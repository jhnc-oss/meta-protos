DESCRIPTION = "PROTOS core image suitable for development work."

IMAGE_FEATURES += "dev-pkgs"
IMAGE_FEATURES += "tools-sdk"
IMAGE_FEATURES += "x11-base"

TOOLCHAIN_TARGET_TASK_append = " \
    extra-cmake-modules \
"

inherit core-image
