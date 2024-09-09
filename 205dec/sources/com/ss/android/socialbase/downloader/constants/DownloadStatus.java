package com.ss.android.socialbase.downloader.constants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadStatus {
    public static final int CANCELED = -4;
    public static final int CONNECTED = 3;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int FIRST_START = 6;
    public static final int FIRST_SUCCESS = -6;
    public static final int IDLE_STATUS = 0;
    public static final int INTERCEPT = -7;
    public static final int PAUSED = -2;
    public static final int PAUSED_BY_DB_INIT = -5;
    public static final int PREPARE = 1;
    public static final int PROGRESS = 4;
    public static final int RETRY = 5;
    public static final int RETRY_DELAY = 7;
    public static final int SINGLE_CHUNK_DELAY_RETRY = 10;
    public static final int SINGLE_CHUNK_RETRY = 9;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int WAITING_ASYNC_HANDLER = 8;

    public static boolean isDownloadOver(int i4) {
        return (i4 >= 0 || i4 == -2 || i4 == -5) ? false : true;
    }

    public static boolean isDownloading(int i4) {
        return (i4 <= 0 || i4 == 7 || i4 == 8 || i4 == 10) ? false : true;
    }

    public static boolean isFailedStatus(int i4) {
        return i4 == -1 || i4 == -7;
    }

    public static boolean isMonitorStatus(int i4) {
        return i4 == 2 || i4 == -3 || i4 == -1 || i4 == -4 || i4 == -2 || i4 == 6 || i4 == 0;
    }

    public static boolean isRealTimeUploadStatus(int i4) {
        return i4 == -3 || i4 == -1 || i4 == -4 || i4 == -2 || i4 == 5 || i4 == 7 || i4 == 8;
    }

    public static boolean isTimeUploadStatus(int i4) {
        return i4 == -3 || i4 == -1 || i4 == -4;
    }

    public static boolean isUnCompletedStatus(int i4) {
        return i4 == -1 || i4 == -2 || i4 == -7 || i4 == -4 || i4 == -5;
    }
}
