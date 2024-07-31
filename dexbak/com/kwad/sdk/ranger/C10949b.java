package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.ranger.p446a.C10946a;
import com.kwad.sdk.ranger.p447b.C10952a;
import com.kwad.sdk.ranger.p447b.p448a.C10955c;
import com.kwad.sdk.ranger.p447b.p448a.C10956d;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11124s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.ranger.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10949b {
    public static final String TAG = "Ranger_" + C10949b.class.getSimpleName();
    private String value;

    /* renamed from: com.kwad.sdk.ranger.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10951a {
        private static final C10949b aNj = new C10949b((byte) 0);
    }

    /* synthetic */ C10949b(byte b) {
        this();
    }

    /* renamed from: KA */
    public static C10949b m24386KA() {
        return C10951a.aNj;
    }

    /* renamed from: a */
    static /* synthetic */ C10955c m24381a(C10949b c10949b, String str, String str2) {
        return m24380an(str, str2);
    }

    @Nullable
    /* renamed from: an */
    private static C10955c m24380an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        C10955c c10955c = new C10955c();
        c10955c.name = str;
        c10955c.aNO = str2;
        return c10955c;
    }

    /* renamed from: c */
    private static Object m24377c(C10946a c10946a) {
        if (c10946a.aNz) {
            try {
                return C11124s.m23696c(Class.forName(c10946a.aNx), c10946a.aNy);
            } catch (Exception e) {
                C10331c.m26246w(TAG, Log.getStackTraceString(e));
            }
        } else {
            Object obj = c10946a.aNw;
            if (obj != null) {
                return C11124s.getField(obj, c10946a.aNy);
            }
        }
        return null;
    }

    /* renamed from: l */
    private void m24376l(Object obj) {
        if (obj != null) {
            this.value = String.valueOf(obj);
            return;
        }
        C10331c.m26246w(TAG, "value is null by ob null");
        this.value = "";
    }

    /* renamed from: b */
    public final void m24378b(C10957c c10957c) {
        List<C10946a> list;
        if (c10957c == null || (list = c10957c.aNm) == null || list.isEmpty()) {
            return;
        }
        final List<C10946a> list2 = c10957c.aNm;
        C11095g.schedule(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.ranger.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (C10946a c10946a : list2) {
                    if (c10946a != null && !TextUtils.isEmpty(c10946a.aNA)) {
                        String str = c10946a.aNA;
                        C10949b.this.m24385a(c10946a);
                        C10949b c10949b = C10949b.this;
                        C10955c m24381a = C10949b.m24381a(c10949b, str, c10949b.value);
                        if (m24381a != null) {
                            arrayList.add(m24381a);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                C10956d c10956d = new C10956d();
                c10956d.aNP = arrayList;
                C10952a.m24374a(c10956d);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private C10949b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m24385a(C10946a c10946a) {
        C10946a c10946a2 = c10946a.aNC;
        if (c10946a2 != null && !c10946a2.m24392KF()) {
            if (!TextUtils.isEmpty(c10946a.aNy)) {
                c10946a.aNC.aNw = m24377c(c10946a);
            } else {
                C10946a.C10948b c10948b = c10946a.aNB;
                if (c10948b != null && !c10948b.m24388KF()) {
                    c10946a.aNC.aNw = m24379b(c10946a);
                }
            }
            m24385a(c10946a.aNC);
        } else if (!TextUtils.isEmpty(c10946a.aNy)) {
            m24376l(m24377c(c10946a));
        } else {
            C10946a.C10948b c10948b2 = c10946a.aNB;
            if (c10948b2 != null && !c10948b2.m24388KF()) {
                m24376l(m24379b(c10946a));
                return;
            }
            String str = TAG;
            C10331c.m26254d(str, "node.nodeClassName:" + c10946a.aNx);
            this.value = C11124s.classExists(c10946a.aNx) ? "true" : "false";
        }
    }

    /* renamed from: b */
    private Object m24379b(C10946a c10946a) {
        Class<?> cls;
        if (c10946a.aNB.aNK) {
            try {
                if (!TextUtils.isEmpty(c10946a.aNx)) {
                    cls = Class.forName(c10946a.aNx);
                } else {
                    Object obj = c10946a.aNw;
                    cls = obj != null ? obj.getClass() : null;
                }
                if (cls != null) {
                    return m24384a(c10946a, true, cls);
                }
                return null;
            } catch (Exception e) {
                C10331c.m26246w(TAG, Log.getStackTraceString(e));
                return null;
            }
        } else if (c10946a.aNw != null) {
            return m24384a(c10946a, false, (Class<?>) null);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private static Object m24384a(C10946a c10946a, boolean z, Class<?> cls) {
        Object[] m24387KI = c10946a.aNB.m24387KI();
        if (m24387KI == null || m24387KI.length == 0) {
            if (z) {
                return C11124s.callStaticMethod(cls, c10946a.aNB.name, new Object[0]);
            }
            return C11124s.callMethod(c10946a.aNw, c10946a.aNB.name, new Object[0]);
        } else if (z) {
            return C11124s.callStaticMethod(cls, c10946a.aNB.name, m24387KI);
        } else {
            return C11124s.callMethod(c10946a.aNw, c10946a.aNB.name, m24387KI);
        }
    }
}
