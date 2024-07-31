package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* renamed from: com.bumptech.glide.load.engine.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class DiskCacheStrategy {

    /* renamed from: a */
    public static final DiskCacheStrategy f13786a = new C3626a();

    /* renamed from: b */
    public static final DiskCacheStrategy f13787b = new C3627b();

    /* renamed from: c */
    public static final DiskCacheStrategy f13788c = new C3628c();

    /* renamed from: d */
    public static final DiskCacheStrategy f13789d = new C3629d();

    /* renamed from: e */
    public static final DiskCacheStrategy f13790e = new C3630e();

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3626a extends DiskCacheStrategy {
        C3626a() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo45221a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo45220b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: c */
        public boolean mo45219c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: d */
        public boolean mo45218d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.j$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3627b extends DiskCacheStrategy {
        C3627b() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo45221a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo45220b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: c */
        public boolean mo45219c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: d */
        public boolean mo45218d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.j$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3628c extends DiskCacheStrategy {
        C3628c() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo45221a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo45220b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: c */
        public boolean mo45219c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: d */
        public boolean mo45218d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.j$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3629d extends DiskCacheStrategy {
        C3629d() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo45221a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo45220b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: c */
        public boolean mo45219c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: d */
        public boolean mo45218d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.j$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3630e extends DiskCacheStrategy {
        C3630e() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: a */
        public boolean mo45221a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: b */
        public boolean mo45220b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: c */
        public boolean mo45219c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        /* renamed from: d */
        public boolean mo45218d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    /* renamed from: a */
    public abstract boolean mo45221a();

    /* renamed from: b */
    public abstract boolean mo45220b();

    /* renamed from: c */
    public abstract boolean mo45219c(DataSource dataSource);

    /* renamed from: d */
    public abstract boolean mo45218d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
