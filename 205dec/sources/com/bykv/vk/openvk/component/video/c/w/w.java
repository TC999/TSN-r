package com.bykv.vk.openvk.component.video.c.w;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.c.w.a;
import com.bykv.vk.openvk.component.video.c.w.ev;
import com.bykv.vk.openvk.component.video.c.w.gd;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bykv.vk.openvk.component.video.c.w.c {
    final Object bk;
    private final InterfaceC0342w fp;
    private volatile ev.c ia;

    /* renamed from: s  reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.c.w.xv.w f25145s;

    /* renamed from: t  reason: collision with root package name */
    final Object f25146t;
    private final int ys;

    /* renamed from: com.bykv.vk.openvk.component.video.c.w.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0342w {
        void c(w wVar);
    }

    w(c cVar) {
        super(cVar.sr, cVar.ux);
        this.ys = cVar.f25152r;
        this.fp = cVar.gd;
        this.bk = this;
        this.f25051r = cVar.f25149c;
        this.ev = cVar.f25153w;
        this.f25048f = cVar.f25150f;
        this.f25050p = cVar.xv;
        this.gd = cVar.ev;
        this.f25146t = cVar.f25151p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0187, code lost:
        r13 = com.bykv.vk.openvk.component.video.c.w.ux.xv;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0189, code lost:
        if (r13 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018b, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + r5 + ", max: " + r12.ys);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ab, code lost:
        com.bykv.vk.openvk.component.video.c.xv.c.c(r6.sr());
        r4.c();
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01b8, code lost:
        if (r13 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ba, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c6, code lost:
        xv();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cb, code lost:
        if (com.bykv.vk.openvk.component.video.c.w.ux.xv == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cd, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d4, code lost:
        com.bykv.vk.openvk.component.video.c.xv.c.c(r6.sr());
        r4.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01de, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.bykv.vk.openvk.component.video.c.w.a.c r13) throws java.io.IOException, com.bykv.vk.openvk.component.video.c.w.ev.c, com.bykv.vk.openvk.component.video.c.w.xv.c, com.bykv.vk.openvk.component.video.c.w.xv.w {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.c.w.w.c(com.bykv.vk.openvk.component.video.c.w.a$c):void");
    }

    private boolean p() throws com.bykv.vk.openvk.component.video.c.w.xv.c {
        while (this.f25050p.c()) {
            ux();
            a.c w3 = this.f25050p.w();
            try {
                c(w3);
                return true;
            } catch (ev.c e4) {
                this.ia = e4;
                c(Boolean.valueOf(r()), this.f25051r, e4);
                return false;
            } catch (com.bykv.vk.openvk.component.video.c.w.xv.w e5) {
                this.f25145s = e5;
                return false;
            } catch (com.bykv.vk.openvk.component.video.c.w.xv.xv e6) {
                w3.c();
                c(Boolean.valueOf(r()), this.f25051r, e6);
            } catch (IOException e7) {
                if (e7 instanceof SocketTimeoutException) {
                    w3.w();
                }
                if (!w()) {
                    c(Boolean.valueOf(r()), this.f25051r, e7);
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev.c ev() {
        return this.ia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bykv.vk.openvk.component.video.c.w.xv.w gd() {
        return this.f25145s;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f25047c.c(this.ev);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            p();
        } catch (Throwable unused) {
        }
        this.sr.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f25047c.w(this.ev);
        InterfaceC0342w interfaceC0342w = this.fp;
        if (interfaceC0342w != null) {
            interfaceC0342w.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        String f25149c;
        gd ev;

        /* renamed from: f  reason: collision with root package name */
        List<gd.w> f25150f;
        InterfaceC0342w gd;

        /* renamed from: p  reason: collision with root package name */
        Object f25151p;

        /* renamed from: r  reason: collision with root package name */
        int f25152r;
        com.bykv.vk.openvk.component.video.c.w.c.c sr;
        com.bykv.vk.openvk.component.video.c.w.w.xv ux;

        /* renamed from: w  reason: collision with root package name */
        String f25153w;
        a xv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f25149c = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c w(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f25153w = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(a aVar) {
            if (aVar != null) {
                this.xv = aVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(com.bykv.vk.openvk.component.video.c.w.c.c cVar) {
            if (cVar != null) {
                this.sr = cVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(com.bykv.vk.openvk.component.video.c.w.w.xv xvVar) {
            if (xvVar != null) {
                this.ux = xvVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(List<gd.w> list) {
            this.f25150f = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(int i4) {
            this.f25152r = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(InterfaceC0342w interfaceC0342w) {
            this.gd = interfaceC0342w;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(gd gdVar) {
            this.ev = gdVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(Object obj) {
            this.f25151p = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public w c() {
            if (this.sr != null && this.ux != null && !TextUtils.isEmpty(this.f25149c) && !TextUtils.isEmpty(this.f25153w) && this.xv != null) {
                return new w(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
