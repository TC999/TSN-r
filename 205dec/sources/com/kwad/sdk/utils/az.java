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
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class az {
    private static Context aPJ;
    private static Map<String, j> aPK = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends j<com.kwad.sdk.l.a.b> {
        private static com.kwad.sdk.l.a.b aPL;

        public a(boolean z3) {
            super(z3);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) s.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        /* renamed from: cQ */
        public com.kwad.sdk.l.a.b bP(Context context) {
            int i4;
            int i5;
            if (!au.Mh() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(64L)) {
                com.kwad.sdk.l.a.b bVar = aPL;
                if (bVar != null) {
                    return bVar;
                }
                CellInfo cellInfo = null;
                if (context == null || au.Mh()) {
                    return null;
                }
                if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1) {
                    if (bi.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        CellLocation cellLocation = telephonyManager.getCellLocation();
                        if (cellLocation instanceof CdmaCellLocation) {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                            i5 = cdmaCellLocation.getBaseStationId();
                            i4 = cdmaCellLocation.getNetworkId();
                        } else if (cellLocation instanceof GsmCellLocation) {
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                            i5 = gsmCellLocation.getCid();
                            i4 = gsmCellLocation.getLac();
                        } else {
                            i4 = -1;
                            i5 = -1;
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
                        aPL = new com.kwad.sdk.l.a.b(i5, i4, cellInfo != null ? a(cellInfo) : -1);
                    }
                    return aPL;
                }
                return null;
            }
            return aPL;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends j<com.kwad.sdk.l.a.f> {
        public b(boolean z3) {
            super(z3);
        }

        @Nullable
        private static com.kwad.sdk.l.a.f cR(Context context) {
            com.kwad.sdk.l.a.f fVar = new com.kwad.sdk.l.a.f();
            fVar.aNe = av.cE(context);
            fVar.aNd = av.cC(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.j
        @Nullable
        protected final /* synthetic */ com.kwad.sdk.l.a.f bP(Context context) {
            return cR(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.l.a.b Ky() {
        if (MA()) {
            return (com.kwad.sdk.l.a.b) gL("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.l.a.f Kz() {
        if (MA()) {
            return (com.kwad.sdk.l.a.f) gL("simCardInfoEnable");
        }
        return null;
    }

    private static boolean MA() {
        return aPJ != null;
    }

    @Nullable
    private static <T> j<T> gK(String str) {
        try {
            return aPK.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static <T> T gL(String str) {
        j gK = gK(str);
        if (gK != null) {
            return (T) gK.bO(aPJ);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
        } else if (MA()) {
            if (aPK.containsKey("baseStationEnable")) {
                boolean yC = hVar.yC();
                j gK = gK("baseStationEnable");
                if (gK != null) {
                    gK.bQ(yC);
                }
            }
            if (aPK.containsKey("simCardInfoEnable")) {
                boolean yA = hVar.yA();
                j gK2 = gK("simCardInfoEnable");
                if (gK2 != null) {
                    gK2.bQ(yA);
                }
            }
        } else {
            aPJ = StubApp.getOrigApplicationContext(context.getApplicationContext());
            aPK.put("baseStationEnable", new a(hVar.yC()));
            aPK.put("simCardInfoEnable", new b(hVar.yA()));
        }
    }
}
