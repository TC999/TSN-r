package com.bytedance.adsdk.c.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.adsdk.c.c.b;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import java.util.zip.CRC32;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.adsdk.c.c.c<m> {

    /* renamed from: com.bytedance.adsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class C0343a extends g0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBuffer f25167a;

        C0343a(ByteBuffer byteBuffer) {
            this.f25167a = byteBuffer;
        }

        public ByteBuffer a() {
            this.f25167a.position(0);
            return this.f25167a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class b extends l {

        /* renamed from: h  reason: collision with root package name */
        static final int f25168h = l.a("IHDR");

        /* renamed from: e  reason: collision with root package name */
        int f25169e;

        /* renamed from: f  reason: collision with root package name */
        int f25170f;

        /* renamed from: g  reason: collision with root package name */
        byte[] f25171g = new byte[5];

        b() {
        }

        @Override // com.bytedance.adsdk.c.c.a.l
        void b(b.C0348b c0348b) throws IOException {
            this.f25169e = c0348b.h();
            this.f25170f = c0348b.h();
            byte[] bArr = this.f25171g;
            c0348b.c(bArr, 0, bArr.length);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c extends e<b.C0348b, b.g> {

        /* renamed from: i  reason: collision with root package name */
        static final /* synthetic */ boolean f25172i = true;

        public c(b.C0348b c0348b) {
            super(c0348b);
        }

        @Override // com.bytedance.adsdk.c.c.a.e
        /* renamed from: b */
        public Bitmap a(Canvas canvas, Paint paint, int i4, Bitmap bitmap, b.g gVar) {
            Bitmap decodeStream;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i4;
            options.inMutable = true;
            options.inBitmap = bitmap;
            Bitmap bitmap2 = null;
            try {
                ((b.C0348b) this.f25176a).a();
                try {
                    decodeStream = BitmapFactory.decodeStream(((b.C0348b) this.f25176a).f(), null, options);
                } catch (IllegalArgumentException unused) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = false;
                    options2.inSampleSize = i4;
                    options2.inMutable = true;
                    decodeStream = BitmapFactory.decodeStream(((b.C0348b) this.f25176a).f(), null, options2);
                }
                try {
                    if (!f25172i && decodeStream == null) {
                        throw new AssertionError();
                    }
                    paint.setXfermode(null);
                    canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
                    return decodeStream;
                } catch (IOException e4) {
                    e = e4;
                    bitmap2 = decodeStream;
                    e.printStackTrace();
                    return bitmap2;
                }
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                return bitmap2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class d extends l {

        /* renamed from: g  reason: collision with root package name */
        static final int f25173g = l.a("acTL");

        /* renamed from: e  reason: collision with root package name */
        int f25174e;

        /* renamed from: f  reason: collision with root package name */
        int f25175f;

        d() {
        }

        @Override // com.bytedance.adsdk.c.c.a.l
        void b(b.C0348b c0348b) throws IOException {
            this.f25174e = c0348b.h();
            this.f25175f = c0348b.h();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public abstract class e<R extends b.c, W extends b.d> {

        /* renamed from: a  reason: collision with root package name */
        protected final R f25176a;

        /* renamed from: b  reason: collision with root package name */
        public int f25177b;

        /* renamed from: c  reason: collision with root package name */
        public int f25178c;

        /* renamed from: d  reason: collision with root package name */
        public int f25179d;

        /* renamed from: e  reason: collision with root package name */
        public int f25180e;

        /* renamed from: f  reason: collision with root package name */
        public int f25181f;

        /* renamed from: g  reason: collision with root package name */
        protected final Rect f25182g = new Rect();

        /* renamed from: h  reason: collision with root package name */
        protected final Rect f25183h = new Rect();

        public e(R r3) {
            this.f25176a = r3;
        }

        public abstract Bitmap a(Canvas canvas, Paint paint, int i4, Bitmap bitmap, W w3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f extends l {

        /* renamed from: n  reason: collision with root package name */
        static final int f25184n = l.a("fcTL");

        /* renamed from: e  reason: collision with root package name */
        int f25185e;

        /* renamed from: f  reason: collision with root package name */
        int f25186f;

        /* renamed from: g  reason: collision with root package name */
        int f25187g;

        /* renamed from: h  reason: collision with root package name */
        int f25188h;

        /* renamed from: i  reason: collision with root package name */
        int f25189i;

        /* renamed from: j  reason: collision with root package name */
        short f25190j;

        /* renamed from: k  reason: collision with root package name */
        short f25191k;

        /* renamed from: l  reason: collision with root package name */
        byte f25192l;

        /* renamed from: m  reason: collision with root package name */
        byte f25193m;

        f() {
        }

        @Override // com.bytedance.adsdk.c.c.a.l
        void b(b.C0348b c0348b) throws IOException {
            this.f25185e = c0348b.h();
            this.f25186f = c0348b.h();
            this.f25187g = c0348b.h();
            this.f25188h = c0348b.h();
            this.f25189i = c0348b.h();
            this.f25190j = c0348b.b();
            this.f25191k = c0348b.b();
            this.f25192l = c0348b.c_();
            this.f25193m = c0348b.c_();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public abstract class g<R extends b.c, W extends b.d> {

        /* renamed from: t  reason: collision with root package name */
        private static final String f25194t = "a$g";

        /* renamed from: u  reason: collision with root package name */
        private static final Rect f25195u = new Rect();

        /* renamed from: a  reason: collision with root package name */
        private final g0.b f25196a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f25197b;

        /* renamed from: e  reason: collision with root package name */
        private int f25200e;

        /* renamed from: g  reason: collision with root package name */
        private final Set<j> f25202g;

        /* renamed from: h  reason: collision with root package name */
        private final AtomicBoolean f25203h;

        /* renamed from: i  reason: collision with root package name */
        private final Runnable f25204i;

        /* renamed from: j  reason: collision with root package name */
        protected int f25205j;

        /* renamed from: k  reason: collision with root package name */
        private final Set<Bitmap> f25206k;

        /* renamed from: l  reason: collision with root package name */
        private final Object f25207l;

        /* renamed from: m  reason: collision with root package name */
        protected Map<Bitmap, Canvas> f25208m;

        /* renamed from: n  reason: collision with root package name */
        protected ByteBuffer f25209n;

        /* renamed from: o  reason: collision with root package name */
        protected volatile Rect f25210o;

        /* renamed from: p  reason: collision with root package name */
        private W f25211p;

        /* renamed from: q  reason: collision with root package name */
        private R f25212q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f25213r;

        /* renamed from: s  reason: collision with root package name */
        private volatile k f25214s;

        /* renamed from: c  reason: collision with root package name */
        protected List<e<R, W>> f25198c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        protected int f25199d = -1;

        /* renamed from: f  reason: collision with root package name */
        private Integer f25201f = null;

        /* renamed from: com.bytedance.adsdk.c.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        class RunnableC0344a implements Runnable {
            RunnableC0344a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f25203h.get()) {
                    return;
                }
                if (g.this.v()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    g.this.f25197b.postDelayed(this, Math.max(0L, g.this.A() - (System.currentTimeMillis() - currentTimeMillis)));
                    for (j jVar : g.this.f25202g) {
                        jVar.a(g.this.f25209n);
                    }
                    return;
                }
                g.this.t();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j f25216a;

            b(j jVar) {
                this.f25216a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f25202g.add(this.f25216a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j f25218a;

            c(j jVar) {
                this.f25218a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f25202g.remove(this.f25218a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.f25202g.size() == 0) {
                    g.this.t();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Thread f25221a;

            e(Thread thread) {
                this.f25221a = thread;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        if (g.this.f25210o == null) {
                            if (g.this.f25212q == null) {
                                g gVar = g.this;
                                gVar.f25212q = gVar.N(gVar.f25196a.w());
                            } else {
                                g.this.f25212q.a();
                            }
                            g gVar2 = g.this;
                            gVar2.j(gVar2.H(gVar2.f25212q));
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        g.this.f25210o = g.f25195u;
                    }
                } finally {
                    LockSupport.unpark(this.f25221a);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class f implements Runnable {
            f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.h();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.adsdk.c.c.a$g$g  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class RunnableC0345g implements Runnable {
            RunnableC0345g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.D();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class h implements Runnable {
            h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f25200e = 0;
                g gVar = g.this;
                gVar.f25199d = -1;
                gVar.f25213r = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class i implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f25226a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f25227b;

            i(int i4, boolean z3) {
                this.f25226a = i4;
                this.f25227b = z3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                g.this.D();
                try {
                    g gVar = g.this;
                    gVar.f25205j = this.f25226a;
                    gVar.j(gVar.H(gVar.N(gVar.f25196a.w())));
                    if (this.f25227b) {
                        g.this.h();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }

        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface j {
            void a(ByteBuffer byteBuffer);

            void c();

            void w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public enum k {
            IDLE,
            RUNNING,
            INITIALIZING,
            FINISHING
        }

        public g(g0.b bVar, j jVar) {
            HashSet hashSet = new HashSet();
            this.f25202g = hashSet;
            this.f25203h = new AtomicBoolean(true);
            this.f25204i = new RunnableC0344a();
            this.f25205j = 1;
            this.f25206k = new HashSet();
            this.f25207l = new Object();
            this.f25208m = new WeakHashMap();
            this.f25211p = C();
            this.f25212q = null;
            this.f25213r = false;
            this.f25214s = k.IDLE;
            this.f25196a = bVar;
            if (jVar != null) {
                hashSet.add(jVar);
            }
            this.f25197b = com.bytedance.sdk.component.gd.w.c.c().w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public long A() {
            int i4 = this.f25199d + 1;
            this.f25199d = i4;
            if (i4 >= y()) {
                this.f25199d = 0;
                this.f25200e++;
            }
            e<R, W> e4 = e(this.f25199d);
            if (e4 == null) {
                return 0L;
            }
            k(e4);
            return e4.f25181f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void D() {
            this.f25197b.removeCallbacks(this.f25204i);
            this.f25198c.clear();
            synchronized (this.f25207l) {
                for (Bitmap bitmap : this.f25206k) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
                this.f25206k.clear();
            }
            if (this.f25209n != null) {
                this.f25209n = null;
            }
            this.f25208m.clear();
            try {
                R r3 = this.f25212q;
                if (r3 != null) {
                    r3.ux();
                    this.f25212q = null;
                }
                W w3 = this.f25211p;
                if (w3 != null) {
                    w3.xv();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            O();
            this.f25214s = k.IDLE;
            for (j jVar : this.f25202g) {
                jVar.w();
            }
        }

        private String P() {
            return "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void h() {
            this.f25203h.compareAndSet(true, false);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.f25198c.size() == 0) {
                    R r3 = this.f25212q;
                    if (r3 == null) {
                        this.f25212q = N(this.f25196a.w());
                    } else {
                        r3.a();
                    }
                    j(H(this.f25212q));
                }
                String str = f25194t;
                Log.i(str, P() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
                this.f25214s = k.RUNNING;
                if (s() != 0 && this.f25213r) {
                    Log.i(str, P() + " No need to started");
                    return;
                }
                this.f25199d = -1;
                this.f25204i.run();
                for (j jVar : this.f25202g) {
                    jVar.c();
                }
            } catch (Throwable th) {
                String str2 = f25194t;
                Log.i(str2, P() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
                this.f25214s = k.RUNNING;
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Rect rect) {
            this.f25210o = rect;
            int width = rect.width() * rect.height();
            int i4 = this.f25205j;
            this.f25209n = ByteBuffer.allocate(((width / (i4 * i4)) + 1) * 4);
            if (this.f25211p == null) {
                this.f25211p = C();
            }
        }

        private int s() {
            Integer num = this.f25201f;
            return num != null ? num.intValue() : G();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v() {
            if (x() && this.f25198c.size() != 0) {
                if (s() > 0 && this.f25200e >= s() - 1) {
                    if (this.f25200e != s() - 1 || this.f25199d >= y() - 1) {
                        this.f25213r = true;
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return false;
        }

        protected abstract W C();

        public void F() {
            this.f25197b.post(new d());
        }

        protected abstract int G();

        protected abstract Rect H(R r3) throws IOException;

        public void I(j jVar) {
            this.f25197b.post(new c(jVar));
        }

        public boolean J(int i4, int i5) {
            int L2 = L(i4, i5);
            if (L2 != this.f25205j) {
                boolean x3 = x();
                this.f25197b.removeCallbacks(this.f25204i);
                this.f25197b.post(new i(L2, x3));
                return true;
            }
            return false;
        }

        protected int L(int i4, int i5) {
            int i6 = 1;
            if (i4 != 0 && i5 != 0) {
                int min = Math.min(q().width() / i4, q().height() / i5);
                while (true) {
                    int i7 = i6 * 2;
                    if (i7 > min) {
                        break;
                    }
                    i6 = i7;
                }
            }
            return i6;
        }

        protected abstract R N(b.c cVar);

        protected abstract void O();

        public int a() {
            return this.f25205j;
        }

        protected Bitmap d(int i4, int i5) {
            synchronized (this.f25207l) {
                Iterator<Bitmap> it = this.f25206k.iterator();
                Bitmap bitmap = null;
                while (it.hasNext()) {
                    int i6 = i4 * i5 * 4;
                    Bitmap next = it.next();
                    if (Build.VERSION.SDK_INT >= 19) {
                        if (next != null && next.getAllocationByteCount() >= i6) {
                            it.remove();
                            if ((next.getWidth() != i4 || next.getHeight() != i5) && i4 > 0 && i5 > 0) {
                                next.reconfigure(i4, i5, Bitmap.Config.ARGB_4444);
                            }
                            next.eraseColor(0);
                            return next;
                        }
                    } else if (next != null && next.getByteCount() >= i6) {
                        if (next.getWidth() == i4 && next.getHeight() == i5) {
                            it.remove();
                            next.eraseColor(0);
                        }
                        return next;
                    }
                    bitmap = next;
                }
                if (i4 <= 0 || i5 <= 0) {
                    return null;
                }
                try {
                    bitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_4444);
                } catch (Exception e4) {
                    e4.printStackTrace();
                } catch (OutOfMemoryError e5) {
                    e5.printStackTrace();
                }
                return bitmap;
            }
        }

        public e<R, W> e(int i4) {
            if (i4 < 0 || i4 >= this.f25198c.size()) {
                return null;
            }
            return this.f25198c.get(i4);
        }

        protected void i(Bitmap bitmap) {
            synchronized (this.f25207l) {
                if (bitmap != null) {
                    this.f25206k.add(bitmap);
                }
            }
        }

        protected abstract void k(e<R, W> eVar);

        public void l(j jVar) {
            this.f25197b.post(new b(jVar));
        }

        public void o() {
            if (this.f25210o == f25195u) {
                return;
            }
            if (this.f25214s != k.RUNNING) {
                k kVar = this.f25214s;
                k kVar2 = k.INITIALIZING;
                if (kVar != kVar2) {
                    if (this.f25214s == k.FINISHING) {
                        String str = f25194t;
                        Log.e(str, P() + " Processing,wait for finish at " + this.f25214s);
                    }
                    this.f25214s = kVar2;
                    if (Looper.myLooper() == this.f25197b.getLooper()) {
                        h();
                        return;
                    } else {
                        this.f25197b.post(new f());
                        return;
                    }
                }
            }
            String str2 = f25194t;
            Log.i(str2, P() + " Already started");
        }

        public Rect q() {
            if (this.f25210o == null) {
                if (this.f25214s == k.FINISHING) {
                    Log.e(f25194t, "In finishing,do not interrupt");
                }
                Thread currentThread = Thread.currentThread();
                this.f25197b.post(new e(currentThread));
                LockSupport.park(currentThread);
            }
            return this.f25210o == null ? f25195u : this.f25210o;
        }

        public void t() {
            if (this.f25210o == f25195u) {
                return;
            }
            k kVar = this.f25214s;
            k kVar2 = k.FINISHING;
            if (kVar != kVar2 && this.f25214s != k.IDLE) {
                if (this.f25214s == k.INITIALIZING) {
                    String str = f25194t;
                    Log.e(str, P() + "Processing,wait for finish at " + this.f25214s);
                }
                this.f25214s = kVar2;
                if (Looper.myLooper() == this.f25197b.getLooper()) {
                    D();
                    return;
                } else {
                    this.f25197b.post(new RunnableC0345g());
                    return;
                }
            }
            String str2 = f25194t;
            Log.i(str2, P() + "No need to stop");
        }

        public void w() {
            this.f25197b.post(new h());
        }

        public boolean x() {
            return this.f25214s == k.RUNNING || this.f25214s == k.INITIALIZING;
        }

        public int y() {
            return this.f25198c.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class h extends l {

        /* renamed from: e  reason: collision with root package name */
        static final int f25234e = l.a("IEND");

        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class i extends l {

        /* renamed from: e  reason: collision with root package name */
        static final int f25235e = l.a("IDAT");

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class j extends l {

        /* renamed from: f  reason: collision with root package name */
        static final int f25236f = l.a("fdAT");

        /* renamed from: e  reason: collision with root package name */
        int f25237e;

        j() {
        }

        @Override // com.bytedance.adsdk.c.c.a.l
        void b(b.C0348b c0348b) throws IOException {
            this.f25237e = c0348b.h();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class k {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.adsdk.c.c.a$k$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0346a extends IOException {
            C0346a() {
                super("APNG Format error");
            }
        }

        public static List<l> a(b.C0348b c0348b) throws IOException {
            if (c0348b.e("\u0089PNG") && c0348b.e("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (c0348b.sr() > 0) {
                    arrayList.add(b(c0348b));
                }
                return arrayList;
            }
            throw new C0346a();
        }

        private static l b(b.C0348b c0348b) throws IOException {
            l lVar;
            int xv = c0348b.xv();
            int h4 = c0348b.h();
            int d4 = c0348b.d();
            if (d4 == d.f25173g) {
                lVar = new d();
            } else if (d4 == f.f25184n) {
                lVar = new f();
            } else if (d4 == j.f25236f) {
                lVar = new j();
            } else if (d4 == i.f25235e) {
                lVar = new i();
            } else if (d4 == h.f25234e) {
                lVar = new h();
            } else if (d4 == b.f25168h) {
                lVar = new b();
            } else {
                lVar = new l();
            }
            lVar.f25241d = xv;
            lVar.f25239b = d4;
            lVar.f25238a = h4;
            lVar.c(c0348b);
            lVar.f25240c = c0348b.h();
            return lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        int f25238a;

        /* renamed from: b  reason: collision with root package name */
        int f25239b;

        /* renamed from: c  reason: collision with root package name */
        int f25240c;

        /* renamed from: d  reason: collision with root package name */
        int f25241d;

        l() {
        }

        static int a(String str) {
            if (TextUtils.isEmpty(str) || str.length() != 4) {
                return -1159790593;
            }
            return ((str.charAt(3) & '\u00ff') << 24) | (str.charAt(0) & '\u00ff') | ((str.charAt(1) & '\u00ff') << 8) | ((str.charAt(2) & '\u00ff') << 16);
        }

        void b(b.C0348b c0348b) throws IOException {
        }

        void c(b.C0348b c0348b) throws IOException {
            int sr = c0348b.sr();
            b(c0348b);
            int sr2 = sr - c0348b.sr();
            int i4 = this.f25238a;
            if (sr2 > i4) {
                throw new IOException("Out of chunk area");
            }
            if (sr2 < i4) {
                c0348b.c(i4 - sr2);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class m extends g<b.C0348b, b.g> {

        /* renamed from: v  reason: collision with root package name */
        private b.g f25242v;

        /* renamed from: w  reason: collision with root package name */
        private int f25243w;

        /* renamed from: x  reason: collision with root package name */
        private final Paint f25244x;

        /* renamed from: y  reason: collision with root package name */
        private final b f25245y;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            byte f25246a;

            /* renamed from: b  reason: collision with root package name */
            Rect f25247b;

            /* renamed from: c  reason: collision with root package name */
            ByteBuffer f25248c;

            private b() {
                this.f25247b = new Rect();
            }
        }

        public m(g0.b bVar, g.j jVar) {
            super(bVar, jVar);
            Paint paint = new Paint();
            this.f25244x = paint;
            this.f25245y = new b();
            paint.setAntiAlias(true);
        }

        @Override // com.bytedance.adsdk.c.c.a.g
        protected int G() {
            return this.f25243w;
        }

        @Override // com.bytedance.adsdk.c.c.a.g
        protected void O() {
            this.f25245y.f25248c = null;
            this.f25242v = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.adsdk.c.c.a.g
        /* renamed from: Q */
        public Rect H(b.C0348b c0348b) throws IOException {
            List<l> a4 = k.a(c0348b);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[0];
            Iterator<l> it = a4.iterator();
            n nVar = null;
            boolean z3 = false;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                l next = it.next();
                if (next instanceof d) {
                    this.f25243w = ((d) next).f25175f;
                    z3 = true;
                } else if (next instanceof f) {
                    nVar = new n(c0348b, (f) next);
                    nVar.f25257m = arrayList;
                    nVar.f25255k = bArr;
                    this.f25198c.add(nVar);
                } else if (next instanceof j) {
                    if (nVar != null) {
                        nVar.f25256l.add(next);
                    }
                } else if (next instanceof i) {
                    if (!z3) {
                        c cVar = new c(c0348b);
                        cVar.f25177b = i4;
                        cVar.f25178c = i5;
                        this.f25198c.add(cVar);
                        this.f25243w = 1;
                        break;
                    } else if (nVar != null) {
                        nVar.f25256l.add(next);
                    }
                } else if (next instanceof b) {
                    b bVar = (b) next;
                    i4 = bVar.f25169e;
                    i5 = bVar.f25170f;
                    bArr = bVar.f25171g;
                } else if (!(next instanceof h)) {
                    arrayList.add(next);
                }
            }
            int i6 = i4 * i5;
            int i7 = this.f25205j;
            this.f25209n = ByteBuffer.allocate(((i6 / (i7 * i7)) + 1) * 4);
            b bVar2 = this.f25245y;
            int i8 = this.f25205j;
            bVar2.f25248c = ByteBuffer.allocate(((i6 / (i8 * i8)) + 1) * 4);
            return new Rect(0, 0, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.adsdk.c.c.a.g
        /* renamed from: R */
        public b.C0348b N(b.c cVar) {
            return new b.C0348b(cVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.adsdk.c.c.a.g
        /* renamed from: S */
        public b.g C() {
            if (this.f25242v == null) {
                this.f25242v = new b.g();
            }
            return this.f25242v;
        }

        @Override // com.bytedance.adsdk.c.c.a.g
        protected void k(e<b.C0348b, b.g> eVar) {
            if (eVar == null || this.f25210o == null) {
                return;
            }
            try {
                Bitmap d4 = d(this.f25210o.width() / this.f25205j, this.f25210o.height() / this.f25205j);
                Canvas canvas = this.f25208m.get(d4);
                if (canvas == null) {
                    canvas = new Canvas(d4);
                    this.f25208m.put(d4, canvas);
                }
                Canvas canvas2 = canvas;
                if (eVar instanceof n) {
                    this.f25209n.rewind();
                    d4.copyPixelsFromBuffer(this.f25209n);
                    if (this.f25199d == 0) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(this.f25245y.f25247b);
                        b bVar = this.f25245y;
                        byte b4 = bVar.f25246a;
                        if (b4 == 1) {
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                        } else if (b4 == 2) {
                            bVar.f25248c.rewind();
                            d4.copyPixelsFromBuffer(this.f25245y.f25248c);
                        }
                        canvas2.restore();
                    }
                    if (((n) eVar).f25254j == 2) {
                        b bVar2 = this.f25245y;
                        if (bVar2.f25246a != 2) {
                            bVar2.f25248c.rewind();
                            d4.copyPixelsToBuffer(this.f25245y.f25248c);
                        }
                    }
                    this.f25245y.f25246a = ((n) eVar).f25254j;
                    canvas2.save();
                    if (((n) eVar).f25253i == 0) {
                        int i4 = eVar.f25179d;
                        int i5 = this.f25205j;
                        int i6 = eVar.f25180e;
                        canvas2.clipRect(i4 / i5, i6 / i5, (i4 + eVar.f25177b) / i5, (i6 + eVar.f25178c) / i5);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    Rect rect = this.f25245y.f25247b;
                    int i7 = eVar.f25179d;
                    int i8 = this.f25205j;
                    int i9 = eVar.f25180e;
                    rect.set(i7 / i8, i9 / i8, (i7 + eVar.f25177b) / i8, (i9 + eVar.f25178c) / i8);
                    canvas2.restore();
                }
                Bitmap d5 = d(eVar.f25177b, eVar.f25178c);
                i(eVar.a(canvas2, this.f25244x, this.f25205j, d5, C()));
                i(d5);
                this.f25209n.rewind();
                d4.copyPixelsToBuffer(this.f25209n);
                i(d4);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class n extends e<b.C0348b, b.g> {

        /* renamed from: n  reason: collision with root package name */
        private static final byte[] f25249n = {-119, 80, 78, 71, 13, 10, 26, 10};

        /* renamed from: o  reason: collision with root package name */
        private static final byte[] f25250o = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        /* renamed from: p  reason: collision with root package name */
        private static final ThreadLocal<CRC32> f25251p = new ThreadLocal<>();

        /* renamed from: q  reason: collision with root package name */
        static final /* synthetic */ boolean f25252q = true;

        /* renamed from: i  reason: collision with root package name */
        public final byte f25253i;

        /* renamed from: j  reason: collision with root package name */
        public final byte f25254j;

        /* renamed from: k  reason: collision with root package name */
        byte[] f25255k;

        /* renamed from: l  reason: collision with root package name */
        List<l> f25256l;

        /* renamed from: m  reason: collision with root package name */
        List<l> f25257m;

        public n(b.C0348b c0348b, f fVar) {
            super(c0348b);
            this.f25256l = new ArrayList();
            this.f25257m = new ArrayList();
            this.f25253i = fVar.f25193m;
            this.f25254j = fVar.f25192l;
            int i4 = fVar.f25190j * 1000;
            short s3 = fVar.f25191k;
            int i5 = i4 / (s3 == 0 ? (short) 100 : s3);
            this.f25181f = i5;
            if (i5 < 10) {
                this.f25181f = 100;
            }
            this.f25177b = fVar.f25186f;
            this.f25178c = fVar.f25187g;
            this.f25179d = fVar.f25188h;
            this.f25180e = fVar.f25189i;
        }

        private int b(b.g gVar) throws IOException {
            int i4;
            int i5 = 33;
            for (l lVar : this.f25257m) {
                i5 += lVar.f25238a + 12;
            }
            for (l lVar2 : this.f25256l) {
                if (lVar2 instanceof i) {
                    i4 = lVar2.f25238a + 12;
                } else if (lVar2 instanceof j) {
                    i4 = lVar2.f25238a + 8;
                }
                i5 += i4;
            }
            int length = i5 + f25250o.length;
            gVar.f(length);
            gVar.c(f25249n);
            gVar.h(13);
            int a4 = gVar.a();
            gVar.g(b.f25168h);
            gVar.h(this.f25177b);
            gVar.h(this.f25178c);
            gVar.c(this.f25255k);
            CRC32 d4 = d();
            d4.reset();
            d4.update(gVar.e(), a4, 17);
            gVar.h((int) d4.getValue());
            for (l lVar3 : this.f25257m) {
                if (!(lVar3 instanceof h)) {
                    ((b.C0348b) this.f25176a).a();
                    ((b.C0348b) this.f25176a).c(lVar3.f25241d);
                    ((b.C0348b) this.f25176a).c(gVar.e(), gVar.a(), lVar3.f25238a + 12);
                    gVar.d(lVar3.f25238a + 12);
                }
            }
            for (l lVar4 : this.f25256l) {
                if (lVar4 instanceof i) {
                    ((b.C0348b) this.f25176a).a();
                    ((b.C0348b) this.f25176a).c(lVar4.f25241d);
                    ((b.C0348b) this.f25176a).c(gVar.e(), gVar.a(), lVar4.f25238a + 12);
                    gVar.d(lVar4.f25238a + 12);
                } else if (lVar4 instanceof j) {
                    gVar.h(lVar4.f25238a - 4);
                    int a5 = gVar.a();
                    gVar.g(i.f25235e);
                    ((b.C0348b) this.f25176a).a();
                    ((b.C0348b) this.f25176a).c(lVar4.f25241d + 4 + 4 + 4);
                    ((b.C0348b) this.f25176a).c(gVar.e(), gVar.a(), lVar4.f25238a - 4);
                    gVar.d(lVar4.f25238a - 4);
                    d4.reset();
                    d4.update(gVar.e(), a5, lVar4.f25238a);
                    gVar.h((int) d4.getValue());
                }
            }
            gVar.c(f25250o);
            return length;
        }

        private CRC32 d() {
            ThreadLocal<CRC32> threadLocal = f25251p;
            CRC32 crc32 = threadLocal.get();
            if (crc32 == null) {
                CRC32 crc322 = new CRC32();
                threadLocal.set(crc322);
                return crc322;
            }
            return crc32;
        }

        @Override // com.bytedance.adsdk.c.c.a.e
        /* renamed from: c */
        public Bitmap a(Canvas canvas, Paint paint, int i4, Bitmap bitmap, b.g gVar) {
            byte[] bArr;
            Bitmap decodeByteArray;
            try {
                int b4 = b(gVar);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i4;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(gVar.e(), 0, b4, options);
                } catch (IllegalArgumentException unused) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = false;
                    options2.inSampleSize = i4;
                    options2.inMutable = true;
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, b4, options2);
                }
                if (!f25252q && decodeByteArray == null) {
                    throw new AssertionError();
                }
                Rect rect = this.f25182g;
                rect.left = 0;
                rect.top = 0;
                rect.right = decodeByteArray.getWidth();
                this.f25182g.bottom = decodeByteArray.getHeight();
                Rect rect2 = this.f25183h;
                int i5 = this.f25179d;
                float f4 = i4;
                rect2.left = (int) (i5 / f4);
                rect2.top = (int) (this.f25180e / f4);
                rect2.right = (int) ((i5 / f4) + decodeByteArray.getWidth());
                this.f25183h.bottom = (int) ((this.f25180e / f4) + decodeByteArray.getHeight());
                canvas.drawBitmap(decodeByteArray, this.f25182g, this.f25183h, paint);
                return decodeByteArray;
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public a(g0.b bVar) {
        super(bVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [g0.b, com.bytedance.adsdk.c.c.a$a] */
    public static a i(ByteBuffer byteBuffer) {
        return new a(new C0343a(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.c.c.c
    /* renamed from: h */
    public m f(g0.b bVar, g.j jVar) {
        return new m(bVar, jVar);
    }
}
