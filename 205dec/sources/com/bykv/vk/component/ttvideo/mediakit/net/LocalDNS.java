package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public MyRunnable(LocalDNS localDNS) {
            this.mLocalDNSRef = new WeakReference<>(localDNS);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.d(LocalDNS.TAG, String.format("----implement delayed check for local dns", new Object[0]));
            LocalDNS localDNS = this.mLocalDNSRef.get();
            if (localDNS == null) {
                AVMDLLog.d(LocalDNS.TAG, String.format("****end implement delayed check for local dns, dns object null", new Object[0]));
            } else if (localDNS.mRet) {
            } else {
                localDNS.cancel();
                AVMDLLog.d(LocalDNS.TAG, String.format("****end implement delayed check cancel local dns,", new Object[0]));
                localDNS.notifyError(new AVMDLDNSInfo(0, localDNS.mHostname, (String) null, 0L, localDNS.mId));
            }
        }
    }

    public LocalDNS(String str, Handler handler) {
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
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.LocalDNS.1
                @Override // java.lang.Runnable
                public void run() {
                    AVMDLLog.d(LocalDNS.TAG, String.format("----call local dns, host:%s", LocalDNS.this.mHostname));
                    try {
                        LocalDNS localDNS = LocalDNS.this;
                        localDNS.mAddress = InetAddress.getAllByName(localDNS.mHostname);
                        LocalDNS.this.mRet = true;
                        if (LocalDNS.this.mAddress == null) {
                            AVMDLLog.d(LocalDNS.TAG, String.format("****end call local dns, not get address host:%s", LocalDNS.this.mHostname));
                            LocalDNS localDNS2 = LocalDNS.this;
                            localDNS2.notifyError(new AVMDLDNSInfo(0, localDNS2.mHostname, (String) null, 0L, localDNS2.mId));
                            return;
                        }
                        String str = "";
                        for (int i4 = 0; i4 < LocalDNS.this.mAddress.length; i4++) {
                            String hostAddress = LocalDNS.this.mAddress[i4].getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                str = TextUtils.isEmpty(str) ? str + hostAddress : str + "," + hostAddress;
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            AVMDLLog.d(LocalDNS.TAG, String.format("****end call local dns, iplist null host:%s", LocalDNS.this.mHostname));
                            LocalDNS localDNS3 = LocalDNS.this;
                            localDNS3.notifyError(new AVMDLDNSInfo(0, localDNS3.mHostname, (String) null, 0L, localDNS3.mId));
                            return;
                        }
                        AVMDLLog.d(LocalDNS.TAG, String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                        int i5 = AVMDLDNSParser.mGlobalForceExpiredTime;
                        if (i5 <= 0) {
                            i5 = AVMDLDNSParser.mGlobalDefaultExpiredTime;
                        }
                        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(0, LocalDNS.this.mHostname, str, (i5 * 1000) + System.currentTimeMillis(), LocalDNS.this.mId);
                        IPCache.getInstance().put(LocalDNS.this.mHostname, aVMDLDNSInfo);
                        LocalDNS.this.notifySuccess(aVMDLDNSInfo);
                        AVMDLLog.d(LocalDNS.TAG, String.format("****end call local dns, suc iplist:%s host:%s", str, LocalDNS.this.mHostname));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        LocalDNS.this.mRet = true;
                        AVMDLLog.d(LocalDNS.TAG, String.format("****end call local dns, end exception:%s host:%s", th, LocalDNS.this.mHostname));
                        LocalDNS localDNS4 = LocalDNS.this;
                        localDNS4.notifyError(new AVMDLDNSInfo(0, localDNS4.mHostname, (String) null, 0L, localDNS4.mId));
                    }
                }
            });
        } catch (Exception e4) {
            AVMDLLog.d(TAG, String.format("****end call local dns, exception:%s host:%s", e4, this.mHostname));
            notifyError(new AVMDLDNSInfo(0, this.mHostname, (String) null, 0L, this.mId));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
