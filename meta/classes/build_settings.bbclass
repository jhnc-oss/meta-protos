# This class is an initial effort to enable conditional target builds
# while keeping our legacy x86 (32 bit) build for now.
#
# Though, architecture is currently limited to x86_64.
#
# In order to enable it you need to add
# IHNHERIT += "build_settings" to local.conf
#
# In addition, the consuming podman container needs to set
# --env YOCTO_TARGET_ARCH=... and whitelist BB_ENV_PASSTHROUGH_ADDITIONS
# accordingly

def build_settings(d):
  arch = d.getVar("YOCTO_TARGET_ARCH")

  if arch == "x86_64":
    opt_machine = "genericx86-64"
    opt_defaulttune = "core2-64"
  elif arch == "x86":
    opt_machine = "genericx86"
    opt_defaulttune = "i586"
  else:
    bb.error("Unsupported target arch: %s" % arch)

  d.appendVar("IMAGE_FSTYPES", " tar.gz")
  d.setVar("IMAGE_VERSION_SUFFIX", "-" + d.getVar('DISTRO_VERSION'))

  d.setVar("MACHINE", opt_machine)
  d.setVar("DEFAULTTUNE", opt_defaulttune)

  bb.note("Setting MACHINE to %s" % (opt_machine))
  bb.note("Setting DEFAULTTUNE to %s" % (opt_defaulttune))

addhandler build_settings_eventhandler
build_settings_eventhandler[eventmask] = "bb.event.ConfigParsed"
python build_settings_eventhandler() {
  build_settings(e.data)
}
