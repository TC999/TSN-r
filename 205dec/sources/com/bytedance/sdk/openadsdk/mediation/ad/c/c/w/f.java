package com.bytedance.sdk.openadsdk.mediation.ad.c.c.w;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36027c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final MediationExpressRenderListener f36028w;

    public f(MediationExpressRenderListener mediationExpressRenderListener) {
        this.f36028w = mediationExpressRenderListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationExpressRenderListener mediationExpressRenderListener = this.f36028w;
        if (mediationExpressRenderListener == null) {
            return null;
        }
        switch (i4) {
            case 142101:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                boolean booleanValue = valueSet.booleanValue(3);
                this.f36028w.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2, booleanValue);
                break;
            case 142102:
                int intValue = valueSet.intValue(2);
                this.f36028w.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue);
                break;
            case 142103:
                mediationExpressRenderListener.onAdClick();
                break;
            case 142104:
                mediationExpressRenderListener.onAdShow();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36027c;
    }
}
