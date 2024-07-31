package com.kwad.components.core.p330s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.config.item.C10269o;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwad.components.core.s.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8950m {
    public static final String TAG = "m";

    /* renamed from: Tl */
    private static final String f28866Tl = "com.kwad.components.core.s.m";

    /* renamed from: Tm */
    private static volatile C8950m f28867Tm;

    /* renamed from: Tn */
    private boolean f28868Tn = false;

    /* renamed from: To */
    private C10269o.C10270a f28869To;

    private C8950m() {
    }

    /* renamed from: I */
    private static void m29541I(long j) {
        String str = TAG;
        C10331c.m26254d(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    /* renamed from: aA */
    private static boolean m29536aA(String str) {
        return (str.startsWith(FaceEnvironment.f8430OS) || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) || str.contains(f28866Tl) || !str.startsWith("androidx")) ? false : true;
    }

    /* renamed from: aB */
    private static boolean m29535aB(String str) {
        return !str.startsWith("com.kwad");
    }

    /* renamed from: aC */
    private static boolean m29534aC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: re */
    public static C8950m m29533re() {
        if (f28867Tm == null) {
            synchronized (C8950m.class) {
                if (f28867Tm == null) {
                    f28867Tm = new C8950m();
                }
            }
        }
        return f28867Tm;
    }

    /* renamed from: rg */
    private void m29531rg() {
        C10269o.C10270a c10270a = this.f28869To;
        if (c10270a == null) {
            return;
        }
        if (!this.f28868Tn && c10270a.atw.size() > 0) {
            for (String str : this.f28869To.atw) {
                boolean m29534aC = m29534aC(str);
                this.f28868Tn = m29534aC;
                if (m29534aC) {
                    break;
                }
            }
        }
        if (this.f28868Tn) {
            ArrayList arrayList = new ArrayList();
            if (this.f28869To.att.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.f28869To.att.entrySet()) {
                    if (m29534aC(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            C10269o.C10270a c10270a2 = this.f28869To;
            C8766a.m29888qi().m29911a(m29538a(c10270a2.atu, c10270a2.atv), arrayList);
        }
    }

    /* renamed from: a */
    public final boolean m29540a(SceneImpl sceneImpl, String str) {
        boolean z;
        if (this.f28868Tn) {
            C10269o.C10270a c10270a = this.f28869To;
            z = m29538a(c10270a.atu, c10270a.atv);
        } else {
            z = false;
        }
        C8766a.m29888qi().m29912a(sceneImpl, z, str);
        return z;
    }

    public final void init() {
        C10269o.C10270a c10270a = (C10269o.C10270a) C10251d.m26520b(C10250c.ari);
        this.f28869To = c10270a;
        if (c10270a != null) {
            m29531rg();
        }
    }

    /* renamed from: rf */
    public final int m29532rf() {
        C10269o.C10270a c10270a = this.f28869To;
        if (c10270a != null) {
            return c10270a.atx;
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m29538a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                for (String str : list) {
                    if (className.contains(str)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return m29537a(list2, stackTrace);
    }

    /* renamed from: a */
    private boolean m29537a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C10331c.m26254d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && m29536aA(className) && m29535aB(className)) {
                    try {
                        if (m29539a(list, Class.forName(className).getSuperclass())) {
                            m29541I(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && m29539a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            m29541I(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            m29541I(elapsedRealtime);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m29539a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            for (String str : list) {
                if (cls.getName().contains(str)) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }
}
