package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.bumptech.glide.load.model.stream.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpUriLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: b */
    private static final Set<String> f14036b = Collections.unmodifiableSet(new HashSet(Arrays.asList(IDataSource.f43971a, "https")));

    /* renamed from: a */
    private final ModelLoader<GlideUrl, InputStream> f14037a;

    /* compiled from: HttpUriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.stream.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3690a implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.m45046d(GlideUrl.class, InputStream.class));
        }
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f14037a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<InputStream> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return this.f14037a.mo45003b(new GlideUrl(uri.toString()), i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return f14036b.contains(uri.getScheme());
    }
}
