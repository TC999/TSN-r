package com.kwad.components.core.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.internal.api.SceneImpl;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class m {
    public static final String TAG = "m";
    private static final String Tl = "com.kwad.components.core.s.m";
    private static volatile m Tm;
    private boolean Tn = false;
    private o.a To;

    private m() {
    }

    private static void I(long j4) {
        String str = TAG;
        com.kwad.sdk.core.e.c.d(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j4));
    }

    private static boolean aA(String str) {
        return (str.startsWith("android") || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) || str.contains(Tl) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aB(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aC(String str) {
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

    public static m re() {
        if (Tm == null) {
            synchronized (m.class) {
                if (Tm == null) {
                    Tm = new m();
                }
            }
        }
        return Tm;
    }

    private void rg() {
        o.a aVar = this.To;
        if (aVar == null) {
            return;
        }
        if (!this.Tn && aVar.atw.size() > 0) {
            for (String str : this.To.atw) {
                boolean aC = aC(str);
                this.Tn = aC;
                if (aC) {
                    break;
                }
            }
        }
        if (this.Tn) {
            ArrayList arrayList = new ArrayList();
            if (this.To.att.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.To.att.entrySet()) {
                    if (aC(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            o.a aVar2 = this.To;
            com.kwad.components.core.o.a.qi().a(a(aVar2.atu, aVar2.atv), arrayList);
        }
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean z3;
        if (this.Tn) {
            o.a aVar = this.To;
            z3 = a(aVar.atu, aVar.atv);
        } else {
            z3 = false;
        }
        com.kwad.components.core.o.a.qi().a(sceneImpl, z3, str);
        return z3;
    }

    public final void init() {
        o.a aVar = (o.a) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.ari);
        this.To = aVar;
        if (aVar != null) {
            rg();
        }
    }

    public final int rf() {
        o.a aVar = this.To;
        if (aVar != null) {
            return aVar.atx;
        }
        return 0;
    }

    private boolean a(List<String> list, List<String> list2) {
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
        return a(list2, stackTrace);
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.e.c.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aA(className) && aB(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            I(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            I(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            I(elapsedRealtime);
        }
        return false;
    }

    private static boolean a(List<String> list, Class cls) {
        int i4 = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            for (String str : list) {
                if (cls.getName().contains(str)) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i4++;
            if (i4 >= 4) {
                break;
            }
        }
        return false;
    }
}
