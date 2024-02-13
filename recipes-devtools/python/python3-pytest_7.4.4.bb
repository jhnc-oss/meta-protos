SUMMARY = "Simple powerful testing with python"
HOMEPAGE = "https://pypi.org/project/pytest/"
DESCRIPTION = "The pytest framework makes it easy to write small tests, yet scales to support complex functional testing for applications and libraries."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bd27e41b6550fe0fc45356d1d81ee37c"

DEPENDS += "python3-setuptools-scm-native"

SRC_URI[sha256sum] = "2cf0005922c6ace4a3e2ec8b4080eb0d9753fdc93107415332f50ce9e7994280"

inherit update-alternatives pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-atomicwrites \
    ${PYTHON_PN}-attrs \
    ${PYTHON_PN}-debugger \
    ${PYTHON_PN}-doctest \
    ${PYTHON_PN}-exceptiongroup \
    ${PYTHON_PN}-importlib-metadata \
    ${PYTHON_PN}-iniconfig \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-more-itertools \
    ${PYTHON_PN}-packaging \
    ${PYTHON_PN}-pathlib2 \
    ${PYTHON_PN}-pluggy \
    ${PYTHON_PN}-py \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-tomli \
    ${PYTHON_PN}-wcwidth \
"

ALTERNATIVE:${PN} += "py.test pytest"

NATIVE_LINK_NAME[pytest] = "${bindir}/pytest"
ALTERNATIVE_TARGET[pytest] = "${bindir}/pytest"

ALTERNATIVE_LINK_NAME[py.test] = "${bindir}/py.test"
ALTERNATIVE_TARGET[py.test] = "${bindir}/py.test"

BBCLASSEXTEND = "native nativesdk"
