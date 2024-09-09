package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ObjectKey.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class d implements com.bumptech.glide.load.c {

    /* renamed from: c  reason: collision with root package name */
    private final Object f18048c;

    public d(@NonNull Object obj) {
        this.f18048c = j.d(obj);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f18048c.toString().getBytes(com.bumptech.glide.load.c.f16793b));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f18048c.equals(((d) obj).f18048c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f18048c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f18048c + '}';
    }
}
