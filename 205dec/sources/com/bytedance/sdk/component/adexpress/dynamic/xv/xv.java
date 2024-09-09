package com.bytedance.sdk.component.adexpress.dynamic.xv;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Object> f29389c = new HashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private JSONObject f29390w;

    public xv(JSONObject jSONObject) {
        this.f29390w = jSONObject;
    }

    public Object c(String str) {
        if (this.f29389c.containsKey(str)) {
            return this.f29389c.get(str);
        }
        return null;
    }

    public boolean w(String str) {
        return this.f29389c.containsKey(str);
    }

    public void c() {
        Iterator<String> keys = this.f29390w.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = this.f29390w.opt(next);
            int i4 = 0;
            if (TextUtils.equals("image", next)) {
                if (opt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (i4 < jSONArray.length()) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                            if (optJSONObject != null) {
                                Iterator<String> keys2 = optJSONObject.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    Object opt2 = optJSONObject.opt(next2);
                                    HashMap<String, Object> hashMap = this.f29389c;
                                    hashMap.put(next + "." + i4 + "." + next2, opt2);
                                }
                            }
                            i4++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (opt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) opt);
                        Iterator<String> keys3 = jSONObject.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            Object opt3 = jSONObject.opt(next3);
                            if ((opt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i5 = 0; i5 < ((JSONArray) opt3).length(); i5++) {
                                    HashMap<String, Object> hashMap2 = this.f29389c;
                                    hashMap2.put(next + "." + next3 + "." + i5, ((JSONArray) opt3).opt(i5));
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, PangleAdapterUtils.MEDIA_EXTRA_COUPON)) {
                                Iterator<String> keys4 = ((JSONObject) opt3).keys();
                                while (keys4.hasNext()) {
                                    String next4 = keys4.next();
                                    Object opt4 = ((JSONObject) opt3).opt(next4);
                                    HashMap<String, Object> hashMap3 = this.f29389c;
                                    hashMap3.put(next + "." + next3 + "." + next4, opt4);
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                c(next, next3, opt3);
                            } else {
                                HashMap<String, Object> hashMap4 = this.f29389c;
                                hashMap4.put(next + "." + next3, opt3);
                            }
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            } else if (!(opt instanceof JSONObject)) {
                this.f29389c.put(next, opt);
                if (opt instanceof String) {
                    this.f29389c.put(next, opt);
                }
            } else if (opt != null) {
                JSONObject jSONObject2 = (JSONObject) opt;
                Iterator<String> keys5 = jSONObject2.keys();
                while (keys5.hasNext()) {
                    String next5 = keys5.next();
                    Object opt5 = jSONObject2.opt(next5);
                    HashMap<String, Object> hashMap5 = this.f29389c;
                    hashMap5.put(next + "." + next5, opt5);
                }
            }
        }
    }

    private void c(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if ((opt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i4 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i4 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            Object opt2 = optJSONObject.opt(next2);
                            HashMap<String, Object> hashMap = this.f29389c;
                            hashMap.put(str + "." + str2 + "." + next + "." + i4 + "." + next2, opt2);
                        }
                        i4++;
                    }
                }
            } else {
                HashMap<String, Object> hashMap2 = this.f29389c;
                hashMap2.put(str + "." + str2 + "." + next, opt);
            }
        }
    }
}
