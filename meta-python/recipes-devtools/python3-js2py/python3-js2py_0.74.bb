require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=faa744092d3fb3314632e815e7c3a560"

SRC_URI[sha256sum] = "39f3a6aa8469180efba3c8677271df27c31332fd1b471df1af2af58b87b8972f"

PYPI_PACKAGE = "Js2Py"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

