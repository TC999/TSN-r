package com.ss.android.socialbase.downloader.ev;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.gd;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface f {
    com.ss.android.socialbase.downloader.exception.ev c(BaseException baseException, long j4);

    com.ss.android.socialbase.downloader.exception.ev c(com.ss.android.socialbase.downloader.model.w wVar, BaseException baseException, long j4);

    com.ss.android.socialbase.downloader.model.w c(int i4);

    void c(long j4) throws BaseException;

    void c(w wVar);

    void c(BaseException baseException, boolean z3);

    void c(com.ss.android.socialbase.downloader.network.r rVar);

    void c(String str, com.ss.android.socialbase.downloader.network.r rVar, long j4) throws BaseException, gd;

    boolean c(BaseException baseException);

    void w(BaseException baseException);

    boolean w(long j4) throws BaseException;

    void xv(BaseException baseException);
}
