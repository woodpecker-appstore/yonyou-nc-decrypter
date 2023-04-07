package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.helper.NCPasswdDcrypter;

public class WoodpeckerPluginManager implements IPluginManager {
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks iPluginManagerCallbacks) {
        NCPasswdDcrypter echoTextConverter = new NCPasswdDcrypter();
        iPluginManagerCallbacks.registerHelperPlugin(echoTextConverter);
    }
}
