package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.Intent;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ActivityUtil {

    /* compiled from: ActivityUtil.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC0981a {
        void startActivityFail(Throwable th);

        void startActivitySuccess();
    }

    /* renamed from: a */
    public static void m59251a(Context context, Intent intent, InterfaceC0981a interfaceC0981a) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
            if (interfaceC0981a != null) {
                interfaceC0981a.startActivitySuccess();
            }
        } catch (Throwable th) {
            if (interfaceC0981a != null) {
                interfaceC0981a.startActivityFail(th);
            }
        }
    }
}
