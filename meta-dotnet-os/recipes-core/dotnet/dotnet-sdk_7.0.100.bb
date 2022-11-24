DESCRIPTION = ".NET Core 7.0 SDK (v7.0.0) which includes runtimes"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/7.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DOTNET_FETCH_ID = "47337472-c910-4815-9d9b-80e1a30fcf16/14847f6a51a6a7e53a859d4a17edc311"

SRC_URI[sha256sum] = "ef675d0b2f3012b8ac0c67952c752f8646decf3d68713b17d7bf45dfaf476441"
SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${DOTNET_FETCH_ID}/dotnet-sdk-${PV}-linux-arm64.tar.gz;unpack=0"

DOTNET_RUNTIME = "7.0.0"

INSANE_SKIP:${PN} += "libdir staticdev"

DEPENDS = "patchelf-native"

RDEPENDS:${PN} = "\
    icu \
    libgssapi-krb5 \
    openssl \
    zlib \
"
FILES:${PN} += "\
    ${datadir}/dotnet \
"

# do_configure[noexec] = "1"
# do_compile[noexec] = "1"

do_install() {
    
    install -d ${D}${datadir}/dotnet
    tar --no-same-owner -xpvzf ${WORKDIR}/dotnet-sdk-${PV}-linux-arm64.tar.gz -C ${D}${datadir}/dotnet
    chmod +x ${D}${datadir}/dotnet/dotnet

    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/dotnet/dotnet ${D}${bindir}/dotnet
    
    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${DOTNET_RUNTIME}/libcoreclrtraceptprovider.so
}