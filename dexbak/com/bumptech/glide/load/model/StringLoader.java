package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StringLoader<Data> implements ModelLoader<String, Data> {

    /* renamed from: a */
    private final ModelLoader<Uri, Data> f14045a;

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.model.u$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3694a implements ModelLoaderFactory<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: c */
        public ModelLoader<String, AssetFileDescriptor> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m45046d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.model.u$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3695b implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<String, ParcelFileDescriptor> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m45046d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.model.u$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3696c implements ModelLoaderFactory<String, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<String, InputStream> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m45046d(Uri.class, InputStream.class));
        }
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.f14045a = modelLoader;
    }

    @Nullable
    /* renamed from: e */
    private static Uri m45014e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return m45013f(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? m45013f(str) : parse;
    }

    /* renamed from: f */
    private static Uri m45013f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull String str, int i, int i2, @NonNull Options options) {
        Uri m45014e = m45014e(str);
        if (m45014e == null || !this.f14045a.mo45004a(m45014e)) {
            return null;
        }
        return this.f14045a.mo45003b(m45014e, i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull String str) {
        return true;
    }
}
