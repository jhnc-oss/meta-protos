LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "https://memtest.org/download/archives/${PV}/memtest86%2B-${PV}.tar.gz"
SRC_URI += "file://0001-fix-permission-denied-on-file-descriptor-of-bitbake.patch"
SRC_URI[sha256sum] = "7146ffb182c0eb324e216ec5db284ef4bd8296122cf45e1695eabd8320cb1f09"

S = "${WORKDIR}/memtest86+-${PV}"

do_compile () {
	oe_runmake memtest.bin
}

do_install () {
	oe_runmake install
}

