package com.bytedance.msdk.core.p;

import android.text.TextUtils;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.core.k.p;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, com.bytedance.msdk.core.k.w> f28090c = new ConcurrentHashMap();

    public static void c(int i4, String str, int i5, double d4) {
        com.bytedance.msdk.core.k.w c4;
        com.bytedance.msdk.core.k.ux ux;
        if (com.bytedance.msdk.core.c.w().gw() && (c4 = com.bytedance.msdk.core.c.w().c(str, i5, 101)) != null) {
            if (c4.f() == 1 && i4 == 1) {
                ux.sr().c(i5, d4);
            } else if (c4.f() != 2 || (ux = com.bytedance.msdk.core.c.w().ux(str)) == null) {
            } else {
                if (i4 == 2 && ux.xv() == 2) {
                    w.sr().c(str, 2, d4);
                } else if (i4 != 1 || ux.xv() == 2) {
                } else {
                    w.sr().c(str, ux.xv(), d4);
                }
            }
        }
    }

    public static void c(com.bytedance.msdk.core.k.w wVar, double d4, String str, int i4) {
        if (!com.bytedance.msdk.core.c.w().gw() || wVar == null) {
            return;
        }
        if (wVar.f() == 2) {
            c(2, str, i4, d4);
        } else if (wVar.f() == 3 || wVar.f() == 4) {
            w.sr().c(wVar.xk(), "_last_load_cpm_", wVar.me(), d4);
        }
    }

    public static void c(String str, String str2, int i4, JSONObject jSONObject) {
        com.bytedance.msdk.core.k.w c4;
        if (com.bytedance.msdk.core.c.w().gw() && (c4 = com.bytedance.msdk.ux.c.c.p().c(str, i4, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (c4.f() == 1) {
                    ux.sr().c(String.valueOf(i4), jSONObject, c4.ux());
                } else if (c4.f() == 2) {
                    w.sr().c(String.valueOf(i4), jSONObject, c4.ux());
                }
            } else if (c4.f() != 2 || "sdk_init".equals(str2) || "sdk_init_end".equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
            } else {
                w.sr().xv(String.valueOf(i4), jSONObject, c4.ux());
            }
        }
    }

    public static com.bytedance.msdk.core.k.w c(com.bytedance.msdk.core.k.w wVar, int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (wVar != null && com.bytedance.msdk.core.c.w().gw()) {
            if (i4 == 101) {
                return f28090c.get(wVar.xk());
            }
            if (i4 == 100 && (wVar.f() == 2 || wVar.f() == 3 || wVar.f() == 4)) {
                List<p> c4 = xv.c(wVar, wVar.xk());
                Object obj = wVar.ux().get("rule_in_use");
                int intValue = obj != null ? ((Integer) obj).intValue() : -1;
                wVar.ux().put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (c4 == null || intValue == 0) {
                    return wVar;
                }
                com.bytedance.msdk.core.k.w clone = wVar.clone();
                if (clone.k()) {
                    clone.w(c4);
                } else {
                    clone.c(c4);
                }
                Object obj2 = clone.ux().get("max_ecpm");
                Object obj3 = clone.ux().get("min_ecpm");
                if (obj2 != null) {
                    clone.sr(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    clone.ux(((Double) obj3).doubleValue());
                }
                f28090c.put(wVar.xk(), clone);
                clone.ux().put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return clone;
            }
        }
        return null;
    }

    public static int c(String str, int i4, Map<String, Object> map) {
        com.bytedance.msdk.core.k.ux ux;
        int i5;
        if (!TextUtils.isEmpty(str) && i4 == 1 && (ux = com.bytedance.msdk.core.c.w().ux(str)) != null) {
            int xv = ux.xv();
            String sr = ux.sr();
            if (xv > 0 && !TextUtils.isEmpty(sr)) {
                double c4 = w.sr().c(3, str, xv);
                List<com.bytedance.msdk.core.k.sr> f4 = com.bytedance.msdk.core.c.w().f(String.valueOf(i4));
                if (f4 != null && f4.size() > 0) {
                    for (com.bytedance.msdk.core.k.sr srVar : f4) {
                        if (c4 > srVar.f() && c4 <= srVar.ux()) {
                            i5 = ux.c(String.valueOf(srVar.xv()));
                            map.put(TTRequestExtraParams.PARAM_BANNER_REFRESH_TIME, Integer.valueOf(i5));
                            break;
                        }
                    }
                }
                i5 = 0;
                if (i5 >= 10000 && i5 <= 180000) {
                    return i5;
                }
            }
        }
        return 0;
    }

    public static void c(int i4, String str, JSONObject jSONObject) {
        com.bytedance.msdk.core.k.ux ux;
        if (com.bytedance.msdk.core.c.w().gw() && i4 == 2 && (ux = com.bytedance.msdk.core.c.w().ux(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", ux.sr());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.w wVar) {
        Object obj;
        if (!com.bytedance.msdk.core.c.w().gw() || list == null || wVar == null) {
            return;
        }
        for (com.bytedance.msdk.c.ux uxVar : list) {
            if (uxVar != null) {
                if (wVar.f() == 1) {
                    uxVar.getMediaExtraInfo().put("gm_usb", ux.xv(wVar.yu()));
                } else if (wVar.f() == 2 && (obj = wVar.ux().get("user_label_value")) != null) {
                    uxVar.getMediaExtraInfo().put("gm_usb", ((com.bytedance.msdk.core.k.sr) obj).c());
                }
            }
        }
    }

    public static void c(boolean z3, com.bytedance.msdk.xv.sr srVar, JSONObject jSONObject, Map<String, Object> map) {
        if (srVar == null || !com.bytedance.msdk.core.c.w().gw()) {
            return;
        }
        ux.sr().c(z3, srVar, jSONObject, map);
    }

    public static void c(int i4, List<p> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (p pVar : list) {
            if (pVar != null && pVar.s() == 0) {
                jSONArray.put(pVar.ia());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
