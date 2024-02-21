SUMMARY = "PROTOS open source software package group"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    audit \
    cmocka \
    cppcheck \
    cpputest \
    debugpy \
    libdmtx \
    libspnav \
    minizip \
    nlohmann-json \
    nlopt \
    xclip \
"
