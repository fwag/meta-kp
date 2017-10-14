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

DEPENDS = "libpifacedigital libmcp23s17"

SRC_URI = "file://util/pifacedigital-cmd.c \
"

do_compile() {
	${CC} -o pifacedigital_cmd util/pifacedigital-cmd.c -L${STAGING_LIBDIR} -lpifacedigital -lmcp23s17
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 pifacedigital_cmd ${D}${bindir}
}
