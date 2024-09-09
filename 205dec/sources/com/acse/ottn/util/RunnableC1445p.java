package com.acse.ottn.util;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.p  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class RunnableC1445p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1446q f6864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1445p(C1446q c1446q) {
        this.f6864a = c1446q;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (T.d().c(T.d().a()) + (HelpShopAppUtil.getInstance().createRandomNumber().longValue() * 1000) > System.currentTimeMillis()) {
            TimerTask timerTask = A.f6684c;
            if (timerTask != null) {
                timerTask.cancel();
                A.f6684c = null;
                return;
            }
            return;
        }
        Ka.r();
        Ka.q();
        va.a().a("heart_beat", new C1444o(this));
        str = A.f6686e;
        ra.b(str, "\u5fc3\u8df3 \u5012\u8ba1\u65f6\u8bbe\u7f6e\u4f4dfalse");
        Aa.b(HelpShopAppUtil.getContext()).a(false);
        J.a(HelpShopAppUtil.getContext());
    }
}
