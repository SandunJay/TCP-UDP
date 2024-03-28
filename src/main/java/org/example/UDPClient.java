package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("hostname");

        byte[] sendData = new byte[1024];
        byte[] recieveData = new byte[1024];

        String sentence  = inFromUser.readLine();

        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress, 9876);

        clientSocket.send(sendPacket);

        DatagramPacket recievePacket = new DatagramPacket(recieveData,recieveData.length);

        clientSocket.receive(recievePacket);

        String modifiedSentence = new String(recievePacket.getData());

        System.out.println("FROM SERVER: "+ modifiedSentence);

        clientSocket.close();
    }
}
