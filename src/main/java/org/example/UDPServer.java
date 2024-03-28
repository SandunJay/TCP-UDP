package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] recieveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true){
            DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);
            serverSocket.receive(recievePacket);
            String sentence = new String(recievePacket.getData());

            InetAddress IPAddress =recievePacket.getAddress();
            int port = recievePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);
        }
    }
}
