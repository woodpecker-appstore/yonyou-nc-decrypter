package me.gv7.woodpecker.helper;

import me.gv7.woodpecker.plugin.IHelper;
import me.gv7.woodpecker.plugin.IHelperPlugin;
import me.gv7.woodpecker.plugin.IHelperPluginCallbacks;
import me.gv7.woodpecker.plugin.IPluginHelper;

import java.util.ArrayList;
import java.util.List;

public class NCPasswdDcrypter implements IHelperPlugin {
    public static IHelperPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;

    public NCPasswdDcrypter() {
    }

    @Override
    public void HelperPluginMain(IHelperPluginCallbacks iHelperPluginCallbacks) {
        callbacks = iHelperPluginCallbacks;
        pluginHelper = callbacks.getPluginHelper();
        callbacks.setHelperPluginName("Yonyou NC password Decrypter");
        callbacks.setHelperPluginVersion("0.1.0");
        callbacks.setHelperPluginAutor("pen4uin");
        callbacks.setHelperPluginDescription("用友 NC 系列密码解密");
        List<IHelper> helperList = new ArrayList();
        helperList.add(new PasswdDecryptHelper());
        callbacks.registerHelper(helperList);
    }
}
