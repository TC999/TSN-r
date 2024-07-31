package io.netty.util;

import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private AtomicInteger nextId = new AtomicInteger(1);

    private String checkNotNullAndNotEmpty(String str) {
        ObjectUtil.checkNotNull(str, "name");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        return str;
    }

    private T createOrThrow(String str) {
        if (this.constants.get(str) == null) {
            T newConstant = newConstant(nextId(), str);
            if (this.constants.putIfAbsent(str, newConstant) == null) {
                return newConstant;
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is already in use", str));
    }

    private T getOrCreate(String str) {
        T t = this.constants.get(str);
        if (t == null) {
            T newConstant = newConstant(nextId(), str);
            T putIfAbsent = this.constants.putIfAbsent(str, newConstant);
            return putIfAbsent == null ? newConstant : putIfAbsent;
        }
        return t;
    }

    public boolean exists(String str) {
        checkNotNullAndNotEmpty(str);
        return this.constants.containsKey(str);
    }

    protected abstract T newConstant(int i, String str);

    public T newInstance(String str) {
        checkNotNullAndNotEmpty(str);
        return createOrThrow(str);
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public T valueOf(Class<?> cls, String str) {
        if (cls != null) {
            if (str != null) {
                return valueOf(cls.getName() + '#' + str);
            }
            throw new NullPointerException("secondNameComponent");
        }
        throw new NullPointerException("firstNameComponent");
    }

    public T valueOf(String str) {
        checkNotNullAndNotEmpty(str);
        return getOrCreate(str);
    }
}
