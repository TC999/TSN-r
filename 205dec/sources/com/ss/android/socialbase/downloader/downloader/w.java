package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ba;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
class w {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    w() {
    }

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().w(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void addNotificationListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().w(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().w(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    public boolean canResume(int i4) {
        return sr.c().ux(i4);
    }

    public void cancel(int i4) {
        cancel(i4, true);
    }

    public void clearDownloadData(int i4) {
        sr.c().sr(i4, true);
    }

    public void destoryDownloader() {
        xv.c();
    }

    public void forceDownloadIngoreRecommendSize(int i4) {
        sr.c().t(i4);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return sr.c().ux();
    }

    public long getCurBytes(int i4) {
        return sr.c().ev(i4);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i4) {
        return sr.c().s(i4);
    }

    public int getDownloadId(String str, String str2) {
        return sr.c().c(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i4) {
        return sr.c().k(i4);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return sr.c().c(str);
    }

    public com.ss.android.socialbase.downloader.depend.n getDownloadNotificationEventListener(int i4) {
        return sr.c().a(i4);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return sr.c().ux(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return sr.c().w(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public s getReserveWifiStatusListener() {
        return xv.mt();
    }

    public int getStatus(int i4) {
        return sr.c().gd(i4);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return sr.c().xv(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return sr.c().sr(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return sr.c().f();
    }

    public boolean isDownloadServiceForeground(int i4) {
        return sr.c().xv(i4).w();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return sr.c().c(downloadInfo);
    }

    public boolean isDownloading(int i4) {
        boolean p3;
        if (com.ss.android.socialbase.downloader.gd.c.c(4194304)) {
            synchronized (this) {
                p3 = sr.c().p(i4);
            }
            return p3;
        }
        return sr.c().p(i4);
    }

    public boolean isHttpServiceInit() {
        return sr.c().sr();
    }

    public void pause(int i4) {
        sr.c().sr(i4);
    }

    public void pauseAll() {
        sr.c().xv();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        sr.c().c(kVar);
    }

    public void registerDownloaderProcessConnectedListener(ba baVar) {
        sr.c().c(baVar);
    }

    public void removeMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().c(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void removeNotificationListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().c(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().c(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i4) {
        sr.c().c(i4, null, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i4) {
        sr.c().c(i4, null, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i4) {
        sr.c().c(i4, null, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void restart(int i4) {
        sr.c().r(i4);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        sr.c().c(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        sr.c().w(list);
    }

    public void resume(int i4) {
        sr.c().f(i4);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (com.ss.android.socialbase.downloader.gd.c.c(4194304)) {
            synchronized (this) {
                xv.w();
            }
            return;
        }
        xv.w();
    }

    public void setDownloadNotificationEventListener(int i4, com.ss.android.socialbase.downloader.depend.n nVar) {
        sr.c().c(i4, nVar);
    }

    public void setLogLevel(int i4) {
        sr.c().fp(i4);
    }

    @Deprecated
    public void setMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().w(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().w(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(s sVar) {
        xv.c(sVar);
    }

    @Deprecated
    public void setSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().w(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void setThrottleNetSpeed(int i4, long j4) {
        sr.c().c(i4, j4);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        sr.c().w(kVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ba baVar) {
        sr.c().w(baVar);
    }

    private File getGlobalSaveDir(String str, boolean z3) {
        File file;
        File file2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            file = new File(str);
        } catch (Throwable unused) {
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                if (!z3) {
                    return null;
                }
                file.delete();
                file.mkdirs();
            }
            return file;
        } catch (Throwable unused2) {
            file2 = file;
            return file2;
        }
    }

    public void cancel(int i4, boolean z3) {
        sr.c().xv(i4, z3);
    }

    public void clearDownloadData(int i4, boolean z3) {
        sr.c().sr(i4, z3);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return sr.c().w(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i4, IDownloadListener iDownloadListener, boolean z3) {
        if (iDownloadListener == null) {
            return;
        }
        sr.c().c(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true, z3);
    }
}
