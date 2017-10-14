SUMMARY = "mcp23s17"
SECTION = "libs"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/piface/libmcp23s17.git;protocol=https;branch=master"
SRCREV = "f65a5e2fb2f705eb0a108e1f888da7dea3638c4b"

SRC_URI[md5sum] = "6a3bc32c3074ee4dee80879077e18288"
SRC_URI[sha256sum] = "d7cb76c5154c417ce5c82dd57099fe2dd57094ae0859ab5b2a090d9342716c50"

S = "${WORKDIR}/git/"

# we need to pass the Cxx parameter extra to the make call
EXTRA_OEMAKE = "'CC=${CC}' 'AR=${AR}'"

do_compile() {
        oe_runmake all 'CC=${CC}'
}

do_install() {
        install -d ${D}${libdir}
        install -m 0755 ${PN}.a ${D}${libdir}
}

do_install_append() {
        install -d ${D}${includedir}
        install -m 0755 src/mcp23s17.h ${D}${includedir}
}

