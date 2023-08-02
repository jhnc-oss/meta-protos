FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://0001-define-OAEP-properties-for-all-openssl-versions.patch \
    file://0002-remove-some-more-constants-we-dont-need.patch \
    file://0003-openssl3-compatibility.patch \
"
