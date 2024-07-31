package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.C2679cx;
import com.baidu.mobads.sdk.internal.C2680cy;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CPUManager {
    private final Context mContext;
    private CPUDramaListener mDramaListener;

    public CPUManager(Context context) {
        this.mContext = context;
    }

    public CPUComponent loadDramaContent(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams != null) {
            C2680cy c2680cy = new C2680cy(this.mContext, cPUDramaRequestParams, cPUDramaListener);
            c2680cy.mo50356a();
            return new C2679cx(c2680cy);
        } else if (cPUDramaListener != null) {
            cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
            return null;
        } else {
            return null;
        }
    }

    public void showDramaDetailActivity(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams != null) {
            new C2680cy(this.mContext, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener).mo50356a();
        } else if (cPUDramaListener != null) {
            cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
        }
    }
}
