package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        p b4 = b(jSONObject);
        if (b4 == null) {
            return null;
        }
        int a4 = b4.a();
        String l4 = b4.l();
        String j4 = b4.j();
        boolean z3 = b4.d() == 1;
        boolean z4 = b4.h() == 1;
        int e4 = b4.e();
        String c4 = b4.c();
        String f4 = b4.f();
        String b5 = b4.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f4;
            packageInfo.versionName = l4;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f4) && !TextUtils.isEmpty(b5) && b5.startsWith(".")) {
                applicationInfo.name = f4 + b5;
                applicationInfo.className = f4 + b5;
            }
            applicationInfo.theme = b4.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m4 = b4.m();
            if (m4 != null && m4.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < m4.size(); i4++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m4.get(i4).c();
                    activityInfo.theme = m4.get(i4).b();
                    activityInfo.labelRes = m4.get(i4).a();
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
        s sVar = new s(packageInfo, a4, f4, l4, j4, c4);
        sVar.f38436v = z3;
        sVar.f38438x = e4;
        int a5 = b4.k() == null ? 0 : b4.k().a();
        int b6 = b4.k() == null ? -1 : b4.k().b();
        sVar.f38434t = a5;
        sVar.f38435u = b6;
        sVar.f38433s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z4) {
            z4 = b4.g() == 1;
        }
        sVar.f38439y = z4;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString("wp"));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                aVar.a(jSONObject2.optInt("r"));
                aVar.b(jSONObject2.optInt("t"));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            bVar.a(jSONObject3.optInt("duration"));
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
