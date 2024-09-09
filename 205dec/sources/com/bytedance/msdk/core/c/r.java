package com.bytedance.msdk.core.c;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends w {
    public r(com.bytedance.msdk.adapter.c cVar) {
        super(cVar);
    }

    private com.bytedance.msdk.api.sr.c.ev.c w() {
        return (com.bytedance.msdk.api.sr.c.ev.c) this.f27667a;
    }

    private com.bytedance.msdk.api.sr.c.ev.c xv() {
        return (com.bytedance.msdk.api.sr.c.ev.c) this.bk;
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
        if (i4 == 8115) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                w().r_();
            }
        } else if (i4 == 8116) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                w().s_();
            }
        } else if (i4 == 8117) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                w().ux();
            }
        } else if (i4 == 8118) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                w().t_();
            }
        } else if (i4 == 8119) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                w().f();
            }
        } else if (i4 == 8230) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                w().c();
            }
        } else if (i4 == 8231) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                final boolean booleanValue = valueSet.booleanValue(8017);
                final float intValue = valueSet.intValue(8018);
                final String stringValue = valueSet.stringValue(8019);
                Map map = (Map) valueSet.objectValue(8020, Map.class);
                final HashMap hashMap = new HashMap();
                if (map != null) {
                    hashMap.putAll(map);
                }
                com.bytedance.msdk.api.xv.c cVar = new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.core.c.r.1
                    @Override // com.bytedance.msdk.api.xv.c
                    public float getAmount() {
                        return intValue;
                    }

                    @Override // com.bytedance.msdk.api.xv.c
                    public Map<String, Object> getCustomData() {
                        return hashMap;
                    }

                    @Override // com.bytedance.msdk.api.xv.c
                    public String getRewardName() {
                        return stringValue;
                    }

                    @Override // com.bytedance.msdk.api.xv.c
                    public boolean rewardVerify() {
                        return booleanValue;
                    }
                };
                com.bytedance.sdk.gromore.c.c.ux.r.c(cVar, "GMRewardAd reward verify");
                w().c(cVar);
            }
        } else if (i4 == 1017) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                int i5 = 0;
                if (valueSet != null) {
                    i5 = valueSet.intValue(8014, 0);
                    str = valueSet.stringValue(8015);
                } else {
                    str = "";
                }
                w().c_(new com.bytedance.msdk.api.c(i5, str));
            }
        } else if (i4 == 8232) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                xv().r_();
            }
        } else if (i4 == 8233) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                xv().s_();
            }
        } else if (i4 == 8234) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                xv().ux();
            }
        } else if (i4 == 8235) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                xv().t_();
            }
        } else if (i4 == 8236) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                xv().f();
            }
        } else if (i4 == 8237) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                xv().c();
            }
        } else if (i4 == 8238) {
            if (this.bk instanceof com.bytedance.msdk.api.sr.c.ev.c) {
                final boolean booleanValue2 = valueSet.booleanValue(8017);
                final float intValue2 = valueSet.intValue(8018);
                final String stringValue2 = valueSet.stringValue(8019);
                Map map2 = (Map) valueSet.objectValue(8020, Map.class);
                final HashMap hashMap2 = new HashMap();
                if (map2 != null) {
                    hashMap2.putAll(map2);
                }
                com.bytedance.msdk.api.xv.c cVar2 = new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.core.c.r.2
                    @Override // com.bytedance.msdk.api.xv.c
                    public float getAmount() {
                        return intValue2;
                    }

                    @Override // com.bytedance.msdk.api.xv.c
                    public Map<String, Object> getCustomData() {
                        return hashMap2;
                    }

                    @Override // com.bytedance.msdk.api.xv.c
                    public String getRewardName() {
                        return stringValue2;
                    }

                    @Override // com.bytedance.msdk.api.xv.c
                    public boolean rewardVerify() {
                        return booleanValue2;
                    }
                };
                com.bytedance.sdk.gromore.c.c.ux.r.c(cVar2, "GMRewardAd play again reward verify");
                xv().c(cVar2);
            }
        } else if (i4 == 8111) {
            setCpm(valueSet.doubleValue(8016));
        }
        return (T) com.bytedance.msdk.core.s.c.c(cls);
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
