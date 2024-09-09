package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EmptySignature.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b implements com.bumptech.glide.load.c {

    /* renamed from: c  reason: collision with root package name */
    private static final b f18044c = new b();

    private b() {
    }

    @NonNull
    public static b c() {
        return f18044c;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
