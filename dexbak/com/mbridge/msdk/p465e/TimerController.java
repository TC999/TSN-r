package com.mbridge.msdk.p465e;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p465e.LoopTimer;

/* renamed from: com.mbridge.msdk.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TimerController {

    /* compiled from: TimerController.java */
    /* renamed from: com.mbridge.msdk.e.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C11246a {

        /* renamed from: a */
        static TimerController f30191a = new TimerController();
    }

    public static TimerController getInstance() {
        return C11246a.f30191a;
    }

    public void addInterstitialList(String str, String str2) {
        LoopTimer.C11244a.f30190a.m22961b(str, str2);
    }

    public void addRewardList(String str, String str2) {
        LoopTimer.C11244a.f30190a.m22964a(str, str2);
    }

    public void start() {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        int m23291q = m23252b.m23291q();
        if (m23291q > 0) {
            LoopTimer.C11244a.f30190a.m22968a(m23291q * 1000);
        }
    }

    private TimerController() {
    }
}
