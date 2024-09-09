package com.bytedance.msdk.core.c;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends w {
    public sr(com.bytedance.msdk.adapter.c cVar) {
        super(cVar);
    }

    private com.bytedance.msdk.api.sr.c.ux.c w() {
        return (com.bytedance.msdk.api.sr.c.ux.c) this.f27667a;
    }

    @Override // com.bytedance.msdk.core.c.w
    public <T> T c(int i4, ValueSet valueSet, Class<T> cls) {
        String str;
        if (i4 == 8143) {
            return (T) Double.valueOf(getCpm());
        }
        if (i4 == 8111) {
            if (valueSet != null) {
                if (c() || isMultiBiddingAd()) {
                    setCpm(valueSet.doubleValue(8016));
                    return null;
                }
                return null;
            }
            return null;
        }
        int i5 = 0;
        if (i4 == 8129) {
            if (valueSet != null) {
                setExpressAd(Boolean.valueOf(valueSet.booleanValue(8033, false)).booleanValue());
                return null;
            }
            return null;
        } else if (i4 == 1008) {
            if (w() != null) {
                w().c();
                return null;
            }
            return null;
        } else if (i4 == 1017) {
            if (w() != null) {
                if (valueSet != null) {
                    i5 = valueSet.intValue(8014, 0);
                    str = valueSet.stringValue(8015);
                } else {
                    str = "";
                }
                w().c(new com.bytedance.msdk.api.c(i5, str));
                return null;
            }
            return null;
        } else if (i4 == 1009) {
            if (w() != null) {
                w().w();
                return null;
            }
            return null;
        } else if (i4 == 1014) {
            if (w() != null) {
                w().xv();
                return null;
            }
            return null;
        } else if (i4 == 1015) {
            if (w() != null) {
                w().sr();
                return null;
            }
            return null;
        } else if (i4 != 1016 || w() == null) {
            return null;
        } else {
            w().ux();
            return null;
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public String getReqId() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (String) bridge.call(8147, null, String.class);
        }
        return super.getReqId();
    }

    @Override // com.bytedance.msdk.c.ux
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) bridge.call(8121, null, MediationConstant.AdIsReadyStatus.class);
            return adIsReadyStatus == null ? super.isReadyStatus() : adIsReadyStatus;
        }
        return super.isReadyStatus();
    }

    @Override // com.bytedance.msdk.c.ux
    public void showAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        super.showAd(activity, ritScenes, str);
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20033, activity);
            ((w) this).f27850c.call(8113, a4.l(), Void.class);
        }
    }
}
