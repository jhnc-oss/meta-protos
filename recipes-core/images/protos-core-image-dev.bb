DESCRIPTION = "PROTOS core image suitable for development work."

EXTRA_IMAGE_FEATURES += "dev-pkgs"
EXTRA_IMAGE_FEATURES += "staticdev-pkgs"
EXTRA_IMAGE_FEATURES += "tools-sdk"
EXTRA_IMAGE_FEATURES += "x11-base"

TOOLCHAIN_TARGET_TASK_append = "\
    fontconfig \
    libxft \
"

TOOLCHAIN_HOST_TASK_append = "\
    nativesdk-fontconfig \
    nativesdk-libxft \
    nativesdk-wayland \
    nativesdk-wayland-dev \
"

IMAGE_INSTALL_append = "\
    weston \
    wayland \
    wayland-protocols \
"

GCC_VERSION = "gcc93"

TOOLCHAIN_OUTPUTNAME ?= "${DISTRO}-${SDKMACHINE}-toolchain-${GCC_VERSION}-${MACHINE}-${DISTRO_VERSION}"
TOOLCHAINEXT_OUTPUTNAME ?= "${DISTRO}-${SDKMACHINE}-toolchain-ext-${GCC_VERSION}-${MACHINE}-${DISTRO_VERSION}"

inherit core-image
