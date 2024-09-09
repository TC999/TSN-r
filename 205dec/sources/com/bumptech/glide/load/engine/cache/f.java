package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ExternalCacheDiskCacheFactory.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class f extends d {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ExternalCacheDiskCacheFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16968a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16969b;

        a(Context context, String str) {
            this.f16968a = context;
            this.f16969b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File externalCacheDir = this.f16968a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f16969b != null ? new File(externalCacheDir, this.f16969b) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, int i4) {
        this(context, "image_manager_disk_cache", i4);
    }

    public f(Context context, String str, int i4) {
        super(new a(context, str), i4);
    }
}
