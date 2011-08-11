#!/bin/sh
adb remount
adb push android-hosts /system/etc/hosts
adb shell input keyevent 82
