package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.az;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ax extends az.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12431a = "local";

    /* renamed from: b  reason: collision with root package name */
    private static final int f12432b = 4000;

    /* renamed from: c  reason: collision with root package name */
    private static final int f12433c = 23;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12434d = 5;

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f12435e = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: f  reason: collision with root package name */
    private static final char f12436f = '\u2554';

    /* renamed from: g  reason: collision with root package name */
    private static final char f12437g = '\u255a';

    /* renamed from: h  reason: collision with root package name */
    private static final char f12438h = '\u255f';

    /* renamed from: i  reason: collision with root package name */
    private static final char f12439i = '\u2551';

    /* renamed from: j  reason: collision with root package name */
    private static final String f12440j = "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550";

    /* renamed from: k  reason: collision with root package name */
    private static final String f12441k = "------------------------------------------";

    /* renamed from: l  reason: collision with root package name */
    private static final String f12442l = "\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550";

    /* renamed from: m  reason: collision with root package name */
    private static final String f12443m = "\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550";

    /* renamed from: n  reason: collision with root package name */
    private static final String f12444n = "\u255f------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.az.a
    @NonNull
    String a() {
        return "local";
    }

    protected String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f12435e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mobads.sdk.internal.az.a
    public final String b() {
        String b4 = super.b();
        if (b4 != null) {
            return b4;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z3 = false;
        int i4 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f12435e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (className.equals(az.class.getName()) || className.equals(bv.class.getName())) {
                z3 = true;
            } else if (z3) {
                break;
            }
            i4++;
        }
        String fileName = stackTrace[i4].getFileName();
        String methodName = stackTrace[i4].getMethodName();
        return "   (" + fileName + ":" + stackTrace[i4].getLineNumber() + ")# " + methodName;
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected void a(int i4, String str, String str2, Throwable th) {
        String[] strArr;
        int min;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("\u5f53\u524d\u7ebf\u7a0b\uff1a");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("\u8c03\u7528\u4f4d\u7f6e\uff1a");
            sb.append(c());
            sb.append(";  ");
            sb.append("\u6253\u5370\u6d88\u606f\uff1a");
            if (str2.length() > 4000) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i5 = 0;
                while (i5 < length) {
                    int indexOf = str2.indexOf(10, i5);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i5 + 4000);
                        arrayList.add(str2.substring(i5, min));
                        if (min >= indexOf) {
                            break;
                        }
                        i5 = min;
                    }
                    i5 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i4, str, sb.toString() + str3);
                }
                return;
            }
            sb.append(str2);
            a(i4, str, sb.toString());
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    private static void a(int i4, String str, String str2) {
        if (i4 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i4, str, str2);
        }
    }
}
