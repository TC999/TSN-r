package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Action.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class z implements ag {

    /* renamed from: a  reason: collision with root package name */
    private String f53150a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<aa> f53151b;

    /* renamed from: c  reason: collision with root package name */
    private String f53152c;

    /* renamed from: d  reason: collision with root package name */
    private String f53153d;

    /* renamed from: e  reason: collision with root package name */
    private String f53154e;

    /* renamed from: f  reason: collision with root package name */
    private String f53155f;

    public z(String str, ArrayList<aa> arrayList) {
        this.f53150a = null;
        new ArrayList();
        this.f53152c = "";
        this.f53153d = "";
        this.f53154e = "";
        this.f53155f = "";
        this.f53150a = str;
        this.f53151b = arrayList;
    }

    public String a() {
        return this.f53150a;
    }

    public String b() {
        return this.f53152c;
    }

    public String c() {
        return this.f53153d;
    }

    private String c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length > 0) {
            ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f53150a);
            if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
                this.f53155f = forbidSdkArray.toString();
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
                        int i4 = 0;
                        while (true) {
                            if (i4 >= supportAction.length) {
                                break;
                            } else if (this.f53150a.equals(supportAction[i4])) {
                                str2 = str4;
                                break;
                            } else {
                                i4++;
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

    public void a(String str) {
        this.f53152c = str;
    }

    public void b(String str) {
        this.f53153d = str;
    }

    @Override // com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f53151b.size();
            if (size == 0) {
                return null;
            }
            for (int i4 = 0; i4 < size; i4++) {
                if (this.f53151b.get(i4).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f53153d)) {
                String c4 = c(this.f53153d);
                this.f53154e = c4;
                if (TextUtils.isEmpty(c4)) {
                    UMRTLog.i("MobclickRT", "\u91c7\u96c6\u9879\uff1a" + this.f53150a + "; \u672a\u9009\u4e2d\u53ef\u7528Module ; sdk: " + this.f53153d);
                } else {
                    UMRTLog.i("MobclickRT", "\u91c7\u96c6\u9879\uff1a" + this.f53150a + "; \u9009\u4e2dModule: " + this.f53154e + "; sdk: " + this.f53153d);
                }
            }
            aa aaVar = this.f53151b.get(size - 1);
            if (aaVar == null || !(aaVar instanceof ac)) {
                return null;
            }
            long c5 = aaVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f53150a);
                jSONObject2.put("sdk", this.f53153d);
                jSONObject2.put("hit_sdk", this.f53152c);
                jSONObject2.put("delay", c5);
                jSONObject2.put("local_hit_sdk", this.f53154e);
                jSONObject2.put("forbid_sdk", this.f53155f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
