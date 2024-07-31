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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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

        static Entry newInstance(Object obj, int i, long j, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i;
            entry.total = j;
            entry.promise = channelPromise;
            return entry;
        }

        int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0L;
            this.progress = 0L;
            this.bufs = null;
            this.buf = null;
            return i;
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

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        int i = this.nioBufferCount;
        if (i > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, i, (Object) null);
        }
    }

    private void clearUserDefinedWritability(int i) {
        int i2;
        int i3;
        int writabilityMask = writabilityMask(i);
        do {
            i2 = this.unwritable;
            i3 = i2 | writabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i2, i3));
        if (i2 != 0 || i3 == 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i, int i2) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i2);
        return byteBufferArr2;
    }

    private static int fillBufferArray(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2, int i) {
        int length = byteBufferArr.length;
        int i2 = 0;
        while (i2 < length) {
            ByteBuffer byteBuffer = byteBufferArr[i2];
            if (byteBuffer == null) {
                break;
            }
            byteBufferArr2[i] = byteBuffer;
            i2++;
            i++;
        }
        return i;
    }

    private void fireChannelWritabilityChanged(boolean z) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (z) {
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

    private boolean remove0(Throwable th, boolean z) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes(i, false, z);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i = this.flushed - 1;
        this.flushed = i;
        if (i == 0) {
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

    private void setUnwritable(boolean z) {
        int i;
        int i2;
        do {
            i = this.unwritable;
            i2 = i | 1;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i2));
        if (i != 0 || i2 == 0) {
            return;
        }
        fireChannelWritabilityChanged(z);
    }

    private void setWritable(boolean z) {
        int i;
        int i2;
        do {
            i = this.unwritable;
            i2 = i & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, i2));
        if (i == 0 || i2 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z);
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

    private static int writabilityMask(int i) {
        if (i < 1 || i > 31) {
            throw new IllegalArgumentException("index: " + i + " (expected: 1~31)");
        }
        return 1 << i;
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

    public void addMessage(Object obj, int i, ChannelPromise channelPromise) {
        Entry newInstance = Entry.newInstance(obj, i, total(obj), channelPromise);
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
        incrementPendingOutboundBytes(i, false);
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
    public void decrementPendingOutboundBytes(long j) {
        decrementPendingOutboundBytes(j, true, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void failFlushed(Throwable th, boolean z) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            do {
            } while (remove0(th, z));
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

    public boolean getUserDefinedWritability(int i) {
        return (writabilityMask(i) & this.unwritable) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incrementPendingOutboundBytes(long j) {
        incrementPendingOutboundBytes(j, true);
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
        long j = 0;
        int i = 0;
        for (Entry entry = this.flushedEntry; isFlushedEntry(entry); entry = entry.next) {
            Object obj = entry.msg;
            if (!(obj instanceof ByteBuf)) {
                break;
            }
            if (!entry.cancelled && (writerIndex = byteBuf.writerIndex() - (readerIndex = (byteBuf = (ByteBuf) obj).readerIndex())) > 0) {
                if (Integer.MAX_VALUE - writerIndex < j) {
                    break;
                }
                j += writerIndex;
                int i2 = entry.count;
                if (i2 == -1) {
                    i2 = byteBuf.nioBufferCount();
                    entry.count = i2;
                }
                int i3 = i + i2;
                if (i3 > byteBufferArr.length) {
                    byteBufferArr = expandNioBufferArray(byteBufferArr, i3, i);
                    NIO_BUFFERS.set(internalThreadLocalMap, byteBufferArr);
                }
                if (i2 == 1) {
                    ByteBuffer byteBuffer = entry.buf;
                    if (byteBuffer == null) {
                        byteBuffer = byteBuf.internalNioBuffer(readerIndex, writerIndex);
                        entry.buf = byteBuffer;
                    }
                    byteBufferArr[i] = byteBuffer;
                    i++;
                } else {
                    ByteBuffer[] byteBufferArr2 = entry.bufs;
                    if (byteBufferArr2 == null) {
                        byteBufferArr2 = byteBuf.nioBuffers();
                        entry.bufs = byteBufferArr2;
                    }
                    i = fillBufferArray(byteBufferArr2, byteBufferArr, i);
                }
            }
        }
        this.nioBufferCount = i;
        this.nioBufferSize = j;
        return byteBufferArr;
    }

    public void progress(long j) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        if (channelPromise instanceof ChannelProgressivePromise) {
            long j2 = entry.progress + j;
            entry.progress = j2;
            ((ChannelProgressivePromise) channelPromise).tryProgress(j2, entry.total);
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
        int i = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes(i, false, true);
        }
        entry.recycle();
        return true;
    }

    public void removeBytes(long j) {
        while (true) {
            Object current = current();
            if (!(current instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) current;
            int readerIndex = byteBuf.readerIndex();
            long writerIndex = byteBuf.writerIndex() - readerIndex;
            if (writerIndex <= j) {
                if (j != 0) {
                    progress(writerIndex);
                    j -= writerIndex;
                }
                remove();
            } else if (j != 0) {
                byteBuf.readerIndex(readerIndex + ((int) j));
                progress(j);
            }
        }
        clearNioBuffers();
    }

    public void setUserDefinedWritability(int i, boolean z) {
        if (z) {
            setUserDefinedWritability(i);
        } else {
            clearUserDefinedWritability(i);
        }
    }

    public int size() {
        return this.flushed;
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    private void decrementPendingOutboundBytes(long j, boolean z, boolean z2) {
        if (j == 0) {
            return;
        }
        long addAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j);
        if (!z2 || addAndGet >= this.channel.config().getWriteBufferLowWaterMark()) {
            return;
        }
        setWritable(z);
    }

    private void incrementPendingOutboundBytes(long j, boolean z) {
        if (j != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j) > this.channel.config().getWriteBufferHighWaterMark()) {
            setUnwritable(z);
        }
    }

    private void setUserDefinedWritability(int i) {
        int i2;
        int i3;
        int writabilityMask = writabilityMask(i) ^ (-1);
        do {
            i2 = this.unwritable;
            i3 = i2 & writabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i2, i3));
        if (i2 == 0 || i3 != 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    public boolean remove(Throwable th) {
        return remove0(th, true);
    }
}
