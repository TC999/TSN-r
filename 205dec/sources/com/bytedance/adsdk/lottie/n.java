package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import com.stub.StubApp;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, q<com.bytedance.adsdk.lottie.e>> f25645a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Set<v> f25646b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f25647c = {80, 75, 3, 4};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f25648a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25649b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25650c;

        a(Context context, String str, String str2) {
            this.f25648a = context;
            this.f25649b = str;
            this.f25650c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> c4 = s.a(this.f25648a).c(this.f25648a, this.f25649b, this.f25650c);
            if (this.f25650c != null && c4.a() != null) {
                com.bytedance.adsdk.lottie.xv.e.b().c(this.f25650c, c4.a());
            }
            return c4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class b implements l<com.bytedance.adsdk.lottie.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f25651a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f25652b;

        b(String str, AtomicBoolean atomicBoolean) {
            this.f25651a = str;
            this.f25652b = atomicBoolean;
        }

        @Override // com.bytedance.adsdk.lottie.l
        /* renamed from: a */
        public void c(com.bytedance.adsdk.lottie.e eVar) {
            n.f25645a.remove(this.f25651a);
            this.f25652b.set(true);
            if (n.f25645a.size() == 0) {
                n.v(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements l<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f25653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f25654b;

        c(String str, AtomicBoolean atomicBoolean) {
            this.f25653a = str;
            this.f25654b = atomicBoolean;
        }

        @Override // com.bytedance.adsdk.lottie.l
        /* renamed from: a */
        public void c(Throwable th) {
            n.f25645a.remove(this.f25653a);
            this.f25654b.set(true);
            if (n.f25645a.size() == 0) {
                n.v(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class d implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f25655a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25656b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25657c;

        d(Context context, String str, String str2) {
            this.f25655a = context;
            this.f25656b = str;
            this.f25657c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            return n.x(this.f25655a, this.f25656b, this.f25657c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class e implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f25658a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f25659b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f25660c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25661d;

        e(WeakReference weakReference, Context context, int i4, String str) {
            this.f25658a = weakReference;
            this.f25659b = context;
            this.f25660c = i4;
            this.f25661d = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            Context context = (Context) this.f25658a.get();
            if (context == null) {
                context = this.f25659b;
            }
            return n.q(context, this.f25660c, this.f25661d);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class f implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f25662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25663b;

        f(InputStream inputStream, String str) {
            this.f25662a = inputStream;
            this.f25663b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            return n.s(this.f25662a, this.f25663b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class g implements Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bytedance.adsdk.lottie.e f25664a;

        g(com.bytedance.adsdk.lottie.e eVar) {
            this.f25664a = eVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> call() throws Exception {
            return new com.bytedance.adsdk.lottie.b<>(this.f25664a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class j<T> {

        /* renamed from: a  reason: collision with root package name */
        private float f25683a;

        /* renamed from: b  reason: collision with root package name */
        private float f25684b;

        /* renamed from: c  reason: collision with root package name */
        private T f25685c;

        /* renamed from: d  reason: collision with root package name */
        private T f25686d;

        /* renamed from: e  reason: collision with root package name */
        private float f25687e;

        /* renamed from: f  reason: collision with root package name */
        private float f25688f;

        /* renamed from: g  reason: collision with root package name */
        private float f25689g;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public j<T> a(float f4, float f5, T t3, T t4, float f6, float f7, float f8) {
            this.f25683a = f4;
            this.f25684b = f5;
            this.f25685c = t3;
            this.f25686d = t4;
            this.f25687e = f6;
            this.f25688f = f7;
            this.f25689g = f8;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class k<T> {

        /* renamed from: a  reason: collision with root package name */
        private final j<T> f25690a;

        /* renamed from: b  reason: collision with root package name */
        protected T f25691b;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final T a(float f4, float f5, T t3, T t4, float f6, float f7, float f8) {
            return b(this.f25690a.a(f4, f5, t3, t4, f6, f7, f8));
        }

        public T b(j<T> jVar) {
            return this.f25691b;
        }
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> a(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return r(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.f.b.k(zipInputStream);
        }
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> b(JsonReader jsonReader, String str) {
        return c(jsonReader, str, true);
    }

    private static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> c(JsonReader jsonReader, String str, boolean z3) {
        try {
            try {
                com.bytedance.adsdk.lottie.e a4 = s.q.a(jsonReader);
                com.bytedance.adsdk.lottie.xv.e.b().c(str, a4);
                com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> bVar = new com.bytedance.adsdk.lottie.b<>(a4);
                if (z3) {
                    m(jsonReader);
                }
                return bVar;
            } catch (Exception e4) {
                com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> bVar2 = new com.bytedance.adsdk.lottie.b<>(e4);
                if (z3) {
                    m(jsonReader);
                }
                return bVar2;
            }
        } catch (Throwable th) {
            if (z3) {
                m(jsonReader);
            }
            throw th;
        }
    }

    @WorkerThread
    private static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> d(InputStream inputStream, String str, boolean z3) {
        try {
            return b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z3) {
                com.bytedance.adsdk.lottie.f.b.k(inputStream);
            }
        }
    }

    private static com.bytedance.adsdk.lottie.h e(com.bytedance.adsdk.lottie.e eVar, String str) {
        for (com.bytedance.adsdk.lottie.h hVar : eVar.a().values()) {
            if (hVar.c().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    public static q<com.bytedance.adsdk.lottie.e> f(Context context, @RawRes int i4) {
        return g(context, i4, y(context, i4));
    }

    public static q<com.bytedance.adsdk.lottie.e> g(Context context, @RawRes int i4, String str) {
        return k(str, new e(new WeakReference(context), StubApp.getOrigApplicationContext(context.getApplicationContext()), i4, str));
    }

    public static q<com.bytedance.adsdk.lottie.e> h(Context context, String str) {
        return i(context, str, "url_" + str);
    }

    public static q<com.bytedance.adsdk.lottie.e> i(Context context, String str, String str2) {
        return k(str2, new a(context, str, str2));
    }

    public static q<com.bytedance.adsdk.lottie.e> j(InputStream inputStream, String str) {
        return k(str, new f(inputStream, str));
    }

    private static q<com.bytedance.adsdk.lottie.e> k(String str, Callable<com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e>> callable) {
        com.bytedance.adsdk.lottie.e a4 = str == null ? null : com.bytedance.adsdk.lottie.xv.e.b().a(str);
        if (a4 != null) {
            return new q<>(new g(a4));
        }
        if (str != null) {
            Map<String, q<com.bytedance.adsdk.lottie.e>> map = f25645a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        q<com.bytedance.adsdk.lottie.e> qVar = new q<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            qVar.b(new b(str, atomicBoolean));
            qVar.k(new c(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                Map<String, q<com.bytedance.adsdk.lottie.e>> map2 = f25645a;
                map2.put(str, qVar);
                if (map2.size() == 1) {
                    v(false);
                }
            }
        }
        return qVar;
    }

    public static void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    private static boolean o(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> p(Context context, @RawRes int i4) {
        return q(context, i4, y(context, i4));
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> q(Context context, @RawRes int i4, String str) {
        try {
            return s(context.getResources().openRawResource(i4), y(context, i4));
        } catch (Resources.NotFoundException e4) {
            return new com.bytedance.adsdk.lottie.b<>(e4);
        }
    }

    @WorkerThread
    private static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> r(Context context, ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.bytedance.adsdk.lottie.e eVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    eVar = c(new JsonReader(new InputStreamReader(zipInputStream)), null, false).a();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        if (!name.contains(".ttf") && !name.contains(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        String[] split = name.split(TTPathConst.sSeparator);
                        String str2 = split[split.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(w.w(context), str2);
                        new FileOutputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Typeface createFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            com.bytedance.adsdk.lottie.f.e.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        hashMap2.put(str3, createFromFile);
                    }
                    String[] split2 = name.split(TTPathConst.sSeparator);
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (eVar == null) {
                return new com.bytedance.adsdk.lottie.b<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                com.bytedance.adsdk.lottie.h e4 = e(eVar, (String) entry.getKey());
                if (e4 != null) {
                    e4.b(com.bytedance.adsdk.lottie.f.b.e((Bitmap) entry.getValue(), e4.a(), e4.e()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z3 = false;
                for (com.bytedance.adsdk.lottie.xv.f fVar : eVar.m().values()) {
                    if (fVar.a().equals(entry2.getKey())) {
                        fVar.b((Typeface) entry2.getValue());
                        z3 = true;
                    }
                }
                if (!z3) {
                    com.bytedance.adsdk.lottie.f.e.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                for (Map.Entry<String, com.bytedance.adsdk.lottie.h> entry3 : eVar.a().entrySet()) {
                    com.bytedance.adsdk.lottie.h value = entry3.getValue();
                    if (value == null) {
                        return null;
                    }
                    String c4 = value.c();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (c4.startsWith("data:") && c4.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(c4.substring(c4.indexOf(44) + 1), 0);
                            value.b(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e5) {
                            com.bytedance.adsdk.lottie.f.e.b("data URL did not have correct base64 format.", e5);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, com.bytedance.adsdk.lottie.h> entry4 : eVar.a().entrySet()) {
                if (entry4.getValue().d() == null) {
                    return new com.bytedance.adsdk.lottie.b<>(new IllegalStateException("There is no image for " + entry4.getValue().c()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.lottie.xv.e.b().c(str, eVar);
            }
            return new com.bytedance.adsdk.lottie.b<>(eVar);
        } catch (IOException e6) {
            return new com.bytedance.adsdk.lottie.b<>(e6);
        }
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> s(InputStream inputStream, String str) {
        return d(inputStream, str, true);
    }

    public static q<com.bytedance.adsdk.lottie.e> t(Context context, String str) {
        return u(context, str, "asset_" + str);
    }

    public static q<com.bytedance.adsdk.lottie.e> u(Context context, String str, String str2) {
        return k(str2, new d(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(boolean z3) {
        ArrayList arrayList = new ArrayList(f25646b);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ((v) arrayList.get(i4)).c(z3);
        }
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> w(Context context, String str) {
        return x(context, str, "asset_" + str);
    }

    @WorkerThread
    public static com.bytedance.adsdk.lottie.b<com.bytedance.adsdk.lottie.e> x(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return s(context.getAssets().open(str), str2);
            }
            return a(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e4) {
            return new com.bytedance.adsdk.lottie.b<>(e4);
        }
    }

    private static String y(Context context, @RawRes int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(o(context) ? "_night_" : "_day_");
        sb.append(i4);
        return sb.toString();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        private float f25681a;

        /* renamed from: b  reason: collision with root package name */
        private float f25682b;

        public i(float f4, float f5) {
            this.f25681a = f4;
            this.f25682b = f5;
        }

        public float a() {
            return this.f25681a;
        }

        public void b(float f4, float f5) {
            this.f25681a = f4;
            this.f25682b = f5;
        }

        public float c() {
            return this.f25682b;
        }

        public boolean d(float f4, float f5) {
            return this.f25681a == f4 && this.f25682b == f5;
        }

        public String toString() {
            return a() + "x" + c();
        }

        public i() {
            this(1.0f, 1.0f);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class h<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.e f25665a;

        /* renamed from: b  reason: collision with root package name */
        public final T f25666b;

        /* renamed from: c  reason: collision with root package name */
        public T f25667c;

        /* renamed from: d  reason: collision with root package name */
        public final Interpolator f25668d;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f25669e;

        /* renamed from: f  reason: collision with root package name */
        public final Interpolator f25670f;

        /* renamed from: g  reason: collision with root package name */
        public final float f25671g;

        /* renamed from: h  reason: collision with root package name */
        public Float f25672h;

        /* renamed from: i  reason: collision with root package name */
        private float f25673i;

        /* renamed from: j  reason: collision with root package name */
        private float f25674j;

        /* renamed from: k  reason: collision with root package name */
        private int f25675k;

        /* renamed from: l  reason: collision with root package name */
        private int f25676l;

        /* renamed from: m  reason: collision with root package name */
        private float f25677m;

        /* renamed from: n  reason: collision with root package name */
        private float f25678n;

        /* renamed from: o  reason: collision with root package name */
        public PointF f25679o;

        /* renamed from: p  reason: collision with root package name */
        public PointF f25680p;

        public h(com.bytedance.adsdk.lottie.e eVar, T t3, T t4, Interpolator interpolator, float f4, Float f5) {
            this.f25673i = -3987645.8f;
            this.f25674j = -3987645.8f;
            this.f25675k = 784923401;
            this.f25676l = 784923401;
            this.f25677m = Float.MIN_VALUE;
            this.f25678n = Float.MIN_VALUE;
            this.f25679o = null;
            this.f25680p = null;
            this.f25665a = eVar;
            this.f25666b = t3;
            this.f25667c = t4;
            this.f25668d = interpolator;
            this.f25669e = null;
            this.f25670f = null;
            this.f25671g = f4;
            this.f25672h = f5;
        }

        public h<T> a(T t3, T t4) {
            return new h<>(t3, t4);
        }

        public boolean b(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
            return f4 >= i() && f4 < g();
        }

        public int c() {
            if (this.f25675k == 784923401) {
                this.f25675k = ((Integer) this.f25666b).intValue();
            }
            return this.f25675k;
        }

        public float d() {
            if (this.f25673i == -3987645.8f) {
                this.f25673i = ((Float) this.f25666b).floatValue();
            }
            return this.f25673i;
        }

        public int e() {
            if (this.f25676l == 784923401) {
                this.f25676l = ((Integer) this.f25667c).intValue();
            }
            return this.f25676l;
        }

        public float f() {
            if (this.f25674j == -3987645.8f) {
                this.f25674j = ((Float) this.f25667c).floatValue();
            }
            return this.f25674j;
        }

        public float g() {
            if (this.f25665a == null) {
                return 1.0f;
            }
            if (this.f25678n == Float.MIN_VALUE) {
                if (this.f25672h == null) {
                    this.f25678n = 1.0f;
                } else {
                    this.f25678n = i() + ((this.f25672h.floatValue() - this.f25671g) / this.f25665a.b());
                }
            }
            return this.f25678n;
        }

        public boolean h() {
            return this.f25668d == null && this.f25669e == null && this.f25670f == null;
        }

        public float i() {
            com.bytedance.adsdk.lottie.e eVar = this.f25665a;
            if (eVar == null) {
                return 0.0f;
            }
            if (this.f25677m == Float.MIN_VALUE) {
                this.f25677m = (this.f25671g - eVar.k()) / this.f25665a.b();
            }
            return this.f25677m;
        }

        public String toString() {
            return "Keyframe{startValue=" + this.f25666b + ", endValue=" + this.f25667c + ", startFrame=" + this.f25671g + ", endFrame=" + this.f25672h + ", interpolator=" + this.f25668d + '}';
        }

        public h(com.bytedance.adsdk.lottie.e eVar, T t3, T t4, Interpolator interpolator, Interpolator interpolator2, float f4, Float f5) {
            this.f25673i = -3987645.8f;
            this.f25674j = -3987645.8f;
            this.f25675k = 784923401;
            this.f25676l = 784923401;
            this.f25677m = Float.MIN_VALUE;
            this.f25678n = Float.MIN_VALUE;
            this.f25679o = null;
            this.f25680p = null;
            this.f25665a = eVar;
            this.f25666b = t3;
            this.f25667c = t4;
            this.f25668d = null;
            this.f25669e = interpolator;
            this.f25670f = interpolator2;
            this.f25671g = f4;
            this.f25672h = f5;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public h(com.bytedance.adsdk.lottie.e eVar, T t3, T t4, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f4, Float f5) {
            this.f25673i = -3987645.8f;
            this.f25674j = -3987645.8f;
            this.f25675k = 784923401;
            this.f25676l = 784923401;
            this.f25677m = Float.MIN_VALUE;
            this.f25678n = Float.MIN_VALUE;
            this.f25679o = null;
            this.f25680p = null;
            this.f25665a = eVar;
            this.f25666b = t3;
            this.f25667c = t4;
            this.f25668d = interpolator;
            this.f25669e = interpolator2;
            this.f25670f = interpolator3;
            this.f25671g = f4;
            this.f25672h = f5;
        }

        public h(T t3) {
            this.f25673i = -3987645.8f;
            this.f25674j = -3987645.8f;
            this.f25675k = 784923401;
            this.f25676l = 784923401;
            this.f25677m = Float.MIN_VALUE;
            this.f25678n = Float.MIN_VALUE;
            this.f25679o = null;
            this.f25680p = null;
            this.f25665a = null;
            this.f25666b = t3;
            this.f25667c = t3;
            this.f25668d = null;
            this.f25669e = null;
            this.f25670f = null;
            this.f25671g = Float.MIN_VALUE;
            this.f25672h = Float.valueOf(Float.MAX_VALUE);
        }

        private h(T t3, T t4) {
            this.f25673i = -3987645.8f;
            this.f25674j = -3987645.8f;
            this.f25675k = 784923401;
            this.f25676l = 784923401;
            this.f25677m = Float.MIN_VALUE;
            this.f25678n = Float.MIN_VALUE;
            this.f25679o = null;
            this.f25680p = null;
            this.f25665a = null;
            this.f25666b = t3;
            this.f25667c = t4;
            this.f25668d = null;
            this.f25669e = null;
            this.f25670f = null;
            this.f25671g = Float.MIN_VALUE;
            this.f25672h = Float.valueOf(Float.MAX_VALUE);
        }
    }
}
