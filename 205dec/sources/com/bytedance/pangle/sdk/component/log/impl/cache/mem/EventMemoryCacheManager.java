package com.bytedance.pangle.sdk.component.log.impl.cache.mem;

import com.bytedance.pangle.sdk.component.log.impl.debug.EventDebugUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class EventMemoryCacheManager<T extends AdLogEventFace> {
    private String TAG;
    private Queue<T> cacheQueue = new ConcurrentLinkedQueue();
    private PolicyConfig mPolicy;
    private Queue<String> sendingQueue;

    public EventMemoryCacheManager(PolicyConfig policyConfig, Queue<String> queue, String str) {
        this.mPolicy = policyConfig;
        this.sendingQueue = queue;
        this.TAG = str;
    }

    public void add(T t3) {
        Queue<T> queue = this.cacheQueue;
        if (queue == null || t3 == null) {
            return;
        }
        queue.offer(t3);
    }

    public synchronized boolean checkNeedUpload(int i4, int i5) {
        int size = this.cacheQueue.size();
        int i6 = this.mPolicy.getmMaxCacheCount();
        LDebug.w(this.TAG + " size:" + size + " cacheCount:" + i6 + " message:" + i4);
        if (i4 != 2 && i4 != 1) {
            return size >= i6;
        } else if (EventDebugUtils.isGroMore()) {
            return size >= 1;
        } else {
            return size >= i6;
        }
    }

    public synchronized List<AdLogEventFace> get(int i4, int i5) {
        if (checkNeedUpload(i4, i5)) {
            ArrayList arrayList = new ArrayList(this.mPolicy.getmMaxCacheCount());
            do {
                T poll = this.cacheQueue.poll();
                if (poll == null) {
                    break;
                }
                arrayList.add(poll);
            } while (arrayList.size() != this.mPolicy.getmAtMostBatchSendCount());
            return arrayList;
        }
        return null;
    }

    public synchronized void handleUploadResult(int i4, List<T> list) {
        if (i4 != -1 && i4 != 200 && i4 != 509) {
            this.cacheQueue.addAll(list);
        } else {
            LDebug.w(this.TAG + " memory size\uff1a" + this.cacheQueue.size());
        }
    }

    public String printMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("In component cacheQueue:");
        sb.append(this.cacheQueue.size());
        sb.append(" sendingQueue:");
        Queue<String> queue = this.sendingQueue;
        sb.append(queue == null ? 0 : queue.size());
        return sb.toString();
    }
}
