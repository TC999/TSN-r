package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RealTimeDebugSwitch.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements bn {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53199a = "RealTimeDebugSwitch";

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f53200b;

    @Override // com.umeng.analytics.pro.bn
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bn
    public void a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    @Override // com.umeng.analytics.pro.bn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.app.Activity r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.b.a(android.app.Activity, android.os.Bundle):void");
    }

    @Override // com.umeng.analytics.pro.bn
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bn
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.bn
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.bn
    public void c() {
    }

    @Override // com.umeng.analytics.pro.bn
    public void c(Activity activity) {
        f53200b++;
    }

    @Override // com.umeng.analytics.pro.bn
    public void d(Activity activity) {
        f53200b--;
    }

    @Override // com.umeng.analytics.pro.bn
    public void e(Activity activity) {
    }

    public static boolean d() {
        return f53200b > 0;
    }
}
