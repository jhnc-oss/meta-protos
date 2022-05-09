require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "\
    https://people.redhat.com/sgrubb/audit/audit-${PV}.tar.gz \
    file://Fixed-swig-host-contamination-issue.patch \
"

SRC_URI[sha256sum] = "b5f4d9b9ad69381ee18f33d3d918326aa52861509c901143f8a8c4ed5caa8913"

inherit autotools

EXTRA_OECONF += "\
    --prefix=/usr \
    --with-libcap-ng=no \
    --disable-zos-remote \
"

do_install_append() {
    install -d ${D}${docdir}/${PN}
    install -m 0644 ${S}/COPYING ${D}/${docdir}/${PN}/LICENSE
}

# avoid -doc package but ship manpages and license file in main package
PACKAGES = "${PN} ${PN}-dbg ${PN}-dev ${PN}-src"

FILES_${PN} += "${docdir}"
FILES_${PN} += "${mandir}"

BBCLASSEXTEND = "native nativesdk"
