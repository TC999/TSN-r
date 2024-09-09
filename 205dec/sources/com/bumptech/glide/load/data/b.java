package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AssetPathFetcher.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f16795d = "AssetPathFetcher";

    /* renamed from: a  reason: collision with root package name */
    private final String f16796a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f16797b;

    /* renamed from: c  reason: collision with root package name */
    private T f16798c;

    public b(AssetManager assetManager, String str) {
        this.f16797b = assetManager;
        this.f16796a = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t3 = this.f16798c;
        if (t3 == null) {
            return;
        }
        try {
            c(t3);
        } catch (IOException unused) {
        }
    }

    protected abstract void c(T t3) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T e4 = e(this.f16797b, this.f16796a);
            this.f16798c = e4;
            aVar.e(e4);
        } catch (IOException e5) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e5);
            }
            aVar.c(e5);
        }
    }

    protected abstract T e(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
