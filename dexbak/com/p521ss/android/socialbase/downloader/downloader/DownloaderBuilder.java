package com.p521ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12481vz;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12623kf;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12634p;
import com.p521ss.android.socialbase.downloader.p557s.InterfaceC12721a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* renamed from: com.ss.android.socialbase.downloader.downloader.DownloaderBuilder */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloaderBuilder {
    private InterfaceC12496h chunkAdjustCalculator;
    private InterfaceC12509p chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private InterfaceC12501k downloadCache;
    private InterfaceC12623kf downloadDns;
    private boolean downloadInMultiProcess;
    private InterfaceC12500j downloadLaunchHandler;
    private InterfaceC12721a downloadMonitorListener;
    private InterfaceC12481vz downloadSetting;
    private InterfaceC12634p headHttpService;
    private IDownloadHttpService httpService;
    private InterfaceC12513r idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private InterfaceC12521x monitorConfig;
    private InterfaceC12480v notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private InterfaceC12498io ttNetHandler;
    private int writeBufferSize;
    private List<InterfaceC12484z> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(InterfaceC12484z interfaceC12484z) {
        synchronized (this.downloadCompleteHandlers) {
            if (interfaceC12484z != null) {
                if (!this.downloadCompleteHandlers.contains(interfaceC12484z)) {
                    this.downloadCompleteHandlers.add(interfaceC12484z);
                    return this;
                }
            }
            return this;
        }
    }

    public Downloader build() {
        return new Downloader(this);
    }

    public DownloaderBuilder chunkAdjustCalculator(InterfaceC12496h interfaceC12496h) {
        this.chunkAdjustCalculator = interfaceC12496h;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(InterfaceC12509p interfaceC12509p) {
        this.chunkCntCalculator = interfaceC12509p;
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

    public DownloaderBuilder downloadCache(InterfaceC12501k interfaceC12501k) {
        this.downloadCache = interfaceC12501k;
        return this;
    }

    public DownloaderBuilder downloadDns(InterfaceC12623kf interfaceC12623kf) {
        this.downloadDns = interfaceC12623kf;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(InterfaceC12500j interfaceC12500j) {
        this.downloadLaunchHandler = interfaceC12500j;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(InterfaceC12721a interfaceC12721a) {
        this.downloadMonitorListener = interfaceC12721a;
        return this;
    }

    public DownloaderBuilder downloadSetting(InterfaceC12481vz interfaceC12481vz) {
        this.downloadSetting = interfaceC12481vz;
        return this;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public InterfaceC12496h getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public InterfaceC12509p getChunkCntCalculator() {
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

    public InterfaceC12501k getDownloadCache() {
        return this.downloadCache;
    }

    public List<InterfaceC12484z> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public InterfaceC12623kf getDownloadDns() {
        return this.downloadDns;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public InterfaceC12500j getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public InterfaceC12721a getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public InterfaceC12481vz getDownloadSetting() {
        return this.downloadSetting;
    }

    public InterfaceC12634p getHeadHttpService() {
        return this.headHttpService;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public InterfaceC12513r getIdGenerator() {
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

    public InterfaceC12521x getMonitorConfig() {
        return this.monitorConfig;
    }

    public InterfaceC12480v getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public InterfaceC12498io getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public DownloaderBuilder headHttpService(InterfaceC12634p interfaceC12634p) {
        this.headHttpService = interfaceC12634p;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder idGenerator(InterfaceC12513r interfaceC12513r) {
        this.idGenerator = interfaceC12513r;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
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

    public DownloaderBuilder monitorConfig(InterfaceC12521x interfaceC12521x) {
        this.monitorConfig = interfaceC12521x;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(InterfaceC12480v interfaceC12480v) {
        this.notificationClickCallback = interfaceC12480v;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ttNetHandler(InterfaceC12498io interfaceC12498io) {
        this.ttNetHandler = interfaceC12498io;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }
}
