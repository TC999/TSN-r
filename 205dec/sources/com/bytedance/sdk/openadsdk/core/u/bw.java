package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bw {

    /* renamed from: c  reason: collision with root package name */
    private int f34625c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34626f;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34627w;
    private String xv;

    public bw(JSONObject jSONObject) {
        this.f34626f = false;
        JSONObject optJSONObject = jSONObject.optJSONObject("reward_live");
        if (optJSONObject != null) {
            this.f34626f = true;
            w(optJSONObject.optInt("reward_live_type", 1));
            xv(optJSONObject.optInt("reward_live_style", 1));
            c(optJSONObject.optString("reward_live_text"));
            c(optJSONObject.optInt("reward_start_time", 5));
            sr(optJSONObject.optInt("reward_close_time", 10));
        }
    }

    public static int ev(me meVar) {
        bw gd = gd(meVar);
        if (gd == null) {
            return 10;
        }
        return Math.max(gd.ux, 3);
    }

    public static String f(me meVar) {
        bw gd = gd(meVar);
        return gd == null ? "\u53bb\u6296\u97f3\u89c2\u770b\u76f4\u64ad\n\u53ef\u63d0\u524d5s\u83b7\u5f97\u5956\u52b1\u54e6" : gd.xv;
    }

    private static bw gd(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.hl();
    }

    public static int r(me meVar) {
        bw gd = gd(meVar);
        if (gd == null) {
            return 5;
        }
        return Math.max(gd.sr, 0);
    }

    public static boolean sr(me meVar) {
        bw gd = gd(meVar);
        if (gd != null && gd.f34626f && TTLiveCommerceHelper.getInstance().isLiveCommerceScene(meVar)) {
            int i4 = gd.f34625c;
            return i4 == 3 || i4 == 4;
        }
        return false;
    }

    public static int ux(me meVar) {
        bw gd = gd(meVar);
        if (gd == null) {
            return 1;
        }
        return gd.f34627w;
    }

    public static int w(me meVar) {
        bw gd = gd(meVar);
        if (gd == null) {
            return 1;
        }
        return gd.f34625c;
    }

    public static boolean xv(me meVar) {
        bw gd = gd(meVar);
        return gd == null || !gd.f34626f || gd.f34625c == 1;
    }

    public void c(JSONObject jSONObject) {
        if (this.f34626f) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.f34625c);
                jSONObject2.put("reward_live_style", this.f34627w);
                jSONObject2.put("reward_live_text", this.xv);
                jSONObject2.put("reward_start_time", this.sr);
                jSONObject2.put("reward_close_time", this.ux);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void w(int i4) {
        if (i4 != 2 && i4 != 3 && i4 != 4 && i4 != 1) {
            i4 = 1;
        }
        this.f34625c = i4;
    }

    private void sr(int i4) {
        if (i4 <= 3) {
            i4 = 3;
        }
        this.ux = i4;
    }

    private void xv(int i4) {
        if (i4 != 1 && i4 != 2 && i4 != 3) {
            i4 = 1;
        }
        this.f34627w = i4;
    }

    public static boolean c(me meVar) {
        bw gd = gd(meVar);
        if (gd == null) {
            return false;
        }
        return gd.f34626f;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f34627w == 3 ? "5s\u540e\u5c06\u4e3a\u4f60\u81ea\u52a8\u6253\u5f00\u6296\u97f3\n\u5728\u6296\u97f3\u89c2\u770b\u76f4\u64ad\n\u53ef\u63d0\u524d5s\u83b7\u5f97\u5956\u52b1\u54e6" : "\u53bb\u6296\u97f3\u89c2\u770b\u76f4\u64ad\n\u53ef\u63d0\u524d5s\u83b7\u5f97\u5956\u52b1\u54e6";
        }
        this.xv = str;
    }

    public void c(int i4) {
        this.sr = i4;
    }
}
