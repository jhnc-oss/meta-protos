require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "b25f3e3033ef93ba2ab7d188af8ebb95b5f535b29f2e7e99979b98a5aeb3696e"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake

PACKAGES = "${PN} ${PN}-dev"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native"

