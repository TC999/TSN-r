package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.depend.pr;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface bk {
    boolean a(int i4);

    int bk(int i4);

    int c(String str, String str2);

    List<DownloadInfo> c(String str);

    void c();

    void c(int i4);

    void c(int i4, int i5);

    void c(int i4, int i5, int i6, int i7);

    void c(int i4, int i5, int i6, long j4);

    void c(int i4, int i5, long j4);

    void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3);

    void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3, boolean z4);

    void c(int i4, long j4);

    void c(int i4, Notification notification);

    void c(int i4, com.ss.android.socialbase.downloader.depend.n nVar);

    void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list);

    void c(int i4, boolean z3);

    void c(pr prVar);

    void c(DownloadTask downloadTask);

    void c(com.ss.android.socialbase.downloader.model.w wVar);

    void c(List<String> list);

    void c(boolean z3, boolean z4);

    boolean c(DownloadInfo downloadInfo);

    DownloadInfo ev(int i4);

    int f(int i4);

    void f();

    boolean fp(int i4);

    IDownloadFileUriProvider fz(int i4);

    List<com.ss.android.socialbase.downloader.model.w> gd(int i4);

    com.ss.android.socialbase.downloader.depend.n ia(int i4);

    void k(int i4);

    void p(int i4);

    boolean r();

    boolean r(int i4);

    me s(int i4);

    List<DownloadInfo> sr();

    List<DownloadInfo> sr(String str);

    void sr(int i4);

    void startService();

    boolean t(int i4);

    long ux(int i4);

    List<DownloadInfo> ux(String str);

    boolean ux();

    DownloadInfo w(String str, String str2);

    List<DownloadInfo> w(String str);

    void w(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3);

    void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list);

    void w(int i4, boolean z3);

    void w(DownloadInfo downloadInfo);

    void w(DownloadTask downloadTask);

    void w(List<String> list);

    boolean w();

    boolean w(int i4);

    List<DownloadInfo> xv(String str);

    void xv(int i4);

    void xv(int i4, boolean z3);

    boolean xv();

    boolean xv(DownloadInfo downloadInfo);

    void ys(int i4);
}
