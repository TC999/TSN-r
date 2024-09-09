package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SpringSystem extends BaseSpringSystem {
    private SpringSystem(SpringLooper springLooper) {
        super(springLooper);
    }

    public static SpringSystem m() {
        return new SpringSystem(AndroidSpringLooperFactory.a());
    }
}
