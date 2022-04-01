SUMMARY = "xclip is a command line interface to the X11 clipboard."
DESCRIPTION = "xclip is a command line interface to the X11 clipboard. It can also be used for copying files, as an alternative to sftp/scp, thus avoiding password prompts when X11 forwarding has already been setup."
AUTHOR = "Peter Astrand <cendio.se>"
HOMEPAGE = "https://github.com/astrand/xclip"
BUGTRACKER = "https://github.com/astrand/xclip/issues"
LICENSE = "GPLv2"

CVE_PRODUCT = ""

DEPENDS += "libxmu"
DEPENDS += "virtual/libx11 "

SRC_URI = "${SOURCEFORGE_MIRROR}/xclip/${BP}.tar.gz"
SRC_URI[md5sum] = "f7e19d3e976fecdc1ea36cd39e39900d"
SRC_URI[sha256sum] = "b7c7fad059ba446df5692d175c2a1d3816e542549661224806db369a0d716c45"

inherit autotools

