package com.kwad.components.p208ad.feed;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p402g.C10380d;
import com.kwad.sdk.core.p402g.InterfaceC10376b;
import com.kwad.sdk.utils.C11064bn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.ad.feed.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7586d {

    /* renamed from: eg */
    private static C10380d f25827eg;

    /* renamed from: eh */
    private static Vibrator f25828eh;

    /* renamed from: ei */
    private static List<C7589a> f25829ei = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.ad.feed.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7589a {

        /* renamed from: ek */
        private InterfaceC7590b f25831ek;
        private Context mContext;

        public C7589a(InterfaceC7590b interfaceC7590b, Context context) {
            this.f25831ek = interfaceC7590b;
            this.mContext = context;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7590b {
        /* renamed from: b */
        boolean mo32832b(double d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public static Vibrator m32841D(Context context) {
        if (f25828eh == null) {
            f25828eh = (Vibrator) context.getSystemService("vibrator");
        }
        return f25828eh;
    }

    /* renamed from: a */
    public static void m32838a(float f, Context context, InterfaceC7590b interfaceC7590b) {
        if (f25827eg == null) {
            m32839a(f, context);
        }
        f25829ei.add(new C7589a(interfaceC7590b, context));
    }

    /* renamed from: a */
    public static void m32837a(InterfaceC7590b interfaceC7590b) {
        for (C7589a c7589a : f25829ei) {
            if (c7589a.f25831ek == interfaceC7590b) {
                f25829ei.remove(c7589a);
            }
        }
        C10331c.m26254d("KSFeedShakeManager", "sShakeItems size " + f25829ei.size());
    }

    /* renamed from: a */
    private static void m32839a(float f, Context context) {
        f25827eg = new C10380d(f);
        f25829ei = new CopyOnWriteArrayList();
        f25827eg.m26199a(new InterfaceC10376b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
            /* renamed from: a */
            public final void mo26220a(double d) {
                if (C7586d.f25829ei != null) {
                    Iterator it = C7586d.f25829ei.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C7589a c7589a = (C7589a) it.next();
                        if (c7589a.f25831ek != null && c7589a.f25831ek.mo32832b(d)) {
                            C11064bn.m23863a(c7589a.mContext, C7586d.m32841D(c7589a.mContext));
                            break;
                        }
                    }
                    C11064bn.m23862a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C10331c.m26254d("KSFeedShakeManager", "onShakeEvent openGate2");
                            C7586d.f25827eg.m26202Fu();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
            /* renamed from: aV */
            public final void mo26219aV() {
            }
        });
        f25827eg.m26192e(f);
        f25827eg.m26195bi(context);
    }
}
