require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=f638c141bfa8dc89f890a3a4ee2cb888"

SRC_URI[sha256sum] = "88a40fc69247d0cd585e21ca169b3820f46c484535102e16455d2202727bb37b"

PYPI_PACKAGE = "plumbum"

inherit pypi setuptools3

do_configure:prepend() {
    cat > ${S}/setup.py <<-EOF
from setuptools import setup
setup()
EOF
}

BBCLASSEXTEND = "native nativesdk"
