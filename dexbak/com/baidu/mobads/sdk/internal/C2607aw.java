package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.http.HttpConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.aw */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2607aw {

    /* renamed from: a */
    public static final String f8630a = "bqt_ad_tag";

    /* renamed from: b */
    static volatile AbstractC2608a[] f8631b;

    /* renamed from: c */
    private static final AbstractC2608a[] f8632c;

    /* renamed from: d */
    private static final Map<String, AbstractC2608a> f8633d = new HashMap();

    /* renamed from: e */
    private static final AbstractC2608a f8634e = new C2609ax();

    /* renamed from: com.baidu.mobads.sdk.internal.aw$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC2608a {

        /* renamed from: a */
        private final ThreadLocal<String> f8635a = new ThreadLocal<>();

        /* renamed from: g */
        private String m50888g(Object[] objArr) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(HttpConstants.SP_CHAR);
            }
            return sb.toString();
        }

        @NonNull
        /* renamed from: a */
        abstract String mo50887a();

        /* renamed from: a */
        protected abstract void mo50885a(int i, String str, String str2, Throwable th);

        /* renamed from: a */
        protected boolean m50896a(int i) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo50892b() {
            String str = this.f8635a.get();
            if (str != null) {
                this.f8635a.remove();
            }
            return str;
        }

        /* renamed from: c */
        public void mo50872c(String str) {
            m50891b(3, null, str);
        }

        /* renamed from: d */
        public void mo50868d(String str) {
            m50891b(4, null, str);
        }

        /* renamed from: e */
        public void mo50864e(String str) {
            m50891b(5, null, str);
        }

        /* renamed from: f */
        public void mo50860f(String str) {
            m50891b(6, null, str);
        }

        /* renamed from: a */
        public void mo50880a(String str) {
            if (TextUtils.isEmpty(str)) {
                mo50872c("Empty/Null json content");
                return;
            }
            try {
                String trim = str.trim();
                if (trim.startsWith("{")) {
                    m50891b(3, null, new JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    m50891b(3, null, new JSONArray(trim).toString(2));
                } else {
                    mo50860f("Invalid Json");
                }
            } catch (Exception unused) {
                mo50860f("Invalid Json");
            }
        }

        /* renamed from: c */
        public void mo50869c(Object... objArr) {
            m50891b(4, null, m50888g(objArr));
        }

        /* renamed from: d */
        public void mo50866d(Throwable th, String str) {
            m50891b(5, th, str);
        }

        /* renamed from: e */
        public void mo50861e(Object... objArr) {
            m50891b(6, null, m50888g(objArr));
        }

        /* renamed from: f */
        public void mo50857f(Object... objArr) {
            m50891b(7, null, m50888g(objArr));
        }

        /* renamed from: b */
        protected String m50890b(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            return obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }

        /* renamed from: c */
        public void mo50870c(Throwable th, String str) {
            m50891b(4, th, str);
        }

        /* renamed from: d */
        public void mo50867d(Throwable th) {
            m50891b(5, th, null);
        }

        /* renamed from: e */
        public void mo50862e(Throwable th, String str) {
            m50891b(6, th, str);
        }

        /* renamed from: f */
        public void mo50858f(Throwable th, String str) {
            m50891b(7, th, str);
        }

        /* renamed from: c */
        public void mo50871c(Throwable th) {
            m50891b(4, th, null);
        }

        /* renamed from: d */
        public void mo50865d(Object... objArr) {
            m50891b(5, null, m50888g(objArr));
        }

        /* renamed from: e */
        public void mo50863e(Throwable th) {
            m50891b(6, th, null);
        }

        /* renamed from: f */
        public void mo50859f(Throwable th) {
            m50891b(7, th, null);
        }

        /* renamed from: g */
        public void mo50856g(String str) {
            m50891b(7, null, str);
        }

        /* renamed from: g */
        private String m50889g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        /* renamed from: a */
        public void mo50877a(Object... objArr) {
            m50891b(2, null, m50888g(objArr));
        }

        /* renamed from: a */
        public void mo50878a(Throwable th, String str) {
            m50891b(2, th, str);
        }

        /* renamed from: a */
        public void mo50879a(Throwable th) {
            m50891b(2, th, null);
        }

        /* renamed from: a */
        public void mo50881a(Object obj) {
            m50891b(3, null, m50890b(obj));
        }

        /* renamed from: a */
        public void mo50886a(int i, String str) {
            m50891b(i, null, str);
        }

        /* renamed from: a */
        public void mo50882a(int i, Object... objArr) {
            m50891b(i, null, m50888g(objArr));
        }

        /* renamed from: a */
        public void mo50883a(int i, Throwable th, String str) {
            m50891b(i, th, str);
        }

        /* renamed from: a */
        public void mo50884a(int i, Throwable th) {
            m50891b(i, th, null);
        }

        /* renamed from: a */
        protected boolean mo50894a(String str, int i) {
            return m50896a(i);
        }

        /* renamed from: b */
        public void mo50876b(String str) {
            m50891b(2, null, str);
        }

        /* renamed from: a */
        protected String m50893a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        /* renamed from: b */
        public void mo50874b(Throwable th, String str) {
            m50891b(3, th, str);
        }

        /* renamed from: b */
        public void mo50873b(Object... objArr) {
            m50891b(3, null, m50888g(objArr));
        }

        /* renamed from: b */
        public void mo50875b(Throwable th) {
            m50891b(3, th, null);
        }

        /* renamed from: b */
        private void m50891b(int i, Throwable th, String str) {
            String mo50892b = mo50892b();
            if (mo50894a(mo50892b, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th == null) {
                        return;
                    }
                    str = m50889g(th);
                } else if (th != null) {
                    str = str + ShellAdbUtils.f33810d + m50889g(th);
                }
                mo50885a(i, mo50892b, str, th);
            }
        }
    }

    static {
        AbstractC2608a[] abstractC2608aArr = new AbstractC2608a[0];
        f8632c = abstractC2608aArr;
        f8631b = abstractC2608aArr;
    }

    /* renamed from: a */
    public static void m50927a(boolean z) {
        try {
            m50937a();
            if (C2658ck.f8831a) {
                m50932a((AbstractC2608a) new C2605au());
            } else if (z) {
                m50932a((AbstractC2608a) new C2604at());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static void m50923b(String str) {
        f8634e.mo50876b(str);
    }

    /* renamed from: c */
    public static void m50918c(String str) {
        f8634e.mo50872c(str);
    }

    /* renamed from: d */
    public static void m50913d(String str) {
        f8634e.mo50868d(str);
    }

    /* renamed from: e */
    public static void m50908e(String str) {
        f8634e.mo50864e(str);
    }

    /* renamed from: f */
    public static void m50903f(String str) {
        f8634e.mo50860f(str);
    }

    /* renamed from: g */
    public static void m50899g(String str) {
        f8634e.mo50856g(str);
    }

    /* renamed from: h */
    public static AbstractC2608a m50898h(String str) {
        for (AbstractC2608a abstractC2608a : f8631b) {
            abstractC2608a.f8635a.set(str);
        }
        return f8634e;
    }

    /* renamed from: i */
    public static void m50897i(String str) {
        Map<String, AbstractC2608a> map = f8633d;
        synchronized (map) {
            if (map.remove(str) == null) {
                return;
            }
            f8631b = (AbstractC2608a[]) map.values().toArray(new AbstractC2608a[0]);
        }
    }

    /* renamed from: b */
    public static void m50920b(Object... objArr) {
        f8634e.mo50873b(objArr);
    }

    /* renamed from: c */
    public static void m50916c(Throwable th, String str) {
        f8634e.mo50870c(th, str);
    }

    /* renamed from: d */
    public static void m50911d(Throwable th, String str) {
        f8634e.mo50866d(th, str);
    }

    /* renamed from: e */
    public static void m50905e(Object... objArr) {
        f8634e.mo50861e(objArr);
    }

    /* renamed from: f */
    public static void m50900f(Object... objArr) {
        f8634e.mo50857f(objArr);
    }

    /* renamed from: b */
    public static void m50921b(Throwable th, String str) {
        f8634e.mo50874b(th, str);
    }

    /* renamed from: c */
    public static void m50915c(Object... objArr) {
        f8634e.mo50869c(objArr);
    }

    /* renamed from: d */
    public static void m50910d(Object... objArr) {
        f8634e.mo50865d(objArr);
    }

    /* renamed from: e */
    public static void m50906e(Throwable th, String str) {
        f8634e.mo50862e(th, str);
    }

    /* renamed from: f */
    public static void m50901f(Throwable th, String str) {
        f8634e.mo50858f(th, str);
    }

    /* renamed from: b */
    public static void m50922b(Throwable th) {
        f8634e.mo50875b(th);
    }

    /* renamed from: c */
    public static void m50917c(Throwable th) {
        f8634e.mo50871c(th);
    }

    /* renamed from: d */
    public static void m50912d(Throwable th) {
        f8634e.mo50867d(th);
    }

    /* renamed from: e */
    public static void m50907e(Throwable th) {
        f8634e.mo50863e(th);
    }

    /* renamed from: f */
    public static void m50902f(Throwable th) {
        f8634e.mo50859f(th);
    }

    /* renamed from: a */
    public static void m50937a() {
        try {
            m50897i("local");
            m50897i("debug");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static AbstractC2608a m50925b() {
        return f8634e;
    }

    /* renamed from: c */
    public static AbstractC2608a m50919c() {
        for (AbstractC2608a abstractC2608a : f8631b) {
            abstractC2608a.f8635a.set(f8630a);
        }
        return f8634e;
    }

    /* renamed from: d */
    public static void m50914d() {
        Map<String, AbstractC2608a> map = f8633d;
        synchronized (map) {
            map.clear();
            f8631b = f8632c;
        }
    }

    /* renamed from: e */
    public static List<AbstractC2608a> m50909e() {
        List<AbstractC2608a> unmodifiableList;
        Map<String, AbstractC2608a> map = f8633d;
        synchronized (map) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(map.values()));
        }
        return unmodifiableList;
    }

    /* renamed from: f */
    public static int m50904f() {
        int size;
        Map<String, AbstractC2608a> map = f8633d;
        synchronized (map) {
            size = map.size();
        }
        return size;
    }

    /* renamed from: b */
    public static void m50924b(AbstractC2608a abstractC2608a) {
        m50897i(abstractC2608a.mo50887a());
    }

    /* renamed from: a */
    public static void m50930a(String str) {
        f8634e.mo50880a(str);
    }

    /* renamed from: a */
    public static void m50926a(Object... objArr) {
        f8634e.mo50877a(objArr);
    }

    /* renamed from: a */
    public static void m50928a(Throwable th, String str) {
        f8634e.mo50878a(th, str);
    }

    /* renamed from: a */
    public static void m50929a(Throwable th) {
        f8634e.mo50879a(th);
    }

    /* renamed from: a */
    public static void m50931a(Object obj) {
        f8634e.mo50881a(obj);
    }

    /* renamed from: a */
    public static void m50936a(int i, String str) {
        f8634e.mo50886a(i, str);
    }

    /* renamed from: a */
    public static void m50934a(int i, Throwable th, String str) {
        f8634e.mo50883a(i, th, str);
    }

    /* renamed from: a */
    public static void m50933a(int i, Object... objArr) {
        f8634e.mo50882a(i, objArr);
    }

    /* renamed from: a */
    public static void m50935a(int i, Throwable th) {
        f8634e.mo50884a(i, th);
    }

    /* renamed from: a */
    public static void m50932a(AbstractC2608a abstractC2608a) {
        if (abstractC2608a == null || abstractC2608a == f8634e) {
            return;
        }
        Map<String, AbstractC2608a> map = f8633d;
        synchronized (map) {
            map.put(abstractC2608a.mo50887a(), abstractC2608a);
            f8631b = (AbstractC2608a[]) map.values().toArray(new AbstractC2608a[0]);
        }
    }
}
