SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS_${PN} = " \
  cmocka \
  cppcheck \
  cpputest \
  sshpass \
"

