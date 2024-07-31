package io.netty.util.internal.logging;

import io.netty.util.internal.StringUtil;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractInternalLogger implements InternalLogger, Serializable {
    private static final String EXCEPTION_MESSAGE = "Unexpected exception:";
    private static final long serialVersionUID = -6382972526573193470L;
    private final String name;

    /* renamed from: io.netty.util.internal.logging.AbstractInternalLogger$1 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static /* synthetic */ class C140911 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$util$internal$logging$InternalLogLevel;

        static {
            int[] iArr = new int[InternalLogLevel.values().length];
            $SwitchMap$io$netty$util$internal$logging$InternalLogLevel = iArr;
            try {
                iArr[InternalLogLevel.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractInternalLogger(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("name");
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(Throwable th) {
        debug(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(Throwable th) {
        error(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(Throwable th) {
        info(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isEnabled(InternalLogLevel internalLogLevel) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            return isErrorEnabled();
                        }
                        throw new Error();
                    }
                    return isWarnEnabled();
                }
                return isInfoEnabled();
            }
            return isDebugEnabled();
        }
        return isTraceEnabled();
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Throwable th) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i == 1) {
            trace(str, th);
        } else if (i == 2) {
            debug(str, th);
        } else if (i == 3) {
            info(str, th);
        } else if (i == 4) {
            warn(str, th);
        } else if (i == 5) {
            error(str, th);
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public String name() {
        return this.name;
    }

    protected Object readResolve() throws ObjectStreamException {
        return InternalLoggerFactory.getInstance(name());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + name() + ')';
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(Throwable th) {
        trace(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(Throwable th) {
        warn(EXCEPTION_MESSAGE, th);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, Throwable th) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i == 1) {
            trace(th);
        } else if (i == 2) {
            debug(th);
        } else if (i == 3) {
            info(th);
        } else if (i == 4) {
            warn(th);
        } else if (i == 5) {
            error(th);
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i == 1) {
            trace(str);
        } else if (i == 2) {
            debug(str);
        } else if (i == 3) {
            info(str);
        } else if (i == 4) {
            warn(str);
        } else if (i == 5) {
            error(str);
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Object obj) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i == 1) {
            trace(str, obj);
        } else if (i == 2) {
            debug(str, obj);
        } else if (i == 3) {
            info(str, obj);
        } else if (i == 4) {
            warn(str, obj);
        } else if (i == 5) {
            error(str, obj);
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Object obj, Object obj2) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i == 1) {
            trace(str, obj, obj2);
        } else if (i == 2) {
            debug(str, obj, obj2);
        } else if (i == 3) {
            info(str, obj, obj2);
        } else if (i == 4) {
            warn(str, obj, obj2);
        } else if (i == 5) {
            error(str, obj, obj2);
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel, String str, Object... objArr) {
        int i = C140911.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel.ordinal()];
        if (i == 1) {
            trace(str, objArr);
        } else if (i == 2) {
            debug(str, objArr);
        } else if (i == 3) {
            info(str, objArr);
        } else if (i == 4) {
            warn(str, objArr);
        } else if (i == 5) {
            error(str, objArr);
        } else {
            throw new Error();
        }
    }
}
