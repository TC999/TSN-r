package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLThreadPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLDownLoadTask {
    public static final int IsHttpOpen = 0;
    public static final int IsHttpRead = 1;
    public static final int IsInValidStep = -1;
    public static final int IsReponseHeader = 0;
    public static final int IsResponseComplete = 3;
    public static final int IsResponseData = 1;
    public static final int IsResponseError = 2;
    private static final String TAG = "AVMDLDownLoadTask";
    private File file;
    FileOutputStream fos;
    private Future mFuture;
    private AVMDLRequest mRequest;
    private AVMDLResponse mResponse;
    private long mHandle = 0;
    private boolean mIsRunning = false;
    private int mStep = -1;
    private Lock mHandleLock = new ReentrantLock();
    private Lock mResonseLock = new ReentrantLock();

    private static native void _notifyLoadInfo(long j4, int i4, long j5, long j6, String str);

    private static native int _onRecvData(long j4, byte[] bArr, int i4);

    @SuppressLint({"CI_DefaultLocale"})
    private void cancelResponse() {
        try {
            this.mResonseLock.lock();
            if (this.mResponse != null) {
                AVMDLLog.d(TAG, "start cancel response");
                long currentTimeMillis = System.currentTimeMillis();
                this.mResponse.cancel();
                AVMDLLog.d(TAG, String.format("end cancel cost time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            }
        } finally {
            this.mResonseLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public AVMDLResponse httOpen(AVMDLRequest aVMDLRequest) {
        int i4;
        AVMDLResponse aVMDLResponse;
        int i5;
        AVMDLLog.d(TAG, "start http open, url:" + aVMDLRequest.urls[aVMDLRequest.mCurlUrlIndex] + "object:" + this + "handle:" + this.mHandle);
        int i6 = aVMDLRequest.mCurlUrlIndex;
        setResponse(null);
        int i7 = i6;
        do {
            AVMDLLog.d(TAG, String.format("http open index:%d state:%d trycount:%d maxTry:%d", Integer.valueOf(i7), Integer.valueOf(aVMDLRequest.mUrlState[i7]), Integer.valueOf(aVMDLRequest.mUrlErrCount[i7]), Integer.valueOf(aVMDLRequest.mMaxTryCout)) + " url:" + aVMDLRequest.urls[i7]);
            if (aVMDLRequest.mUrlState[i7] == 0 && ((i4 = aVMDLRequest.mMaxTryCout) <= 0 || aVMDLRequest.mUrlErrCount[i7] < i4)) {
                try {
                    aVMDLResponse = AVMDLHttpExcutor.excute(aVMDLRequest, i7);
                } catch (IOException e4) {
                    AVMDLLog.d(TAG, "io exception:" + e4.getLocalizedMessage() + "for url:" + aVMDLRequest.urls[i7]);
                    aVMDLResponse = null;
                }
                if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                    AVMDLLog.d(TAG, "http open suc");
                    setResponse(aVMDLResponse);
                    notifyToNative(0, aVMDLResponse.statusCode, aVMDLResponse.contentlength, null);
                    AVMDLLog.d(TAG, "end http open");
                    aVMDLResponse.request = aVMDLRequest;
                    return aVMDLResponse;
                }
                int[] iArr = aVMDLRequest.mUrlErrCount;
                iArr[i7] = iArr[i7] + 1;
                if (aVMDLResponse != null && (i5 = aVMDLResponse.statusCode) >= 400 && i5 < 600) {
                    aVMDLRequest.mUrlState[i7] = 1;
                    AVMDLLog.d(TAG, String.format("set url state forbidden index:%d", Integer.valueOf(i7)));
                }
            }
            i7 = (i7 + 1) % aVMDLRequest.urls.length;
        } while (i7 != i6);
        AVMDLLog.d(TAG, "end http open");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CI_DefaultLocale"})
    public AVMDLResponse httpRead(AVMDLResponse aVMDLResponse, byte[] bArr) {
        int readData = aVMDLResponse.readData(bArr);
        if (readData > 0) {
            try {
                this.mHandleLock.lock();
                long j4 = this.mHandle;
                if (j4 != 0) {
                    _onRecvData(j4, bArr, readData);
                }
            } finally {
                this.mHandleLock.unlock();
            }
        }
        return aVMDLResponse;
    }

    @SuppressLint({"CI_DefaultLocale"})
    private void setHandle(long j4) {
        try {
            this.mHandleLock.lock();
            this.mHandle = j4;
            AVMDLLog.d(TAG, String.format("set handle:%d", Long.valueOf(j4)));
        } finally {
            this.mHandleLock.unlock();
        }
    }

    private void setResponse(AVMDLResponse aVMDLResponse) {
        this.mResonseLock.lock();
        this.mResponse = aVMDLResponse;
        this.mResonseLock.unlock();
    }

    public void close() {
        setHandle(0L);
        this.mIsRunning = false;
        cancelResponse();
    }

    @SuppressLint({"CI_DefaultLocale"})
    public void notifyToNative(int i4, long j4, long j5, String str) {
        AVMDLLog.d(TAG, String.format("notify type:%d code:%d param:%d ", Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(j5)));
        try {
            this.mHandleLock.lock();
            long j6 = this.mHandle;
            if (j6 != 0) {
                _notifyLoadInfo(j6, i4, j4, j5, str);
            }
        } finally {
            this.mHandleLock.unlock();
        }
    }

    public int open(long j4, Object obj, Object obj2, int i4, int i5, int i6) {
        if (j4 != 0 && obj != null) {
            AVMDLRequest aVMDLRequest = (AVMDLRequest) obj;
            String[] strArr = aVMDLRequest.urls;
            if (strArr != null && strArr.length != 0) {
                this.mRequest = aVMDLRequest;
                setHandle(j4);
                this.mStep = 0;
                this.mIsRunning = true;
                this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.downloader.AVMDLDownLoadTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AVMDLResponse aVMDLResponse = new AVMDLResponse(AVMDLDownLoadTask.this.mRequest, null, null);
                        byte[] bArr = new byte[32768];
                        while (AVMDLDownLoadTask.this.mIsRunning) {
                            int i7 = AVMDLDownLoadTask.this.mStep;
                            if (i7 == 0) {
                                aVMDLResponse = AVMDLDownLoadTask.this.httOpen(aVMDLResponse.request);
                                if (aVMDLResponse != null && aVMDLResponse.isOpenSuccessful()) {
                                    AVMDLDownLoadTask.this.mStep = 1;
                                } else {
                                    AVMDLDownLoadTask.this.notifyToNative(2, -777L, 0L, null);
                                    AVMDLLog.d(AVMDLDownLoadTask.TAG, "http open fail");
                                    return;
                                }
                            } else if (i7 != 1) {
                                continue;
                            } else {
                                aVMDLResponse = AVMDLDownLoadTask.this.httpRead(aVMDLResponse, bArr);
                                if (!aVMDLResponse.isReadSuccessful()) {
                                    AVMDLLog.d(AVMDLDownLoadTask.TAG, "read fail try http open");
                                    AVMDLDownLoadTask.this.mStep = 0;
                                } else if (aVMDLResponse.isFinish()) {
                                    AVMDLDownLoadTask.this.notifyToNative(3, 0L, aVMDLResponse.contentlength, null);
                                    AVMDLLog.d(AVMDLDownLoadTask.TAG, "request is finish");
                                    return;
                                }
                            }
                        }
                    }
                });
                return 0;
            }
            AVMDLLog.e(TAG, "no url err");
            return -2;
        }
        AVMDLLog.e(TAG, "handle zero err");
        return -1;
    }
}
