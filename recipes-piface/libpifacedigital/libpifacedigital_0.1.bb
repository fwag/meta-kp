SUMMARY = "mcp23s17"
SECTION = "libs"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/piface/libpifacedigital.git;protocol=https;branch=master"

SRC_URI += "file://Makefile.patch"

SRCREV = "933268fea212d584d0050fec503a975709163e5c"

SRC_URI[md5sum] = "6eb9a2b40b0bd451d4a3cd4068c406ce"
SRC_URI[sha256sum] = "ba4175904470588e46cc531f3a4e8418c6d49a9a2e524f786029301538f4b60a"

S = "${WORKDIR}/git/"

DEPENDS="libmcp23s17"

TARGET_CC_ARCH += "${LDFLAGS}"

# we need to pass the Cxx parameter extra to the make call
EXTRA_OEMAKE = "'CC=${CC}' 'AR=${AR}'"
# 'CFLAGS=${CFLAGS}'"
# 'LDFLAGS=${LDFLAGS}'"

do_compile() {
        oe_runmake all 'CC=${CC}'
	oe_runmake pifacedigital 'CC=${CC}'
}

do_install() {
        install -d ${D}${libdir}
        install -m 0755 ${PN}.a ${D}${libdir}

	install -d ${D}${bindir}
	install -m 0755 pifacedigital ${D}${bindir}
}

do_install_append() {
        install -d ${D}${includedir}
        install -m 0755 src/pifacedigital.h ${D}${includedir}
}

