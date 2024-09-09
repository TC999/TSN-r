package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {
    private static volatile SdkConfigData auu;
    private static final AtomicBoolean aut = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    public static boolean CA() {
        return c.asB.Dx().intValue() == 1;
    }

    public static boolean CB() {
        return c.asC.Dx().intValue() == 1;
    }

    public static int CC() {
        return c.asJ.Dx().intValue();
    }

    public static boolean CD() {
        return c.asK.Ds().booleanValue();
    }

    public static boolean CE() {
        return a(c.asN);
    }

    public static boolean CF() {
        return a(c.asP);
    }

    public static boolean CG() {
        return !c.asQ.Ds().booleanValue();
    }

    public static boolean CH() {
        return a(c.asO);
    }

    public static boolean CI() {
        return c.asS.Dx().intValue() == 1;
    }

    public static int CJ() {
        return c.asT.Dx().intValue();
    }

    @NonNull
    public static SdkConfigData CK() {
        if (auu != null) {
            return auu;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            auu = CL();
        } else {
            synchronized (mLock) {
                if (auu == null) {
                    return CL();
                }
            }
        }
        return auu;
    }

    private static SdkConfigData CL() {
        auu = new SdkConfigData();
        String ct = y.ct(ServiceProvider.Lw());
        if (!TextUtils.isEmpty(ct)) {
            try {
                auu.parseJson(new JSONObject(ct));
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        } else {
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "configCache is empty");
        }
        return auu;
    }

    public static boolean CM() {
        return c.arS.Dx().intValue() == 1;
    }

    public static boolean CN() {
        return c.arT.Dx().intValue() == 1;
    }

    public static boolean CO() {
        return c.arW.Ds().booleanValue();
    }

    public static boolean CP() {
        return c.ats.Dx().intValue() == 1;
    }

    public static int CQ() {
        return c.arU.Dx().intValue();
    }

    public static int CR() {
        return c.ata.Dx().intValue();
    }

    public static int CS() {
        return c.asZ.Dx().intValue();
    }

    public static boolean CT() {
        return c.atb.Dx().intValue() == 1;
    }

    public static boolean CU() {
        return c.atc.Ds().booleanValue();
    }

    public static float CV() {
        float floatValue = c.atd.Dv().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float CW() {
        return c.ate.Dv().floatValue();
    }

    public static boolean CX() {
        return c.atg.Ds().booleanValue();
    }

    public static boolean CY() {
        return c.atk.Dx().intValue() > 0;
    }

    public static boolean CZ() {
        return c.atr.Dx().intValue() == 1;
    }

    public static boolean Cc() {
        return c.arL.Dx().intValue() == 1;
    }

    public static int Cd() {
        return c.arM.Dx().intValue();
    }

    public static int Ce() {
        return c.arN.Dx().intValue();
    }

    public static boolean Cf() {
        return c.arP.Dx().intValue() > 0;
    }

    public static boolean Cg() {
        return c.arN.Dx().intValue() == 2;
    }

    public static int Ch() {
        return c.arO.Dx().intValue();
    }

    public static boolean Ci() {
        return c.arQ.Dx().intValue() > 0;
    }

    public static boolean Cj() {
        return c.arR.Dx().intValue() == 1;
    }

    public static int Ck() {
        return c.arQ.Dx().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ForInvoker(methodId = "initConfigList")
    public static void Cl() {
        com.kwad.components.ad.d.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> Cm() {
        return c.asi.getValue();
    }

    @NonNull
    public static List<String> Cn() {
        return c.ash.getValue();
    }

    public static int Co() {
        return c.atD.Dx().intValue();
    }

    public static int Cp() {
        return c.atE.Dx().intValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    public static String Cq() {
        return c.asc.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    public static String Cr() {
        return c.asd.getValue();
    }

    public static boolean Cs() {
        return c.arH.Dx().intValue() == 1;
    }

    public static int Ct() {
        return c.arI.Dx().intValue();
    }

    public static boolean Cu() {
        return c.arJ.Dx().intValue() == 1;
    }

    public static int Cv() {
        return c.arK.Dx().intValue();
    }

    public static int Cw() {
        return c.asp.Dx().intValue();
    }

    public static int Cx() {
        return c.asq.Dx().intValue();
    }

    public static int Cy() {
        return c.asr.Dx().intValue();
    }

    public static long Cz() {
        return c.ass.Dx().intValue() * 60000;
    }

    public static long Da() {
        return c.atp.Dy().longValue();
    }

    public static boolean Db() {
        return c.atv.Dw();
    }

    public static com.kwad.sdk.core.network.idc.a.b Dc() {
        return c.atx.getValue();
    }

    public static int Dd() {
        return c.aty.Dx().intValue();
    }

    public static long De() {
        return c.atz.Dy().longValue();
    }

    public static int Df() {
        return c.atA.Dx().intValue();
    }

    public static boolean Dg() {
        return c.atB.Dv().floatValue() == 1.0f;
    }

    public static boolean Dh() {
        return c.atC.Dw();
    }

    public static boolean Di() {
        return c.atF.Dw();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    public static String Dj() {
        return c.atG.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    public static String Dk() {
        return c.atH.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    public static String Dl() {
        return c.atI.getValue();
    }

    public static int Dm() {
        return c.atL.Dx().intValue();
    }

    public static boolean Dn() {
        return c.atP.Ds().booleanValue();
    }

    public static int Do() {
        return c.atQ.Dx().intValue();
    }

    public static boolean Dp() {
        return c.aum.Dw();
    }

    public static boolean Dq() {
        return c.auo.Dw();
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : (JSONObject) eVar.Dr();
    }

    public static boolean ab(long j4) {
        return (j4 & c.arX.Dy().longValue()) != 0;
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context Lw = ServiceProvider.Lw();
            b.a(Lw, bVar);
            g.execute(new ay() { // from class: com.kwad.sdk.core.config.d.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    d.aS(Lw);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : (T) bVar.Dr();
    }

    @WorkerThread
    public static synchronized void bf(Context context) {
        synchronized (d.class) {
            AtomicBoolean atomicBoolean = aut;
            if (atomicBoolean.get()) {
                return;
            }
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "loadCache");
            c.init();
            Cl();
            b.be(context);
            CK();
            atomicBoolean.set(true);
        }
    }

    public static int cb(String str) {
        return c.aus.dv(str);
    }

    public static void f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            auu = sdkConfigData;
        }
    }

    public static String getLogObiwanData() {
        return c.ato.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.aun.Dx().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.auj.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    public static String getUserAgent() {
        return c.asX.getValue();
    }

    public static boolean gt() {
        return c.atj.Ds().booleanValue();
    }

    public static boolean isLoaded() {
        return aut.get();
    }

    public static boolean xn() {
        return c.atJ.Ds().booleanValue();
    }

    public static int yS() {
        return c.arB.Dx().intValue();
    }

    public static boolean yT() {
        return false;
    }

    public static boolean yU() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.arG.Dx().intValue() == 1;
    }

    @Deprecated
    public static int zA() {
        return c.arV.Dx().intValue();
    }

    public static boolean zB() {
        return c.auf.Dw();
    }

    public static boolean zK() {
        return c.aup.Dw();
    }

    public static boolean zg() {
        return c.asy.Dx().intValue() == 1;
    }

    public static boolean zi() {
        return c.asz.Dx().intValue() == 1;
    }

    public static boolean zj() {
        return c.asx.Dx().intValue() == 1;
    }

    public static String zk() {
        return c.asL.getImei();
    }

    public static String zl() {
        return c.asL.getOaid();
    }

    public static List<String> zm() {
        return c.asg.getValue();
    }

    public static boolean zn() {
        return c.asW.Dx().intValue() == 1;
    }

    public static boolean zo() {
        return c.asY.Dx().intValue() == 1;
    }

    public static boolean zq() {
        return c.att.Ds().booleanValue();
    }

    public static boolean zr() {
        return c.atu.Ds().booleanValue();
    }

    public static int zs() {
        if (auu != null) {
            return auu.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int zt() {
        return c.atw.Dx().intValue();
    }

    public static double zu() {
        return c.atf.Dv().floatValue();
    }

    public static boolean zv() {
        return c.atN.Ds().booleanValue();
    }

    public static boolean zz() {
        return c.aub.Ds().booleanValue();
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b<Object>) kVar);
        if (num == null) {
            num = (Integer) kVar.Dr();
        }
        return num.intValue();
    }

    public static long a(n nVar) {
        Long l4 = (Long) b(nVar);
        if (l4 == null) {
            l4 = (Long) nVar.Dr();
        }
        return l4.longValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b<Object>) kVar);
        return num != null ? num.intValue() > 0 : ((Integer) kVar.Dr()).intValue() > 0;
    }

    public static double a(f fVar) {
        Double d4 = (Double) b(fVar);
        if (d4 == null) {
            d4 = (Double) fVar.Dr();
        }
        return d4.doubleValue();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = (Boolean) dVar.Dr();
        }
        return bool.booleanValue();
    }

    public static String a(q qVar) {
        String str = (String) b(qVar);
        return str != null ? str : (String) qVar.Dr();
    }
}
