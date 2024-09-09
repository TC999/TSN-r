package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class e {

    /* renamed from: f  reason: collision with root package name */
    private static final String f16841f = "ThumbStreamOpener";

    /* renamed from: g  reason: collision with root package name */
    private static final a f16842g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final a f16843a;

    /* renamed from: b  reason: collision with root package name */
    private final d f16844b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f16845c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f16846d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f16847e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, f16842g, dVar, bVar, contentResolver);
    }

    @Nullable
    private String b(@NonNull Uri uri) {
        Cursor query = this.f16844b.query(uri);
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

    private boolean c(File file) {
        return this.f16843a.a(file) && 0 < this.f16843a.c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f16846d.openInputStream(uri);
                int a4 = com.bumptech.glide.load.b.a(this.f16847e, inputStream, this.f16845c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a4;
            } catch (IOException | NullPointerException e4) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e4);
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

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b4 = b(uri);
        if (TextUtils.isEmpty(b4)) {
            return null;
        }
        File b5 = this.f16843a.b(b4);
        if (c(b5)) {
            Uri fromFile = Uri.fromFile(b5);
            try {
                return this.f16846d.openInputStream(fromFile);
            } catch (NullPointerException e4) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e4));
            }
        }
        return null;
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this.f16843a = aVar;
        this.f16844b = dVar;
        this.f16845c = bVar;
        this.f16846d = contentResolver;
        this.f16847e = list;
    }
}
