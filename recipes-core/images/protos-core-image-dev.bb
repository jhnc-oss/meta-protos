DESCRIPTION = "PROTOS core image suitable for development work."

IMAGE_FEATURES += "dev-pkgs"
IMAGE_FEATURES += "tools-sdk"
IMAGE_FEATURES += "x11-base"

TOOLCHAIN_TARGET_TASK_append = "\
    fontconfig \
    libxft \
"

TOOLCHAIN_HOST_TASK_append = "\
    nativesdk-fontconfig \
    nativesdk-libxft \
"

inherit core-image
