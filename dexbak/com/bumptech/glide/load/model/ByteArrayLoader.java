package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a */
    private final InterfaceC3653b<Data> f13946a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.model.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3651a implements ModelLoaderFactory<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.model.b$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3652a implements InterfaceC3653b<ByteBuffer> {
            C3652a() {
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.InterfaceC3653b
            /* renamed from: a */
            public Class<ByteBuffer> mo45114a() {
                return ByteBuffer.class;
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.InterfaceC3653b
            /* renamed from: c */
            public ByteBuffer mo45113b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<byte[], ByteBuffer> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new C3652a());
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.model.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3653b<Data> {
        /* renamed from: a */
        Class<Data> mo45114a();

        /* renamed from: b */
        Data mo45113b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.model.b$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3654c<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final byte[] f13948a;

        /* renamed from: b */
        private final InterfaceC3653b<Data> f13949b;

        C3654c(byte[] bArr, InterfaceC3653b<Data> interfaceC3653b) {
            this.f13948a = bArr;
            this.f13949b = interfaceC3653b;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo45010a() {
            return this.f13949b.mo45114a();
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
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super Data> interfaceC3562a) {
            interfaceC3562a.mo45051e((Data) this.f13949b.mo45113b(this.f13948a));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.model.b$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3655d implements ModelLoaderFactory<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.model.b$d$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3656a implements InterfaceC3653b<InputStream> {
            C3656a() {
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.InterfaceC3653b
            /* renamed from: a */
            public Class<InputStream> mo45114a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.InterfaceC3653b
            /* renamed from: c */
            public InputStream mo45113b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<byte[], InputStream> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new C3656a());
        }
    }

    public ByteArrayLoader(InterfaceC3653b<Data> interfaceC3653b) {
        this.f13946a = interfaceC3653b;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull byte[] bArr, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(bArr), new C3654c(bArr, this.f13946a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull byte[] bArr) {
        return true;
    }
}
