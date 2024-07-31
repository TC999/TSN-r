package javax.mail.internet;

import io.netty.handler.codec.http.HttpConstants;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.mail.Address;
import javax.mail.Session;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class InternetAddress extends Address implements Cloneable {
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace((char) HttpConstants.SP_CHAR, (char) 0).replace('\t', (char) 0);
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    protected String address;
    protected String encodedPersonal;
    protected String personal;

    public InternetAddress() {
    }

    private static void checkAddress(String str, boolean z, boolean z2) throws AddressException {
        String str2;
        String str3;
        if (str.indexOf(34) >= 0) {
            return;
        }
        int i = 0;
        if (z) {
            while (true) {
                int indexOfAny = indexOfAny(str, ",:", i);
                if (indexOfAny < 0) {
                    break;
                } else if (str.charAt(i) == '@') {
                    if (str.charAt(indexOfAny) == ':') {
                        i = indexOfAny + 1;
                        break;
                    }
                    i = indexOfAny + 1;
                } else {
                    throw new AddressException("Illegal route-addr", str);
                }
            }
        }
        int indexOf = str.indexOf(64, i);
        if (indexOf >= 0) {
            if (indexOf != i) {
                if (indexOf != str.length() - 1) {
                    str3 = str.substring(i, indexOf);
                    str2 = str.substring(indexOf + 1);
                } else {
                    throw new AddressException("Missing domain", str);
                }
            } else {
                throw new AddressException("Missing local name", str);
            }
        } else if (z2) {
            throw new AddressException("Missing final '@domain'", str);
        } else {
            str2 = null;
            str3 = str;
        }
        if (indexOfAny(str, " \t\n\r") < 0) {
            if (indexOfAny(str3, specialsNoDot) < 0) {
                if (str2 != null && str2.indexOf(91) < 0 && indexOfAny(str2, specialsNoDot) >= 0) {
                    throw new AddressException("Illegal character in domain", str);
                }
                return;
            }
            throw new AddressException("Illegal character in local name", str);
        }
        throw new AddressException("Illegal whitespace in address", str);
    }

    public static InternetAddress getLocalAddress(Session session) {
        String property;
        String str;
        String str2;
        String property2;
        String property3;
        InetAddress localHost;
        try {
            if (session == null) {
                str = System.getProperty("user.name");
                str2 = InetAddress.getLocalHost().getHostName();
                property = null;
            } else {
                property = session.getProperty("mail.from");
                if (property == null) {
                    String property4 = session.getProperty("mail.user");
                    if (property4 == null || property4.length() == 0) {
                        property4 = session.getProperty("user.name");
                    }
                    if (property4 != null && property4.length() != 0) {
                        property2 = property4;
                        property3 = session.getProperty("mail.host");
                        if ((property3 != null || property3.length() == 0) && (localHost = InetAddress.getLocalHost()) != null) {
                            property3 = localHost.getHostName();
                        }
                        String str3 = property2;
                        str2 = property3;
                        str = str3;
                    }
                    property2 = System.getProperty("user.name");
                    property3 = session.getProperty("mail.host");
                    if (property3 != null) {
                    }
                    property3 = localHost.getHostName();
                    String str32 = property2;
                    str2 = property3;
                    str = str32;
                } else {
                    str = null;
                    str2 = null;
                }
            }
            if (property == null && str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                property = str + "@" + str2;
            }
            if (property != null) {
                return new InternetAddress(property);
            }
        } catch (SecurityException | UnknownHostException | AddressException unused) {
        }
        return null;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private boolean isSimple() {
        String str = this.address;
        return str == null || indexOfAny(str, specialsNoDotNoAt) < 0;
    }

    private static int lengthOfFirstSegment(String str) {
        int indexOf = str.indexOf("\r\n");
        return indexOf != -1 ? indexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i) {
        int lastIndexOf = str.lastIndexOf("\r\n");
        if (lastIndexOf != -1) {
            return (str.length() - lastIndexOf) - 2;
        }
        return str.length() + i;
    }

    public static InternetAddress[] parse(String str) throws AddressException {
        return parse(str, true);
    }

    public static InternetAddress[] parseHeader(String str, boolean z) throws AddressException {
        return parse(str, z, true);
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\"' && charAt != '\\') {
                if ((charAt < ' ' && charAt != '\r' && charAt != '\n' && charAt != '\t') || charAt >= 127 || rfc822phrase.indexOf(charAt) >= 0) {
                    z = true;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 == '\"' || charAt2 == '\\') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
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

    private static String unquote(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            String substring = str.substring(1, str.length() - 1);
            if (substring.indexOf(92) >= 0) {
                StringBuffer stringBuffer = new StringBuffer(substring.length());
                int i = 0;
                while (i < substring.length()) {
                    char charAt = substring.charAt(i);
                    if (charAt == '\\' && i < substring.length() - 1) {
                        i++;
                        charAt = substring.charAt(i);
                    }
                    stringBuffer.append(charAt);
                    i++;
                }
                return stringBuffer.toString();
            }
            return substring;
        }
        return str;
    }

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // javax.mail.Address
    public boolean equals(Object obj) {
        if (obj instanceof InternetAddress) {
            String address = ((InternetAddress) obj).getAddress();
            String str = this.address;
            if (address == str) {
                return true;
            }
            return str != null && str.equalsIgnoreCase(address);
        }
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public InternetAddress[] getGroup(boolean z) throws AddressException {
        int indexOf;
        String address = getAddress();
        if (address.endsWith(";") && (indexOf = address.indexOf(58)) >= 0) {
            return parseHeader(address.substring(indexOf + 1, address.length() - 1), z);
        }
        return null;
    }

    public String getPersonal() {
        String str = this.personal;
        if (str != null) {
            return str;
        }
        String str2 = this.encodedPersonal;
        if (str2 != null) {
            try {
                String decodeText = MimeUtility.decodeText(str2);
                this.personal = decodeText;
                return decodeText;
            } catch (Exception unused) {
                return this.encodedPersonal;
            }
        }
        return null;
    }

    @Override // javax.mail.Address
    public String getType() {
        return "rfc822";
    }

    public int hashCode() {
        String str = this.address;
        if (str == null) {
            return 0;
        }
        return str.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public boolean isGroup() {
        String str = this.address;
        return str != null && str.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPersonal(String str, String str2) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, null);
        } else {
            this.encodedPersonal = null;
        }
    }

    @Override // javax.mail.Address
    public String toString() {
        String str;
        if (this.encodedPersonal == null && (str = this.personal) != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        String str2 = this.encodedPersonal;
        if (str2 != null) {
            return String.valueOf(quotePhrase(str2)) + " <" + this.address + ">";
        } else if (!isGroup() && !isSimple()) {
            return "<" + this.address + ">";
        } else {
            return this.address;
        }
    }

    public String toUnicodeString() {
        String personal = getPersonal();
        if (personal != null) {
            return String.valueOf(quotePhrase(personal)) + " <" + this.address + ">";
        } else if (!isGroup() && !isSimple()) {
            return "<" + this.address + ">";
        } else {
            return this.address;
        }
    }

    public void validate() throws AddressException {
        checkAddress(getAddress(), true, true);
    }

    public InternetAddress(String str) throws AddressException {
        InternetAddress[] parse = parse(str, true);
        if (parse.length == 1) {
            this.address = parse[0].address;
            this.personal = parse[0].personal;
            this.encodedPersonal = parse[0].encodedPersonal;
            return;
        }
        throw new AddressException("Illegal address", str);
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

    public static InternetAddress[] parse(String str, boolean z) throws AddressException {
        return parse(str, z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static javax.mail.internet.InternetAddress[] parse(java.lang.String r16, boolean r17, boolean r18) throws javax.mail.internet.AddressException {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetAddress.parse(java.lang.String, boolean, boolean):javax.mail.internet.InternetAddress[]");
    }

    public void setPersonal(String str) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str);
        } else {
            this.encodedPersonal = null;
        }
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public InternetAddress(String str, boolean z) throws AddressException {
        this(str);
        if (z) {
            checkAddress(this.address, true, true);
        }
    }

    public static String toString(Address[] addressArr, int i) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < addressArr.length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
                i += 2;
            }
            String address = addressArr[i2].toString();
            if (lengthOfFirstSegment(address) + i > 76) {
                stringBuffer.append("\r\n\t");
                i = 8;
            }
            stringBuffer.append(address);
            i = lengthOfLastSegment(address, i);
        }
        return stringBuffer.toString();
    }

    public InternetAddress(String str, String str2) throws UnsupportedEncodingException {
        this(str, str2, null);
    }

    public InternetAddress(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.address = str;
        setPersonal(str2, str3);
    }
}
