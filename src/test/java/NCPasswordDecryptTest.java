import nc.vo.framework.rsa.Encode;
import org.junit.Test;

public class NCPasswordDecryptTest {
    @Test
    public void Test() throws Exception {
        String password = "jlehfdffcfmohiag";
        String customKey = "1231234234";
        long key = 1231234234L;
        if (customKey != null) {
            key = Long.parseLong(customKey);
            System.out.println(key);
        }
        Encode encoder = new Encode();
        String plainText = encoder.decode(password, key);
        System.out.println("Decrypt result:");
        System.out.println("\n" + plainText + "\n");
    }
}
