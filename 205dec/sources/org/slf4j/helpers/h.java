package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Marker;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SubstituteLogger.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h implements org.slf4j.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f61753a;

    /* renamed from: b  reason: collision with root package name */
    private volatile org.slf4j.c f61754b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f61755c;

    /* renamed from: d  reason: collision with root package name */
    private Method f61756d;

    /* renamed from: e  reason: collision with root package name */
    private org.slf4j.event.b f61757e;

    /* renamed from: f  reason: collision with root package name */
    private Queue<org.slf4j.event.d> f61758f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f61759g;

    public h(String str, Queue<org.slf4j.event.d> queue, boolean z3) {
        this.f61753a = str;
        this.f61758f = queue;
        this.f61759g = z3;
    }

    private org.slf4j.c c() {
        if (this.f61757e == null) {
            this.f61757e = new org.slf4j.event.b(this, this.f61758f);
        }
        return this.f61757e;
    }

    org.slf4j.c b() {
        if (this.f61754b != null) {
            return this.f61754b;
        }
        if (this.f61759g) {
            return NOPLogger.NOP_LOGGER;
        }
        return c();
    }

    public boolean d() {
        Boolean bool = this.f61755c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f61756d = this.f61754b.getClass().getMethod("log", org.slf4j.event.c.class);
            this.f61755c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f61755c = Boolean.FALSE;
        }
        return this.f61755c.booleanValue();
    }

    @Override // org.slf4j.c
    public void debug(String str) {
        b().debug(str);
    }

    public boolean e() {
        return this.f61754b instanceof NOPLogger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f61753a.equals(((h) obj).f61753a);
    }

    @Override // org.slf4j.c
    public void error(String str) {
        b().error(str);
    }

    public boolean f() {
        return this.f61754b == null;
    }

    public void g(org.slf4j.event.c cVar) {
        if (d()) {
            try {
                this.f61756d.invoke(this.f61754b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // org.slf4j.c
    public String getName() {
        return this.f61753a;
    }

    public void h(org.slf4j.c cVar) {
        this.f61754b = cVar;
    }

    public int hashCode() {
        return this.f61753a.hashCode();
    }

    @Override // org.slf4j.c
    public void info(String str) {
        b().info(str);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return b().isDebugEnabled();
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return b().isErrorEnabled();
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return b().isInfoEnabled();
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return b().isTraceEnabled();
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return b().isWarnEnabled();
    }

    @Override // org.slf4j.c
    public void trace(String str) {
        b().trace(str);
    }

    @Override // org.slf4j.c
    public void warn(String str) {
        b().warn(str);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj) {
        b().debug(str, obj);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj) {
        b().error(str, obj);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj) {
        b().info(str, obj);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled(Marker marker) {
        return b().isDebugEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled(Marker marker) {
        return b().isErrorEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled(Marker marker) {
        return b().isInfoEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled(Marker marker) {
        return b().isTraceEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled(Marker marker) {
        return b().isWarnEnabled(marker);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj) {
        b().trace(str, obj);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj) {
        b().warn(str, obj);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj, Object obj2) {
        b().debug(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj, Object obj2) {
        b().error(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj, Object obj2) {
        b().info(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj, Object obj2) {
        b().trace(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj, Object obj2) {
        b().warn(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object... objArr) {
        b().debug(str, objArr);
    }

    @Override // org.slf4j.c
    public void error(String str, Object... objArr) {
        b().error(str, objArr);
    }

    @Override // org.slf4j.c
    public void info(String str, Object... objArr) {
        b().info(str, objArr);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object... objArr) {
        b().trace(str, objArr);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object... objArr) {
        b().warn(str, objArr);
    }

    @Override // org.slf4j.c
    public void debug(String str, Throwable th) {
        b().debug(str, th);
    }

    @Override // org.slf4j.c
    public void error(String str, Throwable th) {
        b().error(str, th);
    }

    @Override // org.slf4j.c
    public void info(String str, Throwable th) {
        b().info(str, th);
    }

    @Override // org.slf4j.c
    public void trace(String str, Throwable th) {
        b().trace(str, th);
    }

    @Override // org.slf4j.c
    public void warn(String str, Throwable th) {
        b().warn(str, th);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str) {
        b().debug(marker, str);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str) {
        b().error(marker, str);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str) {
        b().info(marker, str);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str) {
        b().trace(marker, str);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str) {
        b().warn(marker, str);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object obj) {
        b().debug(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object obj) {
        b().error(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object obj) {
        b().info(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object obj) {
        b().trace(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object obj) {
        b().warn(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        b().debug(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object obj, Object obj2) {
        b().error(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object obj, Object obj2) {
        b().info(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        b().trace(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        b().warn(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object... objArr) {
        b().debug(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object... objArr) {
        b().error(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object... objArr) {
        b().info(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object... objArr) {
        b().trace(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object... objArr) {
        b().warn(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Throwable th) {
        b().debug(marker, str, th);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Throwable th) {
        b().error(marker, str, th);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Throwable th) {
        b().info(marker, str, th);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Throwable th) {
        b().trace(marker, str, th);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Throwable th) {
        b().warn(marker, str, th);
    }
}
