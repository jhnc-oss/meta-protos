require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "https://invent.kde.org/frameworks/${BPN}/-/archive/v${PV}/${BPN}-v${PV}.tar.gz"
SRC_URI[sha256sum] = "1b9fc4d9281e50561ffad71178298e91a41f576d61052fa9330ad414a2f398e3"

S = "${WORKDIR}/${BPN}-v${PV}"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake

PACKAGES = "${PN} ${PN}-dev"

FILES_${PN}-dev += "${datadir}/ECM"

BBCLASSEXTEND = "native"

