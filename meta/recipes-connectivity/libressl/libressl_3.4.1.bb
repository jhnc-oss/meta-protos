SUMMARY = "TLS/crypto stack forked from OpenSSL"
DESCRIPTION = "LibreSSL is a version of the TLS/crypto stack forked from OpenSSL, with goals of modernizing the codebase, improving security, and applying best practice development processes."
HOMEPAGE = "http://www.libressl.org/"
BUGTRACKER = "https://github.com/libressl-portable/portable/issues"
SECTION = "libs/network"
CVE_PRODUCT = "Libressl"

LICENSE = "openssl"
LIC_FILES_CHKSUM = "file://COPYING;md5=01f9bb4d275f5eeea905377bef3de622"

SRC_URI = "https://ftp.openbsd.org/pub/OpenBSD/LibreSSL/libressl-${PV}.tar.gz"
SRC_URI[sha256sum] = "107ceae6ca800e81cb563584c16afa36d6c7138fade94a2b3e9da65456f7c61c"

inherit cmake

EXTRA_OECMAKE = "\
    -DBUILD_SHARED_LIBS=ON \
    -DOPENSSLDIR=${sysconfdir}/libressl \
"

BBCLASSEXTEND = "native"

