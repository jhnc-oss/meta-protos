SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS_${PN} = "\
    audit \
    cmocka \
    cppcheck \
    cpputest \
    debugpy \
    minizip \
    nlohmann-json \
    python3-uinput \
    sshpass \
    xclip \
"
