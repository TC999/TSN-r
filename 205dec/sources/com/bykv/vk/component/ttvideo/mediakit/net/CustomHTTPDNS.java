package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class CustomHTTPDNS extends BaseDNS {
    private static final String TAG = "CustomHTTPDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class MyRunnable implements Runnable {
        private final WeakReference<CustomHTTPDNS> mCustomHTTPDNSRef;

        public MyRunnable(CustomHTTPDNS customHTTPDNS) {
            this.mCustomHTTPDNSRef = new WeakReference<>(customHTTPDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.d(CustomHTTPDNS.TAG, String.format("----implement delayed check for custom httpdns", new Object[0]));
            CustomHTTPDNS customHTTPDNS = this.mCustomHTTPDNSRef.get();
            if (customHTTPDNS == null) {
                AVMDLLog.d(CustomHTTPDNS.TAG, String.format("****end implement delayed check for custom httpdns, dns object null", new Object[0]));
            } else if (customHTTPDNS.mRet) {
            } else {
                customHTTPDNS.cancel();
                AVMDLLog.d(CustomHTTPDNS.TAG, String.format("****end implement delayed check cancel custom httpdns,", new Object[0]));
                customHTTPDNS.notifyError(new AVMDLDNSInfo(4, customHTTPDNS.mHostname, (String) null, 0L, customHTTPDNS.mId));
            }
        }
    }

    public CustomHTTPDNS(String str, Handler handler) {
        super(str, handler);
        this.mRet = false;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void close() {
        super.close();
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.CustomHTTPDNS.1
                @Override // java.lang.Runnable
                @SuppressLint({"CI_DefaultLocale"})
                public void run() {
                    Object[] objArr = new Object[2];
                    objArr[0] = CustomHTTPDNS.this.mHostname;
                    objArr[1] = Integer.valueOf(AVMDLDNSParser.mCustomHttpDNSParser == null ? 0 : 1);
                    AVMDLLog.d(CustomHTTPDNS.TAG, String.format("----call custom httpdns, host:%s custom parser:%d", objArr));
                    AVMDLCustomHTTPDNSParser aVMDLCustomHTTPDNSParser = AVMDLDNSParser.mCustomHttpDNSParser;
                    AVMDLCustomHTTPDNSParserResult parseHost = aVMDLCustomHTTPDNSParser != null ? aVMDLCustomHTTPDNSParser.parseHost(CustomHTTPDNS.this.mHostname) : null;
                    CustomHTTPDNS.this.mRet = true;
                    if (parseHost != null && !TextUtils.isEmpty(parseHost.mIPList)) {
                        AVMDLLog.d(CustomHTTPDNS.TAG, String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                        int i4 = AVMDLDNSParser.mGlobalForceExpiredTime;
                        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(4, CustomHTTPDNS.this.mHostname, parseHost.mIPList, System.currentTimeMillis() + ((i4 > 0 ? i4 : parseHost.mTTL) * 1000), CustomHTTPDNS.this.mId);
                        IPCache.getInstance().put(CustomHTTPDNS.this.mHostname, aVMDLDNSInfo);
                        CustomHTTPDNS.this.notifySuccess(aVMDLDNSInfo);
                        AVMDLLog.d(CustomHTTPDNS.TAG, String.format("****end call custom httpdns, suc iplist:%s host:%s", parseHost.mIPList, CustomHTTPDNS.this.mHostname));
                        return;
                    }
                    AVMDLLog.d(CustomHTTPDNS.TAG, String.format("****end call custom httpdns, result null or iplist null host:%s", CustomHTTPDNS.this.mHostname));
                    CustomHTTPDNS customHTTPDNS = CustomHTTPDNS.this;
                    customHTTPDNS.notifyError(new AVMDLDNSInfo(4, customHTTPDNS.mHostname, (String) null, 0L, customHTTPDNS.mId));
                }
            });
        } catch (Exception e4) {
            AVMDLLog.d(TAG, String.format("****end call custom httpdns, exception:%s host:%s", e4, this.mHostname));
            notifyError(new AVMDLDNSInfo(4, this.mHostname, (String) null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
