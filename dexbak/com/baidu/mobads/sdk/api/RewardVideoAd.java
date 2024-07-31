package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2607aw;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2701ds;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private C2701ds mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        void onRewardVerify(boolean z);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50470a(true, str);
        }
    }

    public Object getAdDataForKey(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            return c2701ds.m50462k(str);
        }
        return null;
    }

    public String getBiddingToken() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            return c2701ds.m50806m();
        }
        return null;
    }

    public String getECPMLevel() {
        C2701ds c2701ds = this.mAdProd;
        return c2701ds != null ? c2701ds.m50464h() : "";
    }

    public boolean isReady() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            return c2701ds.m50466g();
        }
        return false;
    }

    public synchronized void load() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.mo50356a();
        }
    }

    public void loadBiddingAd(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50811c(str);
        }
    }

    public void setAppSid(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50809h(str);
        }
    }

    public void setBidFloor(int i) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.f8671p = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50814b(str);
        }
    }

    public void setDownloadAppConfirmPolicy(int i) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50476a(i);
        }
    }

    public void setExtraInfo(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50463j(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        C2701ds c2701ds;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (c2701ds = this.mAdProd) == null) {
            return;
        }
        c2701ds.m50474a(requestParameters);
    }

    public void setShowDialogOnSkip(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z);
                this.mAdProd.m50819a(jSONObject);
            } catch (Throwable th) {
                C2634bs.m50744a().m50729c(th);
            }
        }
    }

    public void setUserId(String str) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50472a(str);
        }
    }

    public synchronized void show() {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50467f();
        }
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        this.mContext = context;
        C2701ds c2701ds = new C2701ds(context, str, z);
        this.mAdProd = c2701ds;
        c2701ds.mo50473a(rewardVideoAdListener);
        if (TextUtils.isEmpty(str)) {
            C2607aw.m50919c().mo50864e("RewardVideoAd初始化异常：广告位为空");
        }
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50469a(false, str, hashMap);
        }
    }

    public synchronized void show(Context context) {
        C2701ds c2701ds = this.mAdProd;
        if (c2701ds != null) {
            c2701ds.m50475a(context);
        }
    }
}
