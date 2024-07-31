package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.C3769g;
import com.bumptech.glide.util.C3771k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class ResourceCacheKey implements Key {

    /* renamed from: k */
    private static final C3769g<Class<?>, byte[]> f13918k = new C3769g<>(50);

    /* renamed from: c */
    private final ArrayPool f13919c;

    /* renamed from: d */
    private final Key f13920d;

    /* renamed from: e */
    private final Key f13921e;

    /* renamed from: f */
    private final int f13922f;

    /* renamed from: g */
    private final int f13923g;

    /* renamed from: h */
    private final Class<?> f13924h;

    /* renamed from: i */
    private final Options f13925i;

    /* renamed from: j */
    private final Transformation<?> f13926j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f13919c = arrayPool;
        this.f13920d = key;
        this.f13921e = key2;
        this.f13922f = i;
        this.f13923g = i2;
        this.f13926j = transformation;
        this.f13924h = cls;
        this.f13925i = options;
    }

    /* renamed from: c */
    private byte[] m45132c() {
        C3769g<Class<?>, byte[]> c3769g = f13918k;
        byte[] m44406i = c3769g.m44406i(this.f13924h);
        if (m44406i == null) {
            byte[] bytes = this.f13924h.getName().getBytes(Key.f13470b);
            c3769g.m44402m(this.f13924h, bytes);
            return bytes;
        }
        return m44406i;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f13919c.mo45393d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f13922f).putInt(this.f13923g).array();
        this.f13921e.mo44432b(messageDigest);
        this.f13920d.mo44432b(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f13926j;
        if (transformation != null) {
            transformation.mo44432b(messageDigest);
        }
        this.f13925i.mo44432b(messageDigest);
        messageDigest.update(m45132c());
        this.f13919c.put(bArr);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ResourceCacheKey) {
            ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
            return this.f13923g == resourceCacheKey.f13923g && this.f13922f == resourceCacheKey.f13922f && C3771k.m44387d(this.f13926j, resourceCacheKey.f13926j) && this.f13924h.equals(resourceCacheKey.f13924h) && this.f13920d.equals(resourceCacheKey.f13920d) && this.f13921e.equals(resourceCacheKey.f13921e) && this.f13925i.equals(resourceCacheKey.f13925i);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = (((((this.f13920d.hashCode() * 31) + this.f13921e.hashCode()) * 31) + this.f13922f) * 31) + this.f13923g;
        Transformation<?> transformation = this.f13926j;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f13924h.hashCode()) * 31) + this.f13925i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f13920d + ", signature=" + this.f13921e + ", width=" + this.f13922f + ", height=" + this.f13923g + ", decodedResourceClass=" + this.f13924h + ", transformation='" + this.f13926j + "', options=" + this.f13925i + '}';
    }
}
