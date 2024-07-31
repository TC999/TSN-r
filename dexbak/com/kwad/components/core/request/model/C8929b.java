package com.kwad.components.core.request.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.p441l.p442a.C10853b;
import com.kwad.sdk.p441l.p442a.C10855d;
import com.kwad.sdk.p441l.p442a.C10856e;
import com.kwad.sdk.p441l.p442a.C10857f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11043bb;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11073bu;
import com.kwad.sdk.utils.C11105n;
import com.kwad.sdk.utils.C11126t;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.request.model.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8929b implements InterfaceC9914b {

    /* renamed from: RC */
    private int f28816RC;

    /* renamed from: RD */
    private String f28817RD;

    /* renamed from: RE */
    private int f28818RE;

    /* renamed from: RF */
    private Long f28819RF;

    /* renamed from: RG */
    private Long f28820RG;

    /* renamed from: RH */
    private Long f28821RH;

    /* renamed from: RI */
    private Long f28822RI;

    /* renamed from: RJ */
    private String f28823RJ;

    /* renamed from: RK */
    private String f28824RK;

    /* renamed from: RM */
    private long f28826RM;

    /* renamed from: RN */
    private String f28827RN;

    /* renamed from: RO */
    private String f28828RO;

    /* renamed from: RP */
    private long f28829RP;

    /* renamed from: RR */
    private String f28831RR;

    /* renamed from: RS */
    private String f28832RS;

    /* renamed from: RT */
    private boolean f28833RT;

    /* renamed from: RV */
    private List<C8930a> f28835RV;

    /* renamed from: RW */
    private C10857f f28836RW;

    /* renamed from: RX */
    private C10855d f28837RX;

    /* renamed from: RY */
    private C10853b f28838RY;

    /* renamed from: RZ */
    private List<C10856e> f28839RZ;

    /* renamed from: RL */
    private List<C11073bu.C11074a> f28825RL = new CopyOnWriteArrayList();

    /* renamed from: RQ */
    private int f28830RQ = -1;
    private float screenBrightness = -1.0f;

    /* renamed from: RU */
    private int f28834RU = -1;

    @KsJson
    /* renamed from: com.kwad.components.core.request.model.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8930a extends C10482a implements InterfaceC9914b {

        /* renamed from: Sa */
        public int f28840Sa = -1;

        /* renamed from: Sb */
        public int f28841Sb = -1;

        /* renamed from: Sc */
        public int f28842Sc = -1;
        public int streamType;

        private C8930a(int i) {
            this.streamType = i;
        }

        /* renamed from: aG */
        private static int m29581aG(int i) {
            if (i != 0) {
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
                if (i == 4) {
                    return 4;
                }
                if (i == 5) {
                    return 5;
                }
            }
            return 0;
        }

        /* renamed from: ag */
        public static List<C8930a> m29580ag(Context context) {
            AudioManager audioManager;
            ArrayList arrayList = new ArrayList();
            if (context == null || C10251d.m26528X(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i = 0; i <= 5; i++) {
                C8930a c8930a = new C8930a(i);
                int m29581aG = m29581aG(i);
                c8930a.f28842Sc = audioManager.getStreamVolume(m29581aG);
                c8930a.f28840Sa = audioManager.getStreamMaxVolume(m29581aG);
                if (Build.VERSION.SDK_INT >= 28) {
                    c8930a.f28841Sb = audioManager.getStreamMinVolume(m29581aG);
                }
                arrayList.add(c8930a);
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:6:0x001e, B:8:0x0024, B:15:0x0037, B:17:0x0041, B:19:0x0046, B:22:0x004c, B:24:0x0052), top: B:29:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* renamed from: af */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m29583af(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            r6 = this;
            r0 = 512(0x200, double:2.53E-321)
            boolean r0 = com.kwad.sdk.core.config.C10251d.m26528X(r0)
            if (r0 == 0) goto L9
            return
        L9:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)
            r1 = 0
            android.content.Intent r7 = r7.registerReceiver(r1, r0)     // Catch: java.lang.Exception -> L55
            if (r7 == 0) goto L54
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L55
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r4) goto L36
            r5 = 5
            if (r0 != r5) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            r6.f28833RT = r0     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = "plugged"
            int r7 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L55
            if (r7 != r4) goto L44
            r6.f28834RU = r3     // Catch: java.lang.Exception -> L55
            goto L59
        L44:
            if (r7 != r3) goto L49
            r6.f28834RU = r4     // Catch: java.lang.Exception -> L55
            goto L59
        L49:
            r0 = 4
            if (r7 != r0) goto L50
            r7 = 3
            r6.f28834RU = r7     // Catch: java.lang.Exception -> L55
            goto L59
        L50:
            if (r7 != 0) goto L54
            r6.f28834RU = r2     // Catch: java.lang.Exception -> L55
        L54:
            return
        L55:
            r7 = move-exception
            com.kwad.sdk.core.p397e.C10331c.printStackTrace(r7)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.request.model.C8929b.m29583af(android.content.Context):void");
    }

    private static Context getContext() {
        return ServiceProvider.m24363KO();
    }

    @WorkerThread
    /* renamed from: qz */
    public static C8929b m29582qz() {
        C8929b c8929b = new C8929b();
        c8929b.f28816RC = C11059bi.m23912MV();
        c8929b.f28817RD = AbiUtil.m24284bD(getContext());
        c8929b.f28818RE = C11059bi.m23891cW(getContext());
        c8929b.f28819RF = Long.valueOf(C11059bi.m23890cX(getContext()));
        c8929b.f28820RG = Long.valueOf(C11059bi.m23892cV(getContext()));
        c8929b.f28821RH = Long.valueOf(C11059bi.m23915MS());
        c8929b.f28822RI = Long.valueOf(C11059bi.m23914MT());
        c8929b.f28823RJ = C11029av.m24045cA(getContext());
        c8929b.f28824RK = C11029av.m24044cB(getContext());
        c8929b.f28825RL.addAll(C11029av.m24018n(getContext(), 15));
        c8929b.f28826RM = C11059bi.m23908MZ();
        c8929b.f28829RP = C11059bi.m23907Na();
        c8929b.f28832RS = C11059bi.m23906Nb();
        c8929b.f28831RR = C11059bi.m23905Nc();
        c8929b.f28827RN = C11059bi.m23904Nd();
        c8929b.f28828RO = C11059bi.m23903Ne();
        Context context = getContext();
        if (context != null) {
            c8929b.f28830RQ = C11059bi.m23881de(context);
            c8929b.f28835RV = new CopyOnWriteArrayList(C8930a.m29580ag(context));
            c8929b.m29583af(context);
        }
        c8929b.f28837RX = C11105n.m23768Lg();
        c8929b.f28838RY = C11029av.m24062Ky();
        c8929b.f28839RZ = C11043bb.m23963MC().m23962MD();
        c8929b.f28836RW = C11029av.m24061Kz();
        return c8929b;
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "cpuCount", this.f28816RC);
        C11126t.putValue(jSONObject, "cpuAbi", this.f28817RD);
        C11126t.putValue(jSONObject, "batteryPercent", this.f28818RE);
        C11126t.putValue(jSONObject, "totalMemorySize", this.f28819RF.longValue());
        C11126t.putValue(jSONObject, "availableMemorySize", this.f28820RG.longValue());
        C11126t.putValue(jSONObject, "totalDiskSize", this.f28821RH.longValue());
        C11126t.putValue(jSONObject, "availableDiskSize", this.f28822RI.longValue());
        C11126t.putValue(jSONObject, "imsi", this.f28823RJ);
        C11126t.putValue(jSONObject, UMCommonContent.f37797aa, this.f28824RK);
        C11126t.putValue(jSONObject, "wifiList", this.f28825RL);
        C11126t.putValue(jSONObject, "bootTime", this.f28826RM);
        C11126t.putValue(jSONObject, "romName", this.f28827RN);
        C11126t.putValue(jSONObject, "romVersion", this.f28828RO);
        C11126t.putValue(jSONObject, "romBuildTimestamp", this.f28829RP);
        C11126t.putValue(jSONObject, "ringerMode", this.f28830RQ);
        C11126t.putValue(jSONObject, "audioStreamInfo", this.f28835RV);
        C11126t.putValue(jSONObject, "baseBandVersion", this.f28831RR);
        C11126t.putValue(jSONObject, "fingerPrint", this.f28832RS);
        C11126t.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        C11126t.putValue(jSONObject, "isCharging", this.f28833RT);
        C11126t.putValue(jSONObject, "chargeType", this.f28834RU);
        C10857f c10857f = this.f28836RW;
        if (c10857f != null) {
            C11126t.m23678a(jSONObject, "simCardInfo", c10857f);
        }
        C10855d c10855d = this.f28837RX;
        if (c10855d != null) {
            C11126t.m23678a(jSONObject, "environmentInfo", c10855d);
        }
        C10853b c10853b = this.f28838RY;
        if (c10853b != null) {
            C11126t.m23678a(jSONObject, "baseStationInfo", c10853b);
        }
        List<C10856e> list = this.f28839RZ;
        if (list != null) {
            C11126t.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
