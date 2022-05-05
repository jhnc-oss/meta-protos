SUMMARY = "open-source formatting library for C++"
DESCRIPTION = "{fmt} is an open-source formatting library for C++. It can be used as a safe and fast alternative to (s)printf and iostreams."
AUTHOR = "Victor Zverovich"
HOMEPAGE = "https://fmt.dev"
BUGTRACKER = "https://github.com/fmtlib/fmt/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=af88d758f75f3c5c48a967501f24384b"

BRANCH = "8.1.0-jh"

SRC_URI = "git://github.com/jhnc-oss/fmt;branch=${BRANCH}"
SRCREV = "1dcbdf896a8e1672cd9f189ffe3e2e0290ad0aa0"

S = "${WORKDIR}/git"

inherit cmake
inherit ptest

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

BBCLASSEXTEND = "native"

