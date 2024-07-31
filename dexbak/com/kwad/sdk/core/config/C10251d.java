package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.p208ad.feed.p225a.C7497a;
import com.kwad.components.p208ad.fullscreen.p227a.C7605a;
import com.kwad.components.p208ad.interstitial.p239b.C7720a;
import com.kwad.components.p208ad.p213d.C7354a;
import com.kwad.components.p208ad.reward.p248a.C7843a;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.AbstractC10254b;
import com.kwad.sdk.core.config.item.C10256d;
import com.kwad.sdk.core.config.item.C10257e;
import com.kwad.sdk.core.config.item.C10258f;
import com.kwad.sdk.core.config.item.C10265k;
import com.kwad.sdk.core.config.item.C10267m;
import com.kwad.sdk.core.config.item.C10271p;
import com.kwad.sdk.core.network.idc.p407a.C10432b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11137y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C10251d {
    private static volatile SdkConfigData atj;
    private static final AtomicBoolean ati = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    /* renamed from: BA */
    public static boolean m26593BA() {
        return C10250c.aqK.getValue().intValue() > 0;
    }

    /* renamed from: BB */
    public static boolean m26592BB() {
        return C10250c.aqL.getValue().intValue() == 1;
    }

    /* renamed from: BC */
    public static int m26591BC() {
        return C10250c.aqK.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    /* renamed from: BD */
    private static void m26590BD() {
        C7354a.init();
        C7497a.init();
        C7605a.init();
        C7720a.init();
        C7843a.init();
        C8363a.init();
    }

    /* renamed from: BE */
    public static List<String> m26589BE() {
        return C10250c.arc.getValue();
    }

    @NonNull
    /* renamed from: BF */
    public static List<String> m26588BF() {
        return C10250c.arb.getValue();
    }

    /* renamed from: BG */
    public static int m26587BG() {
        return C10250c.asw.getValue().intValue();
    }

    /* renamed from: BH */
    public static String m26586BH() {
        return C10250c.aqW.getValue();
    }

    /* renamed from: BI */
    public static String m26585BI() {
        return C10250c.aqX.getValue();
    }

    /* renamed from: BJ */
    public static boolean m26584BJ() {
        return C10250c.aqB.getValue().intValue() == 1;
    }

    /* renamed from: BK */
    public static int m26583BK() {
        return C10250c.aqC.getValue().intValue();
    }

    /* renamed from: BL */
    public static boolean m26582BL() {
        return C10250c.aqD.getValue().intValue() == 1;
    }

    /* renamed from: BM */
    public static int m26581BM() {
        return C10250c.aqE.getValue().intValue();
    }

    /* renamed from: BN */
    public static int m26580BN() {
        return C10250c.arj.getValue().intValue();
    }

    /* renamed from: BO */
    public static int m26579BO() {
        return C10250c.ark.getValue().intValue();
    }

    /* renamed from: BP */
    public static int m26578BP() {
        return C10250c.arl.getValue().intValue();
    }

    /* renamed from: BQ */
    public static long m26577BQ() {
        return C10250c.arm.getValue().intValue() * 60000;
    }

    /* renamed from: BR */
    public static boolean m26576BR() {
        return C10250c.arv.getValue().intValue() == 1;
    }

    /* renamed from: BS */
    public static boolean m26575BS() {
        return C10250c.arw.getValue().intValue() == 1;
    }

    /* renamed from: BT */
    public static int m26574BT() {
        return C10250c.arD.getValue().intValue();
    }

    /* renamed from: BU */
    public static boolean m26573BU() {
        return C10250c.arE.getValue().booleanValue();
    }

    /* renamed from: BV */
    public static boolean m26572BV() {
        return m26527a(C10250c.arH);
    }

    /* renamed from: BW */
    public static boolean m26571BW() {
        return !C10250c.arJ.getValue().booleanValue();
    }

    /* renamed from: BX */
    public static boolean m26570BX() {
        return m26527a(C10250c.arI);
    }

    /* renamed from: BY */
    public static boolean m26569BY() {
        return C10250c.arL.getValue().intValue() == 1;
    }

    /* renamed from: BZ */
    public static int m26568BZ() {
        return C10250c.arM.getValue().intValue();
    }

    /* renamed from: Bu */
    public static boolean m26567Bu() {
        return C10250c.aqF.getValue().intValue() == 1;
    }

    /* renamed from: Bv */
    public static int m26566Bv() {
        return C10250c.aqG.getValue().intValue();
    }

    /* renamed from: Bw */
    public static int m26565Bw() {
        return C10250c.aqH.getValue().intValue();
    }

    /* renamed from: Bx */
    public static boolean m26564Bx() {
        return C10250c.aqJ.getValue().intValue() > 0;
    }

    /* renamed from: By */
    public static boolean m26563By() {
        return C10250c.aqH.getValue().intValue() == 2;
    }

    /* renamed from: Bz */
    public static int m26562Bz() {
        return C10250c.aqI.getValue().intValue();
    }

    /* renamed from: CA */
    public static String m26561CA() {
        return C10250c.asz.getValue();
    }

    /* renamed from: CB */
    public static String m26560CB() {
        return C10250c.asA.getValue();
    }

    /* renamed from: CC */
    public static int m26559CC() {
        return C10250c.asD.getValue().intValue();
    }

    /* renamed from: CD */
    public static boolean m26558CD() {
        return C10250c.asG.getValue().booleanValue();
    }

    /* renamed from: CE */
    public static int m26557CE() {
        return C10250c.asH.getValue().intValue();
    }

    /* renamed from: CF */
    public static boolean m26556CF() {
        return C10250c.atd.m26486CM();
    }

    /* renamed from: CG */
    public static boolean m26555CG() {
        return C10250c.atf.m26486CM();
    }

    @NonNull
    /* renamed from: Ca */
    public static SdkConfigData m26554Ca() {
        if (atj != null) {
            return atj;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C10331c.m26254d("SdkConfigManager", "getSdkConfigData is ui thread");
            atj = m26553Cb();
        } else {
            synchronized (mLock) {
                if (atj == null) {
                    return m26553Cb();
                }
            }
        }
        return atj;
    }

    /* renamed from: Cb */
    private static SdkConfigData m26553Cb() {
        atj = new SdkConfigData();
        String m23579ch = C11137y.m23579ch(ServiceProvider.m24363KO());
        if (!TextUtils.isEmpty(m23579ch)) {
            try {
                atj.parseJson(new JSONObject(m23579ch));
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        } else {
            C10331c.m26254d("SdkConfigManager", "configCache is empty");
        }
        return atj;
    }

    /* renamed from: Cc */
    public static boolean m26552Cc() {
        return C10250c.aqM.getValue().intValue() == 1;
    }

    /* renamed from: Cd */
    public static boolean m26551Cd() {
        return C10250c.aqN.getValue().intValue() == 1;
    }

    /* renamed from: Ce */
    public static boolean m26550Ce() {
        return C10250c.aqQ.getValue().booleanValue();
    }

    /* renamed from: Cf */
    public static boolean m26549Cf() {
        return C10250c.asl.getValue().intValue() == 1;
    }

    /* renamed from: Cg */
    public static int m26548Cg() {
        return C10250c.aqO.getValue().intValue();
    }

    /* renamed from: Ch */
    public static int m26547Ch() {
        return C10250c.arT.getValue().intValue();
    }

    /* renamed from: Ci */
    public static int m26546Ci() {
        return C10250c.arS.getValue().intValue();
    }

    /* renamed from: Cj */
    public static boolean m26545Cj() {
        return C10250c.arU.getValue().intValue() == 1;
    }

    /* renamed from: Ck */
    public static boolean m26544Ck() {
        return C10250c.arV.getValue().booleanValue();
    }

    /* renamed from: Cl */
    public static float m26543Cl() {
        float floatValue = C10250c.arW.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    /* renamed from: Cm */
    public static float m26542Cm() {
        return C10250c.arX.getValue().floatValue();
    }

    /* renamed from: Cn */
    public static boolean m26541Cn() {
        return C10250c.arZ.getValue().booleanValue();
    }

    /* renamed from: Co */
    public static boolean m26540Co() {
        return C10250c.asd.getValue().intValue() > 0;
    }

    /* renamed from: Cp */
    public static boolean m26539Cp() {
        return C10250c.ask.getValue().intValue() == 1;
    }

    /* renamed from: Cq */
    public static long m26538Cq() {
        return C10250c.asi.getValue().longValue();
    }

    /* renamed from: Cr */
    public static boolean m26537Cr() {
        return C10250c.aso.m26486CM();
    }

    /* renamed from: Cs */
    public static C10432b m26536Cs() {
        return C10250c.asq.getValue();
    }

    /* renamed from: Ct */
    public static int m26535Ct() {
        return C10250c.asr.getValue().intValue();
    }

    /* renamed from: Cu */
    public static long m26534Cu() {
        return C10250c.ass.getValue().longValue();
    }

    /* renamed from: Cv */
    public static int m26533Cv() {
        return C10250c.ast.getValue().intValue();
    }

    /* renamed from: Cw */
    public static boolean m26532Cw() {
        return C10250c.asu.getValue().floatValue() == 1.0f;
    }

    /* renamed from: Cx */
    public static boolean m26531Cx() {
        return C10250c.asv.m26486CM();
    }

    /* renamed from: Cy */
    public static boolean m26530Cy() {
        return C10250c.asx.m26486CM();
    }

    /* renamed from: Cz */
    public static String m26529Cz() {
        return C10250c.asy.getValue();
    }

    /* renamed from: X */
    public static boolean m26528X(long j) {
        return (j & C10250c.aqR.getValue().longValue()) != 0;
    }

    /* renamed from: a */
    public static JSONObject m26526a(C10257e c10257e) {
        JSONObject jSONObject = (JSONObject) m26520b(c10257e);
        return jSONObject != null ? jSONObject : c10257e.m26495CH();
    }

    @WorkerThread
    /* renamed from: aS */
    public static synchronized void m26521aS(Context context) {
        synchronized (C10251d.class) {
            AtomicBoolean atomicBoolean = ati;
            if (atomicBoolean.get()) {
                return;
            }
            C10331c.m26254d("SdkConfigManager", "loadCache");
            C10250c.init();
            m26590BD();
            C10249b.m26596aR(context);
            m26554Ca();
            atomicBoolean.set(true);
        }
    }

    /* renamed from: b */
    public static <T> T m26520b(@NonNull AbstractC10254b<T> abstractC10254b) {
        if (!isLoaded()) {
            final Context m24363KO = ServiceProvider.m24363KO();
            C10249b.m26601a(m24363KO, abstractC10254b);
            C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.config.d.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C10251d.m26521aS(m24363KO);
                }
            });
        }
        T value = abstractC10254b.getValue();
        return value != null ? value : abstractC10254b.m26495CH();
    }

    /* renamed from: f */
    public static void m26518f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            atj = sdkConfigData;
        }
    }

    public static String getLogObiwanData() {
        return C10250c.ash.getValue();
    }

    public static int getTKErrorDetailCount() {
        return C10250c.ate.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return C10250c.ata.getValue();
    }

    public static String getUserAgent() {
        return C10250c.arQ.getValue();
    }

    /* renamed from: gs */
    public static boolean m26517gs() {
        return C10250c.asc.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return ati.get();
    }

    /* renamed from: wJ */
    public static boolean m26516wJ() {
        return C10250c.asB.getValue().booleanValue();
    }

    /* renamed from: yA */
    public static boolean m26515yA() {
        return C10250c.ars.getValue().intValue() == 1;
    }

    /* renamed from: yC */
    public static boolean m26514yC() {
        return C10250c.art.getValue().intValue() == 1;
    }

    /* renamed from: yD */
    public static boolean m26513yD() {
        return C10250c.arr.getValue().intValue() == 1;
    }

    /* renamed from: yE */
    public static String m26512yE() {
        return C10250c.arF.getImei();
    }

    /* renamed from: yF */
    public static String m26511yF() {
        return C10250c.arF.getOaid();
    }

    /* renamed from: yG */
    public static List<String> m26510yG() {
        return C10250c.ara.getValue();
    }

    /* renamed from: yH */
    public static boolean m26509yH() {
        return C10250c.arP.getValue().intValue() == 1;
    }

    /* renamed from: yI */
    public static boolean m26508yI() {
        return C10250c.arR.getValue().intValue() == 1;
    }

    /* renamed from: yK */
    public static boolean m26507yK() {
        return C10250c.asm.getValue().booleanValue();
    }

    /* renamed from: yL */
    public static boolean m26506yL() {
        return C10250c.asn.getValue().booleanValue();
    }

    /* renamed from: yM */
    public static int m26505yM() {
        if (atj != null) {
            return atj.goodIdcThresholdMs;
        }
        return 200;
    }

    /* renamed from: yN */
    public static int m26504yN() {
        return C10250c.asp.getValue().intValue();
    }

    /* renamed from: yO */
    public static double m26503yO() {
        return C10250c.arY.getValue().floatValue();
    }

    /* renamed from: yP */
    public static boolean m26502yP() {
        return C10250c.asF.getValue().booleanValue();
    }

    /* renamed from: yT */
    public static boolean m26501yT() {
        return C10250c.asS.getValue().booleanValue();
    }

    @Deprecated
    /* renamed from: yU */
    public static int m26500yU() {
        return C10250c.aqP.getValue().intValue();
    }

    /* renamed from: yV */
    public static boolean m26499yV() {
        return C10250c.asW.m26486CM();
    }

    /* renamed from: ym */
    public static int m26498ym() {
        return C10250c.aqv.getValue().intValue();
    }

    /* renamed from: yn */
    public static boolean m26497yn() {
        return false;
    }

    /* renamed from: yo */
    public static boolean m26496yo() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return C10250c.aqA.getValue().intValue() == 1;
    }

    /* renamed from: a */
    public static int m26524a(C10265k c10265k) {
        Integer num = (Integer) m26520b((AbstractC10254b<Object>) c10265k);
        if (num == null) {
            num = c10265k.m26495CH();
        }
        return num.intValue();
    }

    /* renamed from: a */
    public static long m26523a(C10267m c10267m) {
        Long l = (Long) m26520b(c10267m);
        if (l == null) {
            l = c10267m.m26495CH();
        }
        return l.longValue();
    }

    /* renamed from: b */
    public static boolean m26519b(C10265k c10265k) {
        Integer num = (Integer) m26520b((AbstractC10254b<Object>) c10265k);
        return num != null ? num.intValue() > 0 : c10265k.m26495CH().intValue() > 0;
    }

    /* renamed from: a */
    public static double m26525a(C10258f c10258f) {
        Double d = (Double) m26520b(c10258f);
        if (d == null) {
            d = c10258f.m26495CH();
        }
        return d.doubleValue();
    }

    /* renamed from: a */
    public static boolean m26527a(C10256d c10256d) {
        Boolean bool = (Boolean) m26520b(c10256d);
        if (bool == null) {
            bool = c10256d.m26495CH();
        }
        return bool.booleanValue();
    }

    /* renamed from: a */
    public static String m26522a(C10271p c10271p) {
        String str = (String) m26520b(c10271p);
        return str != null ? str : c10271p.m26495CH();
    }
}
