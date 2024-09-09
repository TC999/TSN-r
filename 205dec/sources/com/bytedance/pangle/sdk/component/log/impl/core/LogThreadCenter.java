package com.bytedance.pangle.sdk.component.log.impl.core;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.core.thread.AdPriorityLogThread;
import com.bytedance.pangle.sdk.component.log.impl.debug.EventMonitorUtils;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.net.TTRunnable;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LogThreadCenter {
    private final Comparator<AdLogEventFace> comparator;
    private volatile AdPriorityLogThread mAdLogThread;
    private volatile Handler mHandler;
    private final PriorityBlockingQueue<AdLogEventFace> mQueue;
    public static final LogThreadCenter instance = new LogThreadCenter();
    public static final EventMonitor sEventMonitor = new EventMonitor();
    public static final AtomicLong mAppLogEventIndex = new AtomicLong(0);
    public static final AtomicLong mAppLogEventValidIndex = new AtomicLong(0);
    public static final long START_TIME = System.currentTimeMillis();
    public static long FIRST_EVENT_TIME = 0;
    public volatile boolean isServerBusy = false;
    public volatile boolean isRoutineError = false;

    private LogThreadCenter() {
        Comparator<AdLogEventFace> comparator = new Comparator<AdLogEventFace>() { // from class: com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter.1
            @Override // java.util.Comparator
            public int compare(AdLogEventFace adLogEventFace, AdLogEventFace adLogEventFace2) {
                return LogThreadCenter.this.compareEventPriority(adLogEventFace, adLogEventFace2);
            }
        };
        this.comparator = comparator;
        this.mQueue = new PriorityBlockingQueue<>(8, comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int compareEventPriority(AdLogEventFace adLogEventFace, AdLogEventFace adLogEventFace2) {
        long j4;
        long j5;
        long j6;
        long j7;
        if (adLogEventFace == null) {
            return adLogEventFace2 == null ? 0 : -1;
        } else if (adLogEventFace2 == null) {
            return 1;
        } else {
            if (adLogEventFace.getPriority() == adLogEventFace2.getPriority()) {
                if (adLogEventFace.getDelayAdEvent() != null) {
                    j4 = adLogEventFace.getDelayAdEvent().getNewCreateTime();
                    j5 = adLogEventFace.getDelayAdEvent().getGlobalEventIndex();
                } else {
                    j4 = 0;
                    j5 = 0;
                }
                if (adLogEventFace2.getDelayAdEvent() != null) {
                    j7 = adLogEventFace2.getDelayAdEvent().getNewCreateTime();
                    j6 = adLogEventFace2.getDelayAdEvent().getGlobalEventIndex();
                } else {
                    j6 = 0;
                    j7 = 0;
                }
                if (j4 == 0 || j7 == 0) {
                    return 0;
                }
                long j8 = j4 - j7;
                if (Math.abs(j8) > 2147483647L) {
                    return 0;
                }
                if (j8 == 0) {
                    if (j5 == 0 || j6 == 0) {
                        return 0;
                    }
                    return (int) (j5 - j6);
                }
                return (int) j8;
            }
            return adLogEventFace.getPriority() - adLogEventFace2.getPriority();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReportMonitor(IAdLogDepend iAdLogDepend, long j4) {
        AdPriorityLogThread adPriorityLogThread = this.mAdLogThread;
        if (iAdLogDepend == null || adPriorityLogThread == null) {
            return;
        }
        EventMonitor eventMonitor = sEventMonitor;
        adPriorityLogThread.dispatchEvent(iAdLogDepend.compositeMonitorStates(eventMonitor.createEventMonitorJson(j4)), true);
        eventMonitor.resetEventMonitor();
    }

    private void reportMonitor(final IAdLogDepend iAdLogDepend, AdLogEventFace adLogEventFace) {
        if (iAdLogDepend != null) {
            try {
                if (iAdLogDepend.isOpenMonitor()) {
                    long j4 = 0;
                    if (adLogEventFace != null && adLogEventFace.getDelayAdEvent() != null) {
                        j4 = adLogEventFace.getDelayAdEvent().getGlobalEventIndex();
                    }
                    final long j5 = j4;
                    if (j5 == 1) {
                        FIRST_EVENT_TIME = System.currentTimeMillis();
                    }
                    AtomicLong will_save_count = sEventMonitor.getWill_save_count();
                    EventMonitorUtils.add(will_save_count, 1);
                    if (will_save_count.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor providerLogExecutor = iAdLogDepend.providerLogExecutor();
                            if (providerLogExecutor == null) {
                                providerLogExecutor = iAdLogDepend.providerIOExecutor();
                            }
                            if (providerLogExecutor != null) {
                                providerLogExecutor.execute(new TTRunnable("report") { // from class: com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LogThreadCenter.this.doReportMonitor(iAdLogDepend, j5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        LDebug.d("==> monitor upload index1:" + j5);
                        doReportMonitor(iAdLogDepend, j5);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public synchronized boolean createLogThreadIfNeed() {
        try {
            if (this.mAdLogThread != null && this.mAdLogThread.isAlive()) {
                LDebug.d("LogThread state:" + this.mAdLogThread.getState());
                return false;
            }
            LDebug.d("--start LogThread--");
            this.mAdLogThread = new AdPriorityLogThread(this.mQueue);
            this.mAdLogThread.start();
            return true;
        } catch (Throwable th) {
            LDebug.e(th.getMessage());
            return false;
        }
    }

    public void flushMemoryAndDB() {
        EventMonitorUtils.add(sEventMonitor.getInit_threadmessage(), 1);
        LDebug.w("flushMemoryAndDB()");
        final AdPriorityLogThread adPriorityLogThread = this.mAdLogThread;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (adPriorityLogThread != null) {
                adPriorityLogThread.notifyRunOnce(2);
                return;
            }
            return;
        }
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend != null) {
            Executor providerLogExecutor = adLogDepend.providerLogExecutor();
            if (providerLogExecutor == null) {
                providerLogExecutor = adLogDepend.providerIOExecutor();
            }
            if (providerLogExecutor != null) {
                providerLogExecutor.execute(new TTRunnable("flush") { // from class: com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPriorityLogThread adPriorityLogThread2 = adPriorityLogThread;
                        if (adPriorityLogThread2 != null) {
                            adPriorityLogThread2.notifyRunOnce(2);
                        }
                    }
                });
                return;
            }
            return;
        }
        LDebug.w("discard flush");
    }

    public AdPriorityLogThread getAdThread() {
        return this.mAdLogThread;
    }

    public PriorityBlockingQueue<AdLogEventFace> getQueue() {
        return this.mQueue;
    }

    public void report(AdLogEventFace adLogEventFace, int i4) {
        createLogThreadIfNeed();
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        AdPriorityLogThread adPriorityLogThread = this.mAdLogThread;
        if (adPriorityLogThread != null) {
            reportMonitor(adLogDepend, adLogEventFace);
            adPriorityLogThread.dispatchEvent(adLogEventFace, adLogEventFace.getPriority() == 4);
        }
    }

    public void setLogHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void start() {
        createLogThreadIfNeed();
        flushMemoryAndDB();
    }

    public synchronized void stopLogThread() {
        if (this.mAdLogThread != null && this.mAdLogThread.isAlive()) {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.mAdLogThread.setRun(false);
            if (Build.VERSION.SDK_INT >= 18) {
                this.mAdLogThread.quitSafely();
            } else {
                this.mAdLogThread.quit();
            }
            this.mAdLogThread = null;
        }
    }
}
