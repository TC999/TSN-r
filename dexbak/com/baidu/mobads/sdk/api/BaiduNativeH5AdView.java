package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.C2603as;
import com.baidu.mobads.sdk.internal.C2691di;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement mAdPlacement;
    private C2691di mAdProd;
    private BaiduNativeH5EventListner mAdViewListener;
    private RequestParameters mRequestParameters;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    public BaiduNativeH5AdView(Context context, int i) {
        super(context);
        this.mAdViewListener = null;
        initView(context, i);
    }

    private void cancel() {
    }

    @SuppressLint({"NewApi"})
    private void initView(Context context, int i) {
        if (i != 0) {
            setBackgroundResource(i);
        }
    }

    private void onDetach() {
        cancel();
        C2691di c2691di = this.mAdProd;
        if (c2691di != null) {
            c2691di.m50810e();
        }
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.mAdPlacement;
    }

    public boolean isAdDataLoaded() {
        C2691di c2691di = this.mAdProd;
        if (c2691di != null) {
            return c2691di.m50527g();
        }
        return false;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.mRequestParameters = requestParameters;
        if (this.mAdProd != null) {
            onDetach();
        }
        C2691di c2691di = new C2691di(getContext(), "feed", this);
        this.mAdProd = c2691di;
        c2691di.m50532a(requestParameters);
        this.mAdProd.m50534a(this.mAdPlacement);
        this.mAdProd.m50535a(this.mAdPlacement.getSessionId());
        this.mAdProd.m50531c(this.mAdPlacement.getPosistionId());
        this.mAdProd.m50529d(this.mAdPlacement.getSequenceId());
        BaiduNativeH5EventListner baiduNativeH5EventListner = this.mAdViewListener;
        if (baiduNativeH5EventListner != null) {
            this.mAdProd.m50533a(baiduNativeH5EventListner);
        }
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement != null) {
            if (baiduNativeAdPlacement.hasValidResponse()) {
                if (this.mAdProd.m50528f()) {
                    return;
                }
            } else {
                this.mAdProd.m50530c(false);
                if (this.mAdPlacement.getRequestStarted()) {
                    return;
                }
                this.mAdPlacement.setRequestStarted(true);
            }
        }
        this.mAdProd.mo50356a();
    }

    public void recordImpression() {
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement == null || baiduNativeAdPlacement.getResponse() == null || this.mAdPlacement.isWinSended()) {
            return;
        }
        this.mAdProd.m50826a(this, this.mAdPlacement.getResponse().m51110T());
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setAdPlacementData(Object obj) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
        baiduNativeAdPlacement.setApId((String) C2603as.m50956a(obj, "getApId", new Class[0], new Object[0]));
        String str = (String) C2603as.m50956a(obj, "getAppSid", new Class[0], new Object[0]);
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.mAdViewListener = baiduNativeH5EventListner;
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdViewListener = null;
        initView(context, 0);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAdViewListener = null;
        initView(context, 0);
    }
}
