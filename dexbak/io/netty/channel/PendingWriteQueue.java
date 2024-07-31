package io.netty.channel;

import io.netty.channel.MessageSizeEstimator;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class PendingWriteQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PendingWriteQueue.class);
    private final ChannelOutboundBuffer buffer;
    private long bytes;
    private final ChannelHandlerContext ctx;
    private final MessageSizeEstimator.Handle estimatorHandle;
    private PendingWrite head;
    private int size;
    private PendingWrite tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class PendingWrite {
        private static final Recycler<PendingWrite> RECYCLER = new Recycler<PendingWrite>() { // from class: io.netty.channel.PendingWriteQueue.PendingWrite.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public PendingWrite newObject(Recycler.Handle<PendingWrite> handle) {
                return new PendingWrite(handle);
            }
        };
        private final Recycler.Handle<PendingWrite> handle;
        private Object msg;
        private PendingWrite next;
        private ChannelPromise promise;
        private long size;

        static PendingWrite newInstance(Object obj, int i, ChannelPromise channelPromise) {
            PendingWrite pendingWrite = RECYCLER.get();
            pendingWrite.size = i;
            pendingWrite.msg = obj;
            pendingWrite.promise = channelPromise;
            return pendingWrite;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle() {
            this.size = 0L;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        private PendingWrite(Recycler.Handle<PendingWrite> handle) {
            this.handle = handle;
        }
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext != null) {
            this.ctx = channelHandlerContext;
            this.buffer = channelHandlerContext.channel().unsafe().outboundBuffer();
            this.estimatorHandle = channelHandlerContext.channel().config().getMessageSizeEstimator().newHandle();
            return;
        }
        throw new NullPointerException("ctx");
    }

    private void assertEmpty() {
    }

    private void recycle(PendingWrite pendingWrite, boolean z) {
        PendingWrite pendingWrite2 = pendingWrite.next;
        long j = pendingWrite.size;
        if (z) {
            if (pendingWrite2 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
            } else {
                this.head = pendingWrite2;
                this.size--;
                this.bytes -= j;
            }
        }
        pendingWrite.recycle();
        ChannelOutboundBuffer channelOutboundBuffer = this.buffer;
        if (channelOutboundBuffer != null) {
            channelOutboundBuffer.decrementPendingOutboundBytes(j);
        }
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
            return;
        }
        logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
    }

    public void add(Object obj, ChannelPromise channelPromise) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        if (channelPromise != null) {
            int size = this.estimatorHandle.size(obj);
            if (size < 0) {
                size = 0;
            }
            PendingWrite newInstance = PendingWrite.newInstance(obj, size, channelPromise);
            PendingWrite pendingWrite = this.tail;
            if (pendingWrite == null) {
                this.head = newInstance;
                this.tail = newInstance;
            } else {
                pendingWrite.next = newInstance;
                this.tail = newInstance;
            }
            this.size++;
            this.bytes += size;
            ChannelOutboundBuffer channelOutboundBuffer = this.buffer;
            if (channelOutboundBuffer != null) {
                channelOutboundBuffer.incrementPendingOutboundBytes(newInstance.size);
                return;
            }
            return;
        }
        throw new NullPointerException("promise");
    }

    public long bytes() {
        return this.bytes;
    }

    public Object current() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        return pendingWrite.msg;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public ChannelPromise remove() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        ChannelPromise channelPromise = pendingWrite.promise;
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        recycle(pendingWrite, true);
        return channelPromise;
    }

    public void removeAndFail(Throwable th) {
        if (th != null) {
            PendingWrite pendingWrite = this.head;
            if (pendingWrite == null) {
                return;
            }
            ReferenceCountUtil.safeRelease(pendingWrite.msg);
            safeFail(pendingWrite.promise, th);
            recycle(pendingWrite, true);
            return;
        }
        throw new NullPointerException("cause");
    }

    public void removeAndFailAll(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        while (true) {
            PendingWrite pendingWrite = this.head;
            if (pendingWrite != null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
                while (pendingWrite != null) {
                    PendingWrite pendingWrite2 = pendingWrite.next;
                    ReferenceCountUtil.safeRelease(pendingWrite.msg);
                    ChannelPromise channelPromise = pendingWrite.promise;
                    recycle(pendingWrite, false);
                    safeFail(channelPromise, th);
                    pendingWrite = pendingWrite2;
                }
            } else {
                assertEmpty();
                return;
            }
        }
    }

    public ChannelFuture removeAndWrite() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        Object obj = pendingWrite.msg;
        ChannelPromise channelPromise = pendingWrite.promise;
        recycle(pendingWrite, true);
        return this.ctx.write(obj, channelPromise);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[EDGE_INSN: B:19:0x003d->B:11:0x003d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:6:0x0013, B:8:0x0017, B:10:0x0024, B:11:0x003d), top: B:17:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture removeAndWriteAll() {
        /*
            r8 = this;
            boolean r0 = r8.isEmpty()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            io.netty.channel.ChannelHandlerContext r0 = r8.ctx
            io.netty.channel.ChannelPromise r0 = r0.newPromise()
            io.netty.util.concurrent.PromiseCombiner r2 = new io.netty.util.concurrent.PromiseCombiner
            r2.<init>()
        L13:
            io.netty.channel.PendingWriteQueue$PendingWrite r3 = r8.head     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L3d
            r8.tail = r1     // Catch: java.lang.Throwable -> L41
            r8.head = r1     // Catch: java.lang.Throwable -> L41
            r4 = 0
            r8.size = r4     // Catch: java.lang.Throwable -> L41
            r5 = 0
            r8.bytes = r5     // Catch: java.lang.Throwable -> L41
        L22:
            if (r3 == 0) goto L13
            io.netty.channel.PendingWriteQueue$PendingWrite r5 = io.netty.channel.PendingWriteQueue.PendingWrite.access$000(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.Object r6 = io.netty.channel.PendingWriteQueue.PendingWrite.access$200(r3)     // Catch: java.lang.Throwable -> L41
            io.netty.channel.ChannelPromise r7 = io.netty.channel.PendingWriteQueue.PendingWrite.access$300(r3)     // Catch: java.lang.Throwable -> L41
            r8.recycle(r3, r4)     // Catch: java.lang.Throwable -> L41
            r2.add(r7)     // Catch: java.lang.Throwable -> L41
            io.netty.channel.ChannelHandlerContext r3 = r8.ctx     // Catch: java.lang.Throwable -> L41
            r3.write(r6, r7)     // Catch: java.lang.Throwable -> L41
            r3 = r5
            goto L22
        L3d:
            r2.finish(r0)     // Catch: java.lang.Throwable -> L41
            goto L45
        L41:
            r1 = move-exception
            r0.setFailure(r1)
        L45:
            r8.assertEmpty()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.PendingWriteQueue.removeAndWriteAll():io.netty.channel.ChannelFuture");
    }

    public int size() {
        return this.size;
    }
}
