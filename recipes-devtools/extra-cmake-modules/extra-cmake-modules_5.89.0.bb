require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "1236135d5f82c4d1e432d38fa2adb7f4843f0735c734392311a5b296358e726a"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake

PACKAGES = "${PN} ${PN}-dev"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native"

