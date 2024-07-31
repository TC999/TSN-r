package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class DataCacheKey implements Key {

    /* renamed from: c */
    private final Key f13679c;

    /* renamed from: d */
    private final Key f13680d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.f13679c = key;
        this.f13680d = key2;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        this.f13679c.mo44432b(messageDigest);
        this.f13680d.mo44432b(messageDigest);
    }

    /* renamed from: c */
    Key m45297c() {
        return this.f13679c;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            return this.f13679c.equals(dataCacheKey.f13679c) && this.f13680d.equals(dataCacheKey.f13680d);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f13679c.hashCode() * 31) + this.f13680d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f13679c + ", signature=" + this.f13680d + '}';
    }
}
