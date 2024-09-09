package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* compiled from: SocketManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static volatile AtomicInteger f39631a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f39632b;

    /* compiled from: SocketManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f39635b;

        /* renamed from: c  reason: collision with root package name */
        private ByteBuffer f39636c;

        /* renamed from: d  reason: collision with root package name */
        private OutputStream f39637d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f39638e;

        /* renamed from: f  reason: collision with root package name */
        private e f39639f;

        /* renamed from: g  reason: collision with root package name */
        private Socket f39640g;

        /* renamed from: h  reason: collision with root package name */
        private String f39641h;

        /* renamed from: i  reason: collision with root package name */
        private int f39642i;

        a(String str, int i4, String str2, boolean z3, e eVar) {
            this.f39641h = str;
            this.f39642i = i4;
            this.f39635b = str2;
            this.f39638e = z3;
            this.f39639f = eVar;
        }

        private void a(String str) {
            if (this.f39639f != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.f39639f.a(new com.mbridge.msdk.foundation.same.net.a.a(13, new com.mbridge.msdk.foundation.same.net.e.c(404, str.getBytes(), null)));
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] bytes;
            int length;
            String str;
            try {
                Socket socket = new Socket(this.f39641h, this.f39642i);
                this.f39640g = socket;
                socket.setSoTimeout(15000);
                boolean contains = this.f39641h.contains(com.mbridge.msdk.foundation.same.net.f.d.a().f39568e);
                x.d("SocketManager", "Socket connect : " + this.f39641h + " : " + this.f39642i + " isAnalytics : " + contains);
                this.f39637d = this.f39640g.getOutputStream();
                ByteBuffer wrap = ByteBuffer.wrap(new byte[8]);
                this.f39636c = wrap;
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                wrap.order(byteOrder);
                this.f39636c.put((byte) 2);
                if (TextUtils.isEmpty(this.f39635b)) {
                    this.f39636c.put((byte) 1);
                } else {
                    this.f39636c.put(this.f39638e ? (byte) 3 : (byte) 2);
                }
                this.f39636c.putShort((short) m.f39631a.getAndIncrement());
                if (TextUtils.isEmpty(this.f39635b)) {
                    this.f39636c.putInt(0);
                    this.f39637d.write(this.f39636c.array());
                    length = 0;
                } else {
                    if (this.f39638e) {
                        String str2 = this.f39635b;
                        if (TextUtils.isEmpty(str2)) {
                            bytes = null;
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(str2.getBytes());
                            gZIPOutputStream.close();
                            bytes = byteArrayOutputStream.toByteArray();
                        }
                    } else {
                        bytes = this.f39635b.getBytes();
                    }
                    length = bytes.length;
                    this.f39636c.putInt(length);
                    this.f39637d.write(this.f39636c.array());
                    this.f39637d.write(bytes);
                }
                this.f39637d.flush();
                x.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f39636c.array()) + " length : " + length);
                InputStream inputStream = this.f39640g.getInputStream();
                byte[] bArr = new byte[8];
                inputStream.read(bArr, 0, 8);
                ByteBuffer wrap2 = ByteBuffer.wrap(bArr);
                this.f39636c = wrap2;
                wrap2.order(byteOrder);
                int i4 = this.f39636c.getInt(4);
                boolean z3 = bArr[1] == 3;
                boolean z4 = bArr[1] == 2;
                x.d("SocketManager", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i4 + " isGzip : " + z3);
                byte[] bArr2 = new byte[i4];
                new DataInputStream(this.f39640g.getInputStream()).readFully(bArr2);
                if (!z3 && i4 > 2 && ((bArr2[0] << 8) | (bArr2[1] & 255)) == 8075) {
                    z3 = true;
                }
                e eVar = this.f39639f;
                if (eVar == null) {
                    Socket socket2 = this.f39640g;
                    if (socket2 != null) {
                        try {
                            socket2.close();
                            this.f39636c = null;
                            this.f39637d.close();
                        } catch (IOException e4) {
                            x.d("SocketManager", e4.getMessage());
                        }
                    }
                } else if (z4 && i4 == 0) {
                    eVar.a(k.a(null, new com.mbridge.msdk.foundation.same.net.e.c(204, null, null)));
                    Socket socket3 = this.f39640g;
                    if (socket3 != null) {
                        try {
                            socket3.close();
                            this.f39636c = null;
                            this.f39637d.close();
                        } catch (IOException e5) {
                            x.d("SocketManager", e5.getMessage());
                        }
                    }
                } else if (i4 < 1) {
                    a("The response data less than 1");
                    Socket socket4 = this.f39640g;
                    if (socket4 != null) {
                        try {
                            socket4.close();
                            this.f39636c = null;
                            this.f39637d.close();
                        } catch (IOException e6) {
                            x.d("SocketManager", e6.getMessage());
                        }
                    }
                } else if (contains) {
                    if (bArr2[0] == 1) {
                        eVar.a(k.a(null, new com.mbridge.msdk.foundation.same.net.e.c(200, null, null)));
                    } else {
                        a("The server returns fail");
                    }
                    Socket socket5 = this.f39640g;
                    if (socket5 != null) {
                        try {
                            socket5.close();
                            this.f39636c = null;
                            this.f39637d.close();
                        } catch (IOException e7) {
                            x.d("SocketManager", e7.getMessage());
                        }
                    }
                } else {
                    if (z3) {
                        str = m.this.a(bArr2);
                    } else {
                        str = new String(bArr2);
                    }
                    JSONObject jSONObject = !TextUtils.isEmpty(str) ? new JSONObject(str) : null;
                    x.d("SocketManager", "Socket Response length : " + i4 + " " + str.length());
                    this.f39639f.a(k.a(jSONObject, new com.mbridge.msdk.foundation.same.net.e.c(200, null, null)));
                    inputStream.close();
                    Socket socket6 = this.f39640g;
                    if (socket6 != null) {
                        socket6.close();
                        this.f39636c = null;
                        this.f39637d.close();
                    }
                }
            } catch (IOException e8) {
                x.d("SocketManager", e8.getMessage());
            }
        }
    }

    /* compiled from: SocketManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static m f39643a = new m();
    }

    public static m a() {
        return b.f39643a;
    }

    private m() {
        this.f39632b = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.net.m.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("SocketThreadPool");
                return newThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(String str, int i4, String str2, boolean z3, e eVar) {
        this.f39632b.execute(new a(str, i4, str2, z3, eVar));
    }

    public final String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }
}
