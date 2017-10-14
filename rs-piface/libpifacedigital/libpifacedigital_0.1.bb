#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "A simple library for controlling PiFace Digital. Hides the SPI file descriptors so the user only has to deal with hw_addr."
SECTION = "misc"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig

S = "${WORKDIR}"

DEPENDS = "libmcp23s17"

SRC_URI = "file://src/pifacedigital.c \
	file://src/pifacedigital.h \
"

#PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

#RDEPENDS_${PN}-staticdev = ""
#RDEPENDS_${PN}-dev = ""
#RDEPENDS_${PN}-dbg = ""

do_compile() {
	${CC} -o src/pifacedigital.o -c -fPIC src/pifacedigital.c
	${AR} rcs ${PN}.a src/pifacedigital.o
}

do_install() {
	install -d ${D}${libdir}
	install -m 0755 ${PN}.a ${D}${libdir}
}

do_install_append() {
	install -d ${D}${includedir}
	install -m 0755 src/pifacedigital.h ${D}${includedir}
}
