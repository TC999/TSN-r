package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.bumptech.glide.load.model.stream.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UrlLoader implements ModelLoader<URL, InputStream> {

    /* renamed from: a */
    private final ModelLoader<GlideUrl, InputStream> f14042a;

    /* compiled from: UrlLoader.java */
    /* renamed from: com.bumptech.glide.load.model.stream.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3693a implements ModelLoaderFactory<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<URL, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.m45046d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f14042a = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<InputStream> mo45003b(@NonNull URL url, int i, int i2, @NonNull Options options) {
        return this.f14042a.mo45003b(new GlideUrl(url), i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull URL url) {
        return true;
    }
}
