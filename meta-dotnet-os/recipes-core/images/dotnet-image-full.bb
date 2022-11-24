SUMMARY = "A minimal console-only developer image for the Raspberry Pi devices"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Core boot image configuration
include recipes-core/images/core-image-minimal.bb

# Setup default user and passwords
inherit deviceos-users

# Additional application configuration
CORE_IMAGE_EXTRA_INSTALL += "\
    roslynos-core-packagegroup \
    roslynos-base-packagegroup \
    roslynos-debug-packagegroup \
    roslynos-dotnet-sdk-packagegroup \
"

# Do not disable root account
DISABLE_ROOT = "0"

# Enable SSH-ing into target as root 
EXTRA_IMAGE_FEATURES += "debug-tweaks allow-root-login"