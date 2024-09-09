package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class g extends d {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16971b;

        a(Context context, String str) {
            this.f16970a = context;
            this.f16971b = str;
        }

        @Nullable
        private File b() {
            File cacheDir = this.f16970a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f16971b != null ? new File(cacheDir, this.f16971b) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File externalCacheDir;
            File b4 = b();
            return ((b4 == null || !b4.exists()) && (externalCacheDir = this.f16970a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.f16971b != null ? new File(externalCacheDir, this.f16971b) : externalCacheDir : b4;
        }
    }

    public g(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public g(Context context, long j4) {
        this(context, "image_manager_disk_cache", j4);
    }

    public g(Context context, String str, long j4) {
        super(new a(context, str), j4);
    }
}
