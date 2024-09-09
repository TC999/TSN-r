package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private Context f38506a;

    /* renamed from: b  reason: collision with root package name */
    private int f38507b;

    /* renamed from: c  reason: collision with root package name */
    private h f38508c;

    public w(Context context) {
        this.f38507b = 0;
        this.f38506a = context;
        h a4 = h.a(context, "re_po_rt");
        this.f38508c = a4;
        if (a4 != null) {
            this.f38507b = a4.b("plc001_al_m", 0);
        }
    }

    public JSONArray a(int i4) {
        try {
            new A(this.f38506a, i4);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i5 = 0; i5 < jsonObject.length(); i5++) {
                    jSONArray.put(jsonObject.get(i5));
                }
                A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray b(int i4) {
        try {
            return c(i4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray c(int i4) {
        return d(i4);
    }

    public JSONArray d(int i4) {
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f38506a.getPackageManager();
            for (int i5 = 1000; i5 <= 19999; i5++) {
                String[] strArr = null;
                try {
                    strArr = packageManager.getPackagesForUid(i5);
                } catch (Exception unused) {
                }
                if (strArr != null) {
                    for (String str : strArr) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i4 != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                v vVar = new v(packageInfo, this.f38506a);
                                vVar.h();
                                jSONArray.put(vVar.k());
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
