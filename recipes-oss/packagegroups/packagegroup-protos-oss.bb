SUMMARY = "PROTOS open source software package group"

inherit packagegroup

RDEPENDS_${PN} = " \
  cppcheck \
  cmocka \
  cpputest \
  sshpass \
"

