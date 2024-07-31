package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    /* renamed from: a */
    private static final String f13952a = "ByteBufferFileLoader";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3657a implements DataFetcher<ByteBuffer> {

        /* renamed from: a */
        private final File f13953a;

        C3657a(File file) {
            this.f13953a = file;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<ByteBuffer> mo45010a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: b */
        public void mo45009b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: d */
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super ByteBuffer> interfaceC3562a) {
            try {
                interfaceC3562a.mo45051e(ByteBufferUtil.m44431a(this.f13953a));
            } catch (IOException e) {
                if (Log.isLoggable(ByteBufferFileLoader.f13952a, 3)) {
                    Log.d(ByteBufferFileLoader.f13952a, "Failed to obtain ByteBuffer for file", e);
                }
                interfaceC3562a.mo45052c(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.d$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3658b implements ModelLoaderFactory<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<File, ByteBuffer> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<ByteBuffer> mo45003b(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(file), new C3657a(file));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull File file) {
        return true;
    }
}
