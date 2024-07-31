package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.CcgConstant;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.z */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Action implements Processer {

    /* renamed from: a */
    private String f38479a;

    /* renamed from: b */
    private ArrayList<ActionCondition> f38480b;

    /* renamed from: c */
    private String f38481c;

    /* renamed from: d */
    private String f38482d;

    /* renamed from: e */
    private String f38483e;

    /* renamed from: f */
    private String f38484f;

    public Action(String str, ArrayList<ActionCondition> arrayList) {
        this.f38479a = null;
        new ArrayList();
        this.f38481c = "";
        this.f38482d = "";
        this.f38483e = "";
        this.f38484f = "";
        this.f38479a = str;
        this.f38480b = arrayList;
    }

    /* renamed from: a */
    public String m14139a() {
        return this.f38479a;
    }

    /* renamed from: b */
    public String m14136b() {
        return this.f38481c;
    }

    /* renamed from: c */
    public String m14134c() {
        return this.f38482d;
    }

    /* renamed from: c */
    private String m14133c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length > 0) {
            ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f38479a);
            if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
                this.f38484f = forbidSdkArray.toString();
                for (String str3 : split) {
                    if (CcgAgent.getActionInfo(str3) != null && !forbidSdkArray.contains(str3)) {
                        return str3;
                    }
                }
                return "";
            }
            for (String str4 : split) {
                ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
                if (actionInfo != null) {
                    String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                    if (supportAction.length > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= supportAction.length) {
                                break;
                            } else if (this.f38479a.equals(supportAction[i])) {
                                str2 = str4;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            return str2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return str2;
        }
        return "";
    }

    /* renamed from: a */
    public void m14138a(String str) {
        this.f38481c = str;
    }

    /* renamed from: b */
    public void m14135b(String str) {
        this.f38482d = str;
    }

    @Override // com.umeng.analytics.pro.Processer
    /* renamed from: a */
    public JSONObject mo14137a(String str, JSONObject jSONObject) {
        try {
            int size = this.f38480b.size();
            if (size == 0) {
                return null;
            }
            for (int i = 0; i < size; i++) {
                if (this.f38480b.get(i).mo14749b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f38482d)) {
                String m14133c = m14133c(this.f38482d);
                this.f38483e = m14133c;
                if (TextUtils.isEmpty(m14133c)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "采集项：" + this.f38479a + "; 未选中可用Module ; sdk: " + this.f38482d);
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "采集项：" + this.f38479a + "; 选中Module: " + this.f38483e + "; sdk: " + this.f38482d);
                }
            }
            ActionCondition actionCondition = this.f38480b.get(size - 1);
            if (actionCondition == null || !(actionCondition instanceof DelayedStartCondition)) {
                return null;
            }
            long mo14748c = actionCondition.mo14748c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f38479a);
                jSONObject2.put("sdk", this.f38482d);
                jSONObject2.put(CcgConstant.f38544o, this.f38481c);
                jSONObject2.put("delay", mo14748c);
                jSONObject2.put(CcgConstant.f38545p, this.f38483e);
                jSONObject2.put(CcgConstant.f38546q, this.f38484f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
