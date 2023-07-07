require ${PN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=f36e954c2e2d280ef1b4927c29f43195"

SRC_URI = "\
    git://github.com/FreeSpacenav/libspnav.git;protocol=https;branch=master \
    file://configure_libdir.patch \
"
SRCREV = "1716ccf15fa59a3acaeb9805262fc23613fd6a40"

S = "${WORKDIR}/git"

inherit autotools-brokensep

EXTRA_OECONF += "\
    --disable-x11 \
    --libdir=${baselib} \
"

do_install:append() {
    install -d ${D}${docdir}/${PN}
    install -m 0644 ${S}/LICENSE ${D}${docdir}/${PN}
}

BBCLASSEXTEND = "native nativesdk"
