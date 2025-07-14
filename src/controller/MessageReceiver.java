package controller;

import java.net.*;
import java.io.*;
import model.Message;
import util.JSONUtil;
import javax.swing.JTextArea;

public class MessageReceiver extends Thread {

    private final String multicastIP;
    private final int port;
    private final JTextArea messageArea;

    public MessageReceiver(String multicastIP, int port, JTextArea messageArea) {
        this.multicastIP = multicastIP;
        this.port = port;
        this.messageArea = messageArea;
    }

    @Override
    public void run() {
        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastIP);
            socket.joinGroup(group);
            byte[] buffer = new byte[1024];

            while (!isInterrupted()) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String json = new String(packet.getData(), 0, packet.getLength());

                Message msg = JSONUtil.fromJSON(json);
                String formatted = String.format("[%s %s] %s: %s",
                        msg.getDate(), msg.getTime(), msg.getUsername(), msg.getMessage());

                messageArea.append(formatted + "\n");
            }

            socket.leaveGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
