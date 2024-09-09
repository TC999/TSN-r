package io.netty.util.concurrent;

import com.bykv.vk.component.ttvideo.player.C;
import io.netty.channel.a;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private final EventExecutor executor;
    private Object listeners;
    private boolean notifyingListeners;
    private volatile Object result;
    private short waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName() + ".rejectedExecution");
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class CauseHolder {
        final Throwable cause;

        CauseHolder(Throwable th) {
            this.cause = th;
        }
    }

    public DefaultPromise(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj == null) {
            this.listeners = genericFutureListener;
        } else if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).add(genericFutureListener);
        } else {
            this.listeners = new DefaultFutureListeners((GenericFutureListener) obj, genericFutureListener);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:? -> B:55:0x0091). Please submit an issue!!! */
    private boolean await0(long j4, boolean z3) throws InterruptedException {
        boolean z4 = true;
        if (isDone()) {
            return true;
        }
        if (j4 <= 0) {
            return isDone();
        }
        if (z3 && Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        long nanoTime = System.nanoTime();
        boolean z5 = false;
        long j5 = j4;
        do {
            try {
                synchronized (this) {
                    try {
                        if (isDone()) {
                            if (z5) {
                                Thread.currentThread().interrupt();
                            }
                            return true;
                        }
                        incWaiters();
                        try {
                            wait(j5 / C.MICROS_PER_SECOND, (int) (j5 % C.MICROS_PER_SECOND));
                            decWaiters();
                        } catch (InterruptedException e4) {
                            if (z3) {
                                throw e4;
                            }
                            try {
                                decWaiters();
                                z5 = true;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z5 = z4;
                                    if (z5) {
                                        Thread.currentThread().interrupt();
                                    }
                                    throw th;
                                }
                            }
                        }
                        if (isDone()) {
                            if (z5) {
                                Thread.currentThread().interrupt();
                            }
                            return true;
                        }
                        j5 = j4 - (System.nanoTime() - nanoTime);
                    } catch (Throwable th3) {
                        th = th3;
                        z4 = z5;
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } while (j5 > 0);
        boolean isDone = isDone();
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return isDone;
    }

    private synchronized boolean checkNotifyWaiters() {
        if (this.waiters > 0) {
            notifyAll();
        }
        return this.listeners != null;
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void incWaiters() {
        short s3 = this.waiters;
        if (s3 != Short.MAX_VALUE) {
            this.waiters = (short) (s3 + 1);
            return;
        }
        throw new IllegalStateException("too many waiters: " + this);
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> genericFutureListener) {
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        ObjectUtil.checkNotNull(future, "future");
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        notifyListenerWithStackOverFlowProtection(eventExecutor, future, genericFutureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                InternalLogger internalLogger = logger;
                internalLogger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th);
            }
        }
    }

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor eventExecutor, final Future<?> future, final GenericFutureListener<?> genericFutureListener) {
        InternalThreadLocalMap internalThreadLocalMap;
        int futureListenerStackDepth;
        if (eventExecutor.inEventLoop() && (futureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < MAX_LISTENER_STACK_DEPTH) {
            internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth + 1);
            try {
                notifyListener0(future, genericFutureListener);
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth);
            }
        }
        safeExecute(eventExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.2
            @Override // java.lang.Runnable
            public void run() {
                DefaultPromise.notifyListener0(Future.this, genericFutureListener);
            }
        });
    }

    private void notifyListeners() {
        InternalThreadLocalMap internalThreadLocalMap;
        int futureListenerStackDepth;
        EventExecutor executor = executor();
        if (executor.inEventLoop() && (futureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < MAX_LISTENER_STACK_DEPTH) {
            internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth + 1);
            try {
                notifyListenersNow();
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth);
            }
        }
        safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultPromise.this.notifyListenersNow();
            }
        });
    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener<? extends Future<?>>[] listeners = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i4 = 0; i4 < size; i4++) {
            notifyListener0(this, listeners[i4]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersNow() {
        Object obj;
        synchronized (this) {
            if (!this.notifyingListeners && (obj = this.listeners) != null) {
                this.notifyingListeners = true;
                this.listeners = null;
                while (true) {
                    if (obj instanceof DefaultFutureListeners) {
                        notifyListeners0((DefaultFutureListeners) obj);
                    } else {
                        notifyListener0(this, (GenericFutureListener) obj);
                    }
                    synchronized (this) {
                        obj = this.listeners;
                        if (obj == null) {
                            this.notifyingListeners = false;
                            return;
                        }
                        this.listeners = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture, GenericProgressiveFutureListener genericProgressiveFutureListener, long j4, long j5) {
        try {
            genericProgressiveFutureListener.operationProgressed(progressiveFuture, j4, j5);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                InternalLogger internalLogger = logger;
                internalLogger.warn("An exception was thrown by " + genericProgressiveFutureListener.getClass().getName() + ".operationProgressed()", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> progressiveFuture, GenericProgressiveFutureListener<?>[] genericProgressiveFutureListenerArr, long j4, long j5) {
        for (GenericProgressiveFutureListener<?> genericProgressiveFutureListener : genericProgressiveFutureListenerArr) {
            if (genericProgressiveFutureListener == null) {
                return;
            }
            notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j4, j5);
        }
    }

    private synchronized Object progressiveListeners() {
        Object obj = this.listeners;
        if (obj == null) {
            return null;
        }
        if (obj instanceof DefaultFutureListeners) {
            DefaultFutureListeners defaultFutureListeners = (DefaultFutureListeners) obj;
            int progressiveSize = defaultFutureListeners.progressiveSize();
            if (progressiveSize != 0) {
                int i4 = 0;
                if (progressiveSize != 1) {
                    GenericFutureListener<? extends Future<?>>[] listeners = defaultFutureListeners.listeners();
                    GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = new GenericProgressiveFutureListener[progressiveSize];
                    int i5 = 0;
                    while (i4 < progressiveSize) {
                        GenericFutureListener<? extends Future<?>> genericFutureListener = listeners[i5];
                        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                            int i6 = i4 + 1;
                            genericProgressiveFutureListenerArr[i4] = (GenericProgressiveFutureListener) genericFutureListener;
                            i4 = i6;
                        }
                        i5++;
                    }
                    return genericProgressiveFutureListenerArr;
                }
                GenericFutureListener<? extends Future<?>>[] listeners2 = defaultFutureListeners.listeners();
                int length = listeners2.length;
                while (i4 < length) {
                    GenericFutureListener<? extends Future<?>> genericFutureListener2 = listeners2[i4];
                    if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                        return genericFutureListener2;
                    }
                    i4++;
                }
                return null;
            }
            return null;
        } else if (obj instanceof GenericProgressiveFutureListener) {
            return obj;
        } else {
            return null;
        }
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).remove(genericFutureListener);
        } else if (obj == genericFutureListener) {
            this.listeners = null;
        }
    }

    private void rethrowIfFailed() {
        Throwable cause = cause();
        if (cause == null) {
            return;
        }
        PlatformDependent.throwException(cause);
    }

    private static void safeExecute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }

    private boolean setFailure0(Throwable th) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(th, "cause")));
    }

    private boolean setSuccess0(V v3) {
        if (v3 == null) {
            v3 = (V) SUCCESS;
        }
        return setValue0(v3);
    }

    private boolean setValue0(Object obj) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (a.a(atomicReferenceFieldUpdater, this, null, obj) || a.a(atomicReferenceFieldUpdater, this, UNCANCELLABLE, obj)) {
            if (checkNotifyWaiters()) {
                notifyListeners();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z3) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (atomicReferenceFieldUpdater.get(this) == null && a.a(atomicReferenceFieldUpdater, this, null, new CauseHolder(new CancellationException()))) {
            if (checkNotifyWaiters()) {
                notifyListeners();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        Object obj = this.result;
        if (obj instanceof CauseHolder) {
            return ((CauseHolder) obj).cause;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkDeadLock() {
        EventExecutor executor = executor();
        if (executor != null && executor.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        V v3 = (V) this.result;
        if ((v3 instanceof CauseHolder) || v3 == SUCCESS || v3 == UNCANCELLABLE) {
            return null;
        }
        return v3;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyProgressiveListeners(final long j4, final long j5) {
        Object progressiveListeners = progressiveListeners();
        if (progressiveListeners == null) {
            return;
        }
        final ProgressiveFuture progressiveFuture = (ProgressiveFuture) this;
        EventExecutor executor = executor();
        if (executor.inEventLoop()) {
            if (progressiveListeners instanceof GenericProgressiveFutureListener[]) {
                notifyProgressiveListeners0(progressiveFuture, (GenericProgressiveFutureListener[]) progressiveListeners, j4, j5);
            } else {
                notifyProgressiveListener0(progressiveFuture, (GenericProgressiveFutureListener) progressiveListeners, j4, j5);
            }
        } else if (progressiveListeners instanceof GenericProgressiveFutureListener[]) {
            final GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = (GenericProgressiveFutureListener[]) progressiveListeners;
            safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.3
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListeners0(progressiveFuture, genericProgressiveFutureListenerArr, j4, j5);
                }
            });
        } else {
            final GenericProgressiveFutureListener genericProgressiveFutureListener = (GenericProgressiveFutureListener) progressiveListeners;
            safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j4, j5);
                }
            });
        }
    }

    public Promise<V> setFailure(Throwable th) {
        if (setFailure0(th)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public Promise<V> setSuccess(V v3) {
        if (setSuccess0(v3)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        if (a.a(RESULT_UPDATER, this, null, UNCANCELLABLE)) {
            return true;
        }
        Object obj = this.result;
        return (isDone0(obj) && isCancelled0(obj)) ? false : true;
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('@');
        sb.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb.append("(success)");
        } else if (obj == UNCANCELLABLE) {
            sb.append("(uncancellable)");
        } else if (obj instanceof CauseHolder) {
            sb.append("(failure: ");
            sb.append(((CauseHolder) obj).cause);
            sb.append(')');
        } else if (obj != null) {
            sb.append("(success: ");
            sb.append(obj);
            sb.append(')');
        } else {
            sb.append("(incomplete)");
        }
        return sb;
    }

    public boolean tryFailure(Throwable th) {
        return setFailure0(th);
    }

    public boolean trySuccess(V v3) {
        return setSuccess0(v3);
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            addListener0(genericFutureListener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                if (genericFutureListener == null) {
                    break;
                }
                addListener0(genericFutureListener);
            }
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> await() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (!Thread.interrupted()) {
            checkDeadLock();
            synchronized (this) {
                while (!isDone()) {
                    incWaiters();
                    wait();
                    decWaiters();
                }
            }
            return this;
        }
        throw new InterruptedException(toString());
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> awaitUninterruptibly() {
        if (isDone()) {
            return this;
        }
        checkDeadLock();
        boolean z3 = false;
        synchronized (this) {
            while (!isDone()) {
                incWaiters();
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                } catch (Throwable th) {
                    decWaiters();
                    throw th;
                }
                decWaiters();
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            removeListener0(genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                if (genericFutureListener == null) {
                    break;
                }
                removeListener0(genericFutureListener);
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> sync() throws InterruptedException {
        await();
        rethrowIfFailed();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> syncUninterruptibly() {
        awaitUninterruptibly();
        rethrowIfFailed();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultPromise() {
        this.executor = null;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j4, TimeUnit timeUnit) throws InterruptedException {
        return await0(timeUnit.toNanos(j4), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j4, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j4), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j4) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(j4), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j4) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j4), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
