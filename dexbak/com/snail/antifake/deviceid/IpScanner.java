package com.snail.antifake.deviceid;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.snail.antifake.deviceid.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IpScanner {

    /* renamed from: a */
    private Handler f33799a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IpScanner.java */
    /* renamed from: com.snail.antifake.deviceid.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11943a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f33800a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC11946c f33801b;

        RunnableC11943a(String str, InterfaceC11946c interfaceC11946c) {
            this.f33800a = str;
            this.f33801b = interfaceC11946c;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                int i = 2;
                while (i < 255) {
                    Log.e("kalshen", "run: udp-" + this.f33800a + i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f33800a);
                    sb.append(String.valueOf(i));
                    datagramPacket.setAddress(InetAddress.getByName(sb.toString()));
                    datagramSocket.send(datagramPacket);
                    i++;
                    if (i == 125) {
                        datagramSocket.close();
                        datagramSocket = new DatagramSocket();
                    }
                }
                datagramSocket.close();
                IpScanner.this.m19682c(this.f33801b);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IpScanner.java */
    /* renamed from: com.snail.antifake.deviceid.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11944b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ InterfaceC11946c f33803a;

        /* compiled from: IpScanner.java */
        /* renamed from: com.snail.antifake.deviceid.d$b$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class RunnableC11945a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Map f33805a;

            RunnableC11945a(Map map) {
                this.f33805a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC11944b.this.f33803a.m19679a(this.f33805a);
            }
        }

        RunnableC11944b(InterfaceC11946c interfaceC11946c) {
            this.f33803a = interfaceC11946c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        Log.e("kalshen", "run: " + readLine);
                        if (!readLine.contains("00:00:00:00:00:00") && !readLine.contains("IP")) {
                            String[] split = readLine.split("\\s+");
                            hashMap.put(split[3], split[0]);
                        }
                    } else {
                        IpScanner.this.f33799a.post(new RunnableC11945a(hashMap));
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: IpScanner.java */
    /* renamed from: com.snail.antifake.deviceid.d$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC11946c {
        /* renamed from: a */
        void m19679a(Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m19682c(InterfaceC11946c interfaceC11946c) {
        new Thread(new RunnableC11944b(interfaceC11946c)).start();
    }

    /* renamed from: d */
    private String m19681d() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!(nextElement instanceof Inet6Address) && !"127.0.0.1".equals(nextElement.getHostAddress())) {
                            str = nextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("kalshen", "SocketException");
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: e */
    public void m19680e(InterfaceC11946c interfaceC11946c) {
        new ArrayList();
        new HashMap();
        String m19681d = m19681d();
        new Thread(new RunnableC11943a(m19681d.substring(0, m19681d.lastIndexOf(".") + 1), interfaceC11946c)).start();
    }
}
