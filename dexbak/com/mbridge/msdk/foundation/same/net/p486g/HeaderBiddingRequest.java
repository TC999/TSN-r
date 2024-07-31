package com.mbridge.msdk.foundation.same.net.p486g;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;

/* renamed from: com.mbridge.msdk.foundation.same.net.g.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class HeaderBiddingRequest extends CommonAsyncHttpRequest {
    public HeaderBiddingRequest(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest
    /* renamed from: a */
    public void mo20858a(String str, CommonRequestParams commonRequestParams) {
        try {
            try {
                int m21986e = SameTool.m21986e();
                String m21983f = SameTool.m21983f();
                if (commonRequestParams != null) {
                    commonRequestParams.m22222a("misk_spt", String.valueOf(m21986e));
                    if (!TextUtils.isEmpty(m21983f)) {
                        commonRequestParams.m22222a("misk_spt_det", m21983f);
                    }
                }
            } catch (Exception e) {
                SameLogTool.m21738a("CampaignRequest", e.getMessage());
            }
        } finally {
            super.mo20858a(str, commonRequestParams);
        }
    }
}
