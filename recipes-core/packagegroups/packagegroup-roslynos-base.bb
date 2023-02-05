DESCRIPTION = "Base application packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# TODO: Apply only modules and firmware required for device type

# CONNECTIVITY_FIRMWARES:append = " \
#     linux-firmware-rpidistro-bcm43430 \
#     linux-firmware-rpidistro-bcm43455 \
#     linux-firmware-sd8887 \
#     bluez-firmware-rpidistro-bcm43430a1-hcd \
#     bluez-firmware-rpidistro-bcm4345c0-hcd \
# "

# CONNECTIVITY_FIRMWARES:append:raspberrypi400-64 = " \
#     linux-firmware-rpidistro-bcm43456 \
#     bluez-firmware-rpidistro-bcm4345c5-hcd \
# "

# CONNECTIVITY_FIRMWARES:remove:raspberrypi4-64 = " \
#     linux-firmware-rpidistro-bcm43436 \
#     linux-firmware-rpidistro-bcm43436s \
# "

# CONNECTIVITY_FIRMWARES:append:raspberrypi0-2w-64 = " \
#     linux-firmware-rpidistro-bcm43436 \
#     linux-firmware-rpidistro-bcm43436s \
#     bluez-firmware-rpidistro-bcm43430b0-hcd \
# "

# CONNECTIVITY_FIRMWARES:remove:raspberrypi0-2w-64 = " \
#     linux-firmware-rpidistro-bcm43430 \
#     linux-firmware-rpidistro-bcm43455 \
#     bluez-firmware-rpidistro-bcm43430a1-hcd \
#     bluez-firmware-rpidistro-bcm4345c0-hcd \
# "

KERNEL_MODULES:append = " \
	kernel-modules \
"

LINUX_FIRMWARE:append = " \
	linux-firmware \
"

PROVIDES = "${PACKAGES}"
PACKAGES = " \
	packagegroup-roslynos-base \
	packagegroup-roslynos-core \
	packagegroup-base-ap \ 
	packagegroup-base-dotnet \
	packagegroup-base-vscode \
	packagegroup-base-gpio \
	packagegroup-base-can \
"

# ${CONNECTIVITY_FIRMWARES}
RDEPENDS:${PN} = " \
	${KERNEL_MODULES} \
	${LINUX_FIRMWARE} \
	packagegroup-roslynos-core \ 
	packagegroup-base-ap \
	packagegroup-base-dotnet \
	packagegroup-base-vscode \
	packagegroup-base-gpio \
	packagegroup-base-can \
"

RDEPENDS:packagegroup-roslynos-core = "\
	iptables \
	htop \
	nano \
	sudo"

RDEPENDS:packagegroup-base-ap = "\
	iw \
	hostapd \
	dnsmasq"

RDEPENDS:packagegroup-base-dotnet = "\
	vsdbg \
    aspnet-runtime"

RDEPENDS:packagegroup-base-vscode = "\
	ldd \
	glibc \
	libstdc++ \
	procps"

RDEPENDS:packagegroup-base-gpio = "\
	libgpiod \
	libgpiod-dev \
	libgpiod-tools"

RDEPENDS:packagegroup-base-can = "\
	can-utils \
	libsocketcan"