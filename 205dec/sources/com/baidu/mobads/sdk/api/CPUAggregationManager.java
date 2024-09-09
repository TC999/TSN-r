package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bv;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CPUAggregationManager {
    private static final String TAG = "CPUAggregationManager";
    private CPUAggregationListener mCPUListener;
    private Context mContext;
    private ak mNativeCpuAggregation;
    private int mPageSize = 3;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CPUAggregationListener {
        void onExitLp();

        void onHotContentError(String str, int i4);

        void onHotContentLoaded(List<IBasicCPUAggregation> list);
    }

    public CPUAggregationManager(Context context, String str, CPUAggregationListener cPUAggregationListener) {
        this.mNativeCpuAggregation = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUListener = cPUAggregationListener;
            this.mContext = context;
            ak akVar = new ak(context, str);
            this.mNativeCpuAggregation = akVar;
            akVar.a(cPUAggregationListener);
            return;
        }
        bv.a().c(TAG, "Init params error!");
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError("Input params error.", br.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i4) {
        if (i4 > 0) {
            ak akVar = this.mNativeCpuAggregation;
            if (akVar != null) {
                akVar.a(i4, this.mPageSize, this.mParams);
                this.mNativeCpuAggregation.a();
                return;
            }
            return;
        }
        bv.a().c(TAG, "Load with terrible params!");
    }

    public void setPageSize(int i4) {
        if (i4 > 0 && i4 <= 10) {
            this.mPageSize = i4;
        } else {
            bv.a().c(TAG, "Input page size is wrong which should be in (0,10]!");
        }
    }

    public void setRequestParameter(CPUAggregationRequest cPUAggregationRequest) {
        if (cPUAggregationRequest == null || cPUAggregationRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAggregationRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i4) {
        ak akVar = this.mNativeCpuAggregation;
        if (akVar != null) {
            akVar.a(i4);
        }
    }
}
