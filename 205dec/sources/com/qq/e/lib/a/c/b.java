package com.qq.e.lib.a.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.qq.e.lib.a.e.d;
import com.qq.e.lib.a.e.f;
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

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b<R extends com.qq.e.lib.a.e.d, W extends com.qq.e.lib.a.e.f> {

    /* renamed from: u  reason: collision with root package name */
    private static final String f47312u = "b";

    /* renamed from: v  reason: collision with root package name */
    private static final Rect f47313v = new Rect();

    /* renamed from: a  reason: collision with root package name */
    private final int f47314a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.lib.a.f.b f47315b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f47316c;

    /* renamed from: f  reason: collision with root package name */
    private int f47319f;

    /* renamed from: o  reason: collision with root package name */
    protected ByteBuffer f47328o;

    /* renamed from: p  reason: collision with root package name */
    protected volatile Rect f47329p;

    /* renamed from: d  reason: collision with root package name */
    protected List<com.qq.e.lib.a.c.a<R, W>> f47317d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    protected int f47318e = -1;

    /* renamed from: g  reason: collision with root package name */
    private Integer f47320g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Set<j> f47321h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f47322i = new AtomicBoolean(true);

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f47323j = new a();

    /* renamed from: k  reason: collision with root package name */
    protected int f47324k = 1;

    /* renamed from: l  reason: collision with root package name */
    private final Set<Bitmap> f47325l = new HashSet();

    /* renamed from: m  reason: collision with root package name */
    private final Object f47326m = new Object();

    /* renamed from: n  reason: collision with root package name */
    protected Map<Bitmap, Canvas> f47327n = new WeakHashMap();

    /* renamed from: q  reason: collision with root package name */
    private W f47330q = i();

    /* renamed from: r  reason: collision with root package name */
    private R f47331r = null;

    /* renamed from: s  reason: collision with root package name */
    private boolean f47332s = false;

    /* renamed from: t  reason: collision with root package name */
    private volatile k f47333t = k.f47348c;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f47322i.get()) {
                return;
            }
            if (b.this.b()) {
                long currentTimeMillis = System.currentTimeMillis();
                b.this.f47316c.postDelayed(this, Math.max(0L, b.this.p() - (System.currentTimeMillis() - currentTimeMillis)));
                for (j jVar : b.this.f47321h) {
                    jVar.a(b.this.f47328o);
                }
                return;
            }
            b.this.q();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.lib.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0923b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f47335c;

        RunnableC0923b(j jVar) {
            this.f47335c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47321h.add(this.f47335c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j f47337c;

        c(j jVar) {
            this.f47337c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47321h.remove(this.f47337c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f47321h.size() == 0) {
                b.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Thread f47340c;

        e(Thread thread) {
            this.f47340c = thread;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.f47329p == null) {
                    if (b.this.f47331r != null) {
                        b.this.f47331r.reset();
                    } else {
                        b.this.f47331r = b.this.a(b.this.f47315b.a());
                    }
                    b.this.a(b.this.b((b) b.this.f47331r));
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                b.this.f47329p = b.f47313v;
            } finally {
                LockSupport.unpark(this.f47340c);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.k();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47319f = 0;
            b bVar = b.this;
            bVar.f47318e = -1;
            bVar.f47332s = false;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class i implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f47345c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f47346d;

        i(int i4, boolean z3) {
            this.f47345c = i4;
            this.f47346d = z3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.k();
            try {
                b.this.f47324k = this.f47345c;
                b.this.a(b.this.b((b) b.this.a(b.this.f47315b.a())));
                if (this.f47346d) {
                    b.this.j();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface j {
        void a();

        void a(ByteBuffer byteBuffer);

        void onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class k {

        /* renamed from: c  reason: collision with root package name */
        public static final k f47348c = new k("IDLE", 0);

        /* renamed from: d  reason: collision with root package name */
        public static final k f47349d = new k("RUNNING", 1);

        /* renamed from: e  reason: collision with root package name */
        public static final k f47350e = new k("INITIALIZING", 2);

        /* renamed from: f  reason: collision with root package name */
        public static final k f47351f = new k("FINISHING", 3);

        private k(String str, int i4) {
        }
    }

    public b(com.qq.e.lib.a.f.b bVar, j jVar) {
        this.f47315b = bVar;
        if (jVar != null) {
            this.f47321h.add(jVar);
        }
        this.f47314a = com.qq.e.lib.a.d.a.b().a();
        this.f47316c = new Handler(com.qq.e.lib.a.d.a.b().a(this.f47314a));
    }

    private String c() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f47322i.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f47317d.size() == 0) {
                if (this.f47331r == null) {
                    this.f47331r = a(this.f47315b.a());
                } else {
                    this.f47331r.reset();
                }
                a(b((b<R, W>) this.f47331r));
            }
            String str = f47312u;
            Log.i(str, c() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.f47333t = k.f47349d;
            if (g() != 0 && this.f47332s) {
                String str2 = f47312u;
                Log.i(str2, c() + " No need to started");
                return;
            }
            this.f47318e = -1;
            this.f47323j.run();
            for (j jVar : this.f47321h) {
                jVar.onStart();
            }
        } catch (Throwable th) {
            String str3 = f47312u;
            Log.i(str3, c() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.f47333t = k.f47349d;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f47316c.removeCallbacks(this.f47323j);
        this.f47317d.clear();
        synchronized (this.f47326m) {
            for (Bitmap bitmap : this.f47325l) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.f47325l.clear();
        }
        if (this.f47328o != null) {
            this.f47328o = null;
        }
        this.f47327n.clear();
        try {
            if (this.f47331r != null) {
                this.f47331r.close();
                this.f47331r = null;
            }
            if (this.f47330q != null) {
                this.f47330q.close();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        m();
        this.f47333t = k.f47348c;
        for (j jVar : this.f47321h) {
            jVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long p() {
        int i4 = this.f47318e + 1;
        this.f47318e = i4;
        if (i4 >= e()) {
            this.f47318e = 0;
            this.f47319f++;
        }
        com.qq.e.lib.a.c.a<R, W> a4 = a(this.f47318e);
        if (a4 == null) {
            return 0L;
        }
        a(a4);
        return a4.f47309f;
    }

    protected abstract R a(com.qq.e.lib.a.e.d dVar);

    protected abstract void a(com.qq.e.lib.a.c.a<R, W> aVar);

    protected abstract Rect b(R r3) throws IOException;

    protected abstract int f();

    protected abstract W i();

    public boolean l() {
        return this.f47333t == k.f47349d || this.f47333t == k.f47350e;
    }

    protected abstract void m();

    public void n() {
        this.f47316c.post(new h());
    }

    public void o() {
        if (this.f47329p == f47313v) {
            return;
        }
        if (this.f47333t != k.f47349d && this.f47333t != k.f47350e) {
            if (this.f47333t == k.f47351f) {
                String str = f47312u;
                Log.e(str, c() + " Processing,wait for finish at " + this.f47333t);
            }
            this.f47333t = k.f47350e;
            if (Looper.myLooper() == this.f47316c.getLooper()) {
                j();
                return;
            } else {
                this.f47316c.post(new f());
                return;
            }
        }
        String str2 = f47312u;
        Log.i(str2, c() + " Already started");
    }

    public void q() {
        if (this.f47329p == f47313v) {
            return;
        }
        if (this.f47333t != k.f47351f && this.f47333t != k.f47348c) {
            if (this.f47333t == k.f47350e) {
                String str = f47312u;
                Log.e(str, c() + "Processing,wait for finish at " + this.f47333t);
            }
            this.f47333t = k.f47351f;
            if (Looper.myLooper() == this.f47316c.getLooper()) {
                k();
                return;
            } else {
                this.f47316c.post(new g());
                return;
            }
        }
        String str2 = f47312u;
        Log.i(str2, c() + "No need to stop");
    }

    public void r() {
        this.f47316c.post(new d());
    }

    private int g() {
        Integer num = this.f47320g;
        return num != null ? num.intValue() : f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap b(int i4, int i5) {
        synchronized (this.f47326m) {
            Iterator<Bitmap> it = this.f47325l.iterator();
            Bitmap bitmap = null;
            while (it.hasNext()) {
                int i6 = i4 * i5 * 4;
                Bitmap next = it.next();
                if (Build.VERSION.SDK_INT >= 19) {
                    if (next != null && next.getAllocationByteCount() >= i6) {
                        it.remove();
                        if ((next.getWidth() != i4 || next.getHeight() != i5) && i4 > 0 && i5 > 0) {
                            next.reconfigure(i4, i5, Bitmap.Config.ARGB_8888);
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
                bitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            } catch (Exception e4) {
                e4.printStackTrace();
            } catch (OutOfMemoryError e5) {
                e5.printStackTrace();
            }
            return bitmap;
        }
    }

    public boolean c(int i4, int i5) {
        int a4 = a(i4, i5);
        if (a4 != this.f47324k) {
            boolean l4 = l();
            this.f47316c.removeCallbacks(this.f47323j);
            this.f47316c.post(new i(a4, l4));
            return true;
        }
        return false;
    }

    public Rect d() {
        if (this.f47329p == null) {
            if (this.f47333t == k.f47351f) {
                Log.e(f47312u, "In finishing,do not interrupt");
            }
            Thread currentThread = Thread.currentThread();
            this.f47316c.post(new e(currentThread));
            LockSupport.park(currentThread);
        }
        return this.f47329p == null ? f47313v : this.f47329p;
    }

    public int e() {
        return this.f47317d.size();
    }

    public int h() {
        return this.f47324k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        synchronized (this.f47326m) {
            if (bitmap != null) {
                this.f47325l.add(bitmap);
            }
        }
    }

    public void a(j jVar) {
        this.f47316c.post(new RunnableC0923b(jVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect) {
        this.f47329p = rect;
        int width = rect.width() * rect.height();
        int i4 = this.f47324k;
        this.f47328o = ByteBuffer.allocate(((width / (i4 * i4)) + 1) * 4);
        if (this.f47330q == null) {
            this.f47330q = i();
        }
    }

    protected int a(int i4, int i5) {
        int i6 = 1;
        if (i4 != 0 && i5 != 0) {
            int min = Math.min(d().width() / i4, d().height() / i5);
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

    public com.qq.e.lib.a.c.a<R, W> a(int i4) {
        if (i4 < 0 || i4 >= this.f47317d.size()) {
            return null;
        }
        return this.f47317d.get(i4);
    }

    public void b(j jVar) {
        this.f47316c.post(new c(jVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (l() && this.f47317d.size() != 0) {
            if (g() > 0 && this.f47319f >= g() - 1) {
                if (this.f47319f != g() - 1 || this.f47318e >= e() - 1) {
                    this.f47332s = true;
                    return false;
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
