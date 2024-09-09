package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MediaStoreSignature.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements com.bumptech.glide.load.c {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f18045c;

    /* renamed from: d  reason: collision with root package name */
    private final long f18046d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18047e;

    public c(@Nullable String str, long j4, int i4) {
        this.f18045c = str == null ? "" : str;
        this.f18046d = j4;
        this.f18047e = i4;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f18046d).putInt(this.f18047e).array());
        messageDigest.update(this.f18045c.getBytes(com.bumptech.glide.load.c.f16793b));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f18046d == cVar.f18046d && this.f18047e == cVar.f18047e && this.f18045c.equals(cVar.f18045c);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        long j4 = this.f18046d;
        return (((this.f18045c.hashCode() * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f18047e;
    }
}
