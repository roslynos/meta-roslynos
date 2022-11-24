DESCRIPTION = "ASP.NET Core 7.0 Runtime (v7.0.0) which includes .NET Runtime"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/7.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

ASPNET_FETCH_ID = "2d6d851a-4eea-4a7a-9d5e-f1d6cdccda29/366a3dd90251ce11d8c5191ae9633efc"

SRC_URI[sha256sum] = "6e8698b13ddd26d2809f5e53f8a0e5a7c7703ab8f20ba7f08c2ff49002cf5caa"
SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${ASPNET_FETCH_ID}/aspnetcore-runtime-${PV}-linux-arm64.tar.gz;unpack=0"

INSANE_SKIP:${PN} = "already-stripped libdir staticdev"

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
    tar --no-same-owner -xpvzf ${WORKDIR}/aspnetcore-runtime-${PV}-linux-arm64.tar.gz -C ${D}${datadir}/dotnet
    chmod +x ${D}${datadir}/dotnet/dotnet

    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/dotnet/dotnet ${D}${bindir}/dotnet

    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${PV}/libcoreclrtraceptprovider.so

}