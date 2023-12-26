package com.example.apibackend.model.services;

import org.springframework.stereotype.Service;

import java.net.*;
import java.util.Enumeration;
@Service
public class DireccionMac {

    public String GetAddress(String addressType) {
        String address = "";
        InetAddress lanIp = null;
        try {

            String ipAddress = null;
            Enumeration<NetworkInterface> net = null;
            net = NetworkInterface.getNetworkInterfaces();

            while (net.hasMoreElements()) {
                NetworkInterface element = net.nextElement();
                Enumeration<InetAddress> addresses = element.getInetAddresses();

                if (element.getHardwareAddress() != null) {
                    while (addresses.hasMoreElements() && element.getHardwareAddress().length > 0 && element.getHardwareAddress() != null && !isVMMac(element.getHardwareAddress())) {
                        InetAddress ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {

                            if (ip.isSiteLocalAddress()) {
                                ipAddress = ip.getHostAddress();
                                lanIp = InetAddress.getByName(ipAddress);
                            }

                        }

                    }
                }
            }

            if (lanIp == null)
                return null;

            if (addressType.equals("ip")) {

                address = lanIp.toString().replaceAll("^/+", "");

            } else if (addressType.equals("mac")) {

                address = getMacAddress(lanIp);

            } else {
                System.out.println("Valores permitidos \"ip\" o \"mac\"");
                address=null;

            }

        } catch (UnknownHostException ex) {

            ex.printStackTrace();

        } catch (SocketException ex) {

            ex.printStackTrace();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return address;

    }

    private String getMacAddress(InetAddress ip) {
        String address = null;
        try {

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            address = sb.toString();

        } catch (SocketException ex) {

            ex.printStackTrace();

        }

        return address;
    }

    private boolean isVMMac(byte[] mac) {
        if(null == mac) return false;
        byte invalidMacs[][] = {
                {0x00, 0x05, 0x69},
                {0x00, 0x1C, 0x14},
                {0x00, 0x0C, 0x29},
                {0x00, 0x50, 0x56},
                {0x08, 0x00, 0x27},
                {0x0A, 0x00, 0x27},
                {0x00, 0x03, (byte)0xFF},
                {0x00, 0x15, 0x5D}
        };

        for (byte[] invalid: invalidMacs){
            if (invalid[0] == mac[0] && invalid[1] == mac[1] && invalid[2] == mac[2]) return true;
        }

        return false;
    }
}
