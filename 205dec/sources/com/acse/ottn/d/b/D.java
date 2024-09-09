package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.o4;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class D implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5419a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5420b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f5421c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(AccessibilityService accessibilityService, String str, boolean z3) {
        this.f5419a = accessibilityService;
        this.f5420b = str;
        this.f5421c = z3;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        F.h(this.f5419a);
        try {
            if (C1442n.c().g(this.f5419a, this.f5420b) == null) {
                accessibilityNodeInfo = F.f5427d;
                if (accessibilityNodeInfo != null) {
                    C1442n c4 = C1442n.c();
                    accessibilityNodeInfo2 = F.f5427d;
                    c4.b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = F.f5426c;
            if (timerTask != null) {
                timerTask.cancel();
                F.f5426c = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\u627e\u5230\u4e86 =");
            sb.append(this.f5420b);
            ra.a(o4.f6114a, sb.toString());
            C1442n.c().a(V.a().b(500));
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5419a, this.f5420b);
            if (g4 == null || g4.getParent() == null) {
                return;
            }
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName()) && !g4.getParent().getChild(i4).isChecked()) {
                    Rect rect = new Rect();
                    g4.getBoundsInScreen(rect);
                    Rect rect2 = new Rect();
                    g4.getParent().getBoundsInScreen(rect2);
                    int i5 = rect2.right - (rect.left / 2);
                    int i6 = rect.bottom;
                    int i7 = rect.top;
                    int i8 = ((i6 - i7) / 2) + i7;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1442n.c().a(this.f5419a, i5, i8);
                        ra.a(o4.f6114a, "\u70b9\u51fb\u4e86");
                    }
                }
            }
            if (this.f5421c) {
                ra.a(o4.f6114a, "\u7535\u6c60");
                CommonUtil.setButteryState(true);
            }
            C1442n.c().a(V.a().b(200));
            C1442n.c().d(this.f5419a);
        } catch (Exception e4) {
            ra.a(o4.f6114a, "clickSoftList e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        F.f5426c = null;
    }
}
