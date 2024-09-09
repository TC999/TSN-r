package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class yu {

    /* renamed from: c  reason: collision with root package name */
    private int f34910c;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ox> f34911f;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34912w;
    private String xv;

    public yu(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f34910c = 0;
        this.xv = "\u518d\u770b\u4e00\u4e2a\u83b7\u53d6";
        this.sr = "\u66f4\u591a\u5956\u52b1";
        this.f34911f = new ArrayList<>();
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.f34910c = optJSONObject.optInt("again_type", 0);
        this.xv = optJSONObject.optString("entrance_prefix", "\u518d\u770b\u4e00\u4e2a\u83b7\u53d6");
        this.sr = optJSONObject.optString("entrance_suffix", "\u66f4\u591a\u5956\u52b1");
        this.f34912w = optJSONObject.optString("pre_sessions");
        this.ux = optJSONObject.optString("play_again_rit");
        JSONArray optJSONArray = optJSONObject.optJSONArray("again_dialog_config");
        if (optJSONArray != null) {
            this.f34911f = new ArrayList<>();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                if (optJSONObject2 != null) {
                    this.f34911f.add(new ox(optJSONObject2));
                }
            }
        }
    }

    private static yu f(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.bn();
    }

    public static String sr(me meVar) {
        yu f4 = f(meVar);
        if (f4 == null) {
            return null;
        }
        return f4.ux;
    }

    public static ArrayList<ox> ux(me meVar) {
        yu f4 = f(meVar);
        if (f4 != null) {
            return f4.f34911f;
        }
        return new ArrayList<>();
    }

    public static boolean w(me meVar) {
        yu f4 = f(meVar);
        if (f4 == null) {
            return false;
        }
        int i4 = f4.f34910c;
        return (i4 == 1 || i4 == 3) && c(meVar);
    }

    public static String xv(me meVar) {
        yu f4 = f(meVar);
        if (f4 == null) {
            return null;
        }
        return f4.f34912w;
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.f34910c);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject2.put("entrance_prefix", this.xv);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject2.put("entrance_suffix", this.sr);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject2.put("pre_sessions", this.f34912w);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject2.put("play_again_rit", this.ux);
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<ox> arrayList = this.f34911f;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ox> it = this.f34911f.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().c());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String w(String str) {
        return str + "custom_again";
    }

    public static boolean c(me meVar) {
        yu f4 = f(meVar);
        if (f4 == null || pr.c(meVar)) {
            return false;
        }
        int i4 = f4.f34910c;
        return (i4 == 1 || i4 == 2 || i4 == 3) && !TextUtils.isEmpty(f4.f34912w);
    }

    public static String c(String str) {
        return str + "again";
    }

    public static String c(me meVar, String str, String str2) {
        yu f4 = f(meVar);
        if (f4 == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "\u518d\u770b\u4e00\u4e2a\u83b7\u53d6\u66f4\u591a\u5956\u52b1";
            }
            return "\u518d\u770b\u4e00\u4e2a\u83b7\u53d6" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(f4.xv) ? "\u518d\u770b\u4e00\u4e2a\u83b7\u53d6" : f4.xv);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            sb.append(TextUtils.isEmpty(f4.sr) ? "\u66f4\u591a\u5956\u52b1" : f4.sr);
        } else {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }
}
