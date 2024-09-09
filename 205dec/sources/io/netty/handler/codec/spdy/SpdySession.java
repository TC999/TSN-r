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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SpdySession {
    private final AtomicInteger receiveWindowSize;
    private final AtomicInteger sendWindowSize;
    private final AtomicInteger activeLocalStreams = new AtomicInteger();
    private final AtomicInteger activeRemoteStreams = new AtomicInteger();
    private final Map<Integer, StreamState> activeStreams = PlatformDependent.newConcurrentHashMap();
    private final StreamComparator streamComparator = new StreamComparator();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class StreamState {
        private boolean localSideClosed;
        private final Queue<PendingWrite> pendingWriteQueue = new ConcurrentLinkedQueue();
        private final byte priority;
        private final AtomicInteger receiveWindowSize;
        private int receiveWindowSizeLowerBound;
        private boolean receivedReply;
        private boolean remoteSideClosed;
        private final AtomicInteger sendWindowSize;

        StreamState(byte b4, boolean z3, boolean z4, int i4, int i5) {
            this.priority = b4;
            this.remoteSideClosed = z3;
            this.localSideClosed = z4;
            this.sendWindowSize = new AtomicInteger(i4);
            this.receiveWindowSize = new AtomicInteger(i5);
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

        void setReceiveWindowSizeLowerBound(int i4) {
            this.receiveWindowSizeLowerBound = i4;
        }

        int updateReceiveWindowSize(int i4) {
            return this.receiveWindowSize.addAndGet(i4);
        }

        int updateSendWindowSize(int i4) {
            return this.sendWindowSize.addAndGet(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdySession(int i4, int i5) {
        this.sendWindowSize = new AtomicInteger(i4);
        this.receiveWindowSize = new AtomicInteger(i5);
    }

    private StreamState removeActiveStream(int i4, boolean z3) {
        StreamState remove = this.activeStreams.remove(Integer.valueOf(i4));
        if (remove != null) {
            if (z3) {
                this.activeRemoteStreams.decrementAndGet();
            } else {
                this.activeLocalStreams.decrementAndGet();
            }
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acceptStream(int i4, byte b4, boolean z3, boolean z4, int i5, int i6, boolean z5) {
        if (!(z3 && z4) && this.activeStreams.put(Integer.valueOf(i4), new StreamState(b4, z3, z4, i5, i6)) == null) {
            if (z5) {
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
    public void closeLocalSide(int i4, boolean z3) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            streamState.closeLocalSide();
            if (streamState.isRemoteSideClosed()) {
                removeActiveStream(i4, z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeRemoteSide(int i4, boolean z3) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            streamState.closeRemoteSide();
            if (streamState.isLocalSideClosed()) {
                removeActiveStream(i4, z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingWrite getPendingWrite(int i4) {
        PendingWrite pendingWrite;
        if (i4 == 0) {
            for (Map.Entry<Integer, StreamState> entry : activeStreams().entrySet()) {
                StreamState value = entry.getValue();
                if (value.getSendWindowSize() > 0 && (pendingWrite = value.getPendingWrite()) != null) {
                    return pendingWrite;
                }
            }
            return null;
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            return streamState.getPendingWrite();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getReceiveWindowSizeLowerBound(int i4) {
        StreamState streamState;
        if (i4 == 0 || (streamState = this.activeStreams.get(Integer.valueOf(i4))) == null) {
            return 0;
        }
        return streamState.getReceiveWindowSizeLowerBound();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSendWindowSize(int i4) {
        if (i4 == 0) {
            return this.sendWindowSize.get();
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            return streamState.getSendWindowSize();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReceivedReply(int i4) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        return streamState != null && streamState.hasReceivedReply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isActiveStream(int i4) {
        return this.activeStreams.containsKey(Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLocalSideClosed(int i4) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        return streamState == null || streamState.isLocalSideClosed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRemoteSideClosed(int i4) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        return streamState == null || streamState.isRemoteSideClosed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean noActiveStreams() {
        return this.activeStreams.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int numActiveStreams(boolean z3) {
        if (z3) {
            return this.activeRemoteStreams.get();
        }
        return this.activeLocalStreams.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean putPendingWrite(int i4, PendingWrite pendingWrite) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        return streamState != null && streamState.putPendingWrite(pendingWrite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void receivedReply(int i4) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            streamState.receivedReply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingWrite removePendingWrite(int i4) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            return streamState.removePendingWrite();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeStream(int i4, Throwable th, boolean z3) {
        StreamState removeActiveStream = removeActiveStream(i4, z3);
        if (removeActiveStream != null) {
            removeActiveStream.clearPendingWrites(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAllReceiveWindowSizes(int i4) {
        for (StreamState streamState : this.activeStreams.values()) {
            streamState.updateReceiveWindowSize(i4);
            if (i4 < 0) {
                streamState.setReceiveWindowSizeLowerBound(i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAllSendWindowSizes(int i4) {
        for (StreamState streamState : this.activeStreams.values()) {
            streamState.updateSendWindowSize(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int updateReceiveWindowSize(int i4, int i5) {
        if (i4 == 0) {
            return this.receiveWindowSize.addAndGet(i5);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState == null) {
            return -1;
        }
        if (i5 > 0) {
            streamState.setReceiveWindowSizeLowerBound(0);
        }
        return streamState.updateReceiveWindowSize(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int updateSendWindowSize(int i4, int i5) {
        if (i4 == 0) {
            return this.sendWindowSize.addAndGet(i5);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i4));
        if (streamState != null) {
            return streamState.updateSendWindowSize(i5);
        }
        return -1;
    }
}
