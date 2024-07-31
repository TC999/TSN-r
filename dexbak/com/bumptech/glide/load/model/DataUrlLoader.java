package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: b */
    private static final String f13954b = "data:image";

    /* renamed from: c */
    private static final String f13955c = ";base64";

    /* renamed from: a */
    private final InterfaceC3659a<Data> f13956a;

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.model.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3659a<Data> {
        /* renamed from: a */
        Class<Data> mo45108a();

        /* renamed from: b */
        void mo45107b(Data data) throws IOException;

        /* renamed from: c */
        Data mo45106c(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.model.e$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3660b<Data> implements DataFetcher<Data> {

        /* renamed from: a */
        private final String f13957a;

        /* renamed from: b */
        private final InterfaceC3659a<Data> f13958b;

        /* renamed from: c */
        private Data f13959c;

        C3660b(String str, InterfaceC3659a<Data> interfaceC3659a) {
            this.f13957a = str;
            this.f13958b = interfaceC3659a;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo45010a() {
            return this.f13958b.mo45108a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: b */
        public void mo45009b() {
            try {
                this.f13958b.mo45107b(this.f13959c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: d */
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super Data> interfaceC3562a) {
            try {
                Data mo45106c = this.f13958b.mo45106c(this.f13957a);
                this.f13959c = mo45106c;
                interfaceC3562a.mo45051e(mo45106c);
            } catch (IllegalArgumentException e) {
                interfaceC3562a.mo45052c(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.model.e$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3661c<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a */
        private final InterfaceC3659a<InputStream> f13960a = new C3662a();

        /* compiled from: DataUrlLoader.java */
        /* renamed from: com.bumptech.glide.load.model.e$c$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3662a implements InterfaceC3659a<InputStream> {
            C3662a() {
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.InterfaceC3659a
            /* renamed from: a */
            public Class<InputStream> mo45108a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.InterfaceC3659a
            /* renamed from: d */
            public void mo45107b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.InterfaceC3659a
            /* renamed from: e */
            public InputStream mo45106c(String str) {
                if (str.startsWith(DataUrlLoader.f13954b)) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(DataUrlLoader.f13955c)) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Model, InputStream> mo44999c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f13960a);
        }
    }

    public DataUrlLoader(InterfaceC3659a<Data> interfaceC3659a) {
        this.f13956a = interfaceC3659a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: a */
    public boolean mo45004a(@NonNull Model model) {
        return model.toString().startsWith(f13954b);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: b */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(model), new C3660b(model.toString(), this.f13956a));
    }
}
