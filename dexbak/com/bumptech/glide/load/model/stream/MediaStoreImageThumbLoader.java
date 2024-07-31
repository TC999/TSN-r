package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import com.stub.StubApp;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.stream.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a */
    private final Context f14038a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* renamed from: com.bumptech.glide.load.model.stream.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3691a implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a */
        private final Context f14039a;

        public C3691a(Context context) {
            this.f14039a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.f14039a);
        }
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f14038a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<InputStream> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        if (MediaStoreUtil.m45453d(i, i2)) {
            return new ModelLoader.C3678a<>(new ObjectKey(uri), ThumbFetcher.m45450e(this.f14038a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return MediaStoreUtil.m45456a(uri);
    }
}
