package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.er;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, false);
    }

    public void addNotificationListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.SUB, false);
    }

    public boolean canResume(int i4) {
        return s.ok().n(i4);
    }

    public void cancel(int i4) {
        cancel(i4, true);
    }

    public void clearDownloadData(int i4) {
        s.ok().s(i4, true);
    }

    public void destoryDownloader() {
        bl.ok();
    }

    public void forceDownloadIngoreRecommendSize(int i4) {
        s.ok().rh(i4);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return s.ok().n();
    }

    public long getCurBytes(int i4) {
        return s.ok().p(i4);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i4) {
        return s.ok().td(i4);
    }

    public int getDownloadId(String str, String str2) {
        return s.ok().ok(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i4) {
        return s.ok().r(i4);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return s.ok().ok(str);
    }

    public ep getDownloadNotificationEventListener(int i4) {
        return s.ok().j(i4);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return s.ok().n(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return s.ok().a(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public td getReserveWifiStatusListener() {
        return bl.yt();
    }

    public int getStatus(int i4) {
        return s.ok().q(i4);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return s.ok().bl(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return s.ok().s(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return s.ok().kf();
    }

    public boolean isDownloadServiceForeground(int i4) {
        return s.ok().bl(i4).a();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return s.ok().ok(downloadInfo);
    }

    public boolean isDownloading(int i4) {
        boolean k4;
        if (com.ss.android.socialbase.downloader.q.ok.ok(4194304)) {
            synchronized (this) {
                k4 = s.ok().k(i4);
            }
            return k4;
        }
        return s.ok().k(i4);
    }

    public boolean isHttpServiceInit() {
        return s.ok().s();
    }

    public void pause(int i4) {
        s.ok().s(i4);
    }

    public void pauseAll() {
        s.ok().bl();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.r rVar) {
        s.ok().ok(rVar);
    }

    public void registerDownloaderProcessConnectedListener(er erVar) {
        s.ok().ok(erVar);
    }

    public void removeMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, false);
    }

    public void removeNotificationListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i4) {
        s.ok().ok(i4, null, com.ss.android.socialbase.downloader.constants.kf.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i4) {
        s.ok().ok(i4, null, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i4) {
        s.ok().ok(i4, null, com.ss.android.socialbase.downloader.constants.kf.SUB, true);
    }

    public void restart(int i4) {
        s.ok().h(i4);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        s.ok().ok(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        s.ok().a(list);
    }

    public void resume(int i4) {
        s.ok().kf(i4);
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
        if (com.ss.android.socialbase.downloader.q.ok.ok(4194304)) {
            synchronized (this) {
                bl.a();
            }
            return;
        }
        bl.a();
    }

    public void setDownloadNotificationEventListener(int i4, ep epVar) {
        s.ok().ok(i4, epVar);
    }

    public void setLogLevel(int i4) {
        s.ok().i(i4);
    }

    @Deprecated
    public void setMainThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(td tdVar) {
        bl.ok(tdVar);
    }

    @Deprecated
    public void setSubThreadListener(int i4, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().a(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.SUB, true);
    }

    public void setThrottleNetSpeed(int i4, long j4) {
        s.ok().ok(i4, j4);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.r rVar) {
        s.ok().a(rVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(er erVar) {
        s.ok().a(erVar);
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
        s.ok().bl(i4, z3);
    }

    public void clearDownloadData(int i4, boolean z3) {
        s.ok().s(i4, z3);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return s.ok().a(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i4, IDownloadListener iDownloadListener, boolean z3) {
        if (iDownloadListener == null) {
            return;
        }
        s.ok().ok(i4, iDownloadListener, com.ss.android.socialbase.downloader.constants.kf.MAIN, true, z3);
    }
}
