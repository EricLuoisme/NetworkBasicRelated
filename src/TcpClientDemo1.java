import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author lykis
 */
public class TcpClientDemo1 {

    public static void main(String[] args) throws UnknownHostException {

        // 1. 需要知道服务器地址，端口号
        InetAddress serverIp = InetAddress.getByName("localhost");
        int port = 9999;


        try (   // 2. 创建一个socket连接
                Socket socket = new Socket(serverIp, port);

                // 3. 发送信息IO流
                OutputStream os = socket.getOutputStream()
        ) {

            os.write("客户端向服务端发送字节流".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
