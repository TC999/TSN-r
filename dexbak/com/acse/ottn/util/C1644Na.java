package com.acse.ottn.util;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import java.io.ObjectStreamException;
import java.util.List;

/* renamed from: com.acse.ottn.util.Na */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1644Na {

    /* renamed from: a */
    private static C1644Na f3265a = null;

    /* renamed from: b */
    private static String f3266b = "VideoSoftwareUtil";

    /* renamed from: c */
    public static CountDownTimer f3267c;

    /* renamed from: d */
    List<String> f3268d;

    private C1644Na() {
    }

    /* renamed from: a */
    public static C1644Na m56170a() {
        if (f3265a == null) {
            synchronized (C1644Na.class) {
                if (f3265a == null) {
                    f3265a = new C1644Na();
                }
            }
        }
        return f3265a;
    }

    /* renamed from: b */
    private Object m56166b() throws ObjectStreamException {
        return f3265a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m56169a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (accessibilityNodeInfo.getText() != null) {
                String trim = accessibilityNodeInfo.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    return;
                }
                this.f3268d.add(trim);
            }
        } else if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56169a(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public void m56168a(ShopHelperService shopHelperService) {
        CountDownTimer m56164a = C1648S.m56165a().m56164a(3500, 1000, new C1642Ma(this, shopHelperService.getRootInActiveWindow()));
        f3267c = m56164a;
        m56164a.start();
    }

    /* renamed from: a */
    public boolean m56167a(List<String> list) {
        if (list == null || list.size() == 0) {
            C1694ra.m55917a(f3266b, "lists = null");
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).trim().equals("合计:")) {
                String str = f3266b;
                C1694ra.m55917a(str, "合计:" + i);
                int i2 = i + 1;
                if (list.size() <= i2) {
                    return false;
                }
                if (list.get(i2).trim().length() > 0) {
                    String str2 = f3266b;
                    C1694ra.m55917a(str2, "合计:" + list.get(i2));
                    return true;
                }
            }
        }
        return false;
    }
}
