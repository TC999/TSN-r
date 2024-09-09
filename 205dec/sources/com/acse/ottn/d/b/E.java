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
public class E implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5422a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5423b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(AccessibilityService accessibilityService, String str) {
        this.f5422a = accessibilityService;
        this.f5423b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ra.a("samon-->", "\u5012\u8ba1\u65f6");
        F.h(this.f5422a);
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5422a, this.f5423b);
            if (g4 == null) {
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
                ra.a("samon-->", "\u7ed3\u675f\u5012\u8ba1\u65f6");
                F.f5426c = null;
            }
            ra.a(o4.f6114a, "buttery find");
            C1442n.c().f(g4);
            C1442n.c().a(V.a().b(200));
            AccessibilityNodeInfo g5 = C1442n.c().g(this.f5422a, "\u5141\u8bb8\u540e\u53f0\u9ad8\u8017\u7535");
            if (g5 != null) {
                ra.a(o4.f6114a, "buttery info is not null");
                C1442n.c().f(g5);
                CommonUtil.setServiceHightButteryState(true);
            } else {
                ra.a(o4.f6114a, "buttery info is null");
                if (g4.getParent() != null) {
                    ra.a(o4.f6114a, "buttery start");
                    for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                        if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                            ra.a(o4.f6114a, "find buttery Switch");
                            if (!g4.getParent().getChild(i4).isChecked()) {
                                Rect rect = new Rect();
                                g4.getParent().getChild(i4).getBoundsInScreen(rect);
                                int i5 = rect.right;
                                int i6 = rect.left;
                                int i7 = ((i5 - i6) / 2) + i6;
                                int i8 = rect.bottom;
                                int i9 = rect.top;
                                int i10 = ((i8 - i9) / 2) + i9;
                                if (Build.VERSION.SDK_INT >= 24) {
                                    C1442n.c().a(this.f5422a, i7, i10);
                                }
                            }
                        }
                    }
                }
            }
            ra.a(o4.f6114a, "backgroundHightBattery comeBack");
            C1442n.c().a(V.a().b(100));
            C1442n.c().d(this.f5422a);
            C1442n.c().a(V.a().b(100));
            C1442n.c().d(this.f5422a);
            C1442n.c().a(V.a().b(100));
            C1442n.c().d(this.f5422a);
        } catch (Exception e4) {
            ra.a(o4.f6114a, "backgroundHightBattery e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        F.f5426c = null;
    }
}
