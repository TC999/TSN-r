package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.p;
import com.mbridge.msdk.foundation.tools.t;

/* compiled from: PlayableReportUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f39696a = new Handler(Looper.getMainLooper());

    public static void a(CampaignEx campaignEx, String str, String str2, String str3) {
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        p pVar = new p("2000043", TextUtils.isEmpty(campaignEx.getMraid()) ^ true ? 1 : 3, "0", "", campaignEx.getId(), str2, str, String.valueOf(campaignEx.getKeyIaRst()));
        pVar.n(campaignEx.getId());
        pVar.k(campaignEx.getRequestId());
        pVar.l(campaignEx.getRequestIdNotice());
        pVar.b(campaignEx.getAdSpaceT());
        pVar.h(str3);
        pVar.c(t.D(com.mbridge.msdk.foundation.controller.a.f().j()));
        pVar.a(campaignEx.isMraid() ? p.f39346a : p.f39347b);
        a(pVar, str2);
    }

    public static void b(p pVar, String str) {
        if (pVar != null) {
            pVar.o("2000059");
            pVar.m(str);
            pVar.c(t.D(com.mbridge.msdk.foundation.controller.a.f().j()));
            pVar.b(t.E());
            String c4 = p.c(pVar);
            if (b.a().c()) {
                b.a().a(c4);
            } else {
                a(c4, com.mbridge.msdk.foundation.controller.a.f().j(), str);
            }
        }
    }

    public static void c(p pVar, Context context, String str) {
        String h4 = p.h(pVar);
        if (b.a().c()) {
            b.a().a(h4);
        } else {
            a(h4, context, str);
        }
    }

    public static void d(p pVar, Context context, String str) {
        if (pVar != null) {
            pVar.o("2000063");
            pVar.m(str);
            pVar.c(t.D(context));
            String a4 = p.a(pVar);
            if (b.a().c()) {
                b.a().a(a4);
            } else {
                a(a4, context, str);
            }
        }
    }

    public static void b(p pVar, Context context, String str) {
        String g4 = p.g(pVar);
        if (b.a().c()) {
            b.a().a(g4);
        } else {
            a(g4, context, str);
        }
    }

    public static void a(p pVar, String str) {
        if (pVar != null) {
            pVar.b(t.E());
            String d4 = p.d(pVar);
            if (b.a().c()) {
                b.a().a(d4);
            } else {
                a(d4, com.mbridge.msdk.foundation.controller.a.f().j(), str);
            }
        }
    }

    public static void a(p pVar, Context context, String str) {
        if (pVar != null) {
            pVar.o("2000060");
            pVar.m(str);
            pVar.c(t.D(context));
            String b4 = p.b(pVar);
            if (b.a().c()) {
                b.a().a(b4);
            } else {
                a(b4, context, str);
            }
        }
    }

    public static void a(String str, Context context, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(new com.mbridge.msdk.foundation.same.f.a(str, str2));
    }

    private static void a(Runnable runnable) {
        Handler handler = f39696a;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
