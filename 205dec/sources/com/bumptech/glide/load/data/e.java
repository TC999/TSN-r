package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataRewinder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface e<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataRewinder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a<T> {
        @NonNull
        Class<T> a();

        @NonNull
        e<T> b(@NonNull T t3);
    }

    @NonNull
    T a() throws IOException;

    void b();
}
