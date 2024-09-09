package com.bytedance.sdk.gromore.init;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends com.bytedance.sdk.openadsdk.mediation.c.w.sr {
    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(Activity activity, List<com.bytedance.sdk.openadsdk.mediation.c.w.ux> list, int i4, int i5, Bridge bridge) {
        com.bytedance.msdk.api.c.w c4;
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager preload activity = " + activity + " list = " + list + " parallelNum = " + i4 + " requestIntervalS = " + i5 + " classLoader = " + bridge);
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.sdk.openadsdk.mediation.c.w.ux uxVar : list) {
                if (uxVar != null && (c4 = com.bytedance.msdk.api.sr.c.c.c(uxVar.c(), uxVar.w(), bridge)) != null) {
                    arrayList.add(new com.bytedance.msdk.api.sr.a(c4, uxVar.xv()));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.api.sr.gd.c(activity, arrayList, i4, i5);
                return;
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TMe", "\u53c2\u6570\u9519\u8bef");
                return;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TMe", "\u53c2\u6570\u9519\u8bef");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(String str) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager setPulisherDid configUserInfoForSegment = " + str);
        com.bytedance.msdk.api.sr.gd.c(str);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(Context context) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager requestPermissionIfNecessary context = " + context);
        com.bytedance.msdk.api.sr.gd.c(context);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(Context context, int[] iArr) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager requestPermissionIfNecessary context = " + context + " permissions = " + iArr);
        com.bytedance.msdk.api.sr.gd.c(context, iArr);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(int i4) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager setThemeStatus themeStatus = " + i4);
        com.bytedance.msdk.api.sr.gd.c(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public int c(final com.bytedance.sdk.openadsdk.mediation.c.w.c.sr srVar) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager showOpenOrInstallAppDialog");
        return com.bytedance.msdk.api.sr.gd.c(new com.bytedance.msdk.api.sr.xv() { // from class: com.bytedance.sdk.gromore.init.k.1
            @Override // com.bytedance.msdk.api.sr.xv
            public void c(int i4) {
                com.bytedance.sdk.openadsdk.mediation.c.w.c.sr srVar2 = srVar;
                if (srVar2 != null) {
                    srVar2.c(i4);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar) {
        com.bytedance.msdk.api.sr.gd.c(w.c(xvVar));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager updatePrivacyConfig customController = " + srVar);
        com.bytedance.msdk.api.sr.gd.c(srVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("mediationManager updateLocalExtra map = ");
        sb.append(map);
        com.bytedance.msdk.adapter.sr.xv.w("TMe", sb.toString() == null ? "null" : map.toString());
        com.bytedance.msdk.core.w.k().w(map);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(Context context, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, final com.bytedance.sdk.openadsdk.mediation.c.w.c.xv xvVar, Bridge bridge) {
        if (context != null && cVar != null) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager loadNativeToken context = " + context + " adSlot = " + cVar + " pluginIMediationNativeAdTokenCallback = " + xvVar + " classLoader = " + bridge);
            com.bytedance.msdk.api.c.w c4 = com.bytedance.msdk.api.sr.c.c.c(5, cVar, bridge);
            if (c4 != null) {
                final com.bytedance.msdk.core.admanager.ev evVar = new com.bytedance.msdk.core.admanager.ev(context, cVar.f());
                evVar.c(c4, new com.bytedance.msdk.api.sr.c.xv() { // from class: com.bytedance.sdk.gromore.init.k.2
                    @Override // com.bytedance.msdk.api.sr.c.xv
                    public void c(String str) {
                        com.bytedance.sdk.openadsdk.mediation.c.w.c.xv xvVar2 = xvVar;
                        if (xvVar2 != null) {
                            xvVar2.c(str, new a(evVar));
                        }
                    }

                    @Override // com.bytedance.msdk.api.sr.c.xv
                    public void c(com.bytedance.msdk.api.c cVar2) {
                        com.bytedance.sdk.openadsdk.mediation.c.w.c.xv xvVar2;
                        if (cVar2 == null || (xvVar2 = xvVar) == null) {
                            return;
                        }
                        xvVar2.c(cVar2.f27444c, cVar2.f27445w);
                    }
                });
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TMe", "\u53c2\u6570\u9519\u8bef");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public void c(Context context, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, final com.bytedance.sdk.openadsdk.mediation.c.w.c.c cVar2, Bridge bridge) {
        if (context != null && cVar != null) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "mediationManager loadDrawToken context = " + context + " adSlot = " + cVar + " pluginIMediationDrawAdTokenCallback = " + cVar2 + " classLoader = " + bridge);
            com.bytedance.msdk.api.c.w c4 = com.bytedance.msdk.api.sr.c.c.c(9, cVar, bridge);
            if (c4 != null) {
                final com.bytedance.msdk.core.admanager.ux uxVar = new com.bytedance.msdk.core.admanager.ux(context, cVar.f());
                uxVar.c(c4, new com.bytedance.msdk.api.sr.c.xv() { // from class: com.bytedance.sdk.gromore.init.k.3
                    @Override // com.bytedance.msdk.api.sr.c.xv
                    public void c(String str) {
                        com.bytedance.sdk.openadsdk.mediation.c.w.c.c cVar3 = cVar2;
                        if (cVar3 != null) {
                            cVar3.c(str, new p(uxVar));
                        }
                    }

                    @Override // com.bytedance.msdk.api.sr.c.xv
                    public void c(com.bytedance.msdk.api.c cVar3) {
                        com.bytedance.sdk.openadsdk.mediation.c.w.c.c cVar4;
                        if (cVar3 == null || (cVar4 = cVar2) == null) {
                            return;
                        }
                        cVar4.c(cVar3.f27444c, cVar3.f27445w);
                    }
                });
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TMe", "\u53c2\u6570\u9519\u8bef");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public Map<String, Object> c() {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "getMediationExtraInfo");
        return com.bytedance.msdk.api.sr.gd.bk();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.sr
    public Object c(int i4, ValueSet valueSet) {
        String str;
        if (i4 == 8259) {
            return c();
        }
        if (i4 == 1001) {
            return Boolean.valueOf(com.bytedance.msdk.api.sr.gd.c());
        }
        if (i4 == 1002) {
            return Boolean.valueOf(com.bytedance.msdk.api.sr.gd.c(valueSet.stringValue(1001), valueSet.stringValue(1002)));
        }
        if (i4 == 1003) {
            return Boolean.valueOf(com.bytedance.msdk.api.sr.gd.w(valueSet.stringValue(1001), valueSet.stringValue(1003)));
        }
        if (i4 == 1004) {
            return com.bytedance.msdk.api.sr.gd.ux();
        }
        if (i4 == 1005) {
            return com.bytedance.msdk.api.sr.gd.k();
        }
        if (i4 == 1006) {
            return com.bytedance.msdk.api.sr.gd.p();
        }
        if (i4 == 1007) {
            return com.bytedance.msdk.api.sr.gd.w((Context) valueSet.objectValue(1004, Context.class));
        }
        if (i4 == 1008) {
            com.bytedance.msdk.api.sr.gd.w(2);
        } else if (i4 != 1009) {
            if (i4 == 1010) {
                return Boolean.valueOf(com.bytedance.msdk.api.sr.gd.sr(valueSet.stringValue(1001)));
            }
            if (i4 != 1011) {
                if (i4 != 2001 || valueSet == null) {
                    return null;
                }
                com.bytedance.sdk.gromore.w.c.c((Bridge) valueSet.objectValue(2002, Bridge.class));
                return com.bytedance.sdk.gromore.w.c.c();
            }
            String stringValue = valueSet.stringValue(1001);
            com.bytedance.msdk.api.sr.c.w.f.c ux = com.bytedance.msdk.api.sr.gd.ux(stringValue);
            com.bytedance.msdk.adapter.c.xv f4 = com.bytedance.msdk.api.sr.gd.f(stringValue);
            String str2 = "";
            if (ux != null) {
                str2 = ux.c();
                str = ux.w();
            } else if (f4 != null) {
                str2 = f4.w();
                str = f4.c();
            } else {
                str = "";
            }
            HashMap hashMap = new HashMap(2);
            hashMap.put("networdSdkVersion", str2);
            hashMap.put("adapterSdkVersion", str);
            return hashMap;
        } else {
            com.bytedance.msdk.api.sr.gd.a();
        }
        return null;
    }
}
