package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.AppLifeCycle;

/* renamed from: com.umeng.analytics.vshelper.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RealTimeDebugSwitch implements AppLifeCycle {

    /* renamed from: a */
    private static final String f38528a = "RealTimeDebugSwitch";

    /* renamed from: b */
    private static volatile int f38529b;

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: a */
    public void mo14118a() {
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: a */
    public void mo14117a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo14116a(android.app.Activity r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.RealTimeDebugSwitch.mo14116a(android.app.Activity, android.os.Bundle):void");
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: b */
    public void mo14115b() {
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: b */
    public void mo14114b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: b */
    public void mo14113b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: c */
    public void mo14112c() {
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: c */
    public void mo14111c(Activity activity) {
        f38529b++;
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: d */
    public void mo14109d(Activity activity) {
        f38529b--;
    }

    @Override // com.umeng.analytics.pro.AppLifeCycle
    /* renamed from: e */
    public void mo14108e(Activity activity) {
    }

    /* renamed from: d */
    public static boolean m14110d() {
        return f38529b > 0;
    }
}
