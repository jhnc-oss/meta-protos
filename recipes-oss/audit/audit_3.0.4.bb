require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "\
    https://people.redhat.com/sgrubb/audit/audit-${PV}.tar.gz \
    file://Fixed-swig-host-contamination-issue.patch \
    file://0001-flush-uid-gid-caches-when-user-group-added-deleted-m.patch \
"

SRC_URI[sha256sum] = "8c5ae825b9d2837742b626fa93b86cb4a84d15530bf05b6cb42be3f304db8cf6"

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

