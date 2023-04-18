require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=fd0120fc2e9f841c73ac707a30389af5"

SRC_URI[sha256sum] = "6950faca6819acd3219d4ae694a23c7a87ee38d084f70c1724b0c0dbb8b75769"

PYPI_PACKAGE = "paramiko"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-bcrypt \
    python3-cryptography \
    python3-pynacl \
"

BBCLASSEXTEND = "native nativesdk"
