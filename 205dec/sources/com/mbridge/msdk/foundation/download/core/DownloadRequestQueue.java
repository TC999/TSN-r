package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DownloadRequestQueue<T> {
    private static final String TAG = "DownloadRequestQueue";
    private final ConcurrentHashMap<String, DownloadRequest<T>> currentRequestMap;
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<DownloadRequest<T>>> delayRequestMap;
    private final AtomicInteger sequenceGenerator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class ClassHolder {
        private static final DownloadRequestQueue DOWNLOAD_REQUEST_QUEUE = new DownloadRequestQueue();

        private ClassHolder() {
        }
    }

    private void cancelAndRemoveFromMap(DownloadRequest downloadRequest, String str) {
        if (downloadRequest != null) {
            downloadRequest.cancel(downloadRequest.getDownloadMessage());
        }
    }

    public static DownloadRequestQueue getInstance() {
        return ClassHolder.DOWNLOAD_REQUEST_QUEUE;
    }

    private int getSequenceNumber() {
        return this.sequenceGenerator.incrementAndGet();
    }

    public synchronized void addRequest(DownloadRequest<T> downloadRequest) {
        String downloadId = downloadRequest.getDownloadId();
        downloadRequest.setSequence(getSequenceNumber());
        if (this.currentRequestMap.containsKey(downloadId)) {
            DownloadStatus status = downloadRequest.getStatus();
            DownloadStatus downloadStatus = DownloadStatus.RETRY;
            if (status != downloadStatus) {
                downloadStatus = DownloadStatus.DELAY;
            }
            downloadRequest.setStatus(downloadStatus);
            if (this.delayRequestMap.containsKey(downloadId)) {
                CopyOnWriteArrayList<DownloadRequest<T>> copyOnWriteArrayList = this.delayRequestMap.get(downloadId);
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.add(downloadRequest);
                    this.delayRequestMap.remove(downloadId);
                    this.delayRequestMap.put(downloadId, copyOnWriteArrayList);
                }
            } else {
                CopyOnWriteArrayList<DownloadRequest<T>> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(downloadRequest);
                this.delayRequestMap.put(downloadId, copyOnWriteArrayList2);
            }
        } else {
            DownloadStatus status2 = downloadRequest.getStatus();
            DownloadStatus downloadStatus2 = DownloadStatus.RETRY;
            if (status2 != downloadStatus2) {
                downloadStatus2 = DownloadStatus.QUEUED;
            }
            downloadRequest.setStatus(downloadStatus2);
            this.currentRequestMap.put(downloadId, downloadRequest);
            downloadRequest.setFuture(ExecutorManager.getInstance().getExecutorSupplier().getDownloadTasks().submit(new Downloader(downloadRequest)));
        }
    }

    public synchronized void cancel(String str) {
        CopyOnWriteArrayList<DownloadRequest<T>> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && this.delayRequestMap.containsKey(str) && (copyOnWriteArrayList = this.delayRequestMap.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            Iterator<DownloadRequest<T>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                DownloadRequest<T> next = it.next();
                copyOnWriteArrayList.remove(next);
                next.handlerCancelEvent(next.getDownloadMessage());
            }
            if (copyOnWriteArrayList.size() > 0) {
                this.delayRequestMap.remove(str);
                this.delayRequestMap.put(str, copyOnWriteArrayList);
            } else {
                this.delayRequestMap.remove(str);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            cancelAndRemoveFromMap(this.currentRequestMap.get(str), str);
        }
    }

    public synchronized void cancelAll() {
        for (Map.Entry<String, CopyOnWriteArrayList<DownloadRequest<T>>> entry : this.delayRequestMap.entrySet()) {
            CopyOnWriteArrayList<DownloadRequest<T>> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<DownloadRequest<T>> it = value.iterator();
                while (it.hasNext()) {
                    DownloadRequest<T> next = it.next();
                    if (next != null) {
                        next.handlerCancelEvent(next.getDownloadMessage());
                    }
                }
            }
        }
        this.delayRequestMap.clear();
        for (Map.Entry<String, DownloadRequest<T>> entry2 : this.currentRequestMap.entrySet()) {
            DownloadRequest<T> value2 = entry2.getValue();
            cancelAndRemoveFromMap(value2, value2.getDownloadId());
        }
    }

    public synchronized void finish(DownloadRequest downloadRequest) {
        CopyOnWriteArrayList<DownloadRequest<T>> remove;
        String downloadId = downloadRequest.getDownloadId();
        this.currentRequestMap.remove(downloadId);
        if (this.delayRequestMap.containsKey(downloadId) && (remove = this.delayRequestMap.remove(downloadId)) != null && remove.size() > 0) {
            DownloadRequest<T> remove2 = remove.remove(0);
            remove2.setStatus(DownloadStatus.QUEUED);
            this.currentRequestMap.put(downloadId, remove2);
            remove2.setFuture(ExecutorManager.getInstance().getExecutorSupplier().getDownloadTasks().submit(new Downloader(remove2)));
            if (remove.size() > 0) {
                this.delayRequestMap.put(downloadId, remove);
            }
        }
    }

    public synchronized DownloadStatus getStatus(String str) {
        DownloadRequest<T> downloadRequest = this.currentRequestMap.get(str);
        if (downloadRequest != null) {
            return downloadRequest.getStatus();
        }
        return DownloadStatus.UNKNOWN;
    }

    public void initialize() {
    }

    private DownloadRequestQueue() {
        this.currentRequestMap = new ConcurrentHashMap<>();
        this.sequenceGenerator = new AtomicInteger();
        this.delayRequestMap = new ConcurrentHashMap<>();
    }
}
