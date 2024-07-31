package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.signature.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediaStoreSignature implements Key {
    @NonNull

    /* renamed from: c */
    private final String f14527c;

    /* renamed from: d */
    private final long f14528d;

    /* renamed from: e */
    private final int f14529e;

    public MediaStoreSignature(@Nullable String str, long j, int i) {
        this.f14527c = str == null ? "" : str;
        this.f14528d = j;
        this.f14529e = i;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f14528d).putInt(this.f14529e).array());
        messageDigest.update(this.f14527c.getBytes(Key.f13470b));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.f14528d == mediaStoreSignature.f14528d && this.f14529e == mediaStoreSignature.f14529e && this.f14527c.equals(mediaStoreSignature.f14527c);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        long j = this.f14528d;
        return (((this.f14527c.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f14529e;
    }
}
