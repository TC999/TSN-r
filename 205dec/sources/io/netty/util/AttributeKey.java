package io.netty.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() { // from class: io.netty.util.AttributeKey.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.ConstantPool
        public AttributeKey<Object> newConstant(int i4, String str) {
            return new AttributeKey<>(i4, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> AttributeKey<T> newInstance(String str) {
        return (AttributeKey<T>) pool.newInstance(str);
    }

    public static <T> AttributeKey<T> valueOf(String str) {
        return (AttributeKey<T>) pool.valueOf(str);
    }

    private AttributeKey(int i4, String str) {
        super(i4, str);
    }

    public static <T> AttributeKey<T> valueOf(Class<?> cls, String str) {
        return (AttributeKey<T>) pool.valueOf(cls, str);
    }
}
