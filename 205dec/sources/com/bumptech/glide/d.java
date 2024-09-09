package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.engine.prefill.d;
import com.bumptech.glide.load.model.a;
import com.bumptech.glide.load.model.b;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.e;
import com.bumptech.glide.load.model.f;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.s;
import com.bumptech.glide.load.model.stream.b;
import com.bumptech.glide.load.model.stream.c;
import com.bumptech.glide.load.model.stream.d;
import com.bumptech.glide.load.model.stream.e;
import com.bumptech.glide.load.model.stream.f;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.load.model.u;
import com.bumptech.glide.load.model.v;
import com.bumptech.glide.load.model.w;
import com.bumptech.glide.load.model.x;
import com.bumptech.glide.load.resource.bitmap.a0;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.request.target.p;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Glide.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d implements ComponentCallbacks2 {

    /* renamed from: l  reason: collision with root package name */
    private static final String f16576l = "image_manager_disk_cache";

    /* renamed from: m  reason: collision with root package name */
    private static final String f16577m = "Glide";

    /* renamed from: n  reason: collision with root package name */
    private static volatile d f16578n;

    /* renamed from: o  reason: collision with root package name */
    private static volatile boolean f16579o;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.k f16580a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f16581b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.j f16582c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.prefill.b f16583d;

    /* renamed from: e  reason: collision with root package name */
    private final f f16584e;

    /* renamed from: f  reason: collision with root package name */
    private final Registry f16585f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f16586g;

    /* renamed from: h  reason: collision with root package name */
    private final l f16587h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.manager.d f16588i;

    /* renamed from: j  reason: collision with root package name */
    private final List<j> f16589j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private MemoryCategory f16590k = MemoryCategory.NORMAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.k kVar, @NonNull com.bumptech.glide.load.engine.cache.j jVar, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar, @NonNull l lVar, @NonNull com.bumptech.glide.manager.d dVar, int i4, @NonNull com.bumptech.glide.request.h hVar, @NonNull Map<Class<?>, k<?, ?>> map, @NonNull List<com.bumptech.glide.request.g<Object>> list, boolean z3) {
        this.f16580a = kVar;
        this.f16581b = eVar;
        this.f16586g = bVar;
        this.f16582c = jVar;
        this.f16587h = lVar;
        this.f16588i = dVar;
        this.f16583d = new com.bumptech.glide.load.engine.prefill.b(jVar, eVar, (DecodeFormat) hVar.K().c(n.f17442g));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f16585f = registry;
        registry.t(new m());
        if (Build.VERSION.SDK_INT >= 27) {
            registry.t(new q());
        }
        List<ImageHeaderParser> g4 = registry.g();
        n nVar = new n(g4, resources.getDisplayMetrics(), eVar, bVar);
        com.bumptech.glide.load.resource.gif.a aVar = new com.bumptech.glide.load.resource.gif.a(context, g4, eVar, bVar);
        com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> g5 = c0.g(eVar);
        com.bumptech.glide.load.resource.bitmap.i iVar = new com.bumptech.glide.load.resource.bitmap.i(nVar);
        y yVar = new y(nVar, bVar);
        com.bumptech.glide.load.resource.drawable.e eVar2 = new com.bumptech.glide.load.resource.drawable.e(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.e eVar3 = new com.bumptech.glide.load.resource.bitmap.e(bVar);
        com.bumptech.glide.load.resource.transcode.a aVar3 = new com.bumptech.glide.load.resource.transcode.a();
        com.bumptech.glide.load.resource.transcode.d dVar3 = new com.bumptech.glide.load.resource.transcode.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry u3 = registry.a(ByteBuffer.class, new com.bumptech.glide.load.model.c()).a(InputStream.class, new t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, iVar).e("Bitmap", InputStream.class, Bitmap.class, yVar).e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, g5).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, c0.c(eVar)).d(Bitmap.class, Bitmap.class, v.a.b()).e("Bitmap", Bitmap.class, Bitmap.class, new a0()).b(Bitmap.class, eVar3).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, iVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, yVar)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, g5)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar, eVar3)).e("Gif", InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.i(g4, aVar, bVar)).e("Gif", ByteBuffer.class, GifDrawable.class, aVar).b(GifDrawable.class, new com.bumptech.glide.load.resource.gif.c()).d(GifDecoder.class, GifDecoder.class, v.a.b()).e("Bitmap", GifDecoder.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.g(eVar)).c(Uri.class, Drawable.class, eVar2).c(Uri.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.v(eVar2, eVar)).u(new a.C1244a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new o.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.b()).u(new k.a(bVar));
        Class cls = Integer.TYPE;
        u3.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar2).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar2).d(Integer.class, Uri.class, dVar2).d(cls, AssetFileDescriptor.class, aVar2).d(Integer.class, AssetFileDescriptor.class, aVar2).d(cls, Uri.class, dVar2).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new c.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new d.a(context)).d(Uri.class, InputStream.class, new e.a(context)).d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new f.a()).d(Uri.class, File.class, new k.a(context)).d(com.bumptech.glide.load.model.g.class, InputStream.class, new b.a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.b()).d(Drawable.class, Drawable.class, v.a.b()).c(Drawable.class, Drawable.class, new com.bumptech.glide.load.resource.drawable.f()).x(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.transcode.b(resources)).x(Bitmap.class, byte[].class, aVar3).x(Drawable.class, byte[].class, new com.bumptech.glide.load.resource.transcode.c(eVar, aVar3, dVar3)).x(GifDrawable.class, byte[].class, dVar3);
        this.f16584e = new f(context, bVar, registry, new com.bumptech.glide.request.target.k(), hVar, map, list, kVar, z3, i4);
    }

    @NonNull
    public static j A(@NonNull Activity activity) {
        return n(activity).i(activity);
    }

    @NonNull
    @Deprecated
    public static j B(@NonNull Fragment fragment) {
        return n(fragment.getActivity()).j(fragment);
    }

    @NonNull
    public static j C(@NonNull Context context) {
        return n(context).k(context);
    }

    @NonNull
    public static j D(@NonNull View view) {
        return n(view.getContext()).l(view);
    }

    @NonNull
    public static j E(@NonNull androidx.fragment.app.Fragment fragment) {
        return n(fragment.getActivity()).m(fragment);
    }

    @NonNull
    public static j F(@NonNull FragmentActivity fragmentActivity) {
        return n(fragmentActivity).n(fragmentActivity);
    }

    private static void a(@NonNull Context context) {
        if (!f16579o) {
            f16579o = true;
            q(context);
            f16579o = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static d d(@NonNull Context context) {
        if (f16578n == null) {
            synchronized (d.class) {
                if (f16578n == null) {
                    a(context);
                }
            }
        }
        return f16578n;
    }

    @Nullable
    private static b e() {
        try {
            return (b) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e4) {
            x(e4);
            return null;
        } catch (InstantiationException e5) {
            x(e5);
            return null;
        } catch (NoSuchMethodException e6) {
            x(e6);
            return null;
        } catch (InvocationTargetException e7) {
            x(e7);
            return null;
        }
    }

    @Nullable
    public static File j(@NonNull Context context) {
        return k(context, "image_manager_disk_cache");
    }

    @Nullable
    public static File k(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Glide", 6)) {
            Log.e("Glide", "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    private static l n(@Nullable Context context) {
        com.bumptech.glide.util.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return d(context).m();
    }

    @VisibleForTesting
    public static synchronized void o(@NonNull Context context, @NonNull e eVar) {
        synchronized (d.class) {
            if (f16578n != null) {
                w();
            }
            r(context, eVar);
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void p(d dVar) {
        synchronized (d.class) {
            if (f16578n != null) {
                w();
            }
            f16578n = dVar;
        }
    }

    private static void q(@NonNull Context context) {
        r(context, new e());
    }

    private static void r(@NonNull Context context, @NonNull e eVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        b e4 = e();
        List<com.bumptech.glide.module.c> emptyList = Collections.emptyList();
        if (e4 == null || e4.c()) {
            emptyList = new com.bumptech.glide.module.e(origApplicationContext).a();
        }
        if (e4 != null && !e4.d().isEmpty()) {
            Set<Class<?>> d4 = e4.d();
            Iterator<com.bumptech.glide.module.c> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.module.c next = it.next();
                if (d4.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.module.c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        eVar.r(e4 != null ? e4.e() : null);
        for (com.bumptech.glide.module.c cVar : emptyList) {
            cVar.a(origApplicationContext, eVar);
        }
        if (e4 != null) {
            e4.a(origApplicationContext, eVar);
        }
        d b4 = eVar.b(origApplicationContext);
        for (com.bumptech.glide.module.c cVar2 : emptyList) {
            cVar2.b(origApplicationContext, b4, b4.f16585f);
        }
        if (e4 != null) {
            e4.b(origApplicationContext, b4, b4.f16585f);
        }
        origApplicationContext.registerComponentCallbacks(b4);
        f16578n = b4;
    }

    @VisibleForTesting
    public static synchronized void w() {
        synchronized (d.class) {
            if (f16578n != null) {
                StubApp.getOrigApplicationContext(f16578n.getContext().getApplicationContext()).unregisterComponentCallbacks(f16578n);
                f16578n.f16580a.l();
            }
            f16578n = null;
        }
    }

    private static void x(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void b() {
        com.bumptech.glide.util.k.a();
        this.f16580a.e();
    }

    public void c() {
        com.bumptech.glide.util.k.b();
        this.f16582c.b();
        this.f16581b.b();
        this.f16586g.b();
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.b f() {
        return this.f16586g;
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.e g() {
        return this.f16581b;
    }

    @NonNull
    public Context getContext() {
        return this.f16584e.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.manager.d h() {
        return this.f16588i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public f i() {
        return this.f16584e;
    }

    @NonNull
    public Registry l() {
        return this.f16585f;
    }

    @NonNull
    public l m() {
        return this.f16587h;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        c();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        y(i4);
    }

    public void s(@NonNull d.a... aVarArr) {
        this.f16583d.c(aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(j jVar) {
        synchronized (this.f16589j) {
            if (!this.f16589j.contains(jVar)) {
                this.f16589j.add(jVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(@NonNull p<?> pVar) {
        synchronized (this.f16589j) {
            for (j jVar : this.f16589j) {
                if (jVar.X(pVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public MemoryCategory v(@NonNull MemoryCategory memoryCategory) {
        com.bumptech.glide.util.k.b();
        this.f16582c.c(memoryCategory.getMultiplier());
        this.f16581b.c(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f16590k;
        this.f16590k = memoryCategory;
        return memoryCategory2;
    }

    public void y(int i4) {
        com.bumptech.glide.util.k.b();
        this.f16582c.a(i4);
        this.f16581b.a(i4);
        this.f16586g.a(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(j jVar) {
        synchronized (this.f16589j) {
            if (this.f16589j.contains(jVar)) {
                this.f16589j.remove(jVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
