FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

UBOOT_DELAY ?= "1"

SRC_URI += "${@bb.utils.contains('UBOOT_DELAY', '0', 'file://no-boot-delay.cfg', '', d)}"