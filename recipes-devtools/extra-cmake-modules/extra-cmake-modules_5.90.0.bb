require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "99821e2479e2ef35440b6600801c1057dfaded18adf84904ecf0adc0dc9f34f2"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake

PACKAGES = "${PN} ${PN}-dev"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native"

