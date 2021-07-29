require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=ce5d5f1fe02bcd1343ced64a06fd4177"
SRC_URI = "${GITHUB_MIRROR}/cpputest/cpputest/releases/download/v${PV}/cpputest-${PV}.tar.gz"
SRC_URI[sha256sum] = "0b66d20661f232d2a6af124c4455c8ccc9a4ce72d29f6ad4877eb385faaf5108"

inherit cmake

EXTRA_OECMAKE = "\
    -DC++11=ON \
    -DTESTS=OFF \
    -DLONGLONG=ON"

# Build as single package
PACKAGES = "${PN}-dbg ${PN}"
INSANE_SKIP_${PN} += "staticdev"

FILES_${PN} += "${prefix}/include"
FILES_${PN} += "${prefix}/lib"

BBCLASSEXTEND = "native nativesdk"
