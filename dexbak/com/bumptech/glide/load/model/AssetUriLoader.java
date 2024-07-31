package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.bumptech.glide.load.model.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: c */
    private static final String f13939c = "android_asset";

    /* renamed from: d */
    private static final String f13940d = "file:///android_asset/";

    /* renamed from: e */
    private static final int f13941e = 22;

    /* renamed from: a */
    private final AssetManager f13942a;

    /* renamed from: b */
    private final InterfaceC3648a<Data> f13943b;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3648a<Data> {
        /* renamed from: b */
        DataFetcher<Data> mo45118b(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3649b implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, InterfaceC3648a<ParcelFileDescriptor> {

        /* renamed from: a */
        private final AssetManager f13944a;

        public C3649b(AssetManager assetManager) {
            this.f13944a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.InterfaceC3648a
        /* renamed from: b */
        public DataFetcher<ParcelFileDescriptor> mo45118b(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, ParcelFileDescriptor> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f13944a, this);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3650c implements ModelLoaderFactory<Uri, InputStream>, InterfaceC3648a<InputStream> {

        /* renamed from: a */
        private final AssetManager f13945a;

        public C3650c(AssetManager assetManager) {
            this.f13945a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.InterfaceC3648a
        /* renamed from: b */
        public DataFetcher<InputStream> mo45118b(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f13945a, this);
        }
    }

    public AssetUriLoader(AssetManager assetManager, InterfaceC3648a<Data> interfaceC3648a) {
        this.f13942a = assetManager;
        this.f13943b = interfaceC3648a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(uri), this.f13943b.mo45118b(this.f13942a, uri.toString().substring(f13941e)));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return IDataSource.f43973c.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f13939c.equals(uri.getPathSegments().get(0));
    }
}
