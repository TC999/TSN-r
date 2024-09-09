package com.bytedance.msdk.core.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends w {
    private com.bytedance.msdk.adapter.w.f xv;

    public ev(com.bytedance.msdk.adapter.c cVar) {
        super(cVar);
    }

    private com.bytedance.msdk.adapter.w.ux w() {
        return (com.bytedance.msdk.adapter.w.ux) this.f27667a;
    }

    @Override // com.bytedance.msdk.core.c.w
    public <T> T c(int i4, ValueSet valueSet, Class<T> cls) {
        String str;
        if (i4 == 8143) {
            return (T) Double.valueOf(getCpm());
        }
        int i5 = 0;
        if (i4 == 1009) {
            if (valueSet != null ? valueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.adapter.w.f fVar = this.xv;
                if (fVar instanceof com.bytedance.msdk.api.sr.c.gd.w) {
                    ((com.bytedance.msdk.api.sr.c.gd.w) fVar).r();
                    return null;
                }
                return null;
            } else if (w() != null) {
                w().r();
                return null;
            } else {
                return null;
            }
        } else if (i4 == 1017) {
            if (w() != null) {
                if (valueSet != null) {
                    i5 = valueSet.intValue(8014, 0);
                    str = valueSet.stringValue(8015);
                } else {
                    str = "";
                }
                w().d_(new com.bytedance.msdk.api.c(i5, str));
                return null;
            }
            return null;
        } else if (i4 == 1011) {
            boolean booleanValue = valueSet != null ? valueSet.booleanValue(20040, false) : false;
            if (valueSet != null) {
                valueSet.intValue(8552);
            }
            if (booleanValue) {
                com.bytedance.msdk.adapter.w.f fVar2 = this.xv;
                if (fVar2 instanceof com.bytedance.msdk.api.sr.c.gd.w) {
                    ((com.bytedance.msdk.api.sr.c.gd.w) fVar2).w(2);
                    return null;
                }
                return null;
            } else if (w() != null) {
                w().w(2);
                return null;
            } else {
                return null;
            }
        } else if (i4 == 1008) {
            if (valueSet != null ? valueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.adapter.w.f fVar3 = this.xv;
                if (fVar3 instanceof com.bytedance.msdk.api.sr.c.gd.w) {
                    ((com.bytedance.msdk.api.sr.c.gd.w) fVar3).u_();
                    return null;
                }
                return null;
            } else if (w() != null) {
                w().u_();
                return null;
            } else {
                return null;
            }
        } else if (i4 == 1019) {
            boolean booleanValue2 = valueSet != null ? valueSet.booleanValue(20040, false) : false;
            if (valueSet != null) {
                valueSet.intValue(8552);
            }
            if (booleanValue2) {
                com.bytedance.msdk.adapter.w.f fVar4 = this.xv;
                if (fVar4 instanceof com.bytedance.msdk.api.sr.c.gd.w) {
                    ((com.bytedance.msdk.api.sr.c.gd.w) fVar4).c(1);
                    return null;
                }
                return null;
            } else if (w() != null) {
                w().c(1);
                return null;
            } else {
                return null;
            }
        } else if (i4 == 1074) {
            if (w() != null) {
                return (T) w().getActivity();
            }
            return null;
        } else if (i4 == 1073) {
            if (w() == null || valueSet == null) {
                return null;
            }
            w().c(valueSet.booleanValue(8428));
            return null;
        } else if (i4 == 1072) {
            if (w() != null) {
                w().x_();
                return null;
            }
            return null;
        } else if (i4 == 1071) {
            if (w() != null) {
                w().w_();
                return null;
            }
            return null;
        } else if (i4 == 6159) {
            if (w() != null) {
                w().f();
                return null;
            }
            return null;
        } else if (i4 == 1051) {
            if (w() != null) {
                w().c();
                return null;
            }
            return null;
        } else if (i4 == 1052) {
            if (w() != null) {
                w().v_();
                return null;
            }
            return null;
        } else if (i4 == 6156) {
            if (w() != null) {
                w().ux();
                return null;
            }
            return null;
        } else if (i4 == 8111) {
            setCpm(valueSet.doubleValue(8016));
            return null;
        } else {
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
    public Bitmap getSplashBitMap() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (Bitmap) bridge.call(6163, null, Bitmap.class);
        }
        return null;
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
    public void showMinWindow(Rect rect, com.bytedance.msdk.adapter.w.f fVar) {
        super.showMinWindow(rect, fVar);
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20067, rect);
            ((w) this).f27850c.call(6161, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void showSplashAd(ViewGroup viewGroup) {
        super.showSplashAd(viewGroup);
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20060, viewGroup);
            ((w) this).f27850c.call(6152, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        super.showSplashCardView(viewGroup, activity);
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20060, viewGroup);
            a4.h(20033, activity);
            ((w) this).f27850c.call(6154, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void showSplashClickEyeView(ViewGroup viewGroup) {
        super.showSplashClickEyeView(viewGroup);
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20060, viewGroup);
            ((w) this).f27850c.call(6153, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void splashMinWindowAnimationFinish() {
        super.splashMinWindowAnimationFinish();
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            bridge.call(6162, null, Void.class);
        }
    }
}
