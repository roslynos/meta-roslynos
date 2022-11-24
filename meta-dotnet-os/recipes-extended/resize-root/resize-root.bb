DESCRIPTION = "Resize root filesystem to fit available disk space"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://resize-root.service \
	file://resize-root \
"

RDEPENDS:${PN} += "\
	e2fsprogs-resize2fs \
	gptfdisk \
	parted \
	util-linux \
	udev \
"

FILES:${PN} += "\
    ${systemd_system_unitdir} \
"
inherit features_check systemd

SYSTEMD_SERVICE:${PN} = "resize-root.service"

CONFLICT_DISTRO_FEATURES = "rauc"
REQUIRED_DISTRO_FEATURES = "systemd"

do_install() {

	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/resize-root.service ${D}${systemd_system_unitdir}
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/resize-root ${D}${sbindir}

}