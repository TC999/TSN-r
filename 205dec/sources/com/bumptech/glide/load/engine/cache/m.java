package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SafeKeyGenerator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.util.g<com.bumptech.glide.load.c, String> f16997a = new com.bumptech.glide.util.g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<b> f16998b = com.bumptech.glide.util.pool.a.e(10, new a());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements a.d<b> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.a.d
        /* renamed from: b */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f17000a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.util.pool.c f17001b = com.bumptech.glide.util.pool.c.a();

        b(MessageDigest messageDigest) {
            this.f17000a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.a.f
        @NonNull
        public com.bumptech.glide.util.pool.c h() {
            return this.f17001b;
        }
    }

    private String a(com.bumptech.glide.load.c cVar) {
        b bVar = (b) com.bumptech.glide.util.j.d(this.f16998b.acquire());
        try {
            cVar.b(bVar.f17000a);
            return com.bumptech.glide.util.k.w(bVar.f17000a.digest());
        } finally {
            this.f16998b.release(bVar);
        }
    }

    public String b(com.bumptech.glide.load.c cVar) {
        String i4;
        synchronized (this.f16997a) {
            i4 = this.f16997a.i(cVar);
        }
        if (i4 == null) {
            i4 = a(cVar);
        }
        synchronized (this.f16997a) {
            this.f16997a.m(cVar, i4);
        }
        return i4;
    }
}
