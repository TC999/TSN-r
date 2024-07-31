package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import p655w1.C16237a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationLoaderConfig {

    /* renamed from: ok */
    private ValueSet f22755ok;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
            if (valueSet2 != null) {
                this.f22755ok = valueSet2;
            } else {
                this.f22755ok = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    /* renamed from: ok */
    private boolean m36254ok() {
        ValueSet valueSet = this.f22755ok;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getADNName() {
        return m36254ok() ? this.f22755ok.stringValue(C16237a.f47148e) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (m36254ok()) {
            return (ValueSet) this.f22755ok.objectValue(8548, ValueSet.class);
        }
        return null;
    }

    public int getAdType() {
        if (m36254ok()) {
            return this.f22755ok.intValue(8008);
        }
        return 0;
    }

    public String getClassName() {
        return m36254ok() ? this.f22755ok.stringValue(8010) : "";
    }

    public Context getContext() {
        if (m36254ok()) {
            return (Context) this.f22755ok.objectValue(8009, Context.class);
        }
        return null;
    }

    public Bridge getGMCustomAdLoader() {
        if (m36254ok()) {
            return (Bridge) this.f22755ok.objectValue(8011, Bridge.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (m36254ok()) {
            return (ValueSet) this.f22755ok.objectValue(8546, ValueSet.class);
        }
        return null;
    }
}
