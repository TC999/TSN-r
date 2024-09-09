package com.kwad.sdk.e;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class b implements a {
    private static volatile b aJi;
    private static c aJj;

    private b() {
    }

    public static synchronized b Jd() {
        b bVar;
        synchronized (b.class) {
            if (aJi == null) {
                synchronized (b.class) {
                    if (aJi == null) {
                        aJi = new b();
                    }
                }
            }
            bVar = aJi;
        }
        return bVar;
    }

    private static String Je() {
        return a(false, (Object) "", 2);
    }

    public static void a(c cVar) {
        aJj = cVar;
    }

    public final String IR() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IR();
        }
        return Je();
    }

    public final String IS() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IS();
        }
        return Je();
    }

    public final String IT() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IT();
        }
        return Je();
    }

    public final String IU() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IU();
        }
        return Je();
    }

    public final String IV() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IV();
        }
        return Je();
    }

    public final String IW() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IW();
        }
        return Je();
    }

    public final String IX() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IX();
        }
        return Je();
    }

    public final String IY() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IY();
        }
        return Je();
    }

    public final String IZ() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.IZ();
        }
        return Je();
    }

    public final String Ja() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.Ja();
        }
        return Je();
    }

    public final String Jb() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.Jb();
        }
        return Je();
    }

    public final String Jc() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.Jc();
        }
        return Je();
    }

    public final String getAppId() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return Je();
    }

    public final String getDeviceId() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return Je();
    }

    public final String getIccId() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return Je();
    }

    public final String getIp() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getIp();
        }
        return Je();
    }

    public final String getLocation() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return Je();
    }

    public final String getOaid() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return Je();
    }

    public final String getSdkVersion() {
        c cVar = aJj;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return Je();
    }

    public static String a(boolean z3, Object obj, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z3));
        hashMap.put("value", obj);
        hashMap.put("errorCode", String.valueOf(i4));
        return new JSONObject(hashMap).toString();
    }
}
