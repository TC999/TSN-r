package com.kuaishou.weapon.p205p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.C7296p;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7295o {
    /* renamed from: a */
    public static C7303s m33827a(JSONObject jSONObject) {
        C7296p m33826b = m33826b(jSONObject);
        if (m33826b == null) {
            return null;
        }
        int m33825a = m33826b.m33825a();
        String m33801l = m33826b.m33801l();
        String m33803j = m33826b.m33803j();
        boolean z = m33826b.m33814d() == 1;
        boolean z2 = m33826b.m33805h() == 1;
        int m33811e = m33826b.m33811e();
        String m33817c = m33826b.m33817c();
        String m33808f = m33826b.m33808f();
        String m33820b = m33826b.m33820b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = m33808f;
            packageInfo.versionName = m33801l;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(m33808f) && !TextUtils.isEmpty(m33820b) && m33820b.startsWith(".")) {
                applicationInfo.name = m33808f + m33820b;
                applicationInfo.className = m33808f + m33820b;
            }
            applicationInfo.theme = m33826b.m33804i();
            packageInfo.applicationInfo = applicationInfo;
            List<C7296p.C7297a> m33800m = m33826b.m33800m();
            if (m33800m != null && m33800m.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < m33800m.size(); i++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m33800m.get(i).m33794c();
                    activityInfo.theme = m33800m.get(i).m33796b();
                    activityInfo.labelRes = m33800m.get(i).m33799a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        C7303s c7303s = new C7303s(packageInfo, m33825a, m33808f, m33801l, m33803j, m33817c);
        c7303s.f25040v = z;
        c7303s.f25042x = m33811e;
        int m33793a = m33826b.m33802k() == null ? 0 : m33826b.m33802k().m33793a();
        int m33791b = m33826b.m33802k() == null ? -1 : m33826b.m33802k().m33791b();
        c7303s.f25038t = m33793a;
        c7303s.f25039u = m33791b;
        c7303s.f25037s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z2) {
            z2 = m33826b.m33806g() == 1;
        }
        c7303s.f25043y = z2;
        return c7303s;
    }

    /* renamed from: b */
    private static C7296p m33826b(JSONObject jSONObject) {
        try {
            C7296p c7296p = new C7296p();
            c7296p.m33824a(jSONObject.optInt("wk"));
            c7296p.m33822a(jSONObject.optString("wan"));
            c7296p.m33818b(jSONObject.optString("wm"));
            c7296p.m33819b(jSONObject.optInt("wo"));
            c7296p.m33816c(jSONObject.optInt("wpr"));
            c7296p.m33815c(jSONObject.optString(C7193bi.f24582q));
            c7296p.m33810e(jSONObject.optInt("ws", 1));
            c7296p.m33813d(jSONObject.optInt("wh", 0));
            c7296p.m33807f(jSONObject.optInt("wt"));
            c7296p.m33812d(jSONObject.optString("wu"));
            c7296p.m33809e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                C7296p.C7297a c7297a = new C7296p.C7297a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                c7297a.m33798a(jSONObject2.optInt("r"));
                c7297a.m33795b(jSONObject2.optInt(UMCommonContent.f37782aL));
                c7297a.m33797a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c7297a);
            }
            c7296p.m33821a(arrayList);
            C7296p.C7298b c7298b = new C7296p.C7298b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            c7298b.m33792a(jSONObject3.optInt("duration"));
            c7298b.m33790b(jSONObject3.optInt("network"));
            c7296p.m33823a(c7298b);
            return c7296p;
        } catch (Exception unused) {
            return null;
        }
    }
}
