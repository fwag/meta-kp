#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Simple library for accessing the MCP23S17 port expander through SPI."
SECTION = "misc"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = "libmcp23s17"

SRC_URI = "file://src/exmcp23s17.c \
"

do_compile() {
	${CC} -o exmcp23s17 -c src/exmcp23s17.c ${STAGING_LIBDIR}/libmcp23s17.a
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 exmcp23s17 ${D}${bindir}
}
