SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS_${PN} = "\
    audit \
    cmocka \
    cppcheck \
    cpputest \
    debugpy \
    minizip \
    sshpass \
    xclip \
"
