package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.data.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface DataRewinder<T> {

    /* compiled from: DataRewinder.java */
    /* renamed from: com.bumptech.glide.load.data.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3563a<T> {
        @NonNull
        /* renamed from: a */
        Class<T> mo2887a();

        @NonNull
        /* renamed from: b */
        DataRewinder<T> mo2886b(@NonNull T t);
    }

    @NonNull
    /* renamed from: a */
    T mo2890a() throws IOException;

    /* renamed from: b */
    void mo2889b();
}
