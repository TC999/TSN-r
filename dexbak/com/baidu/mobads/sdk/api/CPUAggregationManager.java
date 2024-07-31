package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.C2591ak;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.EnumC2629bo;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CPUAggregationManager {
    private static final String TAG = "CPUAggregationManager";
    private CPUAggregationListener mCPUListener;
    private Context mContext;
    private C2591ak mNativeCpuAggregation;
    private int mPageSize = 3;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface CPUAggregationListener {
        void onExitLp();

        void onHotContentError(String str, int i);

        void onHotContentLoaded(List<IBasicCPUAggregation> list);
    }

    public CPUAggregationManager(Context context, String str, CPUAggregationListener cPUAggregationListener) {
        this.mNativeCpuAggregation = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUListener = cPUAggregationListener;
            this.mContext = context;
            C2591ak c2591ak = new C2591ak(context, str);
            this.mNativeCpuAggregation = c2591ak;
            c2591ak.m51024a(cPUAggregationListener);
            return;
        }
        C2634bs.m50744a().m50728c(TAG, "Init params error!");
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError("Input params error.", EnumC2629bo.INTERFACE_USE_PROBLEM.m50776b());
        }
    }

    public void loadAd(int i) {
        if (i > 0) {
            C2591ak c2591ak = this.mNativeCpuAggregation;
            if (c2591ak != null) {
                c2591ak.m51025a(i, this.mPageSize, this.mParams);
                this.mNativeCpuAggregation.mo50356a();
                return;
            }
            return;
        }
        C2634bs.m50744a().m50728c(TAG, "Load with terrible params!");
    }

    public void setPageSize(int i) {
        if (i > 0 && i <= 10) {
            this.mPageSize = i;
        } else {
            C2634bs.m50744a().m50728c(TAG, "Input page size is wrong which should be in (0,10]!");
        }
    }

    public void setRequestParameter(CPUAggregationRequest cPUAggregationRequest) {
        if (cPUAggregationRequest == null || cPUAggregationRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAggregationRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i) {
        C2591ak c2591ak = this.mNativeCpuAggregation;
        if (c2591ak != null) {
            c2591ak.m51026a(i);
        }
    }
}
