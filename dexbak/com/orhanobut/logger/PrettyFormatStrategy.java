package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.netty.handler.codec.http.HttpConstants;

/* renamed from: com.orhanobut.logger.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PrettyFormatStrategy implements FormatStrategy {

    /* renamed from: f */
    private static final int f32696f = 4000;

    /* renamed from: g */
    private static final int f32697g = 5;

    /* renamed from: h */
    private static final char f32698h = 9484;

    /* renamed from: i */
    private static final char f32699i = 9492;

    /* renamed from: j */
    private static final char f32700j = 9500;

    /* renamed from: k */
    private static final char f32701k = 9474;

    /* renamed from: l */
    private static final String f32702l = "────────────────────────────────────────────────────────";

    /* renamed from: m */
    private static final String f32703m = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: n */
    private static final String f32704n = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: o */
    private static final String f32705o = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: p */
    private static final String f32706p = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: a */
    private final int f32707a;

    /* renamed from: b */
    private final int f32708b;

    /* renamed from: c */
    private final boolean f32709c;
    @NonNull

    /* renamed from: d */
    private final LogStrategy f32710d;
    @Nullable

    /* renamed from: e */
    private final String f32711e;

    /* compiled from: PrettyFormatStrategy.java */
    /* renamed from: com.orhanobut.logger.l$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C11794b {

        /* renamed from: a */
        int f32712a;

        /* renamed from: b */
        int f32713b;

        /* renamed from: c */
        boolean f32714c;
        @Nullable

        /* renamed from: d */
        LogStrategy f32715d;
        @Nullable

        /* renamed from: e */
        String f32716e;

        @NonNull
        /* renamed from: a */
        public PrettyFormatStrategy m20443a() {
            if (this.f32715d == null) {
                this.f32715d = new LogcatLogStrategy();
            }
            return new PrettyFormatStrategy(this);
        }

        @NonNull
        /* renamed from: b */
        public C11794b m20442b(@Nullable LogStrategy logStrategy) {
            this.f32715d = logStrategy;
            return this;
        }

        @NonNull
        /* renamed from: c */
        public C11794b m20441c(int i) {
            this.f32712a = i;
            return this;
        }

        @NonNull
        /* renamed from: d */
        public C11794b m20440d(int i) {
            this.f32713b = i;
            return this;
        }

        @NonNull
        /* renamed from: e */
        public C11794b m20439e(boolean z) {
            this.f32714c = z;
            return this;
        }

        @NonNull
        /* renamed from: f */
        public C11794b m20438f(@Nullable String str) {
            this.f32716e = str;
            return this;
        }

        private C11794b() {
            this.f32712a = 2;
            this.f32713b = 0;
            this.f32714c = true;
            this.f32716e = "PRETTY_LOGGER";
        }
    }

    @Nullable
    /* renamed from: b */
    private String m20453b(@Nullable String str) {
        if (!C11795n.m20420d(str) && !C11795n.m20422b(this.f32711e, str)) {
            return this.f32711e + "-" + str;
        }
        return this.f32711e;
    }

    /* renamed from: c */
    private String m20452c(@NonNull String str) {
        C11795n.m20423a(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: d */
    private int m20451d(@NonNull StackTraceElement[] stackTraceElementArr) {
        C11795n.m20423a(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(LoggerPrinter.class.getName()) && !className.equals(C11792j.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    /* renamed from: e */
    private void m20450e(int i, @Nullable String str) {
        m20449f(i, str, f32705o);
    }

    /* renamed from: f */
    private void m20449f(int i, @Nullable String str, @NonNull String str2) {
        C11795n.m20423a(str2);
        this.f32710d.mo20473a(i, str, str2);
    }

    /* renamed from: g */
    private void m20448g(int i, @Nullable String str, @NonNull String str2) {
        String[] split;
        C11795n.m20423a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            m20449f(i, str, "│ " + str3);
        }
    }

    /* renamed from: h */
    private void m20447h(int i, @Nullable String str) {
        m20449f(i, str, f32706p);
    }

    /* renamed from: i */
    private void m20446i(int i, @Nullable String str, int i2) {
        int i3;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f32709c) {
            m20449f(i, str, "│ Thread: " + Thread.currentThread().getName());
            m20447h(i, str);
        }
        int m20451d = m20451d(stackTrace) + this.f32708b;
        if (i2 + m20451d > stackTrace.length) {
            i2 = (stackTrace.length - m20451d) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            if (i2 + m20451d < stackTrace.length) {
                str2 = str2 + "   ";
                m20449f(i, str, f32701k + HttpConstants.SP_CHAR + str2 + m20452c(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* renamed from: j */
    private void m20445j(int i, @Nullable String str) {
        m20449f(i, str, f32704n);
    }

    @NonNull
    /* renamed from: k */
    public static C11794b m20444k() {
        return new C11794b();
    }

    @Override // com.orhanobut.logger.FormatStrategy
    /* renamed from: a */
    public void mo20454a(int i, @Nullable String str, @NonNull String str2) {
        C11795n.m20423a(str2);
        String m20453b = m20453b(str);
        m20445j(i, m20453b);
        m20446i(i, m20453b, this.f32707a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f32707a > 0) {
                m20447h(i, m20453b);
            }
            m20448g(i, m20453b, str2);
            m20450e(i, m20453b);
            return;
        }
        if (this.f32707a > 0) {
            m20447h(i, m20453b);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            m20448g(i, m20453b, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        m20450e(i, m20453b);
    }

    private PrettyFormatStrategy(@NonNull C11794b c11794b) {
        C11795n.m20423a(c11794b);
        this.f32707a = c11794b.f32712a;
        this.f32708b = c11794b.f32713b;
        this.f32709c = c11794b.f32714c;
        this.f32710d = c11794b.f32715d;
        this.f32711e = c11794b.f32716e;
    }
}
