#!/bin/bash

# Abort script if any command returns error
set -e

# Source build environment
BUILD_DIR="build"
source ./poky/oe-init-build-env $BUILD_DIR

# Build
MACHINE=raspberrypi3-64 bitbake dotnet-image-minimal
MACHINE=raspberrypi3-64 bitbake dotnet-image-full
# MACHINE=raspberrypi4-64 bitbake dotnet-image-minimal --dry-run
# MACHINE=raspberrypi4-64 bitbake dotnet-image-full --dry-run
# MACHINE=reterminal-64 bitbake dotnet-image-minimal --dry-run
# MACHINE=reterminal-64 bitbake dotnet-image-full --dry-run

# Create the package index
# bitbake package-index