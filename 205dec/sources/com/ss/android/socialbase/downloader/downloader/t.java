package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface t<T extends DownloadService> {
    void a(DownloadTask downloadTask);

    boolean a();

    void bl();

    void bl(DownloadTask downloadTask);

    IBinder ok(Intent intent);

    void ok(int i4);

    void ok(int i4, Notification notification);

    void ok(Intent intent, int i4, int i5);

    void ok(rh rhVar);

    void ok(WeakReference<T> weakReference);

    void ok(boolean z3);

    boolean ok();

    void s();

    void startService();
}
