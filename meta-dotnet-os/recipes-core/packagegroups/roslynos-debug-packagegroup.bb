DESCRIPTION = "Debug application packagegroup"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    nbench-byte \
    binutils \
    blktrace \
    bzip2 \
    gptfdisk \
    hdparm \
    htop \
    iotop \
    mc \
    less \
    procps \
    strace \
    tar \
    usbutils \
    util-linux \
    git \
    wget"