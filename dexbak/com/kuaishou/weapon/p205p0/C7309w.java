package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p205p0.jni.C7286A;
import org.json.JSONArray;

/* renamed from: com.kuaishou.weapon.p0.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7309w {

    /* renamed from: a */
    private Context f25115a;

    /* renamed from: b */
    private int f25116b;

    /* renamed from: c */
    private C7283h f25117c;

    public C7309w(Context context) {
        this.f25116b = 0;
        this.f25115a = context;
        C7283h m33888a = C7283h.m33888a(context, "re_po_rt");
        this.f25117c = m33888a;
        if (m33888a != null) {
            this.f25116b = m33888a.m33878b(C7262df.f24906r, 0);
        }
    }

    /* renamed from: a */
    public JSONArray m33726a(int i) {
        try {
            new C7286A(this.f25115a, i);
            JSONArray jsonObject = C7286A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i2 = 0; i2 < jsonObject.length(); i2++) {
                    jSONArray.put(jsonObject.get(i2));
                }
                C7286A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: b */
    public JSONArray m33725b(int i) {
        try {
            return m33724c(i);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    public JSONArray m33724c(int i) {
        return m33723d(i);
    }

    /* renamed from: d */
    public JSONArray m33723d(int i) {
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f25115a.getPackageManager();
            for (int i2 = 1000; i2 <= 19999; i2++) {
                String[] strArr = null;
                try {
                    strArr = packageManager.getPackagesForUid(i2);
                } catch (Exception unused) {
                }
                if (strArr != null) {
                    for (String str : strArr) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                C7308v c7308v = new C7308v(packageInfo, this.f25115a);
                                c7308v.m33730h();
                                jSONArray.put(c7308v.m33727k());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return jSONArray;
    }
}
