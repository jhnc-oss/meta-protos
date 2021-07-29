require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"
SRC_URI = "${GITLAB_MIRROR}/cmocka/cmocka/-/archive/cmocka-${PV}/cmocka-cmocka-${PV}.tar.gz"
SRC_URI[sha256sum] = "51eba78277d51f0299617bedffc388b2b4ea478f5cc9876cc2544dae79638cb0"

inherit cmake

EXTRA_OECMAKE = "-DBUILD_TESTING=OFF -DWITH_EXAMPLES=OFF"

# Build as single package
PACKAGES = "${PN}-dbg ${PN}"
INSANE_SKIP_${PN} += "dev-so"

FILES_${PN} += "${prefix}/include"
FILES_${PN} += "${prefix}/lib"

BBCLASSEXTEND = "native nativesdk"
