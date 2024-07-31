package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
/* renamed from: com.bumptech.glide.load.engine.cache.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* compiled from: ExternalCacheDiskCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3600a implements DiskLruCacheFactory.InterfaceC3599c {

        /* renamed from: a */
        final /* synthetic */ Context f13645a;

        /* renamed from: b */
        final /* synthetic */ String f13646b;

        C3600a(Context context, String str) {
            this.f13645a = context;
            this.f13646b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.InterfaceC3599c
        /* renamed from: a */
        public File mo45325a() {
            File externalCacheDir = this.f13645a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f13646b != null ? new File(externalCacheDir, this.f13646b) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.InterfaceC3592a.f13624b, DiskCache.InterfaceC3592a.f13623a);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.InterfaceC3592a.f13624b, i);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i) {
        super(new C3600a(context, str), i);
    }
}
