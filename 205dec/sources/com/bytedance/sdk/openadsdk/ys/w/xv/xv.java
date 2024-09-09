package com.bytedance.sdk.openadsdk.ys.w.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public final ValueSet f36568c;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private final b f36569c = b.a();

        public c c(double d4) {
            this.f36569c.c(262001, d4);
            return this;
        }

        public c w(double d4) {
            this.f36569c.c(262002, d4);
            return this;
        }

        public xv c() {
            return new xv(this.f36569c.l());
        }
    }

    public xv(ValueSet valueSet) {
        this.f36568c = valueSet == null ? b.f24740c : valueSet;
    }

    public double c() {
        return this.f36568c.doubleValue(262001);
    }

    public double w() {
        return this.f36568c.doubleValue(262002);
    }

    public static final ValueSet c(LocationProvider locationProvider) {
        b a4 = b.a();
        if (locationProvider == null) {
            return null;
        }
        a4.c(262001, locationProvider.getLatitude());
        a4.c(262002, locationProvider.getLongitude());
        return a4.l();
    }
}
