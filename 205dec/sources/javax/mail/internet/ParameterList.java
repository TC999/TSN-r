package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ParameterList {
    private static boolean applehack;
    private static boolean decodeParameters;
    private static boolean decodeParametersStrict;
    private static boolean encodeParameters;
    private static final char[] hex;
    private String lastName;
    private Map list;
    private Set multisegmentNames;
    private Map slist;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class MultiValue extends ArrayList {
        String value;

        private MultiValue() {
        }

        /* synthetic */ MultiValue(MultiValue multiValue) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class ParamEnum implements Enumeration {
        private Iterator it;

        ParamEnum(Iterator it) {
            this.it = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.it.hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class ToStringBuffer {
        private StringBuffer sb = new StringBuffer();
        private int used;

        public ToStringBuffer(int i4) {
            this.used = i4;
        }

        public void addNV(String str, String str2) {
            int lastIndexOf;
            String quote = ParameterList.quote(str2);
            this.sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + quote.length() + 1 > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuffer stringBuffer = this.sb;
            stringBuffer.append(str);
            stringBuffer.append('=');
            int length = this.used + str.length() + 1;
            this.used = length;
            if (length + quote.length() > 76) {
                String fold = MimeUtility.fold(this.used, quote);
                this.sb.append(fold);
                if (fold.lastIndexOf(10) >= 0) {
                    this.used += (fold.length() - lastIndexOf) - 1;
                    return;
                } else {
                    this.used += fold.length();
                    return;
                }
            }
            this.sb.append(quote);
            this.used += quote.length();
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class Value {
        String charset;
        String encodedValue;
        String value;

        private Value() {
        }

        /* synthetic */ Value(Value value) {
            this();
        }
    }

    static {
        try {
            String property = System.getProperty("mail.mime.encodeparameters");
            boolean z3 = true;
            encodeParameters = property != null && property.equalsIgnoreCase("true");
            String property2 = System.getProperty("mail.mime.decodeparameters");
            decodeParameters = property2 != null && property2.equalsIgnoreCase("true");
            String property3 = System.getProperty("mail.mime.decodeparameters.strict");
            decodeParametersStrict = property3 != null && property3.equalsIgnoreCase("true");
            String property4 = System.getProperty("mail.mime.applefilenames");
            if (property4 == null || !property4.equalsIgnoreCase("true")) {
                z3 = false;
            }
            applehack = z3;
        } catch (SecurityException unused) {
        }
        hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00eb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void combineMultisegmentNames(boolean r13) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.combineMultisegmentNames(boolean):void");
    }

    private static String decodeBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i4 = 0;
        int i5 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (charAt == '%') {
                charAt = (char) Integer.parseInt(str.substring(i4 + 1, i4 + 3), 16);
                i4 += 2;
            }
            bArr[i5] = (byte) charAt;
            i4++;
            i5++;
        }
        return new String(bArr, 0, i5, MimeUtility.javaCharset(str2));
    }

    private static Value decodeValue(String str) throws ParseException {
        int indexOf;
        Value value = new Value(null);
        value.encodedValue = str;
        value.value = str;
        try {
            indexOf = str.indexOf(39);
        } catch (UnsupportedEncodingException e4) {
            if (decodeParametersStrict) {
                throw new ParseException(e4.toString());
            }
        } catch (NumberFormatException e5) {
            if (decodeParametersStrict) {
                throw new ParseException(e5.toString());
            }
        } catch (StringIndexOutOfBoundsException e6) {
            if (decodeParametersStrict) {
                throw new ParseException(e6.toString());
            }
        }
        if (indexOf <= 0) {
            if (decodeParametersStrict) {
                throw new ParseException("Missing charset in encoded value: " + str);
            }
            return value;
        }
        String substring = str.substring(0, indexOf);
        int i4 = indexOf + 1;
        int indexOf2 = str.indexOf(39, i4);
        if (indexOf2 < 0) {
            if (decodeParametersStrict) {
                throw new ParseException("Missing language in encoded value: " + str);
            }
            return value;
        }
        str.substring(i4, indexOf2);
        String substring2 = str.substring(indexOf2 + 1);
        value.charset = substring;
        value.value = decodeBytes(substring2, substring);
        return value;
    }

    private static Value encodeValue(String str, String str2) {
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b4 : bytes) {
                char c4 = (char) (b4 & 255);
                if (c4 > ' ' && c4 < '\u007f' && c4 != '*' && c4 != '\'' && c4 != '%' && "()<>@,;:\\\"\t []/?=".indexOf(c4) < 0) {
                    stringBuffer.append(c4);
                } else {
                    stringBuffer.append('%');
                    char[] cArr = hex;
                    stringBuffer.append(cArr[c4 >> 4]);
                    stringBuffer.append(cArr[c4 & 15]);
                }
            }
            Value value = new Value(null);
            value.charset = str2;
            value.value = str;
            value.encodedValue = stringBuffer.toString();
            return value;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void putEncodedName(String str, String str2) throws ParseException {
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            this.list.put(str, str2);
        } else if (indexOf == str.length() - 1) {
            this.list.put(str.substring(0, indexOf), decodeValue(str2));
        } else {
            String substring = str.substring(0, indexOf);
            this.multisegmentNames.add(substring);
            this.list.put(substring, "");
            if (str.endsWith("*")) {
                Value value = new Value(null);
                value.encodedValue = str2;
                value.value = str2;
                str = str.substring(0, str.length() - 1);
                str2 = value;
            }
            this.slist.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String quote(String str) {
        return MimeUtility.quote(str, "()<>@,;:\\\"\t []/?=");
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        if (obj instanceof MultiValue) {
            return ((MultiValue) obj).value;
        }
        if (obj instanceof Value) {
            return ((Value) obj).value;
        }
        return (String) obj;
    }

    public Enumeration getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        if (str == null && str2 != null && str2.equals("DONE")) {
            if (!decodeParameters || this.multisegmentNames.size() <= 0) {
                return;
            }
            try {
                combineMultisegmentNames(true);
                return;
            } catch (ParseException unused) {
                return;
            }
        }
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        if (decodeParameters) {
            try {
                putEncodedName(lowerCase, str2);
                return;
            } catch (ParseException unused2) {
                this.list.put(lowerCase, str2);
                return;
            }
        }
        this.list.put(lowerCase, str2);
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i4) {
        ToStringBuffer toStringBuffer = new ToStringBuffer(i4);
        for (String str : this.list.keySet()) {
            Object obj = this.list.get(str);
            if (obj instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) obj;
                String str2 = String.valueOf(str) + "*";
                for (int i5 = 0; i5 < multiValue.size(); i5++) {
                    Object obj2 = multiValue.get(i5);
                    if (obj2 instanceof Value) {
                        toStringBuffer.addNV(String.valueOf(str2) + i5 + "*", ((Value) obj2).encodedValue);
                    } else {
                        toStringBuffer.addNV(String.valueOf(str2) + i5, (String) obj2);
                    }
                }
            } else if (obj instanceof Value) {
                toStringBuffer.addNV(String.valueOf(str) + "*", ((Value) obj).encodedValue);
            } else {
                toStringBuffer.addNV(str, (String) obj);
            }
        }
        return toStringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (javax.mail.internet.ParameterList.decodeParameters == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        combineMultisegmentNames(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0125, code lost:
        throw new javax.mail.internet.ParseException("Expected ';', got \"" + r8.getValue() + "\"");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ParameterList(java.lang.String r8) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value encodeValue = encodeValue(str2, str3);
            if (encodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), encodeValue);
                return;
            } else {
                set(str, str2);
                return;
            }
        }
        set(str, str2);
    }
}
