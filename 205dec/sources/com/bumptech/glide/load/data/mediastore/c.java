package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ThumbFetcher.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f16831d = "MediaStoreThumbFetcher";

    /* renamed from: a  reason: collision with root package name */
    private final Uri f16832a;

    /* renamed from: b  reason: collision with root package name */
    private final e f16833b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f16834c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ThumbFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f16835b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f16836c = "kind = 1 AND image_id = ?";

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16837a;

        a(ContentResolver contentResolver) {
            this.f16837a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.d
        public Cursor query(Uri uri) {
            return this.f16837a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f16835b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ThumbFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f16838b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f16839c = "kind = 1 AND video_id = ?";

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16840a;

        b(ContentResolver contentResolver) {
            this.f16840a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.d
        public Cursor query(Uri uri) {
            return this.f16840a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f16838b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f16832a = uri;
        this.f16833b = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.d.d(context).l().g(), dVar, com.bumptech.glide.d.d(context).f(), context.getContentResolver()));
    }

    public static c e(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream g() throws FileNotFoundException {
        InputStream d4 = this.f16833b.d(this.f16832a);
        int a4 = d4 != null ? this.f16833b.a(this.f16832a) : -1;
        return a4 != -1 ? new g(d4, a4) : d4;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f16834c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream g4 = g();
            this.f16834c = g4;
            aVar.e(g4);
        } catch (FileNotFoundException e4) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e4);
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
