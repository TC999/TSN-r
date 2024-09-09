package com.bytedance.sdk.component.ux.xv;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.gd;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.component.ux.p;
import com.bytedance.sdk.component.ux.t;
import com.bytedance.sdk.component.ux.u;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements gd {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<ImageView> f30319a;
    private ExecutorService ba;
    private volatile boolean bk;

    /* renamed from: c  reason: collision with root package name */
    Future<?> f30320c;
    private int ck;
    private t eq;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private ImageView.ScaleType f30321f;
    private u fp;
    private final Handler fz;
    private com.bytedance.sdk.component.ux.w gb;
    private int gd;

    /* renamed from: i  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.r f30322i;
    private int ia;

    /* renamed from: j  reason: collision with root package name */
    private f f30323j;

    /* renamed from: k  reason: collision with root package name */
    private int f30324k;
    private com.bytedance.sdk.component.ux.xv.c ls;

    /* renamed from: n  reason: collision with root package name */
    private int f30325n;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.ev f30326p;

    /* renamed from: q  reason: collision with root package name */
    private int f30327q;

    /* renamed from: r  reason: collision with root package name */
    private Bitmap.Config f30328r;

    /* renamed from: s  reason: collision with root package name */
    private Queue<com.bytedance.sdk.component.ux.sr.gd> f30329s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f30330t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f30331u;
    private fp ux;

    /* renamed from: w  reason: collision with root package name */
    private String f30332w;
    private String xv;

    /* renamed from: y  reason: collision with root package name */
    private boolean f30333y;
    private boolean ys;

    /* renamed from: z  reason: collision with root package name */
    private boolean f30334z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c implements fp {

        /* renamed from: w  reason: collision with root package name */
        private fp f30337w;

        public c(fp fpVar) {
            this.f30337w = fpVar;
        }

        @Override // com.bytedance.sdk.component.ux.fp
        @ATSMethod(1)
        public void c(final k kVar) {
            Bitmap c4;
            final ImageView imageView = (ImageView) xv.this.f30319a.get();
            if (imageView != null && xv.this.f30324k != 3 && c(imageView) && (kVar.xv() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) kVar.xv();
                xv.this.fz.post(new Runnable() { // from class: com.bytedance.sdk.component.ux.xv.xv.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (xv.this.f30326p != null && (kVar.xv() instanceof Bitmap) && (c4 = xv.this.f30326p.c((Bitmap) kVar.xv())) != null) {
                    kVar.setResult(c4);
                }
            } catch (Throwable unused) {
            }
            if (xv.this.ia == 5) {
                xv.this.fz.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.ux.xv.xv.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f30337w != null) {
                            c.this.f30337w.c(kVar);
                        }
                    }
                });
                return;
            }
            fp fpVar = this.f30337w;
            if (fpVar != null) {
                fpVar.c(kVar);
            }
        }

        private boolean c(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(xv.this.xv)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.ux.fp
        @ATSMethod(2)
        public void c(final int i4, final String str, final Throwable th) {
            if (xv.this.ia == 5) {
                xv.this.fz.post(new Runnable() { // from class: com.bytedance.sdk.component.ux.xv.xv.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f30337w != null) {
                            c.this.f30337w.c(i4, str, th);
                        }
                    }
                });
                return;
            }
            fp fpVar = this.f30337w;
            if (fpVar != null) {
                fpVar.c(i4, str, th);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w implements p {

        /* renamed from: a  reason: collision with root package name */
        private boolean f30344a;
        private boolean bk;

        /* renamed from: c  reason: collision with root package name */
        private fp f30345c;
        private int ev;

        /* renamed from: f  reason: collision with root package name */
        private Bitmap.Config f30346f;
        private f fp;
        private int fz;

        /* renamed from: i  reason: collision with root package name */
        private ExecutorService f30347i;
        private com.bytedance.sdk.component.ux.ev ia;

        /* renamed from: j  reason: collision with root package name */
        private t f30348j;

        /* renamed from: k  reason: collision with root package name */
        private u f30349k;

        /* renamed from: q  reason: collision with root package name */
        private boolean f30351q;

        /* renamed from: r  reason: collision with root package name */
        private int f30352r;

        /* renamed from: s  reason: collision with root package name */
        private int f30353s;
        private String sr;

        /* renamed from: t  reason: collision with root package name */
        private String f30354t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f30355u;
        private ImageView.ScaleType ux;

        /* renamed from: w  reason: collision with root package name */
        private ImageView f30356w;
        private String xv;
        private com.bytedance.sdk.component.ux.w ys;
        private int gd = 1;

        /* renamed from: p  reason: collision with root package name */
        private int f30350p = 5;

        public w(f fVar) {
            this.fp = fVar;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(4)
        public p c(String str) {
            this.sr = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(18)
        public p sr(int i4) {
            this.f30353s = i4;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(19)
        public p ux(int i4) {
            this.fz = i4;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(5)
        public p w(String str) {
            this.xv = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(12)
        public p xv(int i4) {
            this.gd = i4;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(6)
        public p c(com.bytedance.sdk.component.ux.w wVar) {
            this.ys = wVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(11)
        public p w(int i4) {
            this.ev = i4;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(7)
        public p xv(String str) {
            this.f30354t = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(8)
        public p c(ImageView.ScaleType scaleType) {
            this.ux = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(15)
        public p w(boolean z3) {
            this.bk = z3;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(20)
        public p xv(boolean z3) {
            this.f30351q = z3;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(9)
        public p c(Bitmap.Config config) {
            this.f30346f = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(10)
        public p c(int i4) {
            this.f30352r = i4;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(13)
        public p c(u uVar) {
            this.f30349k = uVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(14)
        public p c(boolean z3) {
            this.f30344a = z3;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(16)
        public p c(ExecutorService executorService) {
            this.f30347i = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(1)
        public gd c(fp fpVar, int i4) {
            this.f30350p = i4;
            return c(fpVar);
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(2)
        public gd c(fp fpVar) {
            this.f30345c = fpVar;
            return new xv(this).gb();
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(3)
        public gd c(ImageView imageView) {
            this.f30356w = imageView;
            return new xv(this).gb();
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(17)
        public p c(com.bytedance.sdk.component.ux.ev evVar) {
            this.ia = evVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.ux.p
        @ATSMethod(21)
        public p c(t tVar) {
            this.f30348j = tVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gd gb() {
        f fVar;
        try {
            fVar = this.f30323j;
        } catch (Exception e4) {
            Log.e("ImageRequest", e4.getMessage());
        }
        if (fVar == null) {
            fp fpVar = this.ux;
            if (fpVar != null) {
                fpVar.c(1005, "not init !", null);
            }
            return this;
        }
        if (this.ba == null) {
            this.ba = fVar.f();
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.ux.xv.xv.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.ux.sr.gd gdVar;
                while (!xv.this.bk && (gdVar = (com.bytedance.sdk.component.ux.sr.gd) xv.this.f30329s.poll()) != null) {
                    try {
                        if (xv.this.fp != null) {
                            xv.this.fp.c(gdVar.c(), xv.this);
                        }
                        gdVar.c(xv.this);
                        if (xv.this.fp != null) {
                            xv.this.fp.w(gdVar.c(), xv.this);
                        }
                    } catch (Throwable th) {
                        xv.this.c(2000, th.getMessage(), th);
                        if (xv.this.fp != null) {
                            xv.this.fp.w("exception", xv.this);
                            return;
                        }
                        return;
                    }
                }
                if (xv.this.bk) {
                    xv.this.c(1003, "canceled", null);
                }
            }
        };
        if (this.f30333y) {
            runnable.run();
        } else {
            ExecutorService executorService = this.ba;
            if (executorService != null) {
                this.f30320c = executorService.submit(runnable);
            }
        }
        return this;
    }

    public Bitmap.Config a() {
        return this.f30328r;
    }

    public int bk() {
        return this.f30324k;
    }

    public boolean fp() {
        return this.f30331u;
    }

    public com.bytedance.sdk.component.ux.xv.c fz() {
        return this.ls;
    }

    public com.bytedance.sdk.component.ux.w i() {
        return this.gb;
    }

    public com.bytedance.sdk.component.ux.r ia() {
        return this.f30322i;
    }

    public t j() {
        return this.eq;
    }

    public fp k() {
        return this.ux;
    }

    public String ls() {
        return r() + bk();
    }

    public boolean q() {
        return this.f30334z;
    }

    public int s() {
        return this.f30327q;
    }

    public boolean t() {
        return this.f30330t;
    }

    public f u() {
        return this.f30323j;
    }

    public boolean ys() {
        return this.ys;
    }

    private xv(w wVar) {
        this.f30329s = new LinkedBlockingQueue();
        this.fz = new Handler(Looper.getMainLooper());
        this.f30331u = true;
        this.f30332w = wVar.sr;
        this.ux = new c(wVar.f30345c);
        this.f30319a = new WeakReference<>(wVar.f30356w);
        this.f30321f = wVar.ux;
        this.f30328r = wVar.f30346f;
        this.ev = wVar.f30352r;
        this.gd = wVar.ev;
        this.f30324k = wVar.gd;
        this.ia = wVar.f30350p;
        this.fp = wVar.f30349k;
        this.gb = c(wVar);
        if (!TextUtils.isEmpty(wVar.xv)) {
            w(wVar.xv);
            c(wVar.xv);
        }
        this.f30330t = wVar.f30344a;
        this.ys = wVar.bk;
        this.f30323j = wVar.fp;
        this.f30326p = wVar.ia;
        this.ck = wVar.fz;
        this.f30325n = wVar.f30353s;
        this.ba = wVar.f30347i;
        this.f30334z = wVar.f30355u;
        this.f30333y = wVar.f30351q;
        this.eq = wVar.f30348j;
        this.f30329s.add(new com.bytedance.sdk.component.ux.sr.xv());
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(8)
    public Bitmap.Config ev() {
        return this.f30328r;
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(6)
    public String f() {
        return this.sr;
    }

    public int gd() {
        return this.f30325n;
    }

    public int p() {
        return this.ck;
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(7)
    public String r() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(4)
    public int sr() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(5)
    public ImageView.ScaleType ux() {
        return this.f30321f;
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(2)
    public String w() {
        return this.f30332w;
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(3)
    public int xv() {
        return this.ev;
    }

    private com.bytedance.sdk.component.ux.w c(w wVar) {
        if (wVar.ys != null) {
            return wVar.ys;
        }
        if (!TextUtils.isEmpty(wVar.f30354t)) {
            return com.bytedance.sdk.component.ux.xv.c.c.c(new File(wVar.f30354t));
        }
        return com.bytedance.sdk.component.ux.xv.c.c.r();
    }

    public void w(String str) {
        WeakReference<ImageView> weakReference = this.f30319a;
        if (weakReference != null && weakReference.get() != null) {
            this.f30319a.get().setTag(1094453505, str);
        }
        this.xv = str;
    }

    public void c(String str) {
        this.sr = str;
    }

    public void c(boolean z3) {
        this.f30331u = z3;
    }

    public void c(com.bytedance.sdk.component.ux.r rVar) {
        this.f30322i = rVar;
    }

    public void c(int i4) {
        this.f30327q = i4;
    }

    public void c(com.bytedance.sdk.component.ux.xv.c cVar) {
        this.ls = cVar;
    }

    public boolean c(com.bytedance.sdk.component.ux.sr.gd gdVar) {
        if (this.bk) {
            return false;
        }
        return this.f30329s.add(gdVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, String str, Throwable th) {
        new com.bytedance.sdk.component.ux.sr.ev(i4, str, th).c(this);
        this.f30329s.clear();
    }

    @Override // com.bytedance.sdk.component.ux.gd
    @ATSMethod(1)
    public boolean c() {
        this.bk = true;
        Future<?> future = this.f30320c;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }
}
