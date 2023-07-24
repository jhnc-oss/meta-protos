require ${PN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI[sha256sum] = "99805170df2af7b291314d5b9d86b2cfd598e635a5a23d32debfede880021044"

PYPI_PACKAGE = "trash-cli"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
