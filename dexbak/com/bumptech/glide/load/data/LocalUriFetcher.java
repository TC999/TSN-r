package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.data.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: d */
    private static final String f13502d = "LocalUriFetcher";

    /* renamed from: a */
    private final Uri f13503a;

    /* renamed from: b */
    private final ContentResolver f13504b;

    /* renamed from: c */
    private T f13505c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f13504b = contentResolver;
        this.f13503a = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: b */
    public void mo45009b() {
        T t = this.f13505c;
        if (t != null) {
            try {
                mo45443c(t);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: c */
    protected abstract void mo45443c(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: d */
    public final void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super T> interfaceC3562a) {
        try {
            T mo45442e = mo45442e(this.f13503a, this.f13504b);
            this.f13505c = mo45442e;
            interfaceC3562a.mo45051e(mo45442e);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(f13502d, 3)) {
                Log.d(f13502d, "Failed to open Uri", e);
            }
            interfaceC3562a.mo45052c(e);
        }
    }

    /* renamed from: e */
    protected abstract T mo45442e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
