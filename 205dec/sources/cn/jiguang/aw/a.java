package cn.jiguang.aw;

import android.net.DhcpInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.ao.c;
import cn.jiguang.ao.g;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f2440a = {102, 120, 94, 71, 57, 37, 117, 49, 1, 0, 52, Byte.MAX_VALUE, 54, 32, 16};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f2441b = {83, 65, 109, 40, 57, 97, 66, 79, 122, 39, 120, 116, 68, 15, 120, 122, 102};

    /* renamed from: cn.jiguang.aw.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class C0052a {

        /* renamed from: a  reason: collision with root package name */
        HandlerThread f2442a;

        /* renamed from: b  reason: collision with root package name */
        Handler f2443b;

        /* renamed from: c  reason: collision with root package name */
        private int f2444c;

        /* renamed from: d  reason: collision with root package name */
        private String f2445d;

        C0052a(String str, int i4) {
            this.f2444c = i4;
            this.f2445d = str;
            HandlerThread handlerThread = new HandlerThread("jg_ptm_thread");
            this.f2442a = handlerThread;
            handlerThread.start();
            this.f2443b = new Handler(this.f2442a.getLooper(), new Handler.Callback() { // from class: cn.jiguang.aw.a.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    Thread thread;
                    if (message == null || message.what != 1 || (thread = (Thread) message.obj) == null) {
                        return false;
                    }
                    thread.interrupt();
                    return false;
                }
            });
        }

        private void b(byte[] bArr, int i4, int i5) {
            if (bArr == null || bArr.length < 3) {
                return;
            }
            byte[] bArr2 = {bArr[0], bArr[1], bArr[2], 0};
            Thread currentThread = Thread.currentThread();
            while (i4 < i5) {
                bArr2[3] = (byte) i4;
                if (bArr2[3] != bArr[3]) {
                    String b4 = a.b(bArr2);
                    if (!b4.equalsIgnoreCase(this.f2445d)) {
                        this.f2443b.removeCallbacksAndMessages(null);
                        Message obtainMessage = this.f2443b.obtainMessage(1);
                        obtainMessage.obj = currentThread;
                        Bundle bundle = new Bundle();
                        bundle.putString("ip", b4);
                        obtainMessage.setData(bundle);
                        this.f2443b.sendMessageDelayed(obtainMessage, this.f2444c);
                        g.a(new String[]{c.b(a.f2440a) + b4}, 0);
                    }
                }
                i4++;
            }
        }

        void a(byte[] bArr, int i4, int i5) {
            b(bArr, i4, i5);
            this.f2442a.quit();
        }
    }

    private static cn.jiguang.av.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        cn.jiguang.av.a aVar = new cn.jiguang.av.a();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= bytes.length - 1) {
                break;
            }
            i4++;
            if (bytes[i4] == 32) {
                int i7 = i4 - i5;
                if (i7 > 1) {
                    String str2 = new String(bytes, i5, i7);
                    if (i6 != 0) {
                        if (i6 != 1) {
                            if (i6 != 2) {
                                if (i6 == 3) {
                                    aVar.f2439d = str2;
                                    break;
                                }
                            } else {
                                aVar.f2438c = str2;
                            }
                        } else {
                            aVar.f2437b = str2;
                        }
                    } else {
                        aVar.f2436a = str2;
                    }
                    i6++;
                }
                i5 = i4 + 1;
            }
        }
        return aVar;
    }

    public static String a(int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i4 & 255);
        stringBuffer.append('.');
        stringBuffer.append((i4 >> 8) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i4 >> 16) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i4 >> 24) & 255);
        return stringBuffer.toString();
    }

    public static List<cn.jiguang.av.a> a(String str, DhcpInfo dhcpInfo) {
        cn.jiguang.av.a a4;
        try {
            String a5 = a(dhcpInfo.ipAddress & Integer.reverseBytes(-256));
            String substring = a5.substring(0, a5.lastIndexOf(".") + 1);
            for (int i4 = 0; i4 < 256; i4++) {
                InetAddress byName = InetAddress.getByName(substring + i4);
                byte[] b4 = b();
                ((DatagramSocket) Class.forName("java.net.DatagramSocket").newInstance()).send(new DatagramPacket(b4, b4.length, byName, 137));
            }
            Thread.sleep(2000L);
            cn.jiguang.w.a.f("JArpHelper", "start to get");
            List<String> a6 = g.a(new String[]{c.b(f2441b)}, 1);
            if (a6 != null && !a6.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : a6) {
                    if (!TextUtils.isEmpty(str2) && (a4 = a(str2)) != null && a4.f2438c.equals("0x2") && !str.equals(a4.f2436a) && !a4.f2439d.equals("00:00:00:00:00:00")) {
                        arrayList.add(a4);
                    }
                }
                return arrayList;
            }
            cn.jiguang.w.a.f("JArpHelper", "execute command failed");
            return null;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JArpHelper", "execute command throwable=" + th);
            return null;
        }
    }

    public static void a(String str, byte[] bArr) {
        new C0052a(str, 300).a(bArr, 0, 255);
    }

    public static byte[] a(long j4) {
        return new byte[]{(byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[1] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[2] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[3] & 255);
        return stringBuffer.toString();
    }

    private static byte[] b() {
        byte[] bArr = new byte[50];
        bArr[0] = 126;
        bArr[1] = 40;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 32;
        bArr[13] = 67;
        bArr[14] = 75;
        for (int i4 = 15; i4 < 45; i4++) {
            bArr[i4] = 65;
        }
        bArr[45] = 0;
        bArr[46] = 0;
        bArr[47] = 33;
        bArr[48] = 0;
        bArr[49] = 1;
        return bArr;
    }
}
