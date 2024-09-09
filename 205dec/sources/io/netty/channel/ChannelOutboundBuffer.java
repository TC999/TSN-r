package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ChannelOutboundBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER;
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER;
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelOutboundBuffer.class);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() { // from class: io.netty.channel.ChannelOutboundBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public ByteBuffer[] initialValue() throws Exception {
            return new ByteBuffer[1024];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Entry {
        private static final Recycler<Entry> RECYCLER = new Recycler<Entry>() { // from class: io.netty.channel.ChannelOutboundBuffer.Entry.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject */
            public Entry newObject2(Recycler.Handle<Entry> handle) {
                return new Entry(handle);
            }
        };
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final Recycler.Handle<Entry> handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        static Entry newInstance(Object obj, int i4, long j4, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i4;
            entry.total = j4;
            entry.promise = channelPromise;
            return entry;
        }

        int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i4 = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0L;
            this.progress = 0L;
            this.bufs = null;
            this.buf = null;
            return i4;
        }

        void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.recycle(this);
        }

        Entry recycleAndGetNext() {
            Entry entry = this.next;
            recycle();
            return entry;
        }

        private Entry(Recycler.Handle<Entry> handle) {
            this.count = -1;
            this.handle = handle;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface MessageProcessor {
        boolean processMessage(Object obj) throws Exception;
    }

    static {
        AtomicIntegerFieldUpdater<ChannelOutboundBuffer> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(ChannelOutboundBuffer.class, "unwritable");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");
        }
        UNWRITABLE_UPDATER = newAtomicIntegerFieldUpdater;
        AtomicLongFieldUpdater<ChannelOutboundBuffer> newAtomicLongFieldUpdater = PlatformDependent.newAtomicLongFieldUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
        if (newAtomicLongFieldUpdater == null) {
            newAtomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
        }
        TOTAL_PENDING_SIZE_UPDATER = newAtomicLongFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelOutboundBuffer(AbstractChannel abstractChannel) {
        this.channel = abstractChannel;
    }

    private void clearNioBuffers() {
        int i4 = this.nioBufferCount;
        if (i4 > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, i4, (Object) null);
        }
    }

    private void clearUserDefinedWritability(int i4) {
        int i5;
        int i6;
        int writabilityMask = writabilityMask(i4);
        do {
            i5 = this.unwritable;
            i6 = i5 | writabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i5, i6));
        if (i5 != 0 || i6 == 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i4, int i5) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i4 > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i5);
        return byteBufferArr2;
    }

    private static int fillBufferArray(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2, int i4) {
        int length = byteBufferArr.length;
        int i5 = 0;
        while (i5 < length) {
            ByteBuffer byteBuffer = byteBufferArr[i5];
            if (byteBuffer == null) {
                break;
            }
            byteBufferArr2[i4] = byteBuffer;
            i5++;
            i4++;
        }
        return i4;
    }

    private void fireChannelWritabilityChanged(boolean z3) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (z3) {
            Runnable runnable = this.fireChannelWritabilityChangedTask;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pipeline.fireChannelWritabilityChanged();
                    }
                };
                this.fireChannelWritabilityChangedTask = runnable;
            }
            this.channel.eventLoop().execute(runnable);
            return;
        }
        pipeline.fireChannelWritabilityChanged();
    }

    private boolean isFlushedEntry(Entry entry) {
        return (entry == null || entry == this.unflushedEntry) ? false : true;
    }

    private boolean remove0(Throwable th, boolean z3) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i4 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes(i4, false, z3);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i4 = this.flushed - 1;
        this.flushed = i4;
        if (i4 == 0) {
            this.flushedEntry = null;
            if (entry == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
                return;
            }
            return;
        }
        this.flushedEntry = entry.next;
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
            return;
        }
        Throwable cause = channelPromise.cause();
        if (cause == null) {
            logger.warn("Failed to mark a promise as failure because it has succeeded already: {}", channelPromise, th);
        } else {
            logger.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause {}", channelPromise, ThrowableUtil.stackTraceToString(cause), th);
        }
    }

    private static void safeSuccess(ChannelPromise channelPromise) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
            return;
        }
        Throwable cause = channelPromise.cause();
        if (cause == null) {
            logger.warn("Failed to mark a promise as success because it has succeeded already: {}", channelPromise);
        } else {
            logger.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause {}", channelPromise, ThrowableUtil.stackTraceToString(cause));
        }
    }

    private void setUnwritable(boolean z3) {
        int i4;
        int i5;
        do {
            i4 = this.unwritable;
            i5 = i4 | 1;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i4, i5));
        if (i4 != 0 || i5 == 0) {
            return;
        }
        fireChannelWritabilityChanged(z3);
    }

    private void setWritable(boolean z3) {
        int i4;
        int i5;
        do {
            i4 = this.unwritable;
            i5 = i4 & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i4, i5));
        if (i4 == 0 || i5 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z3);
    }

    private static long total(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        if (obj instanceof ByteBufHolder) {
            return ((ByteBufHolder) obj).content().readableBytes();
        }
        return -1L;
    }

    private static int writabilityMask(int i4) {
        if (i4 < 1 || i4 > 31) {
            throw new IllegalArgumentException("index: " + i4 + " (expected: 1~31)");
        }
        return 1 << i4;
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes(entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    public void addMessage(Object obj, int i4, ChannelPromise channelPromise) {
        Entry newInstance = Entry.newInstance(obj, i4, total(obj), channelPromise);
        Entry entry = this.tailEntry;
        if (entry == null) {
            this.flushedEntry = null;
            this.tailEntry = newInstance;
        } else {
            entry.next = newInstance;
            this.tailEntry = newInstance;
        }
        if (this.unflushedEntry == null) {
            this.unflushedEntry = newInstance;
        }
        incrementPendingOutboundBytes(i4, false);
    }

    public long bytesBeforeUnwritable() {
        long writeBufferHighWaterMark = this.channel.config().getWriteBufferHighWaterMark() - this.totalPendingSize;
        if (writeBufferHighWaterMark <= 0 || !isWritable()) {
            return 0L;
        }
        return writeBufferHighWaterMark;
    }

    public long bytesBeforeWritable() {
        long writeBufferLowWaterMark = this.totalPendingSize - this.channel.config().getWriteBufferLowWaterMark();
        if (writeBufferLowWaterMark <= 0 || isWritable()) {
            return 0L;
        }
        return writeBufferLowWaterMark;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(final ClosedChannelException closedChannelException) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelOutboundBuffer.this.close(closedChannelException);
                }
            });
            return;
        }
        this.inFail = true;
        if (!this.channel.isOpen()) {
            if (isEmpty()) {
                try {
                    for (Entry entry = this.unflushedEntry; entry != null; entry = entry.recycleAndGetNext()) {
                        TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -entry.pendingSize);
                        if (!entry.cancelled) {
                            ReferenceCountUtil.safeRelease(entry.msg);
                            safeFail(entry.promise, closedChannelException);
                        }
                    }
                    this.inFail = false;
                    clearNioBuffers();
                    return;
                } catch (Throwable th) {
                    this.inFail = false;
                    throw th;
                }
            }
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        throw new IllegalStateException("close() must be invoked after the channel is closed.");
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decrementPendingOutboundBytes(long j4) {
        decrementPendingOutboundBytes(j4, true, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void failFlushed(Throwable th, boolean z3) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            do {
            } while (remove0(th, z3));
        } finally {
            this.inFail = false;
        }
    }

    public void forEachFlushedMessage(MessageProcessor messageProcessor) throws Exception {
        if (messageProcessor != null) {
            Entry entry = this.flushedEntry;
            if (entry == null) {
                return;
            }
            do {
                if (!entry.cancelled && !messageProcessor.processMessage(entry.msg)) {
                    return;
                }
                entry = entry.next;
            } while (isFlushedEntry(entry));
            return;
        }
        throw new NullPointerException("processor");
    }

    public boolean getUserDefinedWritability(int i4) {
        return (writabilityMask(i4) & this.unwritable) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incrementPendingOutboundBytes(long j4) {
        incrementPendingOutboundBytes(j4, true);
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public ByteBuffer[] nioBuffers() {
        ByteBuf byteBuf;
        int readerIndex;
        int writerIndex;
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        ByteBuffer[] byteBufferArr = NIO_BUFFERS.get(internalThreadLocalMap);
        long j4 = 0;
        int i4 = 0;
        for (Entry entry = this.flushedEntry; isFlushedEntry(entry); entry = entry.next) {
            Object obj = entry.msg;
            if (!(obj instanceof ByteBuf)) {
                break;
            }
            if (!entry.cancelled && (writerIndex = byteBuf.writerIndex() - (readerIndex = (byteBuf = (ByteBuf) obj).readerIndex())) > 0) {
                if (Integer.MAX_VALUE - writerIndex < j4) {
                    break;
                }
                j4 += writerIndex;
                int i5 = entry.count;
                if (i5 == -1) {
                    i5 = byteBuf.nioBufferCount();
                    entry.count = i5;
                }
                int i6 = i4 + i5;
                if (i6 > byteBufferArr.length) {
                    byteBufferArr = expandNioBufferArray(byteBufferArr, i6, i4);
                    NIO_BUFFERS.set(internalThreadLocalMap, byteBufferArr);
                }
                if (i5 == 1) {
                    ByteBuffer byteBuffer = entry.buf;
                    if (byteBuffer == null) {
                        byteBuffer = byteBuf.internalNioBuffer(readerIndex, writerIndex);
                        entry.buf = byteBuffer;
                    }
                    byteBufferArr[i4] = byteBuffer;
                    i4++;
                } else {
                    ByteBuffer[] byteBufferArr2 = entry.bufs;
                    if (byteBufferArr2 == null) {
                        byteBufferArr2 = byteBuf.nioBuffers();
                        entry.bufs = byteBufferArr2;
                    }
                    i4 = fillBufferArray(byteBufferArr2, byteBufferArr, i4);
                }
            }
        }
        this.nioBufferCount = i4;
        this.nioBufferSize = j4;
        return byteBufferArr;
    }

    public void progress(long j4) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        if (channelPromise instanceof ChannelProgressivePromise) {
            long j5 = entry.progress + j4;
            entry.progress = j5;
            ((ChannelProgressivePromise) channelPromise).tryProgress(j5, entry.total);
        }
    }

    @Deprecated
    public void recycle() {
    }

    public boolean remove() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i4 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes(i4, false, true);
        }
        entry.recycle();
        return true;
    }

    public void removeBytes(long j4) {
        while (true) {
            Object current = current();
            if (!(current instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) current;
            int readerIndex = byteBuf.readerIndex();
            long writerIndex = byteBuf.writerIndex() - readerIndex;
            if (writerIndex <= j4) {
                if (j4 != 0) {
                    progress(writerIndex);
                    j4 -= writerIndex;
                }
                remove();
            } else if (j4 != 0) {
                byteBuf.readerIndex(readerIndex + ((int) j4));
                progress(j4);
            }
        }
        clearNioBuffers();
    }

    public void setUserDefinedWritability(int i4, boolean z3) {
        if (z3) {
            setUserDefinedWritability(i4);
        } else {
            clearUserDefinedWritability(i4);
        }
    }

    public int size() {
        return this.flushed;
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    private void decrementPendingOutboundBytes(long j4, boolean z3, boolean z4) {
        if (j4 == 0) {
            return;
        }
        long addAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j4);
        if (!z4 || addAndGet >= this.channel.config().getWriteBufferLowWaterMark()) {
            return;
        }
        setWritable(z3);
    }

    private void incrementPendingOutboundBytes(long j4, boolean z3) {
        if (j4 != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j4) > this.channel.config().getWriteBufferHighWaterMark()) {
            setUnwritable(z3);
        }
    }

    private void setUserDefinedWritability(int i4) {
        int i5;
        int i6;
        int writabilityMask = writabilityMask(i4) ^ (-1);
        do {
            i5 = this.unwritable;
            i6 = i5 & writabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i5, i6));
        if (i5 == 0 || i6 != 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    public boolean remove(Throwable th) {
        return remove0(th, true);
    }
}
