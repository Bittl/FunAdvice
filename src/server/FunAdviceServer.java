package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FunAdviceServer {

    String[] adviceList = {"Ешьте меньшими порциями!", "Держите осанку", "Будьте честны с самим собой", "Сыскажите коллеге всё, что Вы о нём думаете", "Подумайте, что бы Вы хотели в себе поменять."};

    public void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true){
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice(){
        int random = (int)(Math.random() * adviceList.length);
//        System.out.println(random);
        return adviceList[random];
    }

    public static void main(String[] args) {
        FunAdviceServer server = new FunAdviceServer();
        server.go();
    }
}
