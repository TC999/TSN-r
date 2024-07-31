package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.C3770j;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.signature.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ObjectKey implements Key {

    /* renamed from: c */
    private final Object f14530c;

    public ObjectKey(@NonNull Object obj) {
        this.f14530c = C3770j.m44392d(obj);
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f14530c.toString().getBytes(Key.f13470b));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f14530c.equals(((ObjectKey) obj).f14530c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f14530c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f14530c + '}';
    }
}
