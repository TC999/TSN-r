package com.bytedance.msdk.core.c;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends w {
    public xv(com.bytedance.msdk.adapter.c cVar) {
        super(cVar);
    }

    private com.bytedance.msdk.api.sr.c.sr.c w() {
        return (com.bytedance.msdk.api.sr.c.sr.c) this.f27667a;
    }

    @Override // com.bytedance.msdk.c.ux
    public boolean adnHasAdVideoCachedApi() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            Boolean bool = (Boolean) bridge.call(8211, null, Boolean.class);
            if (bool == null) {
                return super.adnHasAdVideoCachedApi();
            }
            return bool.booleanValue();
        }
        return super.adnHasAdVideoCachedApi();
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
                w().b_(new com.bytedance.msdk.api.c(i5, str));
                return null;
            }
            return null;
        } else if (i4 == 1009) {
            if (w() != null) {
                w().o_();
                return null;
            }
            return null;
        } else if (i4 == 1014) {
            if (w() != null) {
                w().p_();
                return null;
            }
            return null;
        } else if (i4 == 1026) {
            if (w() != null) {
                w().q_();
                return null;
            }
            return null;
        } else if (i4 == 1021) {
            if (w() != null) {
                w().ux();
                return null;
            }
            return null;
        } else if (i4 == 1037) {
            if (w() != null) {
                w().f();
                return null;
            }
            return null;
        } else if (i4 != 1018 || w() == null) {
            return null;
        } else {
            final boolean booleanValue = valueSet.booleanValue(8017);
            final float intValue = valueSet.intValue(8018);
            final String stringValue = valueSet.stringValue(8019);
            w().c(new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.core.c.xv.1
                @Override // com.bytedance.msdk.api.xv.c
                public float getAmount() {
                    return intValue;
                }

                @Override // com.bytedance.msdk.api.xv.c
                public Map<String, Object> getCustomData() {
                    return null;
                }

                @Override // com.bytedance.msdk.api.xv.c
                public String getRewardName() {
                    return stringValue;
                }

                @Override // com.bytedance.msdk.api.xv.c
                public boolean rewardVerify() {
                    return booleanValue;
                }
            });
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
