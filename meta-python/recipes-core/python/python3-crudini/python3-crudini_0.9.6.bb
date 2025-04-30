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

SRC_URI[sha256sum] = "c2af311a0833857a1449d821a312edc6109f0c2d6d81d76c2d954a76b05e6b14"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-iniparse"

BBCLASSEXTEND = "native nativesdk"
