package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.er;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Downloader extends a {
    private static volatile Downloader instance;

    static {
        bl.ok(new ul());
        instance = null;
    }

    private Downloader() {
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    bl.ok(context);
                    instance = new Downloader();
                }
            }
        }
        return instance;
    }

    public static synchronized void init(DownloaderBuilder downloaderBuilder) {
        synchronized (Downloader.class) {
            initOrCover(downloaderBuilder, false);
        }
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z3) {
        synchronized (Downloader.class) {
            if (downloaderBuilder == null) {
                return;
            }
            if (instance == null) {
                instance = downloaderBuilder.build();
            } else if (!bl.ej()) {
                bl.ok(downloaderBuilder);
            } else if (z3) {
                bl.a(downloaderBuilder);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void addNotificationListener(int i4, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ boolean canResume(int i4) {
        return super.canResume(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void cancel(int i4) {
        super.cancel(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void clearDownloadData(int i4) {
        super.clearDownloadData(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void forceDownloadIngoreRecommendSize(int i4) {
        super.forceDownloadIngoreRecommendSize(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ long getCurBytes(int i4) {
        return super.getCurBytes(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i4) {
        return super.getDownloadFileUriProvider(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i4) {
        return super.getDownloadInfo(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ ep getDownloadNotificationEventListener(int i4) {
        return super.getDownloadNotificationEventListener(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ List getFailedDownloadInfosWithMimeType(String str) {
        return super.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ td getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ int getStatus(int i4) {
        return super.getStatus(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ boolean isDownloadServiceForeground(int i4) {
        return super.isDownloadServiceForeground(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ boolean isDownloading(int i4) {
        return super.isDownloading(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void pause(int i4) {
        super.pause(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.r rVar) {
        super.registerDownloadCacheSyncListener(rVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(er erVar) {
        super.registerDownloaderProcessConnectedListener(erVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i4, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i4) {
        super.removeTaskMainListener(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i4) {
        super.removeTaskNotificationListener(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i4) {
        super.removeTaskSubListener(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void restart(int i4) {
        super.restart(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void resume(int i4) {
        super.resume(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i4, ep epVar) {
        super.setDownloadNotificationEventListener(i4, epVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setLogLevel(int i4) {
        super.setLogLevel(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i4, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(td tdVar) {
        super.setReserveWifiStatusListener(tdVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i4, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i4, long j4) {
        super.setThrottleNetSpeed(i4, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.r rVar) {
        super.unRegisterDownloadCacheSyncListener(rVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(er erVar) {
        super.unRegisterDownloaderProcessConnectedListener(erVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Downloader(DownloaderBuilder downloaderBuilder) {
        bl.ok(downloaderBuilder);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void cancel(int i4, boolean z3) {
        super.cancel(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ void clearDownloadData(int i4, boolean z3) {
        super.clearDownloadData(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i4, IDownloadListener iDownloadListener, boolean z3) {
        super.setMainThreadListener(i4, iDownloadListener, z3);
    }
}
