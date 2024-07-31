package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a;

import android.view.View;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationExpressRenderListener;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.kf */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6440kf implements Bridge {

    /* renamed from: a */
    private final MediationExpressRenderListener f22696a;

    /* renamed from: ok */
    private ValueSet f22697ok = C5930a.f21279c;

    public C6440kf(MediationExpressRenderListener mediationExpressRenderListener) {
        this.f22696a = mediationExpressRenderListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationExpressRenderListener mediationExpressRenderListener = this.f22696a;
        if (mediationExpressRenderListener == null) {
            return null;
        }
        switch (i) {
            case 142101:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                boolean booleanValue = valueSet.booleanValue(3);
                this.f22696a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2, booleanValue);
                break;
            case 142102:
                int intValue = valueSet.intValue(2);
                this.f22696a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue);
                break;
            case 142103:
                mediationExpressRenderListener.onAdClick();
                break;
            case 142104:
                mediationExpressRenderListener.onAdShow();
                break;
        }
        m36276ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36276ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22697ok;
    }
}
