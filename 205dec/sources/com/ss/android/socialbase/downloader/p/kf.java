package com.ss.android.socialbase.downloader.p;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.q;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface kf {
    void a(BaseException baseException);

    boolean a(long j4) throws BaseException;

    void bl(BaseException baseException);

    com.ss.android.socialbase.downloader.exception.p ok(BaseException baseException, long j4);

    com.ss.android.socialbase.downloader.exception.p ok(com.ss.android.socialbase.downloader.model.a aVar, BaseException baseException, long j4);

    com.ss.android.socialbase.downloader.model.a ok(int i4);

    void ok(long j4) throws BaseException;

    void ok(BaseException baseException, boolean z3);

    void ok(com.ss.android.socialbase.downloader.network.h hVar);

    void ok(a aVar);

    void ok(String str, com.ss.android.socialbase.downloader.network.h hVar, long j4) throws BaseException, q;

    boolean ok(BaseException baseException);
}
