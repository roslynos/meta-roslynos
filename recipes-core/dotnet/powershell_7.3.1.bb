DESCRIPTION = "Microsoft PowerShell - Linux x64 Binaries"
HOMEPAGE = "https://learn.microsoft.com/en-us/powershell/?view=powershell-7.3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "f0e03a128171e596a2387d86ef659f3a09d3700be900d62bdea3156d005eda68"
SRC_URI = "https://github.com/PowerShell/PowerShell/releases/download/v${PV}/powershell-${PV}-linux-arm64.tar.gz;unpack=0"

COMPATIBLE_HOST ?= "(aarch64).*-linux"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = '1' 

FILES:${PN} += "\
    ${datadir}/powershell \
"

INSANE_SKIP:${PN} = "file-rdeps libdir"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    
    install -d ${D}${datadir}/powershell
    tar --no-same-owner -xpvzf ${WORKDIR}/powershell-${PV}-linux-arm64.tar.gz -C ${D}${datadir}/powershell
    chmod +x ${D}${datadir}/powershell/pwsh

    # Symlinks
    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/powershell/pwsh ${D}${bindir}/pwsh

}