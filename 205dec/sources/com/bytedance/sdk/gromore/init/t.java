package com.bytedance.sdk.gromore.init;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t implements Manager {

    /* renamed from: c  reason: collision with root package name */
    private Manager f31270c;

    /* renamed from: w  reason: collision with root package name */
    private sr f31271w = new sr();

    public t(Manager manager) {
        this.f31270c = manager;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        Manager manager = this.f31270c;
        if (manager != null) {
            return new ev(context, manager.createLoader(context));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i4) {
        if (i4 == 8303) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "initRequestCondition getBridge");
            return this.f31271w;
        }
        Manager manager = this.f31270c;
        if (manager != null) {
            return new gd(manager.getBridge(i4));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        Manager manager = this.f31270c;
        if (manager != null) {
            return manager.values();
        }
        return null;
    }
}
