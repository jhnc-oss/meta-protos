require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=d5caa317463c433575efff1d2fe206d7"

SRC_URI[sha256sum] = "91f5c769735f051a4290d52edd0858999b57e5876e9f85937691bd4c9fa3ed68"

inherit pypi python_flit_core

PYPI_PACKAGE = "exceptiongroup"

BBCLASSEXTEND = "native nativesdk"

