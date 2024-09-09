package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.a;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DiskLruCacheFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d implements a.InterfaceC0166a {

    /* renamed from: c  reason: collision with root package name */
    private final long f16954c;

    /* renamed from: d  reason: collision with root package name */
    private final c f16955d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16956a;

        a(String str) {
            this.f16956a = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            return new File(this.f16956a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class b implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16957a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16958b;

        b(String str, String str2) {
            this.f16957a = str;
            this.f16958b = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            return new File(this.f16957a, this.f16958b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface c {
        File a();
    }

    public d(String str, long j4) {
        this(new a(str), j4);
    }

    @Override // com.bumptech.glide.load.engine.cache.a.InterfaceC0166a
    public com.bumptech.glide.load.engine.cache.a build() {
        File a4 = this.f16955d.a();
        if (a4 == null) {
            return null;
        }
        if (a4.mkdirs() || (a4.exists() && a4.isDirectory())) {
            return e.c(a4, this.f16954c);
        }
        return null;
    }

    public d(String str, String str2, long j4) {
        this(new b(str, str2), j4);
    }

    public d(c cVar, long j4) {
        this.f16954c = j4;
        this.f16955d = cVar;
    }
}
