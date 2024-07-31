package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3601a implements DiskLruCacheFactory.InterfaceC3599c {

        /* renamed from: a */
        final /* synthetic */ Context f13647a;

        /* renamed from: b */
        final /* synthetic */ String f13648b;

        C3601a(Context context, String str) {
            this.f13647a = context;
            this.f13648b = str;
        }

        @Nullable
        /* renamed from: b */
        private File m45326b() {
            File cacheDir = this.f13647a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f13648b != null ? new File(cacheDir, this.f13648b) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.InterfaceC3599c
        /* renamed from: a */
        public File mo45325a() {
            File externalCacheDir;
            File m45326b = m45326b();
            return ((m45326b == null || !m45326b.exists()) && (externalCacheDir = this.f13647a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.f13648b != null ? new File(externalCacheDir, this.f13648b) : externalCacheDir : m45326b;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.InterfaceC3592a.f13624b, 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.InterfaceC3592a.f13624b, j);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j) {
        super(new C3601a(context, str), j);
    }
}
