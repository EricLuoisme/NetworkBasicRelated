import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author lykis
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);

            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            InetAddress inetAddress4 = InetAddress.getLoopbackAddress();
            System.out.println(inetAddress4);

            System.out.println(inetAddress2.getCanonicalHostName());
            // 获取规范名

            System.out.println(inetAddress2.getHostAddress());
            System.out.println(inetAddress2.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
