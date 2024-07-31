package org.slf4j.event;

import java.util.Queue;
import org.slf4j.InterfaceC15424c;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* renamed from: org.slf4j.event.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class EventRecodingLogger implements InterfaceC15424c {

    /* renamed from: a */
    String f44329a;

    /* renamed from: b */
    SubstituteLogger f44330b;

    /* renamed from: c */
    Queue<SubstituteLoggingEvent> f44331c;

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.f44330b = substituteLogger;
        this.f44329a = substituteLogger.getName();
        this.f44331c = queue;
    }

    /* renamed from: b */
    private void m2634b(Level level, String str, Object[] objArr, Throwable th) {
        m2633c(level, null, str, objArr, th);
    }

    /* renamed from: c */
    private void m2633c(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.m2616q(System.currentTimeMillis());
        substituteLoggingEvent.m2623j(level);
        substituteLoggingEvent.m2622k(this.f44330b);
        substituteLoggingEvent.m2621l(this.f44329a);
        substituteLoggingEvent.m2619n(str);
        substituteLoggingEvent.m2624i(objArr);
        substituteLoggingEvent.m2617p(th);
        substituteLoggingEvent.m2618o(Thread.currentThread().getName());
        this.f44331c.add(substituteLoggingEvent);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str) {
        m2634b(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str) {
        m2634b(Level.ERROR, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public String getName() {
        return this.f44329a;
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str) {
        m2634b(Level.INFO, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str) {
        m2634b(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str) {
        m2634b(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object obj) {
        m2634b(Level.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object obj) {
        m2634b(Level.ERROR, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object obj) {
        m2634b(Level.INFO, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object obj) {
        m2634b(Level.TRACE, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object obj) {
        m2634b(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object obj, Object obj2) {
        m2634b(Level.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object obj, Object obj2) {
        m2634b(Level.ERROR, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object obj, Object obj2) {
        m2634b(Level.INFO, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object obj, Object obj2) {
        m2634b(Level.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object obj, Object obj2) {
        m2634b(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object... objArr) {
        m2634b(Level.DEBUG, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object... objArr) {
        m2634b(Level.ERROR, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object... objArr) {
        m2634b(Level.INFO, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object... objArr) {
        m2634b(Level.TRACE, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object... objArr) {
        m2634b(Level.WARN, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Throwable th) {
        m2634b(Level.DEBUG, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Throwable th) {
        m2634b(Level.ERROR, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Throwable th) {
        m2634b(Level.INFO, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Throwable th) {
        m2634b(Level.TRACE, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Throwable th) {
        m2634b(Level.WARN, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str) {
        m2633c(Level.DEBUG, marker, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str) {
        m2633c(Level.ERROR, marker, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str) {
        m2633c(Level.INFO, marker, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str) {
        m2633c(Level.TRACE, marker, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str) {
        m2634b(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object obj) {
        m2633c(Level.DEBUG, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object obj) {
        m2633c(Level.ERROR, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object obj) {
        m2633c(Level.INFO, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object obj) {
        m2633c(Level.TRACE, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object obj) {
        m2634b(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        m2633c(Level.DEBUG, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object obj, Object obj2) {
        m2633c(Level.ERROR, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object obj, Object obj2) {
        m2633c(Level.INFO, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        m2633c(Level.TRACE, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        m2633c(Level.WARN, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object... objArr) {
        m2633c(Level.DEBUG, marker, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object... objArr) {
        m2633c(Level.ERROR, marker, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object... objArr) {
        m2633c(Level.INFO, marker, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object... objArr) {
        m2633c(Level.TRACE, marker, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object... objArr) {
        m2633c(Level.WARN, marker, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Throwable th) {
        m2633c(Level.DEBUG, marker, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Throwable th) {
        m2633c(Level.ERROR, marker, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Throwable th) {
        m2633c(Level.INFO, marker, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Throwable th) {
        m2633c(Level.TRACE, marker, str, null, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Throwable th) {
        m2633c(Level.WARN, marker, str, null, th);
    }
}
