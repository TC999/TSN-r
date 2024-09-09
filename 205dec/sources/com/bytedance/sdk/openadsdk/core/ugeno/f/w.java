package com.bytedance.sdk.openadsdk.core.ugeno.f;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.c.xv.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.component.adexpress.c.xv.c {
    public w() {
    }

    public static w ux(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return w(new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static w w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        w wVar = new w();
        wVar.c(jSONObject.optString("name"));
        wVar.w(jSONObject.optString("version"));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    c.C0435c c0435c = new c.C0435c();
                    c0435c.c(optJSONObject.optString("url"));
                    c0435c.w(optJSONObject.optString("md5"));
                    c0435c.c(optJSONObject.optInt("level"));
                    arrayList.add(c0435c);
                }
            }
        }
        wVar.c(arrayList);
        if (wVar.f()) {
            return wVar;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.c.xv.c
    public String ev() {
        if (f()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("name", w());
                jSONObject.putOpt("version", xv());
                JSONArray jSONArray = new JSONArray();
                if (getResources() != null) {
                    for (c.C0435c c0435c : getResources()) {
                        if (c0435c != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.putOpt("url", c0435c.c());
                            jSONObject2.putOpt("md5", c0435c.w());
                            jSONObject2.putOpt("level", Integer.valueOf(c0435c.xv()));
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                jSONObject.putOpt("resources", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.c.xv.c
    public boolean f() {
        return (TextUtils.isEmpty(xv()) || TextUtils.isEmpty(w())) ? false : true;
    }

    public w(com.bytedance.sdk.component.adexpress.c.xv.c cVar) {
        if (cVar != null) {
            c(cVar.w());
            w(cVar.xv());
            c(cVar.getResources());
        }
    }
}
