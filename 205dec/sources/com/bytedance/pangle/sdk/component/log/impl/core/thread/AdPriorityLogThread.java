package com.bytedance.pangle.sdk.component.log.impl.core.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.pangle.sdk.component.log.impl.AdLogManager;
import com.bytedance.pangle.sdk.component.log.impl.HighPriorityEventUploadCallback;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.CacheManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.ICache;
import com.bytedance.pangle.sdk.component.log.impl.core.IUploadResult;
import com.bytedance.pangle.sdk.component.log.impl.core.IUploader;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventDebugUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventMonitorUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.ThreadMessage;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.pangle.sdk.component.log.impl.net.TTRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdPriorityLogThread extends HandlerThread implements Handler.Callback, ILogThreadCenter, ILogThreadChecker {
    private static final int CODE_RSPBODY_EXCEPTION_REF = 511;
    private static final int CODE_RSP_IS_NULL_REF = 510;
    private static final int FLUSH_DB_WHEN_QUEUE_SIZE = 100;
    public static final int HANDLER_MESSAGE_INIT = 1;
    public static final int HANDLER_MESSAGE_ROUTINE_ERROR = 3;
    public static final int HANDLER_MESSAGE_SERVER_BUSY = 2;
    private static final int HANDLER_OPT_DELAY_AD_MESSAGE = 11;
    private static final int MAX_OPT_TIME_OUT_MILLS = 200;
    private int MAX_OPT_SIZE;
    private final long TIME_OUT_NANO;
    private final int TYPE_AFTER_INIT;
    private final int TYPE_DISPATCH_INIT;
    private final int TYPE_NOTIFY_INIT;
    private final List<AdLogEventFace> delayFiftyAdList;
    private volatile long lastRoutineErrorRecord;
    private volatile long lastServerBusyRecord;
    private final Object lock;
    private final long lock_wait_time_out;
    protected ICache mCache;
    private volatile Handler mHandler;
    private volatile boolean mIsRun;
    private final PriorityBlockingQueue<AdLogEventFace> mPriorityBlockingQueue;
    private final AtomicInteger mRoutineRetry;
    private final AtomicInteger mRunnableCount;
    private final AtomicInteger mServerBusyRetry;
    private volatile int mTaskMessage;
    private IUploader mUploader;
    private final AtomicInteger timeoutCount;

    public AdPriorityLogThread(PriorityBlockingQueue<AdLogEventFace> priorityBlockingQueue) {
        super(EventDebugUtils.DEBUG_LOG_TAG);
        this.mIsRun = true;
        this.lock = new Object();
        this.lastServerBusyRecord = 0L;
        this.lastRoutineErrorRecord = 0L;
        this.timeoutCount = new AtomicInteger(0);
        this.lock_wait_time_out = 5000L;
        this.TIME_OUT_NANO = 5000000000L;
        this.mRunnableCount = new AtomicInteger(0);
        this.delayFiftyAdList = new ArrayList();
        this.mServerBusyRetry = new AtomicInteger(0);
        this.mRoutineRetry = new AtomicInteger(0);
        this.MAX_OPT_SIZE = 10;
        this.TYPE_AFTER_INIT = 1;
        this.TYPE_DISPATCH_INIT = 2;
        this.TYPE_NOTIFY_INIT = 3;
        this.mPriorityBlockingQueue = priorityBlockingQueue;
        this.mCache = new CacheManager();
    }

    private void afterUpload() {
        long nanoTime;
        StringBuilder sb;
        LogThreadCenter logThreadCenter;
        boolean z3;
        if (this.mHandler.hasMessages(11)) {
            ensureEventLoopConditionFalseIfNeed();
        } else {
            ensureLoopConditionTrue(1);
        }
        LDebug.d("afterUpload message:" + this.mTaskMessage);
        EventMonitor eventMonitor = LogThreadCenter.sEventMonitor;
        EventMonitorUtils.add(eventMonitor.getAll_after_count(), 1);
        if (this.mTaskMessage == 2) {
            EventMonitorUtils.add(eventMonitor.getAfter_count(), 1);
            synchronized (this.lock) {
                try {
                    try {
                        long nanoTime2 = System.nanoTime();
                        this.lock.wait(5000L);
                        nanoTime = System.nanoTime() - nanoTime2;
                        sb = new StringBuilder();
                        sb.append("afterUpload delta:");
                        sb.append(nanoTime);
                        sb.append(" start:");
                        sb.append(nanoTime2);
                        sb.append(" condition:");
                        logThreadCenter = LogThreadCenter.instance;
                    } catch (InterruptedException e4) {
                        LDebug.e("wait exception:" + e4.getMessage());
                        e4.printStackTrace();
                    }
                    if (!logThreadCenter.isServerBusy && !logThreadCenter.isRoutineError) {
                        z3 = false;
                        sb.append(z3);
                        LDebug.d(sb.toString());
                        if (nanoTime < 5000000000L && 5000000000L - nanoTime >= 50000000) {
                            if (!logThreadCenter.isServerBusy && !logThreadCenter.isRoutineError) {
                                LDebug.w("afterUpload meet notifyRunOnce again");
                                EventMonitorUtils.add(eventMonitor.getAfter_upload_threadmsssage(), 1);
                                notifyRunOnce(2);
                                return;
                            }
                            EventMonitorUtils.add(eventMonitor.getServer_net_error(), 1);
                            LDebug.e("afterUpload wait serverBusy");
                            return;
                        }
                        LDebug.e("afterUpload wait timeout");
                        EventMonitorUtils.add(eventMonitor.getTime_out_count(), 1);
                    }
                    z3 = true;
                    sb.append(z3);
                    LDebug.d(sb.toString());
                    if (nanoTime < 5000000000L) {
                        if (!logThreadCenter.isServerBusy) {
                            LDebug.w("afterUpload meet notifyRunOnce again");
                            EventMonitorUtils.add(eventMonitor.getAfter_upload_threadmsssage(), 1);
                            notifyRunOnce(2);
                            return;
                        }
                        EventMonitorUtils.add(eventMonitor.getServer_net_error(), 1);
                        LDebug.e("afterUpload wait serverBusy");
                        return;
                    }
                    LDebug.e("afterUpload wait timeout");
                    EventMonitorUtils.add(eventMonitor.getTime_out_count(), 1);
                } finally {
                }
            }
        }
    }

    private void beginSaveNewEvent(AdLogEventFace adLogEventFace) {
        this.timeoutCount.set(0);
        LogThreadCenter logThreadCenter = LogThreadCenter.instance;
        if (logThreadCenter.isServerBusy) {
            this.mTaskMessage = 5;
        } else if (logThreadCenter.isRoutineError) {
            this.mTaskMessage = 7;
        } else {
            this.mTaskMessage = 4;
        }
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getBefore_save_count(), 1);
        this.mCache.add(adLogEventFace, this.mTaskMessage);
        EventDebugUtils.monitorSave(adLogEventFace);
    }

    private void closeThisThread() {
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getStop_counts(), 1);
        setRun(false);
        LogThreadCenter.instance.stopLogThread();
        LDebug.w("exit log thread");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0114 A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x014e), top: B:73:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void dispatchResult(int r6, java.util.List<com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace> r7, long r8) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.sdk.component.log.impl.core.thread.AdPriorityLogThread.dispatchResult(int, java.util.List, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInnerUpload(List<AdLogEventFace> list, boolean z3, long j4, int i4) {
        AdEventUploadResult uploadStatsLog;
        try {
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getRequest_count(), 1);
            if (list.get(0).getAdType() == 0) {
                uploadStatsLog = LogInternalManager.getNetApi().uploadEvent(list);
                processCallback(uploadStatsLog, list);
                if (uploadStatsLog != null) {
                    EventDebugUtils.putLabelsLogId(list, uploadStatsLog.mLogid);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (AdLogEventFace adLogEventFace : list) {
                        jSONArray.put(adLogEventFace.getEvent());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e4) {
                    LDebug.e("json exception:" + e4.getMessage());
                }
                uploadStatsLog = LogInternalManager.getNetApi().uploadStatsLog(jSONObject);
            }
            AdEventUploadResult adEventUploadResult = uploadStatsLog;
            this.mRunnableCount.decrementAndGet();
            preprocessResult(z3, adEventUploadResult, list, j4);
        } catch (Throwable th) {
            LDebug.e("inner exception:" + th.getMessage());
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getQueue_timeout_threadmessage(), 1);
            this.mRunnableCount.decrementAndGet();
        }
    }

    private void doUpload(List<AdLogEventFace> list, boolean z3, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        EventDebugUtils.debugUploadMessage(list, this.mTaskMessage, str);
        IUploader upLoader = LogInternalManager.getInstance().getUpLoader();
        this.mUploader = upLoader;
        if (upLoader != null) {
            uploadOutOfComponent(list, z3, currentTimeMillis);
        } else {
            uploadInnerFromComponent(list, z3, currentTimeMillis);
        }
    }

    private void ensureEventLoopConditionFalseIfNeed() {
        try {
            if (this.mPriorityBlockingQueue.size() == 0 && this.mHandler.hasMessages(11) && getRun()) {
                setRun(false);
            }
        } catch (Exception e4) {
            LDebug.e(e4.getMessage());
        }
    }

    private void ensureLoopConditionTrue(int i4) {
        if (!getRun()) {
            if (this.mHandler == null) {
                return;
            }
            EventMonitor eventMonitor = LogThreadCenter.sEventMonitor;
            EventMonitorUtils.add(eventMonitor.getRun_false_count(), 1);
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            if (i4 == 1) {
                EventMonitorUtils.add(eventMonitor.getAfter_init_count(), 1);
            } else if (i4 == 2) {
                EventMonitorUtils.add(eventMonitor.getDispatch_init_count(), 1);
            } else if (i4 == 3) {
                EventMonitorUtils.add(eventMonitor.getNotify_init_count(), 1);
            }
            this.mHandler.sendEmptyMessage(1);
            return;
        }
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getEnter_count(), 1);
    }

    private void ensureUploadOptBatch(String str) {
        if (this.mHandler.hasMessages(11)) {
            this.mHandler.removeMessages(11);
        }
        if (this.delayFiftyAdList.size() != 0) {
            ArrayList arrayList = new ArrayList(this.delayFiftyAdList);
            this.delayFiftyAdList.clear();
            doUpload(arrayList, false, "before_" + str);
            afterUpload();
            return;
        }
        LDebug.d("ensureUploadOptBatch empty\uff1a" + str);
    }

    private void handleEventLoop() {
        while (getRun()) {
            try {
                EventMonitor eventMonitor = LogThreadCenter.sEventMonitor;
                EventMonitorUtils.add(eventMonitor.getMessage_count(), 1);
                AdLogEventFace poll = this.mPriorityBlockingQueue.poll(PolicyConfig.THREAD_BLOCK_TIMEOUT, TimeUnit.MILLISECONDS);
                int size = this.mPriorityBlockingQueue.size();
                LDebug.d("poll size:" + size);
                if (poll instanceof ThreadMessage) {
                    handleThreadMessage(poll, size);
                } else if (poll == null) {
                    int incrementAndGet = this.timeoutCount.incrementAndGet();
                    EventMonitorUtils.add(eventMonitor.getBlock_times(), 1);
                    if (isMeetCloseThreadCondition(incrementAndGet)) {
                        closeThisThread();
                        return;
                    } else if (incrementAndGet < 4) {
                        LDebug.d("timeoutCount:" + incrementAndGet);
                        this.mTaskMessage = 1;
                        prepareUpload(null);
                    }
                } else {
                    beginSaveNewEvent(poll);
                    prepareUpload(poll);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                LDebug.e("run exception:" + th.getMessage());
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getQueue_timeout_threadmessage(), 1);
            }
        }
    }

    private void handleThreadMessage(AdLogEventFace adLogEventFace, int i4) {
        this.timeoutCount.set(0);
        LDebug.d("handleThreadMessage()");
        if (i4 == 0) {
            this.mTaskMessage = ((ThreadMessage) adLogEventFace).getMessage();
            if (this.mTaskMessage != 6) {
                EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getThreadmessage_count(), 1);
                prepareUpload(adLogEventFace);
                return;
            }
            return;
        }
        ThreadMessage threadMessage = (ThreadMessage) adLogEventFace;
        if (threadMessage.getMessage() == 1) {
            this.mTaskMessage = 1;
            prepareUpload(adLogEventFace);
        } else if (threadMessage.getMessage() == 2) {
            LDebug.d("before size:" + i4);
            innerLoopForFlushDbWhenQueueIsNotEmpty();
            LDebug.d("after size :" + i4);
            this.mTaskMessage = 2;
            prepareUpload(adLogEventFace);
        }
    }

    private void innerLoopForFlushDbWhenQueueIsNotEmpty() {
        if (this.mPriorityBlockingQueue.size() >= 100) {
            for (int i4 = 0; i4 < 100; i4++) {
                AdLogEventFace poll = this.mPriorityBlockingQueue.poll();
                if (poll instanceof ThreadMessage) {
                    LDebug.d("ignore tm");
                } else if (poll != null) {
                    beginSaveNewEvent(poll);
                } else {
                    LDebug.e("event == null");
                }
            }
        }
    }

    private boolean isMeetCloseThreadCondition(int i4) {
        if (i4 >= 4 && this.mRunnableCount.get() == 0) {
            LogThreadCenter logThreadCenter = LogThreadCenter.instance;
            if (!logThreadCenter.isServerBusy && !logThreadCenter.isRoutineError) {
                return true;
            }
        }
        return false;
    }

    private boolean isMeetServerBusyCondition() {
        return LogThreadCenter.instance.isServerBusy && (this.mTaskMessage == 4 || this.mTaskMessage == 7 || this.mTaskMessage == 6 || this.mTaskMessage == 5 || this.mTaskMessage == 2);
    }

    private void monitorLogThread() {
        if (!isAlive()) {
            LDebug.d("th dead");
            LogThreadCenter.instance.createLogThreadIfNeed();
        } else if (getRun()) {
        } else {
            LDebug.d("monitor  mLogThread ");
            notifyRunOnce(6);
        }
    }

    private void prepareUpload(AdLogEventFace adLogEventFace) {
        if (isMeetServerBusyCondition()) {
            LDebug.w("upload cancel:" + EventDebugUtils.getMessageString(this.mTaskMessage));
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getCheck_return(), 1);
            if (this.mPriorityBlockingQueue.size() != 0) {
                return;
            }
            if (!this.mHandler.hasMessages(2)) {
                LogThreadCenter.instance.isServerBusy = false;
                this.lastRoutineErrorRecord = 0L;
                this.lastServerBusyRecord = 0L;
                this.mServerBusyRetry.set(0);
                this.mRoutineRetry.set(0);
            } else {
                setRun(false);
                return;
            }
        }
        boolean checkEvent = checkEvent(this.mTaskMessage, LogThreadCenter.instance.isServerBusy);
        EventDebugUtils.debugSaveMessage(checkEvent, this.mTaskMessage, adLogEventFace);
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getCheck_result(), 1);
        if (checkEvent) {
            List<AdLogEventFace> list = this.mCache.get(this.mTaskMessage, -1);
            if (list != null) {
                LDebug.w("upload size:" + list.size());
                uploadByBatchIfNeed(list);
                return;
            }
            LDebug.i("no need upload");
            ensureEventLoopConditionFalseIfNeed();
            return;
        }
        ensureEventLoopConditionFalseIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preprocessResult(boolean z3, AdEventUploadResult adEventUploadResult, List<AdLogEventFace> list, long j4) {
        if (z3 || adEventUploadResult == null) {
            return;
        }
        int i4 = adEventUploadResult.mStatusCode;
        int i5 = -2;
        if (adEventUploadResult.mIsDataError) {
            i4 = -1;
        } else if (i4 < 0) {
            i4 = -2;
        }
        i4 = (i4 == 510 || i4 == 511) ? -2 : -2;
        if (adEventUploadResult.mSuccess || ((i4 < 500 || i4 >= 509) && i4 <= 513)) {
            i5 = i4;
        }
        if (list != null) {
            LDebug.d("preprocessResult code is " + i5 + " sz:" + list.size() + "  count:" + this.mRunnableCount.get());
        }
        dispatchResult(i5, list, j4);
    }

    private void processCallback(AdEventUploadResult adEventUploadResult, List<AdLogEventFace> list) {
        if (adEventUploadResult == null || !adEventUploadResult.mSuccess) {
            return;
        }
        List<HighPriorityEventUploadCallback> list2 = AdLogManager.getsEventUploadCallbackList();
        if (list == null || list2 == null || list2.size() == 0) {
            return;
        }
        for (AdLogEventFace adLogEventFace : list) {
            if (adLogEventFace.getPriority() == 1) {
                String labelOrEvent = EventDebugUtils.getLabelOrEvent(adLogEventFace);
                String reqId = EventDebugUtils.getReqId(adLogEventFace);
                for (HighPriorityEventUploadCallback highPriorityEventUploadCallback : list2) {
                    if (highPriorityEventUploadCallback != null) {
                        highPriorityEventUploadCallback.onEventUploadSuccess(labelOrEvent, reqId);
                    }
                }
            }
        }
    }

    private void sendServerBusyOrRoutineErrorRetryMessage() {
        LDebug.d("sendServerBusyOrRoutineErrorRetryMessage");
        monitorLogThread();
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getNet_retry_threadmessage(), 1);
        notifyRunOnce(1);
    }

    private void uploadAdTypeDispatch(List<AdLogEventFace> list, String str) {
        ensureUploadOptBatch(str);
        doUpload(list, false, str);
        afterUpload();
    }

    private void uploadBatchOptimize(List<AdLogEventFace> list) {
        this.delayFiftyAdList.addAll(list);
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend != null && adLogDepend.getLogNetDepend() != null) {
            this.MAX_OPT_SIZE = adLogDepend.getLogNetDepend().getAdEventUploadBatch();
        }
        if (this.delayFiftyAdList.size() >= this.MAX_OPT_SIZE) {
            if (this.mHandler.hasMessages(11)) {
                this.mHandler.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.delayFiftyAdList);
            this.delayFiftyAdList.clear();
            doUpload(arrayList, false, EventDebugUtils.DEBUG_UPLOAD_MAX_SIZE);
            afterUpload();
        } else if (this.mPriorityBlockingQueue.size() == 0) {
            setRun(false);
            if (this.mHandler.hasMessages(11)) {
                this.mHandler.removeMessages(11);
            }
            if (this.mHandler.hasMessages(1)) {
                this.mHandler.removeMessages(1);
            }
            long j4 = 200;
            if (adLogDepend != null && adLogDepend.getLogNetDepend() != null) {
                j4 = adLogDepend.getLogNetDepend().getAdEventUploadInterval();
            }
            this.mHandler.sendEmptyMessageDelayed(11, j4);
        } else {
            LDebug.d("uploadBatchOptimize nothing\uff1a" + this.mPriorityBlockingQueue.size() + "  " + this.mIsRun);
        }
    }

    private void uploadByBatchIfNeed(List<AdLogEventFace> list) {
        if (list.size() != 0) {
            EventDebugUtils.monitorUpload(list, this.mPriorityBlockingQueue.size());
            if (list.size() <= 1 && !EventDebugUtils.isGroMore()) {
                AdLogEventFace adLogEventFace = list.get(0);
                if (adLogEventFace != null) {
                    if (adLogEventFace.getPriority() == 1) {
                        uploadAdTypeDispatch(list, EventDebugUtils.DEBUG_HIGH_PRIORITY);
                        return;
                    } else if (adLogEventFace.getAdType() == 0 && adLogEventFace.getPriority() == 2) {
                        if (adLogEventFace.getEventVersion() == 3) {
                            uploadAdTypeDispatch(list, EventDebugUtils.DEBUG_VERSION_V3);
                            return;
                        } else {
                            uploadBatchOptimize(list);
                            return;
                        }
                    } else if (adLogEventFace.getAdType() == 1) {
                        uploadAdTypeDispatch(list, "stats");
                        return;
                    } else if (adLogEventFace.getAdType() == 3) {
                        uploadAdTypeDispatch(list, EventDebugUtils.DEBUG_AD_TYPE_V3);
                        return;
                    } else if (adLogEventFace.getAdType() == 2) {
                        uploadAdTypeDispatch(list, "other");
                        return;
                    } else {
                        LDebug.d("upload adLogEvent adType error");
                        return;
                    }
                }
                LDebug.d("upload adLogEvent is null");
                return;
            }
            uploadAdTypeDispatch(list, EventDebugUtils.DEBUG_BATCH_READ);
            return;
        }
        ensureEventLoopConditionFalseIfNeed();
        LDebug.d("upload list is empty");
    }

    private void uploadInnerFromComponent(final List<AdLogEventFace> list, final boolean z3, final long j4) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend != null) {
            Executor providerIOExecutor = adLogDepend.providerIOExecutor();
            if (list.get(0).getPriority() == 1) {
                providerIOExecutor = adLogDepend.providerLogExecutor();
            }
            if (providerIOExecutor == null) {
                return;
            }
            this.mRunnableCount.incrementAndGet();
            providerIOExecutor.execute(new TTRunnable("csj_log_upload") { // from class: com.bytedance.pangle.sdk.component.log.impl.core.thread.AdPriorityLogThread.1
                @Override // java.lang.Runnable
                public void run() {
                    AdPriorityLogThread adPriorityLogThread = AdPriorityLogThread.this;
                    adPriorityLogThread.doInnerUpload(list, z3, j4, adPriorityLogThread.mTaskMessage);
                }
            });
        }
    }

    private void uploadOutOfComponent(List<AdLogEventFace> list, final boolean z3, final long j4) {
        this.mRunnableCount.incrementAndGet();
        EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getRequest_count(), 1);
        try {
            this.mUploader.upload(list, new IUploadResult() { // from class: com.bytedance.pangle.sdk.component.log.impl.core.thread.AdPriorityLogThread.2
                @Override // com.bytedance.pangle.sdk.component.log.impl.core.IUploadResult
                public void onResult(List<AdEventResCompose> list2) {
                    try {
                        AdPriorityLogThread.this.mRunnableCount.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            AdEventResCompose adEventResCompose = list2.get(i4);
                            if (adEventResCompose != null) {
                                AdPriorityLogThread.this.preprocessResult(z3, adEventResCompose.getResult(), adEventResCompose.getFaceList(), j4);
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            LDebug.e("outer exception\uff1a" + e4.getMessage());
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getQueue_timeout_threadmessage(), 1);
            this.mRunnableCount.decrementAndGet();
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.core.thread.ILogThreadChecker
    public boolean checkEvent(int i4, boolean z3) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend != null && adLogDepend.isAvailableNet(LogInternalManager.getInstance().getContext())) {
            return this.mCache.checkNeedUpload(i4, z3);
        }
        LDebug.e("AdThread NET IS NOT AVAILABLE!!!");
        return false;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.core.thread.ILogThreadCenter
    public void dispatchEvent(AdLogEventFace adLogEventFace, boolean z3) {
        if (adLogEventFace == null) {
            return;
        }
        LDebug.d("ignore result : " + z3 + ":" + this.mIsRun + " adType: " + ((int) adLogEventFace.getAdType()));
        if (z3) {
            if (this.mHandler != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(adLogEventFace);
                doUpload(arrayList, true, EventDebugUtils.DEBUG_UPLOAD_IGNORE_RESULT);
                return;
            }
            LDebug.e("handler is null\uff0cignore is true");
            return;
        }
        this.mPriorityBlockingQueue.add(adLogEventFace);
        ensureLoopConditionTrue(2);
    }

    public ICache getCache() {
        return this.mCache;
    }

    public boolean getRun() {
        return this.mIsRun;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i4 = message.what;
        try {
        } catch (Throwable th) {
            LDebug.e("error:" + th.getMessage());
        }
        if (i4 == 1) {
            LDebug.d("HANDLER_MESSAGE_INIT");
            EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getDispatch_event_count(), 1);
            setRun(true);
            handleEventLoop();
        } else if (i4 != 2 && i4 != 3) {
            if (i4 == 11) {
                LDebug.d("opt upload");
                ArrayList arrayList = new ArrayList(this.delayFiftyAdList);
                this.delayFiftyAdList.clear();
                doUpload(arrayList, false, EventDebugUtils.DEBUG_UPLOAD_CACHE_TIME_OUT);
                afterUpload();
            }
            return true;
        } else {
            LDebug.d("-----------------server busy handleMessage---------------- ");
            sendServerBusyOrRoutineErrorRetryMessage();
        }
        return true;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.core.thread.ILogThreadCenter
    public void notifyRunOnce(int i4) {
        try {
            boolean checkEvent = checkEvent(i4, LogThreadCenter.instance.isServerBusy);
            LDebug.w("notify flush : " + checkEvent + " " + i4);
            if (i4 == 6 || checkEvent) {
                ThreadMessage threadMessage = new ThreadMessage();
                threadMessage.setMessage(i4);
                this.mPriorityBlockingQueue.add(threadMessage);
                ensureLoopConditionTrue(3);
            }
        } catch (Throwable th) {
            LDebug.e(th.getMessage());
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.mHandler = new Handler(getLooper(), this);
        LogThreadCenter.instance.setLogHandler(this.mHandler);
        this.mHandler.sendEmptyMessage(1);
        LDebug.d("onLooperPrepared");
    }

    public void sendThreadHandlerMessage(int i4, long j4) {
        if (this.mHandler == null) {
            LDebug.e("mHandler == null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i4;
        if (i4 == 2) {
            int incrementAndGet = this.mServerBusyRetry.incrementAndGet();
            long j5 = (((incrementAndGet - 1) % 4) + 1) * j4;
            LDebug.d("sendMonitorMessage:" + i4 + "  busy:" + incrementAndGet + "  l:" + j5);
            this.mHandler.sendMessageDelayed(obtain, j5);
        } else if (i4 == 3) {
            int incrementAndGet2 = this.mRoutineRetry.incrementAndGet();
            LDebug.d("sendMonitorMessage:" + i4 + "  error:" + incrementAndGet2);
            this.mHandler.sendMessageDelayed(obtain, ((long) (((incrementAndGet2 + (-1)) % 4) + 1)) * j4);
        } else {
            LDebug.e("sendMonitorMessage error state");
        }
    }

    public void setRun(boolean z3) {
        this.mIsRun = z3;
    }
}
