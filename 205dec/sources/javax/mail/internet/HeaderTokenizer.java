package javax.mail.internet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class HeaderTokenizer {
    private static final Token EOFToken = new Token(-4, null);
    public static final String MIME = "()<>@,;:\\\"\t []/?=";
    public static final String RFC822 = "()<>@,;:\\\"\t .[]";
    private int currentPos;
    private String delimiters;
    private int maxPos;
    private int nextPos;
    private int peekPos;
    private boolean skipComments;
    private String string;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class Token {
        public static final int ATOM = -1;
        public static final int COMMENT = -3;
        public static final int EOF = -4;
        public static final int QUOTEDSTRING = -2;
        private int type;
        private String value;

        public Token(int i4, String str) {
            this.type = i4;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public HeaderTokenizer(String str, String str2, boolean z3) {
        str = str == null ? "" : str;
        this.string = str;
        this.skipComments = z3;
        this.delimiters = str2;
        this.peekPos = 0;
        this.nextPos = 0;
        this.currentPos = 0;
        this.maxPos = str.length();
    }

    private static String filterToken(String str, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z3 = false;
        boolean z4 = false;
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt != '\n' || !z3) {
                if (z4) {
                    stringBuffer.append(charAt);
                    z3 = false;
                    z4 = false;
                } else if (charAt == '\\') {
                    z3 = false;
                    z4 = true;
                } else if (charAt == '\r') {
                    z3 = true;
                } else {
                    stringBuffer.append(charAt);
                }
                i4++;
            }
            z3 = false;
            i4++;
        }
        return stringBuffer.toString();
    }

    private Token getNext() throws ParseException {
        char charAt;
        String substring;
        String substring2;
        if (this.currentPos >= this.maxPos) {
            return EOFToken;
        }
        if (skipWhiteSpace() == -4) {
            return EOFToken;
        }
        char charAt2 = this.string.charAt(this.currentPos);
        boolean z3 = false;
        while (charAt2 == '(') {
            int i4 = this.currentPos + 1;
            this.currentPos = i4;
            int i5 = 1;
            while (i5 > 0) {
                int i6 = this.currentPos;
                if (i6 >= this.maxPos) {
                    break;
                }
                char charAt3 = this.string.charAt(i6);
                if (charAt3 == '\\') {
                    this.currentPos++;
                } else if (charAt3 != '\r') {
                    if (charAt3 == '(') {
                        i5++;
                    } else if (charAt3 == ')') {
                        i5--;
                    }
                    this.currentPos++;
                }
                z3 = true;
                this.currentPos++;
            }
            if (i5 == 0) {
                if (!this.skipComments) {
                    if (z3) {
                        substring2 = filterToken(this.string, i4, this.currentPos - 1);
                    } else {
                        substring2 = this.string.substring(i4, this.currentPos - 1);
                    }
                    return new Token(-3, substring2);
                } else if (skipWhiteSpace() == -4) {
                    return EOFToken;
                } else {
                    charAt2 = this.string.charAt(this.currentPos);
                }
            } else {
                throw new ParseException("Unbalanced comments");
            }
        }
        if (charAt2 == '\"') {
            int i7 = this.currentPos + 1;
            this.currentPos = i7;
            while (true) {
                int i8 = this.currentPos;
                if (i8 < this.maxPos) {
                    char charAt4 = this.string.charAt(i8);
                    if (charAt4 == '\\') {
                        this.currentPos++;
                    } else if (charAt4 != '\r') {
                        if (charAt4 == '\"') {
                            int i9 = this.currentPos + 1;
                            this.currentPos = i9;
                            if (z3) {
                                substring = filterToken(this.string, i7, i9 - 1);
                            } else {
                                substring = this.string.substring(i7, i9 - 1);
                            }
                            return new Token(-2, substring);
                        }
                        this.currentPos++;
                    }
                    z3 = true;
                    this.currentPos++;
                } else {
                    throw new ParseException("Unbalanced quoted string");
                }
            }
        } else if (charAt2 >= ' ' && charAt2 < '\u007f' && this.delimiters.indexOf(charAt2) < 0) {
            int i10 = this.currentPos;
            while (true) {
                int i11 = this.currentPos;
                if (i11 < this.maxPos && (charAt = this.string.charAt(i11)) >= ' ' && charAt < '\u007f' && charAt != '(' && charAt != ' ' && charAt != '\"' && this.delimiters.indexOf(charAt) < 0) {
                    this.currentPos++;
                }
            }
            return new Token(-1, this.string.substring(i10, this.currentPos));
        } else {
            this.currentPos++;
            return new Token(charAt2, new String(new char[]{charAt2}));
        }
    }

    private int skipWhiteSpace() {
        while (true) {
            int i4 = this.currentPos;
            if (i4 >= this.maxPos) {
                return -4;
            }
            char charAt = this.string.charAt(i4);
            if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                return this.currentPos;
            }
            this.currentPos++;
        }
    }

    public String getRemainder() {
        return this.string.substring(this.nextPos);
    }

    public Token next() throws ParseException {
        this.currentPos = this.nextPos;
        Token next = getNext();
        int i4 = this.currentPos;
        this.peekPos = i4;
        this.nextPos = i4;
        return next;
    }

    public Token peek() throws ParseException {
        this.currentPos = this.peekPos;
        Token next = getNext();
        this.peekPos = this.currentPos;
        return next;
    }

    public HeaderTokenizer(String str, String str2) {
        this(str, str2, true);
    }

    public HeaderTokenizer(String str) {
        this(str, "()<>@,;:\\\"\t .[]");
    }
}
