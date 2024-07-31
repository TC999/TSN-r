package com.mbridge.msdk.foundation.download.core;

import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadResponse;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
class SynchronizeAvailableDirectorPath implements IDownloadTask {
    private int cacheDirectorPathType;
    private String cacheDirectoryPath;
    private String cacheDirectoryPathExternal;
    private String cacheDirectoryPathInternal;
    private DownloadRequest downloadRequest;

    public SynchronizeAvailableDirectorPath(DownloadRequest downloadRequest) {
        this.downloadRequest = downloadRequest;
    }

    public static IDownloadTask create(DownloadRequest downloadRequest) {
        return new SynchronizeAvailableDirectorPath(downloadRequest);
    }

    @Override // com.mbridge.msdk.foundation.download.core.IDownloadTask
    public DownloadResponse run() {
        String str;
        DownloadRequest downloadRequest;
        this.cacheDirectoryPathExternal = this.downloadRequest.getDirectoryPathExternal();
        String directoryPathInternal = this.downloadRequest.getDirectoryPathInternal();
        this.cacheDirectoryPathInternal = directoryPathInternal;
        if (!TextUtils.isEmpty(directoryPathInternal)) {
            try {
                try {
                    if (TextUtils.isEmpty(this.cacheDirectoryPathExternal)) {
                        this.cacheDirectoryPath = this.cacheDirectoryPathInternal;
                        this.cacheDirectorPathType = 0;
                    } else if (Build.VERSION.SDK_INT > 28) {
                        this.cacheDirectoryPath = this.cacheDirectoryPathInternal;
                        this.cacheDirectorPathType = 0;
                    } else {
                        GlobalComponent.getInstance().getContext();
                        this.cacheDirectoryPath = this.cacheDirectoryPathInternal;
                        this.cacheDirectorPathType = 0;
                    }
                    downloadRequest = this.downloadRequest;
                    str = this.cacheDirectoryPath;
                } catch (Exception unused) {
                    str = this.cacheDirectoryPathInternal;
                    this.cacheDirectoryPath = str;
                    this.cacheDirectorPathType = 0;
                    downloadRequest = this.downloadRequest;
                }
                downloadRequest.setCacheDirectoryPath(str);
                this.downloadRequest.setCacheDirectorPathType(this.cacheDirectorPathType);
                return null;
            } catch (Throwable th) {
                this.downloadRequest.setCacheDirectoryPath(this.cacheDirectoryPath);
                this.downloadRequest.setCacheDirectorPathType(this.cacheDirectorPathType);
                throw th;
            }
        }
        throw new RuntimeException("必须指定 cacheDirectoryPathInternal");
    }
}
