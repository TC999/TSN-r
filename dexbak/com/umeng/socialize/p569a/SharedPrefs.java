package com.umeng.socialize.p569a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.utils.ContextUtil;

/* renamed from: com.umeng.socialize.a.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SharedPrefs {

    /* renamed from: a */
    private static final String f39302a = "Prefs";

    /* renamed from: c */
    private static volatile SharedPrefs f39303c;

    /* renamed from: b */
    private final Context f39304b;

    /* renamed from: d */
    private final C13310a f39305d = new C13310a("AZX");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SharedPrefs.java */
    /* renamed from: com.umeng.socialize.a.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13310a {

        /* renamed from: b */
        private final String f39307b;

        public C13310a(String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f39307b = str;
        }

        /* renamed from: b */
        private String m13399b(String str) {
            return this.f39307b + str;
        }

        /* renamed from: c */
        private String m13392c(String str, String str2) {
            try {
                if (C13308c.m13425a(ContextUtil.getContext())) {
                    return DataStore.m13432a().m13427b(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str2;
        }

        /* renamed from: d */
        private void m13391d(String str, String str2) {
            try {
                if (C13308c.m13425a(ContextUtil.getContext())) {
                    DataStore.m13432a().m13430a(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public void m13403a(String str, int i) {
            m13391d(m13399b(str), String.valueOf(i));
        }

        /* renamed from: a */
        public void m13402a(String str, long j) {
            m13391d(m13399b(str), String.valueOf(j));
        }

        /* renamed from: b */
        public int m13397b(String str, int i) {
            try {
                return Integer.parseInt(m13392c(m13399b(str), String.valueOf(i)));
            } catch (Exception unused) {
                return i;
            }
        }

        /* renamed from: a */
        public void m13404a(String str, float f) {
            m13391d(m13399b(str), String.valueOf(f));
        }

        /* renamed from: a */
        public void m13401a(String str, String str2) {
            m13391d(m13399b(str), String.valueOf(str2));
        }

        /* renamed from: b */
        public long m13396b(String str, long j) {
            try {
                return Long.parseLong(m13392c(m13399b(str), String.valueOf(j)));
            } catch (Exception unused) {
                return j;
            }
        }

        /* renamed from: a */
        public void m13400a(String str, boolean z) {
            m13391d(m13399b(str), String.valueOf(z));
        }

        /* renamed from: c */
        private void m13393c(String str) {
            try {
                if (C13308c.m13425a(ContextUtil.getContext())) {
                    DataStore.m13432a().m13431a(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* renamed from: a */
        public void m13405a(String str) {
            m13393c(m13399b(str));
        }

        /* renamed from: b */
        public float m13398b(String str, float f) {
            try {
                return Float.parseFloat(m13392c(m13399b(str), String.valueOf(f)));
            } catch (Exception unused) {
                return f;
            }
        }

        /* renamed from: b */
        public boolean m13394b(String str, boolean z) {
            try {
                return Boolean.parseBoolean(m13392c(m13399b(str), String.valueOf(z)));
            } catch (Exception unused) {
                return z;
            }
        }

        /* renamed from: b */
        public String m13395b(String str, String str2) {
            return m13392c(m13399b(str), str2);
        }
    }

    private SharedPrefs(Context context) {
        this.f39304b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    public static SharedPrefs m13413a(Context context) {
        if (f39303c == null) {
            synchronized (SharedPrefs.class) {
                if (f39303c == null) {
                    f39303c = new SharedPrefs(context);
                }
            }
        }
        return f39303c;
    }

    /* renamed from: b */
    public boolean m13410b() {
        return m13412a(AzxConstant.f39294e);
    }

    /* renamed from: c */
    public int m13408c() {
        return this.f39305d.m13397b(AzxConstant.f39295f, 0);
    }

    /* renamed from: d */
    public long m13407d() {
        return this.f39305d.m13396b(AzxConstant.f39293d, 0L);
    }

    /* renamed from: e */
    public void m13406e() {
        if (C13308c.m13425a(this.f39304b)) {
            this.f39305d.m13402a(AzxConstant.f39293d, m13407d() + 1);
        }
    }

    /* renamed from: b */
    private void m13409b(String str) {
        C13310a c13310a = this.f39305d;
        c13310a.m13405a(str + UMCommonContent.f37794aX);
        C13310a c13310a2 = this.f39305d;
        c13310a2.m13405a(str + "ts");
    }

    /* renamed from: a */
    public void m13414a(long j) {
        m13411a(AzxConstant.f39294e, j);
    }

    /* renamed from: a */
    public long m13416a() {
        return this.f39305d.m13396b("smart_ts", 0L);
    }

    /* renamed from: a */
    public void m13415a(int i) {
        this.f39305d.m13403a(AzxConstant.f39295f, i);
    }

    /* renamed from: a */
    private void m13411a(String str, long j) {
        C13310a c13310a = this.f39305d;
        c13310a.m13402a(str + UMCommonContent.f37794aX, j);
        C13310a c13310a2 = this.f39305d;
        c13310a2.m13402a(str + "ts", System.currentTimeMillis());
    }

    /* renamed from: a */
    private boolean m13412a(String str) {
        C13310a c13310a = this.f39305d;
        long m13396b = c13310a.m13396b(str + UMCommonContent.f37794aX, 0L);
        if (m13396b > 0) {
            C13310a c13310a2 = this.f39305d;
            long abs = Math.abs(System.currentTimeMillis() - c13310a2.m13396b(str + "ts", 0L)) / 1000;
            boolean z = abs >= m13396b;
            if (!z && AzxConstant.f39292c) {
                UPLog.m13366a(f39302a, "interval deny ", str, " config:", Long.valueOf(m13396b), " current:", Long.valueOf(abs));
            }
            return z;
        }
        return true;
    }
}
