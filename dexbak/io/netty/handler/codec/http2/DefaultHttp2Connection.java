package io.netty.handler.codec.http2;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.collection.IntCollections;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.UnaryPromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultHttp2Connection implements Http2Connection {
    final ActiveStreams activeStreams;
    Promise<Void> closePromise;
    final ConnectionStream connectionStream;
    final List<Http2Connection.Listener> listeners;
    final DefaultEndpoint<Http2LocalFlowController> localEndpoint;
    final PropertyKeyRegistry propertyKeyRegistry;
    final DefaultEndpoint<Http2RemoteFlowController> remoteEndpoint;
    final IntObjectMap<Http2Stream> streamMap;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHttp2Connection.class);
    private static final int INITIAL_CHILDREN_MAP_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.http2.childrenMapSize", 4));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2Connection$3 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138363 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class ActiveStreams {
        private final List<Http2Connection.Listener> listeners;
        private int pendingIterations;
        private final Queue<Event> pendingEvents = new ArrayDeque(4);
        private final Set<Http2Stream> streams = new LinkedHashSet();

        public ActiveStreams(List<Http2Connection.Listener> list) {
            this.listeners = list;
        }

        public void activate(final DefaultStream defaultStream) {
            if (allowModifications()) {
                addToActiveStreams(defaultStream);
            } else {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.1
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.addToActiveStreams(defaultStream);
                    }
                });
            }
        }

        void addToActiveStreams(DefaultStream defaultStream) {
            if (this.streams.add(defaultStream)) {
                defaultStream.createdBy().numActiveStreams++;
                for (int i = 0; i < this.listeners.size(); i++) {
                    try {
                        this.listeners.get(i).onStreamActive(defaultStream);
                    } catch (Throwable th) {
                        DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamActive.", th);
                    }
                }
            }
        }

        boolean allowModifications() {
            return this.pendingIterations == 0;
        }

        public void deactivate(final DefaultStream defaultStream, final Iterator<?> it) {
            if (!allowModifications() && it == null) {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.2
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        if (defaultStream.parent() == null) {
                            return;
                        }
                        ActiveStreams.this.removeFromActiveStreams(defaultStream, it);
                    }
                });
            } else {
                removeFromActiveStreams(defaultStream, it);
            }
        }

        void decrementPendingIterations() {
            this.pendingIterations--;
            if (!allowModifications()) {
                return;
            }
            while (true) {
                Event poll = this.pendingEvents.poll();
                if (poll == null) {
                    return;
                }
                try {
                    poll.process();
                } catch (Throwable th) {
                    DefaultHttp2Connection.logger.error("Caught Throwable while processing pending ActiveStreams$Event.", th);
                }
            }
        }

        public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
            incrementPendingIterations();
            try {
                for (Http2Stream http2Stream : this.streams) {
                    if (!http2StreamVisitor.visit(http2Stream)) {
                        return http2Stream;
                    }
                }
                return null;
            } finally {
                decrementPendingIterations();
            }
        }

        void incrementPendingIterations() {
            this.pendingIterations++;
        }

        void removeFromActiveStreams(DefaultStream defaultStream, Iterator<?> it) {
            if (this.streams.remove(defaultStream)) {
                DefaultEndpoint<? extends Http2FlowController> createdBy = defaultStream.createdBy();
                createdBy.numActiveStreams--;
                DefaultHttp2Connection.this.notifyClosed(defaultStream);
            }
            DefaultHttp2Connection.this.removeStream(defaultStream, it);
        }

        public int size() {
            return this.streams.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class ConnectionStream extends DefaultStream {
        ConnectionStream() {
            super(0, Http2Stream.State.IDLE);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream
        DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return null;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return false;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream setPriority(int i, short s, boolean z) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class DefaultEndpoint<F extends Http2FlowController> implements Http2Connection.Endpoint<F> {
        private F flowController;
        private int lastStreamKnownByPeer = -1;
        private int maxActiveStreams;
        private int maxStreams;
        private int nextReservationStreamId;
        private int nextStreamIdToCreate;
        int numActiveStreams;
        int numStreams;
        private boolean pushToAllowed;
        private final boolean server;

        DefaultEndpoint(boolean z) {
            this.pushToAllowed = true;
            this.server = z;
            if (z) {
                this.nextStreamIdToCreate = 2;
                this.nextReservationStreamId = 0;
            } else {
                this.nextStreamIdToCreate = 1;
                this.nextReservationStreamId = 1;
            }
            this.pushToAllowed = true ^ z;
            this.maxActiveStreams = Integer.MAX_VALUE;
            this.maxStreams = Integer.MAX_VALUE;
        }

        private void addStream(DefaultStream defaultStream) {
            DefaultHttp2Connection.this.streamMap.put(defaultStream.mo12684id(), (int) defaultStream);
            ArrayList arrayList = new ArrayList(1);
            DefaultHttp2Connection.this.connectionStream.takeChild(defaultStream, false, arrayList);
            for (int i = 0; i < DefaultHttp2Connection.this.listeners.size(); i++) {
                try {
                    DefaultHttp2Connection.this.listeners.get(i).onStreamAdded(defaultStream);
                } catch (Throwable th) {
                    DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamAdded.", th);
                }
            }
            DefaultHttp2Connection.this.notifyParentChanged(arrayList);
        }

        private void checkNewStreamAllowed(int i, Http2Stream.State state) throws Http2Exception {
            if (DefaultHttp2Connection.this.goAwayReceived() && i > DefaultHttp2Connection.this.localEndpoint.lastStreamKnownByPeer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Cannot create stream %d since this endpoint has received a GOAWAY frame with last stream id %d.", Integer.valueOf(i), Integer.valueOf(DefaultHttp2Connection.this.localEndpoint.lastStreamKnownByPeer()));
            }
            if (i >= 0) {
                if (!isValidStreamId(i)) {
                    Http2Error http2Error = Http2Error.PROTOCOL_ERROR;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = this.server ? "server" : "client";
                    throw Http2Exception.connectionError(http2Error, "Request stream %d is not correct for %s connection", objArr);
                }
                int i2 = this.nextStreamIdToCreate;
                if (i < i2) {
                    throw Http2Exception.closedStreamError(Http2Error.PROTOCOL_ERROR, "Request stream %d is behind the next expected stream %d", Integer.valueOf(i), Integer.valueOf(this.nextStreamIdToCreate));
                }
                if (i2 > 0) {
                    if (!state.localSideOpen() && !state.remoteSideOpen()) {
                        if (this.numStreams == this.maxStreams) {
                            throw Http2Exception.streamError(i, Http2Error.REFUSED_STREAM, "Maximum streams violated for this endpoint.", new Object[0]);
                        }
                    } else if (!canOpenStream()) {
                        throw Http2Exception.streamError(i, Http2Error.REFUSED_STREAM, "Maximum active streams violated for this endpoint.", new Object[0]);
                    }
                    if (DefaultHttp2Connection.this.isClosed()) {
                        throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Attempted to create stream id %d after connection was closed", Integer.valueOf(i));
                    }
                    return;
                }
                throw Http2Exception.connectionError(Http2Error.REFUSED_STREAM, "Stream IDs are exhausted for this endpoint.", new Object[0]);
            }
            throw new Http2NoMoreStreamIdsException();
        }

        private void incrementExpectedStreamId(int i) {
            int i2 = this.nextReservationStreamId;
            if (i > i2 && i2 >= 0) {
                this.nextReservationStreamId = i;
            }
            this.nextStreamIdToCreate = i + 2;
            this.numStreams++;
        }

        private boolean isLocal() {
            return this == DefaultHttp2Connection.this.localEndpoint;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void allowPushTo(boolean z) {
            if (z && this.server) {
                throw new IllegalArgumentException("Servers do not allow push");
            }
            this.pushToAllowed = z;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean canOpenStream() {
            return this.numActiveStreams < this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean created(Http2Stream http2Stream) {
            return (http2Stream instanceof DefaultStream) && ((DefaultStream) http2Stream).createdBy() == this;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public F flowController() {
            return this.flowController;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int incrementAndGetNextStreamId() {
            int i = this.nextReservationStreamId;
            if (i >= 0) {
                int i2 = i + 2;
                this.nextReservationStreamId = i2;
                return i2;
            }
            return i;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isServer() {
            return this.server;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isValidStreamId(int i) {
            if (i > 0) {
                return this.server == ((i & 1) == 0);
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamCreated() {
            int i = this.nextStreamIdToCreate;
            if (i > 1) {
                return i - 2;
            }
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamKnownByPeer() {
            return this.lastStreamKnownByPeer;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int maxActiveStreams() {
            return this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int maxStreams() {
            return this.maxStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean mayHaveCreatedStream(int i) {
            return isValidStreamId(i) && i <= lastStreamCreated();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int numActiveStreams() {
            return this.numActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public Http2Connection.Endpoint<? extends Http2FlowController> opposite() {
            return isLocal() ? DefaultHttp2Connection.this.remoteEndpoint : DefaultHttp2Connection.this.localEndpoint;
        }

        private DefaultStream createStream(int i, Http2Stream.State state) throws Http2Exception {
            checkNewStreamAllowed(i, state);
            DefaultStream defaultStream = new DefaultStream(i, state);
            incrementExpectedStreamId(i);
            addStream(defaultStream);
            return defaultStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lastStreamKnownByPeer(int i) {
            this.lastStreamKnownByPeer = i;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream createIdleStream(int i) throws Http2Exception {
            return createStream(i, Http2Stream.State.IDLE);
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void flowController(F f) {
            this.flowController = (F) ObjectUtil.checkNotNull(f, "flowController");
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void maxStreams(int i, int i2) throws Http2Exception {
            if (i2 < i) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "maxStream[%d] streams must be >= maxActiveStreams[%d]", Integer.valueOf(i2), Integer.valueOf(i));
            }
            this.maxStreams = i2;
            this.maxActiveStreams = i;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream reservePushStream(int i, Http2Stream http2Stream) throws Http2Exception {
            if (http2Stream != null) {
                if (!isLocal() ? http2Stream.state().remoteSideOpen() : http2Stream.state().localSideOpen()) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d is not open for sending push promise", Integer.valueOf(http2Stream.mo12684id()));
                }
                if (opposite().allowPushTo()) {
                    Http2Stream.State state = isLocal() ? Http2Stream.State.RESERVED_LOCAL : Http2Stream.State.RESERVED_REMOTE;
                    checkNewStreamAllowed(i, state);
                    DefaultStream defaultStream = new DefaultStream(i, state);
                    incrementExpectedStreamId(i);
                    addStream(defaultStream);
                    return defaultStream;
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server push not allowed to opposite endpoint.", new Object[0]);
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Parent stream missing", new Object[0]);
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean allowPushTo() {
            return this.pushToAllowed;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream createStream(int i, boolean z) throws Http2Exception {
            DefaultStream createStream = createStream(i, DefaultHttp2Connection.activeState(i, Http2Stream.State.IDLE, isLocal(), z));
            createStream.activate();
            return createStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class DefaultPropertyKey implements Http2Connection.PropertyKey {
        final int index;

        DefaultPropertyKey(int i) {
            this.index = i;
        }

        DefaultPropertyKey verifyConnection(Http2Connection http2Connection) {
            if (http2Connection == DefaultHttp2Connection.this) {
                return this;
            }
            throw new IllegalArgumentException("Using a key that was not created by this connection");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class DefaultStream implements Http2Stream {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: id */
        private final int f40235id;
        private DefaultStream parent;
        private boolean resetSent;
        private Http2Stream.State state;
        private final PropertyMap properties = new PropertyMap();
        private short weight = 16;
        private IntObjectMap<DefaultStream> children = IntCollections.emptyMap();

        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        private class PropertyMap {
            Object[] values;

            private PropertyMap() {
                this.values = EmptyArrays.EMPTY_OBJECTS;
            }

            <V> V add(DefaultPropertyKey defaultPropertyKey, V v) {
                resizeIfNecessary(defaultPropertyKey.index);
                Object[] objArr = this.values;
                int i = defaultPropertyKey.index;
                V v2 = (V) objArr[i];
                objArr[i] = v;
                return v2;
            }

            <V> V get(DefaultPropertyKey defaultPropertyKey) {
                int i = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i >= objArr.length) {
                    return null;
                }
                return (V) objArr[i];
            }

            <V> V remove(DefaultPropertyKey defaultPropertyKey) {
                int i = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i < objArr.length) {
                    V v = (V) objArr[i];
                    objArr[i] = null;
                    return v;
                }
                return null;
            }

            void resizeIfNecessary(int i) {
                Object[] objArr = this.values;
                if (i >= objArr.length) {
                    this.values = Arrays.copyOf(objArr, DefaultHttp2Connection.this.propertyKeyRegistry.size());
                }
            }
        }

        DefaultStream(int i, Http2Stream.State state) {
            this.f40235id = i;
            this.state = state;
        }

        private void initChildren() {
            this.children = new IntObjectHashMap(DefaultHttp2Connection.INITIAL_CHILDREN_MAP_SIZE);
        }

        private void initChildrenIfEmpty() {
            if (this.children == IntCollections.emptyMap()) {
                initChildren();
            }
        }

        private IntObjectMap<DefaultStream> retain(DefaultStream defaultStream) {
            DefaultStream remove = this.children.remove(defaultStream.mo12684id());
            IntObjectMap<DefaultStream> intObjectMap = this.children;
            initChildren();
            if (remove != null) {
                this.children.put(remove.mo12684id(), (int) remove);
            }
            return intObjectMap;
        }

        void activate() {
            DefaultHttp2Connection.this.activeStreams.activate(this);
        }

        Http2Stream close(Iterator<?> it) {
            Http2Stream.State state = this.state;
            Http2Stream.State state2 = Http2Stream.State.CLOSED;
            if (state == state2) {
                return this;
            }
            this.state = state2;
            DefaultEndpoint<? extends Http2FlowController> createdBy = createdBy();
            createdBy.numStreams--;
            DefaultHttp2Connection.this.activeStreams.deactivate(this, it);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            int i = C138363.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i == 4) {
                this.state = Http2Stream.State.HALF_CLOSED_LOCAL;
                DefaultHttp2Connection.this.notifyHalfClosed(this);
            } else if (i != 5) {
                close();
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            int i = C138363.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i == 4) {
                this.state = Http2Stream.State.HALF_CLOSED_REMOTE;
                DefaultHttp2Connection.this.notifyHalfClosed(this);
            } else if (i != 6) {
                close();
            }
            return this;
        }

        DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.f40235id) ? DefaultHttp2Connection.this.localEndpoint : DefaultHttp2Connection.this.remoteEndpoint;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream forEachChild(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
            for (DefaultStream defaultStream : this.children.values()) {
                if (!http2StreamVisitor.visit(defaultStream)) {
                    return defaultStream;
                }
            }
            return null;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V getProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.get(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        /* renamed from: id */
        public final int mo12684id() {
            return this.f40235id;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final boolean isDescendantOf(Http2Stream http2Stream) {
            for (Http2Stream parent = parent(); parent != null; parent = parent.parent()) {
                if (parent == http2Stream) {
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final boolean isLeaf() {
            return numChildren() == 0;
        }

        final boolean isLocal() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.f40235id);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return this.resetSent;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final boolean isRoot() {
            return this.parent == null;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final int numChildren() {
            return this.children.size();
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z) throws Http2Exception {
            this.state = DefaultHttp2Connection.activeState(this.f40235id, this.state, isLocal(), z);
            if (createdBy().canOpenStream()) {
                activate();
                return this;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Maximum active streams violated for this endpoint.", new Object[0]);
        }

        final boolean removeChild(DefaultStream defaultStream) {
            if (this.children.remove(defaultStream.mo12684id()) != null) {
                ArrayList arrayList = new ArrayList(defaultStream.numChildren() + 1);
                arrayList.add(new ParentChangedEvent(defaultStream, defaultStream.parent()));
                DefaultHttp2Connection.this.notifyParentChanging(defaultStream, null);
                defaultStream.parent = null;
                for (DefaultStream defaultStream2 : defaultStream.children.values()) {
                    takeChild(defaultStream2, false, arrayList);
                }
                DefaultHttp2Connection.this.notifyParentChanged(arrayList);
                return true;
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V removeProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.remove(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            this.resetSent = true;
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream setPriority(int i, short s, boolean z) throws Http2Exception {
            ArrayList arrayList;
            if (s >= 1 && s <= 256) {
                DefaultStream defaultStream = (DefaultStream) DefaultHttp2Connection.this.stream(i);
                if (defaultStream == null) {
                    defaultStream = createdBy().createIdleStream(i);
                } else if (this == defaultStream) {
                    throw new IllegalArgumentException("A stream cannot depend on itself");
                }
                weight(s);
                if (defaultStream != parent() || (z && defaultStream.numChildren() != 1)) {
                    if (defaultStream.isDescendantOf(this)) {
                        arrayList = new ArrayList((z ? defaultStream.numChildren() : 0) + 2);
                        this.parent.takeChild(defaultStream, false, arrayList);
                    } else {
                        arrayList = new ArrayList((z ? defaultStream.numChildren() : 0) + 1);
                    }
                    defaultStream.takeChild(this, z, arrayList);
                    DefaultHttp2Connection.this.notifyParentChanged(arrayList);
                }
                return this;
            }
            throw new IllegalArgumentException(String.format("Invalid weight: %d.  Must be between %d and %d (inclusive).", Short.valueOf(s), (short) 1, Short.valueOf((short) Http2CodecUtil.MAX_WEIGHT)));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v) {
            return (V) this.properties.add(DefaultHttp2Connection.this.verifyKey(propertyKey), v);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final Http2Stream.State state() {
            return this.state;
        }

        final void takeChild(DefaultStream defaultStream, boolean z, List<ParentChangedEvent> list) {
            DefaultStream parent = defaultStream.parent();
            if (parent != this) {
                list.add(new ParentChangedEvent(defaultStream, parent));
                DefaultHttp2Connection.this.notifyParentChanging(defaultStream, this);
                defaultStream.parent = this;
                if (parent != null) {
                    parent.children.remove(defaultStream.mo12684id());
                }
                initChildrenIfEmpty();
                this.children.put(defaultStream.mo12684id(), (int) defaultStream);
            }
            if (!z || this.children.isEmpty()) {
                return;
            }
            for (DefaultStream defaultStream2 : retain(defaultStream).values()) {
                defaultStream.takeChild(defaultStream2, false, list);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final short weight() {
            return this.weight;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final DefaultStream parent() {
            return this.parent;
        }

        final void weight(short s) {
            short s2 = this.weight;
            if (s != s2) {
                this.weight = s;
                for (int i = 0; i < DefaultHttp2Connection.this.listeners.size(); i++) {
                    try {
                        DefaultHttp2Connection.this.listeners.get(i).onWeightChanged(this, s2);
                    } catch (Throwable th) {
                        DefaultHttp2Connection.logger.error("Caught Throwable from listener onWeightChanged.", th);
                    }
                }
            }
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            return close(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface Event {
        void process();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class ParentChangedEvent {
        private final Http2Stream oldParent;
        private final Http2Stream stream;

        ParentChangedEvent(Http2Stream http2Stream, Http2Stream http2Stream2) {
            this.stream = http2Stream;
            this.oldParent = http2Stream2;
        }

        public void notifyListener(Http2Connection.Listener listener) {
            try {
                listener.onPriorityTreeParentChanged(this.stream, this.oldParent);
            } catch (Throwable th) {
                DefaultHttp2Connection.logger.error("Caught Throwable from listener onPriorityTreeParentChanged.", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class PropertyKeyRegistry {
        final List<DefaultPropertyKey> keys;

        private PropertyKeyRegistry() {
            this.keys = new ArrayList(4);
        }

        DefaultPropertyKey newKey() {
            DefaultPropertyKey defaultPropertyKey = new DefaultPropertyKey(this.keys.size());
            this.keys.add(defaultPropertyKey);
            return defaultPropertyKey;
        }

        int size() {
            return this.keys.size();
        }
    }

    public DefaultHttp2Connection(boolean z) {
        IntObjectHashMap intObjectHashMap = new IntObjectHashMap();
        this.streamMap = intObjectHashMap;
        this.propertyKeyRegistry = new PropertyKeyRegistry();
        ConnectionStream connectionStream = new ConnectionStream();
        this.connectionStream = connectionStream;
        ArrayList arrayList = new ArrayList(4);
        this.listeners = arrayList;
        this.activeStreams = new ActiveStreams(arrayList);
        this.localEndpoint = new DefaultEndpoint<>(z);
        this.remoteEndpoint = new DefaultEndpoint<>(!z);
        intObjectHashMap.put(connectionStream.mo12684id(), (int) connectionStream);
    }

    static Http2Stream.State activeState(int i, Http2Stream.State state, boolean z, boolean z2) throws Http2Exception {
        int i2 = C138363.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[state.ordinal()];
        if (i2 == 1) {
            return z2 ? z ? Http2Stream.State.HALF_CLOSED_LOCAL : Http2Stream.State.HALF_CLOSED_REMOTE : Http2Stream.State.OPEN;
        } else if (i2 != 2) {
            if (i2 == 3) {
                return Http2Stream.State.HALF_CLOSED_LOCAL;
            }
            Http2Error http2Error = Http2Error.PROTOCOL_ERROR;
            throw Http2Exception.streamError(i, http2Error, "Attempting to open a stream in an invalid state: " + state, new Object[0]);
        } else {
            return Http2Stream.State.HALF_CLOSED_REMOTE;
        }
    }

    private boolean isStreamMapEmpty() {
        return this.streamMap.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParentChanged(List<ParentChangedEvent> list) {
        for (int i = 0; i < list.size(); i++) {
            ParentChangedEvent parentChangedEvent = list.get(i);
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                parentChangedEvent.notifyListener(this.listeners.get(i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParentChanging(Http2Stream http2Stream, Http2Stream http2Stream2) {
        for (int i = 0; i < this.listeners.size(); i++) {
            try {
                this.listeners.get(i).onPriorityTreeParentChanging(http2Stream, http2Stream2);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onPriorityTreeParentChanging.", th);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void addListener(Http2Connection.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Future<Void> close(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        Promise<Void> promise2 = this.closePromise;
        if (promise2 == null) {
            this.closePromise = promise;
        } else if (promise2 != promise) {
            if ((promise instanceof ChannelPromise) && ((ChannelPromise) promise2).isVoid()) {
                this.closePromise = promise;
            } else {
                this.closePromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new UnaryPromiseNotifier(promise));
            }
        }
        if (isStreamMapEmpty()) {
            promise.trySuccess(null);
            return promise;
        }
        Iterator<IntObjectMap.PrimitiveEntry<Http2Stream>> it = this.streamMap.entries().iterator();
        if (this.activeStreams.allowModifications()) {
            this.activeStreams.incrementPendingIterations();
            while (it.hasNext()) {
                try {
                    DefaultStream defaultStream = (DefaultStream) it.next().value();
                    if (defaultStream.mo12684id() != 0) {
                        defaultStream.close(it);
                    }
                } finally {
                    this.activeStreams.decrementPendingIterations();
                }
            }
        } else {
            while (it.hasNext()) {
                Http2Stream value = it.next().value();
                if (value.mo12684id() != 0) {
                    value.close();
                }
            }
        }
        return this.closePromise;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream connectionStream() {
        return this.connectionStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
        return this.activeStreams.forEachActiveStream(http2StreamVisitor);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwayReceived() {
        return ((DefaultEndpoint) this.localEndpoint).lastStreamKnownByPeer >= 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwaySent() {
        return ((DefaultEndpoint) this.remoteEndpoint).lastStreamKnownByPeer >= 0;
    }

    final boolean isClosed() {
        return this.closePromise != null;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean isServer() {
        return this.localEndpoint.isServer();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2LocalFlowController> local() {
        return this.localEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.PropertyKey newKey() {
        return this.propertyKeyRegistry.newKey();
    }

    void notifyClosed(Http2Stream http2Stream) {
        for (int i = 0; i < this.listeners.size(); i++) {
            try {
                this.listeners.get(i).onStreamClosed(http2Stream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamClosed.", th);
            }
        }
    }

    void notifyHalfClosed(Http2Stream http2Stream) {
        for (int i = 0; i < this.listeners.size(); i++) {
            try {
                this.listeners.get(i).onStreamHalfClosed(http2Stream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", th);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public int numActiveStreams() {
        return this.activeStreams.size();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2RemoteFlowController> remote() {
        return this.remoteEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void removeListener(Http2Connection.Listener listener) {
        this.listeners.remove(listener);
    }

    void removeStream(DefaultStream defaultStream, Iterator<?> it) {
        if (defaultStream.parent().removeChild(defaultStream)) {
            if (it == null) {
                this.streamMap.remove(defaultStream.mo12684id());
            } else {
                it.remove();
            }
            for (int i = 0; i < this.listeners.size(); i++) {
                try {
                    this.listeners.get(i).onStreamRemoved(defaultStream);
                } catch (Throwable th) {
                    logger.error("Caught Throwable from listener onStreamRemoved.", th);
                }
            }
            if (this.closePromise == null || !isStreamMapEmpty()) {
                return;
            }
            this.closePromise.trySuccess(null);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream stream(int i) {
        return this.streamMap.get(i);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean streamMayHaveExisted(int i) {
        return this.remoteEndpoint.mayHaveCreatedStream(i) || this.localEndpoint.mayHaveCreatedStream(i);
    }

    final DefaultPropertyKey verifyKey(Http2Connection.PropertyKey propertyKey) {
        return ((DefaultPropertyKey) ObjectUtil.checkNotNull((DefaultPropertyKey) propertyKey, DomainCampaignEx.LOOPBACK_KEY)).verifyConnection(this);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void goAwayReceived(final int i, long j, ByteBuf byteBuf) {
        this.localEndpoint.lastStreamKnownByPeer(i);
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            try {
                this.listeners.get(i2).onGoAwayReceived(i, j, byteBuf);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onGoAwayReceived.", th);
            }
        }
        try {
            forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.1
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) {
                    if (http2Stream.mo12684id() <= i || !DefaultHttp2Connection.this.localEndpoint.isValidStreamId(http2Stream.mo12684id())) {
                        return true;
                    }
                    http2Stream.close();
                    return true;
                }
            });
        } catch (Http2Exception e) {
            PlatformDependent.throwException(e);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void goAwaySent(final int i, long j, ByteBuf byteBuf) {
        this.remoteEndpoint.lastStreamKnownByPeer(i);
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            try {
                this.listeners.get(i2).onGoAwaySent(i, j, byteBuf);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onGoAwaySent.", th);
            }
        }
        try {
            forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.2
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) {
                    if (http2Stream.mo12684id() <= i || !DefaultHttp2Connection.this.remoteEndpoint.isValidStreamId(http2Stream.mo12684id())) {
                        return true;
                    }
                    http2Stream.close();
                    return true;
                }
            });
        } catch (Http2Exception e) {
            PlatformDependent.throwException(e);
        }
    }
}
