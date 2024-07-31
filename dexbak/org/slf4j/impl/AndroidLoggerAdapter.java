package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/* renamed from: org.slf4j.impl.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class AndroidLoggerAdapter extends MarkerIgnoringBase {
    private static final long serialVersionUID = -1227274521521287937L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidLoggerAdapter(String str) {
        this.name = str;
    }

    /* renamed from: b */
    private void m2561b(int i, String str, Object... objArr) {
        if (m2560c(i)) {
            FormattingTuple m2602a = MessageFormatter.m2602a(str, objArr);
            m2558e(i, m2602a.m2604b(), m2602a.m2603c());
        }
    }

    /* renamed from: c */
    private boolean m2560c(int i) {
        return Log.isLoggable(this.name, i);
    }

    /* renamed from: d */
    private void m2559d(int i, String str, Throwable th) {
        if (m2560c(i)) {
            m2558e(i, str, th);
        }
    }

    /* renamed from: e */
    private void m2558e(int i, String str, Throwable th) {
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        Log.println(i, this.name, str);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str) {
        m2559d(3, str, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str) {
        m2559d(6, str, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str) {
        m2559d(4, str, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isDebugEnabled() {
        return m2560c(3);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isErrorEnabled() {
        return m2560c(6);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isInfoEnabled() {
        return m2560c(4);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isTraceEnabled() {
        return m2560c(2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public boolean isWarnEnabled() {
        return m2560c(5);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str) {
        m2559d(2, str, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str) {
        m2559d(5, str, null);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object obj) {
        m2561b(3, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object obj) {
        m2561b(6, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object obj) {
        m2561b(4, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object obj) {
        m2561b(2, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object obj) {
        m2561b(5, str, obj);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object obj, Object obj2) {
        m2561b(3, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object obj, Object obj2) {
        m2561b(6, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object obj, Object obj2) {
        m2561b(4, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object obj, Object obj2) {
        m2561b(2, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object obj, Object obj2) {
        m2561b(5, str, obj, obj2);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Object... objArr) {
        m2561b(3, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Object... objArr) {
        m2561b(6, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Object... objArr) {
        m2561b(4, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Object... objArr) {
        m2561b(2, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Object... objArr) {
        m2561b(5, str, objArr);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void debug(String str, Throwable th) {
        m2559d(2, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void error(String str, Throwable th) {
        m2559d(6, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void info(String str, Throwable th) {
        m2559d(4, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void trace(String str, Throwable th) {
        m2559d(2, str, th);
    }

    @Override // org.slf4j.InterfaceC15424c
    public void warn(String str, Throwable th) {
        m2559d(5, str, th);
    }
}
