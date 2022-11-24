DESCRIPTION = "Dotnet runtime application packagegroup"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    vsdbg \
    aspnet-runtime"