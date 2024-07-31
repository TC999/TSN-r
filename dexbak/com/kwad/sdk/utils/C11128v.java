package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p445n.C10887l;
import com.stub.StubApp;

/* renamed from: com.kwad.sdk.utils.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11128v {

    /* renamed from: fS */
    private static Handler f29686fS = new Handler(Looper.getMainLooper());

    /* renamed from: HE */
    private static volatile boolean f29685HE = false;

    /* renamed from: O */
    public static void m23672O(Context context, String str) {
        m23670b(context, str, C9659R.C9663layout.ksad_content_alliance_toast_2);
    }

    /* renamed from: a */
    private static void m23671a(Context context, String str, int i, long j) {
        if (C9425a.adH.booleanValue() && !f29685HE) {
            f29685HE = true;
            View inflate = C10887l.inflate(context, i, null);
            ((TextView) inflate.findViewById(C9659R.C9662id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            f29686fS.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.v.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C11128v.access$002(false);
                }
            }, j);
        }
    }

    static /* synthetic */ boolean access$002(boolean z) {
        f29685HE = false;
        return false;
    }

    /* renamed from: b */
    private static void m23670b(Context context, String str, int i) {
        m23671a(context, str, i, 800L);
    }

    /* renamed from: c */
    public static void m23668c(Context context, String str, long j) {
        m23671a(context, str, C9659R.C9663layout.ksad_content_alliance_toast_2, 0L);
    }

    /* renamed from: d */
    public static void m23667d(Context context, String str, long j) {
        m23671a(context, str, C9659R.C9663layout.ksad_toast_corner, 0L);
    }

    /* renamed from: c */
    public static void m23669c(Context context, String str, int i) {
        if (C9425a.adH.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(C9659R.C9663layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(C9659R.C9662id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }
}
