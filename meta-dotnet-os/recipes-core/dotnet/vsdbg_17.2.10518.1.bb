DESCRIPTION = ".NET Core Debugger (v17.2.10518.1) - Linux x64 Binaries"
HOMEPAGE = "https://learn.microsoft.com/en-us/dotnet/iot/debugging?tabs=self-contained&pivots=vscode"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "80cde072ac882eb0882bfb9a6bb511ceaa05c022be97715ebd2f9eafaad29182"
SRC_URI = "https://vsdebugger.azureedge.net/vsdbg-17-2-10518-1/vsdbg-linux-arm64.tar.gz;unpack=0"

INSANE_SKIP:${PN} += "libdir"

RDEPENDS:${PN} = "\
    zlib \
"

FILES:${PN} += "\
    ${datadir}/vsdbg \
"

# do_configure[noexec] = "1"
# do_compile[noexec] = "1"

do_install() {
    
    install -d ${D}${datadir}/vsdbg
    tar -xpvzf ${WORKDIR}/vsdbg-linux-arm64.tar.gz -C ${D}${datadir}/vsdbg
    chmod +x ${D}${datadir}/vsdbg/vsdbg

    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/vsdbg/vsdbg ${D}${bindir}/vsdbg

}