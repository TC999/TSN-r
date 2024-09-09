package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.da;
import com.baidu.mobads.sdk.internal.db;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CPUManager {
    private final Context mContext;
    private CPUDramaListener mDramaListener;

    public CPUManager(Context context) {
        this.mContext = context;
    }

    public CPUComponent loadDramaContent(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams != null) {
            db dbVar = new db(this.mContext, cPUDramaRequestParams, cPUDramaListener);
            dbVar.a();
            return new da(dbVar);
        } else if (cPUDramaListener != null) {
            cPUDramaListener.onContentFailed(-2, "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8bf7\u6c42\u53c2\u6570\u662f\u5426\u4e3a\u7a7a");
            return null;
        } else {
            return null;
        }
    }

    public void showDramaDetailActivity(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams != null) {
            new db(this.mContext, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener).a();
        } else if (cPUDramaListener != null) {
            cPUDramaListener.onContentFailed(-2, "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8bf7\u6c42\u53c2\u6570\u662f\u5426\u4e3a\u7a7a");
        }
    }
}
