package com.p521ss.android.socialbase.downloader.downloader;

import com.p521ss.android.socialbase.downloader.exception.C12527h;
import com.p521ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12634p;

/* renamed from: com.ss.android.socialbase.downloader.downloader.io */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12498io {

    /* renamed from: com.ss.android.socialbase.downloader.downloader.io$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12499ok implements InterfaceC12498io {
        @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12498io
        /* renamed from: a */
        public IDownloadHttpService mo17742a() {
            return null;
        }

        @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12498io
        /* renamed from: bl */
        public InterfaceC12634p mo17741bl() {
            return null;
        }

        @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12498io
        /* renamed from: ok */
        public C12527h mo17738ok(Throwable th, String str) {
            return null;
        }

        @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12498io
        /* renamed from: ok */
        public boolean mo17740ok() {
            return false;
        }

        @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12498io
        /* renamed from: ok */
        public boolean mo17739ok(Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    IDownloadHttpService mo17742a();

    /* renamed from: bl */
    InterfaceC12634p mo17741bl();

    /* renamed from: ok */
    C12527h mo17738ok(Throwable th, String str);

    /* renamed from: ok */
    boolean mo17740ok();

    /* renamed from: ok */
    boolean mo17739ok(Throwable th);
}
