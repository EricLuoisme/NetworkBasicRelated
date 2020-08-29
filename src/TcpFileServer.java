import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lykis
 */
public class TcpFileServer {
    public static void main(String[] args) {

        try (
                // 1. 创建服务
                ServerSocket serverSocket = new ServerSocket(9000);

                // 2. 监听客户端连接（阻塞式监听）
                Socket socket = serverSocket.accept();

                // 3. 获取输入流
                InputStream is = socket.getInputStream();

                // 4. 文件输出
                FileOutputStream fos = new FileOutputStream(new File("download.png"));

                // 6. 通知客户端，这边接收完毕
                OutputStream os = socket.getOutputStream()
        ) {

            // 5. 写出文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // 6. 通知接收完毕
            os.write("服务端接受文件完毕".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
