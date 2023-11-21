SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS:${PN} = "\
    audit \
    cmocka \
    cppcheck \
    cpputest \
    debugpy \
    gammaray \
    libdmtx \
    libspnav \
    minizip \
    nlohmann-json \
    nlopt \
    xclip \
"
