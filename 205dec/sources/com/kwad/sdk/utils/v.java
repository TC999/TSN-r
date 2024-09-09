package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class v {
    private static Handler fS = new Handler(Looper.getMainLooper());
    private static volatile boolean HE = false;

    public static void O(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i4, long j4) {
        if (com.kwad.framework.a.a.adH.booleanValue() && !HE) {
            HE = true;
            View inflate = com.kwad.sdk.n.l.inflate(context, i4, null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            fS.postDelayed(new ay() { // from class: com.kwad.sdk.utils.v.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    v.access$002(false);
                }
            }, j4);
        }
    }

    static /* synthetic */ boolean access$002(boolean z3) {
        HE = false;
        return false;
    }

    private static void b(Context context, String str, int i4) {
        a(context, str, i4, 800L);
    }

    public static void c(Context context, String str, long j4) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j4) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    public static void c(Context context, String str, int i4) {
        if (com.kwad.framework.a.a.adH.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }
}
