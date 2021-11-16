require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "779e90d0151ec0759450176e7a5870a37b8f849651f9e6371d4d86bc6ce912bb"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake

PACKAGES = "${PN} ${PN}-dev"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native"

