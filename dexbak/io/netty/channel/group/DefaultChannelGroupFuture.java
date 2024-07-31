package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.BlockingOperationException;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateEventExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DefaultChannelGroupFuture extends DefaultPromise<Void> implements ChannelGroupFuture {
    private final ChannelFutureListener childListener;
    private int failureCount;
    private final Map<Channel, ChannelFuture> futures;
    private final ChannelGroup group;
    private int successCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class DefaultEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private final V value;

        DefaultEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("read-only");
        }
    }

    DefaultChannelGroupFuture(ChannelGroup channelGroup, Collection<ChannelFuture> collection, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.childListener = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroupFuture.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                boolean z;
                boolean isSuccess = channelFuture.isSuccess();
                synchronized (DefaultChannelGroupFuture.this) {
                    if (isSuccess) {
                        DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                    } else {
                        DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                    }
                    z = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
                }
                if (z) {
                    if (DefaultChannelGroupFuture.this.failureCount > 0) {
                        ArrayList arrayList = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                        for (ChannelFuture channelFuture2 : DefaultChannelGroupFuture.this.futures.values()) {
                            if (!channelFuture2.isSuccess()) {
                                arrayList.add(new DefaultEntry(channelFuture2.channel(), channelFuture2.cause()));
                            }
                        }
                        DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(arrayList));
                        return;
                    }
                    DefaultChannelGroupFuture.this.setSuccess0();
                }
            }
        };
        if (channelGroup == null) {
            throw new NullPointerException("group");
        }
        if (collection != null) {
            this.group = channelGroup;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ChannelFuture channelFuture : collection) {
                linkedHashMap.put(channelFuture.channel(), channelFuture);
            }
            Map<Channel, ChannelFuture> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
            this.futures = unmodifiableMap;
            for (ChannelFuture channelFuture2 : unmodifiableMap.values()) {
                channelFuture2.addListener((GenericFutureListener<? extends Future<? super Void>>) this.childListener);
            }
            if (this.futures.isEmpty()) {
                setSuccess0();
                return;
            }
            return;
        }
        throw new NullPointerException("futures");
    }

    static /* synthetic */ int access$008(DefaultChannelGroupFuture defaultChannelGroupFuture) {
        int i = defaultChannelGroupFuture.successCount;
        defaultChannelGroupFuture.successCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$108(DefaultChannelGroupFuture defaultChannelGroupFuture) {
        int i = defaultChannelGroupFuture.failureCount;
        defaultChannelGroupFuture.failureCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFailure0(ChannelGroupException channelGroupException) {
        super.setFailure((Throwable) channelGroupException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess0() {
        super.setSuccess((DefaultChannelGroupFuture) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.DefaultPromise
    public void checkDeadLock() {
        EventExecutor executor = executor();
        if (executor != null && executor != ImmediateEventExecutor.INSTANCE && executor.inEventLoop()) {
            throw new BlockingOperationException();
        }
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel) {
        return this.futures.get(channel);
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroup group() {
        return this.group;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isPartialFailure() {
        boolean z;
        int i = this.failureCount;
        if (i != 0) {
            z = i != this.futures.size();
        }
        return z;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public synchronized boolean isPartialSuccess() {
        boolean z;
        int i = this.successCount;
        if (i != 0) {
            z = i != this.futures.size();
        }
        return z;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture, java.lang.Iterable
    public Iterator<ChannelFuture> iterator() {
        return this.futures.values().iterator();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable th) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ChannelGroupException cause() {
        return (ChannelGroupException) super.cause();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public DefaultChannelGroupFuture setFailure(Throwable th) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public DefaultChannelGroupFuture setSuccess(Void r1) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public boolean trySuccess(Void r1) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        super.await();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> sync() throws InterruptedException {
        super.sync();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Map<Channel, ChannelFuture> map, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.childListener = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroupFuture.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                boolean z;
                boolean isSuccess = channelFuture.isSuccess();
                synchronized (DefaultChannelGroupFuture.this) {
                    if (isSuccess) {
                        DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                    } else {
                        DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                    }
                    z = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
                }
                if (z) {
                    if (DefaultChannelGroupFuture.this.failureCount > 0) {
                        ArrayList arrayList = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                        for (ChannelFuture channelFuture2 : DefaultChannelGroupFuture.this.futures.values()) {
                            if (!channelFuture2.isSuccess()) {
                                arrayList.add(new DefaultEntry(channelFuture2.channel(), channelFuture2.cause()));
                            }
                        }
                        DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(arrayList));
                        return;
                    }
                    DefaultChannelGroupFuture.this.setSuccess0();
                }
            }
        };
        this.group = channelGroup;
        Map<Channel, ChannelFuture> unmodifiableMap = Collections.unmodifiableMap(map);
        this.futures = unmodifiableMap;
        for (ChannelFuture channelFuture : unmodifiableMap.values()) {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }
}
