package com.mbridge.msdk.foundation.same.net.g;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: CampaignRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends b {
    public a(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.b
    public void a(String str, d dVar) {
        try {
            try {
                int e4 = ac.e();
                String f4 = ac.f();
                if (dVar != null) {
                    dVar.a("misk_spt", String.valueOf(e4));
                    if (!TextUtils.isEmpty(f4)) {
                        dVar.a("misk_spt_det", f4);
                    }
                }
            } catch (Exception e5) {
                x.a("CampaignRequest", e5.getMessage());
            }
        } finally {
            super.a(str, dVar);
        }
    }
}
