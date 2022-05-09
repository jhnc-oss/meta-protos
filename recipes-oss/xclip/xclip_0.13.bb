require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS += "\
    libxmu \
    virtual/libx11 \
"

SRC_URI = "git://github.com/astrand/xclip.git;protocol=https;nobranch=1"
SRCREV = "9aa7090c3b8b437c6489edca32ae43d82e0c1281"

S = "${WORKDIR}/git"

inherit autotools-brokensep

BBCLASSEXTEND = "native nativesdk"
