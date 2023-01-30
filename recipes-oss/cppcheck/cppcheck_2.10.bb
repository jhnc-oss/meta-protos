require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS += "libpcre"

SRC_URI = "git://github.com/danmar/cppcheck.git;protocol=https;nobranch=1"
SRCREV = "74221fbc8dc9c5c64b22b6bd56e790724e41e0aa"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_GUI=OFF \
    -DUSE_MATCHCOMPILER=ON \
    -DHAVE_RULES=ON \
    -DBUILD_TESTS=OFF \
"

FILES_${PN} += "${datadir}/Cppcheck/"

BBCLASSEXTEND = "native nativesdk"

