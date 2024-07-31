package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: b */
    private static final String f13962b = "FileLoader";

    /* renamed from: a */
    private final InterfaceC3667d<Data> f13963a;

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3663a<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a */
        private final InterfaceC3667d<Data> f13964a;

        public C3663a(InterfaceC3667d<Data> interfaceC3667d) {
            this.f13964a = interfaceC3667d;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public final void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public final ModelLoader<File, Data> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f13964a);
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3664b extends C3663a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        /* renamed from: com.bumptech.glide.load.model.f$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3665a implements InterfaceC3667d<ParcelFileDescriptor> {
            C3665a() {
            }

            @Override // com.bumptech.glide.load.model.FileLoader.InterfaceC3667d
            /* renamed from: a */
            public Class<ParcelFileDescriptor> mo45099a() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.bumptech.glide.load.model.FileLoader.InterfaceC3667d
            /* renamed from: d */
            public void mo45098b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.model.FileLoader.InterfaceC3667d
            /* renamed from: e */
            public ParcelFileDescriptor mo45097c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public C3664b() {
            super(new C3665a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.f$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3666c<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final File f13965a;

        /* renamed from: b */
        private final InterfaceC3667d<Data> f13966b;

        /* renamed from: c */
        private Data f13967c;

        C3666c(File file, InterfaceC3667d<Data> interfaceC3667d) {
            this.f13965a = file;
            this.f13966b = interfaceC3667d;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo45010a() {
            return this.f13966b.mo45099a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: b */
        public void mo45009b() {
            Data data = this.f13967c;
            if (data != null) {
                try {
                    this.f13966b.mo45098b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: d */
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super Data> interfaceC3562a) {
            try {
                Data mo45097c = this.f13966b.mo45097c(this.f13965a);
                this.f13967c = mo45097c;
                interfaceC3562a.mo45051e(mo45097c);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable(FileLoader.f13962b, 3)) {
                    Log.d(FileLoader.f13962b, "Failed to open file", e);
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

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.f$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3667d<Data> {
        /* renamed from: a */
        Class<Data> mo45099a();

        /* renamed from: b */
        void mo45098b(Data data) throws IOException;

        /* renamed from: c */
        Data mo45097c(File file) throws FileNotFoundException;
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.f$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3668e extends C3663a<InputStream> {

        /* compiled from: FileLoader.java */
        /* renamed from: com.bumptech.glide.load.model.f$e$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3669a implements InterfaceC3667d<InputStream> {
            C3669a() {
            }

            @Override // com.bumptech.glide.load.model.FileLoader.InterfaceC3667d
            /* renamed from: a */
            public Class<InputStream> mo45099a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.FileLoader.InterfaceC3667d
            /* renamed from: d */
            public void mo45098b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.FileLoader.InterfaceC3667d
            /* renamed from: e */
            public InputStream mo45097c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public C3668e() {
            super(new C3669a());
        }
    }

    public FileLoader(InterfaceC3667d<Data> interfaceC3667d) {
        this.f13963a = interfaceC3667d;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(file), new C3666c(file, this.f13963a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull File file) {
        return true;
    }
}
