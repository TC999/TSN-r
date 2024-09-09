package com.bytedance.sdk.component.gd;

import java.lang.Thread;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    public static final ux f29863c = new ux();
    private c sr;

    /* renamed from: w  reason: collision with root package name */
    private final List<SoftReference<ThreadPoolExecutor>> f29864w = new ArrayList();
    private w xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Map<String, Integer> map, Map<String, Integer> map2, int i4, int i5, String str);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(int i4, int i5, Map<String, Integer> map);
    }

    private ux() {
        w().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.ux.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.a.w("PThreadThreadPoolCache", "init workPool success");
            }
        }, 1L, TimeUnit.MINUTES);
    }

    private ScheduledExecutorService w() {
        return a.f29806w.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        List<ThreadPoolExecutor> c4 = c(null, false, false);
        if (c4 == null || c4.size() == 0) {
            return;
        }
        int c5 = this.xv != null ? f.c() : 0;
        HashMap hashMap = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : c4) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof k) {
                    hashMap.put(((k) threadFactory).f29843c + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.gd.c.sr) {
                    hashMap.put(((com.bytedance.sdk.component.gd.c.sr) threadFactory).c() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    hashMap.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                c(threadPoolExecutor);
            }
        }
        if (this.xv != null) {
            this.xv.c(c5, f.c(), hashMap);
        }
    }

    public synchronized void c(com.bytedance.sdk.component.gd.sr.sr srVar) {
        w(srVar);
        this.f29864w.add(new SoftReference<>(srVar));
    }

    public synchronized void w(com.bytedance.sdk.component.gd.sr.sr srVar) {
        Iterator<SoftReference<ThreadPoolExecutor>> it = this.f29864w.iterator();
        while (it.hasNext()) {
            if (it.next().get() == srVar) {
                it.remove();
            }
        }
    }

    public String c(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.gd.c.c) {
            return ((com.bytedance.sdk.component.gd.c.c) blockingQueue).c();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor c(String str, String str2) {
        List<ThreadPoolExecutor> c4 = c(str2, false, true);
        c(c4, str);
        ThreadPoolExecutor threadPoolExecutor = c4.size() > 0 ? c4.get(0) : null;
        com.bytedance.sdk.component.utils.a.w("PThreadThreadPoolCache", "findFreeExecutor queueClass=" + str2 + ", findWitch=" + threadPoolExecutor);
        c();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> c(String str, boolean z3, boolean z4) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z5;
        com.bytedance.sdk.component.utils.a.w("PThreadThreadPoolCache", "getHasFreePoolList queueClass=" + str + ", onlyFirst=" + z3 + ", needSort=" + z4);
        arrayList = new ArrayList();
        for (SoftReference<ThreadPoolExecutor> softReference : this.f29864w) {
            if (softReference != null && (threadPoolExecutor = softReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.bytedance.sdk.component.gd.c.c) {
                    z5 = ((com.bytedance.sdk.component.gd.c.c) queue).w() instanceof PriorityBlockingQueue;
                } else {
                    z5 = queue instanceof PriorityBlockingQueue;
                }
                if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z5)) {
                    if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                        arrayList.add(threadPoolExecutor);
                        if (z3) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z4 && !z3) {
            try {
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.gd.ux.1
                    @Override // java.util.Comparator
                    /* renamed from: c */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        com.bytedance.sdk.component.utils.a.w("PThreadThreadPoolCache", "tempList=" + arrayList.size() + ", mCache=" + this.f29864w.size());
        return arrayList;
    }

    public void c() {
        if (a.f29806w.c()) {
            w().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.ux.2
                @Override // java.lang.Runnable
                public void run() {
                    ux.this.xv();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    private void c(final ThreadPoolExecutor threadPoolExecutor) {
        com.bytedance.sdk.component.utils.a.w("PThreadThreadPoolCache", "trimThreadPool pThreadPoolExecutor=" + threadPoolExecutor);
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(timeUnit);
        final boolean allowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, timeUnit);
        if (allowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } else {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        w().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.ux.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j4 = keepAliveTime;
                if (j4 == 0) {
                    j4 = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j4, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(allowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void c(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.sr == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof k) {
                    hashMap.put(((k) threadFactory).f29843c + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.gd.c.sr) {
                    hashMap.put(((com.bytedance.sdk.component.gd.c.sr) threadFactory).c() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    hashMap.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        ThreadGroup w3 = f.w();
        int activeCount = w3.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = w3.enumerate(threadArr);
        int i4 = 0;
        for (int i5 = 0; i5 < enumerate; i5++) {
            Thread thread = threadArr[i5];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                i4++;
                String replaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) hashMap2.get(replaceAll);
                hashMap2.put(replaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
        c cVar = this.sr;
        if (cVar != null) {
            cVar.c(hashMap, hashMap2, enumerate, i4, str);
        }
    }

    public void c(String str) {
        List<ThreadPoolExecutor> c4 = c(null, false, true);
        if (c4 == null || c4.size() == 0) {
            return;
        }
        c(c4, str);
        com.bytedance.sdk.component.utils.a.w("PThreadThreadPoolCache", "trimFirstEmptyPool freePools=" + c4.size());
        ThreadPoolExecutor threadPoolExecutor = c4.get(0);
        if (threadPoolExecutor != null) {
            c(threadPoolExecutor);
        }
        c();
    }
}
