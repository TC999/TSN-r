package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelPromise;
import io.netty.util.internal.PlatformDependent;
import java.util.Comparator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SpdySession {
    private final AtomicInteger receiveWindowSize;
    private final AtomicInteger sendWindowSize;
    private final AtomicInteger activeLocalStreams = new AtomicInteger();
    private final AtomicInteger activeRemoteStreams = new AtomicInteger();
    private final Map<Integer, StreamState> activeStreams = PlatformDependent.newConcurrentHashMap();
    private final StreamComparator streamComparator = new StreamComparator();

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class PendingWrite {
        final ChannelPromise promise;
        final SpdyDataFrame spdyDataFrame;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingWrite(SpdyDataFrame spdyDataFrame, ChannelPromise channelPromise) {
            this.spdyDataFrame = spdyDataFrame;
            this.promise = channelPromise;
        }

        void fail(Throwable th) {
            this.spdyDataFrame.release();
            this.promise.setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class StreamComparator implements Comparator<Integer> {
        StreamComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            int priority = ((StreamState) SpdySession.this.activeStreams.get(num)).getPriority() - ((StreamState) SpdySession.this.activeStreams.get(num2)).getPriority();
            return priority != 0 ? priority : num.intValue() - num2.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class StreamState {
        private boolean localSideClosed;
        private final Queue<PendingWrite> pendingWriteQueue = new ConcurrentLinkedQueue();
        private final byte priority;
        private final AtomicInteger receiveWindowSize;
        private int receiveWindowSizeLowerBound;
        private boolean receivedReply;
        private boolean remoteSideClosed;
        private final AtomicInteger sendWindowSize;

        StreamState(byte b, boolean z, boolean z2, int i, int i2) {
            this.priority = b;
            this.remoteSideClosed = z;
            this.localSideClosed = z2;
            this.sendWindowSize = new AtomicInteger(i);
            this.receiveWindowSize = new AtomicInteger(i2);
        }

        void clearPendingWrites(Throwable th) {
            while (true) {
                PendingWrite poll = this.pendingWriteQueue.poll();
                if (poll == null) {
                    return;
                }
                poll.fail(th);
            }
        }

        void closeLocalSide() {
            this.localSideClosed = true;
        }

        void closeRemoteSide() {
            this.remoteSideClosed = true;
        }

        PendingWrite getPendingWrite() {
            return this.pendingWriteQueue.peek();
        }

        byte getPriority() {
            return this.priority;
        }

        int getReceiveWindowSizeLowerBound() {
            return this.receiveWindowSizeLowerBound;
        }

        int getSendWindowSize() {
            return this.sendWindowSize.get();
        }

        boolean hasReceivedReply() {
            return this.receivedReply;
        }

        boolean isLocalSideClosed() {
            return this.localSideClosed;
        }

        boolean isRemoteSideClosed() {
            return this.remoteSideClosed;
        }

        boolean putPendingWrite(PendingWrite pendingWrite) {
            return this.pendingWriteQueue.offer(pendingWrite);
        }

        void receivedReply() {
            this.receivedReply = true;
        }

        PendingWrite removePendingWrite() {
            return this.pendingWriteQueue.poll();
        }

        void setReceiveWindowSizeLowerBound(int i) {
            this.receiveWindowSizeLowerBound = i;
        }

        int updateReceiveWindowSize(int i) {
            return this.receiveWindowSize.addAndGet(i);
        }

        int updateSendWindowSize(int i) {
            return this.sendWindowSize.addAndGet(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdySession(int i, int i2) {
        this.sendWindowSize = new AtomicInteger(i);
        this.receiveWindowSize = new AtomicInteger(i2);
    }

    private StreamState removeActiveStream(int i, boolean z) {
        StreamState remove = this.activeStreams.remove(Integer.valueOf(i));
        if (remove != null) {
            if (z) {
                this.activeRemoteStreams.decrementAndGet();
            } else {
                this.activeLocalStreams.decrementAndGet();
            }
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acceptStream(int i, byte b, boolean z, boolean z2, int i2, int i3, boolean z3) {
        if (!(z && z2) && this.activeStreams.put(Integer.valueOf(i), new StreamState(b, z, z2, i2, i3)) == null) {
            if (z3) {
                this.activeRemoteStreams.incrementAndGet();
            } else {
                this.activeLocalStreams.incrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Integer, StreamState> activeStreams() {
        TreeMap treeMap = new TreeMap(this.streamComparator);
        treeMap.putAll(this.activeStreams);
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeLocalSide(int i, boolean z) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            streamState.closeLocalSide();
            if (streamState.isRemoteSideClosed()) {
                removeActiveStream(i, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeRemoteSide(int i, boolean z) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            streamState.closeRemoteSide();
            if (streamState.isLocalSideClosed()) {
                removeActiveStream(i, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingWrite getPendingWrite(int i) {
        PendingWrite pendingWrite;
        if (i == 0) {
            for (Map.Entry<Integer, StreamState> entry : activeStreams().entrySet()) {
                StreamState value = entry.getValue();
                if (value.getSendWindowSize() > 0 && (pendingWrite = value.getPendingWrite()) != null) {
                    return pendingWrite;
                }
            }
            return null;
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            return streamState.getPendingWrite();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getReceiveWindowSizeLowerBound(int i) {
        StreamState streamState;
        if (i == 0 || (streamState = this.activeStreams.get(Integer.valueOf(i))) == null) {
            return 0;
        }
        return streamState.getReceiveWindowSizeLowerBound();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSendWindowSize(int i) {
        if (i == 0) {
            return this.sendWindowSize.get();
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            return streamState.getSendWindowSize();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReceivedReply(int i) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        return streamState != null && streamState.hasReceivedReply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isActiveStream(int i) {
        return this.activeStreams.containsKey(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLocalSideClosed(int i) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        return streamState == null || streamState.isLocalSideClosed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRemoteSideClosed(int i) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        return streamState == null || streamState.isRemoteSideClosed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean noActiveStreams() {
        return this.activeStreams.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int numActiveStreams(boolean z) {
        if (z) {
            return this.activeRemoteStreams.get();
        }
        return this.activeLocalStreams.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean putPendingWrite(int i, PendingWrite pendingWrite) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        return streamState != null && streamState.putPendingWrite(pendingWrite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receivedReply(int i) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            streamState.receivedReply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingWrite removePendingWrite(int i) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            return streamState.removePendingWrite();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeStream(int i, Throwable th, boolean z) {
        StreamState removeActiveStream = removeActiveStream(i, z);
        if (removeActiveStream != null) {
            removeActiveStream.clearPendingWrites(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAllReceiveWindowSizes(int i) {
        for (StreamState streamState : this.activeStreams.values()) {
            streamState.updateReceiveWindowSize(i);
            if (i < 0) {
                streamState.setReceiveWindowSizeLowerBound(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAllSendWindowSizes(int i) {
        for (StreamState streamState : this.activeStreams.values()) {
            streamState.updateSendWindowSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int updateReceiveWindowSize(int i, int i2) {
        if (i == 0) {
            return this.receiveWindowSize.addAndGet(i2);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState == null) {
            return -1;
        }
        if (i2 > 0) {
            streamState.setReceiveWindowSizeLowerBound(0);
        }
        return streamState.updateReceiveWindowSize(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int updateSendWindowSize(int i, int i2) {
        if (i == 0) {
            return this.sendWindowSize.addAndGet(i2);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i));
        if (streamState != null) {
            return streamState.updateSendWindowSize(i2);
        }
        return -1;
    }
}
