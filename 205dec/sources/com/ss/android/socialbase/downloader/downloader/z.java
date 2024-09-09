package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface z {
    DownloadInfo a(String str, String str2);

    List<DownloadInfo> a(String str);

    void a(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3);

    void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list);

    void a(int i4, boolean z3);

    void a(DownloadInfo downloadInfo);

    void a(DownloadTask downloadTask);

    void a(List<String> list);

    boolean a();

    boolean a(int i4);

    List<DownloadInfo> bl(String str);

    void bl(int i4);

    void bl(int i4, boolean z3);

    boolean bl();

    boolean bl(DownloadInfo downloadInfo);

    boolean h();

    boolean h(int i4);

    boolean i(int i4);

    boolean j(int i4);

    void k(int i4);

    int kf(int i4);

    void kf();

    long n(int i4);

    List<DownloadInfo> n(String str);

    boolean n();

    int ok(String str, String str2);

    List<DownloadInfo> ok(String str);

    void ok();

    void ok(int i4);

    void ok(int i4, int i5);

    void ok(int i4, int i5, int i6, int i7);

    void ok(int i4, int i5, int i6, long j4);

    void ok(int i4, int i5, long j4);

    void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3);

    void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3, boolean z4);

    void ok(int i4, long j4);

    void ok(int i4, Notification notification);

    void ok(int i4, ep epVar);

    void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list);

    void ok(int i4, boolean z3);

    void ok(sg sgVar);

    void ok(DownloadTask downloadTask);

    void ok(com.ss.android.socialbase.downloader.model.a aVar);

    void ok(List<String> list);

    void ok(boolean z3, boolean z4);

    boolean ok(DownloadInfo downloadInfo);

    DownloadInfo p(int i4);

    List<com.ss.android.socialbase.downloader.model.a> q(int i4);

    void r(int i4);

    boolean rh(int i4);

    List<DownloadInfo> s();

    List<DownloadInfo> s(String str);

    void s(int i4);

    void startService();

    void t(int i4);

    v td(int i4);

    ep x(int i4);

    int z(int i4);

    IDownloadFileUriProvider zz(int i4);
}
