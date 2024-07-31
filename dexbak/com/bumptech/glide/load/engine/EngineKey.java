package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.C3770j;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class EngineKey implements Key {

    /* renamed from: c */
    private final Object f13849c;

    /* renamed from: d */
    private final int f13850d;

    /* renamed from: e */
    private final int f13851e;

    /* renamed from: f */
    private final Class<?> f13852f;

    /* renamed from: g */
    private final Class<?> f13853g;

    /* renamed from: h */
    private final Key f13854h;

    /* renamed from: i */
    private final Map<Class<?>, Transformation<?>> f13855i;

    /* renamed from: j */
    private final Options f13856j;

    /* renamed from: k */
    private int f13857k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f13849c = C3770j.m44392d(obj);
        this.f13854h = (Key) C3770j.m44391e(key, "Signature must not be null");
        this.f13850d = i;
        this.f13851e = i2;
        this.f13855i = (Map) C3770j.m44392d(map);
        this.f13852f = (Class) C3770j.m44391e(cls, "Resource class must not be null");
        this.f13853g = (Class) C3770j.m44391e(cls2, "Transcode class must not be null");
        this.f13856j = (Options) C3770j.m44392d(options);
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof EngineKey) {
            EngineKey engineKey = (EngineKey) obj;
            return this.f13849c.equals(engineKey.f13849c) && this.f13854h.equals(engineKey.f13854h) && this.f13851e == engineKey.f13851e && this.f13850d == engineKey.f13850d && this.f13855i.equals(engineKey.f13855i) && this.f13852f.equals(engineKey.f13852f) && this.f13853g.equals(engineKey.f13853g) && this.f13856j.equals(engineKey.f13856j);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f13857k == 0) {
            int hashCode = this.f13849c.hashCode();
            this.f13857k = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f13854h.hashCode()) * 31) + this.f13850d) * 31) + this.f13851e;
            this.f13857k = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f13855i.hashCode();
            this.f13857k = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f13852f.hashCode();
            this.f13857k = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f13853g.hashCode();
            this.f13857k = hashCode5;
            this.f13857k = (hashCode5 * 31) + this.f13856j.hashCode();
        }
        return this.f13857k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f13849c + ", width=" + this.f13850d + ", height=" + this.f13851e + ", resourceClass=" + this.f13852f + ", transcodeClass=" + this.f13853g + ", signature=" + this.f13854h + ", hashCode=" + this.f13857k + ", transformations=" + this.f13855i + ", options=" + this.f13856j + '}';
    }
}
