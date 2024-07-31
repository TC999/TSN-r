package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.InterfaceC15424c;
import org.slf4j.Marker;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* renamed from: org.slf4j.helpers.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SubstituteLogger implements InterfaceC15424c {

    /* renamed from: a */
    private final String f44353a;

    /* renamed from: b */
    private volatile InterfaceC15424c f44354b;

    /* renamed from: c */
    private Boolean f44355c;

    /* renamed from: d */
    private Method f44356d;

    /* renamed from: e */
    private EventRecodingLogger f44357e;

    /* renamed from: f */
    private Queue<SubstituteLoggingEvent> f44358f;

    /* renamed from: g */
    private final boolean f44359g;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.f44353a = str;
        this.f44358f = queue;
        this.f44359g = z;
    }

    /* renamed from: c */
    private InterfaceC15424c m2579c() {
        if (this.f44357e == null) {
            this.f44357e = new EventRecodingLogger(this, this.f44358f);
        }
        return this.f44357e;
    }

    /* renamed from: b */
    InterfaceC15424c m2580b() {
        if (this.f44354b != null) {
            return this.f44354b;
        }
        if (this.f44359g) {
            return NOPLogger.NOP_LOGGER;
        }
        return m2579c();
    }

    /* renamed from: d */
    public boolean m2578d() {
        Boolean bool = this.f44355c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f44356d = this.f44354b.getClass().getMethod("log", LoggingEvent.class);
            this.f44355c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f44355c = Boolean.FALSE;
        }
        return this.f44355c.booleanValue();
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str) {
        m2580b().debug(str);
    }

    /* renamed from: e */
    public boolean m2577e() {
        return this.f44354b instanceof NOPLogger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f44353a.equals(((SubstituteLogger) obj).f44353a);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str) {
        m2580b().error(str);
    }

    /* renamed from: f */
    public boolean m2576f() {
        return this.f44354b == null;
    }

    /* renamed from: g */
    public void m2575g(LoggingEvent loggingEvent) {
        if (m2578d()) {
            try {
                this.f44356d.invoke(this.f44354b, loggingEvent);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // org.slf4j.InterfaceC15424c
    public String getName() {
        return this.f44353a;
    }

    /* renamed from: h */
    public void m2574h(InterfaceC15424c interfaceC15424c) {
        this.f44354b = interfaceC15424c;
    }

    public int hashCode() {
        return this.f44353a.hashCode();
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str) {
        m2580b().info(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isDebugEnabled() {
        return m2580b().isDebugEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isErrorEnabled() {
        return m2580b().isErrorEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isInfoEnabled() {
        return m2580b().isInfoEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isTraceEnabled() {
        return m2580b().isTraceEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isWarnEnabled() {
        return m2580b().isWarnEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str) {
        m2580b().trace(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str) {
        m2580b().warn(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object obj) {
        m2580b().debug(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object obj) {
        m2580b().error(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object obj) {
        m2580b().info(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isDebugEnabled(Marker marker) {
        return m2580b().isDebugEnabled(marker);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isErrorEnabled(Marker marker) {
        return m2580b().isErrorEnabled(marker);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isInfoEnabled(Marker marker) {
        return m2580b().isInfoEnabled(marker);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isTraceEnabled(Marker marker) {
        return m2580b().isTraceEnabled(marker);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isWarnEnabled(Marker marker) {
        return m2580b().isWarnEnabled(marker);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object obj) {
        m2580b().trace(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object obj) {
        m2580b().warn(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object obj, Object obj2) {
        m2580b().debug(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object obj, Object obj2) {
        m2580b().error(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object obj, Object obj2) {
        m2580b().info(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object obj, Object obj2) {
        m2580b().trace(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object obj, Object obj2) {
        m2580b().warn(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object... objArr) {
        m2580b().debug(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object... objArr) {
        m2580b().error(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object... objArr) {
        m2580b().info(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object... objArr) {
        m2580b().trace(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object... objArr) {
        m2580b().warn(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Throwable th) {
        m2580b().debug(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Throwable th) {
        m2580b().error(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Throwable th) {
        m2580b().info(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Throwable th) {
        m2580b().trace(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Throwable th) {
        m2580b().warn(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str) {
        m2580b().debug(marker, str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str) {
        m2580b().error(marker, str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str) {
        m2580b().info(marker, str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str) {
        m2580b().trace(marker, str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str) {
        m2580b().warn(marker, str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object obj) {
        m2580b().debug(marker, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object obj) {
        m2580b().error(marker, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object obj) {
        m2580b().info(marker, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object obj) {
        m2580b().trace(marker, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object obj) {
        m2580b().warn(marker, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        m2580b().debug(marker, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object obj, Object obj2) {
        m2580b().error(marker, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object obj, Object obj2) {
        m2580b().info(marker, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        m2580b().trace(marker, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        m2580b().warn(marker, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object... objArr) {
        m2580b().debug(marker, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object... objArr) {
        m2580b().error(marker, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object... objArr) {
        m2580b().info(marker, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object... objArr) {
        m2580b().trace(marker, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object... objArr) {
        m2580b().warn(marker, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Throwable th) {
        m2580b().debug(marker, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Throwable th) {
        m2580b().error(marker, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Throwable th) {
        m2580b().info(marker, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Throwable th) {
        m2580b().trace(marker, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Throwable th) {
        m2580b().warn(marker, str, th);
    }
}
