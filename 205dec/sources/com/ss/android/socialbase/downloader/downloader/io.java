package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface io {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok implements io {
        @Override // com.ss.android.socialbase.downloader.downloader.io
        public IDownloadHttpService a() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.io
        public com.ss.android.socialbase.downloader.network.p bl() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.io
        public com.ss.android.socialbase.downloader.exception.h ok(Throwable th, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.io
        public boolean ok() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.io
        public boolean ok(Throwable th) {
            return false;
        }
    }

    IDownloadHttpService a();

    com.ss.android.socialbase.downloader.network.p bl();

    com.ss.android.socialbase.downloader.exception.h ok(Throwable th, String str);

    boolean ok();

    boolean ok(Throwable th);
}
