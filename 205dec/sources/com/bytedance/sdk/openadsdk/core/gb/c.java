package com.bytedance.sdk.openadsdk.core.gb;

import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.live.sr.w;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.n.f;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final int f33689c;

    public c(int i4) {
        this.f33689c = i4;
    }

    public int c(int i4) {
        int i5 = this.f33689c >> i4;
        int i6 = i5 & 7;
        if (i6 == 0) {
            return sr();
        }
        return ((i5 & 8) >> 3) == 1 ? -i6 : i6;
    }

    public int sr() {
        return 2;
    }

    public String toString() {
        return String.valueOf(this.f33689c);
    }

    public void ux() {
        JSONObject jr = ls.w().jr();
        if (jr == null) {
            return;
        }
        try {
            c(jr, "com.byted.live.lite", 4, true);
            c(jr, "com.byted.csj.ext", 8, true);
            c(jr, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
            a.xv("onReceiveServerStatus", th);
        }
    }

    public int w() {
        return c(4);
    }

    public int xv() {
        return c(8);
    }

    public c(int i4, boolean z3) {
        this.f33689c = i4;
        f.c(new p("csj-plugin-check") { // from class: com.bytedance.sdk.openadsdk.core.gb.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.w() == 5) {
                    w.c();
                }
            }
        });
    }

    public int c() {
        return c(0);
    }

    public int c(String str) {
        if ("com.byted.live.lite".equals(str)) {
            return w();
        }
        if ("com.byted.csj.ext".equals(str)) {
            return xv();
        }
        if ("com.byted.pangle".equals(str)) {
            return c();
        }
        return sr();
    }

    private void c(JSONObject jSONObject, String str, int i4, boolean z3) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return;
        }
        int optInt = optJSONObject.optInt("state", 2);
        if (optInt == 5) {
            int w3 = com.bytedance.sdk.openadsdk.n.p.w(str);
            int xv = com.bytedance.sdk.openadsdk.n.p.xv(str);
            int sr = com.bytedance.sdk.openadsdk.n.p.sr(str);
            if (z3 || xv > sr) {
                String optString = optJSONObject.optString("api_rule", "=");
                String optString2 = optJSONObject.optString("plugin_rule", "=");
                int optInt2 = optJSONObject.optInt("api_v", 0);
                int optInt3 = optJSONObject.optInt("plugin_v", 0);
                if (c(w3, optInt2, optString) && c(xv, optInt3, optString2)) {
                    com.bytedance.sdk.openadsdk.n.p.c(str);
                }
            }
        } else if (optInt == -1 && c(i4) == 5 && com.bytedance.sdk.openadsdk.n.p.xv(str) > com.bytedance.sdk.openadsdk.n.p.sr(str)) {
            com.bytedance.sdk.openadsdk.n.p.c(str);
        }
    }

    private boolean c(int i4, int i5, String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 60:
                if (str.equals("<")) {
                    c4 = 0;
                    break;
                }
                break;
            case 61:
                if (str.equals("=")) {
                    c4 = 1;
                    break;
                }
                break;
            case 62:
                if (str.equals(">")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1921:
                if (str.equals("<=")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1952:
                if (str.equals("==")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1983:
                if (str.equals(">=")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return i4 < i5;
            case 1:
            case 4:
                return i4 == i5;
            case 2:
                return i4 > i5;
            case 3:
                return i4 <= i5;
            case 5:
                return i4 >= i5;
            default:
                return false;
        }
    }
}
