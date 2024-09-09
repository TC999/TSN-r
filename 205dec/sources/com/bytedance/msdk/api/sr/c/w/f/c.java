package com.bytedance.msdk.api.sr.c.w.f;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.sr.c.w.xv.w;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27557c = "TTMediationSDK_" + c.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private w f27558w;
    private final AtomicBoolean xv = new AtomicBoolean(false);

    public abstract String c();

    @Nullable
    public String c(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract void c(Context context, w wVar, Map<String, Object> map);

    public final boolean sr() {
        return this.xv.get();
    }

    public abstract String w();

    @Nullable
    public String w(Context context, Map<String, Object> map) {
        return null;
    }

    public final void w(Context context, w wVar, Map<String, Object> map) {
        this.xv.set(false);
        this.f27558w = wVar;
        c(context, wVar, map);
    }

    public final void xv() {
        this.xv.set(true);
    }
}
