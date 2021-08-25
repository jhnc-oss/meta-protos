require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=89c0b58a3e01ce3d8254c9f59e78adfb"

DEPENDS += "\
    libglu \
    libx11 \
    libxi \
    virtual/libgl \
"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PBN}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "d4000e02102acaf259998c870e25214739d1f16f67f99cb35e4f46841399da68"

inherit cmake

BBCLASSEXTEND = "native"

