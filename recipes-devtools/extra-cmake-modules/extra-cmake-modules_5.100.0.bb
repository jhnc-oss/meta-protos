require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "b5b63cc5e704182549155649dd6df73580660d5510acbb9c7567db448c80b1cd"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake_qt5

PACKAGES = "${PN}"

FILES_${PN} += "${datadir}/ECM"

BBCLASSEXTEND = "native"

