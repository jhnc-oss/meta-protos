require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS += "libpcre"

SRC_URI = "git://github.com/danmar/cppcheck.git;protocol=https;nobranch=1"
SRCREV = "f2f1fb0bca5f23aac8f02fb9c09e4529a7935749"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_GUI=OFF \
    -DBUILD_TESTS=OFF \
    -DDISABLE_DMAKE=ON \
    -DHAVE_RULES=ON \
    -DUSE_MATCHCOMPILER=ON \
"

FILES:${PN} += "${datadir}/Cppcheck/"

BBCLASSEXTEND = "native nativesdk"

