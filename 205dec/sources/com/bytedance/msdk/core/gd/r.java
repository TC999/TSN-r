package com.bytedance.msdk.core.gd;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends sr {
    private final String ev;

    /* renamed from: f  reason: collision with root package name */
    private List<ux> f28005f;
    private final String gd;

    /* renamed from: p  reason: collision with root package name */
    private c f28006p;

    /* renamed from: r  reason: collision with root package name */
    private String f28007r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public String f28009c;

        /* renamed from: w  reason: collision with root package name */
        public String f28010w;
        public String xv;

        public c(String str, String str2, String str3) {
            this.f28009c = str;
            this.f28010w = str2;
            this.xv = str3;
        }
    }

    public r(String str, String str2, String str3, String str4, int i4, String str5) {
        super(str, str2, str3, str4, i4);
        this.ev = "count";
        this.gd = "effective_time";
        this.f28007r = str5;
        if (!TextUtils.isEmpty(str2)) {
            this.f28006p = new c("freq", "span", "rule_id");
        } else {
            this.f28006p = new c("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        }
    }

    public void c(String str, int i4) {
        for (ux uxVar : k()) {
            if (TextUtils.equals(uxVar.xv(), str)) {
                uxVar.w(i4);
                return;
            }
        }
    }

    public String gd() {
        try {
            JSONArray jSONArray = new JSONArray(this.f28007r);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", f.c(jSONObject.getLong(this.f28006p.f28010w)));
            }
            this.f28007r = jSONArray.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f28007r;
    }

    public synchronized List<ux> k() {
        r p3;
        List<ux> list = this.f28005f;
        if (list == null || list.size() == 0) {
            this.f28005f = new ArrayList();
            if (this.f28007r == null && (p3 = bk.c().p(this.f28011c)) != null) {
                this.f28007r = p3.f28007r;
            }
            if (TextUtils.isEmpty(this.f28007r)) {
                return this.f28005f;
            }
            try {
                JSONArray jSONArray = new JSONArray(this.f28007r);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    ux uxVar = new ux();
                    String string = jSONObject.getString(this.f28006p.xv);
                    if (!TextUtils.isEmpty(string)) {
                        uxVar.c(jSONObject.optInt(this.f28006p.f28009c));
                        uxVar.c(jSONObject.optLong(this.f28006p.f28010w));
                        uxVar.c(string);
                        if (jSONObject.has("count")) {
                            uxVar.w(jSONObject.optInt("count"));
                        }
                        if (jSONObject.has("effective_time")) {
                            uxVar.w(jSONObject.optLong("effective_time"));
                        }
                        this.f28005f.add(uxVar);
                    }
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (this.f28005f.size() > 0) {
                Collections.sort(this.f28005f, new Comparator<ux>() { // from class: com.bytedance.msdk.core.gd.r.1
                    @Override // java.util.Comparator
                    /* renamed from: c */
                    public int compare(ux uxVar2, ux uxVar3) {
                        long w3 = uxVar2.w() - uxVar3.w();
                        if (w3 == 0) {
                            return 0;
                        }
                        return w3 > 0 ? 1 : -1;
                    }
                });
            }
            return this.f28005f;
        }
        return this.f28005f;
    }

    public String p() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (ux uxVar : k()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.f28006p.f28009c, uxVar.c());
                jSONObject.put(this.f28006p.f28010w, uxVar.w());
                jSONObject.put(this.f28006p.xv, uxVar.xv());
                jSONObject.put("count", uxVar.ux());
                jSONObject.put("effective_time", uxVar.sr());
                jSONArray.put(jSONObject);
            }
            this.f28007r = jSONArray.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f28007r;
    }

    @Override // com.bytedance.msdk.core.gd.sr
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f28011c + "', showRulesVersion='" + this.xv + "', timingMode=" + this.ux + "}IntervalFreqctlBean{freqctlRules=" + this.f28005f + ", freqctlRulesJson='" + this.f28007r + "'}";
    }

    public void c(String str, long j4) {
        for (ux uxVar : k()) {
            if (TextUtils.equals(uxVar.xv(), str)) {
                uxVar.w(j4);
                return;
            }
        }
    }
}
