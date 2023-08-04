require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SRC_URI = "${SOURCEFORGE_MIRROR}/sshpass/sshpass-${PV}.tar.gz"
SRC_URI[sha256sum] = "ad1106c203cbb56185ca3bad8c6ccafca3b4064696194da879f81c8d7bdfeeda"

inherit autotools

do_install:append() {
    install -D -m 0644 ${S}/COPYING ${D}/${docdir}/${PN}/LICENSE
}

# avoid empty -dev (no headers in source) and ship manpages and license file
# in main package
PACKAGES = "${PN} ${PN}-dbg {PN}-src"

FILES:${PN} += "${docdir}"
FILES:${PN} += "${mandir}"

RDEPENDS:${PN} += "openssh"

BBCLASSEXTEND = "native nativesdk"

