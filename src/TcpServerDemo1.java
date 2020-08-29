import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lykis
 */
public class TcpServerDemo1 {

    public static void main(String[] args) {

        try (
                // 1. 需要有一个自己的地址（端口号）
                ServerSocket serverSocket = new ServerSocket(9999);

                // 2. 等待客户端连接
                Socket socket = serverSocket.accept();

                // 3. 读取客户端发送的消息
                InputStream is = socket.getInputStream();

                // 管道流
                ByteArrayOutputStream baos = new ByteArrayOutputStream()

        ) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
