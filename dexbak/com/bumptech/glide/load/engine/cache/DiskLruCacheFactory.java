package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DiskLruCacheFactory implements DiskCache.InterfaceC3592a {

    /* renamed from: c */
    private final long f13631c;

    /* renamed from: d */
    private final InterfaceC3599c f13632d;

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3597a implements InterfaceC3599c {

        /* renamed from: a */
        final /* synthetic */ String f13633a;

        C3597a(String str) {
            this.f13633a = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.InterfaceC3599c
        /* renamed from: a */
        public File mo45325a() {
            return new File(this.f13633a);
        }
    }

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.d$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3598b implements InterfaceC3599c {

        /* renamed from: a */
        final /* synthetic */ String f13634a;

        /* renamed from: b */
        final /* synthetic */ String f13635b;

        C3598b(String str, String str2) {
            this.f13634a = str;
            this.f13635b = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.InterfaceC3599c
        /* renamed from: a */
        public File mo45325a() {
            return new File(this.f13634a, this.f13635b);
        }
    }

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.d$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3599c {
        /* renamed from: a */
        File mo45325a();
    }

    public DiskLruCacheFactory(String str, long j) {
        this(new C3597a(str), j);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.InterfaceC3592a
    public DiskCache build() {
        File mo45325a = this.f13632d.mo45325a();
        if (mo45325a == null) {
            return null;
        }
        if (mo45325a.mkdirs() || (mo45325a.exists() && mo45325a.isDirectory())) {
            return DiskLruCacheWrapper.m45330c(mo45325a, this.f13631c);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this(new C3598b(str, str2), j);
    }

    public DiskLruCacheFactory(InterfaceC3599c interfaceC3599c, long j) {
        this.f13631c = j;
        this.f13632d = interfaceC3599c;
    }
}
