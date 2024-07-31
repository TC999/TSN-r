package com.kwad.sdk.core.p399f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p399f.p400a.C10347a;
import com.kwad.sdk.core.p399f.p400a.C10349b;
import com.kwad.sdk.core.p399f.p400a.C10351c;
import com.kwad.sdk.core.p399f.p400a.C10353d;
import com.kwad.sdk.core.p399f.p400a.C10354e;
import com.kwad.sdk.core.p399f.p400a.C10355f;
import com.kwad.sdk.core.p399f.p400a.C10357g;
import com.kwad.sdk.core.p399f.p400a.C10359h;
import com.kwad.sdk.core.p399f.p400a.C10360i;
import com.kwad.sdk.core.p399f.p400a.C10361j;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11028au;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11120o;
import com.kwad.sdk.utils.C11137y;
import com.stub.StubApp;
import io.netty.util.internal.StringUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10343a {
    private static String awV = "";
    private static final AtomicBoolean awW = new AtomicBoolean();
    private static final AtomicBoolean awX = new AtomicBoolean();
    private static boolean sGetOaidFail;

    /* renamed from: Et */
    private static String m26242Et() {
        if (awX.getAndSet(true)) {
            return awV;
        }
        String m23572j = C11137y.m23572j("ksadsdk_pref", "kasd_oaid_key", "");
        awV = m23572j;
        return m23572j;
    }

    /* renamed from: Eu */
    static /* synthetic */ String m26241Eu() {
        return m26242Et();
    }

    /* renamed from: Ev */
    static /* synthetic */ void m26240Ev() {
    }

    /* renamed from: bc */
    public static String m26238bc(Context context) {
        if (C11028au.m24068Mo() && !TextUtils.isEmpty(C11028au.m24067Mp())) {
            return C11028au.m24067Mp();
        }
        if (!TextUtils.isEmpty(awV)) {
            return awV;
        }
        if (!C11028au.m24068Mo() && C11120o.m23760Lk()) {
            initAsync(context);
            return awV;
        }
        String m26242Et = m26242Et();
        awV = m26242Et;
        return m26242Et;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bd */
    public static void m26237bd(Context context) {
        if (!TextUtils.isEmpty(awV) || context == null || sGetOaidFail) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals("LENOVO")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        c = 2;
                        break;
                    }
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        c = 4;
                        break;
                    }
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        c = 11;
                        break;
                    }
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2634924:
                    if (upperCase.equals("VIVO")) {
                        c = 5;
                        break;
                    }
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        c = 7;
                        break;
                    }
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    awV = new C10349b(origApplicationContext).getOAID();
                    break;
                case 1:
                case 2:
                    awV = new C10360i(origApplicationContext).getOAID();
                    break;
                case 3:
                case 4:
                    awV = new C10355f(origApplicationContext).getOAID();
                    break;
                case 5:
                    awV = new C10359h(origApplicationContext).getOAID();
                    break;
                case 6:
                case 7:
                    awV = new C10351c(origApplicationContext).getOAID();
                    break;
                case '\b':
                    awV = new C10353d(origApplicationContext).getOAID();
                    break;
                case '\t':
                    awV = new C10354e(origApplicationContext).getOAID();
                    break;
                case '\n':
                    awV = new C10357g(origApplicationContext).getOAID();
                    break;
                case 11:
                    awV = new C10347a(origApplicationContext).getOAID();
                    break;
                case '\f':
                case '\r':
                case 14:
                    awV = new C10361j(origApplicationContext).getOAID();
                    break;
            }
            C10331c.m26248i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + awV);
            if (TextUtils.isEmpty(awV)) {
                sGetOaidFail = true;
            }
            m26235ej(awV);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ej */
    public static void m26235ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C11137y.m23573i("ksadsdk_pref", "kasd_oaid_key", str);
    }

    private static void initAsync(final Context context) {
        if (context == null || awW.getAndSet(true)) {
            return;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.f.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                String unused = C10343a.awV = C10343a.m26241Eu();
                if (TextUtils.isEmpty(C10343a.awV)) {
                    C10343a.m26237bd(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.InterfaceC10889a() { // from class: com.kwad.sdk.core.f.a.1.1
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper.InterfaceC10889a
                            /* renamed from: em */
                            public final void mo24548em(String str) {
                                String unused2 = C10343a.awV = str;
                                C10343a.m26235ej(str);
                                C10343a.m26240Ev();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.InterfaceC10891a() { // from class: com.kwad.sdk.core.f.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.InterfaceC10891a
                            /* renamed from: em */
                            public final void mo24547em(String str) {
                                String unused2 = C10343a.awV = str;
                                C10343a.m26235ej(str);
                                C10343a.m26240Ev();
                            }
                        });
                    }
                    C10343a.awW.set(false);
                }
            }
        });
    }
}
