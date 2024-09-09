package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.cache.CacheInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.http.BridgeInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.http.CallServerInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.http.RealInterceptorChain;
import com.mbridge.msdk.thrid.okhttp.internal.http.RetryAndFollowUpInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.AsyncTimeout;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class RealCall implements Call {
    final OkHttpClient client;
    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        protected void execute() {
            Throwable th;
            boolean z3;
            IOException e4;
            RealCall.this.timeout.enter();
            try {
                try {
                    z3 = true;
                } catch (IOException e5) {
                    e4 = e5;
                    z3 = false;
                } catch (Throwable th2) {
                    th = th2;
                    z3 = false;
                }
                try {
                    this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                } catch (IOException e6) {
                    e4 = e6;
                    IOException timeoutExit = RealCall.this.timeoutExit(e4);
                    if (z3) {
                        Platform platform = Platform.get();
                        platform.log(4, "Callback failure for " + RealCall.this.toLoggableString(), timeoutExit);
                    } else {
                        RealCall.this.eventListener.callFailed(RealCall.this, timeoutExit);
                        this.responseCallback.onFailure(RealCall.this, timeoutExit);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    RealCall.this.cancel();
                    if (!z3) {
                        this.responseCallback.onFailure(RealCall.this, new IOException("canceled due to " + th));
                    }
                    throw th;
                }
            } finally {
                RealCall.this.client.dispatcher().finished(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e4) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e4);
                    RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z3) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z3;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z3);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: com.mbridge.msdk.thrid.okhttp.RealCall.1
            @Override // com.mbridge.msdk.thrid.okio.AsyncTimeout
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z3) {
        RealCall realCall = new RealCall(okHttpClient, request, z3);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain != null) {
                    return responseWithInterceptorChain;
                }
                throw new IOException("Canceled");
            } catch (IOException e4) {
                IOException timeoutExit = timeoutExit(e4);
                this.eventListener.callFailed(this, timeoutExit);
                throw timeoutExit;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Response proceed = new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (this.retryAndFollowUpInterceptor.isCanceled()) {
            Util.closeQuietly(proceed);
            throw new IOException("Canceled");
        }
        return proceed;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public Request request() {
        return this.originalRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    public Timeout timeout() {
        return this.timeout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IOException timeoutExit(@Nullable IOException iOException) {
        if (this.timeout.exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return iOException;
    }

    String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.Call
    /* renamed from: clone */
    public RealCall m98clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
