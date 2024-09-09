package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EventRecodingLogger.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b implements org.slf4j.c {

    /* renamed from: a  reason: collision with root package name */
    String f61729a;

    /* renamed from: b  reason: collision with root package name */
    h f61730b;

    /* renamed from: c  reason: collision with root package name */
    Queue<d> f61731c;

    public b(h hVar, Queue<d> queue) {
        this.f61730b = hVar;
        this.f61729a = hVar.getName();
        this.f61731c = queue;
    }

    private void b(Level level, String str, Object[] objArr, Throwable th) {
        c(level, null, str, objArr, th);
    }

    private void c(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        d dVar = new d();
        dVar.q(System.currentTimeMillis());
        dVar.j(level);
        dVar.k(this.f61730b);
        dVar.l(this.f61729a);
        dVar.n(str);
        dVar.i(objArr);
        dVar.p(th);
        dVar.o(Thread.currentThread().getName());
        this.f61731c.add(dVar);
    }

    @Override // org.slf4j.c
    public void debug(String str) {
        b(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.c
    public void error(String str) {
        b(Level.ERROR, str, null, null);
    }

    @Override // org.slf4j.c
    public String getName() {
        return this.f61729a;
    }

    @Override // org.slf4j.c
    public void info(String str) {
        b(Level.INFO, str, null, null);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.c
    public void trace(String str) {
        b(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.c
    public void warn(String str) {
        b(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj) {
        b(Level.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj) {
        b(Level.ERROR, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj) {
        b(Level.INFO, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj) {
        b(Level.TRACE, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj) {
        b(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj, Object obj2) {
        b(Level.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj, Object obj2) {
        b(Level.ERROR, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj, Object obj2) {
        b(Level.INFO, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj, Object obj2) {
        b(Level.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj, Object obj2) {
        b(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object... objArr) {
        b(Level.DEBUG, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void error(String str, Object... objArr) {
        b(Level.ERROR, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void info(String str, Object... objArr) {
        b(Level.INFO, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object... objArr) {
        b(Level.TRACE, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object... objArr) {
        b(Level.WARN, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void debug(String str, Throwable th) {
        b(Level.DEBUG, str, null, th);
    }

    @Override // org.slf4j.c
    public void error(String str, Throwable th) {
        b(Level.ERROR, str, null, th);
    }

    @Override // org.slf4j.c
    public void info(String str, Throwable th) {
        b(Level.INFO, str, null, th);
    }

    @Override // org.slf4j.c
    public void trace(String str, Throwable th) {
        b(Level.TRACE, str, null, th);
    }

    @Override // org.slf4j.c
    public void warn(String str, Throwable th) {
        b(Level.WARN, str, null, th);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str) {
        c(Level.DEBUG, marker, str, null, null);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str) {
        c(Level.ERROR, marker, str, null, null);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str) {
        c(Level.INFO, marker, str, null, null);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str) {
        c(Level.TRACE, marker, str, null, null);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str) {
        b(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object obj) {
        c(Level.DEBUG, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object obj) {
        c(Level.ERROR, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object obj) {
        c(Level.INFO, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object obj) {
        c(Level.TRACE, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object obj) {
        b(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        c(Level.DEBUG, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object obj, Object obj2) {
        c(Level.ERROR, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object obj, Object obj2) {
        c(Level.INFO, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        c(Level.TRACE, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        c(Level.WARN, marker, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object... objArr) {
        c(Level.DEBUG, marker, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object... objArr) {
        c(Level.ERROR, marker, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object... objArr) {
        c(Level.INFO, marker, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object... objArr) {
        c(Level.TRACE, marker, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object... objArr) {
        c(Level.WARN, marker, str, objArr, null);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Throwable th) {
        c(Level.DEBUG, marker, str, null, th);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Throwable th) {
        c(Level.ERROR, marker, str, null, th);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Throwable th) {
        c(Level.INFO, marker, str, null, th);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Throwable th) {
        c(Level.TRACE, marker, str, null, th);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Throwable th) {
        c(Level.WARN, marker, str, null, th);
    }
}
