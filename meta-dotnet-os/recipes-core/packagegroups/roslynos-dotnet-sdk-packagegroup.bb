DESCRIPTION = "Dotnet SDK application packagegroup"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    vsdbg \
    powershell \
    dotnet-sdk"