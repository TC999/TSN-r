package javax.activation;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MimeTypeParameterList {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private Hashtable parameters = new Hashtable();

    public MimeTypeParameterList() {
    }

    private static boolean isTokenChar(char c4) {
        return c4 > ' ' && c4 < '\u007f' && "()<>@,;:/[]?=\\\"".indexOf(c4) < 0;
    }

    private static String quote(String str) {
        int length = str.length();
        boolean z3 = false;
        for (int i4 = 0; i4 < length && !z3; i4++) {
            z3 = !isTokenChar(str.charAt(i4));
        }
        if (z3) {
            StringBuffer stringBuffer = new StringBuffer();
            double d4 = length;
            Double.isNaN(d4);
            stringBuffer.ensureCapacity((int) (d4 * 1.5d));
            stringBuffer.append('\"');
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = str.charAt(i5);
                if (charAt == '\\' || charAt == '\"') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(charAt);
            }
            stringBuffer.append('\"');
            return stringBuffer.toString();
        }
        return str;
    }

    private static int skipWhiteSpace(String str, int i4) {
        int length = str.length();
        while (i4 < length && Character.isWhitespace(str.charAt(i4))) {
            i4++;
        }
        return i4;
    }

    private static String unquote(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        boolean z3 = false;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (!z3 && charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (z3) {
                stringBuffer.append(charAt);
                z3 = false;
            } else {
                z3 = true;
            }
        }
        return stringBuffer.toString();
    }

    public String get(String str) {
        return (String) this.parameters.get(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public Enumeration getNames() {
        return this.parameters.keys();
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    protected void parse(String str) throws MimeTypeParseException {
        int length;
        int i4;
        String substring;
        if (str != null && (length = str.length()) > 0) {
            int skipWhiteSpace = skipWhiteSpace(str, 0);
            while (skipWhiteSpace < length && str.charAt(skipWhiteSpace) == ';') {
                int skipWhiteSpace2 = skipWhiteSpace(str, skipWhiteSpace + 1);
                if (skipWhiteSpace2 >= length) {
                    return;
                }
                int i5 = skipWhiteSpace2;
                while (i5 < length && isTokenChar(str.charAt(i5))) {
                    i5++;
                }
                String lowerCase = str.substring(skipWhiteSpace2, i5).toLowerCase(Locale.ENGLISH);
                int skipWhiteSpace3 = skipWhiteSpace(str, i5);
                if (skipWhiteSpace3 < length && str.charAt(skipWhiteSpace3) == '=') {
                    int skipWhiteSpace4 = skipWhiteSpace(str, skipWhiteSpace3 + 1);
                    if (skipWhiteSpace4 < length) {
                        char charAt = str.charAt(skipWhiteSpace4);
                        if (charAt == '\"') {
                            int i6 = skipWhiteSpace4 + 1;
                            if (i6 >= length) {
                                throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                            }
                            int i7 = i6;
                            while (i7 < length) {
                                charAt = str.charAt(i7);
                                if (charAt == '\"') {
                                    break;
                                }
                                if (charAt == '\\') {
                                    i7++;
                                }
                                i7++;
                            }
                            if (charAt == '\"') {
                                substring = unquote(str.substring(i6, i7));
                                i4 = i7 + 1;
                            } else {
                                throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                            }
                        } else if (isTokenChar(charAt)) {
                            i4 = skipWhiteSpace4;
                            while (i4 < length && isTokenChar(str.charAt(i4))) {
                                i4++;
                            }
                            substring = str.substring(skipWhiteSpace4, i4);
                        } else {
                            throw new MimeTypeParseException("Unexpected character encountered at index " + skipWhiteSpace4);
                        }
                        this.parameters.put(lowerCase, substring);
                        skipWhiteSpace = skipWhiteSpace(str, i4);
                    } else {
                        throw new MimeTypeParseException("Couldn't find a value for parameter named " + lowerCase);
                    }
                } else {
                    throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
                }
            }
            if (skipWhiteSpace < length) {
                throw new MimeTypeParseException("More characters encountered in input than expected.");
            }
        }
    }

    public void remove(String str) {
        this.parameters.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        this.parameters.put(str.trim().toLowerCase(Locale.ENGLISH), str2);
    }

    public int size() {
        return this.parameters.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(this.parameters.size() * 16);
        Enumeration keys = this.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            stringBuffer.append("; ");
            stringBuffer.append(str);
            stringBuffer.append('=');
            stringBuffer.append(quote((String) this.parameters.get(str)));
        }
        return stringBuffer.toString();
    }

    public MimeTypeParameterList(String str) throws MimeTypeParseException {
        parse(str);
    }
}
