package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.az;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aw extends az.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12429a = "debug";

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<String> f12430a = new ThreadLocal<>();

        private String g(Object[] objArr) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(' ');
            }
            return sb.toString();
        }

        @NonNull
        abstract String a();

        protected abstract void a(int i4, String str, String str2, Throwable th);

        protected boolean a(int i4) {
            return true;
        }

        String b() {
            String str = this.f12430a.get();
            if (str != null) {
                this.f12430a.remove();
            }
            return str;
        }

        public void c(String str) {
            b(3, null, str);
        }

        public void d(String str) {
            b(4, null, str);
        }

        public void e(String str) {
            b(5, null, str);
        }

        public void f(String str) {
            b(6, null, str);
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                String trim = str.trim();
                if (trim.startsWith("{")) {
                    b(3, null, new JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    b(3, null, new JSONArray(trim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (Exception unused) {
                f("Invalid Json");
            }
        }

        public void c(Object... objArr) {
            b(4, null, g(objArr));
        }

        public void d(Throwable th, String str) {
            b(5, th, str);
        }

        public void e(Object... objArr) {
            b(6, null, g(objArr));
        }

        public void f(Object... objArr) {
            b(7, null, g(objArr));
        }

        protected String b(Object obj) {
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

        public void c(Throwable th, String str) {
            b(4, th, str);
        }

        public void d(Throwable th) {
            b(5, th, null);
        }

        public void e(Throwable th, String str) {
            b(6, th, str);
        }

        public void f(Throwable th, String str) {
            b(7, th, str);
        }

        public void c(Throwable th) {
            b(4, th, null);
        }

        public void d(Object... objArr) {
            b(5, null, g(objArr));
        }

        public void e(Throwable th) {
            b(6, th, null);
        }

        public void f(Throwable th) {
            b(7, th, null);
        }

        public void g(String str) {
            b(7, null, str);
        }

        private String g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public void a(Object... objArr) {
            b(2, null, g(objArr));
        }

        public void a(Throwable th, String str) {
            b(2, th, str);
        }

        public void a(Throwable th) {
            b(2, th, null);
        }

        public void a(Object obj) {
            b(3, null, b(obj));
        }

        public void a(int i4, String str) {
            b(i4, null, str);
        }

        public void a(int i4, Object... objArr) {
            b(i4, null, g(objArr));
        }

        public void a(int i4, Throwable th, String str) {
            b(i4, th, str);
        }

        public void a(int i4, Throwable th) {
            b(i4, th, null);
        }

        protected boolean a(String str, int i4) {
            return a(i4);
        }

        public void b(String str) {
            b(2, null, str);
        }

        protected String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public void b(Throwable th, String str) {
            b(3, th, str);
        }

        public void b(Object... objArr) {
            b(3, null, g(objArr));
        }

        public void b(Throwable th) {
            b(3, th, null);
        }

        private void b(int i4, Throwable th, String str) {
            String b4 = b();
            if (a(b4, i4)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th == null) {
                        return;
                    }
                    str = g(th);
                } else if (th != null) {
                    str = str + "\n" + g(th);
                }
                a(i4, b4, str, th);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    @NonNull
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected boolean a(String str, int i4) {
        return "bqt_ad_tag".equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected void a(int i4, String str, String str2, Throwable th) {
        a(i4, str, str2);
    }

    private static void a(int i4, String str, String str2) {
        try {
            if (i4 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i4, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
