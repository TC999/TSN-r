package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.data.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: d */
    private static final String f13472d = "AssetPathFetcher";

    /* renamed from: a */
    private final String f13473a;

    /* renamed from: b */
    private final AssetManager f13474b;

    /* renamed from: c */
    private T f13475c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f13474b = assetManager;
        this.f13473a = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: b */
    public void mo45009b() {
        T t = this.f13475c;
        if (t == null) {
            return;
        }
        try {
            mo45463c(t);
        } catch (IOException unused) {
        }
    }

    /* renamed from: c */
    protected abstract void mo45463c(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: d */
    public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super T> interfaceC3562a) {
        try {
            T mo45462e = mo45462e(this.f13474b, this.f13473a);
            this.f13475c = mo45462e;
            interfaceC3562a.mo45051e(mo45462e);
        } catch (IOException e) {
            if (Log.isLoggable(f13472d, 3)) {
                Log.d(f13472d, "Failed to load data from asset manager", e);
            }
            interfaceC3562a.mo45052c(e);
        }
    }

    /* renamed from: e */
    protected abstract T mo45462e(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
