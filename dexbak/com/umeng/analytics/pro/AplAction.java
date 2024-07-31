package com.umeng.analytics.pro;

import com.umeng.ccg.CcgConstant;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.ab */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AplAction extends Action {

    /* renamed from: a */
    private String f37603a;

    /* renamed from: b */
    private String f37604b;

    public AplAction(String str, ArrayList<ActionCondition> arrayList) {
        super(str, arrayList);
        this.f37603a = "";
        this.f37604b = "";
    }

    @Override // com.umeng.analytics.pro.Action, com.umeng.analytics.pro.Processer
    /* renamed from: a */
    public JSONObject mo14137a(String str, JSONObject jSONObject) {
        JSONObject mo14137a = super.mo14137a(str, jSONObject);
        if (mo14137a != null) {
            try {
                mo14137a.put(CcgConstant.f38548s, this.f37603a);
                mo14137a.put(CcgConstant.f38549t, this.f37604b);
            } catch (Throwable unused) {
            }
        }
        return mo14137a;
    }

    /* renamed from: c */
    public void m14758c(String str) {
        this.f37603a = str;
    }

    /* renamed from: d */
    public String m14757d() {
        return this.f37603a;
    }

    /* renamed from: e */
    public String m14755e() {
        return this.f37604b;
    }

    /* renamed from: d */
    public void m14756d(String str) {
        this.f37604b = str;
    }
}
