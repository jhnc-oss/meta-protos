SUMMARY = "Python crudini"
HOMEPAGE = "https://github.com/pixelb/crudini"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[md5sum] = "d81b2f41b92c838548cbd9552e706324"
SRC_URI[sha256sum] = "6fd0eb341b6cbd91e1883030ea9f2102c1c95619eb563af7ddabc2161e019f6b"

DEPENDS += "python3-pip-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-iniparse"

BBCLASSEXTEND = "native nativesdk"
