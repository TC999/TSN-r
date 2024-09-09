package com.bytedance.pangle.sdk.component.log.impl.track;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.net.IGetExecutor;
import com.bytedance.pangle.sdk.component.log.impl.net.INetResponse;
import com.bytedance.pangle.sdk.component.log.impl.net.TTRunnable;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TrackAdUrlImpl implements TrackAdUrl {
    private static final int MAX_RETRY_COUNT = 5;
    private static final String TAG = "trackurl";
    private static final int TIME_OUT = 10000;
    private final Context mContext;
    private final TrackRetryRepertory mRetryRepertory;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class AdsStats extends TTRunnable {
        private final String mDid;
        private final TrackInfo mTrackInfo;

        private String replaceCommonParams(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains(AdScopeTrackerTool.ts)) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace(AdScopeTrackerTool.ts, String.valueOf(currentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.mDid)) ? str.replace("{UID}", this.mDid).replace("__UID__", this.mDid) : str;
        }

        String handleAdClickTrackUrl(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(TrackAdUrlImpl.access$300().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e4) {
                e4.printStackTrace();
                return str;
            }
        }

        boolean isHttpUrl(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE));
        }

        @Override // java.lang.Runnable
        public void run() {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || !adLogDepend.canUseSDK() || !isHttpUrl(this.mTrackInfo.getUrl())) {
                return;
            }
            if (this.mTrackInfo.getRetryCount() == 0) {
                TrackAdUrlImpl.this.mRetryRepertory.delete(this.mTrackInfo);
                return;
            }
            while (this.mTrackInfo.getRetryCount() > 0) {
                try {
                    adLogDepend.upDateDBAdEventTime();
                    if (this.mTrackInfo.getRetryCount() == 5) {
                        TrackAdUrlImpl.this.mRetryRepertory.insert(this.mTrackInfo);
                    }
                } catch (Throwable unused) {
                }
                if (!adLogDepend.isAvailableNet(TrackAdUrlImpl.this.getContext())) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                String url = this.mTrackInfo.getUrl();
                if (adLogDepend.sdkType() == 0) {
                    url = replaceCommonParams(this.mTrackInfo.getUrl());
                    if (this.mTrackInfo.isReplaceHolder()) {
                        url = handleAdClickTrackUrl(url);
                    }
                }
                IGetExecutor providerGetExecutor = adLogDepend.providerGetExecutor();
                if (providerGetExecutor == null) {
                    return;
                }
                providerGetExecutor.addHeader("User-Agent", adLogDepend.getWebViewUA());
                providerGetExecutor.setUrl(url);
                INetResponse iNetResponse = null;
                try {
                    iNetResponse = providerGetExecutor.execute();
                    adLogDepend.upDateDBAdEvent(iNetResponse.isSuccess());
                } catch (Throwable unused2) {
                }
                if (iNetResponse != null && iNetResponse.isSuccess()) {
                    TrackAdUrlImpl.this.mRetryRepertory.delete(this.mTrackInfo);
                    LDebug.d(TrackAdUrlImpl.TAG, "track success : " + this.mTrackInfo.getUrl());
                    adLogDepend.upDateNetAdEvent(true, 200, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                LDebug.d(TrackAdUrlImpl.TAG, "track fail : " + this.mTrackInfo.getUrl());
                TrackInfo trackInfo = this.mTrackInfo;
                trackInfo.setRetryCount(trackInfo.getRetryCount() - 1);
                if (this.mTrackInfo.getRetryCount() == 0) {
                    TrackAdUrlImpl.this.mRetryRepertory.delete(this.mTrackInfo);
                    LDebug.d(TrackAdUrlImpl.TAG, "track fail and delete : " + this.mTrackInfo.getUrl());
                    return;
                }
                TrackAdUrlImpl.this.mRetryRepertory.update(this.mTrackInfo);
                if (iNetResponse != null) {
                    adLogDepend.upDateNetAdEvent(false, iNetResponse.getCode(), System.currentTimeMillis());
                } else {
                    adLogDepend.upDateNetAdEvent(false, 0, System.currentTimeMillis());
                }
            }
        }

        private AdsStats(TrackInfo trackInfo, String str) {
            super("AdsStats");
            this.mTrackInfo = trackInfo;
            this.mDid = str;
        }
    }

    public TrackAdUrlImpl(Context context, TrackRetryRepertory trackRetryRepertory) {
        this.mContext = context;
        this.mRetryRepertory = trackRetryRepertory;
    }

    static /* synthetic */ Random access$300() {
        return getRandomInstance();
    }

    private static Random getRandomInstance() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    public Context getContext() {
        Context context = this.mContext;
        return context == null ? LogInternalManager.getInstance().getContext() : context;
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackAdUrl
    public void stop() {
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackAdUrl
    public void track(String str, List<String> list, boolean z3) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || adLogDepend.providerLogExecutor() == null || !adLogDepend.canUseSDK() || list == null || list.size() == 0) {
            return;
        }
        for (String str2 : list) {
            adLogDepend.providerLogExecutor().execute(new AdsStats(new TrackInfo(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str2, z3, 5), str));
        }
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.track.TrackAdUrl
    public void trackFailedUrls(final String str) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || LogInternalManager.getInstance().getContext() == null || !adLogDepend.canUseSDK()) {
            return;
        }
        TTRunnable tTRunnable = new TTRunnable("trackFailedUrls") { // from class: com.bytedance.pangle.sdk.component.log.impl.track.TrackAdUrlImpl.1
            @Override // java.lang.Runnable
            public void run() {
                TrackAdUrlImpl.this.trackFailedUrls(TrackAdUrlImpl.this.mRetryRepertory.queryAll(), str);
            }
        };
        tTRunnable.setPriority(1);
        if (adLogDepend.providerLogExecutor() != null) {
            adLogDepend.providerLogExecutor().execute(tTRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFailedUrls(List<TrackInfo> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        for (TrackInfo trackInfo : list) {
            if (adLogDepend != null && adLogDepend.providerLogExecutor() != null) {
                adLogDepend.providerLogExecutor().execute(new AdsStats(trackInfo, str));
            }
        }
    }
}
