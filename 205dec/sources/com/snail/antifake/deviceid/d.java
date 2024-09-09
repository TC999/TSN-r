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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IpScanner.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Handler f48133a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IpScanner.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f48134a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f48135b;

        a(String str, c cVar) {
            this.f48134a = str;
            this.f48135b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                int i4 = 2;
                while (i4 < 255) {
                    Log.e("kalshen", "run: udp-" + this.f48134a + i4);
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f48134a);
                    sb.append(String.valueOf(i4));
                    datagramPacket.setAddress(InetAddress.getByName(sb.toString()));
                    datagramSocket.send(datagramPacket);
                    i4++;
                    if (i4 == 125) {
                        datagramSocket.close();
                        datagramSocket = new DatagramSocket();
                    }
                }
                datagramSocket.close();
                d.this.c(this.f48135b);
            } catch (SocketException e4) {
                e4.printStackTrace();
            } catch (UnknownHostException e5) {
                e5.printStackTrace();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IpScanner.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f48137a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* compiled from: IpScanner.java */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f48139a;

            a(Map map) {
                this.f48139a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f48137a.a(this.f48139a);
            }
        }

        b(c cVar) {
            this.f48137a = cVar;
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
                        d.this.f48133a.post(new a(hashMap));
                        return;
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IpScanner.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface c {
        void a(Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c cVar) {
        new Thread(new b(cVar)).start();
    }

    private String d() {
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
        } catch (SocketException e4) {
            Log.i("kalshen", "SocketException");
            e4.printStackTrace();
        }
        return str;
    }

    public void e(c cVar) {
        new ArrayList();
        new HashMap();
        String d4 = d();
        new Thread(new a(d4.substring(0, d4.lastIndexOf(".") + 1), cVar)).start();
    }
}
