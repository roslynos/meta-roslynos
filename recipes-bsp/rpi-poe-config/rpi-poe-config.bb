LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_deploy:append:raspberrypi3() {
    echo "dtoverlay=rpi-poe" >>${DEPLOYDIR}/bootfiles/config.txt
}

do_deploy:append:raspberrypi4() {
    echo "dtoverlay=rpi-poe" >>${DEPLOYDIR}/bootfiles/config.txt
}