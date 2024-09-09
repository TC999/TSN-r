package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BaseDNS {
    private static final String TAG = "BaseDNS";
    protected boolean mCancelled;
    protected Handler mHandler;
    public String mHostname;
    public String mId;
    protected DNSCompletionListener mListener;
    protected AVMDLNetClient mNetClient;

    public BaseDNS(String str, Handler handler) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = str;
        this.mHandler = handler;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public void cancel() {
    }

    public void close() {
    }

    public boolean isRunning() {
        return true;
    }

    protected void notifyCancelled() {
        this.mHandler.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyError(AVMDLDNSInfo aVMDLDNSInfo) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, aVMDLDNSInfo));
    }

    protected void notifyRetry(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, error));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySuccess(AVMDLDNSInfo aVMDLDNSInfo) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, aVMDLDNSInfo));
    }

    public void setCompletionListener(DNSCompletionListener dNSCompletionListener) {
        this.mListener = dNSCompletionListener;
    }

    public void start() {
    }

    public BaseDNS(String str, AVMDLNetClient aVMDLNetClient, Handler handler) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = str;
        this.mHandler = handler;
        this.mNetClient = aVMDLNetClient == null ? AVMDLDNSParser.getNetClient() : aVMDLNetClient;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }
}
