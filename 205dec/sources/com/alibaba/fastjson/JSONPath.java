package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JSONPath implements JSONAware {
    private static int CACHE_SIZE = 1024;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private ParserConfig parserConfig;
    private final String path;
    private Segement[] segments;
    private SerializeConfig serializeConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ArrayAccessSegement implements Segement {
        private final int index;

        public ArrayAccessSegement(int i4) {
            this.index = i4;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class DoubleOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final double value;

        public DoubleOpSegement(String str, double d4, Operator operator) {
            this.propertyName = str;
            this.value = d4;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue != null && (propertyValue instanceof Number)) {
                double doubleValue = ((Number) propertyValue).doubleValue();
                Operator operator = this.op;
                return operator == Operator.EQ ? doubleValue == this.value : operator == Operator.NE ? doubleValue != this.value : operator == Operator.GE ? doubleValue >= this.value : operator == Operator.GT ? doubleValue > this.value : operator == Operator.LE ? doubleValue <= this.value : operator == Operator.LT && doubleValue < this.value;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class FilterSegement implements Segement {
        private final Filter filter;

        public FilterSegement(Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object obj3 : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                        jSONArray.add(obj3);
                    }
                }
                return jSONArray;
            } else if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long startValue;

        public IntBetweenSegement(String str, long j4, long j5, boolean z3) {
            this.propertyName = str;
            this.startValue = j4;
            this.endValue = j5;
            this.not = z3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                if (longValue >= this.startValue && longValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z3) {
            this.propertyName = str;
            this.values = jArr;
            this.not = z3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                for (long j4 : this.values) {
                    if (j4 == longValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z3) {
            this.propertyName = str;
            this.values = lArr;
            this.not = z3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i4 = 0;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i4 < length) {
                    if (lArr[i4] == null) {
                        return !this.not;
                    }
                    i4++;
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i4 < length2) {
                    Long l4 = lArr2[i4];
                    if (l4 != null && l4.longValue() == longValue) {
                        return !this.not;
                    }
                    i4++;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long value;

        public IntOpSegement(String str, long j4, Operator operator) {
            this.propertyName = str;
            this.value = j4;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue != null && (propertyValue instanceof Number)) {
                long longValue = ((Number) propertyValue).longValue();
                Operator operator = this.op;
                return operator == Operator.EQ ? longValue == this.value : operator == Operator.NE ? longValue != this.value : operator == Operator.GE ? longValue >= this.value : operator == Operator.GT ? longValue > this.value : operator == Operator.LE ? longValue <= this.value : operator == Operator.LT && longValue < this.value;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class JSONPathParser {
        private char ch;
        private int level;
        private final String path;
        private int pos;

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        static boolean isDigitFirst(char c4) {
            return c4 == '-' || c4 == '+' || (c4 >= '0' && c4 <= '9');
        }

        void accept(char c4) {
            if (this.ch == c4) {
                if (isEOF()) {
                    return;
                }
                next();
                return;
            }
            throw new JSONPathException("expect '" + c4 + ", but '" + this.ch + "'");
        }

        Segement buildArraySegement(String str) {
            int length = str.length();
            int i4 = 0;
            char charAt = str.charAt(0);
            int i5 = length - 1;
            char charAt2 = str.charAt(i5);
            int indexOf = str.indexOf(44);
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                if (indexOf == -1) {
                    return new PropertySegement(str.substring(1, i5), false);
                }
                String[] split = str.split(",");
                String[] strArr = new String[split.length];
                while (i4 < split.length) {
                    String str2 = split[i4];
                    strArr[i4] = str2.substring(1, str2.length() - 1);
                    i4++;
                }
                return new MultiPropertySegement(strArr);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegement(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegement(str, false);
                    }
                }
                return new PropertySegement(str, false);
            } else if (indexOf != -1) {
                String[] split2 = str.split(",");
                int[] iArr = new int[split2.length];
                while (i4 < split2.length) {
                    iArr[i4] = Integer.parseInt(split2[i4]);
                    i4++;
                }
                return new MultiIndexSegement(iArr);
            } else if (indexOf2 != -1) {
                String[] split3 = str.split(":");
                int length2 = split3.length;
                int[] iArr2 = new int[length2];
                for (int i6 = 0; i6 < split3.length; i6++) {
                    String str3 = split3[i6];
                    if (str3.length() != 0) {
                        iArr2[i6] = Integer.parseInt(str3);
                    } else if (i6 == 0) {
                        iArr2[i6] = 0;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                int i7 = iArr2[0];
                int i8 = length2 > 1 ? iArr2[1] : -1;
                int i9 = length2 == 3 ? iArr2[2] : 1;
                if (i8 < 0 || i8 >= i7) {
                    if (i9 > 0) {
                        return new RangeSegement(i7, i8, i9);
                    }
                    throw new UnsupportedOperationException("step must greater than zero : " + i9);
                }
                throw new UnsupportedOperationException("end must greater than or equals start. start " + i7 + ",  end " + i8);
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public Segement[] explain() {
            String str = this.path;
            if (str != null && str.length() != 0) {
                Segement[] segementArr = new Segement[8];
                while (true) {
                    Segement readSegement = readSegement();
                    if (readSegement == null) {
                        break;
                    }
                    int i4 = this.level;
                    if (i4 == segementArr.length) {
                        Segement[] segementArr2 = new Segement[(i4 * 3) / 2];
                        System.arraycopy(segementArr, 0, segementArr2, 0, i4);
                        segementArr = segementArr2;
                    }
                    int i5 = this.level;
                    this.level = i5 + 1;
                    segementArr[i5] = readSegement;
                }
                int i6 = this.level;
                if (i6 == segementArr.length) {
                    return segementArr;
                }
                Segement[] segementArr3 = new Segement[i6];
                System.arraycopy(segementArr, 0, segementArr3, 0, i6);
                return segementArr3;
            }
            throw new IllegalArgumentException();
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        void next() {
            String str = this.path;
            int i4 = this.pos;
            this.pos = i4 + 1;
            this.ch = str.charAt(i4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
            r0 = r14.pos;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.alibaba.fastjson.JSONPath.Segement parseArrayAccess(boolean r15) {
            /*
                Method dump skipped, instructions count: 1130
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.JSONPathParser.parseArrayAccess(boolean):com.alibaba.fastjson.JSONPath$Segement");
        }

        protected double readDoubleValue(long j4) {
            int i4 = this.pos - 1;
            next();
            while (true) {
                char c4 = this.ch;
                if (c4 < '0' || c4 > '9') {
                    break;
                }
                next();
            }
            double parseDouble = Double.parseDouble(this.path.substring(i4, this.pos - 1));
            double d4 = j4;
            Double.isNaN(d4);
            return parseDouble + d4;
        }

        protected long readLongValue() {
            int i4 = this.pos - 1;
            char c4 = this.ch;
            if (c4 == '+' || c4 == '-') {
                next();
            }
            while (true) {
                char c5 = this.ch;
                if (c5 < '0' || c5 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i4, this.pos - 1));
        }

        String readName() {
            skipWhitespace();
            char c4 = this.ch;
            if (c4 != '\\' && !IOUtils.firstIdentifier(c4)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb = new StringBuilder();
            while (!isEOF()) {
                char c5 = this.ch;
                if (c5 == '\\') {
                    next();
                    sb.append(this.ch);
                    if (isEOF()) {
                        break;
                    }
                    next();
                } else if (!IOUtils.isIdent(c5)) {
                    break;
                } else {
                    sb.append(this.ch);
                    next();
                }
            }
            if (isEOF() && IOUtils.isIdent(this.ch)) {
                sb.append(this.ch);
            }
            return sb.toString();
        }

        protected Operator readOp() {
            Operator operator;
            char c4 = this.ch;
            if (c4 == '=') {
                next();
                operator = Operator.EQ;
            } else if (c4 == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c4 == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c4 == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator == null) {
                String readName = readName();
                if ("not".equalsIgnoreCase(readName)) {
                    skipWhitespace();
                    String readName2 = readName();
                    if ("like".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_LIKE;
                    }
                    if ("rlike".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_RLIKE;
                    }
                    if ("in".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_IN;
                    }
                    if ("between".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_BETWEEN;
                    }
                    throw new UnsupportedOperationException();
                } else if ("like".equalsIgnoreCase(readName)) {
                    return Operator.LIKE;
                } else {
                    if ("rlike".equalsIgnoreCase(readName)) {
                        return Operator.RLIKE;
                    }
                    if ("in".equalsIgnoreCase(readName)) {
                        return Operator.IN;
                    }
                    if ("between".equalsIgnoreCase(readName)) {
                        return Operator.BETWEEN;
                    }
                    throw new UnsupportedOperationException();
                }
            }
            return operator;
        }

        Segement readSegement() {
            boolean z3 = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegement(this.ch - '0');
                }
                char c4 = this.ch;
                if ((c4 >= 'a' && c4 <= 'z') || (c4 >= 'A' && c4 <= 'Z')) {
                    return new PropertySegement(Character.toString(c4), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c5 = this.ch;
                if (c5 != '$') {
                    if (c5 != '.' && c5 != '/') {
                        if (c5 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new PropertySegement(readName(), false);
                        }
                        throw new UnsupportedOperationException();
                    }
                    next();
                    if (c5 == '.' && this.ch == '.') {
                        next();
                    } else {
                        z3 = false;
                    }
                    char c6 = this.ch;
                    if (c6 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return WildCardSegement.instance;
                    } else if (isDigitFirst(c6)) {
                        return parseArrayAccess(false);
                    } else {
                        String readName = readName();
                        if (this.ch == '(') {
                            next();
                            if (this.ch == ')') {
                                if (!isEOF()) {
                                    next();
                                }
                                if ("size".equals(readName)) {
                                    return SizeSegement.instance;
                                }
                                throw new UnsupportedOperationException();
                            }
                            throw new UnsupportedOperationException();
                        }
                        return new PropertySegement(readName, z3);
                    }
                }
                next();
            }
            return null;
        }

        String readString() {
            char c4 = this.ch;
            next();
            int i4 = this.pos - 1;
            while (this.ch != c4 && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i4, isEOF() ? this.pos : this.pos - 1);
            accept(c4);
            return substring;
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c4 = this.ch;
            if (c4 == '\"' || c4 == '\'') {
                return readString();
            }
            if (c4 == 'n') {
                if ("null".equals(readName())) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        public final void skipWhitespace() {
            while (true) {
                char c4 = this.ch;
                if (c4 > ' ') {
                    return;
                }
                if (c4 != ' ' && c4 != '\r' && c4 != '\n' && c4 != '\t' && c4 != '\f' && c4 != '\b') {
                    return;
                }
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z3) {
            this.propertyName = str;
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z3;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i4;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i4 = 0;
            } else if (!obj4.startsWith(str)) {
                return this.not;
            } else {
                i4 = this.startsWithValue.length() + 0;
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i4);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i4 = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            if (str3 != null && !obj4.endsWith(str3)) {
                return this.not;
            }
            return !this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class MultiIndexSegement implements Segement {
        private final int[] indexes;

        public MultiIndexSegement(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.indexes.length);
            int i4 = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i4 >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getArrayItem(obj2, iArr[i4]));
                i4++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class MultiPropertySegement implements Segement {
        private final String[] propertyNames;

        public MultiPropertySegement(String[] strArr) {
            this.propertyNames = strArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            for (String str : this.propertyNames) {
                arrayList.add(jSONPath.getPropertyValue(obj2, str, true));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class NotNullSegement implements Filter {
        private final String propertyName;

        public NotNullSegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, false) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class NullSegement implements Filter {
        private final String propertyName;

        public NullSegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, false) == null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class PropertySegement implements Segement {
        private final boolean deep;
        private final String propertyName;

        public PropertySegement(String str, boolean z3) {
            this.propertyName = str;
            this.deep = z3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                ArrayList arrayList = new ArrayList();
                jSONPath.deepScan(obj2, this.propertyName, arrayList);
                return arrayList;
            }
            return jSONPath.getPropertyValue(obj2, this.propertyName, true);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, obj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class RangeSegement implements Segement {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegement(int i4, int i5, int i6) {
            this.start = i4;
            this.end = i5;
            this.step = i6;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegement.instance.eval(jSONPath, obj, obj2).intValue();
            int i4 = this.start;
            if (i4 < 0) {
                i4 += intValue;
            }
            int i5 = this.end;
            if (i5 < 0) {
                i5 += intValue;
            }
            int i6 = ((i5 - i4) / this.step) + 1;
            if (i6 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i6);
            while (i4 <= i5 && i4 < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i4));
                i4 += this.step;
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;

        public RlikeSegement(String str, String str2, boolean z3) {
            this.propertyName = str;
            this.pattern = Pattern.compile(str2);
            this.not = z3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !matches : matches;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        SizeSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z3) {
            this.propertyName = str;
            this.values = strArr;
            this.not = z3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            String[] strArr;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            for (String str : this.values) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            Operator operator = this.op;
            if (operator == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (operator == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            Operator operator2 = this.op;
            return operator2 == Operator.GE ? compareTo <= 0 : operator2 == Operator.GT ? compareTo < 0 : operator2 == Operator.LE ? compareTo >= 0 : operator2 == Operator.LT && compareTo > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ValueSegment implements Filter {
        private boolean eq;
        private final String propertyName;
        private final Object value;

        public ValueSegment(String str, Object obj, boolean z3) {
            this.eq = true;
            if (obj != null) {
                this.propertyName = str;
                this.value = obj;
                this.eq = z3;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, false));
            return !this.eq ? !equals : equals;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        WildCardSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValues(obj2);
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public static JSONPath compile(String str) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath == null) {
                JSONPath jSONPath2 = new JSONPath(str);
                if (pathCache.size() < CACHE_SIZE) {
                    pathCache.putIfAbsent(str, jSONPath2);
                    return pathCache.get(str);
                }
                return jSONPath2;
            }
            return jSONPath;
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return eqNotNull((Number) obj, (Number) obj2);
            }
            return false;
        }
        return obj.equals(obj2);
    }

    static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(number2.longValue()));
            }
        }
        if (isInt) {
            if (isInt2) {
                return number.longValue() == number2.longValue();
            } else if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(number2.longValue()));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        return ((isDouble && isDouble2) || ((isDouble && isInt2) || (isDouble2 && isInt))) && number.doubleValue() == number2.doubleValue();
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        Object obj2 = null;
        int i4 = 0;
        Object obj3 = obj;
        int i5 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i5 >= segementArr.length) {
                break;
            }
            if (i5 == segementArr.length - 1) {
                obj2 = obj3;
            }
            obj3 = segementArr[i5].eval(this, obj, obj3);
            i5++;
        }
        if (obj3 != null) {
            if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i4 < length) {
                    collection.add(objArr[i4]);
                    i4++;
                }
                return;
            }
            Class<?> cls = obj3.getClass();
            if (cls.isArray()) {
                int length2 = Array.getLength(obj3);
                Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                System.arraycopy(obj3, 0, newInstance, 0, length2);
                while (i4 < objArr.length) {
                    Array.set(newInstance, length2 + i4, objArr[i4]);
                    i4++;
                }
                Segement[] segementArr2 = this.segments;
                Segement segement = segementArr2[segementArr2.length - 1];
                if (segement instanceof PropertySegement) {
                    ((PropertySegement) segement).setValue(this, obj2, newInstance);
                    return;
                } else if (segement instanceof ArrayAccessSegement) {
                    ((ArrayAccessSegement) segement).setValue(this, obj2, newInstance);
                    return;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            throw new JSONException("unsupported array put operation. " + cls);
        }
        throw new JSONPathException("value not found in path " + this.path);
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i4 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i4 >= segementArr.length) {
                return true;
            }
            obj2 = segementArr[i4].eval(this, obj, obj2);
            if (obj2 == null) {
                return false;
            }
            i4++;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (eval instanceof Iterable) {
            for (Object obj3 : (Iterable) eval) {
                if (eq(obj3, obj2)) {
                    return true;
                }
            }
            return false;
        }
        return eq(eval, obj2);
    }

    protected void deepScan(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                list.add(map.get(str));
                return;
            }
            for (Object obj2 : map.values()) {
                deepScan(obj2, str, list);
            }
            return;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                if (fieldSerializer != null) {
                    try {
                        try {
                            list.add(fieldSerializer.getPropertyValueDirect(obj));
                            return;
                        } catch (IllegalAccessException e4) {
                            throw new JSONException("getFieldValue error." + str, e4);
                        }
                    } catch (InvocationTargetException e5) {
                        throw new JSONException("getFieldValue error." + str, e5);
                    }
                }
                for (Object obj3 : javaBeanSerializer.getFieldValues(obj)) {
                    deepScan(obj3, str, list);
                }
            } catch (Exception e6) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e6);
            }
        } else if (obj instanceof List) {
            List list2 = (List) obj;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                deepScan(list2.get(i4), str, list);
            }
        }
    }

    protected void deepSet(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            }
            for (Object obj3 : map.values()) {
                deepSet(obj3, str, obj2);
            }
            return;
        }
        Class<?> cls = obj.getClass();
        JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer != null) {
            try {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer != null) {
                    fieldDeserializer.setValue(obj, obj2);
                    return;
                }
                for (Object obj4 : getJavaBeanSerializer(cls).getObjectFieldValues(obj)) {
                    deepSet(obj4, str, obj2);
                }
            } catch (Exception e4) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e4);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i4 = 0; i4 < list.size(); i4++) {
                deepSet(list.get(i4), str, obj2);
            }
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i4 = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i4 >= segementArr.length) {
                return obj2;
            }
            obj2 = segementArr[i4].eval(this, obj, obj2);
            i4++;
        }
    }

    int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i4 = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i4++;
                }
            }
            return i4;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e4) {
            throw new JSONPathException("evalSize error : " + this.path, e4);
        }
    }

    protected Object getArrayItem(Object obj, int i4) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i4 >= 0) {
                if (i4 < list.size()) {
                    return list.get(i4);
                }
                return null;
            } else if (Math.abs(i4) <= list.size()) {
                return list.get(list.size() + i4);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i4 >= 0) {
                if (i4 < length) {
                    return Array.get(obj, i4);
                }
                return null;
            } else if (Math.abs(i4) <= length) {
                return Array.get(obj, length + i4);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i4));
            return obj2 == null ? map.get(Integer.toString(i4)) : obj2;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    protected JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    protected Object getPropertyValue(Object obj, String str, boolean z3) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            return (obj2 == null && "size".equals(str)) ? Integer.valueOf(map.size()) : obj2;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj, str);
            } catch (Exception e4) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e4);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if ("size".equals(str)) {
                return Integer.valueOf(list.size());
            }
            JSONArray jSONArray = new JSONArray(list.size());
            for (int i4 = 0; i4 < list.size(); i4++) {
                Object propertyValue = getPropertyValue(list.get(i4), str, z3);
                if (propertyValue instanceof Collection) {
                    jSONArray.addAll((Collection) propertyValue);
                } else {
                    jSONArray.add(propertyValue);
                }
            }
            return jSONArray;
        } else {
            if (obj instanceof Enum) {
                Enum r7 = (Enum) obj;
                if ("name".equals(str)) {
                    return r7.name();
                }
                if ("ordinal".equals(str)) {
                    return Integer.valueOf(r7.ordinal());
                }
            }
            if (obj instanceof Calendar) {
                Calendar calendar = (Calendar) obj;
                if ("year".equals(str)) {
                    return Integer.valueOf(calendar.get(1));
                }
                if ("month".equals(str)) {
                    return Integer.valueOf(calendar.get(2));
                }
                if ("day".equals(str)) {
                    return Integer.valueOf(calendar.get(5));
                }
                if ("hour".equals(str)) {
                    return Integer.valueOf(calendar.get(11));
                }
                if ("minute".equals(str)) {
                    return Integer.valueOf(calendar.get(12));
                }
                if ("second".equals(str)) {
                    return Integer.valueOf(calendar.get(13));
                }
            }
            throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str);
        }
    }

    protected Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e4) {
                throw new JSONPathException("jsonpath error, path " + this.path, e4);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    protected void init() {
        if (this.segments != null) {
            return;
        }
        if ("*".equals(this.path)) {
            this.segments = new Segement[]{WildCardSegement.instance};
        } else {
            this.segments = new JSONPathParser(this.path).explain();
        }
    }

    public boolean remove(Object obj) {
        boolean z3 = false;
        if (obj == null) {
            return false;
        }
        init();
        Collection<Object> collection = null;
        Object obj2 = obj;
        int i4 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i4 >= segementArr.length) {
                break;
            } else if (i4 == segementArr.length - 1) {
                collection = obj2;
                break;
            } else {
                obj2 = segementArr[i4].eval(this, obj, obj2);
                if (obj2 == null) {
                    break;
                }
                i4++;
            }
        }
        if (collection == null) {
            return false;
        }
        Segement[] segementArr2 = this.segments;
        Segement segement = segementArr2[segementArr2.length - 1];
        if (segement instanceof PropertySegement) {
            PropertySegement propertySegement = (PropertySegement) segement;
            if ((collection instanceof Collection) && segementArr2.length > 1) {
                Segement segement2 = segementArr2[segementArr2.length - 2];
                if ((segement2 instanceof RangeSegement) || (segement2 instanceof MultiIndexSegement)) {
                    for (Object obj3 : collection) {
                        if (propertySegement.remove(this, obj3)) {
                            z3 = true;
                        }
                    }
                    return z3;
                }
            }
            return propertySegement.remove(this, collection);
        } else if (segement instanceof ArrayAccessSegement) {
            return ((ArrayAccessSegement) segement).remove(this, collection);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i4) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i4 >= 0) {
                if (i4 >= list.size()) {
                    return false;
                }
                list.remove(i4);
                return true;
            }
            int size = list.size() + i4;
            if (size < 0) {
                return false;
            }
            list.remove(size);
            return true;
        }
        Class<?> cls = obj.getClass();
        throw new JSONPathException("unsupported set operation." + cls);
    }

    protected boolean removePropertyValue(Object obj, String str) {
        if (obj instanceof Map) {
            return ((Map) obj).remove(str) != null;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer != null) {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer == null) {
                return false;
            }
            fieldDeserializer.setValue(obj, (String) null);
            return true;
        }
        throw new UnsupportedOperationException();
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i4, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i4 >= 0) {
                list.set(i4, obj2);
            } else {
                list.set(list.size() + i4, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (i4 >= 0) {
                if (i4 < length) {
                    Array.set(obj, i4, obj2);
                }
            } else if (Math.abs(i4) <= length) {
                Array.set(obj, length + i4, obj2);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + cls);
    }

    protected boolean setPropertyValue(Object obj, String str, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        } else if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, obj2);
                }
            }
            return true;
        } else {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer == null) {
                    return false;
                }
                fieldDeserializer.setValue(obj, obj2);
                return true;
            }
            throw new UnsupportedOperationException();
        }
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i4 = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i4 < segementArr.length) {
                obj2 = segementArr[i4].eval(this, obj, obj2);
                i4++;
            } else {
                return evalSize(obj2);
            }
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str != null && str.length() != 0) {
            this.path = str;
            this.serializeConfig = serializeConfig;
            this.parserConfig = parserConfig;
            return;
        }
        throw new JSONPathException("json-path can not be null or empty");
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        paths(identityHashMap, TTPathConst.sSeparator, obj, serializeConfig);
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : identityHashMap.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean set(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r8 = this;
            r11 = 0
            if (r9 != 0) goto L4
            return r11
        L4:
            r8.init()
            r0 = 0
            r2 = r9
            r3 = r0
            r1 = 0
        Lb:
            com.alibaba.fastjson.JSONPath$Segement[] r4 = r8.segments
            int r5 = r4.length
            r6 = 1
            if (r1 >= r5) goto L86
            r3 = r4[r1]
            java.lang.Object r4 = r3.eval(r8, r9, r2)
            if (r4 != 0) goto L81
            com.alibaba.fastjson.JSONPath$Segement[] r4 = r8.segments
            int r5 = r4.length
            int r5 = r5 - r6
            if (r1 >= r5) goto L24
            int r5 = r1 + 1
            r4 = r4[r5]
            goto L25
        L24:
            r4 = r0
        L25:
            boolean r5 = r4 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r5 == 0) goto L61
            boolean r4 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r4 == 0) goto L4b
            r4 = r3
            com.alibaba.fastjson.JSONPath$PropertySegement r4 = (com.alibaba.fastjson.JSONPath.PropertySegement) r4
            java.lang.String r4 = com.alibaba.fastjson.JSONPath.PropertySegement.access$000(r4)
            java.lang.Class r5 = r2.getClass()
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r5)
            if (r5 == 0) goto L4b
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r5.getFieldDeserializer(r4)
            com.alibaba.fastjson.util.FieldInfo r4 = r4.fieldInfo
            java.lang.Class<?> r4 = r4.fieldClass
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r4)
            goto L4d
        L4b:
            r4 = r0
            r5 = r4
        L4d:
            if (r5 == 0) goto L5b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r5.beanInfo
            java.lang.reflect.Constructor<?> r7 = r7.defaultConstructor
            if (r7 == 0) goto L5a
            java.lang.Object r4 = r5.createInstance(r0, r4)
            goto L6c
        L5a:
            return r11
        L5b:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
            goto L6c
        L61:
            boolean r4 = r4 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegement
            if (r4 == 0) goto L6b
            com.alibaba.fastjson.JSONArray r4 = new com.alibaba.fastjson.JSONArray
            r4.<init>()
            goto L6c
        L6b:
            r4 = r0
        L6c:
            if (r4 == 0) goto L87
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r5 == 0) goto L78
            com.alibaba.fastjson.JSONPath$PropertySegement r3 = (com.alibaba.fastjson.JSONPath.PropertySegement) r3
            r3.setValue(r8, r2, r4)
            goto L81
        L78:
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegement
            if (r5 == 0) goto L87
            com.alibaba.fastjson.JSONPath$ArrayAccessSegement r3 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegement) r3
            r3.setValue(r8, r2, r4)
        L81:
            int r1 = r1 + 1
            r3 = r2
            r2 = r4
            goto Lb
        L86:
            r2 = r3
        L87:
            if (r2 != 0) goto L8a
            return r11
        L8a:
            com.alibaba.fastjson.JSONPath$Segement[] r9 = r8.segments
            int r11 = r9.length
            int r11 = r11 - r6
            r9 = r9[r11]
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.PropertySegement
            if (r11 == 0) goto L9a
            com.alibaba.fastjson.JSONPath$PropertySegement r9 = (com.alibaba.fastjson.JSONPath.PropertySegement) r9
            r9.setValue(r8, r2, r10)
            return r6
        L9a:
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegement
            if (r11 == 0) goto La5
            com.alibaba.fastjson.JSONPath$ArrayAccessSegement r9 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegement) r9
            boolean r9 = r9.setValue(r8, r2, r10)
            return r9
        La5:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            r9.<init>()
            goto Lac
        Lab:
            throw r9
        Lac:
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.set(java.lang.Object, java.lang.Object, boolean):boolean");
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    private static void paths(Map<Object, String> map, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj == null || map.containsKey(obj)) {
            return;
        }
        map.put(obj, str);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals(TTPathConst.sSeparator)) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append(TTPathConst.sSeparator);
                    sb4.append(key);
                    paths(map, sb4.toString(), entry.getValue(), serializeConfig);
                }
            }
            return;
        }
        int i4 = 0;
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals(TTPathConst.sSeparator)) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append(TTPathConst.sSeparator);
                sb3.append(i4);
                paths(map, sb3.toString(), obj2, serializeConfig);
                i4++;
            }
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            while (i4 < length) {
                Object obj3 = Array.get(obj, i4);
                if (str.equals(TTPathConst.sSeparator)) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                }
                sb2.append(TTPathConst.sSeparator);
                sb2.append(i4);
                paths(map, sb2.toString(), obj3, serializeConfig);
                i4++;
            }
        } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
            ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
            if (objectWriter instanceof JavaBeanSerializer) {
                try {
                    for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                        String key2 = entry2.getKey();
                        if (key2 instanceof String) {
                            if (str.equals(TTPathConst.sSeparator)) {
                                sb = new StringBuilder();
                                sb.append(TTPathConst.sSeparator);
                                sb.append(key2);
                            } else {
                                sb = new StringBuilder();
                                sb.append(str);
                                sb.append(TTPathConst.sSeparator);
                                sb.append(key2);
                            }
                            paths(map, sb.toString(), entry2.getValue(), serializeConfig);
                        }
                    }
                } catch (Exception e4) {
                    throw new JSONException("toJSON error", e4);
                }
            }
        }
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }
}
