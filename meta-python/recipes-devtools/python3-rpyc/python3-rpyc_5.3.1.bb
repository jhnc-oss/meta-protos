require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=439c6f54322baa097f0a398de5eb3d9a"

SRC_URI[sha256sum] = "f2233174879faf18ae266437d5a65511ce46c817cec4edc1344f036758cfbf52"

PYPI_PACKAGE = "rpyc"

inherit pypi setuptools3

do_configure:prepend() {
    cat > ${S}/setup.py <<-EOF
from setuptools import setup
setup()
EOF
}

RDEPENDS:${PN} += "\
    python3-plumbum \
"

BBCLASSEXTEND = "native nativesdk"
