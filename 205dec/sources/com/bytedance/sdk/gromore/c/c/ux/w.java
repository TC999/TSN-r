package com.bytedance.sdk.gromore.c.c.ux;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.msdk.core.admanager.p;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.ys.w.w.fp;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends fp {

    /* renamed from: c  reason: collision with root package name */
    private p f31211c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.gb.c.w.c.c f31212w;
    private com.bytedance.sdk.openadsdk.gb.c.w.c.c xv;

    public w(p pVar) {
        this.f31211c = pVar;
        f();
    }

    private void f() {
        p pVar = this.f31211c;
        if (pVar == null) {
            return;
        }
        pVar.c(new com.bytedance.msdk.api.sr.c.ev.c() { // from class: com.bytedance.sdk.gromore.c.c.ux.w.1
            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c() {
                if (w.this.f31212w != null) {
                    w.this.f31212w.onAdShow();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c_(com.bytedance.msdk.api.c cVar) {
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void f() {
                if (w.this.f31212w != null) {
                    w.this.f31212w.onSkippedVideo();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void r_() {
                if (w.this.f31212w != null) {
                    w.this.f31212w.onAdVideoBarClick();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void s_() {
                if (w.this.f31212w != null) {
                    w.this.f31212w.onAdClose();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void t_() {
                if (w.this.f31212w != null) {
                    w.this.f31212w.onVideoComplete();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void ux() {
                if (w.this.f31212w != null) {
                    w.this.f31212w.onVideoError();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c(com.bytedance.msdk.api.xv.c cVar) {
                w wVar = w.this;
                wVar.c(cVar, wVar.f31212w, "CSJMRewardAd normal");
            }
        });
        this.f31211c.w(new com.bytedance.msdk.api.sr.c.ev.c() { // from class: com.bytedance.sdk.gromore.c.c.ux.w.2
            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c() {
                if (w.this.xv != null) {
                    w.this.xv.onAdShow();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c_(com.bytedance.msdk.api.c cVar) {
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void f() {
                if (w.this.xv != null) {
                    w.this.xv.onSkippedVideo();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void r_() {
                if (w.this.xv != null) {
                    w.this.xv.onAdVideoBarClick();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void s_() {
                if (w.this.xv != null) {
                    w.this.xv.onAdClose();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void t_() {
                if (w.this.xv != null) {
                    w.this.xv.onVideoComplete();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void ux() {
                if (w.this.xv != null) {
                    w.this.xv.onVideoError();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ev.c
            public void c(com.bytedance.msdk.api.xv.c cVar) {
                w wVar = w.this;
                wVar.c(cVar, wVar.xv, "CSJMRewardAd play again");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(com.bytedance.sdk.openadsdk.gb.c.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public long sr() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.f ux() {
        return new c(new xv(this.f31211c));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public int xv() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void w(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar) {
        this.xv = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.msdk.api.xv.c cVar, com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar2, String str) {
        Bundle bundle;
        r.c(cVar, str);
        if (cVar2 == null || cVar == null) {
            return;
        }
        boolean rewardVerify = cVar.rewardVerify();
        float amount = cVar.getAmount();
        String rewardName = cVar.getRewardName();
        Map<String, Object> customData = cVar.getCustomData();
        if (customData == null) {
            customData = new HashMap<>();
        }
        Object obj = customData.get("rewardType");
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = customData.get("extraInfo");
        if (obj2 instanceof Bundle) {
            bundle = (Bundle) obj2;
        } else {
            bundle = new Bundle();
        }
        bundle.putString("reward_extra_key_reward_name", rewardName);
        bundle.putFloat("reward_extra_key_reward_amount", amount);
        Object obj3 = customData.get("isGroMoreServerSideVerify");
        if (obj3 instanceof Boolean) {
            bundle.putBoolean("isGroMoreServerSideVerify", ((Boolean) obj3).booleanValue());
        }
        Object obj4 = customData.get("transId");
        if (obj4 instanceof String) {
            bundle.putString("transId", (String) obj4);
        }
        Object obj5 = customData.get("reason");
        if (obj5 instanceof Integer) {
            bundle.putInt("reason", ((Integer) obj5).intValue());
        }
        Object obj6 = customData.get("gromoreExtra");
        if (obj6 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj6);
        }
        Object obj7 = customData.get("errorCode");
        if (obj7 instanceof Integer) {
            bundle.putInt("errorCode", ((Integer) obj7).intValue());
        }
        Object obj8 = customData.get("errorMsg");
        if (obj8 instanceof String) {
            bundle.putString("errorMsg", (String) obj8);
        }
        Object obj9 = customData.get("adnName");
        if (obj9 instanceof String) {
            bundle.putString("adnName", (String) obj9);
        }
        Object obj10 = customData.get("ecpm");
        if (obj10 instanceof String) {
            bundle.putString("ecpm", (String) obj10);
        }
        cVar2.onRewardArrived(rewardVerify, intValue, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public Map<String, Object> w() {
        p pVar = this.f31211c;
        if (pVar != null) {
            return pVar.ta();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar) {
        this.f31212w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(Activity activity) {
        p pVar = this.f31211c;
        if (pVar != null) {
            pVar.c(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        p pVar = this.f31211c;
        if (pVar != null) {
            pVar.c(activity, ritScenes, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.fp
    public int c() {
        p pVar = this.f31211c;
        if (pVar != null) {
            return pVar.eu();
        }
        return -1;
    }
}
