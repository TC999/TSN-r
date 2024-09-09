package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class h extends d {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16973b;

        a(Context context, String str) {
            this.f16972a = context;
            this.f16973b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File cacheDir = this.f16972a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f16973b != null ? new File(cacheDir, this.f16973b) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public h(Context context, long j4) {
        this(context, "image_manager_disk_cache", j4);
    }

    public h(Context context, String str, long j4) {
        super(new a(context, str), j4);
    }
}
