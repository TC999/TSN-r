package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdCacheCannotUseInfo {

    /* renamed from: a */
    private int f396a;

    /* renamed from: b */
    private int f397b;

    /* renamed from: c */
    private String f398c;

    /* renamed from: d */
    private String f399d;

    /* renamed from: e */
    private int f400e;

    /* renamed from: f */
    private int f401f;

    /* renamed from: g */
    private int f402g;

    /* renamed from: a */
    public String m59694a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.KEY_REASON, this.f396a);
            jSONObject.put("fill_error_code", this.f397b);
            jSONObject.put("fill_error_msg", this.f398c);
            jSONObject.put("mediation_rit", this.f399d);
            jSONObject.put("load_sort", this.f400e);
            jSONObject.put("show_sort", this.f401f);
            jSONObject.put("has_shown", this.f402g);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{\"name\": \"json err\"}";
        }
    }

    /* renamed from: b */
    public void m59691b(int i) {
        this.f402g = i;
    }

    /* renamed from: c */
    public void m59689c(int i) {
        this.f400e = i;
    }

    /* renamed from: d */
    public void m59688d(int i) {
        this.f396a = i;
    }

    /* renamed from: e */
    public void m59687e(int i) {
        this.f401f = i;
    }

    /* renamed from: b */
    public void m59690b(String str) {
        this.f399d = str;
    }

    /* renamed from: a */
    public void m59693a(int i) {
        this.f397b = i;
    }

    /* renamed from: a */
    public void m59692a(String str) {
        this.f398c = str;
    }
}
