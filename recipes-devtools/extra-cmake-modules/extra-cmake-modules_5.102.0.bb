require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "5c7b49d0bc08eb65a7e46e29c888a7e0d8580a0935200bc6d18a4abc774f6531"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake_qt5

PACKAGES = "${PN}"

FILES:${PN} += "${datadir}/ECM"

BBCLASSEXTEND = "native"

