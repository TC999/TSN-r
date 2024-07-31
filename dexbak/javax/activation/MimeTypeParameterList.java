package javax.activation;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MimeTypeParameterList {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private Hashtable parameters = new Hashtable();

    public MimeTypeParameterList() {
    }

    private static boolean isTokenChar(char c) {
        return c > ' ' && c < 127 && TSPECIALS.indexOf(c) < 0;
    }

    private static String quote(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length && !z; i++) {
            z = !isTokenChar(str.charAt(i));
        }
        if (z) {
            StringBuffer stringBuffer = new StringBuffer();
            double d = length;
            Double.isNaN(d);
            stringBuffer.ensureCapacity((int) (d * 1.5d));
            stringBuffer.append('\"');
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
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

    private static int skipWhiteSpace(String str, int i) {
        int length = str.length();
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static String unquote(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!z && charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (z) {
                stringBuffer.append(charAt);
                z = false;
            } else {
                z = true;
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
        int i;
        String substring;
        if (str != null && (length = str.length()) > 0) {
            int skipWhiteSpace = skipWhiteSpace(str, 0);
            while (skipWhiteSpace < length && str.charAt(skipWhiteSpace) == ';') {
                int skipWhiteSpace2 = skipWhiteSpace(str, skipWhiteSpace + 1);
                if (skipWhiteSpace2 >= length) {
                    return;
                }
                int i2 = skipWhiteSpace2;
                while (i2 < length && isTokenChar(str.charAt(i2))) {
                    i2++;
                }
                String lowerCase = str.substring(skipWhiteSpace2, i2).toLowerCase(Locale.ENGLISH);
                int skipWhiteSpace3 = skipWhiteSpace(str, i2);
                if (skipWhiteSpace3 < length && str.charAt(skipWhiteSpace3) == '=') {
                    int skipWhiteSpace4 = skipWhiteSpace(str, skipWhiteSpace3 + 1);
                    if (skipWhiteSpace4 < length) {
                        char charAt = str.charAt(skipWhiteSpace4);
                        if (charAt == '\"') {
                            int i3 = skipWhiteSpace4 + 1;
                            if (i3 >= length) {
                                throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                            }
                            int i4 = i3;
                            while (i4 < length) {
                                charAt = str.charAt(i4);
                                if (charAt == '\"') {
                                    break;
                                }
                                if (charAt == '\\') {
                                    i4++;
                                }
                                i4++;
                            }
                            if (charAt == '\"') {
                                substring = unquote(str.substring(i3, i4));
                                i = i4 + 1;
                            } else {
                                throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
                            }
                        } else if (isTokenChar(charAt)) {
                            i = skipWhiteSpace4;
                            while (i < length && isTokenChar(str.charAt(i))) {
                                i++;
                            }
                            substring = str.substring(skipWhiteSpace4, i);
                        } else {
                            throw new MimeTypeParseException("Unexpected character encountered at index " + skipWhiteSpace4);
                        }
                        this.parameters.put(lowerCase, substring);
                        skipWhiteSpace = skipWhiteSpace(str, i);
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
