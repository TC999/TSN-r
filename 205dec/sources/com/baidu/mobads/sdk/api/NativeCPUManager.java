package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private ae mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CPUAdListener {
        void onAdError(String str, int i4);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i4, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            ae aeVar = new ae(context, str, this);
            this.mCPUAdProd = aeVar;
            aeVar.a(cPUAdListener);
            return;
        }
        bv.a().c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", br.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i4, int i5, boolean z3) {
        loadAd(i4, new int[]{i5}, z3);
    }

    public void openAppActivity(String str) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i4) {
        if (i4 > 0 && i4 <= 20) {
            this.mPageSize = i4;
        } else {
            bv.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i4) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i4);
        }
    }

    private void loadAd(int i4, int[] iArr, boolean z3) {
        if (i4 > 0 && iArr != null) {
            ae aeVar = this.mCPUAdProd;
            if (aeVar != null) {
                aeVar.a(i4, this.mPageSize, iArr, z3, this.mParams);
                this.mCPUAdProd.f();
                this.mCPUAdProd.a();
                return;
            }
            return;
        }
        bv.a().c(TAG, "LoadAd with terrible params!");
    }
}
