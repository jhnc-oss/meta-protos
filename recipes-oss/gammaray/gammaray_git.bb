require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=15cc986c797a8f6b72bf0334bc4fd6e3"

DEPENDS += "\
    qtdeclarative \
"

RDEPENDS_${PN} = "qtconnectivity qtlocation qtscript qtsvg qttools"

SRC_URI = "git://github.com/KDAB/GammaRay;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit cmake_qt5

EXTRA_OECMAKE += "\
    -DGAMMARAY_BUILD_UI=ON \
"

FILES_${PN} += "\
    ${datadir}/* \
"

FILES_${PN}-dev += "\
    ${libdir}/cmake/* \
    ${prefix}/mkspecs/modules/* \
"

FILES_${PN}-dbg += "\
    ${libdir}/.debug/* \
    ${libdir}/gammaray/*/*/.debug \
    ${libdir}/gammaray/*/*/styles/.debug \
"
