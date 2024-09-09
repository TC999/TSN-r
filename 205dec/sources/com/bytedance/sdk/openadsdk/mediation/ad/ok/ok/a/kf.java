package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class kf implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final MediationExpressRenderListener f36053a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public kf(MediationExpressRenderListener mediationExpressRenderListener) {
        this.f36053a = mediationExpressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationExpressRenderListener mediationExpressRenderListener = this.f36053a;
        if (mediationExpressRenderListener == null) {
            return null;
        }
        switch (i4) {
            case 142101:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                boolean booleanValue = valueSet.booleanValue(3);
                this.f36053a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2, booleanValue);
                break;
            case 142102:
                int intValue = valueSet.intValue(2);
                this.f36053a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue);
                break;
            case 142103:
                mediationExpressRenderListener.onAdClick();
                break;
            case 142104:
                mediationExpressRenderListener.onAdShow();
                break;
        }
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
