package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.m.a.a;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private String value;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class a {
        private static final b aOq = new b((byte) 0);
    }

    /* synthetic */ b(byte b4) {
        this();
    }

    public static b Li() {
        return a.aOq;
    }

    static /* synthetic */ com.kwad.sdk.m.b.a.c a(b bVar, String str, String str2) {
        return am(str, str2);
    }

    @Nullable
    private static com.kwad.sdk.m.b.a.c am(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.m.b.a.c cVar = new com.kwad.sdk.m.b.a.c();
        cVar.name = str;
        cVar.aOR = str2;
        return cVar;
    }

    private static Object c(com.kwad.sdk.m.a.a aVar) {
        if (aVar.aOC) {
            try {
                return s.c(Class.forName(aVar.aOA), aVar.aOB);
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e4));
            }
        } else {
            Object obj = aVar.aOz;
            if (obj != null) {
                return s.getField(obj, aVar.aOB);
            }
        }
        return null;
    }

    private void l(Object obj) {
        if (obj != null) {
            this.value = String.valueOf(obj);
            return;
        }
        com.kwad.sdk.core.e.c.w(TAG, "value is null by ob null");
        this.value = "";
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.kwad.sdk.m.b$1, java.lang.Runnable] */
    public final void b(c cVar) {
        List<com.kwad.sdk.m.a.a> list;
        if (cVar == null || (list = cVar.aOt) == null || list.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.m.a.a> list2 = cVar.aOt;
        g.schedule(new az() { // from class: com.kwad.sdk.m.b.1
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.m.a.a aVar : list2) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.aOD)) {
                        String str = aVar.aOD;
                        b.this.a(aVar);
                        b bVar = b.this;
                        com.kwad.sdk.m.b.a.c a4 = b.a(bVar, str, bVar.value);
                        if (a4 != null) {
                            arrayList.add(a4);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.m.b.a.d dVar = new com.kwad.sdk.m.b.a.d();
                dVar.aOS = arrayList;
                com.kwad.sdk.m.b.a.a(dVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.m.a.a aVar) {
        com.kwad.sdk.m.a.a aVar2 = aVar.aOF;
        if (aVar2 != null && !aVar2.Ln()) {
            if (!TextUtils.isEmpty(aVar.aOB)) {
                aVar.aOF.aOz = c(aVar);
            } else {
                a.b bVar = aVar.aOE;
                if (bVar != null && !bVar.Ln()) {
                    aVar.aOF.aOz = b(aVar);
                }
            }
            a(aVar.aOF);
        } else if (!TextUtils.isEmpty(aVar.aOB)) {
            l(c(aVar));
        } else {
            a.b bVar2 = aVar.aOE;
            if (bVar2 != null && !bVar2.Ln()) {
                l(b(aVar));
                return;
            }
            String str = TAG;
            com.kwad.sdk.core.e.c.d(str, "node.nodeClassName:" + aVar.aOA);
            this.value = s.classExists(aVar.aOA) ? "true" : "false";
        }
    }

    private Object b(com.kwad.sdk.m.a.a aVar) {
        Class<?> cls;
        if (aVar.aOE.aON) {
            try {
                if (!TextUtils.isEmpty(aVar.aOA)) {
                    cls = Class.forName(aVar.aOA);
                } else {
                    Object obj = aVar.aOz;
                    cls = obj != null ? obj.getClass() : null;
                }
                if (cls != null) {
                    return a(aVar, true, cls);
                }
                return null;
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e4));
                return null;
            }
        } else if (aVar.aOz != null) {
            return a(aVar, false, (Class<?>) null);
        } else {
            return null;
        }
    }

    private static Object a(com.kwad.sdk.m.a.a aVar, boolean z3, Class<?> cls) {
        Object[] Lq = aVar.aOE.Lq();
        if (Lq == null || Lq.length == 0) {
            if (z3) {
                return s.callStaticMethod(cls, aVar.aOE.name, new Object[0]);
            }
            return s.callMethod(aVar.aOz, aVar.aOE.name, new Object[0]);
        } else if (z3) {
            return s.callStaticMethod(cls, aVar.aOE.name, Lq);
        } else {
            return s.callMethod(aVar.aOz, aVar.aOE.name, Lq);
        }
    }
}
