SUMMARY = "Seeed reterminal device tree overlay"
DESCRIPTION = "Include all the device dtoverlay of reterminal"
HOMEPAGE = "https://github.com/Seeed-Studio/seeed-linux-dtoverlays"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit devicetree

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://reterminal-overlay.dts \
"

COMPATIBLE_MACHINE = "reterminal-64"

RM_WORK_EXCLUDE += "${PN}"