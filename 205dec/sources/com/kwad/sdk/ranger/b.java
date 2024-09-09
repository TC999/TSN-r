package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.ranger.a.a;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private String value;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final b aNj = new b((byte) 0);
    }

    /* synthetic */ b(byte b4) {
        this();
    }

    public static b KA() {
        return a.aNj;
    }

    static /* synthetic */ com.kwad.sdk.ranger.b.a.c a(b bVar, String str, String str2) {
        return an(str, str2);
    }

    @Nullable
    private static com.kwad.sdk.ranger.b.a.c an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.ranger.b.a.c cVar = new com.kwad.sdk.ranger.b.a.c();
        cVar.name = str;
        cVar.aNO = str2;
        return cVar;
    }

    private static Object c(com.kwad.sdk.ranger.a.a aVar) {
        if (aVar.aNz) {
            try {
                return s.c(Class.forName(aVar.aNx), aVar.aNy);
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.w(TAG, Log.getStackTraceString(e4));
            }
        } else {
            Object obj = aVar.aNw;
            if (obj != null) {
                return s.getField(obj, aVar.aNy);
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

    public final void b(c cVar) {
        List<com.kwad.sdk.ranger.a.a> list;
        if (cVar == null || (list = cVar.aNm) == null || list.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.ranger.a.a> list2 = cVar.aNm;
        g.schedule(new ay() { // from class: com.kwad.sdk.ranger.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.ranger.a.a aVar : list2) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.aNA)) {
                        String str = aVar.aNA;
                        b.this.a(aVar);
                        b bVar = b.this;
                        com.kwad.sdk.ranger.b.a.c a4 = b.a(bVar, str, bVar.value);
                        if (a4 != null) {
                            arrayList.add(a4);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.ranger.b.a.d dVar = new com.kwad.sdk.ranger.b.a.d();
                dVar.aNP = arrayList;
                com.kwad.sdk.ranger.b.a.a(dVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.ranger.a.a aVar) {
        com.kwad.sdk.ranger.a.a aVar2 = aVar.aNC;
        if (aVar2 != null && !aVar2.KF()) {
            if (!TextUtils.isEmpty(aVar.aNy)) {
                aVar.aNC.aNw = c(aVar);
            } else {
                a.b bVar = aVar.aNB;
                if (bVar != null && !bVar.KF()) {
                    aVar.aNC.aNw = b(aVar);
                }
            }
            a(aVar.aNC);
        } else if (!TextUtils.isEmpty(aVar.aNy)) {
            l(c(aVar));
        } else {
            a.b bVar2 = aVar.aNB;
            if (bVar2 != null && !bVar2.KF()) {
                l(b(aVar));
                return;
            }
            String str = TAG;
            com.kwad.sdk.core.e.c.d(str, "node.nodeClassName:" + aVar.aNx);
            this.value = s.classExists(aVar.aNx) ? "true" : "false";
        }
    }

    private Object b(com.kwad.sdk.ranger.a.a aVar) {
        Class<?> cls;
        if (aVar.aNB.aNK) {
            try {
                if (!TextUtils.isEmpty(aVar.aNx)) {
                    cls = Class.forName(aVar.aNx);
                } else {
                    Object obj = aVar.aNw;
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
        } else if (aVar.aNw != null) {
            return a(aVar, false, (Class<?>) null);
        } else {
            return null;
        }
    }

    private static Object a(com.kwad.sdk.ranger.a.a aVar, boolean z3, Class<?> cls) {
        Object[] KI = aVar.aNB.KI();
        if (KI == null || KI.length == 0) {
            if (z3) {
                return s.callStaticMethod(cls, aVar.aNB.name, new Object[0]);
            }
            return s.callMethod(aVar.aNw, aVar.aNB.name, new Object[0]);
        } else if (z3) {
            return s.callStaticMethod(cls, aVar.aNB.name, KI);
        } else {
            return s.callMethod(aVar.aNw, aVar.aNB.name, KI);
        }
    }
}
