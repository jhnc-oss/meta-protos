DESCRIPTION = "PROTOS core image suitable for development work."

IMAGE_FEATURES += "dev-pkgs"
IMAGE_FEATURES += "tools-sdk"
IMAGE_FEATURES += "x11-base"

TOOLCHAIN_TARGET_TASK_append = " \
    extra-cmake-modules \
"

GCC_VERSION = "gcc93"

TOOLCHAIN_OUTPUTNAME ?= "${DISTRO}-${SDKMACHINE}-toolchain-${GCC_VERSION}-${MACHINE}-${DISTRO_VERSION}"
TOOLCHAINEXT_OUTPUTNAME ?= "${DISTRO}-${SDKMACHINE}-toolchain-ext-${GCC_VERSION}-${MACHINE}-${DISTRO_VERSION}"

inherit core-image
