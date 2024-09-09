package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteSelector;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode;
import com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    private Socket deallocate(boolean z3, boolean z4, boolean z5) {
        Socket socket;
        if (z5) {
            this.codec = null;
        }
        if (z4) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z3) {
                realConnection.noNewStreams = true;
            }
            if (this.codec == null) {
                if (this.released || realConnection.noNewStreams) {
                    release(realConnection);
                    if (this.connection.allocations.isEmpty()) {
                        this.connection.idleAtNanos = System.nanoTime();
                        if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                            socket = this.connection.socket();
                            this.connection = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.connection = null;
                    return socket;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private RealConnection findConnection(int i4, int i5, int i6, int i7, boolean z3) throws IOException {
        RealConnection realConnection;
        Socket releaseIfNoNewStreams;
        RealConnection realConnection2;
        Socket socket;
        Route route;
        boolean z4;
        boolean z5;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (!this.released) {
                if (this.codec == null) {
                    if (!this.canceled) {
                        realConnection = this.connection;
                        releaseIfNoNewStreams = releaseIfNoNewStreams();
                        realConnection2 = this.connection;
                        socket = null;
                        if (realConnection2 != null) {
                            realConnection = null;
                        } else {
                            realConnection2 = null;
                        }
                        if (!this.reportedAcquired) {
                            realConnection = null;
                        }
                        if (realConnection2 == null) {
                            Internal.instance.get(this.connectionPool, this.address, this, null);
                            RealConnection realConnection3 = this.connection;
                            if (realConnection3 != null) {
                                realConnection2 = realConnection3;
                                z4 = true;
                                route = null;
                            } else {
                                route = this.route;
                            }
                        } else {
                            route = null;
                        }
                        z4 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        Util.closeQuietly(releaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z4) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            this.route = this.connection.route();
            return realConnection2;
        }
        if (route != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z5 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z5 = true;
        }
        synchronized (this.connectionPool) {
            if (this.canceled) {
                throw new IOException("Canceled");
            }
            if (z5) {
                List<Route> all = this.routeSelection.getAll();
                int size = all.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size) {
                        break;
                    }
                    Route route2 = all.get(i8);
                    Internal.instance.get(this.connectionPool, this.address, this, route2);
                    RealConnection realConnection4 = this.connection;
                    if (realConnection4 != null) {
                        this.route = route2;
                        realConnection2 = realConnection4;
                        z4 = true;
                        break;
                    }
                    i8++;
                }
            }
            if (!z4) {
                if (route == null) {
                    route = this.routeSelection.next();
                }
                this.route = route;
                this.refusedStreamCount = 0;
                realConnection2 = new RealConnection(this.connectionPool, route);
                acquire(realConnection2, false);
            }
        }
        if (z4) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i4, i5, i6, i7, z3, this.call, this.eventListener);
        routeDatabase().connected(realConnection2.route());
        synchronized (this.connectionPool) {
            this.reportedAcquired = true;
            Internal.instance.put(this.connectionPool, realConnection2);
            if (realConnection2.isMultiplexed()) {
                socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                realConnection2 = this.connection;
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    private RealConnection findHealthyConnection(int i4, int i5, int i6, int i7, boolean z3, boolean z4) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i4, i5, i6, i7, z3);
            synchronized (this.connectionPool) {
                if (findConnection.successCount == 0 && !findConnection.isMultiplexed()) {
                    return findConnection;
                }
                if (findConnection.isHealthy(z4)) {
                    return findConnection;
                }
                noNewStreams();
            }
        }
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection, boolean z3) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z3;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        RouteSelector.Selection selection;
        return this.route != null || ((selection = this.routeSelection) != null && selection.hasNext()) || this.routeSelector.hasNext();
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z3) {
        try {
            HttpCodec newCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z3).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = newCodec;
            }
            return newCodec;
        } catch (IOException e4) {
            throw new RouteException(e4);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(this.connection.allocations.get(0));
            return deallocate;
        }
        throw new IllegalStateException();
    }

    public Route route() {
        return this.route;
    }

    public void streamFailed(IOException iOException) {
        RealConnection realConnection;
        boolean z3;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = null;
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i4 = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i4;
                    if (i4 > 1) {
                        this.route = null;
                        z3 = true;
                    }
                    z3 = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.route = null;
                        z3 = true;
                    }
                    z3 = false;
                }
            } else {
                RealConnection realConnection2 = this.connection;
                if (realConnection2 != null && (!realConnection2.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.connection.successCount == 0) {
                        Route route = this.route;
                        if (route != null && iOException != null) {
                            this.routeSelector.connectFailed(route, iOException);
                        }
                        this.route = null;
                    }
                    z3 = true;
                }
                z3 = false;
            }
            RealConnection realConnection3 = this.connection;
            deallocate = deallocate(z3, false, true);
            if (this.connection == null && this.reportedAcquired) {
                realConnection = realConnection3;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void streamFinished(boolean z3, HttpCodec httpCodec, long j4, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z4;
        this.eventListener.responseBodyEnd(this.call, j4);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                if (httpCodec == this.codec) {
                    if (!z3) {
                        this.connection.successCount++;
                    }
                    realConnection = this.connection;
                    deallocate = deallocate(z3, false, true);
                    if (this.connection != null) {
                        realConnection = null;
                    }
                    z4 = this.released;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z4) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.address.toString();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (realConnection.allocations.get(i4).get() == this) {
                realConnection.allocations.remove(i4);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
