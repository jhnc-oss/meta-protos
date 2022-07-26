require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"
SRC_URI = "https://cmocka.org/files/1.1/cmocka-${PV}.tar.xz"
SRC_URI[sha256sum] = "f0ccd8242d55e2fd74b16ba518359151f6f8383ff8aef4976e48393f77bba8b6"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_TESTING=OFF \
    -DWITH_EXAMPLES=OFF \
"

BBCLASSEXTEND = "native nativesdk"

