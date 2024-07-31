package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: c */
    private static final String f14024c = "ResourceLoader";

    /* renamed from: a */
    private final ModelLoader<Uri, Data> f14025a;

    /* renamed from: b */
    private final Resources f14026b;

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.model.s$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3685a implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a */
        private final Resources f14027a;

        public C3685a(Resources resources) {
            this.f14027a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: c */
        public ModelLoader<Integer, AssetFileDescriptor> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f14027a, multiModelLoaderFactory.m45046d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.model.s$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3686b implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a */
        private final Resources f14028a;

        public C3686b(Resources resources) {
            this.f14028a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Integer, ParcelFileDescriptor> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f14028a, multiModelLoaderFactory.m45046d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.model.s$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3687c implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a */
        private final Resources f14029a;

        public C3687c(Resources resources) {
            this.f14029a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Integer, InputStream> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f14029a, multiModelLoaderFactory.m45046d(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: com.bumptech.glide.load.model.s$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3688d implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a */
        private final Resources f14030a;

        public C3688d(Resources resources) {
            this.f14030a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Integer, Uri> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f14030a, UnitModelLoader.m45012c());
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f14026b = resources;
        this.f14025a = modelLoader;
    }

    @Nullable
    /* renamed from: d */
    private Uri m45034d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f14026b.getResourcePackageName(num.intValue()) + '/' + this.f14026b.getResourceTypeName(num.intValue()) + '/' + this.f14026b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable(f14024c, 5)) {
                Log.w(f14024c, "Received invalid resource id: " + num, e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull Integer num, int i, int i2, @NonNull Options options) {
        Uri m45034d = m45034d(num);
        if (m45034d == null) {
            return null;
        }
        return this.f14025a.mo45003b(m45034d, i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: e */
    public boolean mo45004a(@NonNull Integer num) {
        return true;
    }
}
