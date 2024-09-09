package io.netty.channel.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final Callable<Integer> pendingTasksCallable;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    Selector selector;
    private final AtomicBoolean wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioEventLoop.class);
    private static final boolean DISABLE_KEYSET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    static {
        if (SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.3
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e4) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e4);
            }
        }
        int i4 = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        int i5 = i4 >= 3 ? i4 : 0;
        SELECTOR_AUTO_REBUILD_THRESHOLD = i5;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEYSET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler) {
        super((EventLoopGroup) nioEventLoopGroup, executor, false, SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS, rejectedExecutionHandler);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() throws Exception {
                return NioEventLoop.this.selectNow();
            }
        };
        this.pendingTasksCallable = new Callable<Integer>() { // from class: io.netty.channel.nio.NioEventLoop.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                return Integer.valueOf(NioEventLoop.super.pendingTasks());
            }
        };
        this.wakenUp = new AtomicBoolean();
        this.ioRatio = 50;
        if (selectorProvider == null) {
            throw new NullPointerException("selectorProvider");
        }
        if (selectStrategy != null) {
            this.provider = selectorProvider;
            this.selector = openSelector();
            this.selectStrategy = selectStrategy;
            return;
        }
        throw new NullPointerException("selectStrategy");
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> keys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(keys.size());
        for (SelectionKey selectionKey : keys) {
            Object attachment = selectionKey.attachment();
            if (attachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) attachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) attachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e4) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e4);
        }
    }

    private Selector openSelector() {
        try {
            final AbstractSelector openSelector = this.provider.openSelector();
            if (DISABLE_KEYSET_OPTIMIZATION) {
                return openSelector;
            }
            final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
            Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (ClassNotFoundException e4) {
                        return e4;
                    } catch (SecurityException e5) {
                        return e5;
                    }
                }
            });
            if (doPrivileged instanceof Class) {
                final Class cls = (Class) doPrivileged;
                if (cls.isAssignableFrom(openSelector.getClass())) {
                    Object doPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.5
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                declaredField.setAccessible(true);
                                declaredField2.setAccessible(true);
                                declaredField.set(openSelector, selectedSelectionKeySet);
                                declaredField2.set(openSelector, selectedSelectionKeySet);
                                return null;
                            } catch (IllegalAccessException e4) {
                                return e4;
                            } catch (NoSuchFieldException e5) {
                                return e5;
                            }
                        }
                    });
                    if (doPrivileged2 instanceof Exception) {
                        this.selectedKeys = null;
                        logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Exception) doPrivileged2);
                    } else {
                        this.selectedKeys = selectedSelectionKeySet;
                        logger.trace("instrumented a special java.util.Set into: {}", openSelector);
                    }
                    return openSelector;
                }
            }
            if (doPrivileged instanceof Exception) {
                logger.trace("failed to instrument a special java.util.Set into: {}", openSelector, (Exception) doPrivileged);
            }
            return openSelector;
        } catch (IOException e4) {
            throw new ChannelException("failed to open a new selector", e4);
        }
    }

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe unsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                NioEventLoop eventLoop = abstractNioChannel.eventLoop();
                if (eventLoop != this || eventLoop == null) {
                    return;
                }
                unsafe.close(unsafe.voidPromise());
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            int readyOps = selectionKey.readyOps();
            if ((readyOps & 17) != 0 || readyOps == 0) {
                unsafe.read();
                if (!abstractNioChannel.isOpen()) {
                    return;
                }
            }
            if ((readyOps & 4) != 0) {
                abstractNioChannel.unsafe().forceFlush();
            }
            if ((readyOps & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                unsafe.finishConnect();
            }
        } catch (CancelledKeyException unused2) {
            unsafe.close(unsafe.voidPromise());
        }
    }

    private void processSelectedKeys() {
        SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
        if (selectedSelectionKeySet != null) {
            processSelectedKeysOptimized(selectedSelectionKeySet.flip());
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    private void processSelectedKeysOptimized(SelectionKey[] selectionKeyArr) {
        int i4 = 0;
        while (true) {
            SelectionKey selectionKey = selectionKeyArr[i4];
            if (selectionKey == null) {
                return;
            }
            selectionKeyArr[i4] = null;
            Object attachment = selectionKey.attachment();
            if (attachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) attachment);
            } else {
                processSelectedKey(selectionKey, (NioTask) attachment);
            }
            if (this.needsToSelectAgain) {
                while (true) {
                    i4++;
                    if (selectionKeyArr[i4] == null) {
                        break;
                    }
                    selectionKeyArr[i4] = null;
                }
                selectAgain();
                selectionKeyArr = this.selectedKeys.flip();
                i4 = -1;
            }
            i4++;
        }
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator<SelectionKey> it = set.iterator();
        while (true) {
            SelectionKey next = it.next();
            Object attachment = next.attachment();
            it.remove();
            if (attachment instanceof AbstractNioChannel) {
                processSelectedKey(next, (AbstractNioChannel) attachment);
            } else {
                processSelectedKey(next, (NioTask) attachment);
            }
            if (!it.hasNext()) {
                return;
            }
            if (this.needsToSelectAgain) {
                selectAgain();
                Set<SelectionKey> selectedKeys = this.selector.selectedKeys();
                if (selectedKeys.isEmpty()) {
                    return;
                }
                it = selectedKeys.iterator();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        r6 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void select(boolean r14) throws java.io.IOException {
        /*
            r13 = this;
            java.nio.channels.Selector r0 = r13.selector
            long r1 = java.lang.System.nanoTime()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r3 = r13.delayNanos(r1)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r3 = r3 + r1
            r5 = 0
            r6 = 0
        Ld:
            long r7 = r3 - r1
            r9 = 500000(0x7a120, double:2.47033E-318)
            long r7 = r7 + r9
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r7 / r9
            r9 = 0
            r11 = 1
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 > 0) goto L26
            if (r6 != 0) goto L9a
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
        L23:
            r6 = 1
            goto L9a
        L26:
            boolean r9 = r13.hasTasks()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L38
            java.util.concurrent.atomic.AtomicBoolean r9 = r13.wakenUp     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r9 = r9.compareAndSet(r5, r11)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L38
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto L23
        L38:
            int r9 = r0.select(r7)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            int r6 = r6 + 1
            if (r9 != 0) goto L9a
            if (r14 != 0) goto L9a
            java.util.concurrent.atomic.AtomicBoolean r9 = r13.wakenUp     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r9 = r9.get()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 != 0) goto L9a
            boolean r9 = r13.hasTasks()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 != 0) goto L9a
            boolean r9 = r13.hasScheduledTasks()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L57
            goto L9a
        L57:
            boolean r9 = java.lang.Thread.interrupted()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r9 == 0) goto L6b
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r1 = r14.isDebugEnabled()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r1 == 0) goto L23
            java.lang.String r1 = "Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop."
            r14.debug(r1)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto L23
        L6b:
            long r9 = java.lang.System.nanoTime()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r7 = r12.toNanos(r7)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            long r7 = r9 - r7
            int r12 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r12 < 0) goto L7d
            r6 = 1
            goto L97
        L7d:
            int r1 = io.netty.channel.nio.NioEventLoop.SELECTOR_AUTO_REBUILD_THRESHOLD     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r1 <= 0) goto L97
            if (r6 < r1) goto L97
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            java.lang.String r1 = "Selector.select() returned prematurely {} times in a row; rebuilding Selector {}."
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r14.warn(r1, r2, r0)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r13.rebuildSelector()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            java.nio.channels.Selector r0 = r13.selector     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r0.selectNow()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto L23
        L97:
            r1 = r9
            goto Ld
        L9a:
            r14 = 3
            if (r6 <= r14) goto Ld3
            io.netty.util.internal.logging.InternalLogger r14 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            boolean r1 = r14.isDebugEnabled()     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            if (r1 == 0) goto Ld3
            java.lang.String r1 = "Selector.select() returned prematurely {} times in a row for Selector {}."
            int r6 = r6 - r11
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            r14.debug(r1, r2, r0)     // Catch: java.nio.channels.CancelledKeyException -> Lb0
            goto Ld3
        Lb0:
            r14 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            boolean r2 = r1.isDebugEnabled()
            if (r2 == 0) goto Ld3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class<java.nio.channels.CancelledKeyException> r3 = java.nio.channels.CancelledKeyException.class
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r3 = " raised by a Selector {} - JDK bug?"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.debug(r2, r0, r14)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.select(boolean):void");
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i4 = this.cancelledKeys + 1;
        this.cancelledKeys = i4;
        if (i4 >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e4) {
            logger.warn("Failed to close a selector.", (Throwable) e4);
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i4) {
        return PlatformDependent.newMpscQueue(i4);
    }

    @Override // io.netty.channel.SingleThreadEventLoop, io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        if (inEventLoop()) {
            return super.pendingTasks();
        }
        return ((Integer) submit((Callable) this.pendingTasksCallable).syncUninterruptibly().getNow()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Runnable pollTask() {
        Runnable pollTask = super.pollTask();
        if (this.needsToSelectAgain) {
            selectAgain();
        }
        return pollTask;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void rebuildSelector() {
        /*
            r9 = this;
            boolean r0 = r9.inEventLoop()
            if (r0 != 0) goto Lf
            io.netty.channel.nio.NioEventLoop$6 r0 = new io.netty.channel.nio.NioEventLoop$6
            r0.<init>()
            r9.execute(r0)
            return
        Lf:
            java.nio.channels.Selector r0 = r9.selector
            if (r0 != 0) goto L14
            return
        L14:
            java.nio.channels.Selector r1 = r9.openSelector()     // Catch: java.lang.Exception -> Lb3
            r2 = 0
        L19:
            java.util.Set r3 = r0.keys()     // Catch: java.util.ConcurrentModificationException -> L19
            java.util.Iterator r3 = r3.iterator()     // Catch: java.util.ConcurrentModificationException -> L19
        L21:
            boolean r4 = r3.hasNext()     // Catch: java.util.ConcurrentModificationException -> L19
            if (r4 == 0) goto L81
            java.lang.Object r4 = r3.next()     // Catch: java.util.ConcurrentModificationException -> L19
            java.nio.channels.SelectionKey r4 = (java.nio.channels.SelectionKey) r4     // Catch: java.util.ConcurrentModificationException -> L19
            java.lang.Object r5 = r4.attachment()     // Catch: java.util.ConcurrentModificationException -> L19
            boolean r6 = r4.isValid()     // Catch: java.lang.Exception -> L5d
            if (r6 == 0) goto L21
            java.nio.channels.SelectableChannel r6 = r4.channel()     // Catch: java.lang.Exception -> L5d
            java.nio.channels.SelectionKey r6 = r6.keyFor(r1)     // Catch: java.lang.Exception -> L5d
            if (r6 == 0) goto L42
            goto L21
        L42:
            int r6 = r4.interestOps()     // Catch: java.lang.Exception -> L5d
            r4.cancel()     // Catch: java.lang.Exception -> L5d
            java.nio.channels.SelectableChannel r7 = r4.channel()     // Catch: java.lang.Exception -> L5d
            java.nio.channels.SelectionKey r6 = r7.register(r1, r6, r5)     // Catch: java.lang.Exception -> L5d
            boolean r7 = r5 instanceof io.netty.channel.nio.AbstractNioChannel     // Catch: java.lang.Exception -> L5d
            if (r7 == 0) goto L5a
            r7 = r5
            io.netty.channel.nio.AbstractNioChannel r7 = (io.netty.channel.nio.AbstractNioChannel) r7     // Catch: java.lang.Exception -> L5d
            r7.selectionKey = r6     // Catch: java.lang.Exception -> L5d
        L5a:
            int r2 = r2 + 1
            goto L21
        L5d:
            r6 = move-exception
            io.netty.util.internal.logging.InternalLogger r7 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.util.ConcurrentModificationException -> L19
            java.lang.String r8 = "Failed to re-register a Channel to the new Selector."
            r7.warn(r8, r6)     // Catch: java.util.ConcurrentModificationException -> L19
            boolean r7 = r5 instanceof io.netty.channel.nio.AbstractNioChannel     // Catch: java.util.ConcurrentModificationException -> L19
            if (r7 == 0) goto L7b
            io.netty.channel.nio.AbstractNioChannel r5 = (io.netty.channel.nio.AbstractNioChannel) r5     // Catch: java.util.ConcurrentModificationException -> L19
            io.netty.channel.nio.AbstractNioChannel$NioUnsafe r4 = r5.unsafe()     // Catch: java.util.ConcurrentModificationException -> L19
            io.netty.channel.nio.AbstractNioChannel$NioUnsafe r5 = r5.unsafe()     // Catch: java.util.ConcurrentModificationException -> L19
            io.netty.channel.ChannelPromise r5 = r5.voidPromise()     // Catch: java.util.ConcurrentModificationException -> L19
            r4.close(r5)     // Catch: java.util.ConcurrentModificationException -> L19
            goto L21
        L7b:
            io.netty.channel.nio.NioTask r5 = (io.netty.channel.nio.NioTask) r5     // Catch: java.util.ConcurrentModificationException -> L19
            invokeChannelUnregistered(r5, r4, r6)     // Catch: java.util.ConcurrentModificationException -> L19
            goto L21
        L81:
            r9.selector = r1
            r0.close()     // Catch: java.lang.Throwable -> L87
            goto L97
        L87:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L97
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            java.lang.String r3 = "Failed to close the old Selector."
            r1.warn(r3, r0)
        L97:
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.channel.nio.NioEventLoop.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Migrated "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = " channel(s) to the new Selector."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.info(r1)
            return
        Lb3:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            java.lang.String r2 = "Failed to create a new Selector."
            r1.warn(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.rebuildSelector():void");
    }

    public void register(SelectableChannel selectableChannel, int i4, NioTask<?> nioTask) {
        if (selectableChannel == null) {
            throw new NullPointerException("ch");
        }
        if (i4 != 0) {
            if (((selectableChannel.validOps() ^ (-1)) & i4) != 0) {
                throw new IllegalArgumentException("invalid interestOps: " + i4 + "(validOps: " + selectableChannel.validOps() + ')');
            } else if (nioTask != null) {
                if (!isShutdown()) {
                    try {
                        selectableChannel.register(this.selector, i4, nioTask);
                        return;
                    } catch (Exception e4) {
                        throw new EventLoopException("failed to register a channel", e4);
                    }
                }
                throw new IllegalStateException("event loop shut down");
            } else {
                throw new NullPointerException("task");
            }
        }
        throw new IllegalArgumentException("interestOps must be non-zero.");
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        while (true) {
            try {
                int calculateStrategy = this.selectStrategy.calculateStrategy(this.selectNowSupplier, hasTasks());
                if (calculateStrategy == -2) {
                    continue;
                } else {
                    if (calculateStrategy == -1) {
                        select(this.wakenUp.getAndSet(false));
                        if (this.wakenUp.get()) {
                            this.selector.wakeup();
                        }
                    }
                    this.cancelledKeys = 0;
                    this.needsToSelectAgain = false;
                    int i4 = this.ioRatio;
                    if (i4 == 100) {
                        processSelectedKeys();
                        runAllTasks();
                    } else {
                        long nanoTime = System.nanoTime();
                        processSelectedKeys();
                        runAllTasks(((System.nanoTime() - nanoTime) * (100 - i4)) / i4);
                    }
                    if (isShuttingDown()) {
                        closeAll();
                        if (confirmShutdown()) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            } catch (Throwable th) {
                logger.warn("Unexpected exception in the selector loop.", th);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int selectNow() throws IOException {
        try {
            return this.selector.selectNow();
        } finally {
            if (this.wakenUp.get()) {
                this.selector.wakeup();
            }
        }
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    public void setIoRatio(int i4) {
        if (i4 > 0 && i4 <= 100) {
            this.ioRatio = i4;
            return;
        }
        throw new IllegalArgumentException("ioRatio: " + i4 + " (expected: 0 < ioRatio <= 100)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z3) {
        if (z3 || !this.wakenUp.compareAndSet(false, true)) {
            return;
        }
        this.selector.wakeup();
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        SelectorTuple(Selector selector) {
            this.unwrappedSelector = selector;
            this.selector = selector;
        }

        SelectorTuple(Selector selector, Selector selector2) {
            this.unwrappedSelector = selector;
            this.selector = selector2;
        }
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (selectionKey.isValid()) {
                    return;
                }
                invokeChannelUnregistered(nioTask, selectionKey, null);
            } catch (Exception e4) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e4);
            }
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th;
        }
    }
}
