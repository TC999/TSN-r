package com.kwad.sdk.p364a.p365a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p364a.p365a.C9674b;
import com.kwad.sdk.p364a.p365a.p366a.C9673b;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.a.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9679c {
    private final Map<String, Integer> alA;
    private final Stack<AdTemplate> alB;
    private volatile boolean alC;
    public volatile boolean alD;
    public volatile boolean alE;
    private View$OnClickListenerC9693e aly;
    private final Map<String, Integer> alz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.a.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9691a {
        static final C9679c alJ = new C9679c((byte) 0);
    }

    /* synthetic */ C9679c(byte b) {
        this();
    }

    /* renamed from: a */
    static /* synthetic */ View$OnClickListenerC9693e m28062a(C9679c c9679c, View$OnClickListenerC9693e view$OnClickListenerC9693e) {
        c9679c.aly = null;
        return null;
    }

    /* renamed from: aM */
    private static boolean m28052aM(AdTemplate adTemplate) {
        String m26382H;
        if (adTemplate == null) {
            return false;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C11017ak.m24114an(ServiceProvider.getContext(), C10483a.m25911ay(m25641dQ)) || (m26382H = C10296a.m26382H(m25641dQ)) == null || TextUtils.isEmpty(m26382H)) {
            return false;
        }
        return new File(m26382H).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aR */
    public void m28047aR(final AdTemplate adTemplate) {
        m28056a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (i == -1) {
                        C9913b c9913b = new C9913b();
                        c9913b.m27264cM(29);
                        c9913b.m27257cT(23);
                        C9908c.m27306e(adTemplate, (JSONObject) null, c9913b);
                        AlertDialogC9668a.m28083zH();
                    } else if (i != -2) {
                    } else {
                        C9679c c9679c = C9679c.this;
                        C9679c.m28041g(adTemplate, 1);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.c.8
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (AlertDialogC9668a.m28083zH()) {
                    C9679c c9679c = C9679c.this;
                    C9679c.m28041g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m28042e(final AdTemplate adTemplate, final boolean z) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.c.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int m26579BO = C10251d.m26579BO();
                boolean z2 = z;
                if (z2 && m26579BO == 2) {
                    C9679c.this.m28056a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == -1) {
                                C9913b c9913b = new C9913b();
                                c9913b.m27264cM(29);
                                c9913b.m27257cT(23);
                                C9908c.m27306e(adTemplate, (JSONObject) null, c9913b);
                                AlertDialogC9668a.m28083zH();
                            } else if (i == -2) {
                                C96823 c96823 = C96823.this;
                                C9679c c9679c = C9679c.this;
                                C9679c.m28041g(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    C9679c.this.m28055a(adTemplate, z2, m26579BO, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m28041g(AdTemplate adTemplate, int i) {
        C9908c.m27306e(adTemplate, (JSONObject) null, new C9913b().m27264cM(69).m27257cT(23).m27253cX(i));
    }

    /* renamed from: zM */
    public static C9679c m28040zM() {
        return C9691a.alJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zQ */
    public void m28036zQ() {
        if (!this.alD && C9673b.m28081cM() <= 0) {
            C11064bn.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
                @Override // java.lang.Runnable
                @SuppressLint({"WrongConstant"})
                public final void run() {
                    try {
                        AdTemplate m28064zK = C9674b.m28065zJ().m28064zK();
                        if (m28064zK == null || C10251d.m26578BP() == 0) {
                            return;
                        }
                        C9679c.this.alD = true;
                        C10232b.m26625DD();
                        C9673b.m28082H(C10232b.getCurrentActivity());
                        C9679c.this.m28047aR(m28064zK);
                    } catch (Throwable th) {
                        C8571a.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    /* renamed from: aN */
    public final void m28051aN(AdTemplate adTemplate) {
        if (m28052aM(adTemplate)) {
            this.alB.add(adTemplate);
        }
    }

    /* renamed from: aO */
    public final void m28050aO(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.alB.remove(adTemplate);
    }

    /* renamed from: aP */
    public final void m28049aP(final AdTemplate adTemplate) {
        int m26580BN = C10251d.m26580BN();
        if (adTemplate == null || m26580BN <= 0) {
            return;
        }
        final AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(C10487e.m25631ea(adTemplate));
        int i = 0;
        if (this.alz.containsKey(valueOf)) {
            i = this.alz.get(valueOf).intValue();
            this.alz.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        C11095g.schedule(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.c.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int i2 = m25641dQ.status;
                if (i2 == 12 || i2 == 10 || !C11122q.m23718gs(C10296a.m26382H(C10487e.m25641dQ(adTemplate)))) {
                    return;
                }
                C9679c.this.m28042e(adTemplate, true);
            }
        }, m26580BN, TimeUnit.SECONDS);
    }

    /* renamed from: aQ */
    public final void m28048aQ(final AdTemplate adTemplate) {
        int m26568BZ = C10251d.m26568BZ();
        if (m26568BZ < 0) {
            return;
        }
        final AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        String valueOf = String.valueOf(m25641dQ.adBaseInfo.creativeId);
        int i = 0;
        if (this.alA.containsKey(valueOf)) {
            i = this.alA.get(valueOf).intValue();
            this.alA.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        C11095g.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (C11017ak.m24113ao(ServiceProvider.getContext(), C10483a.m25911ay(m25641dQ)) == 1) {
                    return;
                }
                C9679c.this.m28042e(adTemplate, false);
            }
        }, m26568BZ, TimeUnit.SECONDS);
    }

    /* renamed from: bj */
    public final void m28044bj(boolean z) {
        this.alC = z;
    }

    public final void dismiss() {
        AlertDialogC9668a.m28083zH();
        View$OnClickListenerC9693e view$OnClickListenerC9693e = this.aly;
        if (view$OnClickListenerC9693e != null) {
            view$OnClickListenerC9693e.dismiss();
            this.aly = null;
        }
    }

    @Nullable
    /* renamed from: zN */
    public final AdTemplate m28039zN() {
        AdTemplate adTemplate = null;
        while (!this.alB.isEmpty()) {
            AdTemplate pop = this.alB.pop();
            if (m28052aM(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.alB.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: zO */
    public final void m28038zO() {
        C9674b.m28065zJ().m28078a(new C9674b.InterfaceC9678a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.p364a.p365a.C9674b.InterfaceC9678a
            /* renamed from: go */
            public final void mo28034go() {
                C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        if (!C9679c.this.alC) {
                            C9679c.this.m28036zQ();
                        } else {
                            C9679c.this.alE = true;
                        }
                    }
                }, C10251d.m26577BQ());
            }

            @Override // com.kwad.sdk.p364a.p365a.C9674b.InterfaceC9678a
            /* renamed from: zL */
            public final void mo28033zL() {
                C10331c.m26254d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    /* renamed from: zP */
    public final void m28037zP() {
        m28044bj(false);
        if (this.alD || !this.alE) {
            return;
        }
        C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.c.5
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9679c.this.m28036zQ();
            }
        }, 5000L);
    }

    /* renamed from: zR */
    public final void m28035zR() {
        this.aly = null;
    }

    private C9679c() {
        this.alz = new HashMap();
        this.alA = new HashMap();
        this.alB = new Stack<>();
        this.alC = false;
        this.alD = false;
        this.alE = false;
    }

    /* renamed from: b */
    private static void m28045b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* renamed from: a */
    public void m28056a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (AlertDialogC9668a.m28084nr()) {
            return;
        }
        C10232b.m26625DD();
        Activity currentActivity = C10232b.getCurrentActivity();
        if (currentActivity != null && AlertDialogC9668a.m28088a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            m28054a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* renamed from: a */
    public void m28055a(AdTemplate adTemplate, boolean z, int i, boolean z2) {
        if (this.aly != null || AlertDialogC8602b.m30267nr()) {
            return;
        }
        boolean z3 = true;
        m28053a(adTemplate, z, (z && i == 1) ? false : false, z2);
    }

    @UiThread
    /* renamed from: a */
    private void m28053a(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context wrapContextIfNeed;
        C10232b.m26625DD();
        Activity currentActivity = C10232b.getCurrentActivity();
        if (currentActivity == null || (context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext()) == null || (wrapContextIfNeed = C10887l.wrapContextIfNeed(context)) == null) {
            return;
        }
        View$OnClickListenerC9693e view$OnClickListenerC9693e = new View$OnClickListenerC9693e(wrapContextIfNeed, adTemplate, z, z2, z3);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            view$OnClickListenerC9693e.m28027b((FrameLayout) findViewById);
            this.aly = view$OnClickListenerC9693e;
            m28054a(adTemplate, z, z3);
        }
        if (z3) {
            C10232b.m26625DD();
            C9673b.m28082H(C10232b.getCurrentActivity());
            C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.a.a.c.9
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9679c.this.aly != null) {
                        C9679c.this.aly.dismiss();
                        C9679c.m28062a(C9679c.this, (View$OnClickListenerC9693e) null);
                        C9679c c9679c = C9679c.this;
                        C9679c.m28041g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    /* renamed from: a */
    private void m28054a(AdTemplate adTemplate, boolean z, boolean z2) {
        String valueOf = String.valueOf(C10487e.m25631ea(adTemplate));
        if (z) {
            m28045b(this.alz, valueOf);
            C9913b c9913b = new C9913b();
            if (z2) {
                c9913b.m27257cT(23);
                c9913b.m27264cM(191);
            } else {
                c9913b.m27264cM(92);
            }
            C9908c.m27309d(adTemplate, (JSONObject) null, c9913b);
            return;
        }
        C9908c.m27316c(adTemplate, 93, (JSONObject) null);
        m28045b(this.alA, valueOf);
    }
}
