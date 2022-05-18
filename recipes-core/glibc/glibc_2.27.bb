require glibc.inc
require glibc-version.inc

CVE_CHECK_WHITELIST += "CVE-2020-10029"

DEPENDS += "gperf-native bison-native make-native"

NATIVESDKFIXES ?= ""
NATIVESDKFIXES_class-nativesdk = "\
    file://0001-nativesdk-glibc-Look-for-host-system-ld.so.cache-as-.patch \
    file://0002-nativesdk-glibc-Fix-buffer-overrun-with-a-relocated-.patch \
    file://0003-nativesdk-glibc-Raise-the-size-of-arrays-containing-.patch \
    file://0004-nativesdk-glibc-Allow-64-bit-atomics-for-x86.patch \
    file://relocate-locales.patch \
    file://0031-nativesdk-deprecate-libcrypt.patch \
"

ADDITIONAL_GLIBC_FIXES = "\
    file://group_member_fix_huge_alloc.patch \
    file://glibc-fedora-nscd.patch \
    file://glibc-fedora-linux-tcsetattr.patch \
    file://glibc-fedora-nptl-linklibc.patch \
    file://glibc-fedora-nis-rh188246.patch \
    file://glibc-fedora-manual-dircategory.patch \
    file://glibc-fedora-__libc_multiple_libcs.patch \
    file://glibc-cs-path.patch \
    file://glibc-rh697421.patch \
    file://glibc-rh741105.patch \
    file://glibc-rh819430.patch \
    file://glibc-rh1070416.patch \
    file://glibc-rh1315108.patch \
    file://glibc-rh1452750-allocate_once.patch \
    file://glibc-python3.patch \
    file://glibc-with-nonshared-cflags.patch \
    file://glibc-asflags.patch \
    file://glibc-extra-stackprot-1.patch \
    file://glibc-extra-stackprot-2.patch \
"

SRC_URI =  "\
    ${GLIBC_GIT_URI};branch=${SRCBRANCH};name=glibc \
    file://etc/ld.so.conf \
    file://generate-supported.mk \
    ${NATIVESDKFIXES} \
    ${ADDITIONAL_GLIBC_FIXES} \
    file://0005-fsl-e500-e5500-e6500-603e-fsqrt-implementation.patch \
    file://0006-readlib-Add-OECORE_KNOWN_INTERPRETER_NAMES-to-known-.patch \
    file://0007-ppc-sqrt-Fix-undefined-reference-to-__sqrt_finite.patch \
    file://0008-__ieee754_sqrt-f-are-now-inline-functions-and-call-o.patch \
    file://0009-Quote-from-bug-1443-which-explains-what-the-patch-do.patch \
    file://0010-eglibc-run-libm-err-tab.pl-with-specific-dirs-in-S.patch \
    file://0011-__ieee754_sqrt-f-are-now-inline-functions-and-call-o.patch \
    file://0012-sysdeps-gnu-configure.ac-handle-correctly-libc_cv_ro.patch \
    file://0013-Add-unused-attribute.patch \
    file://0014-yes-within-the-path-sets-wrong-config-variables.patch \
    file://0015-timezone-re-written-tzselect-as-posix-sh.patch \
    file://0016-Remove-bash-dependency-for-nscd-init-script.patch \
    file://0017-eglibc-Cross-building-and-testing-instructions.patch \
    file://0018-eglibc-Help-bootstrap-cross-toolchain.patch \
    file://0019-eglibc-Clear-cache-lines-on-ppc8xx.patch \
    file://0020-eglibc-Resolve-__fpscr_values-on-SH4.patch \
    file://0022-eglibc-Forward-port-cross-locale-generation-support.patch \
    file://0023-Define-DUMMY_LOCALE_T-if-not-defined.patch \
    file://0024-elf-dl-deps.c-Make-_dl_build_local_scope-breadth-fir.patch \
    file://0025-locale-fix-hard-coded-reference-to-gcc-E.patch \
    file://0026-reset-dl_load_write_lock-after-forking.patch \
    file://0027-Acquire-ld.so-lock-before-switching-to-malloc_atfork.patch \
    file://0028-bits-siginfo-consts.h-enum-definition-for-TRAP_HWBKP.patch \
    file://0029-Replace-strncpy-with-memccpy-to-fix-Wstringop-trunca.patch \
    file://0030-plural_c_no_preprocessor_lines.patch \
    file://CVE-2017-18269.patch \
    file://CVE-2018-11236.patch \
    file://CVE-2018-11237.patch \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build-${TARGET_SYS}"

PACKAGES_DYNAMIC = ""

# the -isystem in bitbake.conf screws up glibc do_stage
BUILD_CPPFLAGS = "-I${STAGING_INCDIR_NATIVE}"
TARGET_CPPFLAGS = "-I${STAGING_DIR_TARGET}${includedir}"

GLIBC_BROKEN_LOCALES = ""

# We will skip parsing glibc when target system C library selection is not glibc
# this helps in easing out parsing for non-glibc system libraries
COMPATIBLE_HOST_libc-musl_class-target = "null"

GLIBCPIE ??= ""

EXTRA_OECONF = "\
    --enable-kernel=${OLDEST_KERNEL} \
    --disable-profile \
    --disable-debug --without-gd \
    --enable-clocale=gnu \
    --with-headers=${STAGING_INCDIR} \
    --without-selinux \
    --enable-tunables \
    --enable-bind-now \
    --enable-stackguard-randomization \
    --disable-crypt \
    --disable-werror \
    ${@bb.utils.contains_any('SELECTED_OPTIMIZATION', '-O0 -Og', '--disable-werror', '', d)} \
    ${GLIBCPIE} \
    ${GLIBC_EXTRA_OECONF} \
"

EXTRA_OECONF += "${@get_libc_fpu_setting(bb, d)}"

PACKAGECONFIG ??= "nscd"
PACKAGECONFIG[nscd] = "--enable-nscd,--disable-nscd"

do_patch_append() {
    bb.build.exec_func('do_fix_readlib_c', d)
}

do_fix_readlib_c () {
	sed -i -e 's#OECORE_KNOWN_INTERPRETER_NAMES#${EGLIBC_KNOWN_INTERPRETER_NAMES}#' ${S}/elf/readlib.c
}

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
# don't pass CPPFLAGS into configure, since it upsets the kernel-headers
# version check and doesn't really help with anything
        (cd ${S} && gnu-configize) || die "failure in running gnu-configize"
        find ${S} -name "configure" | xargs touch
        CPPFLAGS="" oe_runconf
}

# LDFLAGS += "-fuse-ld=bfd"
do_compile () {
  unset LDFLAGS
	base_do_compile
	echo "Adjust ldd script"
	if [ -n "${RTLDLIST}" ]
	then
		prevrtld=`cat ${B}/elf/ldd | grep "^RTLDLIST=" | sed 's#^RTLDLIST="\?\([^"]*\)"\?$#\1#'`
		# remove duplicate entries
		newrtld=`echo $(printf '%s\n' ${prevrtld} ${RTLDLIST} | LC_ALL=C sort -u)`
		echo "ldd \"${prevrtld} ${RTLDLIST}\" -> \"${newrtld}\""
		sed -i ${B}/elf/ldd -e "s#^RTLDLIST=.*\$#RTLDLIST=\"${newrtld}\"#"
	fi
}

require glibc-package.inc

BBCLASSEXTEND = "nativesdk"
