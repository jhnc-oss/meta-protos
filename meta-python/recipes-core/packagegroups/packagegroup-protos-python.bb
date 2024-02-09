SUMMARY = "PROTOS python software package group"

inherit packagegroup

RDEPENDS:${PN} = "\
    python3-crudini \
    python3-exceptiongroup \
    python3-uinput \
"
