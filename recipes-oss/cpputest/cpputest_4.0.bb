require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=ce5d5f1fe02bcd1343ced64a06fd4177"
SRC_URI = "${GITHUB_MIRROR}/cpputest/cpputest/releases/download/v${PV}/cpputest-${PV}.tar.gz"
SRC_URI[sha256sum] = "21c692105db15299b5529af81a11a7ad80397f92c122bd7bf1e4a4b0e85654f7"

inherit cmake

EXTRA_OECMAKE = "\
    -DC++11=ON \
    -DTESTS=OFF \
    -DLONGLONG=ON \
"

# Build as single package
PACKAGES = "${PN}-dbg ${PN}"
INSANE_SKIP_${PN} += "staticdev"

FILES_${PN} += "${prefix}/include"
FILES_${PN} += "${prefix}/lib"

BBCLASSEXTEND = "native nativesdk"

