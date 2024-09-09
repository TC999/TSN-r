package org.slf4j.helpers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class NOPLogger extends MarkerIgnoringBase {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();
    private static final long serialVersionUID = -517220405410904473L;

    protected NOPLogger() {
    }

    @Override // org.slf4j.c
    public final void debug(String str) {
    }

    @Override // org.slf4j.c
    public final void debug(String str, Object obj) {
    }

    @Override // org.slf4j.c
    public final void debug(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.c
    public final void debug(String str, Throwable th) {
    }

    @Override // org.slf4j.c
    public final void debug(String str, Object... objArr) {
    }

    @Override // org.slf4j.c
    public final void error(String str) {
    }

    @Override // org.slf4j.c
    public final void error(String str, Object obj) {
    }

    @Override // org.slf4j.c
    public final void error(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.c
    public final void error(String str, Throwable th) {
    }

    @Override // org.slf4j.c
    public final void error(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.g, org.slf4j.c
    public String getName() {
        return "NOP";
    }

    @Override // org.slf4j.c
    public final void info(String str) {
    }

    @Override // org.slf4j.c
    public final void info(String str, Object obj) {
    }

    @Override // org.slf4j.c
    public final void info(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.c
    public final void info(String str, Throwable th) {
    }

    @Override // org.slf4j.c
    public final void info(String str, Object... objArr) {
    }

    @Override // org.slf4j.c
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.c
    public final void trace(String str) {
    }

    @Override // org.slf4j.c
    public final void trace(String str, Object obj) {
    }

    @Override // org.slf4j.c
    public final void trace(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.c
    public final void trace(String str, Throwable th) {
    }

    @Override // org.slf4j.c
    public final void trace(String str, Object... objArr) {
    }

    @Override // org.slf4j.c
    public final void warn(String str) {
    }

    @Override // org.slf4j.c
    public final void warn(String str, Object obj) {
    }

    @Override // org.slf4j.c
    public final void warn(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.c
    public final void warn(String str, Throwable th) {
    }

    @Override // org.slf4j.c
    public final void warn(String str, Object... objArr) {
    }
}