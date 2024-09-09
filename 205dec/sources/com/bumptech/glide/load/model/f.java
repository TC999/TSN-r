package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FileLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17279b = "FileLoader";

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f17280a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FileLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f17281a;

        public a(d<Data> dVar) {
            this.f17281a = dVar;
        }

        @Override // com.bumptech.glide.load.model.o
        public final void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public final n<File, Data> c(@NonNull r rVar) {
            return new f(this.f17281a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FileLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: FileLoader.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // com.bumptech.glide.load.model.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: d */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: e */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FileLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f17282a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f17283b;

        /* renamed from: c  reason: collision with root package name */
        private Data f17284c;

        c(File file, d<Data> dVar) {
            this.f17282a = file;
            this.f17283b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17283b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f17284c;
            if (data != null) {
                try {
                    this.f17283b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data c4 = this.f17283b.c(this.f17282a);
                this.f17284c = c4;
                aVar.e(c4);
            } catch (FileNotFoundException e4) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e4);
                }
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
    /* compiled from: FileLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FileLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class e extends a<InputStream> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: FileLoader.java */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class a implements d<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.model.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: e */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f17280a = dVar;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull File file, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.d(file), new c(file, this.f17280a));
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
