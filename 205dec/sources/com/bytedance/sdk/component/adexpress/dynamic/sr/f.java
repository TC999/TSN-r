package com.bytedance.sdk.component.adexpress.dynamic.sr;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.sr.ux;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: r  reason: collision with root package name */
    private static HashMap<String, String> f29299r;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f29300c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.xv.sr f29301f;
    private c sr;
    private xv ux;

    /* renamed from: w  reason: collision with root package name */
    private JSONObject f29302w;
    private com.bytedance.sdk.component.adexpress.dynamic.xv.xv xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        float f29303c;

        /* renamed from: w  reason: collision with root package name */
        float f29304w;
        boolean xv;

        public static c c(JSONObject jSONObject) {
            c cVar = new c();
            if (jSONObject != null) {
                cVar.f29303c = (float) jSONObject.optDouble("width");
                cVar.f29304w = (float) jSONObject.optDouble("height");
                cVar.xv = jSONObject.optBoolean("isLandscape");
            }
            return cVar;
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f29299r = hashMap;
        hashMap.put(MediaFormat.KEY_SUBTITLE, "description");
        f29299r.put("source", "source|app.app_name");
        f29299r.put("screenshot", "dynamic_creative.screenshot");
    }

    public f(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f29300c = jSONObject;
        this.f29302w = jSONObject2;
        this.xv = new com.bytedance.sdk.component.adexpress.dynamic.xv.xv(jSONObject2);
        this.sr = c.c(jSONObject3);
        this.f29301f = com.bytedance.sdk.component.adexpress.dynamic.xv.sr.c(jSONObject4);
    }

    private void w(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        com.bytedance.sdk.component.adexpress.dynamic.xv.xv xvVar;
        Object c4;
        Object c5;
        Object c6;
        Object c7;
        if (evVar == null || (xvVar = this.xv) == null || (c4 = xvVar.c("image.0.url")) == null) {
            return;
        }
        String valueOf = String.valueOf(c4);
        if (TextUtils.isEmpty(valueOf) || (c5 = this.xv.c("title")) == null) {
            return;
        }
        String valueOf2 = String.valueOf(c5);
        if (TextUtils.isEmpty(valueOf2) || (c6 = this.xv.c("description")) == null) {
            return;
        }
        String valueOf3 = String.valueOf(c6);
        if (TextUtils.isEmpty(valueOf3) || (c7 = this.xv.c(RewardPlus.ICON)) == null) {
            return;
        }
        String valueOf4 = String.valueOf(c7);
        if (TextUtils.isEmpty(valueOf4)) {
            return;
        }
        Object c8 = this.xv.c("app.app_name");
        Object c9 = this.xv.c("source");
        if (c8 == null && c9 == null) {
            return;
        }
        if (c8 == null) {
            c8 = c9;
        }
        String valueOf5 = String.valueOf(c8);
        if (TextUtils.isEmpty(valueOf5)) {
            return;
        }
        evVar.c("imageUrl", valueOf);
        evVar.c("title", valueOf2);
        evVar.c("description", valueOf3);
        evVar.c(RewardPlus.ICON, valueOf4);
        evVar.c("app_name", valueOf5);
        evVar.c(true);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.xv.ev c(double d4, int i4, double d5, String str, bk bkVar) {
        JSONObject jSONObject;
        this.xv.c();
        try {
            jSONObject = new JSONObject(this.f29301f.f29378w);
        } catch (JSONException e4) {
            e4.printStackTrace();
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.xv.ev c4 = c(sr.c(this.f29300c, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.xv.ev) null);
        c(c4);
        ux uxVar = new ux(d4, i4, d5, str, bkVar);
        ux.c cVar = new ux.c();
        c cVar2 = this.sr;
        cVar.f29312c = cVar2.f29303c;
        cVar.f29313w = cVar2.f29304w;
        cVar.xv = 0.0f;
        uxVar.c(cVar);
        uxVar.c(c4, 0.0f, 0.0f);
        uxVar.c();
        com.bytedance.sdk.component.adexpress.dynamic.xv.w wVar = uxVar.f29310c;
        if (wVar.sr == 65536.0f) {
            return null;
        }
        return wVar.f29385f;
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        int c4;
        if (evVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.c.c.c.c().xv() != null) {
            c4 = com.bytedance.sdk.component.adexpress.c.c.c.c().xv().fp();
        } else {
            c4 = com.bytedance.sdk.component.adexpress.sr.f.c(com.bytedance.sdk.component.adexpress.sr.getContext());
        }
        int w3 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), c4);
        c cVar = this.sr;
        float min = cVar.xv ? cVar.f29303c : Math.min(cVar.f29303c, w3);
        if (this.sr.f29304w == 0.0f) {
            evVar.ux(min);
            evVar.p().sr().p("auto");
            evVar.f(0.0f);
            return;
        }
        evVar.ux(min);
        int w4 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), com.bytedance.sdk.component.adexpress.sr.f.xv(com.bytedance.sdk.component.adexpress.sr.getContext()));
        c cVar2 = this.sr;
        evVar.f(cVar2.xv ? cVar2.f29304w : Math.min(cVar2.f29304w, w4));
        evVar.p().sr().p("fixed");
    }

    public com.bytedance.sdk.component.adexpress.dynamic.xv.ev c(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.equals(optString, "custom-component-vessel")) {
            int optInt = jSONObject.optInt("componentId");
            if (this.f29301f != null) {
                xv xvVar = new xv();
                this.ux = xvVar;
                JSONObject c4 = xvVar.c(this.f29301f.f29377c, optInt, jSONObject);
                if (c4 != null) {
                    jSONObject = c4;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.xv.ev c5 = c(jSONObject);
        c5.c(evVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            c5.c((List<com.bytedance.sdk.component.adexpress.dynamic.xv.ev>) null);
            return c5;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i4);
            if (optJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(optString, "tag-group")) {
                    length = c5.p().sr().ta();
                } else {
                    length = optJSONArray2.length();
                }
                for (int i5 = 0; i5 < length; i5++) {
                    com.bytedance.sdk.component.adexpress.dynamic.xv.ev c6 = c(optJSONArray2.optJSONObject(i5), c5);
                    if (com.bytedance.sdk.component.adexpress.sr.c() && "skip-with-time".equals(c5.p().getType()) && !"transparent".equals(c5.j()) && !TextUtils.isEmpty(c5.j())) {
                        c6.xv(c5.j());
                    }
                    arrayList.add(c6);
                    arrayList3.add(c6);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            c5.c(arrayList);
        }
        if (arrayList2.size() > 0) {
            c5.w(arrayList2);
        }
        return c5;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.xv.ev c(JSONObject jSONObject) {
        String c4;
        JSONObject jSONObject2;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("id");
        JSONObject optJSONObject = jSONObject.optJSONObject("values");
        gd.c(optString, optJSONObject);
        JSONObject c5 = gd.c(optString, gd.c(jSONObject.optJSONArray("sceneValues")), optJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.xv.ev evVar = new com.bytedance.sdk.component.adexpress.dynamic.xv.ev();
        if (TextUtils.isEmpty(optString2)) {
            evVar.w(String.valueOf(evVar.hashCode()));
        } else {
            evVar.w(optString2);
        }
        if (optJSONObject != null) {
            w(evVar);
            evVar.xv((float) optJSONObject.optDouble("x"));
            evVar.sr((float) optJSONObject.optDouble("y"));
            evVar.ux((float) optJSONObject.optDouble("width"));
            evVar.f((float) optJSONObject.optDouble("height"));
            evVar.r(optJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.xv.ux uxVar = new com.bytedance.sdk.component.adexpress.dynamic.xv.ux();
            uxVar.c(optString);
            uxVar.w(optJSONObject.optString("data"));
            uxVar.xv(optJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.xv.f c6 = com.bytedance.sdk.component.adexpress.dynamic.xv.f.c(optJSONObject);
            uxVar.c(c6);
            com.bytedance.sdk.component.adexpress.dynamic.xv.f c7 = com.bytedance.sdk.component.adexpress.dynamic.xv.f.c(c5);
            if (c7 == null) {
                uxVar.w(c6);
            } else {
                uxVar.w(c7);
            }
            c(c6);
            c(c7);
            if (TextUtils.equals(optString, "video-image-budget") && (jSONObject2 = this.f29302w) != null) {
                c(uxVar, jSONObject2.optInt("image_mode"));
            }
            String type = uxVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.xv.f sr = uxVar.sr();
            if (f29299r.containsKey(type) && !sr.b()) {
                sr.u(f29299r.get(type));
            }
            if (sr.b()) {
                c4 = uxVar.w();
            } else {
                c4 = c(uxVar.w());
            }
            if (com.bytedance.sdk.component.adexpress.sr.c()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    c4 = c("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    c4 = c("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && c6.v()) {
                    c4 = c("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(c()) && (TextUtils.equals("logo-union", optString) || TextUtils.equals("logo", optString))) {
                uxVar.w(c4 + "adx:" + c());
            } else {
                uxVar.w(c4);
            }
            evVar.c(uxVar);
        }
        return evVar;
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.xv.ux uxVar, int i4) {
        int lastIndexOf;
        if (i4 != 5 && i4 != 15 && i4 != 50 && i4 != 154) {
            uxVar.c("image");
            String c4 = gd.c("image");
            com.bytedance.sdk.component.adexpress.dynamic.xv.f sr = uxVar.sr();
            sr.u(c4);
            uxVar.f().u(c4);
            String c5 = gd.c("image", "clickArea");
            if (!TextUtils.isEmpty(c5)) {
                sr.ys(c5);
                uxVar.f().ys(c5);
            }
            JSONObject ky = sr.ky();
            if (ky != null) {
                sr.j(ky.optString("imageLottieTosPath"));
                sr.a(ky.optBoolean("animationsLoop"));
                sr.n(ky.optInt("lottieAppNameMaxLength"));
                sr.z(ky.optInt("lottieAdDescMaxLength"));
                sr.ck(ky.optInt("lottieAdTitleMaxLength"));
            }
            uxVar.w(c4);
            if (c4 != null && (lastIndexOf = c4.lastIndexOf(".")) > 0) {
                String substring = c4.substring(0, lastIndexOf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", c(substring + ".width"));
                    jSONObject.put("height", c(substring + ".height"));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                uxVar.xv(jSONObject.toString());
            }
            sr.ny();
            return;
        }
        uxVar.c("video");
        String c6 = gd.c("video");
        uxVar.sr().u(c6);
        String c7 = gd.c("video", "clickArea");
        if (!TextUtils.isEmpty(c7)) {
            uxVar.sr().ys(c7);
            uxVar.f().ys(c7);
        }
        uxVar.f().u(c6);
        uxVar.w(c6);
        uxVar.sr().nd();
    }

    private String c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.xv.w(str2)) {
                String valueOf = String.valueOf(this.xv.c(str2));
                if (!TextUtils.isEmpty(valueOf)) {
                    return valueOf;
                }
            }
        }
        return "";
    }

    private String c() {
        com.bytedance.sdk.component.adexpress.dynamic.xv.xv xvVar = this.xv;
        return xvVar == null ? "" : String.valueOf(xvVar.c("adx_name"));
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.xv.f fVar) {
        if (fVar == null) {
            return;
        }
        String ba = fVar.ba();
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            String sr = com.bytedance.sdk.component.adexpress.sr.f.sr(com.bytedance.sdk.component.adexpress.sr.getContext());
            if ("zh".equals(sr)) {
                sr = "cn";
            }
            if (!TextUtils.isEmpty(sr) && fVar.f() != null) {
                String optString = fVar.f().optString(sr);
                if (!TextUtils.isEmpty(optString)) {
                    ba = optString;
                }
            }
        }
        if (TextUtils.isEmpty(ba)) {
            return;
        }
        int indexOf = ba.indexOf("{{");
        int indexOf2 = ba.indexOf("}}");
        if (indexOf >= 0 && indexOf2 >= 0 && indexOf2 >= indexOf) {
            String c4 = c(ba.substring(indexOf + 2, indexOf2));
            StringBuilder sb = new StringBuilder(ba.substring(0, indexOf));
            if (!TextUtils.isEmpty(c4)) {
                sb.append(c4);
            }
            sb.append(ba.substring(indexOf2 + 2));
            fVar.a(sb.toString());
            return;
        }
        fVar.a(ba);
    }
}
