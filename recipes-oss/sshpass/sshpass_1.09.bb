require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SRC_URI = "${SOURCEFORGE_MIRROR}/sshpass/sshpass-${PV}.tar.gz"
SRC_URI[sha256sum] = "71746e5e057ffe9b00b44ac40453bf47091930cba96bbea8dc48717dedc49fb7"

inherit autotools

do_install:append() {
    install -d ${D}${docdir}/${PN}
    install -m 0644 ${S}/COPYING ${D}/${docdir}/${PN}/LICENSE
}

# avoid empty -dev (no headers in source) and ship manpages and license file
# in main package
PACKAGES = "${PN} ${PN}-dbg {PN}-src"

FILES:${PN} += "${docdir}"
FILES:${PN} += "${mandir}"

RDEPENDS:${PN} += "openssh"

BBCLASSEXTEND = "native nativesdk"

