package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataUrlLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17271b = "data:image";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17272c = ";base64";

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f17273a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataUrlLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(String str) throws IllegalArgumentException;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataUrlLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f17274a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f17275b;

        /* renamed from: c  reason: collision with root package name */
        private Data f17276c;

        b(String str, a<Data> aVar) {
            this.f17274a = str;
            this.f17275b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17275b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f17275b.b(this.f17276c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data c4 = this.f17275b.c(this.f17274a);
                this.f17276c = c4;
                aVar.e(c4);
            } catch (IllegalArgumentException e4) {
                aVar.c(e4);
            }
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
    /* compiled from: DataUrlLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f17277a = new a();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: DataUrlLoader.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.model.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.e.a
            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.e.a
            /* renamed from: e */
            public InputStream c(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Model, InputStream> c(@NonNull r rVar) {
            return new e(this.f17277a);
        }
    }

    public e(a<Data> aVar) {
        this.f17273a = aVar;
    }

    @Override // com.bumptech.glide.load.model.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.model.n
    public n.a<Data> b(@NonNull Model model, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.d(model), new b(model.toString(), this.f17273a));
    }
}
