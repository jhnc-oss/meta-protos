SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS_${PN} = "\
    audit \
    cmocka \
    cppcheck \
    cpputest \
    debugpy \
    libdmtx \
    minizip \
    nlohmann-json \
    sshpass \
    xclip \
"
