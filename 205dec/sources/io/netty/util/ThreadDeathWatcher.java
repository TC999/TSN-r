package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ThreadDeathWatcher {
    static final ThreadFactory threadFactory;
    private static volatile Thread watcherThread;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadDeathWatcher.class);
    private static final Queue<Entry> pendingEntries = new ConcurrentLinkedQueue();
    private static final Watcher watcher = new Watcher();
    private static final AtomicBoolean started = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Entry {
        final boolean isWatch;
        final Runnable task;
        final Thread thread;

        Entry(Thread thread, Runnable runnable, boolean z3) {
            this.thread = thread;
            this.task = runnable;
            this.isWatch = z3;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                return this.thread == entry.thread && this.task == entry.task;
            }
            return false;
        }

        public int hashCode() {
            return this.thread.hashCode() ^ this.task.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Watcher implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Entry> watchees;

        private Watcher() {
            this.watchees = new ArrayList();
        }

        private void fetchWatchees() {
            while (true) {
                Entry entry = (Entry) ThreadDeathWatcher.pendingEntries.poll();
                if (entry == null) {
                    return;
                }
                if (entry.isWatch) {
                    this.watchees.add(entry);
                } else {
                    this.watchees.remove(entry);
                }
            }
        }

        private void notifyWatchees() {
            List<Entry> list = this.watchees;
            int i4 = 0;
            while (i4 < list.size()) {
                Entry entry = list.get(i4);
                if (entry.thread.isAlive()) {
                    i4++;
                } else {
                    list.remove(i4);
                    try {
                        entry.task.run();
                    } catch (Throwable th) {
                        ThreadDeathWatcher.logger.warn("Thread death watcher task raised an exception:", th);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                fetchWatchees();
                notifyWatchees();
                fetchWatchees();
                notifyWatchees();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                if (this.watchees.isEmpty() && ThreadDeathWatcher.pendingEntries.isEmpty()) {
                    ThreadDeathWatcher.started.compareAndSet(true, false);
                    if (ThreadDeathWatcher.pendingEntries.isEmpty() || !ThreadDeathWatcher.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    static {
        String str = SystemPropertyUtil.get("io.netty.serviceThreadPrefix");
        String str2 = "threadDeathWatcher";
        if (!StringUtil.isNullOrEmpty(str)) {
            str2 = str + "threadDeathWatcher";
        }
        threadFactory = new DefaultThreadFactory(str2, true, 1, null);
    }

    private ThreadDeathWatcher() {
    }

    public static boolean awaitInactivity(long j4, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit != null) {
            Thread thread = watcherThread;
            if (thread != null) {
                thread.join(timeUnit.toMillis(j4));
                return !thread.isAlive();
            }
            return true;
        }
        throw new NullPointerException("unit");
    }

    private static void schedule(Thread thread, Runnable runnable, boolean z3) {
        pendingEntries.add(new Entry(thread, runnable, z3));
        if (started.compareAndSet(false, true)) {
            final Thread newThread = threadFactory.newThread(watcher);
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.util.ThreadDeathWatcher.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    newThread.setContextClassLoader(null);
                    return null;
                }
            });
            newThread.start();
            watcherThread = newThread;
        }
    }

    public static void unwatch(Thread thread, Runnable runnable) {
        if (thread == null) {
            throw new NullPointerException("thread");
        }
        if (runnable != null) {
            schedule(thread, runnable, false);
            return;
        }
        throw new NullPointerException("task");
    }

    public static void watch(Thread thread, Runnable runnable) {
        if (thread == null) {
            throw new NullPointerException("thread");
        }
        if (runnable != null) {
            if (thread.isAlive()) {
                schedule(thread, runnable, true);
                return;
            }
            throw new IllegalArgumentException("thread must be alive.");
        }
        throw new NullPointerException("task");
    }
}
