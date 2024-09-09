package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ByteArrayLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0176b<Data> f17263a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.model.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0175a implements InterfaceC0176b<ByteBuffer> {
            C0175a() {
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0176b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0176b
            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<byte[], ByteBuffer> c(@NonNull r rVar) {
            return new b(new C0175a());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.model.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface InterfaceC0176b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f17265a;

        /* renamed from: b  reason: collision with root package name */
        private final InterfaceC0176b<Data> f17266b;

        c(byte[] bArr, InterfaceC0176b<Data> interfaceC0176b) {
            this.f17265a = bArr;
            this.f17266b = interfaceC0176b;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17266b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.e((Data) this.f17266b.b(this.f17265a));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class d implements o<byte[], InputStream> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: ByteArrayLoader.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class a implements InterfaceC0176b<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0176b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0176b
            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<byte[], InputStream> c(@NonNull r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0176b<Data> interfaceC0176b) {
        this.f17263a = interfaceC0176b;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull byte[] bArr, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.d(bArr), new c(bArr, this.f17263a));
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
