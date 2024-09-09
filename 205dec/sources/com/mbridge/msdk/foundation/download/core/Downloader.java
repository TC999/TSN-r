package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Downloader implements Runnable {
    private static final String TAG = "DownloadTask";
    private IDatabaseHelper databaseHelper;
    private volatile DownloadMessage downloadMessage;
    public final DownloadPriority downloadPriority;
    public volatile DownloadRequest downloadRequest;
    public final int sequence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Downloader(DownloadRequest downloadRequest) {
        this.downloadRequest = downloadRequest;
        this.downloadPriority = downloadRequest.getDownloadPriority();
        this.sequence = downloadRequest.getSequence();
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalComponent.getInstance().getLogger().log("DownloadTask", "\u5f00\u59cb\u4e0b\u8f7d\u4efb\u52a1");
        if (this.downloadRequest.getStatus() != DownloadStatus.RETRY) {
            this.downloadRequest.handlerStartEvent(this.downloadRequest.getDownloadMessage());
        }
        this.downloadRequest.setStatus(DownloadStatus.RUNNING);
        ILogger logger = GlobalComponent.getInstance().getLogger();
        logger.log("DownloadTask", "\u4efb\u52a1 " + this.downloadRequest.getDownloadId() + " \u4fee\u6539\u72b6\u6001\u4e3a RUNNING");
        this.downloadMessage = this.downloadRequest.getDownloadMessage();
        this.databaseHelper = GlobalComponent.getInstance().getDatabaseHelper();
        SynchronizeAvailableDirectorPath.create(this.downloadRequest).run();
        String cacheDirectoryPath = this.downloadRequest.getCacheDirectoryPath();
        int cacheDirectorPathType = this.downloadRequest.getCacheDirectorPathType();
        DownloadMessage downloadMessage = this.downloadMessage;
        downloadMessage.setSaveFilePath(cacheDirectoryPath + this.downloadMessage.getSaveFileName());
        ILogger logger2 = GlobalComponent.getInstance().getLogger();
        logger2.log("DownloadTask", "cacheDirectoryPath\uff1a " + cacheDirectoryPath + " cacheDirectorPathType\uff1a " + cacheDirectorPathType);
        DownloadResponse run = DownloadTask.create(this.downloadRequest, this.downloadMessage, this.databaseHelper).run();
        if (run.isSuccessful()) {
            if (run.getFrom() == 1) {
                this.downloadMessage.setFrom(1);
            }
            this.downloadRequest.handlerSuccessEvent(this.downloadMessage);
        } else if (run.getError() != null) {
            this.downloadRequest.handlerErrorEvent(this.downloadMessage, run.getError());
        } else if (run.isCancelled()) {
            this.downloadRequest.handlerCancelEvent(this.downloadMessage);
        }
    }
}
