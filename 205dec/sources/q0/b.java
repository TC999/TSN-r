package q0;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b {
    private static Object a(double d4, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                double longValue = number.longValue();
                Double.isNaN(longValue);
                return Double.valueOf(d4 + longValue);
            } else if (number instanceof Float) {
                double floatValue = number.floatValue();
                Double.isNaN(floatValue);
                return Double.valueOf(d4 + floatValue);
            } else if (number instanceof Double) {
                return Double.valueOf(d4 + number.doubleValue());
            } else {
                throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
            }
        }
        double intValue = number.intValue();
        Double.isNaN(intValue);
        return Double.valueOf(d4 + intValue);
    }

    private static Object b(float f4, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Float.valueOf(f4 + ((float) number.longValue()));
            }
            if (number instanceof Float) {
                return Float.valueOf(f4 + number.floatValue());
            }
            if (number instanceof Double) {
                double d4 = f4;
                double doubleValue = number.doubleValue();
                Double.isNaN(d4);
                return Double.valueOf(d4 + doubleValue);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
        return Float.valueOf(f4 + number.intValue());
    }

    private static Object c(int i4, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(i4 + number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(i4 + number.floatValue());
            }
            if (number instanceof Double) {
                double d4 = i4;
                double doubleValue = number.doubleValue();
                Double.isNaN(d4);
                return Double.valueOf(d4 + doubleValue);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
        return Integer.valueOf(i4 + number.intValue());
    }

    private static Object d(long j4, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(j4 + number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(((float) j4) + number.floatValue());
            }
            if (number instanceof Double) {
                double d4 = j4;
                double doubleValue = number.doubleValue();
                Double.isNaN(d4);
                return Double.valueOf(d4 + doubleValue);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7684\u52a0\u64cd\u4f5c");
        }
        return Long.valueOf(j4 + number.intValue());
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
