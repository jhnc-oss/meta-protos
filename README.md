# meta-protos

[![ci](https://github.com/jhnc-oss/meta-protos/actions/workflows/ci.yml/badge.svg)](https://github.com/jhnc-oss/meta-protos/actions/workflows/ci.yml)
[![License](https://img.shields.io/badge/license-MIT-yellow.svg)](LICENSE)

Exemplary Yocto distro layer based on LTS release yocto/dunfell.

## Dependencies
This layer depends on:

| meta layer          | project repository                    |
| ------------------- | ------------------------------------- |
| poky                | [poky/dunfell](https://git.yoctoproject.org/cgit/cgit.cgi/poky/log/?h=dunfell)   |
| meta-clang          | [meta-clang/dunfell](https://github.com/jhnc-oss/meta-clang/tree/dunfell)        |
| meta-mingw          | [meta-mingw/dunfell](https://github.com/jhnc-oss/meta-mingw/tree/dunfell)        |
| meta-openembedded   | [meta-openembedded/dunfell](https://github.com/jhnc-oss/meta-openembedded/tree/dunfell)        |
| meta-python2        | [meta-python2/dunfell](https://github.com/jhnc-oss/meta-python2/tree/dunfell)        |
| meta-qt5            | [meta-qt5/dunfell](https://github.com/jhnc-oss/meta-qt5/tree/h5b/dunfell-5.12.4) |
| meta-selinux        | [meta-selinux/dunfell](https://github.com/jhnc-oss/meta-selinux/tree/dunfell)        |

## TODOs
Drop legacy layer meta-python2 as soon as we can get rid of our dunfell-backport
of [Qt5.12.4](https://github.com/jhnc-oss/meta-qt5/tree/backport/5.12.4-dunfell-23.0.11)
and switch to officially supported version as provided by meta-qt5.
