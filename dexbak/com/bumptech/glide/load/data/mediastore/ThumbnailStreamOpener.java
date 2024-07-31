package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bumptech.glide.load.data.mediastore.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class ThumbnailStreamOpener {

    /* renamed from: f */
    private static final String f13518f = "ThumbStreamOpener";

    /* renamed from: g */
    private static final FileService f13519g = new FileService();

    /* renamed from: a */
    private final FileService f13520a;

    /* renamed from: b */
    private final ThumbnailQuery f13521b;

    /* renamed from: c */
    private final ArrayPool f13522c;

    /* renamed from: d */
    private final ContentResolver f13523d;

    /* renamed from: e */
    private final List<ImageHeaderParser> f13524e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f13519g, thumbnailQuery, arrayPool, contentResolver);
    }

    @Nullable
    /* renamed from: b */
    private String m45446b(@NonNull Uri uri) {
        Cursor query = this.f13521b.query(uri);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return query.getString(0);
                }
            } finally {
                query.close();
            }
        }
        if (query != null) {
        }
        return null;
    }

    /* renamed from: c */
    private boolean m45445c(File file) {
        return this.f13520a.m45459a(file) && 0 < this.f13520a.m45457c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m45447a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f13523d.openInputStream(uri);
                int m45482a = ImageHeaderParserUtils.m45482a(this.f13524e, inputStream, this.f13522c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return m45482a;
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable(f13518f, 3)) {
                    Log.d(f13518f, "Failed to open uri: " + uri, e);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused2) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* renamed from: d */
    public InputStream m45444d(Uri uri) throws FileNotFoundException {
        String m45446b = m45446b(uri);
        if (TextUtils.isEmpty(m45446b)) {
            return null;
        }
        File m45458b = this.f13520a.m45458b(m45446b);
        if (m45445c(m45458b)) {
            Uri fromFile = Uri.fromFile(m45458b);
            try {
                return this.f13523d.openInputStream(fromFile);
            } catch (NullPointerException e) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
            }
        }
        return null;
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f13520a = fileService;
        this.f13521b = thumbnailQuery;
        this.f13522c = arrayPool;
        this.f13523d = contentResolver;
        this.f13524e = list;
    }
}
