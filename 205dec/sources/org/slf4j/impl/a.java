package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.MarkerIgnoringBase;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AndroidLoggerAdapter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class a extends MarkerIgnoringBase {
    private static final long serialVersionUID = -1227274521521287937L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.name = str;
    }

    private void b(int i4, String str, Object... objArr) {
        if (c(i4)) {
            org.slf4j.helpers.c a4 = org.slf4j.helpers.d.a(str, objArr);
            e(i4, a4.b(), a4.c());
        }
    }

    private boolean c(int i4) {
        return Log.isLoggable(this.name, i4);
    }

    private void d(int i4, String str, Throwable th) {
        if (c(i4)) {
            e(i4, str, th);
        }
    }

    private void e(int i4, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i4, this.name, str);
    }

    @Override // org.slf4j.c
    public void debug(String str) {
        d(3, str, null);
    }

    @Override // org.slf4j.c
    public void error(String str) {
        d(6, str, null);
    }

    @Override // org.slf4j.c
    public void info(String str) {
        d(4, str, null);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return c(3);
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return c(6);
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return c(4);
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return c(2);
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return c(5);
    }

    @Override // org.slf4j.c
    public void trace(String str) {
        d(2, str, null);
    }

    @Override // org.slf4j.c
    public void warn(String str) {
        d(5, str, null);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj) {
        b(3, str, obj);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj) {
        b(6, str, obj);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj) {
        b(4, str, obj);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj) {
        b(2, str, obj);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj) {
        b(5, str, obj);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj, Object obj2) {
        b(3, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj, Object obj2) {
        b(6, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj, Object obj2) {
        b(4, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj, Object obj2) {
        b(2, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj, Object obj2) {
        b(5, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object... objArr) {
        b(3, str, objArr);
    }

    @Override // org.slf4j.c
    public void error(String str, Object... objArr) {
        b(6, str, objArr);
    }

    @Override // org.slf4j.c
    public void info(String str, Object... objArr) {
        b(4, str, objArr);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object... objArr) {
        b(2, str, objArr);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object... objArr) {
        b(5, str, objArr);
    }

    @Override // org.slf4j.c
    public void debug(String str, Throwable th) {
        d(2, str, th);
    }

    @Override // org.slf4j.c
    public void error(String str, Throwable th) {
        d(6, str, th);
    }

    @Override // org.slf4j.c
    public void info(String str, Throwable th) {
        d(4, str, th);
    }

    @Override // org.slf4j.c
    public void trace(String str, Throwable th) {
        d(2, str, th);
    }

    @Override // org.slf4j.c
    public void warn(String str, Throwable th) {
        d(5, str, th);
    }
}
