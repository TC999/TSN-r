package com.kwad.sdk.collector;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.collector.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9801g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int anC;
    private String anB;
    private int state;

    public C9801g(String str, int i) {
        this.anB = str;
        this.state = i;
    }

    /* renamed from: Az */
    private String m27751Az() {
        int lastIndexOf;
        String str = this.anB;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(lastIndexOf + 1) : str : str;
    }

    /* renamed from: t */
    public static JSONArray m27750t(List<C9801g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (C9801g c9801g : list) {
            jSONArray.put(c9801g.toJson());
        }
        return jSONArray;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", m27751Az());
            jSONObject.put("state", this.state);
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        return jSONObject;
    }
}
