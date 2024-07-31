package com.bumptech.glide.load.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.bumptech.glide.load.model.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b */
    private static final Set<String> f14054b = Collections.unmodifiableSet(new HashSet(Arrays.asList(IDataSource.f43971a, "https")));

    /* renamed from: a */
    private final ModelLoader<GlideUrl, Data> f14055a;

    /* compiled from: UrlUriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.x$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3703a implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.m45046d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.f14055a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return this.f14055a.mo45003b(new GlideUrl(uri.toString()), i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return f14054b.contains(uri.getScheme());
    }
}
