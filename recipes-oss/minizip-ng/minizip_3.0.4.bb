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
SRCREV = "95987e98b4862c055b8cf91d6e7ce5f9153ddc24"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "\
    -DBUILD_SHARED_LIBS=ON \
    -DCMAKE_INSTALL_INCLUDEDIR=${includedir}/${PN}-ng \
"

BBCLASSEXTEND = "native nativesdk"

