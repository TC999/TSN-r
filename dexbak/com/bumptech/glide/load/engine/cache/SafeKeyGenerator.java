package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.C3769g;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bumptech.glide.load.engine.cache.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SafeKeyGenerator {

    /* renamed from: a */
    private final C3769g<Key, String> f13674a = new C3769g<>(1000);

    /* renamed from: b */
    private final Pools.Pool<C3608b> f13675b = FactoryPools.m44359e(10, new C3607a());

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.m$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3607a implements FactoryPools.InterfaceC3777d<C3608b> {
        C3607a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3777d
        /* renamed from: b */
        public C3608b mo44354a() {
            try {
                return new C3608b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.m$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3608b implements FactoryPools.InterfaceC3779f {

        /* renamed from: a */
        final MessageDigest f13677a;

        /* renamed from: b */
        private final StateVerifier f13678b = StateVerifier.m44345a();

        C3608b(MessageDigest messageDigest) {
            this.f13677a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3779f
        @NonNull
        /* renamed from: h */
        public StateVerifier mo44353h() {
            return this.f13678b;
        }
    }

    /* renamed from: a */
    private String m45300a(Key key) {
        C3608b c3608b = (C3608b) C3770j.m44392d(this.f13675b.acquire());
        try {
            key.mo44432b(c3608b.f13677a);
            return C3771k.m44368w(c3608b.f13677a.digest());
        } finally {
            this.f13675b.release(c3608b);
        }
    }

    /* renamed from: b */
    public String m45299b(Key key) {
        String m44406i;
        synchronized (this.f13674a) {
            m44406i = this.f13674a.m44406i(key);
        }
        if (m44406i == null) {
            m44406i = m45300a(key);
        }
        synchronized (this.f13674a) {
            this.f13674a.m44402m(key, m44406i);
        }
        return m44406i;
    }
}
