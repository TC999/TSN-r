package com.acse.ottn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.acse.ottn.util.C1650T;
import com.acse.ottn.util.C1661ba;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class HomeKeyReceiver extends BroadcastReceiver {

    /* renamed from: a */
    final String f2907a = MediationConstant.KEY_REASON;

    /* renamed from: b */
    final String f2908b = "recentapps";

    /* renamed from: c */
    final String f2909c = "homekey";

    /* renamed from: d */
    private boolean f2910d = false;

    /* renamed from: e */
    private Handler f2911e = new Handler();

    /* renamed from: f */
    Runnable f2912f = new RunnableC1553a(this);

    /* renamed from: a */
    private void m56438a(Context context) {
        if ((C1661ba.m56097a() == null && C1661ba.m56097a().m56096a("setting_day")) || this.f2910d) {
            return;
        }
        this.f2910d = true;
        this.f2911e.postDelayed(this.f2912f, 3000L);
        String m56161a = C1650T.m56150d().m56161a();
        String m56086d = C1661ba.m56097a().m56086d("am_show_seed_dialog");
        String m56086d2 = C1661ba.m56097a().m56086d("pm_show_seed_dialog");
        int m56157b = C1650T.m56150d().m56157b();
        if (m56157b >= 1400) {
            if (m56161a.equals(m56086d2) || m56157b < 1400 || m56157b >= 2100) {
                return;
            }
            m56437a(context, "pm_show_seed_dialog", m56161a);
        } else if (m56161a.equals(m56086d) || m56157b < 800 || m56157b >= 1400) {
        } else {
            m56437a(context, "am_show_seed_dialog", m56161a);
        }
    }

    /* renamed from: a */
    private void m56437a(Context context, String str, String str2) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || (stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON)) == null) {
            return;
        }
        if (!stringExtra.equals("homekey") && stringExtra.equals("recentapps")) {
            return;
        }
        m56438a(context);
    }
}
