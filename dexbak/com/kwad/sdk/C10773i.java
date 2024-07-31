package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p318p.C8770b;
import com.kwad.components.core.request.model.C8929b;
import com.kwad.components.p206a.p207a.InterfaceC7326a;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.config.C10248a;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.config.item.C10255c;
import com.kwad.sdk.core.config.item.C10268n;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.download.C10303b;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.network.C10424i;
import com.kwad.sdk.core.network.C10434j;
import com.kwad.sdk.core.network.InterfaceC10435k;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10454f;
import com.kwad.sdk.core.report.C10464n;
import com.kwad.sdk.core.report.InterfaceC10471s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.InterfaceC10489g;
import com.kwad.sdk.core.video.p411a.InterfaceC10536f;
import com.kwad.sdk.kgeo.C10839a;
import com.kwad.sdk.p434g.AbstractC10762b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10963a;
import com.kwad.sdk.service.p449a.InterfaceC10964b;
import com.kwad.sdk.service.p449a.InterfaceC10965c;
import com.kwad.sdk.service.p449a.InterfaceC10966d;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10969g;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.service.p449a.InterfaceC10971i;
import com.kwad.sdk.service.p449a.InterfaceC10972j;
import com.kwad.sdk.utils.p451b.C11038a;
import com.kwad.sdk.utils.p451b.InterfaceC11039b;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10773i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10784a implements InterfaceC10963a {
        private C10784a() {
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10963a
        /* renamed from: g */
        public final void mo24354g(Context context, AdTemplate adTemplate) {
            C8615a.m30233a(new C8615a.C8616a(context).m30198aq(adTemplate).m30197aq(true));
        }

        /* synthetic */ C10784a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.i$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10785b implements InterfaceC10968f {
        private C10785b() {
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: a */
        public final void mo24344a(String str, Map<String, String> map, String str2) {
            C9889d.m27430a(str, map, str2);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: aF */
        public final boolean mo24343aF(AdTemplate adTemplate) {
            InterfaceC7326a interfaceC7326a = (InterfaceC7326a) C9861c.m27501f(InterfaceC7326a.class);
            return interfaceC7326a != null && interfaceC7326a.m33471tC();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: al */
        public final String mo24342al(String str) {
            return C9889d.m27429al(str);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        public final String getApiVersion() {
            return C10829k.m24699zd().getApiVersion();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        public final int getApiVersionCode() {
            return C10829k.m24699zd().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        public final String getSDKVersion() {
            C10829k.m24699zd();
            return C10829k.getSDKVersion();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: oK */
        public final boolean mo24341oK() {
            InterfaceC8695a interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class);
            if (interfaceC8695a != null) {
                return interfaceC8695a.mo28869oK();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: tD */
        public final InterfaceC10489g mo24340tD() {
            InterfaceC7326a interfaceC7326a = (InterfaceC7326a) C9861c.m27501f(InterfaceC7326a.class);
            if (interfaceC7326a != null) {
                return interfaceC7326a.m33470tD();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yp */
        public final boolean mo24339yp() {
            return C10829k.m24699zd().m24703yp();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yq */
        public final boolean mo24338yq() {
            return C10829k.m24699zd().m24702yq();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yr */
        public final boolean mo24337yr() {
            return C10829k.m24699zd().m24701yr();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: ys */
        public final boolean mo24336ys() {
            return C10829k.m24699zd().m24700ys();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yt */
        public final String mo24335yt() {
            return C10839a.m24656yt();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yu */
        public final InterfaceC9914b mo24334yu() {
            return C10839a.m24663IS();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yv */
        public final List<AdTemplate> mo24333yv() {
            return C10303b.m26364De().m26339yv();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yw */
        public final String mo24332yw() {
            return C10760g.m24890ya();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yx */
        public final JSONObject mo24331yx() {
            return C8766a.m29888qi().m29889m("", "").toJson();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yy */
        public final JSONObject mo24330yy() {
            return new C10454f((List<C10464n>) null).getBodyParams();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10968f
        /* renamed from: yz */
        public final Map<String, String> mo24329yz() {
            return new C10454f((List<C10464n>) null).getHeader();
        }

        /* synthetic */ C10785b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.i$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10786c implements InterfaceC10970h {
        private C10786c() {
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: X */
        public final boolean mo24327X(long j) {
            return C10251d.m26528X(j);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: as */
        public final int mo24326as(Context context) {
            return C10255c.m26492aT(context);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: bW */
        public final boolean mo24325bW(String str) {
            return C10248a.m26605bW(str);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        public final <T> T getAppConfigData(T t, AbstractC10762b<JSONObject, T> abstractC10762b) {
            return (T) C10251d.m26554Ca().getAppConfigData(null, abstractC10762b);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        public final String getUserAgent() {
            return C10251d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: wJ */
        public final boolean mo24324wJ() {
            return C10251d.m26516wJ();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yA */
        public final boolean mo24323yA() {
            return C10251d.m26515yA();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yB */
        public final boolean mo24322yB() {
            return C10251d.m26519b(C10250c.aru);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yC */
        public final boolean mo24321yC() {
            return C10251d.m26514yC();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yD */
        public final boolean mo24320yD() {
            return C10251d.m26513yD();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yE */
        public final String mo24319yE() {
            return C10251d.m26512yE();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yF */
        public final String mo24318yF() {
            return C10251d.m26511yF();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yG */
        public final List<String> mo24317yG() {
            return C10251d.m26510yG();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yH */
        public final boolean mo24316yH() {
            return C10251d.m26509yH();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yI */
        public final boolean mo24315yI() {
            return C10251d.m26508yI();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yJ */
        public final boolean mo24314yJ() {
            return C10251d.m26549Cf();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yK */
        public final boolean mo24313yK() {
            return C10251d.m26507yK();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yL */
        public final boolean mo24312yL() {
            return C10251d.m26506yL();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yM */
        public final int mo24311yM() {
            return C10251d.m26505yM();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yN */
        public final int mo24310yN() {
            return C10251d.m26504yN();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yO */
        public final double mo24309yO() {
            return C10251d.m26503yO();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yP */
        public final boolean mo24308yP() {
            return C10251d.m26502yP();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yQ */
        public final boolean mo24307yQ() {
            return C10251d.m26527a(C10250c.asP);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yR */
        public final boolean mo24306yR() {
            return C10251d.m26527a(C10250c.asQ);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yS */
        public final boolean mo24305yS() {
            return C10251d.m26527a(C10250c.asR);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yT */
        public final boolean mo24304yT() {
            return C10251d.m26501yT();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yU */
        public final int mo24303yU() {
            return C10251d.m26500yU();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yV */
        public final boolean mo24302yV() {
            return C10251d.m26499yV();
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yW */
        public final String mo24301yW() {
            return C10251d.m26522a(C10250c.asY);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yX */
        public final boolean mo24300yX() {
            return C10251d.m26519b(C10250c.atc);
        }

        @Override // com.kwad.sdk.service.p449a.InterfaceC10970h
        /* renamed from: yY */
        public final String mo24299yY() {
            return C10251d.m26522a(C10250c.ath);
        }

        /* synthetic */ C10786c(byte b) {
            this();
        }
    }

    /* renamed from: yj */
    public static void m24878yj() {
        ServiceProvider.put(InterfaceC10968f.class, new C10785b((byte) 0));
        ServiceProvider.put(InterfaceC10970h.class, new C10786c((byte) 0));
        ServiceProvider.put(InterfaceC10967e.class, new InterfaceC10967e() { // from class: com.kwad.sdk.i.1
            @Override // com.kwad.sdk.service.p449a.InterfaceC10967e
            /* renamed from: G */
            public final void mo24347G(String str, String str2) {
                C8571a.m30339j(str, str2);
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10967e
            /* renamed from: a */
            public final void mo24346a(final InterfaceC10965c interfaceC10965c) {
                C8571a.m30344a(new C8571a.InterfaceC8577b() { // from class: com.kwad.sdk.i.1.1
                    @Override // com.kwad.components.core.p288d.C8571a.InterfaceC8577b
                    public final String getKey() {
                        InterfaceC10965c interfaceC10965c2 = interfaceC10965c;
                        if (interfaceC10965c2 != null) {
                            return interfaceC10965c2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.p288d.C8571a.InterfaceC8577b
                    public final JSONObject getValue() {
                        InterfaceC10965c interfaceC10965c2 = interfaceC10965c;
                        if (interfaceC10965c2 != null) {
                            return interfaceC10965c2.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10967e
            public final void gatherException(Throwable th) {
                C8571a.reportSdkCaughtException(th);
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10967e
            /* renamed from: a */
            public final void mo24345a(final InterfaceC10969g interfaceC10969g) {
                C8571a.m30343a(new C8571a.InterfaceC8578c() { // from class: com.kwad.sdk.i.1.2
                    @Override // com.kwad.components.core.p288d.C8571a.InterfaceC8578c
                    public final void onCrashOccur(int i, String str) {
                        InterfaceC10969g interfaceC10969g2 = interfaceC10969g;
                        if (interfaceC10969g2 != null) {
                            interfaceC10969g2.mo24328l(i, str);
                        }
                    }
                });
            }
        });
        ServiceProvider.put(InterfaceC10966d.class, new InterfaceC10966d() { // from class: com.kwad.sdk.i.2
            @Override // com.kwad.sdk.service.p449a.InterfaceC10966d
            /* renamed from: a */
            public final void mo24349a(boolean z, String str, String str2, String str3) {
                C10291a.m26395Dc().m26390dr(str);
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10966d
            /* renamed from: bV */
            public final File mo24348bV(String str) {
                return C10291a.m26395Dc().m26391bV(str);
            }
        });
        ServiceProvider.put(InterfaceC10972j.class, new InterfaceC10972j() { // from class: com.kwad.sdk.i.3
            @Override // com.kwad.sdk.service.p449a.InterfaceC10972j
            /* renamed from: qB */
            public final boolean mo24298qB() {
                C8770b.m29881qA();
                return C8770b.m29880qB();
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10972j
            /* renamed from: qC */
            public final int mo24297qC() {
                C8770b.m29881qA();
                return C8770b.m29879qC();
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10972j
            /* renamed from: qD */
            public final int mo24296qD() {
                return C8770b.m29881qA().m29878qD();
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10972j
            public final InputStream wrapInputStream(InputStream inputStream) {
                C8770b.m29881qA();
                return C8770b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(InterfaceC10435k.class, new InterfaceC10435k() { // from class: com.kwad.sdk.i.4
            @Override // com.kwad.sdk.core.network.InterfaceC10435k
            /* renamed from: a */
            public final void mo24876a(C10434j c10434j) {
                C9815b.m27680b(c10434j);
            }

            @Override // com.kwad.sdk.core.network.InterfaceC10435k
            /* renamed from: yk */
            public final InterfaceC9914b mo24875yk() {
                return C8929b.m29582qz();
            }

            @Override // com.kwad.sdk.core.network.InterfaceC10435k
            /* renamed from: a */
            public final void mo24877a(C10424i c10424i) {
                C9815b.m27681b(c10424i);
            }
        });
        ServiceProvider.put(InterfaceC10971i.class, ImageLoaderProxy.INSTANCE);
        ServiceProvider.put(InterfaceC10964b.class, new InterfaceC10964b() { // from class: com.kwad.sdk.i.5
            @Override // com.kwad.sdk.service.p449a.InterfaceC10964b
            /* renamed from: H */
            public final void mo24353H(String str, String str2) {
                C10331c.m26250e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10964b
            /* renamed from: aE */
            public final void mo24352aE(AdTemplate adTemplate) {
                C8766a.m29888qi().m29895f(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10964b
            /* renamed from: e */
            public final void mo24351e(@NonNull JSONObject jSONObject, int i) {
                C8766a.m29888qi().m29896e(jSONObject, i);
            }

            @Override // com.kwad.sdk.service.p449a.InterfaceC10964b
            /* renamed from: yl */
            public final void mo24350yl() {
                C8766a.m29888qi().m29908ae(ServiceProvider.getContext());
            }
        });
        ServiceProvider.put(InterfaceC10471s.class, new InterfaceC10471s() { // from class: com.kwad.sdk.i.6
            @Override // com.kwad.sdk.core.report.InterfaceC10471s
            /* renamed from: W */
            public final boolean mo24874W(long j) {
                C10268n c10268n = C10250c.arh;
                return C10268n.m26483W(j);
            }

            @Override // com.kwad.sdk.core.report.InterfaceC10471s
            /* renamed from: tA */
            public final int mo24873tA() {
                InterfaceC7326a interfaceC7326a = (InterfaceC7326a) C9861c.m27501f(InterfaceC7326a.class);
                if (interfaceC7326a != null) {
                    return interfaceC7326a.m33473tA();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.InterfaceC10471s
            /* renamed from: ym */
            public final int mo24872ym() {
                return C10251d.m26498ym();
            }
        });
        ServiceProvider.put(InterfaceC10536f.class, new InterfaceC10536f() { // from class: com.kwad.sdk.i.7
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10536f
            /* renamed from: tB */
            public final boolean mo24871tB() {
                return ((InterfaceC7326a) C9861c.m27501f(InterfaceC7326a.class)).m33472tB();
            }

            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10536f
            /* renamed from: yn */
            public final boolean mo24870yn() {
                return C10251d.m26497yn();
            }

            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10536f
            /* renamed from: yo */
            public final boolean mo24869yo() {
                return C10251d.m26496yo();
            }
        });
        ServiceProvider.put(InterfaceC11039b.class, new InterfaceC11039b() { // from class: com.kwad.sdk.i.8
            @Override // com.kwad.sdk.utils.p451b.InterfaceC11039b
            /* renamed from: a */
            public final void mo23975a(C11038a c11038a) {
                if (c11038a == null) {
                    return;
                }
                C9815b.m27679b(c11038a);
            }
        });
        ServiceProvider.put(InterfaceC10963a.class, new C10784a((byte) 0));
    }
}
