package com.qq.e.comm.plugin.b0;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.qq.e.comm.plugin.b0.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.p.c;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.g;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.t;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class e implements Runnable {

    /* renamed from: p  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f42053p = new ConcurrentHashMap<>();

    /* renamed from: q  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.p.c f42054q = new c.b().a(false).a(10000).b(10000).a();

    /* renamed from: r  reason: collision with root package name */
    private static final LruCache<String, SoftReference<Bitmap>> f42055r = new LruCache<>(5);

    /* renamed from: s  reason: collision with root package name */
    private static Boolean f42056s = null;

    /* renamed from: t  reason: collision with root package name */
    private static final String f42057t = com.qq.e.comm.plugin.d0.a.d().f().b("webppv", "imageView2/format/webp=");

    /* renamed from: u  reason: collision with root package name */
    private static final String f42058u = com.qq.e.comm.plugin.d0.a.d().f().b("apv", "imageView2/format/avif");

    /* renamed from: c  reason: collision with root package name */
    private String f42059c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<ImageView> f42060d;

    /* renamed from: e  reason: collision with root package name */
    private final c f42061e;

    /* renamed from: f  reason: collision with root package name */
    private File f42062f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f42063g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f42064h;

    /* renamed from: i  reason: collision with root package name */
    private String f42065i;

    /* renamed from: j  reason: collision with root package name */
    private String f42066j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f42067k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f42068l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f42069m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f42070n;

    /* renamed from: o  reason: collision with root package name */
    private String f42071o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f42072c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Exception f42073d;

        a(int i4, Exception exc) {
            this.f42072c = i4;
            this.f42073d = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f42061e != null) {
                e.this.f42061e.a(e.this.f42059c, this.f42072c, this.f42073d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.b f42075c;

        b(f.b bVar) {
            this.f42075c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = (ImageView) e.this.f42060d.get();
            f a4 = this.f42075c.a();
            e.this.a(imageView, a4);
            if (e.this.f42061e != null) {
                e.this.f42061e.a(e.this.f42059c, imageView, a4);
            }
        }
    }

    private e(ImageView imageView, c cVar, boolean z3, boolean z4) {
        this.f42067k = false;
        this.f42060d = new WeakReference<>(imageView);
        this.f42061e = cVar;
        this.f42063g = z3;
        this.f42064h = z4;
        if (f42056s == null) {
            f42056s = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("eia", Build.VERSION.SDK_INT < 23 ? 0 : 1) == 1);
        }
    }

    private int d() {
        int i4;
        if (TextUtils.isEmpty(this.f42066j) || !this.f42066j.endsWith(f42058u)) {
            i4 = this.f42068l ? 1 : 2;
        } else {
            i4 = 3;
        }
        int d4 = g.e().d();
        if (d4 > 1) {
            d4 *= 100;
        }
        int i5 = d4 + (i4 * 10) + (this.f42063g ? 1 : 0);
        if (i5 > 100) {
            d1.a("gdt_tag_avif", "enum code is " + i5);
        }
        return i5;
    }

    private Bitmap e() {
        String c4 = c();
        SoftReference<Bitmap> softReference = f42055r.get(c4);
        Bitmap bitmap = softReference != null ? softReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            f42055r.remove(c4);
            return null;
        }
        return bitmap;
    }

    private void f() {
        Object obj = f42053p.get(this.f42071o);
        if (obj != null) {
            synchronized (obj) {
                Object obj2 = f42053p.get(this.f42071o);
                if (obj2 != null) {
                    try {
                        obj2.wait(5000L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap e4;
        f();
        if (!this.f42063g && (e4 = e()) != null) {
            a(new f.b().a(e4), true);
        } else if (this.f42062f.exists() && b(true)) {
        } else {
            if (TextUtils.isEmpty(this.f42059c)) {
                a(32768, new Exception());
                return;
            }
            f42053p.putIfAbsent(this.f42071o, new Object());
            Object obj = f42053p.get(this.f42071o);
            synchronized (obj) {
                try {
                    b();
                    b(false);
                    f42053p.remove(this.f42071o);
                } catch (com.qq.e.comm.plugin.p.d e5) {
                    a(e5.a(), e5);
                    f42053p.remove(this.f42071o);
                }
                obj.notifyAll();
            }
        }
    }

    private boolean b(boolean z3) {
        if (this.f42063g) {
            a(new f.b(), z3);
            return true;
        }
        try {
            f.b a4 = a();
            if (a4 != null) {
                a(a4, z3);
                return true;
            } else if (z3) {
                this.f42062f.delete();
                return false;
            } else {
                a(102, new Exception("DecodeFailed"));
                return true;
            }
        } catch (Exception unused) {
            a(102, new Exception("DecodeFailed"));
            return true;
        } catch (OutOfMemoryError e4) {
            a(101, new Exception(e4));
            return true;
        }
    }

    private String c() {
        t.a a4 = t.a(this.f42060d.get(), 0, 0);
        return this.f42071o + "_" + a4.b() + "_" + a4.a();
    }

    public void a(boolean z3) {
        this.f42067k = z3;
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView == null) {
            return;
        }
        Object tag = imageView.getTag(2131755009);
        if (tag == null || !tag.equals(this.f42071o)) {
            imageView.setImageBitmap(bitmap);
            imageView.setTag(2131755009, this.f42071o);
        }
    }

    private void a(int i4, Exception exc) {
        c cVar;
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("rs", this.f42059c);
        v.a(1402202, null, Integer.valueOf(d()), Integer.valueOf(i4), dVar);
        if (this.f42064h && (cVar = this.f42061e) != null) {
            cVar.a(this.f42059c, i4, exc);
        } else {
            p0.a((Runnable) new a(i4, exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, f fVar) {
        int f4;
        Object tag;
        if (imageView == null || (f4 = fVar.f()) == 0) {
            return;
        }
        if (f4 == 3) {
            imageView.setImageDrawable(fVar.c());
        } else if (f4 == 2 && (imageView instanceof com.qq.e.comm.plugin.r0.g)) {
            ((com.qq.e.comm.plugin.r0.g) imageView).a(fVar.e());
        } else if (f4 == 1 && (tag = imageView.getTag(2131755009)) != null && tag.equals(this.f42071o)) {
            imageView.setImageBitmap(fVar.b());
        }
    }

    private void b() throws com.qq.e.comm.plugin.p.d {
        this.f42066j = a(this.f42059c);
        com.qq.e.comm.plugin.p.j.f fVar = new com.qq.e.comm.plugin.p.j.f(this.f42066j, this.f42062f, 1, f42054q, false, this.f42065i);
        int d4 = d();
        v.a(1402201, null, Integer.valueOf(d4));
        long currentTimeMillis = System.currentTimeMillis();
        boolean g4 = fVar.g();
        if (g4) {
            if (this.f42069m) {
                if (t.c(this.f42062f)) {
                    this.f42070n = true;
                } else {
                    this.f42070n = false;
                    com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
                    dVar.a("rs", this.f42066j);
                    v.a(9130068, null, Integer.valueOf(d4), null, dVar);
                }
            }
            if (d4 > 100) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 1000) {
                    currentTimeMillis2 = 1000;
                }
                v.a(9130065, null, Integer.valueOf(d4), Integer.valueOf((int) (currentTimeMillis2 / 10)), null);
            }
        }
        if (!g4) {
            throw new com.qq.e.comm.plugin.p.d(fVar.b(), fVar.a());
        }
    }

    private void a(f.b bVar, boolean z3) {
        bVar.a(this.f42062f);
        bVar.b(z3);
        bVar.c(this.f42068l);
        bVar.a(this.f42069m);
        if (this.f42064h && this.f42061e != null) {
            f a4 = bVar.a();
            this.f42061e.a(this.f42059c, this.f42060d.get(), a4);
            return;
        }
        p0.a((Runnable) new b(bVar));
    }

    public e(File file, ImageView imageView, c cVar, boolean z3, Bitmap bitmap) {
        this(imageView, cVar, false, z3);
        this.f42062f = file;
        this.f42071o = file.getAbsolutePath();
        a(imageView, bitmap);
    }

    public e(String str, ImageView imageView, c cVar, boolean z3, boolean z4, Bitmap bitmap, String str2) {
        this(imageView, cVar, z3, z4);
        this.f42059c = str;
        this.f42068l = str.contains(f42057t);
        File file = new File(b1.b(), b1.e(str));
        this.f42062f = file;
        this.f42071o = file.getAbsolutePath();
        a(imageView, bitmap);
        this.f42065i = str2;
    }

    private String a(String str) {
        if (!this.f42067k && g.e().f(str)) {
            if (str.endsWith(f42057t)) {
                str = str.replace(f42057t, f42058u);
                this.f42068l = false;
            } else if (!str.endsWith(f42058u)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str.contains("?") ? "&" : "?");
                sb.append(f42058u);
                str = sb.toString();
            }
        }
        if (str.endsWith(f42058u)) {
            this.f42069m = true;
        }
        return str;
    }

    private f.b a() throws OutOfMemoryError {
        com.qq.e.lib.a.b.a a4;
        Movie b4 = t.b(this.f42062f);
        if (b4 != null) {
            return new f.b().a(b4);
        }
        if (f42056s.booleanValue() && (a4 = t.a(this.f42062f, this.f42059c)) != null) {
            return new f.b().a(a4);
        }
        Bitmap a5 = t.a(this.f42062f, this.f42060d.get(), this.f42069m && this.f42070n);
        if (a5 != null) {
            f42055r.put(c(), new SoftReference<>(a5));
            return new f.b().a(a5);
        }
        return null;
    }
}
