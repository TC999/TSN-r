package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.QDecoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MimeUtility {
    public static final int ALL = -1;
    static final int ALL_ASCII = 1;
    static final int MOSTLY_ASCII = 2;
    static final int MOSTLY_NONASCII = 3;
    private static boolean decodeStrict = true;
    private static String defaultJavaCharset = null;
    private static String defaultMIMECharset = null;
    private static boolean encodeEolStrict = false;
    private static boolean foldEncodedWords = false;
    private static boolean foldText = true;
    private static Hashtable java2mime;
    private static Hashtable mime2java;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.sun.mail.util.LineInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    static {
        ?? r1;
        Throwable th;
        try {
            String property = System.getProperty("mail.mime.decodetext.strict");
            boolean z = false;
            decodeStrict = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.encodeeol.strict");
            encodeEolStrict = property2 != null && property2.equalsIgnoreCase("true");
            String property3 = System.getProperty("mail.mime.foldencodedwords");
            foldEncodedWords = property3 != null && property3.equalsIgnoreCase("true");
            String property4 = System.getProperty("mail.mime.foldtext");
            if (property4 == null || !property4.equalsIgnoreCase("false")) {
                z = true;
            }
            foldText = z;
        } catch (SecurityException unused) {
        }
        java2mime = new Hashtable(40);
        mime2java = new Hashtable(10);
        try {
            InputStream resourceAsStream = MimeUtility.class.getResourceAsStream("/META-INF/javamail.charset.map");
            if (resourceAsStream != null) {
                try {
                    r1 = new LineInputStream(resourceAsStream);
                } catch (Throwable th2) {
                    r1 = resourceAsStream;
                    th = th2;
                }
                try {
                    loadMappings(r1, java2mime);
                    loadMappings(r1, mime2java);
                    r1.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        r1.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused3) {
        }
        if (java2mime.isEmpty()) {
            java2mime.put("8859_1", "ISO-8859-1");
            java2mime.put("iso8859_1", "ISO-8859-1");
            java2mime.put("iso8859-1", "ISO-8859-1");
            java2mime.put("8859_2", "ISO-8859-2");
            java2mime.put("iso8859_2", "ISO-8859-2");
            java2mime.put("iso8859-2", "ISO-8859-2");
            java2mime.put("8859_3", "ISO-8859-3");
            java2mime.put("iso8859_3", "ISO-8859-3");
            java2mime.put("iso8859-3", "ISO-8859-3");
            java2mime.put("8859_4", "ISO-8859-4");
            java2mime.put("iso8859_4", "ISO-8859-4");
            java2mime.put("iso8859-4", "ISO-8859-4");
            java2mime.put("8859_5", "ISO-8859-5");
            java2mime.put("iso8859_5", "ISO-8859-5");
            java2mime.put("iso8859-5", "ISO-8859-5");
            java2mime.put("8859_6", "ISO-8859-6");
            java2mime.put("iso8859_6", "ISO-8859-6");
            java2mime.put("iso8859-6", "ISO-8859-6");
            java2mime.put("8859_7", "ISO-8859-7");
            java2mime.put("iso8859_7", "ISO-8859-7");
            java2mime.put("iso8859-7", "ISO-8859-7");
            java2mime.put("8859_8", "ISO-8859-8");
            java2mime.put("iso8859_8", "ISO-8859-8");
            java2mime.put("iso8859-8", "ISO-8859-8");
            java2mime.put("8859_9", "ISO-8859-9");
            java2mime.put("iso8859_9", "ISO-8859-9");
            java2mime.put("iso8859-9", "ISO-8859-9");
            java2mime.put("sjis", "Shift_JIS");
            java2mime.put("jis", "ISO-2022-JP");
            java2mime.put("iso2022jp", "ISO-2022-JP");
            java2mime.put("euc_jp", "euc-jp");
            java2mime.put("koi8_r", "koi8-r");
            java2mime.put("euc_cn", "euc-cn");
            java2mime.put("euc_tw", "euc-tw");
            java2mime.put("euc_kr", "euc-kr");
        }
        if (mime2java.isEmpty()) {
            mime2java.put("iso-2022-cn", "ISO2022CN");
            mime2java.put("iso-2022-kr", "ISO2022KR");
            mime2java.put("utf-8", "UTF8");
            mime2java.put("utf8", "UTF8");
            mime2java.put("ja_jp.iso2022-7", "ISO2022JP");
            mime2java.put("ja_jp.eucjp", "EUCJIS");
            mime2java.put("euc-kr", "KSC5601");
            mime2java.put("euckr", "KSC5601");
            mime2java.put("us-ascii", "ISO-8859-1");
            mime2java.put("x-us-ascii", "ISO-8859-1");
        }
    }

    private MimeUtility() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkAscii(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (nonascii(str.charAt(i3))) {
                i++;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i2 > i ? 2 : 3;
    }

    public static InputStream decode(InputStream inputStream, String str) throws MessagingException {
        if (str.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE)) {
            return new QPDecoderStream(inputStream);
        }
        if (!str.equalsIgnoreCase("uuencode") && !str.equalsIgnoreCase("x-uuencode") && !str.equalsIgnoreCase("x-uue")) {
            if (str.equalsIgnoreCase(HttpHeaders.Values.BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
                return inputStream;
            }
            throw new MessagingException("Unknown encoding: " + str);
        }
        return new UUDecoderStream(inputStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String decodeInnerWords(java.lang.String r5) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
        L6:
            java.lang.String r2 = "=?"
            int r2 = r5.indexOf(r2, r1)
            if (r2 >= 0) goto Lf
            goto L34
        Lf:
            java.lang.String r3 = r5.substring(r1, r2)
            r0.append(r3)
            int r3 = r2 + 2
            r4 = 63
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L21
            goto L34
        L21:
            int r3 = r3 + 1
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L2a
            goto L34
        L2a:
            int r3 = r3 + 1
            java.lang.String r4 = "?="
            int r3 = r5.indexOf(r4, r3)
            if (r3 >= 0) goto L49
        L34:
            if (r1 != 0) goto L37
            return r5
        L37:
            int r2 = r5.length()
            if (r1 >= r2) goto L44
            java.lang.String r5 = r5.substring(r1)
            r0.append(r5)
        L44:
            java.lang.String r5 = r0.toString()
            return r5
        L49:
            int r1 = r3 + 2
            java.lang.String r2 = r5.substring(r2, r1)
            java.lang.String r2 = decodeWord(r2)     // Catch: javax.mail.internet.ParseException -> L53
        L53:
            r0.append(r2)
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.decodeInnerWords(java.lang.String):java.lang.String");
    }

    public static String decodeText(String str) throws UnsupportedEncodingException {
        if (str.indexOf("=?") == -1) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n\r", true);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            char charAt = nextToken.charAt(0);
            if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                try {
                    String decodeWord = decodeWord(nextToken);
                    if (!z && stringBuffer2.length() > 0) {
                        stringBuffer.append(stringBuffer2);
                    }
                    nextToken = decodeWord;
                    z = true;
                } catch (ParseException unused) {
                    if (!decodeStrict) {
                        String decodeInnerWords = decodeInnerWords(nextToken);
                        if (decodeInnerWords != nextToken) {
                            if ((!z || !nextToken.startsWith("=?")) && stringBuffer2.length() > 0) {
                                stringBuffer.append(stringBuffer2);
                            }
                            z = nextToken.endsWith("?=");
                            nextToken = decodeInnerWords;
                        } else if (stringBuffer2.length() > 0) {
                            stringBuffer.append(stringBuffer2);
                        }
                    } else if (stringBuffer2.length() > 0) {
                        stringBuffer.append(stringBuffer2);
                    }
                    z = false;
                }
                stringBuffer.append(nextToken);
                stringBuffer2.setLength(0);
            } else {
                stringBuffer2.append(charAt);
            }
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    public static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        InputStream qDecoderStream;
        if (str.startsWith("=?")) {
            int indexOf = str.indexOf(63, 2);
            if (indexOf != -1) {
                String javaCharset = javaCharset(str.substring(2, indexOf));
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(63, i);
                if (indexOf2 != -1) {
                    String substring = str.substring(i, indexOf2);
                    int i2 = indexOf2 + 1;
                    int indexOf3 = str.indexOf("?=", i2);
                    if (indexOf3 != -1) {
                        String substring2 = str.substring(i2, indexOf3);
                        try {
                            String str2 = "";
                            if (substring2.length() > 0) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ASCIIUtility.getBytes(substring2));
                                if (substring.equalsIgnoreCase("B")) {
                                    qDecoderStream = new BASE64DecoderStream(byteArrayInputStream);
                                } else if (substring.equalsIgnoreCase("Q")) {
                                    qDecoderStream = new QDecoderStream(byteArrayInputStream);
                                } else {
                                    throw new UnsupportedEncodingException("unknown encoding: " + substring);
                                }
                                int available = byteArrayInputStream.available();
                                byte[] bArr = new byte[available];
                                int read = qDecoderStream.read(bArr, 0, available);
                                if (read > 0) {
                                    str2 = new String(bArr, 0, read, javaCharset);
                                }
                            }
                            int i3 = indexOf3 + 2;
                            if (i3 < str.length()) {
                                String substring3 = str.substring(i3);
                                if (!decodeStrict) {
                                    substring3 = decodeInnerWords(substring3);
                                }
                                return str2 + substring3;
                            }
                            return str2;
                        } catch (UnsupportedEncodingException e) {
                            throw e;
                        } catch (IOException e2) {
                            throw new ParseException(e2.toString());
                        } catch (IllegalArgumentException unused) {
                            throw new UnsupportedEncodingException(javaCharset);
                        }
                    }
                    throw new ParseException("encoded word does not end with \"?=\": " + str);
                }
                throw new ParseException("encoded word does not include encoding: " + str);
            }
            throw new ParseException("encoded word does not include charset: " + str);
        }
        throw new ParseException("encoded word does not start with \"=?\": " + str);
    }

    private static void doEncode(String str, boolean z, String str2, int i, String str3, boolean z2, boolean z3, StringBuffer stringBuffer) throws UnsupportedEncodingException {
        int encodedLength;
        OutputStream qEncoderStream;
        int length;
        byte[] bytes = str.getBytes(str2);
        if (z) {
            encodedLength = BEncoderStream.encodedLength(bytes);
        } else {
            encodedLength = QEncoderStream.encodedLength(bytes, z3);
        }
        if (encodedLength > i && (length = str.length()) > 1) {
            int i2 = length / 2;
            doEncode(str.substring(0, i2), z, str2, i, str3, z2, z3, stringBuffer);
            doEncode(str.substring(i2, length), z, str2, i, str3, false, z3, stringBuffer);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            qEncoderStream = new BEncoderStream(byteArrayOutputStream);
        } else {
            qEncoderStream = new QEncoderStream(byteArrayOutputStream, z3);
        }
        try {
            qEncoderStream.write(bytes);
            qEncoderStream.close();
        } catch (IOException unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!z2) {
            if (foldEncodedWords) {
                stringBuffer.append("\r\n ");
            } else {
                stringBuffer.append(" ");
            }
        }
        stringBuffer.append(str3);
        for (byte b : byteArray) {
            stringBuffer.append((char) b);
        }
        stringBuffer.append("?=");
    }

    public static OutputStream encode(OutputStream outputStream, String str) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE)) {
            return new QPEncoderStream(outputStream);
        }
        if (!str.equalsIgnoreCase("uuencode") && !str.equalsIgnoreCase("x-uuencode") && !str.equalsIgnoreCase("x-uue")) {
            if (str.equalsIgnoreCase(HttpHeaders.Values.BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
                return outputStream;
            }
            throw new MessagingException("Unknown encoding: " + str);
        }
        return new UUEncoderStream(outputStream);
    }

    public static String encodeText(String str) throws UnsupportedEncodingException {
        return encodeText(str, null, null);
    }

    public static String encodeWord(String str) throws UnsupportedEncodingException {
        return encodeWord(str, null, null);
    }

    public static String fold(int i, String str) {
        char charAt;
        if (foldText) {
            int length = str.length() - 1;
            while (length >= 0 && ((charAt = str.charAt(length)) == ' ' || charAt == '\t' || charAt == '\r' || charAt == '\n')) {
                length--;
            }
            if (length != str.length() - 1) {
                str = str.substring(0, length + 1);
            }
            if (str.length() + i <= 76) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer(str.length() + 4);
            int i2 = i;
            String str2 = str;
            char c = 0;
            while (true) {
                if (str2.length() + i2 <= 76) {
                    break;
                }
                int i3 = 0;
                int i4 = -1;
                while (i3 < str2.length() && (i4 == -1 || i2 + i3 <= 76)) {
                    char charAt2 = str2.charAt(i3);
                    if ((charAt2 == ' ' || charAt2 == '\t') && c != ' ' && c != '\t') {
                        i4 = i3;
                    }
                    i3++;
                    c = charAt2;
                }
                if (i4 == -1) {
                    stringBuffer.append(str2);
                    str2 = "";
                    break;
                }
                stringBuffer.append(str2.substring(0, i4));
                stringBuffer.append("\r\n");
                c = str2.charAt(i4);
                stringBuffer.append(c);
                str2 = str2.substring(i4 + 1);
                i2 = 1;
            }
            stringBuffer.append(str2);
            return stringBuffer.toString();
        }
        return str;
    }

    public static String getDefaultJavaCharset() {
        if (defaultJavaCharset == null) {
            String str = null;
            try {
                str = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
            if (str != null && str.length() > 0) {
                String javaCharset = javaCharset(str);
                defaultJavaCharset = javaCharset;
                return javaCharset;
            }
            try {
                defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
            } catch (SecurityException unused2) {
                String encoding = new InputStreamReader(new InputStream() { // from class: javax.mail.internet.MimeUtility.1NullInputStream
                    @Override // java.io.InputStream
                    public int read() {
                        return 0;
                    }
                }).getEncoding();
                defaultJavaCharset = encoding;
                if (encoding == null) {
                    defaultJavaCharset = "8859_1";
                }
            }
        }
        return defaultJavaCharset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    public static String getEncoding(DataSource dataSource) {
        String str = HttpHeaders.Values.BASE64;
        try {
            ContentType contentType = new ContentType(dataSource.getContentType());
            InputStream inputStream = dataSource.getInputStream();
            int checkAscii = checkAscii(inputStream, -1, !contentType.match("text/*"));
            if (checkAscii == 1) {
                str = "7bit";
            } else if (checkAscii == 2) {
                str = HttpHeaders.Values.QUOTED_PRINTABLE;
            }
            inputStream.close();
        } catch (IOException | Exception unused) {
        }
        return str;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    public static String javaCharset(String str) {
        String str2;
        Hashtable hashtable = mime2java;
        return (hashtable == null || str == null || (str2 = (String) hashtable.get(str.toLowerCase(Locale.ENGLISH))) == null) ? str : str2;
    }

    private static void loadMappings(LineInputStream lineInputStream, Hashtable hashtable) {
        while (true) {
            try {
                String readLine = lineInputStream.readLine();
                if (readLine == null) {
                    return;
                }
                if (readLine.startsWith("--") && readLine.endsWith("--")) {
                    return;
                }
                if (readLine.trim().length() != 0 && !readLine.startsWith("#")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                    try {
                        String nextToken = stringTokenizer.nextToken();
                        hashtable.put(nextToken.toLowerCase(Locale.ENGLISH), stringTokenizer.nextToken());
                    } catch (NoSuchElementException unused) {
                    }
                }
            } catch (IOException unused2) {
                return;
            }
        }
    }

    public static String mimeCharset(String str) {
        String str2;
        Hashtable hashtable = java2mime;
        return (hashtable == null || str == null || (str2 = (String) hashtable.get(str.toLowerCase(Locale.ENGLISH))) == null) ? str : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean nonascii(int i) {
        if (i < 127) {
            return (i >= 32 || i == 13 || i == 10 || i == 9) ? false : true;
        }
        return true;
    }

    public static String quote(String str, String str2) {
        int length = str.length();
        char c = 0;
        int i = 0;
        boolean z = false;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '\"' && charAt != '\\' && charAt != '\r' && charAt != '\n') {
                if (charAt < ' ' || charAt >= 127 || str2.indexOf(charAt) >= 0) {
                    z = true;
                }
                i++;
            } else {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                stringBuffer.append(str.substring(0, i));
                while (i < length) {
                    char charAt2 = str.charAt(i);
                    if ((charAt2 == '\"' || charAt2 == '\\' || charAt2 == '\r' || charAt2 == '\n') && (charAt2 != '\n' || c != '\r')) {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
                    i++;
                    c = charAt2;
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
        }
        if (z) {
            StringBuffer stringBuffer2 = new StringBuffer(length + 2);
            stringBuffer2.append('\"');
            stringBuffer2.append(str);
            stringBuffer2.append('\"');
            return stringBuffer2.toString();
        }
        return str;
    }

    public static String unfold(String str) {
        char charAt;
        char charAt2;
        if (foldText) {
            StringBuffer stringBuffer = null;
            while (true) {
                int indexOfAny = indexOfAny(str, "\r\n");
                if (indexOfAny < 0) {
                    break;
                }
                int length = str.length();
                int i = indexOfAny + 1;
                if (i < length && str.charAt(i - 1) == '\r' && str.charAt(i) == '\n') {
                    i++;
                }
                if (indexOfAny != 0) {
                    int i2 = indexOfAny - 1;
                    if (str.charAt(i2) == '\\') {
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer(str.length());
                        }
                        stringBuffer.append(str.substring(0, i2));
                        stringBuffer.append(str.substring(indexOfAny, i));
                        str = str.substring(i);
                    }
                }
                if (i < length && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
                    while (true) {
                        i++;
                        if (i >= length || ((charAt2 = str.charAt(i)) != ' ' && charAt2 != '\t')) {
                            break;
                        }
                    }
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(str.length());
                    }
                    if (indexOfAny != 0) {
                        stringBuffer.append(str.substring(0, indexOfAny));
                        stringBuffer.append(HttpConstants.SP_CHAR);
                    }
                    str = str.substring(i);
                } else {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(str.length());
                    }
                    stringBuffer.append(str.substring(0, i));
                    str = str.substring(i);
                }
            }
            if (stringBuffer != null) {
                stringBuffer.append(str);
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    public static String encodeText(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, false);
    }

    public static String encodeWord(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, true);
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            while (i < length) {
                if (str2.indexOf(str.charAt(i)) >= 0) {
                    return i;
                }
                i++;
            }
            return -1;
        } catch (StringIndexOutOfBoundsException unused) {
            return -1;
        }
    }

    static int checkAscii(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            if (nonascii(b & UByte.f41242c)) {
                i++;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i2 > i ? 2 : 3;
    }

    private static String encodeWord(String str, String str2, String str3, boolean z) throws UnsupportedEncodingException {
        String javaCharset;
        boolean z2;
        int checkAscii = checkAscii(str);
        if (checkAscii == 1) {
            return str;
        }
        if (str2 == null) {
            javaCharset = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            javaCharset = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = checkAscii != 3 ? "Q" : "B";
        }
        if (str3.equalsIgnoreCase("B")) {
            z2 = true;
        } else if (!str3.equalsIgnoreCase("Q")) {
            throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
        } else {
            z2 = false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 68 - str2.length();
        doEncode(str, z2, javaCharset, length, "=?" + str2 + "?" + str3 + "?", true, z, stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int checkAscii(java.io.InputStream r16, int r17, boolean r18) {
        /*
            r0 = r17
            boolean r1 = javax.mail.internet.MimeUtility.encodeEolStrict
            r3 = 0
            if (r1 == 0) goto Lb
            if (r18 == 0) goto Lb
            r1 = 1
            goto Lc
        Lb:
            r1 = 0
        Lc:
            r4 = 0
            r5 = -1
            r6 = 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L1c
            if (r0 != r5) goto L15
            goto L1a
        L15:
            int r4 = java.lang.Math.min(r0, r6)
            r6 = r4
        L1a:
            byte[] r4 = new byte[r6]
        L1c:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L21:
            if (r0 != 0) goto L24
            goto L6b
        L24:
            r13 = r16
            int r14 = r13.read(r4, r3, r6)     // Catch: java.io.IOException -> L6a
            if (r14 != r5) goto L2d
            goto L6b
        L2d:
            r15 = 0
        L2e:
            if (r15 < r14) goto L35
            if (r0 == r5) goto L33
            int r0 = r0 - r14
        L33:
            r3 = 0
            goto L21
        L35:
            r5 = r4[r15]     // Catch: java.io.IOException -> L6a
            r5 = r5 & 255(0xff, float:3.57E-43)
            r2 = 10
            r12 = 13
            if (r1 == 0) goto L48
            if (r3 != r12) goto L43
            if (r5 != r2) goto L47
        L43:
            if (r3 == r12) goto L48
            if (r5 != r2) goto L48
        L47:
            r9 = 1
        L48:
            if (r5 == r12) goto L55
            if (r5 != r2) goto L4d
            goto L55
        L4d:
            int r11 = r11 + 1
            r2 = 998(0x3e6, float:1.398E-42)
            if (r11 <= r2) goto L56
            r10 = 1
            goto L56
        L55:
            r11 = 0
        L56:
            boolean r2 = nonascii(r5)     // Catch: java.io.IOException -> L6a
            if (r2 == 0) goto L63
            if (r18 == 0) goto L60
            r2 = 3
            return r2
        L60:
            int r8 = r8 + 1
            goto L65
        L63:
            int r7 = r7 + 1
        L65:
            int r15 = r15 + 1
            r3 = r5
            r5 = -1
            goto L2e
        L6a:
        L6b:
            if (r0 != 0) goto L71
            if (r18 == 0) goto L71
            r0 = 3
            return r0
        L71:
            r0 = 3
            r1 = 2
            if (r8 != 0) goto L7d
            if (r9 == 0) goto L78
            return r0
        L78:
            if (r10 == 0) goto L7b
            return r1
        L7b:
            r0 = 1
            return r0
        L7d:
            if (r7 <= r8) goto L80
            return r1
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.checkAscii(java.io.InputStream, int, boolean):int");
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                AsciiOutputStream asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException unused) {
                }
                int ascii = asciiOutputStream.getAscii();
                if (ascii != 1) {
                    return ascii != 2 ? HttpHeaders.Values.BASE64 : HttpHeaders.Values.QUOTED_PRINTABLE;
                }
            } else {
                AsciiOutputStream asciiOutputStream2 = new AsciiOutputStream(true, encodeEolStrict);
                try {
                    dataHandler.writeTo(asciiOutputStream2);
                } catch (IOException unused2) {
                }
                if (asciiOutputStream2.getAscii() != 1) {
                    return HttpHeaders.Values.BASE64;
                }
            }
            return "7bit";
        } catch (Exception unused3) {
            return HttpHeaders.Values.BASE64;
        }
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.BASE64)) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase(HttpHeaders.Values.QUOTED_PRINTABLE)) {
            return new QPEncoderStream(outputStream);
        }
        if (!str.equalsIgnoreCase("uuencode") && !str.equalsIgnoreCase("x-uuencode") && !str.equalsIgnoreCase("x-uue")) {
            if (str.equalsIgnoreCase(HttpHeaders.Values.BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
                return outputStream;
            }
            throw new MessagingException("Unknown encoding: " + str);
        }
        return new UUEncoderStream(outputStream, str2);
    }
}
