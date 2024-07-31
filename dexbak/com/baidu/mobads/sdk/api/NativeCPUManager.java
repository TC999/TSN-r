package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2585ae;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.EnumC2629bo;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private C2585ae mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface CPUAdListener {
        void onAdError(String str, int i);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            C2585ae c2585ae = new C2585ae(context, str, this);
            this.mCPUAdProd = c2585ae;
            c2585ae.m51037a(cPUAdListener);
            return;
        }
        C2634bs.m50744a().m50728c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", EnumC2629bo.INTERFACE_USE_PROBLEM.m50776b());
        }
    }

    public void loadAd(int i, int i2, boolean z) {
        loadAd(i, new int[]{i2}, z);
    }

    public void openAppActivity(String str) {
        C2585ae c2585ae = this.mCPUAdProd;
        if (c2585ae != null) {
            c2585ae.m51034a(str);
            this.mCPUAdProd.mo50356a();
        }
    }

    public void setPageSize(int i) {
        if (i > 0 && i <= 20) {
            this.mPageSize = i;
        } else {
            C2634bs.m50744a().m50728c(TAG, "Input page size is wrong which should be in (0,20]!");
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i) {
        C2585ae c2585ae = this.mCPUAdProd;
        if (c2585ae != null) {
            c2585ae.m51040a(i);
        }
    }

    private void loadAd(int i, int[] iArr, boolean z) {
        if (i > 0 && iArr != null) {
            C2585ae c2585ae = this.mCPUAdProd;
            if (c2585ae != null) {
                c2585ae.m51039a(i, this.mPageSize, iArr, z, this.mParams);
                this.mCPUAdProd.m51031f();
                this.mCPUAdProd.mo50356a();
                return;
            }
            return;
        }
        C2634bs.m50744a().m50728c(TAG, "LoadAd with terrible params!");
    }
}
