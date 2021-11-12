require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=36964f044224efeedd694983c34e716f"

DEPENDS += "\
    bzip2 \
    libbsd \
    openssl \
    xz \
    zlib \
    zstd \
"

SRC_URI = "git://github.com/zlib-ng/minizip-ng.git;branch=master;protocol=https"
SRCREV = "99d39015e29703af2612277180ea586805f655ea"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "\
    -DBUILD_SHARED_LIBS=ON \
    -DCMAKE_INSTALL_INCLUDEDIR=${includedir}/${PN}-ng \
"

BBCLASSEXTEND = "native nativesdk"

