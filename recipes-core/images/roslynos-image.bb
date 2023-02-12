SUMMARY = "A minimal console-only runtime image for Raspberry Pi devices"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Core boot image configuration
inherit core-image

# Setup default user and passwords
inherit roslynos-users

# Specifies the list of locales to install into the image
LINGUAS_EN_GB = "en-gb en-gb.iso-8859-1"
LINGUAS_EN_US = "en-us en-us.iso-8859-1"
IMAGE_LINGUAS = "${LINGUAS_EN_GB} ${LINGUAS_EN_US}"

# Do a quiet boot with limited console messages
APPEND += "rootfstype=ext4 quiet"
AUTO_SYSLINUXMENU = "0"
SYSLINUX_PROMPT ?= "0"
SYSLINUX_TIMEOUT ?= "0"

# Adds 4GB extra free space to the root filesystem
IMAGE_ROOTFS_EXTRA_SPACE = "4194304"

# Additional application configuration
CORE_IMAGE_EXTRA_INSTALL += "\
    watchdog \
    udev-rules-gpio \
    udev-rules-i2c \
    udev-rules-spi \
    packagegroup-roslynos-base \
"

PACKAGE_EXCLUDE += "perl"

# perform some changes to the rootfs
rootfs_postprocess() {

    # image timastamp
    date "+%m%d%H%M%Y" > ${IMAGE_ROOTFS}/etc/timestamp

    # board type
    echo 'export PATH=$PATH:/usr/local/sbin:/usr/sbin:/sbin' > ${IMAGE_ROOTFS}/etc/profile.d/board.sh
    echo 'export BOARD='${MACHINE} >> ${IMAGE_ROOTFS}/etc/profile.d/board.sh
    
    # if ${bb.utils.contains('IMAGE_INSTALL', 'nano', True, False, d)};  then
    #     sed -i -e 's#^EDITOR[[:space:]]*=.*#EDITOR=/usr/bin/nano#' ${IMAGE_ROOTFS}/etc/profile
    # fi

    # aliases
	# touch ${IMAGE_ROOTFS}/etc/profile
	# echo alias 'l="ls -l"' >> ${IMAGE_ROOTFS}/etc/profile
	# echo alias 'll="ls -lag"' >> ${IMAGE_ROOTFS}/etc/profile
    # echo alias 'ipkg="opkg"' >> ${IMAGE_ROOTFS}/etc/profile
    # echo alias 'md=mkdir' >> ${IMAGE_ROOTFS}/etc/profile
    # echo alias 'rd=rmdir' >> ${IMAGE_ROOTFS}/etc/profile  
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_postprocess;"
