package com.bykv.vk.openvk.component.video.c.sr;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.c;
import com.bykv.vk.openvk.component.video.c.sr.xv;
import com.bytedance.sdk.component.utils.n;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bykv.vk.openvk.component.video.api.c, xv.c, xv.f, xv.r, xv.sr, xv.ux, xv.w, xv.InterfaceC0337xv, n.c {
    private static final SparseIntArray ls = new SparseIntArray();
    private n bk;

    /* renamed from: c  reason: collision with root package name */
    private SurfaceTexture f24996c;
    private boolean gb;
    private boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Runnable> f24998i;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25002p;
    private int sr;

    /* renamed from: u  reason: collision with root package name */
    private boolean f25007u;

    /* renamed from: w  reason: collision with root package name */
    private SurfaceHolder f25008w;
    private volatile boolean yu;
    private int xv = 0;
    private boolean ux = false;

    /* renamed from: f  reason: collision with root package name */
    private volatile xv f24997f = null;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f25004r = false;
    private boolean ev = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f25000k = 201;

    /* renamed from: a  reason: collision with root package name */
    private long f24995a = -1;

    /* renamed from: t  reason: collision with root package name */
    private boolean f25006t = false;
    private long ys = 0;
    private long fp = Long.MIN_VALUE;
    private long ia = 0;

    /* renamed from: s  reason: collision with root package name */
    private long f25005s = 0;
    private long fz = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f25003q = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f24999j = "0";

    /* renamed from: n  reason: collision with root package name */
    private final List<WeakReference<c.InterfaceC0334c>> f25001n = new CopyOnWriteArrayList();
    private com.bykv.vk.openvk.component.video.api.xv.sr ck = null;

    /* renamed from: z  reason: collision with root package name */
    private boolean f25010z = false;
    private CountDownLatch ba = new CountDownLatch(1);

    /* renamed from: y  reason: collision with root package name */
    private volatile int f25009y = 200;
    private AtomicBoolean eq = new AtomicBoolean(false);
    private Surface me = null;
    private final Runnable wv = new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.1
        @Override // java.lang.Runnable
        public void run() {
            if (sr.this.f24997f == null) {
                return;
            }
            long fz = sr.this.fz();
            if (fz > 0 && Build.VERSION.SDK_INT >= 23 && sr.this.bk() && sr.this.fp != Long.MIN_VALUE) {
                try {
                    if (sr.this.fp == fz) {
                        if (!sr.this.f25006t && sr.this.ia >= 400) {
                            sr.this.w(701, 800);
                            sr.this.f25006t = true;
                        }
                        sr.this.ia += sr.this.f25009y;
                    } else {
                        if (sr.this.f25006t) {
                            sr.this.ys += sr.this.ia;
                            sr.this.w(702, 800);
                            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(sr.this.ys), "  bufferCount =", Integer.valueOf(sr.this.xv));
                        }
                        sr.this.ia = 0L;
                        sr.this.f25006t = false;
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (sr.this.s() > 0) {
                if (sr.this.fp != fz) {
                    if (com.bykv.vk.openvk.component.video.api.xv.sr()) {
                        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(sr.this.fp), "  curPosition = ", Long.valueOf(fz));
                    }
                    sr srVar = sr.this;
                    srVar.c(fz, srVar.s());
                }
                sr.this.fp = fz;
            }
            if (!sr.this.gd()) {
                if (sr.this.bk != null) {
                    sr.this.bk.postDelayed(this, sr.this.f25009y);
                    return;
                }
                return;
            }
            sr srVar2 = sr.this;
            srVar2.c(srVar2.s(), sr.this.s());
        }
    };
    private final c xk = new c();
    private long wx = 0;
    private long pr = 0;
    private boolean bw = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c implements Runnable {

        /* renamed from: w  reason: collision with root package name */
        private long f25033w;
        private boolean xv;

        c() {
        }

        public void c(boolean z3) {
            this.xv = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sr.this.f24997f != null) {
                try {
                    if (!this.xv) {
                        long gd = sr.this.f24997f.gd();
                        sr.this.f24995a = Math.max(this.f25033w, gd);
                    }
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start, OpStartTask:" + sr.this.f24995a);
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th);
                }
            }
            if (sr.this.bk != null) {
                sr.this.bk.sendEmptyMessageDelayed(100, 0L);
            }
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
        }

        public void c(long j4) {
            this.f25033w = j4;
        }
    }

    public sr() {
        c("SSMediaPlayerWrapper");
    }

    private void ba() {
        n nVar = this.bk;
        if (nVar != null) {
            nVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        sr.this.f24997f.r();
                        sr.this.f25000k = 207;
                        sr.this.yu = false;
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "pauseBeforePlayIfNeed error: ", th);
                    }
                }
            });
        }
    }

    private void ck() {
        SparseIntArray sparseIntArray = ls;
        Integer valueOf = Integer.valueOf(sparseIntArray.get(this.f25003q));
        if (valueOf == null) {
            sparseIntArray.put(this.f25003q, 1);
        } else {
            sparseIntArray.put(this.f25003q, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    private void eq() {
        ArrayList<Runnable> arrayList = this.f24998i;
        boolean z3 = arrayList == null || arrayList.isEmpty();
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "isPendingAction:" + z3);
        if (z3) {
            return;
        }
        y();
    }

    private void gb() {
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.f24997f == null) {
            return;
        }
        try {
            this.f24997f.a();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "releaseMediaplayer error1: ", th);
        }
        this.f24997f.c((xv.w) null);
        this.f24997f.c((xv.r) null);
        this.f24997f.c((xv.c) null);
        this.f24997f.c((xv.sr) null);
        this.f24997f.c((xv.InterfaceC0337xv) null);
        this.f24997f.c((xv.ux) null);
        this.f24997f.c((xv.f) null);
        try {
            this.f24997f.k();
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "releaseMediaplayer error2: ", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        StringBuilder sb = new StringBuilder();
        sb.append("initMediaPlayer: ");
        sb.append(this.bk != null);
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", sb.toString());
        n nVar = this.bk;
        if (nVar != null) {
            nVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.10
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.f24997f == null) {
                        try {
                            sr.this.f24997f = new w();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (sr.this.f24997f == null) {
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("initMediaPlayer mMediaPlayer is null :");
                        sb2.append(sr.this.f24997f == null);
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", sb2.toString());
                        sr.this.f24999j = "0";
                        sr.this.f24997f.c((xv.ux) sr.this);
                        sr.this.f24997f.c((xv.w) sr.this);
                        sr.this.f24997f.c((xv.InterfaceC0337xv) sr.this);
                        sr.this.f24997f.c((xv.c) sr.this);
                        sr.this.f24997f.c((xv.f) sr.this);
                        sr.this.f24997f.c((xv.sr) sr.this);
                        sr.this.f24997f.c((xv.r) sr.this);
                        try {
                            sr.this.f24997f.xv(false);
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setLooping error: ", th2);
                        }
                        sr.this.ev = false;
                    }
                }
            });
        }
    }

    private void ls() {
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke !");
        w(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.14
            @Override // java.lang.Runnable
            public void run() {
                if (sr.this.bk != null) {
                    sr.this.bk.sendEmptyMessage(104);
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    private void me() {
        ArrayList<Runnable> arrayList = this.f24998i;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f24998i.clear();
    }

    private void n() {
        n nVar = this.bk;
        if (nVar == null || nVar.getLooper() == null) {
            return;
        }
        this.bk.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.6
            @Override // java.lang.Runnable
            public void run() {
                if (sr.this.bk == null || sr.this.bk.getLooper() == null) {
                    return;
                }
                try {
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "onDestory............");
                    com.bytedance.sdk.component.gd.w.c.c().c(sr.this.bk);
                    sr.this.bk = null;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "onDestroy error: ", th);
                }
            }
        });
    }

    private void q() {
        this.ys = 0L;
        this.xv = 0;
        this.ia = 0L;
        this.f25006t = false;
        this.fp = Long.MIN_VALUE;
    }

    private void y() {
        if (this.gd) {
            return;
        }
        this.gd = true;
        Iterator it = new ArrayList(this.f24998i).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f24998i.clear();
        this.gd = false;
    }

    private void z() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.fz;
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this, elapsedRealtime);
            }
        }
        this.ux = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int a() {
        if (this.f24997f == null || ys()) {
            return 0;
        }
        return this.f24997f.t();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean bk() {
        n nVar;
        return (this.f25000k == 206 || ((nVar = this.bk) != null && nVar.hasMessages(100))) && !this.yu;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long fp() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f25006t) {
                long j4 = this.ia;
                if (j4 > 0) {
                    return this.ys + j4;
                }
            }
            return this.ys;
        }
        return this.pr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long fz() {
        if (ys()) {
            return 0L;
        }
        if (this.f25000k == 206 || this.f25000k == 207) {
            try {
                return this.f24997f.gd();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public boolean i() {
        return this.f25000k == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int ia() {
        return this.xv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public long s() {
        long j4 = this.f25005s;
        if (j4 != 0) {
            return j4;
        }
        if (this.f25000k == 206 || this.f25000k == 207) {
            try {
                this.f25005s = this.f24997f.p();
            } catch (Throwable unused) {
            }
        }
        return this.f25005s;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean t() {
        n nVar;
        return ((this.f25000k != 207 && !this.yu) || (nVar = this.bk) == null || nVar.hasMessages(100)) ? false : true;
    }

    public int u() {
        if (ys()) {
            return 203;
        }
        return this.f25000k;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean ys() {
        return this.f25002p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public SurfaceTexture ev() {
        return this.f24996c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean f() {
        return this.ux;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean gd() {
        return this.f25000k == 209;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public int k() {
        if (this.f24997f == null || ys()) {
            return 0;
        }
        return this.f24997f.bk();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public boolean p() {
        return i() || bk() || t();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public SurfaceHolder r() {
        return this.f25008w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void ux() {
        if (ys()) {
            return;
        }
        this.f25002p = true;
        me();
        n nVar = this.bk;
        if (nVar != null) {
            try {
                nVar.removeCallbacksAndMessages(null);
                if (this.f24997f != null) {
                    this.bk.sendEmptyMessage(103);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void sr() {
        if (ys()) {
            return;
        }
        w(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.15
            @Override // java.lang.Runnable
            public void run() {
                if (sr.this.bk != null) {
                    sr.this.bk.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w(final boolean z3) {
        if (ys()) {
            return;
        }
        this.gb = z3;
        if (this.f24997f != null) {
            this.f24997f.c(z3);
            return;
        }
        n nVar = this.bk;
        if (nVar != null) {
            nVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.9
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.f24997f != null) {
                        sr.this.f24997f.c(z3);
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void xv() {
        n nVar;
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (ys() || (nVar = this.bk) == null) {
            return;
        }
        nVar.removeMessages(100);
        this.yu = true;
        if (!this.bw) {
            if (!this.f25007u && !w(this.ck)) {
                c(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (sr.this.bk != null) {
                            sr.this.bk.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            }
            n nVar2 = this.bk;
            if (nVar2 != null) {
                nVar2.sendEmptyMessage(101);
            }
        } else if (!this.ux && !w(this.ck)) {
            c(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.13
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.bk != null) {
                        sr.this.bk.sendEmptyMessage(101);
                    }
                }
            });
        } else {
            n nVar3 = this.bk;
            if (nVar3 != null) {
                nVar3.sendEmptyMessage(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4, long j5) {
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this, j4, j5);
            }
        }
    }

    private void w(long j4) {
        this.xk.c(j4);
        if (this.gb) {
            w(this.xk);
        } else if (w(this.ck)) {
            w(this.xk);
        } else {
            c(this.xk);
        }
    }

    private void c(String str) {
        this.f25003q = 0;
        com.bytedance.sdk.component.gd.w.c c4 = com.bytedance.sdk.component.gd.w.c.c();
        this.bk = c4.c(this, "csj_" + str);
        this.bw = true;
        j();
    }

    private boolean w(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        return srVar != null && srVar.r();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c() {
        if (ys()) {
            return;
        }
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] MediaPlayerProxy#restart:" + this.f25000k);
        if (this.f24997f == null) {
            return;
        }
        this.eq.set(true);
        if (this.f25000k != 206) {
            q();
            this.yu = false;
            this.xk.c(true);
            w(0L);
            n nVar = this.bk;
            if (nVar != null) {
                nVar.removeCallbacks(this.wv);
                this.bk.postDelayed(this.wv, this.f25009y);
            }
        }
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "start:end");
        this.ba.countDown();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w() {
        if (ys() || this.bk == null) {
            return;
        }
        this.eq.set(true);
        this.bk.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.11
            @Override // java.lang.Runnable
            public void run() {
                if (!sr.this.t() || sr.this.f24997f == null) {
                    return;
                }
                try {
                    sr.this.f24997f.ux();
                    com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : sr.this.f25001n) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((c.InterfaceC0334c) weakReference.get()).ux(sr.this);
                        }
                    }
                    sr.this.f25000k = 206;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.f
    public void xv(xv xvVar) {
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c((com.bykv.vk.openvk.component.video.api.c) this, true);
            }
        }
    }

    private void w(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f24997f.c(fileInputStream.getFD());
        fileInputStream.close();
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.sr
    public boolean w(xv xvVar, int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_MEDIA", "what,extra:" + i4 + "," + i5);
        if (this.f24997f != xvVar) {
            return false;
        }
        if (i5 == -1004) {
            com.bykv.vk.openvk.component.video.api.xv.w wVar = new com.bykv.vk.openvk.component.video.api.xv.w(i4, i5);
            for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().c(this, wVar);
                }
            }
        }
        w(i4, i5);
        return false;
    }

    public sr(String str) {
        c("mda_" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4, int i5) {
        if (i4 == 701) {
            this.wx = SystemClock.elapsedRealtime();
            this.xv++;
            for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().c(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.xv));
        } else if (i4 == 702) {
            if (this.wx > 0) {
                this.pr += SystemClock.elapsedRealtime() - this.wx;
                this.wx = 0L;
            }
            for (WeakReference<c.InterfaceC0334c> weakReference2 : this.f25001n) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().c((com.bykv.vk.openvk.component.video.api.c) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.xv), " mBufferTotalTime = ", Long.valueOf(this.pr));
        } else if (this.bw && i4 == 3) {
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.yu);
            eq();
            z();
            c(this.f25010z);
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(boolean z3, long j4, boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append("[video] MediaPlayerProxy#start firstSeekToPosition=");
        sb.append(j4);
        sb.append(",isFirst :");
        sb.append(z3);
        sb.append(",isPauseOtherMusicVolume=");
        sb.append(z4);
        sb.append(" ");
        sb.append(this.f25000k);
        sb.append(" ");
        sb.append(this.f24997f == null);
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", sb.toString());
        if (ys()) {
            return;
        }
        j();
        this.f25010z = z4;
        this.eq.set(true);
        this.yu = false;
        c(z4);
        if (z3) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] first start , SSMediaPlayer  start method !");
            this.f24995a = j4;
            ls();
        } else {
            w(j4);
        }
        n nVar = this.bk;
        if (nVar != null) {
            nVar.removeCallbacks(this.wv);
            this.bk.postDelayed(this.wv, this.f25009y);
        }
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "start:end");
        this.ba.countDown();
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final long j4) {
        if (ys()) {
            return;
        }
        if (this.f25000k == 207 || this.f25000k == 206 || this.f25000k == 209) {
            w(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.2
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.bk != null) {
                        sr.this.bk.obtainMessage(106, Long.valueOf(j4)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final SurfaceTexture surfaceTexture) {
        if (ys()) {
            return;
        }
        this.f24996c = surfaceTexture;
        w(true);
        w(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.3
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setSurface() runnable exec");
                sr.this.j();
                if (sr.this.bk != null) {
                    sr.this.bk.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.ux
    public void w(xv xvVar) {
        if (ys()) {
            return;
        }
        this.f25000k = 205;
        try {
            com.bykv.vk.openvk.component.video.api.xv.sr srVar = this.ck;
            if (srVar != null) {
                float ys = srVar.ys();
                if (ys > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.w wVar = new com.bykv.vk.openvk.component.video.api.w();
                    wVar.c(ys);
                    this.f24997f.c(wVar);
                }
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "speed error: ", th);
        }
        if (this.bk != null) {
            if (this.yu) {
                ba();
            } else {
                com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                n nVar = this.bk;
                nVar.sendMessage(nVar.obtainMessage(100, -1, -1));
            }
        }
        ls.delete(this.f25003q);
        com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_MEDIA", "onPrepared:" + this.bw + " " + this.f25007u);
        if (!this.bw && !this.f25007u) {
            z();
            this.f25007u = true;
        }
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().w(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final SurfaceHolder surfaceHolder) {
        if (ys()) {
            return;
        }
        this.f25008w = surfaceHolder;
        w(true);
        w(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.4
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDisplay() runnable exec");
                sr.this.j();
                if (sr.this.bk != null) {
                    sr.this.bk.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        if (ys()) {
            return;
        }
        this.ck = srVar;
        if (srVar != null) {
            this.bw = this.bw && !srVar.r();
        }
        w(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.5
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDataSource() runnable exec ");
                sr.this.j();
                if (sr.this.bk != null) {
                    sr.this.bk.obtainMessage(107, srVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        int i4 = this.f25000k;
        int i5 = message.what;
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video]  execute , mCurrentState = " + this.f25000k + " handlerMsg=" + i5);
        boolean z3 = false;
        if (this.f24997f != null) {
            switch (message.what) {
                case 100:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_START");
                    if (this.f25000k == 205 || this.f25000k == 207 || this.f25000k == 209) {
                        try {
                            this.f24997f.ux();
                            this.fz = SystemClock.elapsedRealtime();
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f25000k = 206;
                            if (this.f24995a > 0) {
                                com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] OP_START, seekTo:" + this.f24995a);
                                this.f24997f.c(this.f24995a, this.sr);
                                this.f24995a = -1L;
                            }
                            if (this.ck != null) {
                                c(this.f25010z);
                                break;
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_START error: ", th);
                            break;
                        }
                    }
                    z3 = true;
                    break;
                case 101:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_PAUSE");
                    if (this.f25006t) {
                        this.ys += this.ia;
                    }
                    this.f25006t = false;
                    this.ia = 0L;
                    this.fp = Long.MIN_VALUE;
                    if (this.f25000k == 206 || this.f25000k == 207 || this.f25000k == 209) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f24997f.r();
                            this.f25000k = 207;
                            this.yu = false;
                            for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get().sr(this);
                                }
                            }
                            break;
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_PAUSE error: ", th2);
                            break;
                        }
                    }
                    z3 = true;
                    break;
                case 102:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_RESET");
                    try {
                        this.f24997f.a();
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] OP_RESET execute!");
                        this.f25000k = 201;
                        break;
                    } catch (Throwable th3) {
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_RESET error: ", th3);
                        break;
                    }
                case 103:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_RELEASE");
                    try {
                        gb();
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th4) {
                        com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th4);
                    }
                    for (WeakReference<c.InterfaceC0334c> weakReference2 : this.f25001n) {
                        if (weakReference2 != null && weakReference2.get() != null) {
                            weakReference2.get().xv(this);
                        }
                    }
                    this.f25000k = 203;
                    break;
                case 104:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC");
                    if (this.f25000k == 202 || this.f25000k == 208) {
                        try {
                            this.f24997f.ev();
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            break;
                        } catch (Throwable th5) {
                            com.bykv.vk.openvk.component.video.api.f.xv.xv("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th5);
                            break;
                        }
                    }
                    z3 = true;
                    break;
                case 105:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_STOP");
                    if (this.f25000k == 205 || this.f25000k == 206 || this.f25000k == 208 || this.f25000k == 207 || this.f25000k == 209) {
                        try {
                            this.f24997f.f();
                            this.f25000k = 208;
                            break;
                        } catch (Throwable th6) {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_STOP error: ", th6);
                            break;
                        }
                    }
                    z3 = true;
                    break;
                case 106:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SEEKTO");
                    if (this.f25000k == 206 || this.f25000k == 207 || this.f25000k == 209) {
                        try {
                            this.f24997f.c(((Long) message.obj).longValue(), this.sr);
                            break;
                        } catch (Throwable th7) {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SEEKTO error: ", th7);
                            break;
                        }
                    }
                    z3 = true;
                    break;
                case 107:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SET_DATASOURCE");
                    q();
                    if (this.f25000k == 201 || this.f25000k == 203) {
                        try {
                            com.bykv.vk.openvk.component.video.api.xv.sr srVar = (com.bykv.vk.openvk.component.video.api.xv.sr) message.obj;
                            if (TextUtils.isEmpty(srVar.ux())) {
                                srVar.c(com.bykv.vk.openvk.component.video.api.xv.c());
                            }
                            File file = new File(srVar.ux(), srVar.ia());
                            if (file.exists()) {
                                com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDataSource\uff1a try paly local:" + file.getAbsolutePath());
                                if (com.bykv.vk.openvk.component.video.api.xv.w()) {
                                    w(file.getAbsolutePath());
                                } else {
                                    this.f24997f.c(file.getAbsolutePath());
                                }
                            } else {
                                com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDataSource\uff1a paly net:" + srVar.fp());
                                if (srVar.f24957w == 1 && Build.VERSION.SDK_INT < 23) {
                                    this.f24997f.c(srVar.fp());
                                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDataSource\uff1a  url" + srVar.fp());
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f24997f.c(srVar);
                                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDataSource\uff1a MediaDataSource url" + srVar.fp());
                                } else {
                                    String w3 = com.bykv.vk.openvk.component.video.c.w.f.c.c().w(srVar);
                                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setDataSource\uff1a  local url = ", w3);
                                    if (w3 != null && com.bykv.vk.openvk.component.video.api.xv.w() && w3.startsWith("file")) {
                                        w(Uri.parse(w3).getPath());
                                    } else {
                                        this.f24997f.c(w3);
                                    }
                                }
                            }
                            this.f25000k = 202;
                            break;
                        } catch (Throwable th8) {
                            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SET_DATASOURCE error: ", th8);
                            break;
                        }
                    }
                    z3 = true;
                    break;
                case 110:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SET_DISPLAY");
                    try {
                        this.f24997f.c((SurfaceHolder) message.obj);
                        this.f24997f.w(true);
                        this.ba.await(1L, TimeUnit.SECONDS);
                        eq();
                        break;
                    } catch (Throwable th9) {
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SET_DISPLAY error: ", th9);
                        break;
                    }
                case 111:
                    com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SET_SURFACE");
                    try {
                        this.me = new Surface((SurfaceTexture) message.obj);
                        this.f24997f.c(this.me);
                        this.f24997f.w(true);
                        this.ba.await(1L, TimeUnit.SECONDS);
                        eq();
                        break;
                    } catch (Throwable th10) {
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OP_SET_SURFACE error: ", th10);
                        break;
                    }
            }
        }
        if (z3) {
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "wrongState");
            this.f25000k = 200;
            if (this.ev) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.xv.w wVar = new com.bykv.vk.openvk.component.video.api.xv.w(308, i5);
            wVar.c(i4 + "," + i5);
            for (WeakReference<c.InterfaceC0334c> weakReference3 : this.f25001n) {
                if (weakReference3 != null && weakReference3.get() != null) {
                    weakReference3.get().c(this, wVar);
                }
            }
            this.ev = true;
        }
    }

    private void w(Runnable runnable) {
        if (runnable == null || ys()) {
            return;
        }
        if (!this.f25002p) {
            runnable.run();
        } else {
            c(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void w(int i4) {
        if (ys()) {
            return;
        }
        this.f25009y = i4;
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.c
    public void c(xv xvVar, int i4) {
        if (this.f24997f != xvVar) {
            return;
        }
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().w(this, i4);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.w
    public void c(xv xvVar) {
        this.f25000k = 209;
        ls.delete(this.f25003q);
        n nVar = this.bk;
        if (nVar != null) {
            nVar.removeCallbacks(this.wv);
        }
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.InterfaceC0337xv
    public boolean c(xv xvVar, int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_MEDIA", "what=" + i4 + "extra=" + i5);
        ck();
        this.f25000k = 200;
        n nVar = this.bk;
        if (nVar != null) {
            nVar.removeCallbacks(this.wv);
        }
        if (c(i4, i5)) {
            n();
        }
        if (this.eq.get()) {
            this.eq.set(false);
            com.bykv.vk.openvk.component.video.api.xv.w wVar = new com.bykv.vk.openvk.component.video.api.xv.w(i4, i5);
            for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().c(this, wVar);
                }
            }
            return true;
        }
        return true;
    }

    private boolean c(int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "OnError - Error code: " + i4 + " Extra code: " + i5);
        boolean z3 = i4 == -1010 || i4 == -1007 || i4 == -1004 || i4 == -110 || i4 == 100 || i4 == 200;
        if (i5 == 1 || i5 == 700 || i5 == 800) {
            return true;
        }
        return z3;
    }

    private void c(Runnable runnable) {
        try {
            com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "enqueueAction()");
            if (this.f24998i == null) {
                this.f24998i = new ArrayList<>();
            }
            this.f24998i.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.sr("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(final boolean z3) {
        if (ys()) {
            return;
        }
        n nVar = this.bk;
        if (nVar == null) {
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            nVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.sr.sr.8
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.ys() || sr.this.f24997f == null) {
                        return;
                    }
                    try {
                        sr.this.f25010z = z3;
                        sr.this.f24997f.sr(z3);
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.f.xv.c("CSJ_VIDEO_MEDIA", "setQuietPlay error: ", th);
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.c.sr.xv.r
    public void c(xv xvVar, int i4, int i5, int i6, int i7) {
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c((com.bykv.vk.openvk.component.video.api.c) this, i4, i5);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(c.InterfaceC0334c interfaceC0334c) {
        if (interfaceC0334c == null) {
            return;
        }
        for (WeakReference<c.InterfaceC0334c> weakReference : this.f25001n) {
            if (weakReference != null && weakReference.get() == interfaceC0334c) {
                return;
            }
        }
        this.f25001n.add(new WeakReference<>(interfaceC0334c));
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(int i4) {
        this.sr = i4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.c
    public void c(float f4) {
        try {
            com.bykv.vk.openvk.component.video.api.w wVar = new com.bykv.vk.openvk.component.video.api.w();
            wVar.c(f4);
            this.f24997f.c(wVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
