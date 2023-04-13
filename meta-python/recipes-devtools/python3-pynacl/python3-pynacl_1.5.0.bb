require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=8cc789b082b3d97e1ccc5261f8594d3f"

DEPENDS += "\
    libsodium \
    python3-cffi-native \
"

SRC_URI[sha256sum] = "8ac7448f09ab85811607bdd21ec2464495ac8b7c66d146bf545b0f08fb9220ba"

PYPI_PACKAGE = "PyNaCl"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    libsodium \
    python3-cffi \
"

do_compile:prepend() {
    export SODIUM_INSTALL=system
}

do_install:prepend() {
    export SODIUM_INSTALL=system
}

BBCLASSEXTEND = "native nativesdk"
