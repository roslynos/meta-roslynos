DESCRIPTION = "Base application packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "\
	roslynos-base-packagegroup \
	roslynos-base-connectivity \
	roslynos-base-gpio \
	roslynos-base-utilities"

RDEPENDS:${PN} = "\
	roslynos-base-connectivity \
	roslynos-base-gpio \
	roslynos-base-utilities"

SUMMARY:roslynos-base-connectivity = "Connectivity Packages"
RDEPENDS:roslynos-base-connectivity = "\
	hostapd \
	dnsmasq \
	openssh \ 
	openssh-sftp-server \
	openssl \
	ufw \
	iptables \
	htop \
	curl"

SUMMARY:roslynos-base-gpio = "Gpio Packages"
RDEPENDS:roslynos-base-gpio = "\
	libgpiod \
	libgpiod-tools \
	i2c-tools"

SUMMARY:roslynos-base-utilities = "General Packages"
RDEPENDS:roslynos-base-utilities = "\
	iw \
	bash \
	nano \
	sudo"