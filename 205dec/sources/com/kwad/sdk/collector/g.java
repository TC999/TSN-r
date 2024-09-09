package com.kwad.sdk.collector;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int anC;
    private String anB;
    private int state;

    public g(String str, int i4) {
        this.anB = str;
        this.state = i4;
    }

    private String Az() {
        int lastIndexOf;
        String str = this.anB;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(lastIndexOf + 1) : str : str;
    }

    public static JSONArray t(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (g gVar : list) {
            jSONArray.put(gVar.toJson());
        }
        return jSONArray;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Az());
            jSONObject.put("state", this.state);
        } catch (JSONException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
        return jSONObject;
    }
}
