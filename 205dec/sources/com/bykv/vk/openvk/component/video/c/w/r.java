package com.bykv.vk.openvk.component.video.c.w;

import android.util.Log;
import com.bykv.vk.openvk.component.video.c.w.a;
import com.bykv.vk.openvk.component.video.c.w.ev;
import com.bykv.vk.openvk.component.video.c.w.gd;
import com.bykv.vk.openvk.component.video.c.w.w;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bykv.vk.openvk.component.video.c.w.c {
    private final Socket bk;
    private volatile com.bykv.vk.openvk.component.video.c.w.w fp;
    private volatile boolean ia;

    /* renamed from: t  reason: collision with root package name */
    private final xv f25107t;
    private final sr ys;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        private final OutputStream f25113c;

        /* renamed from: w  reason: collision with root package name */
        private int f25114w;
        private boolean xv;

        w(OutputStream outputStream, int i4) {
            this.f25113c = outputStream;
            this.f25114w = i4;
        }

        boolean c() {
            return this.xv;
        }

        void w(byte[] bArr, int i4, int i5) throws com.bykv.vk.openvk.component.video.c.w.xv.sr {
            try {
                this.f25113c.write(bArr, i4, i5);
                this.f25114w += i5;
            } catch (IOException e4) {
                throw new com.bykv.vk.openvk.component.video.c.w.xv.sr(e4);
            }
        }

        void c(byte[] bArr, int i4, int i5) throws com.bykv.vk.openvk.component.video.c.w.xv.sr {
            if (this.xv) {
                return;
            }
            try {
                this.f25113c.write(bArr, i4, i5);
                this.xv = true;
            } catch (IOException e4) {
                throw new com.bykv.vk.openvk.component.video.c.w.xv.sr(e4);
            }
        }

        int w() {
            return this.f25114w;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface xv {
        void c(r rVar);

        void w(r rVar);
    }

    r(c cVar) {
        super(cVar.f25111c, cVar.f25112w);
        this.ia = true;
        this.bk = cVar.xv;
        this.f25107t = cVar.sr;
        this.ys = sr.xv();
    }

    private void c(boolean z3, int i4, int i5, int i6, int i7) {
    }

    private w ev() {
        try {
            this.gd = gd.c(this.bk.getInputStream());
            OutputStream outputStream = this.bk.getOutputStream();
            com.bykv.vk.openvk.component.video.c.w.c.c cVar = this.gd.xv.f25097c == 1 ? ux.f25133c : ux.f25138w;
            if (cVar == null) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.f25047c = cVar;
            this.f25051r = this.gd.xv.f25100w;
            this.ev = this.gd.xv.xv;
            this.f25050p = new a(this.gd.xv.f25099r);
            this.f25048f = this.gd.f25096w;
            if (ux.xv) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.gd.toString());
            }
            return new w(outputStream, this.gd.xv.sr);
        } catch (gd.sr e4) {
            com.bykv.vk.openvk.component.video.c.xv.c.c(this.bk);
            if (ux.xv) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
            }
            c(this.f25047c == null ? null : Boolean.valueOf(r()), this.f25051r, e4);
            return null;
        } catch (IOException e5) {
            com.bykv.vk.openvk.component.video.c.xv.c.c(this.bk);
            if (ux.xv) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
            }
            c(this.f25047c == null ? null : Boolean.valueOf(r()), this.f25051r, e5);
            return null;
        }
    }

    private void gd() {
        com.bykv.vk.openvk.component.video.c.w.w wVar = this.fp;
        this.fp = null;
        if (wVar != null) {
            wVar.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ad A[EDGE_INSN: B:101:0x01ad->B:70:0x01ad ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104 A[Catch: all -> 0x01d9, TRY_LEAVE, TryCatch #4 {all -> 0x01d9, blocks: (B:30:0x00ef, B:37:0x0100, B:39:0x0104, B:45:0x014e, B:49:0x0160, B:48:0x015e, B:36:0x00fc), top: B:97:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e A[Catch: all -> 0x01d9, TryCatch #4 {all -> 0x01d9, blocks: (B:30:0x00ef, B:37:0x0100, B:39:0x0104, B:45:0x014e, B:49:0x0160, B:48:0x015e, B:36:0x00fc), top: B:97:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f A[Catch: all -> 0x01d5, TryCatch #1 {all -> 0x01d5, blocks: (B:51:0x0169, B:53:0x016f, B:55:0x0174, B:68:0x01a2, B:69:0x01a9, B:70:0x01ad, B:72:0x01b1, B:73:0x01b6, B:58:0x017a), top: B:93:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1 A[Catch: all -> 0x01d5, TryCatch #1 {all -> 0x01d5, blocks: (B:51:0x0169, B:53:0x016f, B:55:0x0174, B:68:0x01a2, B:69:0x01a9, B:70:0x01ad, B:72:0x01b1, B:73:0x01b6, B:58:0x017a), top: B:93:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sr(com.bykv.vk.openvk.component.video.c.w.r.w r13, com.bykv.vk.openvk.component.video.c.w.a.c r14) throws com.bykv.vk.openvk.component.video.c.w.xv.sr, java.io.IOException, com.bykv.vk.openvk.component.video.c.w.xv.c, com.bykv.vk.openvk.component.video.c.w.xv.w {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.c.w.r.sr(com.bykv.vk.openvk.component.video.c.w.r$w, com.bykv.vk.openvk.component.video.c.w.a$c):void");
    }

    private void w(w wVar, a.c cVar) throws IOException, com.bykv.vk.openvk.component.video.c.w.xv.sr {
        byte[] c4 = c(this.f25053w.query(this.ev, this.gd.xv.f25097c), wVar, cVar);
        if (c4 == null) {
            return;
        }
        wVar.c(c4, 0, c4.length);
    }

    private void xv(w wVar, a.c cVar) throws ev.c, com.bykv.vk.openvk.component.video.c.w.xv.sr, IOException, com.bykv.vk.openvk.component.video.c.w.xv.c, com.bykv.vk.openvk.component.video.c.w.xv.w {
        if (this.ia) {
            File xv2 = this.f25047c.xv(this.ev);
            long length = xv2.length();
            com.bykv.vk.openvk.component.video.c.w.w.c query = this.f25053w.query(this.ev, this.gd.xv.f25097c);
            int w3 = wVar.w();
            long j4 = length - w3;
            int i4 = (int) j4;
            int i5 = query == null ? -1 : query.xv;
            if (length > wVar.w()) {
                if (ux.xv) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j4);
                }
                c(true, i4, i5, (int) length, w3);
                c(query, xv2, wVar, cVar);
                return;
            }
            c(false, i4, i5, (int) length, w3);
        } else {
            c(false, 0, 0, 0, wVar.w());
        }
        sr(wVar, cVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.component.video.c.w.w.c query;
        w ev = ev();
        if (ev == null) {
            return;
        }
        xv xvVar = this.f25107t;
        if (xvVar != null) {
            xvVar.c(this);
        }
        this.f25047c.c(this.ev);
        if (ux.ev != 0 && ((query = this.f25053w.query(this.ev, this.gd.xv.f25097c)) == null || this.f25047c.xv(this.ev).length() < query.xv)) {
            this.ys.c(r(), this.ev);
        }
        try {
            c(ev);
        } catch (com.bykv.vk.openvk.component.video.c.w.xv.c e4) {
            if (ux.xv) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
            }
        } catch (Throwable th) {
            if (ux.xv) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.f25047c.w(this.ev);
        this.ys.c(r(), null);
        c();
        com.bykv.vk.openvk.component.video.c.xv.c.c(this.bk);
        xv xvVar2 = this.f25107t;
        if (xvVar2 != null) {
            xvVar2.w(this);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class c {

        /* renamed from: c  reason: collision with root package name */
        com.bykv.vk.openvk.component.video.c.w.c.c f25111c;
        xv sr;

        /* renamed from: w  reason: collision with root package name */
        com.bykv.vk.openvk.component.video.c.w.w.xv f25112w;
        Socket xv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(com.bykv.vk.openvk.component.video.c.w.w.xv xvVar) {
            if (xvVar != null) {
                this.f25112w = xvVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(Socket socket) {
            if (socket != null) {
                this.xv = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c(xv xvVar) {
            this.sr = xvVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public r c() {
            if (this.f25112w != null && this.xv != null) {
                return new r(this);
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean c(w wVar) throws com.bykv.vk.openvk.component.video.c.w.xv.c {
        while (this.f25050p.c()) {
            ux();
            a.c w3 = this.f25050p.w();
            try {
                c(wVar, w3);
                return true;
            } catch (ev.c e4) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                }
                this.ia = false;
                c(Boolean.valueOf(r()), this.f25051r, e4);
            } catch (com.bykv.vk.openvk.component.video.c.w.xv.sr e5) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return true;
            } catch (com.bykv.vk.openvk.component.video.c.w.xv.w e6) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
                return false;
            } catch (com.bykv.vk.openvk.component.video.c.w.xv.xv e7) {
                w3.c();
                c(Boolean.valueOf(r()), this.f25051r, e7);
            } catch (IOException e8) {
                if (e8 instanceof SocketTimeoutException) {
                    w3.w();
                }
                if (w()) {
                    if (ux.xv) {
                        if ("Canceled".equalsIgnoreCase(e8.getMessage())) {
                            Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e8));
                        }
                    }
                } else {
                    c(Boolean.valueOf(r()), this.f25051r, e8);
                }
            } catch (Exception e9) {
                if (ux.xv) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e9));
                }
            }
        }
        return false;
    }

    private void c(w wVar, a.c cVar) throws com.bykv.vk.openvk.component.video.c.w.xv.sr, IOException, ev.c, com.bykv.vk.openvk.component.video.c.w.xv.c, com.bykv.vk.openvk.component.video.c.w.xv.w {
        if ("HEAD".equalsIgnoreCase(this.gd.f25095c.f25103c)) {
            w(wVar, cVar);
        } else {
            xv(wVar, cVar);
        }
    }

    private byte[] c(com.bykv.vk.openvk.component.video.c.w.w.c cVar, w wVar, a.c cVar2) throws IOException {
        if (cVar != null) {
            if (ux.xv) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.c.xv.c.c(cVar, wVar.w()).getBytes(com.bykv.vk.openvk.component.video.c.xv.c.f25164c);
        }
        com.bykv.vk.openvk.component.video.c.w.ux.c c4 = c(cVar2, 0, -1, "HEAD");
        if (c4 == null) {
            return null;
        }
        try {
            String c5 = com.bykv.vk.openvk.component.video.c.xv.c.c(c4, false, false);
            if (c5 == null) {
                com.bykv.vk.openvk.component.video.c.w.w.c c6 = com.bykv.vk.openvk.component.video.c.xv.c.c(c4, this.f25053w, this.ev, this.gd.xv.f25097c);
                if (ux.xv) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                return com.bykv.vk.openvk.component.video.c.xv.c.c(c6, wVar.w()).getBytes(com.bykv.vk.openvk.component.video.c.xv.c.f25164c);
            }
            throw new com.bykv.vk.openvk.component.video.c.w.xv.xv(c5 + ", rawKey: " + this.f25051r + ", url: " + cVar2);
        } finally {
            com.bykv.vk.openvk.component.video.c.xv.c.c(c4.sr());
        }
    }

    private void c(com.bykv.vk.openvk.component.video.c.w.w.c cVar, File file, w wVar, a.c cVar2) throws IOException, com.bykv.vk.openvk.component.video.c.w.xv.sr, ev.c, com.bykv.vk.openvk.component.video.c.w.xv.c, com.bykv.vk.openvk.component.video.c.w.xv.w {
        final com.bytedance.sdk.component.gd.gd gdVar;
        ev evVar;
        com.bykv.vk.openvk.component.video.c.w.w wVar2;
        if (!wVar.c()) {
            byte[] c4 = c(cVar, wVar, cVar2);
            ux();
            if (c4 == null) {
                return;
            }
            wVar.c(c4, 0, c4.length);
        }
        ev evVar2 = null;
        if (cVar == null && (cVar = this.f25053w.query(this.ev, this.gd.xv.f25097c)) == null) {
            if (ux.xv) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            c((com.bykv.vk.openvk.component.video.c.w.w.c) null, wVar, cVar2);
            cVar = this.f25053w.query(this.ev, this.gd.xv.f25097c);
            if (cVar == null) {
                throw new com.bykv.vk.openvk.component.video.c.w.xv.xv("failed to get header, rawKey: " + this.f25051r + ", url: " + cVar2);
            }
        }
        if (file.length() >= cVar.xv || !((wVar2 = this.fp) == null || wVar2.w() || wVar2.sr())) {
            gdVar = null;
        } else {
            com.bykv.vk.openvk.component.video.c.w.w c5 = new w.c().c(this.f25047c).c(this.f25053w).c(this.f25051r).w(this.ev).c(new a(cVar2.f25044c)).c(this.f25048f).c(this.gd).c(new w.InterfaceC0342w() { // from class: com.bykv.vk.openvk.component.video.c.w.r.1
                @Override // com.bykv.vk.openvk.component.video.c.w.w.InterfaceC0342w
                public void c(com.bykv.vk.openvk.component.video.c.w.w wVar3) {
                    r.this.xv.addAndGet(wVar3.xv.get());
                    r.this.sr.addAndGet(wVar3.sr.get());
                    synchronized (wVar3.bk) {
                        wVar3.bk.notifyAll();
                    }
                    if (wVar3.sr()) {
                        r.this.ys.c(r.this.r(), null);
                    }
                }
            }).c();
            this.fp = c5;
            gdVar = new com.bytedance.sdk.component.gd.gd(c5, null, 10, 1);
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.component.video.c.w.r.2
                @Override // java.lang.Runnable
                public void run() {
                    gdVar.run();
                }
            });
            if (ux.xv) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            evVar = new ev(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            evVar.c(wVar.w());
            int min = this.gd.xv.ux > 0 ? Math.min(cVar.xv, this.gd.xv.ux) : cVar.xv;
            while (wVar.w() < min) {
                ux();
                int c6 = evVar.c(bArr);
                if (c6 <= 0) {
                    com.bykv.vk.openvk.component.video.c.w.w wVar3 = this.fp;
                    if (wVar3 != null) {
                        com.bykv.vk.openvk.component.video.c.w.xv.w gd = wVar3.gd();
                        if (gd == null) {
                            ev.c ev = wVar3.ev();
                            if (ev != null) {
                                throw ev;
                            }
                        } else {
                            throw gd;
                        }
                    }
                    if (wVar3 != null && !wVar3.w() && !wVar3.sr()) {
                        ux();
                        synchronized (wVar3.bk) {
                            try {
                                wVar3.bk.wait(1000L);
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (ux.xv) {
                        Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                    }
                    throw new com.bykv.vk.openvk.component.video.c.w.xv.xv("illegal state download task has finished, rawKey: " + this.f25051r + ", url: " + cVar2);
                }
                wVar.w(bArr, 0, c6);
                ux();
            }
            if (ux.xv) {
                Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + wVar.w() + ", " + min);
            }
            xv();
            evVar.c();
            if (gdVar != null) {
                try {
                    gdVar.get();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            evVar2 = evVar;
            if (evVar2 != null) {
                evVar2.c();
            }
            if (gdVar != null) {
                try {
                    gdVar.get();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.c
    public void c() {
        super.c();
        gd();
    }
}
