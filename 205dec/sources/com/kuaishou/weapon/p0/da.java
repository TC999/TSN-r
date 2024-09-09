package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class da {

    /* renamed from: b  reason: collision with root package name */
    private static volatile da f38259b;

    /* renamed from: a  reason: collision with root package name */
    private Context f38260a;

    /* renamed from: c  reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f38261c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f38262d;

    private da(Context context) {
        this.f38260a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Context context = this.f38260a;
            if (context == null) {
                return;
            }
            h a4 = h.a(context, "re_po_rt");
            if (a4.b("plc001_f_act", 0) == 0) {
                return;
            }
            final int[] iArr = {0};
            final int[] iArr2 = {a4.b("plc001_blpc", 1)};
            if (this.f38260a instanceof Application) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.kuaishou.weapon.p0.da.2
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            int[] iArr3 = iArr;
                            iArr3[0] = iArr3[0] + 1;
                            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) da.this.f38260a).unregisterActivityLifecycleCallbacks(da.this.f38261c);
                                        return;
                                    }
                                    int[] iArr4 = iArr2;
                                    iArr4[0] = iArr4[0] - 1;
                                    cx.a(da.this.f38260a).a(106);
                                    dd.a(da.this.f38260a).a(106);
                                    db.a(da.this.f38260a).a(106, 0);
                                    cy.a(da.this.f38260a).a(106);
                                    cz.a(da.this.f38260a).a(106);
                                    de.a(da.this.f38260a).a(106);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                };
                this.f38261c = activityLifecycleCallbacks;
                ((Application) this.f38260a).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable unused) {
        }
    }

    public static da a(Context context) {
        if (f38259b == null) {
            synchronized (da.class) {
                if (f38259b == null) {
                    f38259b = new da(context);
                }
            }
        }
        return f38259b;
    }

    public void a() {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h a4 = h.a(da.this.f38260a, "re_po_rt");
                        boolean e4 = a4.e("a1_p_s_p_s");
                        boolean e5 = a4.e("a1_p_s_p_s_c_b");
                        if ((e4 || e5) && !da.this.f38262d) {
                            da.this.f38262d = true;
                            da.this.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
