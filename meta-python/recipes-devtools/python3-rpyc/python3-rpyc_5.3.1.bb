require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=439c6f54322baa097f0a398de5eb3d9a"

SRC_URI:append = " file://0001-fix_pyprojecttoml_license.patch"
SRC_URI[sha256sum] = "f2233174879faf18ae266437d5a65511ce46c817cec4edc1344f036758cfbf52"

PYPI_PACKAGE = "rpyc"

inherit pypi python_flit_core

RDEPENDS:${PN} += "\
    python3-plumbum \
"

BBCLASSEXTEND = "native nativesdk"
