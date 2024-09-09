package q0;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class g {
    private static boolean a(double d4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return d4 == ((double) number.intValue());
        } else if (number instanceof Long) {
            return d4 == ((double) number.longValue());
        } else if (number instanceof Float) {
            return d4 == ((double) number.floatValue());
        } else if (number instanceof Double) {
            return d4 == number.doubleValue();
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    private static boolean b(float f4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return f4 == ((float) number.intValue());
        } else if (number instanceof Long) {
            return f4 == ((float) number.longValue());
        } else if (number instanceof Float) {
            return f4 == number.floatValue();
        } else if (number instanceof Double) {
            return ((double) f4) == number.doubleValue();
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    private static boolean c(int i4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return i4 == number.intValue();
        } else if (number instanceof Long) {
            return ((long) i4) == number.longValue();
        } else if (number instanceof Float) {
            return ((float) i4) == number.floatValue();
        } else if (number instanceof Double) {
            return ((double) i4) == number.doubleValue();
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    private static boolean d(long j4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return j4 == ((long) number.intValue());
        } else if (number instanceof Long) {
            return j4 == number.longValue();
        } else if (number instanceof Float) {
            return ((float) j4) == number.floatValue();
        } else if (number instanceof Double) {
            return ((double) j4) == number.doubleValue();
        } else {
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
    }

    public static boolean e(Number number, Number number2) {
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
