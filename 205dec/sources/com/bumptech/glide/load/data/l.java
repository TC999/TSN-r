package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LocalUriFetcher.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f16825d = "LocalUriFetcher";

    /* renamed from: a  reason: collision with root package name */
    private final Uri f16826a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f16827b;

    /* renamed from: c  reason: collision with root package name */
    private T f16828c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f16827b = contentResolver;
        this.f16826a = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t3 = this.f16828c;
        if (t3 != null) {
            try {
                c(t3);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(T t3) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T e4 = e(this.f16826a, this.f16827b);
            this.f16828c = e4;
            aVar.e(e4);
        } catch (FileNotFoundException e5) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e5);
            }
            aVar.c(e5);
        }
    }

    protected abstract T e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
