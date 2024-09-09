package com.bytedance.sdk.openadsdk.core.ls.xv;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.ev.sr.f;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.ls.ev;
import com.bytedance.sdk.openadsdk.core.ls.gd;
import com.bytedance.sdk.openadsdk.core.ls.w;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends gd implements w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f33894c;

    /* renamed from: w  reason: collision with root package name */
    private AtomicBoolean f33895w = new AtomicBoolean(false);
    private long xv;

    private c() {
    }

    public static String sr() {
        int i4 = Calendar.getInstance().get(11);
        String str = ys.sr(ls.getContext()) ? "w" : "c";
        return "q_" + i4 + str;
    }

    public static c xv() {
        if (f33894c == null) {
            synchronized (c.class) {
                if (f33894c == null) {
                    f33894c = new c();
                }
            }
        }
        return f33894c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public String c() {
        return "network";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.gd
    public void c(int i4, ev evVar) {
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int i4 = -1;
        if (ys.sr(ls.getContext())) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("wifi");
                if (optJSONObject == null) {
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("steps");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                    String string = jSONObject2.getString("target");
                    int i5 = jSONObject2.getInt("count");
                    int i6 = jSONObject2.getInt("timeout") * 1000;
                    WifiInfo w3 = i.w();
                    String bssid = w3 != null ? w3.getBSSID() : "";
                    i4 = c(string, 2, i5, i6, "wifi_" + bssid);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                Log.e("NetStateStrategy", "get net state wifi failed: " + e4.getMessage());
            }
        } else if (ys.ux(ls.getContext()) || ys.f(ls.getContext())) {
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("cellular");
                if (optJSONObject2 == null) {
                    return;
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(0);
                    String string2 = jSONObject3.getString("target");
                    int i7 = jSONObject3.getInt("count");
                    int i8 = jSONObject3.getInt("timeout") * 1000;
                    String r3 = ys.r(ls.getContext());
                    String ia = i.ia();
                    i4 = c(string2, 2, i7, i8, r3 + ia);
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
                Log.e("NetStateStrategy", "get net state mobile failed: " + e5.getMessage());
            }
        }
        c(i4);
    }

    public void ux() {
        AtomicBoolean atomicBoolean;
        if (System.currentTimeMillis() - this.xv < 60000 || (atomicBoolean = this.f33895w) == null || atomicBoolean.get()) {
            return;
        }
        this.f33895w.set(true);
        try {
            if (ls.w().zb()) {
                c(ls.w().wt());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e("NetStateStrategy", "runEvaluateTask failed" + th.getMessage());
        }
        this.f33895w.set(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.gd
    public JSONObject w(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.gd
    public boolean w() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public String c(String str) {
        return com.bytedance.sdk.component.f.xv.w.w.c(c(), ls.getContext()).w(sr(), "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public void c(String str, String str2) {
        com.bytedance.sdk.component.f.xv.w.w.c(c(), ls.getContext()).c(str, str2);
    }

    private void c(int i4) {
        if (i4 == -1) {
            return;
        }
        this.xv = System.currentTimeMillis();
        String sr = sr();
        c(sr, String.valueOf(i4));
        try {
            String ba = ux.c().ba();
            JSONObject jSONObject = TextUtils.isEmpty(ba) ? new JSONObject() : new JSONObject(ba);
            int optInt = jSONObject.optInt(sr, -1);
            jSONObject.put(sr, i4);
            ux.c().z(jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("time", sr);
            jSONObject2.put("newQty", i4);
            jSONObject2.put("oldQty", optInt);
            jSONObject2.put("splRegion", com.bytedance.sdk.openadsdk.core.ls.sr.c.r());
            Log.d("NetStateStrategy", "updateNetQuality: newQty: " + i4 + " oldQty: " + optInt);
            a.c().xv(jSONObject2);
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e("NetStateStrategy", "updateNetQuality failed: " + e4.getMessage());
        }
    }

    private int c(String str, int i4, int i5, int i6, String str2) {
        int c4 = f.c(str, i4, i5, i6);
        float c5 = f.c(str, i5, i6);
        int i7 = (c4 <= 0 || c4 >= 50) ? c4 >= 100 ? c5 > 0.0f ? 3 : 1 : c5 > 0.0f ? 2 : 4 : 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identifier", str2);
            jSONObject.put("network_quality", i7);
            jSONObject.put("rtt", c4);
            jSONObject.put("lost", c5);
            jSONObject.put("timeZone", sr());
            Log.d("NetStateStrategy", "getNetworkState " + jSONObject.toString());
        } catch (JSONException e4) {
            e4.printStackTrace();
            Log.e("NetStateStrategy", "getNetworkState failed" + e4.getMessage());
        }
        a.c().w(jSONObject);
        return i7;
    }
}
