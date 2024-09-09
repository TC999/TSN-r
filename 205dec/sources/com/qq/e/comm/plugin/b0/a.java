package com.qq.e.comm.plugin.b0;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;
import com.qq.e.comm.plugin.b0.f;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.s0;
import java.io.File;
import java.lang.ref.SoftReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42037a = "com.qq.e.comm.plugin.b0.a";

    /* renamed from: b  reason: collision with root package name */
    private static final LruCache<String, SoftReference<Bitmap>> f42038b = new LruCache<>(5);

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.b0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class C0790a implements com.qq.e.comm.plugin.b0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f42039a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f42040b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f42041c;

        C0790a(String str, float f4, c cVar) {
            this.f42039a = str;
            this.f42040b = f4;
            this.f42041c = cVar;
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, int i4, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.b0.c
        public void a(String str, ImageView imageView, f fVar) {
            a.b(true, this.f42039a, fVar.b(), this.f42040b, this.f42041c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bitmap f42042c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f42043d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f42044e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f42045f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ c f42046g;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.b0.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0791a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bitmap f42047c;

            RunnableC0791a(Bitmap bitmap) {
                this.f42047c = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f42046g.a(new f.b().a(this.f42047c).b(false).a());
            }
        }

        b(Bitmap bitmap, float f4, String str, boolean z3, c cVar) {
            this.f42042c = bitmap;
            this.f42043d = f4;
            this.f42044e = str;
            this.f42045f = z3;
            this.f42046g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap b4 = a.b(this.f42042c, this.f42043d);
            d1.a(a.f42037a, "blur success, uniqueKey = %s, blurRadius = %s, time = %s", this.f42044e, Float.valueOf(this.f42043d), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            h hVar = new h(2130002);
            hVar.b(System.currentTimeMillis() - currentTimeMillis);
            v.a(hVar);
            if (this.f42045f) {
                a.f42038b.put(this.f42044e, new SoftReference(b4));
            }
            p0.a((Runnable) new RunnableC0791a(b4));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(f fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z3, String str, Bitmap bitmap, float f4, c cVar) {
        SoftReference<Bitmap> softReference;
        Bitmap bitmap2;
        if (bitmap == null) {
            return;
        }
        d1.a(f42037a, "blur start, uniqueKey = %s, blurRadius = %s", str, Float.valueOf(f4));
        if (z3 && (softReference = f42038b.get(str)) != null && (bitmap2 = softReference.get()) != null) {
            f a4 = new f.b().a(bitmap2).b(true).a();
            d1.a(f42037a, "blur hit cache, uniqueKey = %s, blurRadius = %s", str, Float.valueOf(f4));
            cVar.a(a4);
            return;
        }
        d0.f46406b.submit(new b(bitmap, f4, str, z3, cVar));
    }

    public static void a(String str, float f4, c cVar) {
        Bitmap bitmap;
        String a4 = a(str, f4);
        SoftReference<Bitmap> softReference = f42038b.get(a4);
        if (softReference != null && (bitmap = softReference.get()) != null) {
            cVar.a(new f.b().a(bitmap).b(true).a());
        } else {
            com.qq.e.comm.plugin.b0.b.a().a(str, (ImageView) null, new C0790a(a4, f4, cVar));
        }
    }

    public static void a(Object obj, Bitmap bitmap, float f4, c cVar) {
        if (!(obj instanceof String) && !(obj instanceof File)) {
            b(false, null, bitmap, f4, cVar);
        } else {
            b(true, a(obj, f4), bitmap, f4, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c9, code lost:
        if (r10 != null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(android.graphics.Bitmap r10, float r11) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.b0.a.b(android.graphics.Bitmap, float):android.graphics.Bitmap");
    }

    private static String a(Object obj, float f4) {
        String a4;
        if (obj instanceof String) {
            a4 = s0.a((String) obj);
        } else {
            a4 = obj instanceof File ? s0.a(((File) obj).getAbsolutePath()) : "";
        }
        return a4 + "_" + f4;
    }
}
