package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: com.bumptech.glide.load.model.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a */
    private final Context f13987a;

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3674a implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a */
        private final Context f13988a;

        public C3674a(Context context) {
            this.f13988a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Uri, File> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f13988a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: com.bumptech.glide.load.model.k$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3675b implements DataFetcher<File> {

        /* renamed from: c */
        private static final String[] f13989c = {"_data"};

        /* renamed from: a */
        private final Context f13990a;

        /* renamed from: b */
        private final Uri f13991b;

        C3675b(Context context, Uri uri) {
            this.f13990a = context;
            this.f13991b = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<File> mo45010a() {
            return File.class;
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
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super File> interfaceC3562a) {
            Cursor query = this.f13990a.getContentResolver().query(this.f13991b, f13989c, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                interfaceC3562a.mo45052c(new FileNotFoundException("Failed to find file path for: " + this.f13991b));
                return;
            }
            interfaceC3562a.mo45051e(new File(r0));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f13987a = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.C3678a<File> mo45003b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(uri), new C3675b(this.f13987a, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean mo45004a(@NonNull Uri uri) {
        return MediaStoreUtil.m45455b(uri);
    }
}
