package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PrettyFormatStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l implements f {

    /* renamed from: f  reason: collision with root package name */
    private static final int f41383f = 4000;

    /* renamed from: g  reason: collision with root package name */
    private static final int f41384g = 5;

    /* renamed from: h  reason: collision with root package name */
    private static final char f41385h = '\u250c';

    /* renamed from: i  reason: collision with root package name */
    private static final char f41386i = '\u2514';

    /* renamed from: j  reason: collision with root package name */
    private static final char f41387j = '\u251c';

    /* renamed from: k  reason: collision with root package name */
    private static final char f41388k = '\u2502';

    /* renamed from: l  reason: collision with root package name */
    private static final String f41389l = "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500";

    /* renamed from: m  reason: collision with root package name */
    private static final String f41390m = "\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504";

    /* renamed from: n  reason: collision with root package name */
    private static final String f41391n = "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500";

    /* renamed from: o  reason: collision with root package name */
    private static final String f41392o = "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500";

    /* renamed from: p  reason: collision with root package name */
    private static final String f41393p = "\u251c\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504";

    /* renamed from: a  reason: collision with root package name */
    private final int f41394a;

    /* renamed from: b  reason: collision with root package name */
    private final int f41395b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41396c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final h f41397d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f41398e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: PrettyFormatStrategy.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f41399a;

        /* renamed from: b  reason: collision with root package name */
        int f41400b;

        /* renamed from: c  reason: collision with root package name */
        boolean f41401c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        h f41402d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        String f41403e;

        @NonNull
        public l a() {
            if (this.f41402d == null) {
                this.f41402d = new i();
            }
            return new l(this);
        }

        @NonNull
        public b b(@Nullable h hVar) {
            this.f41402d = hVar;
            return this;
        }

        @NonNull
        public b c(int i4) {
            this.f41399a = i4;
            return this;
        }

        @NonNull
        public b d(int i4) {
            this.f41400b = i4;
            return this;
        }

        @NonNull
        public b e(boolean z3) {
            this.f41401c = z3;
            return this;
        }

        @NonNull
        public b f(@Nullable String str) {
            this.f41403e = str;
            return this;
        }

        private b() {
            this.f41399a = 2;
            this.f41400b = 0;
            this.f41401c = true;
            this.f41403e = "PRETTY_LOGGER";
        }
    }

    @Nullable
    private String b(@Nullable String str) {
        if (!n.d(str) && !n.b(this.f41398e, str)) {
            return this.f41398e + "-" + str;
        }
        return this.f41398e;
    }

    private String c(@NonNull String str) {
        n.a(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private int d(@NonNull StackTraceElement[] stackTraceElementArr) {
        n.a(stackTraceElementArr);
        for (int i4 = 5; i4 < stackTraceElementArr.length; i4++) {
            String className = stackTraceElementArr[i4].getClassName();
            if (!className.equals(k.class.getName()) && !className.equals(j.class.getName())) {
                return i4 - 1;
            }
        }
        return -1;
    }

    private void e(int i4, @Nullable String str) {
        f(i4, str, "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
    }

    private void f(int i4, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        this.f41397d.a(i4, str, str2);
    }

    private void g(int i4, @Nullable String str, @NonNull String str2) {
        String[] split;
        n.a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            f(i4, str, "\u2502 " + str3);
        }
    }

    private void h(int i4, @Nullable String str) {
        f(i4, str, "\u251c\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504");
    }

    private void i(int i4, @Nullable String str, int i5) {
        int i6;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f41396c) {
            f(i4, str, "\u2502 Thread: " + Thread.currentThread().getName());
            h(i4, str);
        }
        int d4 = d(stackTrace) + this.f41395b;
        if (i5 + d4 > stackTrace.length) {
            i5 = (stackTrace.length - d4) - 1;
        }
        String str2 = "";
        while (i5 > 0) {
            if (i5 + d4 < stackTrace.length) {
                str2 = str2 + "   ";
                f(i4, str, "\u2502 " + str2 + c(stackTrace[i6].getClassName()) + "." + stackTrace[i6].getMethodName() + "  (" + stackTrace[i6].getFileName() + ":" + stackTrace[i6].getLineNumber() + ")");
            }
            i5--;
        }
    }

    private void j(int i4, @Nullable String str) {
        f(i4, str, "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
    }

    @NonNull
    public static b k() {
        return new b();
    }

    @Override // com.orhanobut.logger.f
    public void a(int i4, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        String b4 = b(str);
        j(i4, b4);
        i(i4, b4, this.f41394a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f41394a > 0) {
                h(i4, b4);
            }
            g(i4, b4, str2);
            e(i4, b4);
            return;
        }
        if (this.f41394a > 0) {
            h(i4, b4);
        }
        for (int i5 = 0; i5 < length; i5 += 4000) {
            g(i4, b4, new String(bytes, i5, Math.min(length - i5, 4000)));
        }
        e(i4, b4);
    }

    private l(@NonNull b bVar) {
        n.a(bVar);
        this.f41394a = bVar.f41399a;
        this.f41395b = bVar.f41400b;
        this.f41396c = bVar.f41401c;
        this.f41397d = bVar.f41402d;
        this.f41398e = bVar.f41403e;
    }
}
