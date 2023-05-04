SUMMARY = "A debugger for Python 3"
DESCRIPTION = "An implementation of the Debug Adapter Protocol for Python 3"
AUTHOR = "Microsoft Corporation"
HOMEPAGE = "https://github.com/microsoft/debugpy/"
BUGTRACKER = "https://github.com/microsoft/debugpy/issues"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789"

CVE_PRODUCT = ""

SRC_URI[sha256sum] = "7b79c40852991f7b6c3ea65845ed0f5f6b731c37f4f9ad9c61e2ab4bd48a9275"

PYPI_PACKAGE = "debugpy"
PYPI_PACKAGE_EXT = "zip"

def get_so_target(d):
    if d.getVar('MACHINE_ARCH') == 'genericx86':
        return 'attach_linux_x86'
    return 'attach_linux_amd64'

do_compile_append() {
    find ${WORKDIR} -name attach_linux\*.so -exec rm -rf {} \;

    cd ${WORKDIR}/${PN}-${PV}/src/${PN}/_vendored/pydevd/pydevd_attach_to_process/linux_and_mac
    ${BUILD_CXX} -shared -o ${@get_so_target(d)}.so -fPIC -nostartfiles attach.cpp

    mv ${@get_so_target(d)}.so ../${@get_so_target(d)}.so
}

do_install_append() {
    chmod -R 0755 ${D}${libdir}
}

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
