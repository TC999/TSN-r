package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DiskCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface InterfaceC0166a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f16946a = 262144000;

        /* renamed from: b  reason: collision with root package name */
        public static final String f16947b = "image_manager_disk_cache";

        @Nullable
        a build();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        boolean a(@NonNull File file);
    }

    void a(com.bumptech.glide.load.c cVar, b bVar);

    @Nullable
    File b(com.bumptech.glide.load.c cVar);

    void clear();

    void delete(com.bumptech.glide.load.c cVar);
}
