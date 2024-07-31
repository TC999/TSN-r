package com.acse.ottn.util;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.p */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RunnableC1689p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1691q f3354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1689p(C1691q c1691q) {
        this.f3354a = c1691q;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (C1650T.m56150d().m56152c(C1650T.m56150d().m56161a()) + (HelpShopAppUtil.getInstance().createRandomNumber().longValue() * 1000) > System.currentTimeMillis()) {
            TimerTask timerTask = C1617A.f3111c;
            if (timerTask != null) {
                timerTask.cancel();
                C1617A.f3111c = null;
                return;
            }
            return;
        }
        C1638Ka.m56175r();
        C1638Ka.m56176q();
        C1703va.m55903a().m55900a("heart_beat", new C1687o(this));
        str = C1617A.f3113e;
        C1694ra.m55915b(str, "心跳 倒计时设置位false");
        C1618Aa.m56307b(HelpShopAppUtil.getContext()).m56309a(false);
        C1635J.m56236a(HelpShopAppUtil.getContext());
    }
}
