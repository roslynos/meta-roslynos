# Build Repository

## Build

```
$ git clone https://github.com/bytewizer/reterminal-image.git
$ cd reterminal-image
$ ./repo-mgr.sh install
$ ./repo-mgr.sh init
$ ./run-build.sh
```

### Supported machines

- raspberrypi3-64
- raspberrypi4-64

## WIFI Setup

```bash
mkdir -p /etc/wpa_supplicant
cp /etc/wpa_supplicant.conf /etc/wpa_supplicant/wpa_supplicant-wlan0.conf
systemctl start wpa_supplicant@wlan0 
systemctl enable wpa_supplicant@wlan0
```


### Identify Wifi Access Points
```bash
$ nmcli dev wifi list
```

### Connect to Wifi
```bash
$ sudo nmcli dev wifi connect network-ssid password "network-password"
```

### Create an Access Point Hotspot
```bash
$ nmcli dev wifi hotspot
```
To show the Wi-Fi name and password
```bash
$ nmcli dev wifi show-password
```

```bash
nmcli con add type wifi ifname wlan0 con-name Hostspot autoconnect yes ssid Hostspot
nmcli con modify Hostspot 802-11-wireless.mode ap 802-11-wireless.band bg ipv4.method shared
nmcli con modify Hostspot wifi-sec.key-mgmt wpa-psk
nmcli con modify Hostspot wifi-sec.psk "veryveryhardpassword1234"
nmcli con up Hostspot

sudo cat /etc/NetworkManager/system-connections/Hotspot.nmconnection
```

