SUMMARY = "A debugger for Python 3"
DESCRIPTION = "An implementation of the Debug Adapter Protocol for Python 3"
AUTHOR = "Microsoft Corporation"
HOMEPAGE = "https://github.com/microsoft/debugpy/"
BUGTRACKER = "https://github.com/microsoft/debugpy/issues"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789"

CVE_PRODUCT = ""

SRC_URI[sha256sum] = "12af2c55b419521e33d5fb21bd022df0b5eb267c3e178f1d374a63a2a6bdccd0"

PYPI_PACKAGE = "debugpy"
PYPI_PACKAGE_EXT = "zip"

def get_so_suffix(d):
    arch = d.getVar('MACHINE_ARCH')

    if arch == 'genericx86' or arch == 'mc_x86_32':
        return 'x86'
    if arch == 'genericx86_64' or arch == 'mc_x86_64' or arch == 'wsl_x86_64':
        return 'amd64'
    bb.error("Unsupported architecture")

do_compile:append() {
    cd ${WORKDIR}/${PN}-${PV}/src/${PN}/_vendored/pydevd/pydevd_attach_to_process/linux_and_mac
    ${CXX} ${LDFLAGS} -std=c++11 -shared -fPIC -nostartfiles attach.cpp -o attach_linux_${@get_so_suffix(d)}.so
}

do_install:append() {
    install ${WORKDIR}/${PN}-${PV}/src/debugpy/_vendored/pydevd/pydevd_attach_to_process/linux_and_mac/attach_linux_*.so ${D}${PYTHON_SITEPACKAGES_DIR}/debugpy/_vendored/pydevd/pydevd_attach_to_process/
    chmod -R 0755 ${D}${libdir}
}

inherit pypi setuptools3

RDEPENDS:${PN} += "glibc"

BBCLASSEXTEND = "native nativesdk"

COMPATIBLE_MACHINES="^(genericx86|genericx86-64|mc-x86-32|mc-x86-64|wsl-x86-64)$"
