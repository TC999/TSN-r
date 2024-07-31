package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.p518qq.p519e.comm.adevent.AdEventType;
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
import kotlin.UByte;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.net.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SocketManager {

    /* renamed from: a */
    private static volatile AtomicInteger f30858a = new AtomicInteger(1);

    /* renamed from: b */
    private ExecutorService f30859b;

    /* compiled from: SocketManager.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private class RunnableC11358a implements Runnable {

        /* renamed from: b */
        private String f30862b;

        /* renamed from: c */
        private ByteBuffer f30863c;

        /* renamed from: d */
        private OutputStream f30864d;

        /* renamed from: e */
        private boolean f30865e;

        /* renamed from: f */
        private IListener f30866f;

        /* renamed from: g */
        private Socket f30867g;

        /* renamed from: h */
        private String f30868h;

        /* renamed from: i */
        private int f30869i;

        RunnableC11358a(String str, int i, String str2, boolean z, IListener iListener) {
            this.f30868h = str;
            this.f30869i = i;
            this.f30862b = str2;
            this.f30865e = z;
            this.f30866f = iListener;
        }

        /* renamed from: a */
        private void m22162a(String str) {
            if (this.f30866f != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.f30866f.mo21052a(new CommonError(13, new NetworkResponse(404, str.getBytes(), null)));
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] bytes;
            int length;
            String str;
            try {
                Socket socket = new Socket(this.f30868h, this.f30869i);
                this.f30867g = socket;
                socket.setSoTimeout(15000);
                boolean contains = this.f30868h.contains(RequestUrlUtil.m22248a().f30795e);
                SameLogTool.m21733d("SocketManager", "Socket connect : " + this.f30868h + " : " + this.f30869i + " isAnalytics : " + contains);
                this.f30864d = this.f30867g.getOutputStream();
                ByteBuffer wrap = ByteBuffer.wrap(new byte[8]);
                this.f30863c = wrap;
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                wrap.order(byteOrder);
                this.f30863c.put((byte) 2);
                if (TextUtils.isEmpty(this.f30862b)) {
                    this.f30863c.put((byte) 1);
                } else {
                    this.f30863c.put(this.f30865e ? (byte) 3 : (byte) 2);
                }
                this.f30863c.putShort((short) SocketManager.f30858a.getAndIncrement());
                if (TextUtils.isEmpty(this.f30862b)) {
                    this.f30863c.putInt(0);
                    this.f30864d.write(this.f30863c.array());
                    length = 0;
                } else {
                    if (this.f30865e) {
                        String str2 = this.f30862b;
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
                        bytes = this.f30862b.getBytes();
                    }
                    length = bytes.length;
                    this.f30863c.putInt(length);
                    this.f30864d.write(this.f30863c.array());
                    this.f30864d.write(bytes);
                }
                this.f30864d.flush();
                SameLogTool.m21738a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f30863c.array()) + " length : " + length);
                InputStream inputStream = this.f30867g.getInputStream();
                byte[] bArr = new byte[8];
                inputStream.read(bArr, 0, 8);
                ByteBuffer wrap2 = ByteBuffer.wrap(bArr);
                this.f30863c = wrap2;
                wrap2.order(byteOrder);
                int i = this.f30863c.getInt(4);
                boolean z = bArr[1] == 3;
                boolean z2 = bArr[1] == 2;
                SameLogTool.m21733d("SocketManager", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i + " isGzip : " + z);
                byte[] bArr2 = new byte[i];
                new DataInputStream(this.f30867g.getInputStream()).readFully(bArr2);
                if (!z && i > 2 && ((bArr2[0] << 8) | (bArr2[1] & UByte.f41242c)) == 8075) {
                    z = true;
                }
                IListener iListener = this.f30866f;
                if (iListener == null) {
                    Socket socket2 = this.f30867g;
                    if (socket2 != null) {
                        try {
                            socket2.close();
                            this.f30863c = null;
                            this.f30864d.close();
                        } catch (IOException e) {
                            SameLogTool.m21733d("SocketManager", e.getMessage());
                        }
                    }
                } else if (z2 && i == 0) {
                    iListener.mo21051a(C11356k.m22175a(null, new NetworkResponse(AdEventType.VIDEO_PAUSE, null, null)));
                    Socket socket3 = this.f30867g;
                    if (socket3 != null) {
                        try {
                            socket3.close();
                            this.f30863c = null;
                            this.f30864d.close();
                        } catch (IOException e2) {
                            SameLogTool.m21733d("SocketManager", e2.getMessage());
                        }
                    }
                } else if (i < 1) {
                    m22162a("The response data less than 1");
                    Socket socket4 = this.f30867g;
                    if (socket4 != null) {
                        try {
                            socket4.close();
                            this.f30863c = null;
                            this.f30864d.close();
                        } catch (IOException e3) {
                            SameLogTool.m21733d("SocketManager", e3.getMessage());
                        }
                    }
                } else if (contains) {
                    if (bArr2[0] == 1) {
                        iListener.mo21051a(C11356k.m22175a(null, new NetworkResponse(200, null, null)));
                    } else {
                        m22162a("The server returns fail");
                    }
                    Socket socket5 = this.f30867g;
                    if (socket5 != null) {
                        try {
                            socket5.close();
                            this.f30863c = null;
                            this.f30864d.close();
                        } catch (IOException e4) {
                            SameLogTool.m21733d("SocketManager", e4.getMessage());
                        }
                    }
                } else {
                    if (z) {
                        str = SocketManager.this.m22164a(bArr2);
                    } else {
                        str = new String(bArr2);
                    }
                    JSONObject jSONObject = !TextUtils.isEmpty(str) ? new JSONObject(str) : null;
                    SameLogTool.m21733d("SocketManager", "Socket Response length : " + i + " " + str.length());
                    this.f30866f.mo21051a(C11356k.m22175a(jSONObject, new NetworkResponse(200, null, null)));
                    inputStream.close();
                    Socket socket6 = this.f30867g;
                    if (socket6 != null) {
                        socket6.close();
                        this.f30863c = null;
                        this.f30864d.close();
                    }
                }
            } catch (IOException e5) {
                SameLogTool.m21733d("SocketManager", e5.getMessage());
            }
        }
    }

    /* compiled from: SocketManager.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.m$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static final class C11359b {

        /* renamed from: a */
        private static SocketManager f30870a = new SocketManager();
    }

    /* renamed from: a */
    public static SocketManager m22166a() {
        return C11359b.f30870a;
    }

    private SocketManager() {
        this.f30859b = new ThreadPoolExecutor(5, 10, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.net.m.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("SocketThreadPool");
                return newThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    /* renamed from: a */
    public final void m22165a(String str, int i, String str2, boolean z, IListener iListener) {
        this.f30859b.execute(new RunnableC11358a(str, i, str2, z, iListener));
    }

    /* renamed from: a */
    public final String m22164a(byte[] bArr) throws IOException {
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
