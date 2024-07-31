package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.D */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1495D implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2744a;

    /* renamed from: b */
    final /* synthetic */ String f2745b;

    /* renamed from: c */
    final /* synthetic */ boolean f2746c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1495D(AccessibilityService accessibilityService, String str, boolean z) {
        this.f2744a = accessibilityService;
        this.f2745b = str;
        this.f2746c = z;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1497F.m56627h(this.f2744a);
        try {
            if (C1684n.m55975c().m55955g(this.f2744a, this.f2745b) == null) {
                accessibilityNodeInfo = C1497F.f2752d;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1497F.f2752d;
                    m55975c.m55978b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = C1497F.f2751c;
            if (timerTask != null) {
                timerTask.cancel();
                C1497F.f2751c = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("找到了 =");
            sb.append(this.f2745b);
            C1694ra.m55917a("acse_VivoUtils", sb.toString());
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(500));
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2744a, this.f2745b);
            if (m55955g == null || m55955g.getParent() == null) {
                return;
            }
            for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
                if (m55955g.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i).getClassName()) && !m55955g.getParent().getChild(i).isChecked()) {
                    Rect rect = new Rect();
                    m55955g.getBoundsInScreen(rect);
                    Rect rect2 = new Rect();
                    m55955g.getParent().getBoundsInScreen(rect2);
                    int i2 = rect2.right - (rect.left / 2);
                    int i3 = rect.bottom;
                    int i4 = rect.top;
                    int i5 = ((i3 - i4) / 2) + i4;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1684n.m55975c().m56002a(this.f2744a, i2, i5);
                        C1694ra.m55917a("acse_VivoUtils", "点击了");
                    }
                }
            }
            if (this.f2746c) {
                C1694ra.m55917a("acse_VivoUtils", "电池");
                CommonUtil.setButteryState(true);
            }
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
            C1684n.m55975c().m55969d(this.f2744a);
        } catch (Exception e) {
            C1694ra.m55917a("acse_VivoUtils", "clickSoftList e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1497F.f2751c = null;
    }
}
