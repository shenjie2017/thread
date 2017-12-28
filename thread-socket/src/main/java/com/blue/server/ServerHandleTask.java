package com.blue.server;

import java.io.*;
import java.net.Socket;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 17:49 2017/12/27
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

public class ServerHandleTask implements Runnable {
    private Socket socket;

    public ServerHandleTask(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);

            String line = null;
            while(null!=(line=br.readLine())){
                System.out.println("is receive host(" + socket.getRemoteSocketAddress() + ") data:" + line);
                String result = new ServiceHandler().handler(line);
                pw.println(result);
                pw.flush();
            }

            System.out.println(socket.getInetAddress().toString()+" is disconnected");

        } catch (IOException e) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
