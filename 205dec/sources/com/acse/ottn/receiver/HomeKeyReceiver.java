package com.acse.ottn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.acse.ottn.g1;
import com.acse.ottn.p0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HomeKeyReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final String f6209a = "reason";

    /* renamed from: b  reason: collision with root package name */
    public final String f6210b = "recentapps";

    /* renamed from: c  reason: collision with root package name */
    public final String f6211c = "homekey";

    /* renamed from: d  reason: collision with root package name */
    public boolean f6212d = false;

    /* renamed from: e  reason: collision with root package name */
    public Handler f6213e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f6214f = new a();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HomeKeyReceiver.this.f6212d = false;
        }
    }

    public final void a(Context context, String str, String str2) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || (stringExtra = intent.getStringExtra("reason")) == null) {
            return;
        }
        if (stringExtra.equals("homekey")) {
            a(context);
        } else if (stringExtra.equals("recentapps")) {
        } else {
            a(context);
        }
    }

    public final void a(Context context) {
        if ((g1.a() == null && g1.a().a("setting_day")) || this.f6212d) {
            return;
        }
        this.f6212d = true;
        this.f6213e.postDelayed(this.f6214f, 3000L);
        String a4 = p0.d().a();
        String d4 = g1.a().d("am_show_seed_dialog");
        String d5 = g1.a().d("pm_show_seed_dialog");
        int b4 = p0.d().b();
        if (b4 >= 1400) {
            if (a4.equals(d5) || b4 < 1400 || b4 >= 2100) {
                return;
            }
            a(context, "pm_show_seed_dialog", a4);
        } else if (a4.equals(d4) || b4 < 800 || b4 >= 1400) {
        } else {
            a(context, "am_show_seed_dialog", a4);
        }
    }
}
