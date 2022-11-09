require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=ce5d5f1fe02bcd1343ced64a06fd4177"
SRC_URI = "https://github.com/cpputest/cpputest/releases/download/v${PV}/cpputest-${PV}.tar.gz"
SRC_URI[sha256sum] = "21c692105db15299b5529af81a11a7ad80397f92c122bd7bf1e4a4b0e85654f7"

inherit cmake

EXTRA_OECMAKE = "\
    -DC++11=ON \
    -DTESTS=OFF \
    -DLONGLONG=ON \
"

FILES_${PN}-dev += "${libdir}/CppUTest/cmake/*"

ALLOW_EMPTY_${PN} = "1"

BBCLASSEXTEND = "native nativesdk"
