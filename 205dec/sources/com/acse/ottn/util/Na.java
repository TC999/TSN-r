package com.acse.ottn.util;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import java.io.ObjectStreamException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Na {

    /* renamed from: a  reason: collision with root package name */
    private static Na f6775a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6776b = "VideoSoftwareUtil";

    /* renamed from: c  reason: collision with root package name */
    public static CountDownTimer f6777c;

    /* renamed from: d  reason: collision with root package name */
    List<String> f6778d;

    private Na() {
    }

    public static Na a() {
        if (f6775a == null) {
            synchronized (Na.class) {
                if (f6775a == null) {
                    f6775a = new Na();
                }
            }
        }
        return f6775a;
    }

    private Object b() throws ObjectStreamException {
        return f6775a;
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (accessibilityNodeInfo.getText() != null) {
                String trim = accessibilityNodeInfo.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    return;
                }
                this.f6778d.add(trim);
            }
        } else if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public void a(ShopHelperService shopHelperService) {
        CountDownTimer a4 = S.a().a(3500, 1000, new Ma(this, shopHelperService.getRootInActiveWindow()));
        f6777c = a4;
        a4.start();
    }

    public boolean a(List<String> list) {
        if (list == null || list.size() == 0) {
            ra.a(f6776b, "lists = null");
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4).trim().equals("\u5408\u8ba1:")) {
                String str = f6776b;
                ra.a(str, "\u5408\u8ba1:" + i4);
                int i5 = i4 + 1;
                if (list.size() <= i5) {
                    return false;
                }
                if (list.get(i5).trim().length() > 0) {
                    String str2 = f6776b;
                    ra.a(str2, "\u5408\u8ba1:" + list.get(i5));
                    return true;
                }
            }
        }
        return false;
    }
}
