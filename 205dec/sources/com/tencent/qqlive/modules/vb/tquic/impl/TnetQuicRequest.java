package com.tencent.qqlive.modules.vb.tquic.impl;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class TnetQuicRequest {
    private final Callback mCallback;
    private long mTnetQuicAdapter;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static abstract class Callback {
        public abstract void onClose(int i4, String str) throws Exception;

        public abstract void onComplete(int i4) throws Exception;

        public abstract void onConnect(int i4) throws Exception;

        public abstract void onDataRecv(byte[] bArr) throws Exception;

        public abstract void onHeaderRecv(String str) throws Exception;

        public abstract void onNetworkLinked() throws Exception;
    }

    public TnetQuicRequest(Callback callback, TnetConfig tnetConfig, int i4) {
        this.mCallback = callback;
        try {
            this.mTnetQuicAdapter = nativeCreateTnetQuicAdapter(tnetConfig, i4);
        } catch (RuntimeException e4) {
            throw e4;
        }
    }

    private native void nativeAddHeaders(long j4, String str, String str2);

    private native void nativeCancelRequest(long j4);

    private native void nativeConnect(long j4, String str, String str2);

    private native long nativeCreateTnetQuicAdapter(TnetConfig tnetConfig, int i4);

    private native void nativeDestroy(long j4);

    private native void nativeGetTnetStates(long j4, TnetStats tnetStats);

    private native boolean nativeIsConnectCompleted(long j4);

    private native boolean nativeRequestFinished(long j4);

    private native boolean nativeSendRequest(long j4, byte[] bArr, int i4, boolean z3);

    private native void nativeSetExpid(int i4);

    private void onClose(int i4, String str) {
        try {
            this.mCallback.onClose(i4, str);
        } catch (Exception unused) {
        }
    }

    private void onComplete(int i4) {
        try {
            this.mCallback.onComplete(i4);
        } catch (Exception unused) {
        }
    }

    private void onConnect(int i4) {
        try {
            this.mCallback.onConnect(i4);
        } catch (Exception unused) {
        }
    }

    private void onDataRecv(byte[] bArr) {
        try {
            this.mCallback.onDataRecv(bArr);
        } catch (Exception unused) {
        }
    }

    private void onNetworkLinked() {
        try {
            this.mCallback.onNetworkLinked();
        } catch (Exception unused) {
        }
    }

    public void addHeaders(String str, String str2) {
        nativeAddHeaders(this.mTnetQuicAdapter, str, str2);
    }

    public void cancelRequest() {
        nativeCancelRequest(this.mTnetQuicAdapter);
    }

    public void connect(String str, String str2) {
        nativeConnect(this.mTnetQuicAdapter, str, str2);
    }

    public void destroy() {
        nativeDestroy(this.mTnetQuicAdapter);
    }

    public void getTnetStates(TnetStats tnetStats) {
        nativeGetTnetStates(this.mTnetQuicAdapter, tnetStats);
    }

    public boolean isConnectCompleted() {
        return nativeIsConnectCompleted(this.mTnetQuicAdapter);
    }

    public boolean isRequestFinished() {
        return nativeRequestFinished(this.mTnetQuicAdapter);
    }

    public boolean sendRequest(byte[] bArr, int i4, boolean z3) {
        return nativeSendRequest(this.mTnetQuicAdapter, bArr, i4, z3);
    }

    public void setExpId(int i4) {
        nativeSetExpid(i4);
    }
}
