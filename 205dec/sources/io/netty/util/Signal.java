package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Signal extends Error implements Constant<Signal> {
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() { // from class: io.netty.util.Signal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.ConstantPool
        public Signal newConstant(int i4, String str) {
            return new Signal(i4, str);
        }
    };
    private static final long serialVersionUID = -221145131122459977L;
    private final SignalConstant constant;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class SignalConstant extends AbstractConstant<SignalConstant> {
        SignalConstant(int i4, String str) {
            super(i4, str);
        }
    }

    public static Signal valueOf(String str) {
        return pool.valueOf(str);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public void expect(Signal signal) {
        if (this == signal) {
            return;
        }
        throw new IllegalStateException("unexpected signal: " + signal);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // io.netty.util.Constant
    public int id() {
        return this.constant.id();
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        return this;
    }

    @Override // io.netty.util.Constant
    public String name() {
        return this.constant.name();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return name();
    }

    private Signal(int i4, String str) {
        this.constant = new SignalConstant(i4, str);
    }

    public static Signal valueOf(Class<?> cls, String str) {
        return pool.valueOf(cls, str);
    }

    @Override // java.lang.Comparable
    public int compareTo(Signal signal) {
        if (this == signal) {
            return 0;
        }
        return this.constant.compareTo(signal.constant);
    }
}
