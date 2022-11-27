# RoslynOS Devices

Optimising .NET Core images running on bare metal IoT devices.  Boot timeing for minminal is ~12 seconds.

## Supported Single Board Computers
- Raspberrypi 3
- Raspberrypi 4
- Seeed ReTerminal

### Minimial Image Software
- ASP.NET Core Runtime 7.0.0
- .NET Core Debugger 17.2.10518.1

### Full Image Software
- .NET SDK 7.0.100
- .NET Core Debugger 17.2.10518.1
- Debug Tools

## Install RoslynOS Boot Image
NOTE: THESE IMAGES ARE BETA AND AT THIS POINT DO NOT INCLUDED ANY SECURITY HARDENING. USE AT YOUR OWN RISK.

### Write the image to your boot media
1. Attach the boot media (SD card) to your computer

2. Download and start [Balena Etcher](https://www.balena.io/etcher/). (You may need to run it with administrator privileges on Windows).

3. Select “Flash from URL”

4. Get the [URL](https://github.com/roslynos/meta-roslynos/releases) for your device:

Raspberry Pi 3 
```
    https://github.com/roslynos/meta-roslynos/releases/download/v1.3.3/dotnet-image-full-raspberrypi3-64-20221127075700.rootfs.wic.gz
```
```
    https://github.com/roslynos/meta-roslynos/releases/download/v1.3.3/dotnet-image-minimal-raspberrypi3-64-20221127002702.rootfs.wic.gz
```

Raspberry Pi 4
```
    https://github.com/roslynos/meta-roslynos/releases/download/v1.3.3/dotnet-image-full-raspberrypi4-64-20221127143810.rootfs.wic.gz
```
```
    https://github.com/roslynos/meta-roslynos/releases/download/v1.3.3/dotnet-image-minimal-raspberrypi4-64-20221127090658.rootfs.wic.gz
```

5. Select and copy the URL or use the “copy” button that appear when you hover it.

6. Select the SD card you want to use for your RoslynOS device.
7. Click on “Flash!” to start writing the image.

## Start up your RoslynOS device

1. Insert the boot media (SD card) you just created.

2. Attach an Ethernet cable for network.

3. Attach the power cable.

4. Connect to device using 'ssh vs@rainier' with 'dotnet' when prompted for a password. 

## Building RoslynOS from builder scripts
Repository provides a script that can be used to build RoslynOS filesystem images for the various supported devices. Visit [The Yocto Project](https://docs.yoctoproject.org/) For more detailed information on a typical build setup. This will setup the environment, download the repositories, and build all supported images.

Clone the repository and run the scripts:
``` bash
$ git clone https://github.com/roslynos/meta-roslynos.git
$ cd meta-roslynos
$ ./repo-mgr.sh install
$ ./repo-mgr.sh init
$ ./run-build.sh
```

# Give a Star! :star:

If you like or are using this project to start your solution, please give it a star. Thanks!

# Contributions

Contributions to this project are always welcome. Please consider forking this project on GitHub and sending a pull request to get your improvements added to the original project.

# Disclaimer

All source, documentation, instructions and products of this project are provided as-is without warranty. No liability is accepted for any damages, data loss or costs incurred by its use.