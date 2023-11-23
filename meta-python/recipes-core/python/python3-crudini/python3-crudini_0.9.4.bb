SUMMARY = "An utility for manipulating ini files"
DESCRIPTION = "CLI utility for ini file manipulation"
AUTHOR = "pixelb"
HOMEPAGE = "https://github.com/pixelb/crudini"
BUGTRACKER = "https://github.com/pixelb/crudini/issues"
SECTION = "development"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

CVE_PRODUCT = ""

DEPENDS += "\
    python3-pip-native \
    python3-setuptools-scm-native \
"

SRC_URI[sha256sum] = "6fd0eb341b6cbd91e1883030ea9f2102c1c95619eb563af7ddabc2161e019f6b"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-iniparse"

BBCLASSEXTEND = "native nativesdk"
