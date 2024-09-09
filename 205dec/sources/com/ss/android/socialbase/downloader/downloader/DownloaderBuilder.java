package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.vz;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloaderBuilder {
    private h chunkAdjustCalculator;
    private p chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private k downloadCache;
    private com.ss.android.socialbase.downloader.network.kf downloadDns;
    private boolean downloadInMultiProcess;
    private j downloadLaunchHandler;
    private com.ss.android.socialbase.downloader.s.a downloadMonitorListener;
    private vz downloadSetting;
    private com.ss.android.socialbase.downloader.network.p headHttpService;
    private IDownloadHttpService httpService;
    private r idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private x monitorConfig;
    private v notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private io ttNetHandler;
    private int writeBufferSize;
    private List<com.ss.android.socialbase.downloader.depend.z> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.z zVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (zVar != null) {
                if (!this.downloadCompleteHandlers.contains(zVar)) {
                    this.downloadCompleteHandlers.add(zVar);
                    return this;
                }
            }
            return this;
        }
    }

    public Downloader build() {
        return new Downloader(this);
    }

    public DownloaderBuilder chunkAdjustCalculator(h hVar) {
        this.chunkAdjustCalculator = hVar;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(p pVar) {
        this.chunkCntCalculator = pVar;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadCache(k kVar) {
        this.downloadCache = kVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.ss.android.socialbase.downloader.network.kf kfVar) {
        this.downloadDns = kfVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i4) {
        this.downloadExpSwitch = i4;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z3) {
        this.downloadInMultiProcess = z3;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(j jVar) {
        this.downloadLaunchHandler = jVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.ss.android.socialbase.downloader.s.a aVar) {
        this.downloadMonitorListener = aVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(vz vzVar) {
        this.downloadSetting = vzVar;
        return this;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public h getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public p getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public Context getContext() {
        return this.context;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public k getDownloadCache() {
        return this.downloadCache;
    }

    public List<com.ss.android.socialbase.downloader.depend.z> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public com.ss.android.socialbase.downloader.network.kf getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public j getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public com.ss.android.socialbase.downloader.s.a getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public vz getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.ss.android.socialbase.downloader.network.p getHeadHttpService() {
        return this.headHttpService;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public r getIdGenerator() {
        return this.idGenerator;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public x getMonitorConfig() {
        return this.monitorConfig;
    }

    public v getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public io getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public DownloaderBuilder headHttpService(com.ss.android.socialbase.downloader.network.p pVar) {
        this.headHttpService = pVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder idGenerator(r rVar) {
        this.idGenerator = rVar;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i4) {
        this.maxDownloadPoolSize = i4;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder monitorConfig(x xVar) {
        this.monitorConfig = xVar;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z3) {
        this.needAutoRefreshUnSuccessTask = z3;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(v vVar) {
        this.notificationClickCallback = vVar;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ttNetHandler(io ioVar) {
        this.ttNetHandler = ioVar;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int i4) {
        this.writeBufferSize = i4;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }
}
