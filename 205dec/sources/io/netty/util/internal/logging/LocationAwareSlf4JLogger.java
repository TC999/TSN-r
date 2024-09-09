package io.netty.util.internal.logging;

import l3.a;
import org.slf4j.helpers.c;
import org.slf4j.helpers.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class LocationAwareSlf4JLogger extends AbstractInternalLogger {
    static final String FQCN = LocationAwareSlf4JLogger.class.getName();
    private static final long serialVersionUID = -8292030083201538180L;
    private final transient a logger;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationAwareSlf4JLogger(a aVar) {
        super(aVar.getName());
        this.logger = aVar;
    }

    private void log(int i4, String str) {
        this.logger.a(null, FQCN, i4, str, null, null);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str) {
        if (isDebugEnabled()) {
            log(10, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str) {
        if (isErrorEnabled()) {
            log(40, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str) {
        if (isInfoEnabled()) {
            log(20, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str) {
        if (isTraceEnabled()) {
            log(0, str);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str) {
        if (isWarnEnabled()) {
            log(30, str);
        }
    }

    private void log(int i4, String str, Throwable th) {
        this.logger.a(null, FQCN, i4, str, null, th);
    }

    private void log(int i4, c cVar) {
        this.logger.a(null, FQCN, i4, cVar.b(), cVar.a(), cVar.c());
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj) {
        if (isDebugEnabled()) {
            log(10, d.i(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        if (isErrorEnabled()) {
            log(40, d.i(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj) {
        if (isInfoEnabled()) {
            log(20, d.i(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            log(0, d.i(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        if (isWarnEnabled()) {
            log(30, d.i(str, obj));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj, Object obj2) {
        if (isDebugEnabled()) {
            log(10, d.j(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        if (isErrorEnabled()) {
            log(40, d.j(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj, Object obj2) {
        if (isInfoEnabled()) {
            log(20, d.j(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            log(0, d.j(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object... objArr) {
        if (isWarnEnabled()) {
            log(30, d.a(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object... objArr) {
        if (isDebugEnabled()) {
            log(10, d.a(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object... objArr) {
        if (isErrorEnabled()) {
            log(40, d.a(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object... objArr) {
        if (isInfoEnabled()) {
            log(20, d.a(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object... objArr) {
        if (isTraceEnabled()) {
            log(0, d.a(str, objArr));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        if (isWarnEnabled()) {
            log(30, d.j(str, obj, obj2));
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Throwable th) {
        if (isDebugEnabled()) {
            log(10, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        if (isErrorEnabled()) {
            log(40, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Throwable th) {
        if (isInfoEnabled()) {
            log(20, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Throwable th) {
        if (isTraceEnabled()) {
            log(0, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Throwable th) {
        if (isWarnEnabled()) {
            log(30, str, th);
        }
    }
}
