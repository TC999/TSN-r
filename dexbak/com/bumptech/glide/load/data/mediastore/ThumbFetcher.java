package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.data.mediastore.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: d */
    private static final String f13508d = "MediaStoreThumbFetcher";

    /* renamed from: a */
    private final Uri f13509a;

    /* renamed from: b */
    private final ThumbnailStreamOpener f13510b;

    /* renamed from: c */
    private InputStream f13511c;

    /* compiled from: ThumbFetcher.java */
    /* renamed from: com.bumptech.glide.load.data.mediastore.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3569a implements ThumbnailQuery {

        /* renamed from: b */
        private static final String[] f13512b = {"_data"};

        /* renamed from: c */
        private static final String f13513c = "kind = 1 AND image_id = ?";

        /* renamed from: a */
        private final ContentResolver f13514a;

        C3569a(ContentResolver contentResolver) {
            this.f13514a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.f13514a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f13512b, f13513c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* renamed from: com.bumptech.glide.load.data.mediastore.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3570b implements ThumbnailQuery {

        /* renamed from: b */
        private static final String[] f13515b = {"_data"};

        /* renamed from: c */
        private static final String f13516c = "kind = 1 AND video_id = ?";

        /* renamed from: a */
        private final ContentResolver f13517a;

        C3570b(ContentResolver contentResolver) {
            this.f13517a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.f13517a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f13515b, f13516c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f13509a = uri;
        this.f13510b = thumbnailStreamOpener;
    }

    /* renamed from: c */
    private static ThumbFetcher m45451c(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.m45744d(context).m45736l().m45779g(), thumbnailQuery, Glide.m45744d(context).m45742f(), context.getContentResolver()));
    }

    /* renamed from: e */
    public static ThumbFetcher m45450e(Context context, Uri uri) {
        return m45451c(context, uri, new C3569a(context.getContentResolver()));
    }

    /* renamed from: f */
    public static ThumbFetcher m45449f(Context context, Uri uri) {
        return m45451c(context, uri, new C3570b(context.getContentResolver()));
    }

    /* renamed from: g */
    private InputStream m45448g() throws FileNotFoundException {
        InputStream m45444d = this.f13510b.m45444d(this.f13509a);
        int m45447a = m45444d != null ? this.f13510b.m45447a(this.f13509a) : -1;
        return m45447a != -1 ? new ExifOrientationStream(m45444d, m45447a) : m45444d;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo45010a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: b */
    public void mo45009b() {
        InputStream inputStream = this.f13511c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: d */
    public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super InputStream> interfaceC3562a) {
        try {
            InputStream m45448g = m45448g();
            this.f13511c = m45448g;
            interfaceC3562a.mo45051e(m45448g);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(f13508d, 3)) {
                Log.d(f13508d, "Failed to find thumbnail file", e);
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
