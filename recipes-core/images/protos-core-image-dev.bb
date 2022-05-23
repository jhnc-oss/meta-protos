DESCRIPTION = "PROTOS core image suitable for development work."

IMAGE_FEATURES += "dev-pkgs"
IMAGE_FEATURES += "tools-sdk"
IMAGE_FEATURES += "x11-base"

inherit core-image
