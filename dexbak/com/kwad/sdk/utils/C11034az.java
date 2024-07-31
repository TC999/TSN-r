package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p441l.p442a.C10853b;
import com.kwad.sdk.p441l.p442a.C10857f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.kwad.sdk.utils.az */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11034az {
    private static Context aPJ;
    private static Map<String, AbstractC11101j> aPK = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.az$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11035a extends AbstractC11101j<C10853b> {
        private static C10853b aPL;

        public C11035a(boolean z) {
            super(z);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        /* renamed from: a */
        private static int m23983a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) C11124s.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.AbstractC11101j
        /* renamed from: cQ */
        public C10853b mo23783bP(Context context) {
            int i;
            int i2;
            if (!C11028au.m24075Mh() && !((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(64L)) {
                C10853b c10853b = aPL;
                if (c10853b != null) {
                    return c10853b;
                }
                CellInfo cellInfo = null;
                if (context == null || C11028au.m24075Mh()) {
                    return null;
                }
                if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, C7282g.f24949g) != -1) {
                    if (C11059bi.checkSelfPermission(context, C7282g.f24949g) == 0) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        CellLocation cellLocation = telephonyManager.getCellLocation();
                        if (cellLocation instanceof CdmaCellLocation) {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                            i2 = cdmaCellLocation.getBaseStationId();
                            i = cdmaCellLocation.getNetworkId();
                        } else if (cellLocation instanceof GsmCellLocation) {
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                            i2 = gsmCellLocation.getCid();
                            i = gsmCellLocation.getLac();
                        } else {
                            i = -1;
                            i2 = -1;
                        }
                        Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CellInfo next = it.next();
                            if (next != null && next.isRegistered()) {
                                cellInfo = next;
                                break;
                            }
                        }
                        aPL = new C10853b(i2, i, cellInfo != null ? m23983a(cellInfo) : -1);
                    }
                    return aPL;
                }
                return null;
            }
            return aPL;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.az$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11036b extends AbstractC11101j<C10857f> {
        public C11036b(boolean z) {
            super(z);
        }

        @Nullable
        /* renamed from: cR */
        private static C10857f m23981cR(Context context) {
            C10857f c10857f = new C10857f();
            c10857f.aNe = C11029av.m24041cE(context);
            c10857f.aNd = C11029av.m24043cC(context);
            return c10857f;
        }

        @Override // com.kwad.sdk.utils.AbstractC11101j
        @Nullable
        /* renamed from: bP */
        protected final /* synthetic */ C10857f mo23783bP(Context context) {
            return m23981cR(context);
        }
    }

    @Nullable
    /* renamed from: Ky */
    public static C10853b m23988Ky() {
        if (m23986MA()) {
            return (C10853b) m23984gL("baseStationEnable");
        }
        return null;
    }

    @Nullable
    /* renamed from: Kz */
    public static C10857f m23987Kz() {
        if (m23986MA()) {
            return (C10857f) m23984gL("simCardInfoEnable");
        }
        return null;
    }

    /* renamed from: MA */
    private static boolean m23986MA() {
        return aPJ != null;
    }

    @Nullable
    /* renamed from: gK */
    private static <T> AbstractC11101j<T> m23985gK(String str) {
        try {
            return aPK.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: gL */
    private static <T> T m23984gL(String str) {
        AbstractC11101j m23985gK = m23985gK(str);
        if (m23985gK != null) {
            return (T) m23985gK.m23784bO(aPJ);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h == null) {
            C10331c.m26254d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
        } else if (m23986MA()) {
            if (aPK.containsKey("baseStationEnable")) {
                boolean mo24321yC = interfaceC10970h.mo24321yC();
                AbstractC11101j m23985gK = m23985gK("baseStationEnable");
                if (m23985gK != null) {
                    m23985gK.m23782bQ(mo24321yC);
                }
            }
            if (aPK.containsKey("simCardInfoEnable")) {
                boolean mo24323yA = interfaceC10970h.mo24323yA();
                AbstractC11101j m23985gK2 = m23985gK("simCardInfoEnable");
                if (m23985gK2 != null) {
                    m23985gK2.m23782bQ(mo24323yA);
                }
            }
        } else {
            aPJ = StubApp.getOrigApplicationContext(context.getApplicationContext());
            aPK.put("baseStationEnable", new C11035a(interfaceC10970h.mo24321yC()));
            aPK.put("simCardInfoEnable", new C11036b(interfaceC10970h.mo24323yA()));
        }
    }
}
