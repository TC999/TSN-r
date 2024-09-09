package com.acse.ottn;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h1 {

    /* renamed from: b  reason: collision with root package name */
    public static h1 f5713b;

    /* renamed from: a  reason: collision with root package name */
    public List<HashMap<String, String>> f5714a = new ArrayList();

    public static h1 c() {
        if (f5713b == null) {
            synchronized (h1.class) {
                if (f5713b == null) {
                    f5713b = new h1();
                }
            }
        }
        return f5713b;
    }

    public void a(List<HashMap<String, String>> list) {
        this.f5714a = list;
    }

    public String b() {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return "demo";
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            return packageManager.getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<HashMap<String, String>> d() {
        return this.f5714a;
    }

    public boolean e() {
        return "huawei".equals(c4.b()) || "honor".equals(c4.b()) || "tdtech".equals(c4.b()) || "ptac".equals(c4.b()) || "tyh612m".equals(c4.p()) || c4.s();
    }

    public boolean f() {
        return e() || "oppo".equals(c4.b()) || "vivo".equals(c4.b()) || "xiaomi".equals(c4.b()) || "redmi".equals(c4.b()) || "realme".equals(c4.b()) || "oneplus".equals(c4.b()) || "blackshark".equals(c4.b()) || "samsung".equals(c4.b());
    }

    public final Object g() throws ObjectStreamException {
        return f5713b;
    }

    public void a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        if (g1.a() != null) {
            g1.a().b("screenWidth", i4);
            g1.a().b("screenHight", i5);
        }
    }

    public void a(String str) {
        if (g1.a() == null) {
            return;
        }
        g1.a().b("accessiblity_state", str);
    }

    public String a() {
        if (g1.a() == null) {
            return j0.f5767i;
        }
        String d4 = g1.a().d("accessiblity_state");
        return TextUtils.isEmpty(d4) ? j0.f5767i : d4;
    }
}
