#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Simple library for accessing the MCP23S17 port expander through SPI."
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig

S = "${WORKDIR}"

SRC_URI = "file://src/mcp23s17.c \
	file://src/mcp23s17.h \
"

#PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

#RDEPENDS_${PN}-staticdev = ""
#RDEPENDS_${PN}-dev = ""
#RDEPENDS_${PN}-dbg = ""

do_compile() {
	${CC} -c -fPIC src/mcp23s17.c -o src/mcp23s17.o
	${AR} rcs ${PN}.a src/mcp23s17.o
}

do_install() {
	install -d ${D}${libdir}
	install -m 0755 ${PN}.a ${D}${libdir}
}

do_install_append() {
	install -d ${D}${includedir}
	install -m 0755 src/mcp23s17.h ${D}${includedir}
}
