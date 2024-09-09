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
public class LocalDNSHosts {
    private static final String TAG = "BatchParseLocalDNSHosts";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    protected Handler mHandler;
    public String[] mHosts;
    public String mId;
    private boolean mRet = false;
    protected boolean mCancelled = false;
    protected AVMDLNetClient mNetClient = null;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNSHosts> mLocalDNSRef;

        public MyRunnable(LocalDNSHosts localDNSHosts) {
            this.mLocalDNSRef = new WeakReference<>(localDNSHosts);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVMDLLog.d(LocalDNSHosts.TAG, String.format("----implement delayed check for local dns", new Object[0]));
            LocalDNSHosts localDNSHosts = this.mLocalDNSRef.get();
            if (localDNSHosts == null) {
                AVMDLLog.d(LocalDNSHosts.TAG, String.format("****end implement delayed check for local dns, dns object null", new Object[0]));
            } else if (localDNSHosts.mRet) {
            } else {
                localDNSHosts.cancel();
                AVMDLLog.d(LocalDNSHosts.TAG, String.format("****end implement delayed check cancel local dns,", new Object[0]));
            }
        }
    }

    public LocalDNSHosts(String[] strArr, Handler handler) {
        this.mHosts = strArr;
        this.mHandler = handler;
    }

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

    public void close() {
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
            this.mFuture = null;
        }
    }

    public boolean isRunning() {
        return this.mRet;
    }

    public void start() {
        try {
            this.mFuture = AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.LocalDNSHosts.1
                @Override // java.lang.Runnable
                @SuppressLint({"CI_DefaultLocale"})
                public void run() {
                    AVMDLLog.d(LocalDNSHosts.TAG, "----call local dns batch parse");
                    int i4 = 0;
                    while (true) {
                        LocalDNSHosts localDNSHosts = LocalDNSHosts.this;
                        String[] strArr = localDNSHosts.mHosts;
                        if (i4 < strArr.length) {
                            if (!TextUtils.isEmpty(strArr[i4])) {
                                try {
                                    LocalDNSHosts localDNSHosts2 = LocalDNSHosts.this;
                                    localDNSHosts2.mAddress = InetAddress.getAllByName(localDNSHosts2.mHosts[i4]);
                                    String str = "";
                                    for (int i5 = 0; i5 < LocalDNSHosts.this.mAddress.length; i5++) {
                                        String hostAddress = LocalDNSHosts.this.mAddress[i5].getHostAddress();
                                        if (!TextUtils.isEmpty(hostAddress)) {
                                            str = TextUtils.isEmpty(str) ? str + hostAddress : str + "," + hostAddress;
                                        }
                                    }
                                    AVMDLLog.d(LocalDNSHosts.TAG, String.format("host:%s pasrse suc result:%s", LocalDNSHosts.this.mHosts[i4], str));
                                    if (!TextUtils.isEmpty(str)) {
                                        AVMDLLog.d(LocalDNSHosts.TAG, String.format("****default expiredtime:%d force expiredtime:%d ", Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                                        int i6 = AVMDLDNSParser.mGlobalForceExpiredTime;
                                        if (i6 <= 0) {
                                            i6 = AVMDLDNSParser.mGlobalDefaultExpiredTime;
                                        }
                                        IPCache.getInstance().put(LocalDNSHosts.this.mHosts[i4], new AVMDLDNSInfo(0, LocalDNSHosts.this.mHosts[i4], str, (i6 * 1000) + System.currentTimeMillis(), LocalDNSHosts.this.mId));
                                    }
                                } catch (Throwable th) {
                                    AVMDLLog.d(LocalDNSHosts.TAG, String.format("host:%s pasrse err:%s", LocalDNSHosts.this.mHosts[i4], th.getMessage()));
                                }
                            }
                            i4++;
                        } else {
                            localDNSHosts.mRet = true;
                            AVMDLLog.d(LocalDNSHosts.TAG, "****end call local dns batch parse");
                            return;
                        }
                    }
                }
            });
        } catch (Exception e4) {
            AVMDLLog.d(TAG, String.format("****end call local dns, exception:%s", e4));
        }
        this.mHandler.postDelayed(new MyRunnable(this), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
