package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netmask = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            netmask[i] = (byte) (ip[i] & mask[i]);
        }
        return netmask;
    }

    public static void print(byte[] bytes) {
        byte o1 = bytes[0];
        byte o2 = bytes[1];
        byte o3 = bytes[2];
        byte o4 = bytes[3];

        String oct1 = String.format("%8s", Integer.toBinaryString(o1 & 0xFF)).replace(' ', '0');
        String oct2 = String.format("%8s", Integer.toBinaryString(o2 & 0xFF)).replace(' ', '0');
        String oct3 = String.format("%8s", Integer.toBinaryString(o3 & 0xFF)).replace(' ', '0');
        String oct4 = String.format("%8s", Integer.toBinaryString(o4 & 0xFF)).replace(' ', '0');

    System.out.printf("%s %s %s %s%n", oct1, oct2, oct3, oct4);
    }
}
