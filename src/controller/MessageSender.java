package controller;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Message;
import util.JSONUtil;

public class MessageSender {

    public static void sendMessage(String user, String text, String multicastIP, int port) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(multicastIP);
            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            Message msg = new Message(date, time, user, text);
            String json = JSONUtil.toJSON(msg);

            byte[] buffer = json.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
