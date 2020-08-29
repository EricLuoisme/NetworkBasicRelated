import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author lykis
 */
public class TcpFileClient {
    public static void main(String[] args) {

        try (
                // 1. 创建socket连接
                Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

                // 2. 创建一个输出流
                OutputStream os = socket.getOutputStream();

                // 3. 读取文件（文件路径是整个项目下的路径作为开始）
                FileInputStream fis = new FileInputStream(new File("upload.png"));

                // 6. 确认服务端接受完毕，才断开连接
                InputStream inputStream = socket.getInputStream();

                // 7. 接收的东西是不认识的，所以需要管道流才能知道
                ByteArrayOutputStream baos = new ByteArrayOutputStream()

        ) {

            // 4. 写出文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            // 5. 通知服务器，我发送完了
            socket.shutdownOutput();


            // 8. 输出接受到的信息
            byte[] buffer2 = new byte[1024];
            int len2;
            while ((len2 = fis.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
