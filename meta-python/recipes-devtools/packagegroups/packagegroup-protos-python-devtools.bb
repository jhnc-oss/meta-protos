SUMMARY = "PROTOS python devtools software package group"

inherit packagegroup

RDEPENDS_${PN} = "\
    python3-paramiko \
    python3-plumbum \
    python3-pynacl \
    python3-rpyc \
    python3-trash-cli \
"
