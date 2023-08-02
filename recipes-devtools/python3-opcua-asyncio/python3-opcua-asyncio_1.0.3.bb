require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI[sha256sum] = "581a5f4d32e65959105d907c82cec3c4ab98ef82230a2ca1778ca58f1a3b1d45"

PYPI_PACKAGE = "asyncua"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiofiles \
    python3-aiosqlite \
    python3-cryptography \
    python3-dateutil \
    python3-pytz \
    python3-sortedcontainers \
"

BBCLASSEXTEND = "native nativesdk"
