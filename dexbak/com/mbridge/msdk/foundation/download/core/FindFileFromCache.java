package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.core.DownloaderReporter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import java.io.File;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
class FindFileFromCache implements IDownloadTask {
    private final IDatabaseHelper _databaseHelper;
    private final String _downloadId;
    private DownloadMessage _downloadMessage;
    private final DownloadModel _downloadModel;
    private DownloaderReporter.Builder _downloaderReporter;
    private final DownloadRequest _request;

    private FindFileFromCache(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, String str, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        this._request = downloadRequest;
        this._downloadModel = downloadModel;
        this._databaseHelper = iDatabaseHelper;
        this._downloadId = str;
        this._downloadMessage = downloadMessage;
        this._downloaderReporter = builder;
    }

    private boolean checkDownloadReadyRate(long j) {
        return Utils.getDownloadRate(this._downloadModel.getTotalBytes(), j) >= this._downloadMessage.getDownloadRate();
    }

    private boolean checkUseFileResume() {
        boolean z;
        try {
            z = Boolean.parseBoolean(this._request.get("do_us_fi_re", Boolean.toString(true)));
        } catch (Exception unused) {
            GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, "类型转换错误： do_us_fi_re");
            z = false;
        }
        DownloaderReporter.Builder builder = this._downloaderReporter;
        builder.add(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_C + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDownloadTask create(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, String str, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        if (Objects.isNull(builder)) {
            builder = new DownloaderReporter.Builder(DownloadCommon.DOWNLOAD_REPORT_KEY);
        }
        return new FindFileFromCache(downloadRequest, downloadModel, iDatabaseHelper, str, downloadMessage, builder);
    }

    private void resumeDownloadAndDeleteFile(DownloadResponse downloadResponse, File file) {
        this._request.setDownloadedBytes(0L);
        this._request.setTotalBytes(0L);
        this._databaseHelper.remove(this._downloadId);
        MBResourceManager.getInstance().deleteFile(file);
        downloadResponse.setSuccessful(false);
    }

    private void resumeDownloadFromFile(DownloadResponse downloadResponse, long j) {
        this._request.setTotalBytes(this._downloadModel.getTotalBytes());
        this._request.setDownloadedBytes(j);
        GlobalComponent.getInstance().getDatabaseHelper().update(DownloadModel.create(this._downloadModel.getDownloadId(), this._downloadModel.getDownloadUrl(), this._downloadModel.getResourceUrl(), this._downloadModel.getEtag(), this._downloadModel.getSaveDirectorPath(), this._downloadModel.getSaveFileName(), this._downloadModel.getTotalBytes(), j, this._downloadModel.getDownloadRate(), this._downloadModel.getUsageCounter(), this._downloadModel.getDownloadResourceType()), this._request.getCacheDirectoryPath());
        downloadResponse.setSuccessful(checkDownloadReadyRate(j));
    }

    @Override // com.mbridge.msdk.foundation.download.core.IDownloadTask
    public DownloadResponse run() {
        if (Objects.isNull(this._downloadModel)) {
            return null;
        }
        DownloadResponse downloadResponse = new DownloadResponse();
        String cacheDirectoryPath = this._request.getCacheDirectoryPath();
        String saveFileName = this._downloadMessage.getSaveFileName();
        File file = new File(cacheDirectoryPath + saveFileName);
        if (!Objects.exists(file, cacheDirectoryPath, saveFileName)) {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT, "d");
            this._request.setDownloadedBytes(0L);
            this._databaseHelper.remove(this._downloadId);
            downloadResponse.setSuccessful(false);
            return downloadResponse;
        }
        long fileSize = MBResourceManager.getInstance().getFileSize(file, cacheDirectoryPath, saveFileName);
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_SIZE, String.valueOf(fileSize));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_FIND_TOTAL_SIZE, String.valueOf(this._downloadModel.getTotalBytes()));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_FIND_DOWNLOAD_SIZE, String.valueOf(this._downloadModel.getDownloadedBytes()));
        if (fileSize != this._downloadModel.getDownloadedBytes()) {
            boolean checkUseFileResume = checkUseFileResume();
            ILogger logger = GlobalComponent.getInstance().getLogger();
            logger.log(IDownloadTask.TAG, "数据库记录和文件大小不一致，是否以文件大小为基准进行断点续传： " + checkUseFileResume);
            if (checkUseFileResume) {
                resumeDownloadFromFile(downloadResponse, fileSize);
            } else {
                resumeDownloadAndDeleteFile(downloadResponse, file);
            }
            return downloadResponse;
        }
        this._request.setTotalBytes(this._downloadModel.getTotalBytes());
        this._request.setDownloadedBytes(this._downloadModel.getDownloadedBytes());
        if (checkDownloadReadyRate(this._downloadModel.getDownloadedBytes())) {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT, "a");
            downloadResponse.setFrom(this._downloadModel.getFrom());
            downloadResponse.setSuccessful(true);
        } else {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT, "b");
            downloadResponse.setSuccessful(false);
        }
        return downloadResponse;
    }
}
