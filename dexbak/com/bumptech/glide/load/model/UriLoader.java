package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.bumptech.glide.load.model.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b */
    private static final Set<String> f14049b = Collections.unmodifiableSet(new HashSet(Arrays.asList(IDataSource.f43973c, "android.resource", "content")));

    /* renamed from: a */
    private final InterfaceC3701c<Data> f14050a;

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.w$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3699a implements ModelLoaderFactory<Uri, AssetFileDescriptor>, InterfaceC3701c<AssetFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f14051a;

        public C3699a(ContentResolver contentResolver) {
            this.f14051a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.UriLoader.InterfaceC3701c
        /* renamed from: b */
        public DataFetcher<AssetFileDescriptor> mo45005b(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f14051a, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: c */
        public ModelLoader<Uri, AssetFileDescriptor> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.w$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3700b implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, InterfaceC3701c<ParcelFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f14052a;

        public C3700b(ContentResolver contentResolver) {
            this.f14052a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.UriLoader.InterfaceC3701c
        /* renamed from: b */
        public DataFetcher<ParcelFileDescriptor> mo45005b(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f14052a, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, ParcelFileDescriptor> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.w$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3701c<Data> {
        /* renamed from: b */
        DataFetcher<Data> mo45005b(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.model.w$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3702d implements ModelLoaderFactory<Uri, InputStream>, InterfaceC3701c<InputStream> {

        /* renamed from: a */
        private final ContentResolver f14053a;

        public C3702d(ContentResolver contentResolver) {
            this.f14053a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.UriLoader.InterfaceC3701c
        /* renamed from: b */
        public DataFetcher<InputStream> mo45005b(Uri uri) {
            return new StreamLocalUriFetcher(this.f14053a, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public UriLoader(InterfaceC3701c<Data> interfaceC3701c) {
        this.f14050a = interfaceC3701c;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(uri), this.f14050a.mo45005b(uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return f14049b.contains(uri.getScheme());
    }
}
