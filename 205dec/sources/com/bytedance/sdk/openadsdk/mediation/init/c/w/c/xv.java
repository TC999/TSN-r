package com.bytedance.sdk.openadsdk.mediation.init.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public final ValueSet f36190c;

    public xv(ValueSet valueSet) {
        this.f36190c = valueSet == null ? b.f24740c : valueSet;
    }

    public Map<String, String> c() {
        return (Map) this.f36190c.objectValue(265007, Map.class);
    }

    public String f() {
        return (String) this.f36190c.objectValue(265005, String.class);
    }

    public String r() {
        return (String) this.f36190c.objectValue(265006, String.class);
    }

    public String sr() {
        return (String) this.f36190c.objectValue(265003, String.class);
    }

    public int ux() {
        return this.f36190c.intValue(265004);
    }

    public String w() {
        return (String) this.f36190c.objectValue(265001, String.class);
    }

    public String xv() {
        return (String) this.f36190c.objectValue(265002, String.class);
    }

    public static final ValueSet c(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        b a4 = b.a();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        a4.h(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        a4.i(265001, mediationConfigUserInfoForSegment.getUserId());
        a4.i(265002, mediationConfigUserInfoForSegment.getChannel());
        a4.i(265003, mediationConfigUserInfoForSegment.getSubChannel());
        a4.e(265004, mediationConfigUserInfoForSegment.getAge());
        a4.i(265005, mediationConfigUserInfoForSegment.getGender());
        a4.i(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return a4.l();
    }
}
