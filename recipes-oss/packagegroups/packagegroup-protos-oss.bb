SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS_${PN} = "\
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
    sshpass \
    xclip \
"
