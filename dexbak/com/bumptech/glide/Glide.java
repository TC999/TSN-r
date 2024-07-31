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
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
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
import p622n.ByteBufferRewinder;
import p625o.FileDecoder;

/* renamed from: com.bumptech.glide.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Glide implements ComponentCallbacks2 {

    /* renamed from: l */
    private static final String f13232l = "image_manager_disk_cache";

    /* renamed from: m */
    private static final String f13233m = "Glide";

    /* renamed from: n */
    private static volatile Glide f13234n;

    /* renamed from: o */
    private static volatile boolean f13235o;

    /* renamed from: a */
    private final Engine f13236a;

    /* renamed from: b */
    private final BitmapPool f13237b;

    /* renamed from: c */
    private final MemoryCache f13238c;

    /* renamed from: d */
    private final BitmapPreFiller f13239d;

    /* renamed from: e */
    private final GlideContext f13240e;

    /* renamed from: f */
    private final Registry f13241f;

    /* renamed from: g */
    private final ArrayPool f13242g;

    /* renamed from: h */
    private final RequestManagerRetriever f13243h;

    /* renamed from: i */
    private final ConnectivityMonitorFactory f13244i;

    /* renamed from: j */
    private final List<C3558j> f13245j = new ArrayList();

    /* renamed from: k */
    private MemoryCategory f13246k = MemoryCategory.NORMAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Glide(@NonNull Context context, @NonNull Engine engine, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, boolean z) {
        this.f13236a = engine;
        this.f13237b = bitmapPool;
        this.f13242g = arrayPool;
        this.f13238c = memoryCache;
        this.f13243h = requestManagerRetriever;
        this.f13244i = connectivityMonitorFactory;
        this.f13239d = new BitmapPreFiller(memoryCache, bitmapPool, (DecodeFormat) requestOptions.m44661K().m45124c(Downsampler.f14125g));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f13241f = registry;
        registry.m45766t(new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            registry.m45766t(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> m45779g = registry.m45779g();
        Downsampler downsampler = new Downsampler(m45779g, resources.getDisplayMetrics(), bitmapPool, arrayPool);
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, m45779g, bitmapPool, arrayPool);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> m44987g = VideoDecoder.m44987g(bitmapPool);
        ByteBufferBitmapDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.C3687c c3687c = new ResourceLoader.C3687c(resources);
        ResourceLoader.C3688d c3688d = new ResourceLoader.C3688d(resources);
        ResourceLoader.C3686b c3686b = new ResourceLoader.C3686b(resources);
        ResourceLoader.C3685a c3685a = new ResourceLoader.C3685a(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        Registry m45765u = registry.m45785a(ByteBuffer.class, new ByteBufferEncoder()).m45785a(InputStream.class, new StreamEncoder(arrayPool)).m45781e(Registry.f13212l, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).m45781e(Registry.f13212l, InputStream.class, Bitmap.class, streamBitmapDecoder).m45781e(Registry.f13212l, ParcelFileDescriptor.class, Bitmap.class, m44987g).m45781e(Registry.f13212l, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.m44991c(bitmapPool)).m45782d(Bitmap.class, Bitmap.class, UnitModelLoader.C3697a.m45011b()).m45781e(Registry.f13212l, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).m45784b(Bitmap.class, bitmapEncoder).m45781e(Registry.f13213m, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).m45781e(Registry.f13213m, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).m45781e(Registry.f13213m, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, m44987g)).m45784b(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).m45781e(Registry.f13211k, InputStream.class, GifDrawable.class, new StreamGifDecoder(m45779g, byteBufferGifDecoder, arrayPool)).m45781e(Registry.f13211k, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).m45784b(GifDrawable.class, new GifDrawableEncoder()).m45782d(GifDecoder.class, GifDecoder.class, UnitModelLoader.C3697a.m45011b()).m45781e(Registry.f13212l, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).m45783c(Uri.class, Drawable.class, resourceDrawableDecoder).m45783c(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).m45765u(new ByteBufferRewinder.C15372a()).m45782d(File.class, ByteBuffer.class, new ByteBufferFileLoader.C3658b()).m45782d(File.class, InputStream.class, new FileLoader.C3668e()).m45783c(File.class, File.class, new FileDecoder()).m45782d(File.class, ParcelFileDescriptor.class, new FileLoader.C3664b()).m45782d(File.class, File.class, UnitModelLoader.C3697a.m45011b()).m45765u(new InputStreamRewinder.C3568a(arrayPool));
        Class cls = Integer.TYPE;
        m45765u.m45782d(cls, InputStream.class, c3687c).m45782d(cls, ParcelFileDescriptor.class, c3686b).m45782d(Integer.class, InputStream.class, c3687c).m45782d(Integer.class, ParcelFileDescriptor.class, c3686b).m45782d(Integer.class, Uri.class, c3688d).m45782d(cls, AssetFileDescriptor.class, c3685a).m45782d(Integer.class, AssetFileDescriptor.class, c3685a).m45782d(cls, Uri.class, c3688d).m45782d(String.class, InputStream.class, new DataUrlLoader.C3661c()).m45782d(Uri.class, InputStream.class, new DataUrlLoader.C3661c()).m45782d(String.class, InputStream.class, new StringLoader.C3696c()).m45782d(String.class, ParcelFileDescriptor.class, new StringLoader.C3695b()).m45782d(String.class, AssetFileDescriptor.class, new StringLoader.C3694a()).m45782d(Uri.class, InputStream.class, new HttpUriLoader.C3690a()).m45782d(Uri.class, InputStream.class, new AssetUriLoader.C3650c(context.getAssets())).m45782d(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.C3649b(context.getAssets())).m45782d(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.C3691a(context)).m45782d(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.C3692a(context)).m45782d(Uri.class, InputStream.class, new UriLoader.C3702d(contentResolver)).m45782d(Uri.class, ParcelFileDescriptor.class, new UriLoader.C3700b(contentResolver)).m45782d(Uri.class, AssetFileDescriptor.class, new UriLoader.C3699a(contentResolver)).m45782d(Uri.class, InputStream.class, new UrlUriLoader.C3703a()).m45782d(URL.class, InputStream.class, new UrlLoader.C3693a()).m45782d(Uri.class, File.class, new MediaStoreFileLoader.C3674a(context)).m45782d(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.C3689a()).m45782d(byte[].class, ByteBuffer.class, new ByteArrayLoader.C3651a()).m45782d(byte[].class, InputStream.class, new ByteArrayLoader.C3655d()).m45782d(Uri.class, Uri.class, UnitModelLoader.C3697a.m45011b()).m45782d(Drawable.class, Drawable.class, UnitModelLoader.C3697a.m45011b()).m45783c(Drawable.class, Drawable.class, new UnitDrawableDecoder()).m45762x(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).m45762x(Bitmap.class, byte[].class, bitmapBytesTranscoder).m45762x(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).m45762x(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        this.f13240e = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptions, map, list, engine, z, i);
    }

    @NonNull
    /* renamed from: A */
    public static C3558j m45753A(@NonNull Activity activity) {
        return m45734n(activity).m44740i(activity);
    }

    @NonNull
    @Deprecated
    /* renamed from: B */
    public static C3558j m45752B(@NonNull Fragment fragment) {
        return m45734n(fragment.getActivity()).m44739j(fragment);
    }

    @NonNull
    /* renamed from: C */
    public static C3558j m45751C(@NonNull Context context) {
        return m45734n(context).m44738k(context);
    }

    @NonNull
    /* renamed from: D */
    public static C3558j m45750D(@NonNull View view) {
        return m45734n(view.getContext()).m44737l(view);
    }

    @NonNull
    /* renamed from: E */
    public static C3558j m45749E(@NonNull androidx.fragment.app.Fragment fragment) {
        return m45734n(fragment.getActivity()).m44736m(fragment);
    }

    @NonNull
    /* renamed from: F */
    public static C3558j m45748F(@NonNull FragmentActivity fragmentActivity) {
        return m45734n(fragmentActivity).m44735n(fragmentActivity);
    }

    /* renamed from: a */
    private static void m45747a(@NonNull Context context) {
        if (!f13235o) {
            f13235o = true;
            m45731q(context);
            f13235o = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    /* renamed from: d */
    public static Glide m45744d(@NonNull Context context) {
        if (f13234n == null) {
            synchronized (Glide.class) {
                if (f13234n == null) {
                    m45747a(context);
                }
            }
        }
        return f13234n;
    }

    @Nullable
    /* renamed from: e */
    private static GeneratedAppGlideModule m45743e() {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(f13233m, 5)) {
                Log.w(f13233m, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e) {
            m45724x(e);
            return null;
        } catch (InstantiationException e2) {
            m45724x(e2);
            return null;
        } catch (NoSuchMethodException e3) {
            m45724x(e3);
            return null;
        } catch (InvocationTargetException e4) {
            m45724x(e4);
            return null;
        }
    }

    @Nullable
    /* renamed from: j */
    public static File m45738j(@NonNull Context context) {
        return m45737k(context, "image_manager_disk_cache");
    }

    @Nullable
    /* renamed from: k */
    public static File m45737k(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable(f13233m, 6)) {
            Log.e(f13233m, "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    /* renamed from: n */
    private static RequestManagerRetriever m45734n(@Nullable Context context) {
        C3770j.m44391e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m45744d(context).m45735m();
    }

    @VisibleForTesting
    /* renamed from: o */
    public static synchronized void m45733o(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        synchronized (Glide.class) {
            if (f13234n != null) {
                m45725w();
            }
            m45730r(context, glideBuilder);
        }
    }

    @VisibleForTesting
    @Deprecated
    /* renamed from: p */
    public static synchronized void m45732p(Glide glide) {
        synchronized (Glide.class) {
            if (f13234n != null) {
                m45725w();
            }
            f13234n = glide;
        }
    }

    /* renamed from: q */
    private static void m45731q(@NonNull Context context) {
        m45730r(context, new GlideBuilder());
    }

    /* renamed from: r */
    private static void m45730r(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        GeneratedAppGlideModule m45743e = m45743e();
        List<GlideModule> emptyList = Collections.emptyList();
        if (m45743e == null || m45743e.mo44711c()) {
            emptyList = new ManifestParser(origApplicationContext).m44709a();
        }
        if (m45743e != null && !m45743e.m45759d().isEmpty()) {
            Set<Class<?>> m45759d = m45743e.m45759d();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (m45759d.contains(next.getClass())) {
                    if (Log.isLoggable(f13233m, 3)) {
                        Log.d(f13233m, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(f13233m, 3)) {
            Iterator<GlideModule> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d(f13233m, "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        glideBuilder.m45640r(m45743e != null ? m45743e.m45758e() : null);
        for (GlideModule glideModule : emptyList) {
            glideModule.mo44710a(origApplicationContext, glideBuilder);
        }
        if (m45743e != null) {
            m45743e.mo44710a(origApplicationContext, glideBuilder);
        }
        Glide m45656b = glideBuilder.m45656b(origApplicationContext);
        for (GlideModule glideModule2 : emptyList) {
            glideModule2.mo44706b(origApplicationContext, m45656b, m45656b.f13241f);
        }
        if (m45743e != null) {
            m45743e.mo44706b(origApplicationContext, m45656b, m45656b.f13241f);
        }
        origApplicationContext.registerComponentCallbacks(m45656b);
        f13234n = m45656b;
    }

    @VisibleForTesting
    /* renamed from: w */
    public static synchronized void m45725w() {
        synchronized (Glide.class) {
            if (f13234n != null) {
                StubApp.getOrigApplicationContext(f13234n.getContext().getApplicationContext()).unregisterComponentCallbacks(f13234n);
                f13234n.f13236a.m45209l();
            }
            f13234n = null;
        }
    }

    /* renamed from: x */
    private static void m45724x(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* renamed from: b */
    public void m45746b() {
        C3771k.m44390a();
        this.f13236a.m45216e();
    }

    /* renamed from: c */
    public void m45745c() {
        C3771k.m44389b();
        this.f13238c.mo45321b();
        this.f13237b.mo45375b();
        this.f13242g.mo45395b();
    }

    @NonNull
    /* renamed from: f */
    public ArrayPool m45742f() {
        return this.f13242g;
    }

    @NonNull
    /* renamed from: g */
    public BitmapPool m45741g() {
        return this.f13237b;
    }

    @NonNull
    public Context getContext() {
        return this.f13240e.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public ConnectivityMonitorFactory m45740h() {
        return this.f13244i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: i */
    public GlideContext m45739i() {
        return this.f13240e;
    }

    @NonNull
    /* renamed from: l */
    public Registry m45736l() {
        return this.f13241f;
    }

    @NonNull
    /* renamed from: m */
    public RequestManagerRetriever m45735m() {
        return this.f13243h;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        m45745c();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        m45723y(i);
    }

    /* renamed from: s */
    public void m45729s(@NonNull PreFillType.C3645a... c3645aArr) {
        this.f13239d.m45158c(c3645aArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public void m45728t(C3558j c3558j) {
        synchronized (this.f13245j) {
            if (!this.f13245j.contains(c3558j)) {
                this.f13245j.add(c3558j);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean m45727u(@NonNull Target<?> target) {
        synchronized (this.f13245j) {
            for (C3558j c3558j : this.f13245j) {
                if (c3558j.m45510X(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    /* renamed from: v */
    public MemoryCategory m45726v(@NonNull MemoryCategory memoryCategory) {
        C3771k.m44389b();
        this.f13238c.mo45320c(memoryCategory.getMultiplier());
        this.f13237b.mo45374c(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f13246k;
        this.f13246k = memoryCategory;
        return memoryCategory2;
    }

    /* renamed from: y */
    public void m45723y(int i) {
        C3771k.m44389b();
        this.f13238c.mo45322a(i);
        this.f13237b.mo45376a(i);
        this.f13242g.mo45396a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public void m45722z(C3558j c3558j) {
        synchronized (this.f13245j) {
            if (this.f13245j.contains(c3558j)) {
                this.f13245j.remove(c3558j);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
