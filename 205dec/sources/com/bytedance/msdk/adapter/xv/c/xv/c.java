package com.bytedance.msdk.adapter.xv.c.xv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.xv.c.sr.sr;
import com.bytedance.msdk.adapter.xv.c.sr.ux;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.msdk.api.sr.c.w.ev.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.c.w.f;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.msdk.api.sr.c.w.sr.c implements Bridge {

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.w.w.w f27261w;
    private Bridge xv;

    public c(com.bytedance.msdk.api.sr.c.w.w.w wVar, Bridge bridge) {
        this.f27261w = wVar;
        this.xv = bridge;
        if (bridge != null) {
            b a4 = b.a();
            a4.h(8034, this);
            bridge.call(8127, a4.l(), Void.class);
            au();
            bj();
        }
    }

    private void au() {
        ValueSet values = this.xv.values();
        if (values != null) {
            String stringValue = values.stringValue(8045);
            String stringValue2 = values.stringValue(8046);
            String stringValue3 = values.stringValue(8048);
            String stringValue4 = values.stringValue(8049);
            String stringValue5 = values.stringValue(8050);
            int intValue = values.intValue(8051);
            int intValue2 = values.intValue(8052);
            List<String> list = (List) values.objectValue(8053, List.class);
            String stringValue6 = values.stringValue(8054);
            double doubleValue = values.doubleValue(8016);
            boolean booleanValue = values.booleanValue(8033);
            int intValue3 = values.intValue(8060);
            String stringValue7 = values.stringValue(8061);
            double doubleValue2 = values.doubleValue(8082);
            int intValue4 = values.intValue(8420);
            int intValue5 = values.intValue(8421);
            int intValue6 = values.intValue(8059);
            Bridge bridge = (Bridge) values.objectValue(8315, Bridge.class);
            w(doubleValue);
            c((Map) values.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class));
            c(stringValue);
            w(stringValue2);
            xv(stringValue3);
            sr(stringValue5);
            w(intValue2);
            xv(intValue);
            ux(stringValue7);
            f(stringValue6);
            sr(intValue4);
            ux(intValue5);
            xv(doubleValue2);
            c(list);
            r(stringValue4);
            c(booleanValue);
            f(intValue3);
            r(intValue6);
            if (bridge != null) {
                c(new sr(bridge));
            }
        }
    }

    private void bj() {
        c(new r() { // from class: com.bytedance.msdk.adapter.xv.c.xv.c.1
            @Override // com.bytedance.msdk.api.sr.c.w.ev.r
            public ev c(Activity activity) {
                if (c.this.xv != null) {
                    b a4 = b.a();
                    a4.h(20033, activity);
                    Bridge bridge = (Bridge) c.this.xv.call(6072, a4.l(), Bridge.class);
                    if (bridge != null) {
                        final f fVar = new f(bridge);
                        return new ev() { // from class: com.bytedance.msdk.adapter.xv.c.xv.c.1.1
                            @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                            public void c() {
                                fVar.c();
                            }

                            @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                            public void c(String str) {
                            }

                            @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                            public void w() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                            public boolean xv() {
                                return false;
                            }

                            @Override // com.bytedance.sdk.openadsdk.ys.w.w.ev
                            public void c(com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
                                fVar.c(new ux(cVar));
                            }
                        };
                    }
                    return null;
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.sr.c.w.ev.r
            public void c(String str, Map<String, Object> map) {
                if (c.this.xv != null) {
                    b a4 = b.a();
                    a4.i(8036, str);
                    a4.h(8075, map);
                    c.this.xv.call(8194, a4.l(), Void.class);
                }
            }
        });
    }

    private boolean bm() {
        com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27261w;
        return wVar != null && wVar.t() == 1;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8134) {
            int intValue = valueSet.intValue(8014);
            c((View) valueSet.objectValue(8042, View.class), valueSet.stringValue(8015), intValue);
        } else if (i4 == 8133) {
            c(valueSet.floatValue(8040), valueSet.floatValue(8041));
        } else if (i4 == 8130) {
            s();
        } else if (i4 == 8113) {
            fz();
        } else if (i4 == 8145) {
            u();
        } else if (i4 == 8146) {
            i();
        } else if (i4 == 8150) {
            q();
        } else if (i4 == 8118) {
            j();
        } else if (i4 == 8117) {
            c(new com.bytedance.msdk.api.sr.c.w.c(valueSet.intValue(8014), valueSet.stringValue(8015)));
        } else if (i4 == 8154) {
            c(valueSet.longValue(8072), valueSet.longValue(8073));
        } else if (i4 == 8185) {
            ls();
        } else if (i4 == 8184) {
            gb();
        } else if (i4 == 6085) {
            bj();
        } else if (i4 == 8110) {
            return (T) Boolean.valueOf(bm());
        } else {
            if (i4 == 8136) {
                return (T) Boolean.valueOf(up());
            }
            if (i4 == 8160) {
                return (T) Boolean.valueOf(mt());
            }
            if (i4 == 8226) {
                com.bytedance.msdk.api.sr.c.w.w.w wVar = this.f27261w;
                if (wVar != null) {
                    return (T) Integer.valueOf(wVar.t());
                }
            } else if (i4 == 8132) {
                c(valueSet.intValue(8038), valueSet.stringValue(8039));
            }
        }
        return (T) com.bytedance.msdk.core.s.c.c(cls);
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public MediationConstant.AdIsReadyStatus ev() {
        MediationConstant.AdIsReadyStatus adIsReadyStatus;
        Bridge bridge = this.xv;
        return (bridge == null || (adIsReadyStatus = (MediationConstant.AdIsReadyStatus) bridge.call(8121, null, MediationConstant.AdIsReadyStatus.class)) == null) ? MediationConstant.AdIsReadyStatus.ADN_NO_READY_API : adIsReadyStatus;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public void f() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            bridge.call(8148, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.ev.c
    public String gd() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            return (String) bridge.call(8228, null, String.class);
        }
        return super.gd();
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public void r() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            bridge.call(8109, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public boolean sr() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            return ((Boolean) bridge.call(8135, null, Boolean.class)).booleanValue();
        }
        return super.sr();
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public void ux() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            bridge.call(8149, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c, com.bytedance.msdk.api.sr.c.w.ev.c
    public View w() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            return (View) bridge.call(6081, null, View.class);
        }
        return super.w();
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public com.bytedance.msdk.api.sr.c.xv.sr xv() {
        Bridge bridge;
        Bridge bridge2 = this.xv;
        if (bridge2 != null && (bridge = (Bridge) bridge2.call(8320, null, Bridge.class)) != null) {
            return com.bytedance.msdk.core.c.f.c(bridge);
        }
        return super.xv();
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public void c() {
        Bridge bridge = this.xv;
        if (bridge != null) {
            bridge.call(6083, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.sr.c
    public void c(@Nullable Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, k kVar) {
        super.c(activity, viewGroup, list, list2, kVar);
        c(activity, viewGroup, list, list2, a(), kVar);
    }

    private void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
        if (this.xv != null) {
            b a4 = b.a();
            a4.h(20033, activity);
            a4.h(8067, viewGroup);
            a4.h(8068, list);
            a4.h(8069, list2);
            a4.h(8070, list3);
            a4.h(8071, k.c(kVar));
            this.xv.call(8159, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w.ev.c
    public void c(boolean z3, double d4, int i4, Map<String, Object> map) {
        if (this.xv != null) {
            b a4 = b.a();
            a4.j(8406, z3);
            a4.c(8407, d4);
            a4.e(8408, i4);
            a4.h(8075, map);
            this.xv.call(8225, a4.l(), Void.class);
        }
    }
}
