package org.slf4j.helpers;

import org.slf4j.InterfaceC15424c;
import org.slf4j.Marker;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase implements InterfaceC15424c {
    private static final long serialVersionUID = 9044267456635152283L;

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str) {
        debug(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str) {
        error(str);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, org.slf4j.InterfaceC15424c
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str) {
        info(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isErrorEnabled(Marker marker) {
        return isErrorEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isInfoEnabled(Marker marker) {
        return isInfoEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isTraceEnabled(Marker marker) {
        return isTraceEnabled();
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isWarnEnabled(Marker marker) {
        return isWarnEnabled();
    }

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str) {
        trace(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str) {
        warn(str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object obj) {
        debug(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object obj) {
        error(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object obj) {
        info(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object obj) {
        trace(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object obj) {
        warn(str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        debug(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object obj, Object obj2) {
        error(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object obj, Object obj2) {
        info(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        trace(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        warn(str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Object... objArr) {
        debug(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Object... objArr) {
        error(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Object... objArr) {
        info(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Object... objArr) {
        trace(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Object... objArr) {
        warn(str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(Marker marker, String str, Throwable th) {
        debug(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(Marker marker, String str, Throwable th) {
        error(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(Marker marker, String str, Throwable th) {
        info(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(Marker marker, String str, Throwable th) {
        trace(str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(Marker marker, String str, Throwable th) {
        warn(str, th);
    }
}
