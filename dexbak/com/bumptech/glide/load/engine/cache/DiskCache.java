package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface DiskCache {

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3592a {

        /* renamed from: a */
        public static final int f13623a = 262144000;

        /* renamed from: b */
        public static final String f13624b = "image_manager_disk_cache";

        @Nullable
        DiskCache build();
    }

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3593b {
        /* renamed from: a */
        boolean mo45296a(@NonNull File file);
    }

    /* renamed from: a */
    void mo45332a(Key key, InterfaceC3593b interfaceC3593b);

    @Nullable
    /* renamed from: b */
    File mo45331b(Key key);

    void clear();

    void delete(Key key);
}
