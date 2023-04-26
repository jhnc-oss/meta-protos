require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/catchorg/Catch2.git;protocol=https;nobranch=1"
SRCREV = "3f0283de7a9c43200033da996ff9093be3ac84dc"

S = "${WORKDIR}/git"

inherit cmake

do_install_append() {
    rm -rf ${D}${datadir}/Catch2
}

ALLOW_EMPTY_${PN} = "1"

BBCLASSEXTEND = "native nativesdk"

