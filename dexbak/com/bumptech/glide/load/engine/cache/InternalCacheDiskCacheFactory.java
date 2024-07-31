package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.h$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3602a implements DiskLruCacheFactory.InterfaceC3599c {

        /* renamed from: a */
        final /* synthetic */ Context f13649a;

        /* renamed from: b */
        final /* synthetic */ String f13650b;

        C3602a(Context context, String str) {
            this.f13649a = context;
            this.f13650b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.InterfaceC3599c
        /* renamed from: a */
        public File mo45325a() {
            File cacheDir = this.f13649a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f13650b != null ? new File(cacheDir, this.f13650b) : cacheDir;
        }
    }

    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.InterfaceC3592a.f13624b, 262144000L);
    }

    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.InterfaceC3592a.f13624b, j);
    }

    public InternalCacheDiskCacheFactory(Context context, String str, long j) {
        super(new C3602a(context, str), j);
    }
}
