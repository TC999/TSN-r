package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import com.stub.StubApp;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.stream.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a */
    private final Context f14040a;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* renamed from: com.bumptech.glide.load.model.stream.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3692a implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a */
        private final Context f14041a;

        public C3692a(Context context) {
            this.f14041a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f14041a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f14040a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: e */
    private boolean m45020e(Options options) {
        Long l = (Long) options.m45124c(VideoDecoder.f14075g);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    /* renamed from: c */
    public ModelLoader.C3678a<InputStream> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        if (MediaStoreUtil.m45453d(i, i2) && m45020e(options)) {
            return new ModelLoader.C3678a<>(new ObjectKey(uri), ThumbFetcher.m45449f(this.f14040a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return MediaStoreUtil.m45454c(uri);
    }
}
