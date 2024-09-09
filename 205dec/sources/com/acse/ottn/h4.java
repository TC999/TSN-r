package com.acse.ottn;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.l0;
import com.acse.ottn.service.ShopHelperService;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h4 {

    /* renamed from: b  reason: collision with root package name */
    public static h4 f5723b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f5724c = "VideoSoftwareUtil";

    /* renamed from: d  reason: collision with root package name */
    public static CountDownTimer f5725d;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f5726a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f5727a;

        public a(AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f5727a = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
        }

        @Override // com.acse.ottn.l0.d
        @RequiresApi(api = 16)
        public void a(long j4) {
            CountDownTimer countDownTimer;
            h4.this.f5726a = new ArrayList();
            h4.this.a(this.f5727a);
            h4 h4Var = h4.this;
            if (!h4Var.a(h4Var.f5726a) || (countDownTimer = h4.f5725d) == null) {
                return;
            }
            countDownTimer.cancel();
            h4.f5725d = null;
        }
    }

    public static h4 a() {
        if (f5723b == null) {
            synchronized (h4.class) {
                if (f5723b == null) {
                    f5723b = new h4();
                }
            }
        }
        return f5723b;
    }

    public final Object b() throws ObjectStreamException {
        return f5723b;
    }

    @RequiresApi(api = 16)
    public void a(ShopHelperService shopHelperService) {
        CountDownTimer a4 = l0.a().a(3500, 1000, new a(shopHelperService.getRootInActiveWindow()));
        f5725d = a4;
        a4.start();
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (accessibilityNodeInfo.getText() != null) {
                String trim = accessibilityNodeInfo.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    return;
                }
                this.f5726a.add(trim);
            }
        } else if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (list.get(i4).trim().equals("\u5408\u8ba1:")) {
                    String str = f5724c;
                    z1.a(str, "\u5408\u8ba1:" + i4);
                    int i5 = i4 + 1;
                    if (list.size() <= i5) {
                        return false;
                    }
                    if (list.get(i5).trim().length() > 0) {
                        String str2 = f5724c;
                        z1.a(str2, "\u5408\u8ba1:" + list.get(i5));
                        return true;
                    }
                }
            }
            return false;
        }
        z1.a(f5724c, "lists = null");
        return false;
    }
}
