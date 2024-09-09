package com.qq.e.comm.plugin.i0.l.k;

import com.qq.e.comm.plugin.i0.l.k.c;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends c {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DatagramSocket f44358c;

        a(e eVar, DatagramSocket datagramSocket) {
            this.f44358c = datagramSocket;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f44358c.close();
            } catch (Exception unused) {
            }
        }
    }

    public e(String[] strArr, int i4, int i5, ExecutorService executorService) {
        super(strArr, i4, i5, executorService);
    }

    @Override // com.qq.e.comm.plugin.i0.l.k.c
    d a(c.b bVar, String str, String str2, int i4) throws Exception {
        DatagramSocket datagramSocket;
        b bVar2 = new b((short) (Math.random() * 65535.0d), i4, str2);
        byte[] b4 = bVar2.b();
        InetAddress byName = InetAddress.getByName(str);
        try {
            datagramSocket = new DatagramSocket();
        } catch (Throwable th) {
            th = th;
            datagramSocket = null;
        }
        try {
            DatagramPacket datagramPacket = new DatagramPacket(b4, b4.length, byName, 53);
            datagramSocket.setSoTimeout(this.f44330d * 1000);
            bVar.a(new a(this, datagramSocket));
            datagramSocket.send(datagramPacket);
            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1500], 1500);
            datagramSocket.receive(datagramPacket2);
            d dVar = new d(str, 2, bVar2, datagramPacket2.getData());
            datagramSocket.close();
            return dVar;
        } catch (Throwable th2) {
            th = th2;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            throw th;
        }
    }
}
