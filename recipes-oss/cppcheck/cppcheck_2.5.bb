require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS += "libpcre"
SRC_URI = "${GITHUB_MIRROR}/danmar/cppcheck/archive/refs/tags/${PV}.tar.gz"
SRC_URI[sha256sum] = "dc27154d799935c96903dcc46653c526c6f4148a6912b77d3a50cb35dabd82e1"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_GUI=OFF \
    -DUSE_MATCHCOMPILER=ON \
    -DHAVE_RULES=ON \
    -DBUILD_TESTS=OFF"

FILES_${PN} += "${datadir}/Cppcheck/"

BBCLASSEXTEND = "native nativesdk"
