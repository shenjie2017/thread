package com.blue.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 18:04 2017/12/27
 * @Modifide By:
 **/

//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

public class ServiceClient {
    public static void main(String[] args) {
        ServiceClient client = new ServiceClient();
        try {
            client.startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startClient() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",8888));
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            pw.println("hello");
            pw.flush();
            String line = br.readLine();
            System.out.println("is received host(" + socket.getRemoteSocketAddress().toString()+ ") data:" + line);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(null!=in){
                    in.close();
                }
                if(null!=out){
                    out.close();
                }
                if(null!=socket){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
