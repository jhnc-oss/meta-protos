SUMMARY = "boost-compat provides legacy Python2 library package"
DESCRIPTION = "boost-compat is meant to coexist with official boost packages while providing Python2 library support only (shared and static) which is no longer available as yocto switched to Python3 years ago"
HOMEPAGE = "http://www.boost.org/"
LICENSE = "BSL-1.0 & MIT & Python-2.0"

DEPENDS += "bjam-native"
DEPENDS += "bzip2"
DEPENDS += "python"
DEPENDS += "zlib"

LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

BOOST_VER = "${@"_".join(d.getVar("PV").split("."))}"
BOOST_MAJ = "${@"_".join(d.getVar("PV").split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"

SRC_URI = "https://boostorg.jfrog.io/artifactory/main/release/${PV}/source/${BOOST_P}.tar.bz2"
SRC_URI[sha256sum] = "59c9b274bc451cf91a9ba1dd2c7fdcaf5d60b1b3aa83f2c9fa143417cc660722"

SRC_URI += " \
    file://boost-CVE-2012-2677.patch \
    file://boost-math-disable-pch-for-gcc.patch \
    file://0001-Apply-boost-1.62.0-no-forced-flags.patch.patch \
    file://0001-Don-t-set-up-arch-instruction-set-flags-we-do-that-o.patch \
    file://0001-dont-setup-compiler-flags-m32-m64.patch \
    file://0001-revert-cease-dependence-on-range.patch \
    file://0001-added-typedef-executor_type.patch \
"

inherit python-dir
PYTHON_ROOT = "${STAGING_DIR_HOST}/${prefix}"

B = "${WORKDIR}/build"
S = "${WORKDIR}/${BOOST_P}"
do_configure[cleandirs] = "${B}"

BOOST_LIBS = "python"

SQD = '"'
EQD = '\"'
BJAM_CONF = "${SQD}'-DBOOST_PLATFORM_CONFIG=${EQD}boost/config/platform/${TARGET_OS}.hpp${EQD}'${SQD}"

BJAM_TOOLS   = "--ignore-site-config \
		'-sTOOLS=gcc' \
		'-sGCC=${CC} '${BJAM_CONF} \
		'-sGXX=${CXX} '${BJAM_CONF} \
		'-sGCC_INCLUDE_DIRECTORY=${STAGING_INCDIR}' \
		'-sGCC_STDLIB_DIRECTORY=${STAGING_LIBDIR}' \
		'-sBUILD=release <optimization>space <threading>multi <inlining>on <debug-symbols>off' \
		'-sPYTHON_ROOT=${PYTHON_ROOT}' \
		'--layout=system' \
		"

BOOST_PARALLEL_MAKE = "${@oe.utils.parallel_make_argument(d, '-j%d')}"
BJAM_OPTS    = '${BOOST_PARALLEL_MAKE} -d+2 -q \
		${BJAM_TOOLS} \
		-sBOOST_BUILD_USER_CONFIG=${WORKDIR}/user-config.jam \
		--build-dir=${S}/${TARGET_SYS} \
		--disable-icu \
		${BJAM_EXTRA}'

BJAM_OPTS_append_class-native = ' -sNO_BZIP2=1'
BJAM_OPTS_append_x86-x32 = " abi=x32 address-model=64"

do_configure() {
        cd ${S}
	cp -f ${S}/boost/config/platform/linux.hpp ${S}/boost/config/platform/linux-gnueabi.hpp

	rm -f ${WORKDIR}/user-config.jam
	echo 'using gcc : 4.3.1 : ${CXX} : <cflags>"${CFLAGS}" <cxxflags>"${CXXFLAGS}" <linkflags>"${LDFLAGS}" ;' >> ${WORKDIR}/user-config.jam
	echo "using python : ${PYTHON_BASEVERSION} : ${STAGING_DIR_HOST}${bindir}/python2 : ${STAGING_DIR_HOST}${includedir}/${PYTHON_DIR}${PYTHON_ABI} : ${STAGING_DIR_HOST}${libdir}/${PYTHON_DIR} ;" >> ${WORKDIR}/user-config.jam

	CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" ./bootstrap.sh --with-libraries=python --with-bjam=bjam --with-toolset=gcc

	sed -i '/using python/d' ${S}/project-config.jam
}

do_compile() {
	rm -rf ${S}/${TARGET_SYS}
        cd ${S}
	bjam ${BJAM_OPTS} \
		--prefix=${prefix} \
		--exec-prefix=${exec_prefix} \
		--libdir=${libdir} \
		--includedir=${includedir} \
		--debug-configuration
}

do_install() {
        cd ${S}
	bjam ${BJAM_OPTS} \
		--libdir=${D}${libdir} \
		--includedir=${D}${includedir} \
                install
	for lib in ${BOOST_LIBS}; do
		if [ -e ${D}${libdir}/libboost_${lib}.a ]; then
			ln -s libboost_${lib}.a ${D}${libdir}/libboost_${lib}-mt.a
		fi
		if [ -e ${D}${libdir}/libboost_${lib}.so ]; then
			ln -s libboost_${lib}.so ${D}${libdir}/libboost_${lib}-mt.so
		fi
	done

        rm -rf ${D}${includedir}
        rm -rf ${D}${libdir}/cmake
}

PROVIDES += "libboost-python27"

PACKAGES = "${PN} ${PN}-dbg"

INSANE_SKIP_${PN} += "dev-so"
INSANE_SKIP_${PN} += "staticdev"

FILES_${PN} += "${libdir}/libboost_python27*"

