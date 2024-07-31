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

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IntervalFreqctlBean extends BaseIntervalBean {

    /* renamed from: d */
    private List<FreqctlBean> f472d;

    /* renamed from: e */
    private String f473e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntervalFreqctlBean.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0968a implements Comparator<FreqctlBean> {
        C0968a(IntervalFreqctlBean intervalFreqctlBean) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(FreqctlBean freqctlBean, FreqctlBean freqctlBean2) {
            int i = ((freqctlBean.m59610e() - freqctlBean2.m59610e()) > 0L ? 1 : ((freqctlBean.m59610e() - freqctlBean2.m59610e()) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    public IntervalFreqctlBean(String str, String str2, int i, String str3) {
        super(str, str2, i);
        this.f473e = str3;
    }

    /* renamed from: a */
    public void m59606a(String str, int i) {
        for (FreqctlBean freqctlBean : m59604e()) {
            if (TextUtils.equals(freqctlBean.m59611d(), str)) {
                freqctlBean.m59619a(i);
                return;
            }
        }
    }

    /* renamed from: e */
    public List<FreqctlBean> m59604e() {
        IntervalFreqctlBean m59577h;
        List<FreqctlBean> list = this.f472d;
        if (list == null || list.size() == 0) {
            this.f472d = new ArrayList();
            if (this.f473e == null && (m59577h = IntervalShowControl.m59587b().m59577h(this.f464a)) != null) {
                this.f473e = m59577h.f473e;
            }
            if (TextUtils.isEmpty(this.f473e)) {
                return this.f472d;
            }
            try {
                JSONArray jSONArray = new JSONArray(this.f473e);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    FreqctlBean freqctlBean = new FreqctlBean();
                    String string = jSONObject.getString("waterfall_show_rule_id");
                    if (!TextUtils.isEmpty(string)) {
                        freqctlBean.m59614b(jSONObject.optInt("waterfall_show_freq"));
                        freqctlBean.m59613b(jSONObject.optLong("waterfall_show_span"));
                        freqctlBean.m59616a(string);
                        if (jSONObject.has("count")) {
                            freqctlBean.m59619a(jSONObject.optInt("count"));
                        }
                        if (jSONObject.has("effective_time")) {
                            freqctlBean.m59618a(jSONObject.optLong("effective_time"));
                        }
                        this.f472d.add(freqctlBean);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.f472d.size() > 0) {
                Collections.sort(this.f472d, new C0968a(this));
            }
            return this.f472d;
        }
        return this.f472d;
    }

    /* renamed from: f */
    public String m59603f() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (FreqctlBean freqctlBean : m59604e()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("waterfall_show_freq", freqctlBean.m59612c());
                jSONObject.put("waterfall_show_span", freqctlBean.m59610e());
                jSONObject.put("waterfall_show_rule_id", freqctlBean.m59611d());
                jSONObject.put("count", freqctlBean.m59620a());
                jSONObject.put("effective_time", freqctlBean.m59615b());
                jSONArray.put(jSONObject);
            }
            this.f473e = jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.f473e;
    }

    /* renamed from: g */
    public String m59602g() {
        try {
            JSONArray jSONArray = new JSONArray(this.f473e);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("count", 0);
                Logger.m37562d("TTMediationSDK_IntervalFreqctlBean", "ruleId = " + jSONObject.optString("waterfall_show_rule_id"));
                jSONObject.put("effective_time", IntervalEffectiveTime.m59609a(jSONObject.getLong("waterfall_show_span")));
            }
            this.f473e = jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.f473e;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.f464a + "', showRulesVersion='" + this.f465b + "', timingMode=" + this.f466c + "}IntervalFreqctlBean{freqctlRules=" + this.f472d + ", freqctlRulesJson='" + this.f473e + "'}";
    }

    /* renamed from: a */
    public void m59605a(String str, long j) {
        for (FreqctlBean freqctlBean : m59604e()) {
            if (TextUtils.equals(freqctlBean.m59611d(), str)) {
                freqctlBean.m59618a(j);
                return;
            }
        }
    }
}
