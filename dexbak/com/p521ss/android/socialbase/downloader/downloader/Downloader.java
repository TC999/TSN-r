package com.p521ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12428er;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.Downloader */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Downloader extends C12489a {
    private static volatile Downloader instance;

    static {
        C12490bl.m17792ok(new C12520ul());
        instance = null;
    }

    private Downloader() {
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    C12490bl.m17799ok(context);
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

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z) {
        synchronized (Downloader.class) {
            if (downloaderBuilder == null) {
                return;
            }
            if (instance == null) {
                instance = downloaderBuilder.build();
            } else if (!C12490bl.m17824ej()) {
                C12490bl.m17793ok(downloaderBuilder);
            } else if (z) {
                C12490bl.m17838a(downloaderBuilder);
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ boolean canResume(int i) {
        return super.canResume(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void cancel(int i) {
        super.cancel(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void clearDownloadData(int i) {
        super.clearDownloadData(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void forceDownloadIngoreRecommendSize(int i) {
        super.forceDownloadIngoreRecommendSize(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ long getCurBytes(int i) {
        return super.getCurBytes(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return super.getDownloadFileUriProvider(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i) {
        return super.getDownloadInfo(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ InterfaceC12427ep getDownloadNotificationEventListener(int i) {
        return super.getDownloadNotificationEventListener(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ List getFailedDownloadInfosWithMimeType(String str) {
        return super.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ InterfaceC12518td getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ int getStatus(int i) {
        return super.getStatus(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ boolean isDownloadServiceForeground(int i) {
        return super.isDownloadServiceForeground(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ boolean isDownloading(int i) {
        return super.isDownloading(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void pause(int i) {
        super.pause(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(InterfaceC12468r interfaceC12468r) {
        super.registerDownloadCacheSyncListener(interfaceC12468r);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(InterfaceC12428er interfaceC12428er) {
        super.registerDownloaderProcessConnectedListener(interfaceC12428er);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i) {
        super.removeTaskMainListener(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i) {
        super.removeTaskNotificationListener(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i) {
        super.removeTaskSubListener(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void restart(int i) {
        super.restart(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void resume(int i) {
        super.resume(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i, InterfaceC12427ep interfaceC12427ep) {
        super.setDownloadNotificationEventListener(i, interfaceC12427ep);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setLogLevel(int i) {
        super.setLogLevel(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(InterfaceC12518td interfaceC12518td) {
        super.setReserveWifiStatusListener(interfaceC12518td);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i, iDownloadListener);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i, long j) {
        super.setThrottleNetSpeed(i, j);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(InterfaceC12468r interfaceC12468r) {
        super.unRegisterDownloadCacheSyncListener(interfaceC12468r);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(InterfaceC12428er interfaceC12428er) {
        super.unRegisterDownloaderProcessConnectedListener(interfaceC12428er);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Downloader(DownloaderBuilder downloaderBuilder) {
        C12490bl.m17793ok(downloaderBuilder);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void cancel(int i, boolean z) {
        super.cancel(i, z);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ void clearDownloadData(int i, boolean z) {
        super.clearDownloadData(i, z);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.C12489a
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        super.setMainThreadListener(i, iDownloadListener, z);
    }
}
