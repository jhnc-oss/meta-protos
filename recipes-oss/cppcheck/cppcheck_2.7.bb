require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS += "libpcre"

SRC_URI = "git://github.com/danmar/cppcheck.git;protocol=https;nobranch=1"
SRCREV = "6ba6567ad897d56741159f8af90fc354ae050e61"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_GUI=OFF \
    -DUSE_MATCHCOMPILER=ON \
    -DHAVE_RULES=ON \
    -DBUILD_TESTS=OFF \
"

FILES:${PN} += "${datadir}/Cppcheck/"

BBCLASSEXTEND = "native nativesdk"

