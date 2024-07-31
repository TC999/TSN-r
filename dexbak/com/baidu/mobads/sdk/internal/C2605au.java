package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.C2607aw;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.baidu.mobads.sdk.internal.au */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2605au extends C2607aw.AbstractC2608a {

    /* renamed from: a */
    public static final String f8614a = "local";

    /* renamed from: b */
    private static final int f8615b = 4000;

    /* renamed from: c */
    private static final int f8616c = 23;

    /* renamed from: d */
    private static final int f8617d = 5;

    /* renamed from: e */
    private static final Pattern f8618e = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: f */
    private static final char f8619f = 9556;

    /* renamed from: g */
    private static final char f8620g = 9562;

    /* renamed from: h */
    private static final char f8621h = 9567;

    /* renamed from: i */
    private static final char f8622i = 9553;

    /* renamed from: j */
    private static final String f8623j = "════════════════════════════════════════════";

    /* renamed from: k */
    private static final String f8624k = "------------------------------------------";

    /* renamed from: l */
    private static final String f8625l = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: m */
    private static final String f8626m = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: n */
    private static final String f8627n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    @NonNull
    /* renamed from: a */
    String mo50887a() {
        return "local";
    }

    /* renamed from: a */
    protected String m50939a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f8618e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    /* renamed from: b */
    public final String mo50892b() {
        String mo50892b = super.mo50892b();
        if (mo50892b != null) {
            return mo50892b;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : m50939a(stackTrace[5]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public String m50938c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f8618e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (className.equals(C2607aw.class.getName()) || className.equals(C2634bs.class.getName())) {
                z = true;
            } else if (z) {
                break;
            }
            i++;
        }
        String fileName = stackTrace[i].getFileName();
        String methodName = stackTrace[i].getMethodName();
        return "   (" + fileName + ":" + stackTrace[i].getLineNumber() + ")# " + methodName;
    }

    @Override // com.baidu.mobads.sdk.internal.C2607aw.AbstractC2608a
    /* renamed from: a */
    protected void mo50885a(int i, String str, String str2, Throwable th) {
        String[] strArr;
        int min;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("当前线程：");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(m50938c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() > 4000) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i2 = 0;
                while (i2 < length) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i2 + 4000);
                        arrayList.add(str2.substring(i2, min));
                        if (min >= indexOf) {
                            break;
                        }
                        i2 = min;
                    }
                    i2 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    m50940a(i, str, sb.toString() + str3);
                }
                return;
            }
            sb.append(str2);
            m50940a(i, str, sb.toString());
        } catch (Throwable th2) {
            m50940a(6, str, th2.toString());
        }
    }

    /* renamed from: a */
    private static void m50940a(int i, String str, String str2) {
        if (i == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }
}
