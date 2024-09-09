package q0;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class h {
    private static Object a(double d4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(d4 > ((double) number.intValue()));
        } else if (number instanceof Long) {
            return Boolean.valueOf(d4 > ((double) number.longValue()));
        } else if (number instanceof Float) {
            return Boolean.valueOf(d4 > ((double) number.floatValue()));
        } else if (number instanceof Double) {
            return Boolean.valueOf(d4 > number.doubleValue());
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    private static Object b(float f4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(f4 > ((float) number.intValue()));
        } else if (number instanceof Long) {
            return Boolean.valueOf(f4 > ((float) number.longValue()));
        } else if (number instanceof Float) {
            return Boolean.valueOf(f4 > number.floatValue());
        } else if (number instanceof Double) {
            return Boolean.valueOf(((double) f4) > number.doubleValue());
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    private static Object c(int i4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(i4 > number.intValue());
        } else if (number instanceof Long) {
            return Boolean.valueOf(((long) i4) > number.longValue());
        } else if (number instanceof Float) {
            return Boolean.valueOf(((float) i4) > number.floatValue());
        } else if (number instanceof Double) {
            return Boolean.valueOf(((double) i4) > number.doubleValue());
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    private static Object d(long j4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(j4 > ((long) number.intValue()));
        } else if (number instanceof Long) {
            return Boolean.valueOf(j4 > number.longValue());
        } else if (number instanceof Float) {
            return Boolean.valueOf(((float) j4) > number.floatValue());
        } else if (number instanceof Double) {
            return Boolean.valueOf(((double) j4) > number.doubleValue());
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    public static Object e(Number number, Number number2) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return d(number.longValue(), number2);
            }
            if (number instanceof Float) {
                return b(number.floatValue(), number2);
            }
            if (number instanceof Double) {
                return a(number.doubleValue(), number2);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
        return c(number.intValue(), number2);
    }
}
