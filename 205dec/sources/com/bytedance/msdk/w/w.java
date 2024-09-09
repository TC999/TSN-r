package com.bytedance.msdk.w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.f.sr.xv;
import com.bytedance.sdk.component.ev.c;
import com.bytedance.sdk.component.w.c.sr;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f28467c;

    /* renamed from: w  reason: collision with root package name */
    private Context f28468w;
    private final com.bytedance.sdk.component.ev.c xv;

    private w(Context context) {
        Map<String, Object> map;
        this.f28468w = context == null ? com.bytedance.msdk.core.c.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        c.C0445c c0445c = new c.C0445c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c.C0445c c4 = c0445c.c(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).w(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).xv(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).c(true);
        if (xv.c() && (map = xv.f28359c) != null) {
            Object obj = map.get("case_id");
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                c4.c(new xv.c());
            }
        }
        com.bytedance.sdk.component.ev.c c5 = c4.c();
        this.xv = c5;
        sr c6 = c5.ux().c();
        if (c6 != null) {
            c6.c(16);
        }
    }

    public static w c() {
        if (f28467c == null) {
            synchronized (w.class) {
                if (f28467c == null) {
                    f28467c = new w(com.bytedance.msdk.core.c.getContext());
                }
            }
        }
        return f28467c;
    }

    public com.bytedance.sdk.component.ev.c w() {
        return this.xv;
    }
}
