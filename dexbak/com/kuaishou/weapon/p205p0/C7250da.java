package com.kuaishou.weapon.p205p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* renamed from: com.kuaishou.weapon.p0.da */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7250da {

    /* renamed from: b */
    private static volatile C7250da f24763b;

    /* renamed from: a */
    private Context f24764a;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f24765c;

    /* renamed from: d */
    private boolean f24766d;

    private C7250da(Context context) {
        this.f24764a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m34004b() {
        try {
            Context context = this.f24764a;
            if (context == null) {
                return;
            }
            C7283h m33888a = C7283h.m33888a(context, "re_po_rt");
            if (m33888a.m33878b(C7262df.f24911w, 0) == 0) {
                return;
            }
            final int[] iArr = {0};
            final int[] iArr2 = {m33888a.m33878b(C7262df.f24899k, 1)};
            if (this.f24764a instanceof Application) {
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
                            C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C72522 c72522 = C72522.this;
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) C7250da.this.f24764a).unregisterActivityLifecycleCallbacks(C7250da.this.f24765c);
                                        return;
                                    }
                                    int[] iArr4 = iArr2;
                                    iArr4[0] = iArr4[0] - 1;
                                    C7243cx.m34020a(C7250da.this.f24764a).m34021a(106);
                                    C7258dd.m33993a(C7250da.this.f24764a).m33994a(106);
                                    C7254db.m33999a(C7250da.this.f24764a).m34000a(106, 0);
                                    C7245cy.m34017a(C7250da.this.f24764a).m34018a(106);
                                    C7247cz.m34014a(C7250da.this.f24764a).m34015a(106);
                                    C7260de.m33990a(C7250da.this.f24764a).m33991a(106);
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
                this.f24765c = activityLifecycleCallbacks;
                ((Application) this.f24764a).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static C7250da m34007a(Context context) {
        if (f24763b == null) {
            synchronized (C7250da.class) {
                if (f24763b == null) {
                    f24763b = new C7250da(context);
                }
            }
        }
        return f24763b;
    }

    /* renamed from: a */
    public void m34008a() {
        try {
            C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C7283h m33888a = C7283h.m33888a(C7250da.this.f24764a, "re_po_rt");
                        boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
                        boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
                        if ((m33867e || m33867e2) && !C7250da.this.f24766d) {
                            C7250da.this.f24766d = true;
                            C7250da.this.m34004b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
