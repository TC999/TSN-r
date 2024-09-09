package com.bykv.vk.openvk.component.video.c.w;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.openvk.component.video.c.w.r;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    private static volatile f sr;

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f25073a;
    private final AtomicBoolean bk;

    /* renamed from: c  reason: collision with root package name */
    private volatile ServerSocket f25074c;
    private final SparseArray<Set<r>> ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.c.w.c.xv f25075f;
    private final r.xv gd;

    /* renamed from: k  reason: collision with root package name */
    private volatile xv f25076k;

    /* renamed from: p  reason: collision with root package name */
    private volatile xv f25077p;

    /* renamed from: r  reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.c.w.c.w f25078r;
    private volatile com.bykv.vk.openvk.component.video.c.w.w.xv ux;

    /* renamed from: w  reason: collision with root package name */
    private volatile int f25079w;
    private final AtomicInteger xv = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c implements Callable<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        private final String f25086c;

        /* renamed from: w  reason: collision with root package name */
        private final int f25087w;

        c(String str, int i4) {
            this.f25086c = str;
            this.f25087w = i4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "call: ");
                socket = new Socket(this.f25086c, this.f25087w);
            } catch (Throwable th2) {
                socket = null;
                th = th2;
            }
            try {
                socket.setSoTimeout(2000);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.component.video.c.xv.c.f25164c));
                outputStream.flush();
                if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    return Boolean.TRUE;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "call: " + th.getMessage());
                    f.w("ping error", Log.getStackTraceString(th));
                    com.bykv.vk.openvk.component.video.c.xv.c.c(socket);
                    return Boolean.FALSE;
                } finally {
                    com.bykv.vk.openvk.component.video.c.xv.c.c(socket);
                }
            }
            com.bykv.vk.openvk.component.video.c.xv.c.c(socket);
            return Boolean.FALSE;
        }
    }

    private f() {
        SparseArray<Set<r>> sparseArray = new SparseArray<>(2);
        this.ev = sparseArray;
        this.gd = new r.xv() { // from class: com.bykv.vk.openvk.component.video.c.w.f.1
            @Override // com.bykv.vk.openvk.component.video.c.w.r.xv
            public void c(r rVar) {
                synchronized (f.this.ev) {
                    Set set = (Set) f.this.ev.get(rVar.f());
                    if (set != null) {
                        set.add(rVar);
                    }
                }
            }

            @Override // com.bykv.vk.openvk.component.video.c.w.r.xv
            public void w(r rVar) {
                if (ux.xv) {
                    Log.d("ProxyServer", "afterExecute, ProxyTask: " + rVar);
                }
                int f4 = rVar.f();
                synchronized (f.this.ev) {
                    Set set = (Set) f.this.ev.get(f4);
                    if (set != null) {
                        set.remove(rVar);
                    }
                }
            }
        };
        this.f25073a = new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.w.f.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i4 = 0;
                    f.this.f25074c = new ServerSocket(0, 50, InetAddress.getByName(f.this.gd()));
                    f fVar = f.this;
                    fVar.f25079w = fVar.f25074c.getLocalPort();
                    if (f.this.f25079w != -1) {
                        p.c(f.this.gd(), f.this.f25079w);
                        if (f.this.r()) {
                            com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "run:  state = ", f.this.xv);
                            if (f.this.xv.compareAndSet(0, 1)) {
                                com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "run:  state = ", f.this.xv);
                                if (ux.xv) {
                                    com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "proxy server start!");
                                }
                                while (f.this.xv.get() == 1) {
                                    try {
                                        try {
                                            Socket accept = f.this.f25074c.accept();
                                            com.bykv.vk.openvk.component.video.c.w.w.xv xvVar = f.this.ux;
                                            if (xvVar != null) {
                                                final r c4 = new r.c().c(xvVar).c(accept).c(f.this.gd).c();
                                                com.bytedance.sdk.component.gd.ev.c().execute(new com.bytedance.sdk.component.gd.p("ProxyTask", 10) { // from class: com.bykv.vk.openvk.component.video.c.w.f.2.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        c4.run();
                                                    }
                                                });
                                            } else {
                                                com.bykv.vk.openvk.component.video.c.xv.c.c(accept);
                                            }
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                            f.w("accept error", Log.getStackTraceString(e4));
                                            i4++;
                                            if (i4 > 3) {
                                                break;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        String stackTraceString = Log.getStackTraceString(th);
                                        Log.e("ProxyServer", "proxy server crashed!  " + stackTraceString);
                                        f.w("error", stackTraceString);
                                    }
                                }
                                if (ux.xv) {
                                    com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "proxy server closed!");
                                }
                                f.this.ux();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    f.w("socket not bound", "");
                    f.this.ux();
                } catch (IOException e5) {
                    if (ux.xv) {
                        Log.e("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e5));
                    }
                    f.w("create ServerSocket error", Log.getStackTraceString(e5));
                    f.this.ux();
                }
            }
        };
        this.bk = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str, String str2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v6 */
    private void ev() {
        Socket socket;
        ?? r02 = 0;
        r02 = 0;
        try {
            try {
                r02 = this.f25074c.accept();
                r02.setSoTimeout(2000);
                boolean equals = "Ping".equals(new BufferedReader(new InputStreamReader(r02.getInputStream())).readLine());
                socket = r02;
                if (equals) {
                    OutputStream outputStream = r02.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.component.video.c.xv.c.f25164c));
                    outputStream.flush();
                    socket = r02;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                w("ping error", Log.getStackTraceString(e4));
                socket = r02;
            }
            com.bykv.vk.openvk.component.video.c.xv.c.c(socket);
            r02 = "ProxyServer";
            com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "answerPing: ");
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.c.xv.c.c((Socket) r02);
            throw th;
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.ev) {
            int size = this.ev.size();
            for (int i4 = 0; i4 < size; i4++) {
                SparseArray<Set<r>> sparseArray = this.ev;
                Set<r> set = sparseArray.get(sparseArray.keyAt(i4));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((r) it.next()).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gd() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        com.bytedance.sdk.component.gd.gd gdVar = new com.bytedance.sdk.component.gd.gd(new c(gd(), this.f25079w), 5, 1);
        com.bytedance.sdk.component.gd.ev.c().submit(gdVar);
        ev();
        try {
            if (!((Boolean) gdVar.get()).booleanValue()) {
                Log.e("ProxyServer", "Ping error");
                w("ping error", "");
                ux();
                return false;
            }
            com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "pingTest: ");
            if (ux.xv) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            w("ping error", Log.getStackTraceString(th));
            ux();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        if (this.xv.compareAndSet(1, 2) || this.xv.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.component.video.c.xv.c.c(this.f25074c);
            f();
        }
    }

    public void sr() {
        if (this.bk.compareAndSet(false, true)) {
            com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(this.f25073a, "r/ProxyServer");
            xvVar.setName("csj_proxy_server");
            xvVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv w() {
        return this.f25077p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv xv() {
        return this.f25076k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i4, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.ev) {
            Set<r> set = this.ev.get(i4);
            if (set != null) {
                for (r rVar : set) {
                    if (rVar != null && str.equals(rVar.ev)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static f c() {
        if (sr == null) {
            synchronized (f.class) {
                if (sr == null) {
                    sr = new f();
                }
            }
        }
        return sr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bykv.vk.openvk.component.video.c.w.w.xv xvVar) {
        this.ux = xvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bykv.vk.openvk.component.video.c.w.c.xv xvVar) {
        this.f25075f = xvVar;
    }

    public String c(boolean z3, boolean z4, String str, String... strArr) {
        String str2;
        if (strArr != null && strArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                w(DomainCampaignEx.LOOPBACK_KEY, "key is empty");
                return strArr[0];
            } else if (this.ux == null) {
                w("db", "VideoProxyDB is null");
                return strArr[0];
            } else {
                if ((z3 ? this.f25078r : this.f25075f) == null) {
                    w("cache", "Cache is null");
                    return strArr[0];
                }
                int i4 = this.xv.get();
                if (i4 != 1) {
                    w("state", "ProxyServer is not running, " + i4);
                    return strArr[0];
                }
                List<String> c4 = com.bykv.vk.openvk.component.video.c.xv.c.c(strArr);
                if (c4 == null) {
                    w("url", "url not start with http/https");
                    return strArr[0];
                }
                String c5 = gd.c(str, z4 ? str : com.bykv.vk.openvk.component.video.api.f.w.c(str), c4);
                if (c5 == null) {
                    w("url", "combine proxy url error");
                    return strArr[0];
                }
                if (z3) {
                    str2 = JPushConstants.HTTPS_PRE + gd() + ":" + this.f25079w + "?f=1&" + c5;
                } else {
                    str2 = JPushConstants.HTTPS_PRE + gd() + ":" + this.f25079w + "?" + c5;
                }
                return str2.replaceFirst("s", "");
            }
        }
        w("url", "url is empty");
        return null;
    }
}
