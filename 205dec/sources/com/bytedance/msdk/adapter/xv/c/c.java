package com.bytedance.msdk.adapter.xv.c;

import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.api.sr.c.w.xv.xv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    protected Bridge f27248c;
    private xv sr;

    /* renamed from: w  reason: collision with root package name */
    protected com.bytedance.msdk.api.sr.c.w.w.w f27249w;
    private String xv;

    public c(String str, com.bytedance.msdk.api.sr.c.w.w.w wVar) {
        this.xv = str;
        this.f27249w = wVar;
    }

    public abstract <T> T c(int i4, ValueSet valueSet, Class<T> cls);

    public void c(Context context, com.bytedance.msdk.api.c.w wVar, xv xvVar) {
        if (context == null || wVar == null || xvVar == null) {
            return;
        }
        this.sr = xvVar;
        b a4 = b.a();
        a4.h(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this);
        if (com.bytedance.sdk.gromore.init.c.c() >= 5900) {
            a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.adapter.sr.c.c(context));
        } else {
            a4.h(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        }
        a4.i(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.xv);
        a4.h(8546, xvVar.c());
        if (wVar.wx() != null) {
            a4.h(8548, wVar.wx());
        }
        Bridge f4 = com.bytedance.msdk.core.bk.c.c().f();
        if (f4 != null) {
            f4.call(8106, a4.l(), Void.class);
        } else {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "load custom class loader is null ");
        }
    }

    public void c(Map<String, Object> map) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public final <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8221) {
            this.f27248c = (Bridge) valueSet.objectValue(8405, Bridge.class);
        } else if (i4 == 8137) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "GMCustomAdLoader4csjm getAdm");
            return (T) c();
        } else if (i4 == 8224) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "GMCustomAdLoader4csjm getExtraDataNoParse");
            return (T) w();
        } else if (i4 == 8226) {
            T t3 = (T) Integer.valueOf(xv());
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "GMCustomAdLoader4csjm getBiddingType :" + t3);
            return t3;
        } else if (i4 == 8227) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "GMCustomAdLoader4csjm setExtraInfo");
            if (valueSet != null) {
                c((Map) valueSet.objectValue(8075, Map.class));
            }
        }
        return (T) c(i4, valueSet, cls);
    }

    public void f() {
        Bridge bridge = this.f27248c;
        if (bridge != null) {
            bridge.call(8148, null, Void.class);
        }
    }

    public void r() {
        Bridge bridge = this.f27248c;
        if (bridge != null) {
            bridge.call(8109, null, Void.class);
        }
    }

    public MediationConstant.AdIsReadyStatus sr() {
        Bridge bridge = this.f27248c;
        if (bridge != null) {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) bridge.call(8121, null, MediationConstant.AdIsReadyStatus.class);
            return adIsReadyStatus == null ? MediationConstant.AdIsReadyStatus.ADN_NO_READY_API : adIsReadyStatus;
        }
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public void ux() {
        Bridge bridge = this.f27248c;
        if (bridge != null) {
            bridge.call(8149, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public Object w() {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27249w;
        return wVar != null ? wVar.fp() : "";
    }

    public int xv() {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27249w;
        if (wVar != null) {
            return wVar.t();
        }
        return 0;
    }

    public String c() {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27249w;
        return wVar != null ? wVar.ys() : "";
    }

    public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
        if (this.f27248c != null) {
            b a4 = b.a();
            a4.j(8406, z3);
            a4.c(8407, d4);
            a4.e(8408, i4);
            a4.h(8075, map);
            this.f27248c.call(8225, a4.l(), Void.class);
        }
    }
}
