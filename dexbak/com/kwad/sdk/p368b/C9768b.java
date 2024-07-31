package com.kwad.sdk.p368b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.graphics.C0262a;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10964b;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9768b {
    private static final Map<String, String> ano = new HashMap();
    private final AtomicBoolean anp;
    private final AtomicBoolean anq;
    private final AtomicBoolean anr;
    private final List<String> ans;
    private final List<String> ant;
    private final BroadcastReceiver anu;
    private Context mContext;
    private final List<InterfaceC9767a> mListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9773a {
        private static final C9768b anw = new C9768b((byte) 0);
    }

    /* synthetic */ C9768b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public static void m27831A(Context context, @NonNull String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                ((InterfaceC10964b) ServiceProvider.get(InterfaceC10964b.class)).mo24351e(InstalledAppInfoManager.m24279a(InstalledAppInfoManager.m24280a(packageInfo, packageManager)), 1);
            }
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    /* renamed from: Ao */
    public static C9768b m27830Ao() {
        return C9773a.anw;
    }

    /* renamed from: Ap */
    private void m27829Ap() {
        C10232b.m26625DD();
        C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.b.b.1
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    C9768b.this.m27827Ar();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    C9768b.this.m27828Aq();
                    C9768b.this.m27826As();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Aq */
    public void m27828Aq() {
        Context m24363KO = ServiceProvider.m24363KO();
        m27818aH(m24363KO);
        for (AdTemplate adTemplate : ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24333yv()) {
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            int m25855by = C10483a.m25855by(m25641dQ);
            String m25911ay = C10483a.m25911ay(m25641dQ);
            if (m25855by != 12) {
                if (C11017ak.m24114an(m24363KO, m25911ay)) {
                    m27803y(m24363KO, m25911ay);
                }
            } else if (!C11017ak.m24114an(m24363KO, m25911ay)) {
                m27812ck(m25911ay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ar */
    public void m27827Ar() {
        if (this.anr.get()) {
            ServiceProvider.m24363KO().unregisterReceiver(this.anu);
            this.anr.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: As */
    public void m27826As() {
        if (this.anr.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.m24363KO().registerReceiver(this.anu, intentFilter);
        this.anr.set(true);
    }

    /* renamed from: B */
    private static void m27825B(Context context, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    c = 0;
                    break;
                }
                break;
            case 473713875:
                if (str.equals("com.kuaishou.nebula")) {
                    c = 1;
                    break;
                }
                break;
            case 1659293491:
                if (str.equals("com.smile.gifmaker")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ano.put("com.tencent.mm", C11102k.m23781M(context, "com.tencent.mm"));
                return;
            case 1:
                ano.put("com.kuaishou.nebula", C11102k.m23781M(context, "com.kuaishou.nebula"));
                return;
            case 2:
                ano.put("com.smile.gifmaker", C11102k.m23781M(context, "com.smile.gifmaker"));
                return;
            default:
                return;
        }
    }

    /* renamed from: aG */
    private synchronized void m27819aG(Context context) {
        if (this.anp.get()) {
            return;
        }
        m27825B(context, "com.smile.gifmaker");
        m27825B(context, "com.kuaishou.nebula");
        m27825B(context, "com.tencent.mm");
        this.anp.set(true);
    }

    /* renamed from: aH */
    private void m27818aH(Context context) {
        if (this.anp.get()) {
            for (String str : ano.keySet()) {
                String str2 = ano.get(str);
                String m23781M = C11102k.m23781M(context, str);
                if (!TextUtils.isEmpty(m23781M) && !C0262a.m60024a(str2, m23781M)) {
                    m27803y(context, str);
                } else if (TextUtils.isEmpty(m23781M) && !TextUtils.isEmpty(str2)) {
                    m27812ck(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ck */
    public void m27812ck(@NonNull String str) {
        C10331c.m26254d("AppInstallManager", "unInstallApp packageName: " + str);
        m27807cp(str);
        m27808co(str);
        m27811cl(str);
    }

    /* renamed from: cl */
    private void m27811cl(String str) {
        C10232b.m26625DD();
        if (C10232b.isAppOnForeground()) {
            m27810cm(str);
            return;
        }
        this.ant.add(str);
        C10232b.m26625DD();
        C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.b.b.4
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToForeground() {
                if (C9768b.this.ant.size() > 0) {
                    for (int i = 0; i < C9768b.this.ant.size(); i++) {
                        C9768b.m27810cm((String) C9768b.this.ant.get(i));
                    }
                    C9768b.this.ant.clear();
                }
                C10232b.m26625DD();
                C10232b.m26621b((InterfaceC10246c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cm */
    public static void m27810cm(@NonNull String str) {
        try {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = str;
            ((InterfaceC10964b) ServiceProvider.get(InterfaceC10964b.class)).mo24351e(InstalledAppInfoManager.m24279a(appPackageInfo), 2);
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    /* renamed from: cn */
    private void m27809cn(String str) {
        for (InterfaceC9767a interfaceC9767a : this.mListeners) {
            try {
                interfaceC9767a.mo26320N(str);
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
        }
    }

    /* renamed from: co */
    private void m27808co(String str) {
        for (InterfaceC9767a interfaceC9767a : this.mListeners) {
            try {
                interfaceC9767a.mo26319O(str);
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
        }
    }

    /* renamed from: cp */
    private static void m27807cp(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    c = 0;
                    break;
                }
                break;
            case 473713875:
                if (str.equals("com.kuaishou.nebula")) {
                    c = 1;
                    break;
                }
                break;
            case 1659293491:
                if (str.equals("com.smile.gifmaker")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ano.put("com.tencent.mm", "");
                return;
            case 1:
                ano.put("com.kuaishou.nebula", "");
                return;
            case 2:
                ano.put("com.smile.gifmaker", "");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m27803y(Context context, @NonNull String str) {
        C10331c.m26254d("AppInstallManager", "installApp packageName: " + str);
        m27825B(context, str);
        m27809cn(str);
        m27802z(context, str);
    }

    /* renamed from: z */
    private void m27802z(Context context, String str) {
        C10232b.m26625DD();
        if (C10232b.isAppOnForeground()) {
            m27831A(context, str);
            return;
        }
        this.ans.add(str);
        C10232b.m26625DD();
        C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.b.b.3
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            public final void onBackToForeground() {
                if (C9768b.this.ans.size() > 0) {
                    for (int i = 0; i < C9768b.this.ans.size(); i++) {
                        C9768b.m27831A(C9768b.this.mContext, (String) C9768b.this.ans.get(i));
                    }
                    C9768b.this.ans.clear();
                }
                C10232b.m26625DD();
                C10232b.m26621b((InterfaceC10246c) this);
            }
        });
    }

    public final synchronized void checkInit() {
        try {
            if (this.anq.get()) {
                return;
            }
            if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24300yX()) {
                C10232b.m26625DD();
                if (C10232b.isAppOnForeground()) {
                    m27826As();
                }
                m27829Ap();
            } else {
                m27826As();
            }
            this.anq.set(true);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        m27819aG(context);
        return ano.get(str);
    }

    private C9768b() {
        this.anp = new AtomicBoolean();
        this.anq = new AtomicBoolean();
        this.anr = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.ans = new CopyOnWriteArrayList();
        this.ant = new CopyOnWriteArrayList();
        this.anu = new BroadcastReceiver() { // from class: com.kwad.sdk.b.b.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    C9768b.this.mContext = context;
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        C9768b.this.m27803y(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        C9768b.this.m27812ck(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        };
    }

    /* renamed from: b */
    public final void m27817b(InterfaceC9767a interfaceC9767a) {
        if (interfaceC9767a == null) {
            return;
        }
        checkInit();
        this.mListeners.remove(interfaceC9767a);
    }

    /* renamed from: a */
    public final void m27824a(InterfaceC9767a interfaceC9767a) {
        if (interfaceC9767a == null) {
            return;
        }
        checkInit();
        this.mListeners.add(interfaceC9767a);
    }
}
