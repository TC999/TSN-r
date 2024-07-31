package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.stream.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: b */
    public static final Option<Integer> f14033b = Option.m45431g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    @Nullable

    /* renamed from: a */
    private final ModelCache<GlideUrl, GlideUrl> f14034a;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.model.stream.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3689a implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a */
        private final ModelCache<GlideUrl, GlideUrl> f14035a = new ModelCache<>(500);

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<GlideUrl, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f14035a);
        }
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<InputStream> mo45003b(@NonNull GlideUrl glideUrl, int i, int i2, @NonNull Options options) {
        ModelCache<GlideUrl, GlideUrl> modelCache = this.f14034a;
        if (modelCache != null) {
            GlideUrl m45071b = modelCache.m45071b(glideUrl, 0, 0);
            if (m45071b == null) {
                this.f14034a.m45070c(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = m45071b;
            }
        }
        return new ModelLoader.C3678a<>(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.m45124c(f14033b)).intValue()));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public HttpGlideUrlLoader(@Nullable ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.f14034a = modelCache;
    }
}
