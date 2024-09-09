package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys implements Initializer {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.gromore.c.w.c f31278c;
    private xv sr;
    private Bundle ux;

    /* renamed from: w  reason: collision with root package name */
    private EventListener f31279w;
    private Initializer xv;

    public ys(Bundle bundle, Initializer initializer) {
        this.xv = initializer;
        this.ux = bundle;
        f.c();
        Bundle bundle2 = this.ux;
        if (bundle2 != null) {
            f.f31256c = bundle2.getLong("call_init_time");
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.xv != null) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "getManager mediation");
            Manager manager = this.xv.getManager();
            if (manager != null) {
                return new t(manager);
            }
            return null;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        com.bytedance.sdk.gromore.c.w.c c4 = com.bytedance.sdk.gromore.c.w.c.c(valueSet);
        this.f31278c = c4;
        if (c4.sr()) {
            com.bytedance.msdk.adapter.sr.xv.c();
            com.bytedance.sdk.component.ev.c.c();
        }
        if (this.f31278c.c()) {
            com.bytedance.msdk.core.bk.c.c().w();
            w(context, valueSet);
            return;
        }
        c(context, valueSet);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        com.bytedance.sdk.gromore.c.w.c cVar = this.f31278c;
        if (cVar != null && cVar.c()) {
            Initializer initializer = this.xv;
            return initializer != null && this.sr != null && initializer.isInitSuccess() && this.sr.c();
        }
        Initializer initializer2 = this.xv;
        if (initializer2 != null) {
            return initializer2.isInitSuccess();
        }
        return false;
    }

    private void w(final Context context, ValueSet valueSet) {
        EventListener xv = this.f31278c.xv();
        this.f31279w = xv;
        if (xv != null) {
            ux uxVar = new ux(xv);
            this.f31279w = uxVar;
            uxVar.c(new EventListener() { // from class: com.bytedance.sdk.gromore.init.ys.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    if (result.isSuccess()) {
                        f.xv = SystemClock.elapsedRealtime();
                        ys ysVar = ys.this;
                        ysVar.c(context, ysVar.f31278c, ys.this.f31279w);
                        return null;
                    }
                    return null;
                }
            });
        }
        if (this.xv != null) {
            b k4 = b.k(valueSet);
            k4.h(15, this.f31279w);
            c(context, k4.l());
            return;
        }
        this.f31279w.onEvent(0, com.bykv.c.c.c.c.a.a().e(false).b(80000).d("init error Initializer is null").f());
    }

    private void c(Context context, ValueSet valueSet) {
        f.f31257w = SystemClock.elapsedRealtime();
        Initializer initializer = this.xv;
        if (initializer != null) {
            initializer.init(context, valueSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, com.bytedance.sdk.gromore.c.w.c cVar, EventListener eventListener) {
        f.sr = SystemClock.elapsedRealtime();
        xv xvVar = new xv();
        this.sr = xvVar;
        xvVar.c(context, cVar, eventListener);
    }
}
