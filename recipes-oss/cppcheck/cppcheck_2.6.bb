require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS += "libpcre"

SRC_URI = "git://github.com/danmar/cppcheck.git;protocol=https;nobranch=1"
SRCREV = "d873b8e77189cf6b974fc9d403df8e8500eded7b"

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

