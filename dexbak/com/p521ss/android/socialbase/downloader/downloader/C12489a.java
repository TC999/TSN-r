package com.p521ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12428er;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.socialbase.downloader.downloader.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12489a {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17681a(i, iDownloadListener, EnumC12414kf.MAIN, false);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17681a(i, iDownloadListener, EnumC12414kf.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17681a(i, iDownloadListener, EnumC12414kf.SUB, false);
    }

    public boolean canResume(int i) {
        return C12515s.m17660ok().m17662n(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void clearDownloadData(int i) {
        C12515s.m17660ok().m17639s(i, true);
    }

    public void destoryDownloader() {
        C12490bl.m17802ok();
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        C12515s.m17660ok().m17642rh(i);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return C12515s.m17660ok().m17663n();
    }

    public long getCurBytes(int i) {
        return C12515s.m17660ok().m17645p(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return C12515s.m17660ok().m17636td(i);
    }

    public int getDownloadId(String str, String str2) {
        return C12515s.m17660ok().m17648ok(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return C12515s.m17660ok().m17643r(i);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return C12515s.m17660ok().m17649ok(str);
    }

    public InterfaceC12427ep getDownloadNotificationEventListener(int i) {
        return C12515s.m17660ok().m17667j(i);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return C12515s.m17660ok().m17661n(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return C12515s.m17660ok().m17676a(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public InterfaceC12518td getReserveWifiStatusListener() {
        return C12490bl.m17746yt();
    }

    public int getStatus(int i) {
        return C12515s.m17660ok().m17644q(i);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return C12515s.m17660ok().m17670bl(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return C12515s.m17660ok().m17638s(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return C12515s.m17660ok().m17665kf();
    }

    public boolean isDownloadServiceForeground(int i) {
        return C12515s.m17660ok().m17672bl(i).mo17472a();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return C12515s.m17660ok().m17651ok(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean m17666k;
        if (C12717ok.m16510ok(4194304)) {
            synchronized (this) {
                m17666k = C12515s.m17660ok().m17666k(i);
            }
            return m17666k;
        }
        return C12515s.m17660ok().m17666k(i);
    }

    public boolean isHttpServiceInit() {
        return C12515s.m17660ok().m17641s();
    }

    public void pause(int i) {
        C12515s.m17660ok().m17640s(i);
    }

    public void pauseAll() {
        C12515s.m17660ok().m17673bl();
    }

    public void registerDownloadCacheSyncListener(InterfaceC12468r interfaceC12468r) {
        C12515s.m17660ok().m17652ok(interfaceC12468r);
    }

    public void registerDownloaderProcessConnectedListener(InterfaceC12428er interfaceC12428er) {
        C12515s.m17660ok().m17653ok(interfaceC12428er);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17657ok(i, iDownloadListener, EnumC12414kf.MAIN, false);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17657ok(i, iDownloadListener, EnumC12414kf.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17657ok(i, iDownloadListener, EnumC12414kf.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        C12515s.m17660ok().m17657ok(i, null, EnumC12414kf.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        C12515s.m17660ok().m17657ok(i, null, EnumC12414kf.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        C12515s.m17660ok().m17657ok(i, null, EnumC12414kf.SUB, true);
    }

    public void restart(int i) {
        C12515s.m17660ok().m17669h(i);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        C12515s.m17660ok().m17647ok(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        C12515s.m17660ok().m17674a(list);
    }

    public void resume(int i) {
        C12515s.m17660ok().m17664kf(i);
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
        if (C12717ok.m16510ok(4194304)) {
            synchronized (this) {
                C12490bl.m17841a();
            }
            return;
        }
        C12490bl.m17841a();
    }

    public void setDownloadNotificationEventListener(int i, InterfaceC12427ep interfaceC12427ep) {
        C12515s.m17660ok().m17655ok(i, interfaceC12427ep);
    }

    public void setLogLevel(int i) {
        C12515s.m17660ok().m17668i(i);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17681a(i, iDownloadListener, EnumC12414kf.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17681a(i, iDownloadListener, EnumC12414kf.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(InterfaceC12518td interfaceC12518td) {
        C12490bl.m17786ok(interfaceC12518td);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17681a(i, iDownloadListener, EnumC12414kf.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        C12515s.m17660ok().m17658ok(i, j);
    }

    public void unRegisterDownloadCacheSyncListener(InterfaceC12468r interfaceC12468r) {
        C12515s.m17660ok().m17678a(interfaceC12468r);
    }

    public void unRegisterDownloaderProcessConnectedListener(InterfaceC12428er interfaceC12428er) {
        C12515s.m17660ok().m17679a(interfaceC12428er);
    }

    private File getGlobalSaveDir(String str, boolean z) {
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
                if (!z) {
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

    public void cancel(int i, boolean z) {
        C12515s.m17660ok().m17671bl(i, z);
    }

    public void clearDownloadData(int i, boolean z) {
        C12515s.m17660ok().m17639s(i, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return C12515s.m17660ok().m17675a(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        C12515s.m17660ok().m17656ok(i, iDownloadListener, EnumC12414kf.MAIN, true, z);
    }
}
