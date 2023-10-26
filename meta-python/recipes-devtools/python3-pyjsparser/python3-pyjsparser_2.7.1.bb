require ${PN}.inc

# The project doesn't ship the license
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=953430a448a7e6837e6d8984fce682d1"

SRC_URI:append = " file://LICENSE"
SRC_URI[sha256sum] = "be60da6b778cc5a5296a69d8e7d614f1f870faf94e1b1b6ac591f2ad5d729579"

PYPI_PACKAGE = "pyjsparser"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
