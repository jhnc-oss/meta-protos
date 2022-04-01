require ${PN}.inc

LIC_FILES_CHKSUM = "\
    file://LICENCE.txt;md5=567351b9adbecfcb38180eb4204e10b4 \
    file://client/LICENCE.txt;md5=567351b9adbecfcb38180eb4204e10b4 \
    file://server/LICENCE.txt;md5=567351b9adbecfcb38180eb4204e10b4 \
"

DEPENDS += "\
    qtbase \
    qtdeclarative \
    qtquickcontrols2 \
"

SRC_URI = "git://github.com/parkouss/funq.git;protocol=https;branch=master \
           file://0001-hack-to-allow-library-packaging.patch \
"

SRCREV = "8fa127fd0fb3b72a0fde09f533e5b1d5322fc662"

S = "${WORKDIR}/git"

inherit qmake5
inherit qmake5_paths

QMAKE_PROFILES = "${S}/server/libFunq/libFunq.pro"

PACKAGES = "${PN}-dbg ${PN}"
INSANE_SKIP_${PN} += "dev-so"

FILES_${PN} += "${libdir}"

BBCLASSEXTEND = "native"

