package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IntervalFreqctlBean.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g extends d {

    /* renamed from: d  reason: collision with root package name */
    private List<e> f465d;

    /* renamed from: e  reason: collision with root package name */
    private String f466e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntervalFreqctlBean.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements Comparator<e> {
        a(g gVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i4 = ((eVar.e() - eVar2.e()) > 0L ? 1 : ((eVar.e() - eVar2.e()) == 0L ? 0 : -1));
            if (i4 == 0) {
                return 0;
            }
            return i4 > 0 ? 1 : -1;
        }
    }

    public g(String str, String str2, int i4, String str3) {
        super(str, str2, i4);
        this.f466e = str3;
    }

    public void a(String str, int i4) {
        for (e eVar : e()) {
            if (TextUtils.equals(eVar.d(), str)) {
                eVar.a(i4);
                return;
            }
        }
    }

    public List<e> e() {
        g h4;
        List<e> list = this.f465d;
        if (list == null || list.size() == 0) {
            this.f465d = new ArrayList();
            if (this.f466e == null && (h4 = i.b().h(this.f457a)) != null) {
                this.f466e = h4.f466e;
            }
            if (TextUtils.isEmpty(this.f466e)) {
                return this.f465d;
            }
            try {
                JSONArray jSONArray = new JSONArray(this.f466e);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    e eVar = new e();
                    String string = jSONObject.getString("waterfall_show_rule_id");
                    if (!TextUtils.isEmpty(string)) {
                        eVar.b(jSONObject.optInt("waterfall_show_freq"));
                        eVar.b(jSONObject.optLong("waterfall_show_span"));
                        eVar.a(string);
                        if (jSONObject.has("count")) {
                            eVar.a(jSONObject.optInt("count"));
                        }
                        if (jSONObject.has("effective_time")) {
                            eVar.a(jSONObject.optLong("effective_time"));
                        }
                        this.f465d.add(eVar);
                    }
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (this.f465d.size() > 0) {
                Collections.sort(this.f465d, new a(this));
            }
            return this.f465d;
        }
        return this.f465d;
    }

    public String f() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (e eVar : e()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("waterfall_show_freq", eVar.c());
                jSONObject.put("waterfall_show_span", eVar.e());
                jSONObject.put("waterfall_show_rule_id", eVar.d());
                jSONObject.put("count", eVar.a());
                jSONObject.put("effective_time", eVar.b());
                jSONArray.put(jSONObject);
            }
            this.f466e = jSONArray.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f466e;
    }

    public String g() {
        try {
            JSONArray jSONArray = new JSONArray(this.f466e);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                jSONObject.put("count", 0);
                Logger.d("TTMediationSDK_IntervalFreqctlBean", "ruleId = " + jSONObject.optString("waterfall_show_rule_id"));
                jSONObject.put("effective_time", f.a(jSONObject.getLong("waterfall_show_span")));
            }
            this.f466e = jSONArray.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f466e;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f457a + "', showRulesVersion='" + this.f458b + "', timingMode=" + this.f459c + "}IntervalFreqctlBean{freqctlRules=" + this.f465d + ", freqctlRulesJson='" + this.f466e + "'}";
    }

    public void a(String str, long j4) {
        for (e eVar : e()) {
            if (TextUtils.equals(eVar.d(), str)) {
                eVar.a(j4);
                return;
            }
        }
    }
}
