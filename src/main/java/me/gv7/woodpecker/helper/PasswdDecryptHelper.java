package me.gv7.woodpecker.helper;

import me.gv7.woodpecker.plugin.IArg;
import me.gv7.woodpecker.plugin.IArgsUsageBinder;
import me.gv7.woodpecker.plugin.IHelper;
import me.gv7.woodpecker.plugin.IResultOutput;
import nc.vo.framework.rsa.Encode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PasswdDecryptHelper implements IHelper {
    public PasswdDecryptHelper() {
    }

    public String getHelperTabCaption() {
        return "NC password Decrypter";
    }

    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = NCPasswdDcrypter.pluginHelper.createArgsUsageBinder();
        List<IArg> args = new ArrayList();
        IArg argPassword = NCPasswdDcrypter.pluginHelper.createArg();
        argPassword.setName("password");
        argPassword.setDefaultValue("jlehfdffcfmohiag");
        argPassword.setDescription("需要解密的 password");
        argPassword.setRequired(true);
        args.add(argPassword);

        IArg argKey = NCPasswdDcrypter.pluginHelper.createArg();
        argKey.setName("key");
        argKey.setDefaultValue("1231234234");
        argKey.setDescription("用于解密的 key");
        argKey.setRequired(false);
        args.add(argKey);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    public void doHelp(Map<String, Object> customArgs, IResultOutput iResultOutput) throws Throwable {
        String password = (String) customArgs.get("password");
        String customKey = (String) customArgs.get("key");
        long key = 1231234234;
        if (customKey != null) {
            key = Long.parseLong(customKey);
        }
        try {
            Encode encoder = new Encode();
            String plainText = encoder.decode(password, key);
            iResultOutput.successPrintln("Decrypt result:");
            iResultOutput.rawPrintln("\n" + plainText + "\n");
        } catch (Exception var6) {
            iResultOutput.errorPrintln(NCPasswdDcrypter.pluginHelper.getThrowableInfo(var6));
        }
    }
}
