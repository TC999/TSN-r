package com.qq.e.comm.dynamic;

import com.qq.e.comm.plugin.q.i;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class QuickJS implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private long f41610c;

    private QuickJS(long j4) {
        this.f41610c = j4;
    }

    public static QuickJS a() {
        long createContext;
        synchronized (QuickJS.class) {
            createContext = createContext();
        }
        if (createContext != 0) {
            return new QuickJS(createContext);
        }
        throw new OutOfMemoryError("Cannot create QuickJS instance");
    }

    private native Object call(long j4, long j5, Object obj, Object[] objArr);

    private native byte[] compile(long j4, String str, String str2);

    private static native long createContext();

    private native void destroyContext(long j4);

    private native Object evaluate(long j4, String str, String str2);

    private native Object execute(long j4, byte[] bArr);

    private native long get(long j4, String str, Object[] objArr);

    private native void set(long j4, String str, Object obj, Object[] objArr);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j4 = this.f41610c;
        if (j4 != 0) {
            this.f41610c = 0L;
            synchronized (QuickJS.class) {
                destroyContext(j4);
            }
        }
    }

    protected void finalize() {
        if (this.f41610c != 0) {
            i.b();
            Logger.getLogger(QuickJS.class.getName()).warning("QuickJS instance leaked!");
        }
    }

    public Object a(String str) {
        return evaluate(this.f41610c, str, "?");
    }

    public <T> void a(String str, Class<T> cls, T t3) {
        Method[] methods;
        if (cls.isInterface()) {
            if (cls.getInterfaces().length <= 0) {
                if (cls.isInstance(t3)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Method method : cls.getMethods()) {
                        if (linkedHashMap.put(method.getName(), method) != null) {
                            throw new UnsupportedOperationException(method.getName() + " is overloaded in " + cls);
                        }
                    }
                    set(this.f41610c, str, t3, linkedHashMap.values().toArray());
                    return;
                }
                throw new IllegalArgumentException(t3.getClass() + " is not an instance of " + cls);
            }
            throw new UnsupportedOperationException(cls + " must not extend other interfaces");
        }
        throw new UnsupportedOperationException("Only interfaces can be bound. Received: " + cls);
    }

    public byte[] a(String str, String str2) {
        return compile(this.f41610c, str, str2);
    }

    public Object a(byte[] bArr) {
        return execute(this.f41610c, bArr);
    }
}
