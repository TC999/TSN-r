package com.bytedance.msdk.adapter.xv.c.c;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.sr.xv;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.msdk.adapter.xv.c.c {
    private c xv;

    public w(String str, com.bytedance.msdk.api.sr.c.w.w.w wVar) {
        super(str, wVar);
        com.bytedance.msdk.api.sr.c.w.w.w wVar2 = this.f27249w;
        if (wVar2 instanceof c) {
            this.xv = (c) wVar2;
        }
    }

    public void c(int i4, String str) {
        c cVar = this.xv;
        if (cVar != null) {
            cVar.c(new com.bytedance.msdk.api.sr.c.w.c(i4, str));
        }
    }

    public void c(double d4, Map<String, Object> map) {
        c cVar = this.xv;
        if (cVar != null) {
            cVar.c(d4, map);
        }
    }

    @Override // com.bytedance.msdk.adapter.xv.c.c
    public void c(Map<String, Object> map) {
        super.c(map);
        if (this.xv == null || map == null || map.size() <= 0) {
            return;
        }
        this.xv.c(map);
    }

    public void c(Activity activity) {
        if (this.f27248c != null) {
            b a4 = b.a();
            a4.h(20033, activity);
            this.f27248c.call(8113, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.adapter.xv.c.c
    public <T> T c(int i4, ValueSet valueSet, Class<T> cls) {
        Map<String, Object> map;
        if (i4 == 8123) {
            int intValue = valueSet.intValue(8014);
            String stringValue = valueSet.stringValue(8015);
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callLoaderFail  code:" + intValue + " msg:" + stringValue);
            c(intValue, stringValue);
        } else if (i4 == 8107) {
            double d4 = 0.0d;
            if (valueSet != null) {
                d4 = valueSet.doubleValue(8409);
                map = (Map) valueSet.objectValue(8075, Map.class);
            } else {
                map = null;
            }
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callLoadSucceed price:" + d4);
            c(d4, map);
        } else if (i4 == 1008) {
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callInterstitialShow");
            c cVar = this.xv;
            if (cVar != null) {
                cVar.ux();
            }
        } else if (i4 == 1009) {
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callInterstitialAdClick");
            c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.f();
            }
        } else if (i4 == 1014) {
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callInterstitialClosed");
            c cVar3 = this.xv;
            if (cVar3 != null) {
                cVar3.r();
            }
        } else if (i4 == 1015) {
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callInterstitialAdOpened");
            c cVar4 = this.xv;
            if (cVar4 != null) {
                cVar4.ev();
            }
        } else if (i4 == 1016) {
            xv.w("TTMediationSDK", "GMCustomInterstitialLoader4csjm callInterstitialAdLeftApplication");
            c cVar5 = this.xv;
            if (cVar5 != null) {
                cVar5.gd();
            }
        }
        return null;
    }
}
