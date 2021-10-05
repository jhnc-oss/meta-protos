require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS += "libpcre"
SRC_URI = "${GITHUB_MIRROR}/danmar/cppcheck/archive/refs/tags/${PV}.tar.gz"
SRC_URI[sha256sum] = "99f0c5cf58a0072876c4deb114f3f5f798c933b8e459cddb00a061c8bb4dd765"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_GUI=OFF \
    -DUSE_MATCHCOMPILER=ON \
    -DHAVE_RULES=ON \
    -DBUILD_TESTS=OFF \
"

FILES_${PN} += "${datadir}/Cppcheck/"

BBCLASSEXTEND = "native nativesdk"

