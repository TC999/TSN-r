package com.bytedance.sdk.openadsdk.core.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.ev.c;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q.c;
import com.bytedance.sdk.openadsdk.core.u.n;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile ux f34501c;
    private final com.bytedance.sdk.component.ev.c sr;

    /* renamed from: w  reason: collision with root package name */
    private Context f34502w;
    private com.bytedance.sdk.openadsdk.a.c.c xv;

    private ux(Context context) {
        this.f34502w = context == null ? ls.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        c.C0445c c0445c = new c.C0445c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.bytedance.sdk.component.ev.c c4 = c0445c.c(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).w(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).xv(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).c(new c.C0504c()).c(n.c()).c(n.w()).c(true).c(sr()).c();
        this.sr = c4;
        com.bytedance.sdk.component.w.c.sr c5 = c4.ux().c();
        if (c5 != null) {
            c5.c(32);
            c5.w(com.bytedance.sdk.openadsdk.core.xv.sr.c().ux());
        }
    }

    public static ux c() {
        if (f34501c == null) {
            synchronized (ux.class) {
                if (f34501c == null) {
                    com.bytedance.sdk.component.w.c.c.c.c().c(false);
                    f34501c = new ux(ls.getContext());
                }
            }
        }
        return f34501c;
    }

    private Bundle sr() {
        try {
            JSONObject ev = com.bytedance.sdk.openadsdk.core.xv.sr.c().ev();
            if (ev == null || !com.bytedance.sdk.openadsdk.core.xv.xv.sr()) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("max_idle_cnt", ev.optInt("mi_c", 5));
            bundle.putLong("max_idle_time", ev.optInt("mi_t", 5));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(com.bytedance.sdk.openadsdk.core.xv.sr.c().sr());
            bundle.putStringArrayList("white_hosts", arrayList);
            bundle.putLong("white_extra_idle_time", 1L);
            return bundle;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void ux() {
        if (this.xv == null) {
            this.xv = new com.bytedance.sdk.openadsdk.a.c.c();
        }
    }

    public com.bytedance.sdk.component.ev.c w() {
        return this.sr;
    }

    public com.bytedance.sdk.openadsdk.a.c.c xv() {
        ux();
        return this.xv;
    }
}
