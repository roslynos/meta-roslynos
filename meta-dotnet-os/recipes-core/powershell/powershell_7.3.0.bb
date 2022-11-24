DESCRIPTION = ".NET Core Debugger (v17.2.10518.1) - Linux x64 Binaries"
HOMEPAGE = "https://learn.microsoft.com/en-us/dotnet/iot/debugging?tabs=self-contained&pivots=vscode"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "dc84e26df576ef8cc353850eeb5f6659f322ff999913442f472b158f943d109f"
SRC_URI = "https://github.com/PowerShell/PowerShell/releases/download/v7.3.0/powershell-7.3.0-linux-arm64.tar.gz;unpack=0"

INSANE_SKIP:${PN} += "libdir"

DEPENDS = "patchelf-native"

RDEPENDS:${PN} = "\
    zlib \
"

FILES:${PN} += "\
    ${datadir}/powershell \
"

# do_configure[noexec] = "1"
# do_compile[noexec] = "1"

do_install() {
    
    install -d ${D}${datadir}/powershell
    tar --no-same-owner -xpvzf ${WORKDIR}/powershell-${PV}-linux-arm64.tar.gz -C ${D}${datadir}/powershell
    chmod +x ${D}${datadir}/powershell/pwsh

    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/powershell/pwsh ${D}${bindir}/pwsh

    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/powershell/libcoreclrtraceptprovider.so

}