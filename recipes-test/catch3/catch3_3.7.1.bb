require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/catchorg/Catch2.git;protocol=https;nobranch=1"
SRCREV = "fa43b77429ba76c462b1898d6cd2f2d7a9416b14"

S = "${WORKDIR}/git"

inherit cmake

do_install:append() {
    rm -rf ${D}${datadir}/Catch2
}

ALLOW_EMPTY:${PN} = "1"

BBCLASSEXTEND = "native nativesdk"

