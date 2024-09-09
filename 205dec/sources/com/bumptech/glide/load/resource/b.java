package com.bumptech.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: UnitTransformation.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b<T> implements i<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final i<?> f17374c = new b();

    private b() {
    }

    @NonNull
    public static <T> b<T> c() {
        return (b) f17374c;
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i4, int i5) {
        return uVar;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
    }
}
