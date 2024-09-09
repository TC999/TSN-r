package myjava.awt.datatransfer;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class MimeTypeProcessor {
    private static MimeTypeProcessor instance;

    private MimeTypeProcessor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String assemble(MimeType mimeType) {
        StringBuilder sb = new StringBuilder();
        sb.append(mimeType.getFullType());
        Enumeration keys = mimeType.parameters.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            sb.append("; ");
            sb.append(str);
            sb.append("=\"");
            sb.append((String) mimeType.parameters.get(str));
            sb.append('\"');
        }
        return sb.toString();
    }

    private static int getNextMeaningfulIndex(String str, int i4) {
        while (i4 < str.length() && !isMeaningfulChar(str.charAt(i4))) {
            i4++;
        }
        return i4;
    }

    private static boolean isMeaningfulChar(char c4) {
        return c4 >= '!' && c4 <= '~';
    }

    private static boolean isTSpecialChar(char c4) {
        return c4 == '(' || c4 == ')' || c4 == '[' || c4 == ']' || c4 == '<' || c4 == '>' || c4 == '@' || c4 == ',' || c4 == ';' || c4 == ':' || c4 == '\\' || c4 == '\"' || c4 == '/' || c4 == '?' || c4 == '=';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MimeType parse(String str) {
        if (instance == null) {
            instance = new MimeTypeProcessor();
        }
        MimeType mimeType = new MimeType();
        if (str != null) {
            StringPosition stringPosition = new StringPosition(null);
            retrieveType(str, mimeType, stringPosition);
            retrieveParams(str, mimeType, stringPosition);
        }
        return mimeType;
    }

    private static void retrieveParam(String str, MimeType mimeType, StringPosition stringPosition) {
        String retrieveToken;
        String lowerCase = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f61482i);
        stringPosition.f61482i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && str.charAt(stringPosition.f61482i) == '=') {
            int i4 = stringPosition.f61482i + 1;
            stringPosition.f61482i = i4;
            int nextMeaningfulIndex2 = getNextMeaningfulIndex(str, i4);
            stringPosition.f61482i = nextMeaningfulIndex2;
            if (nextMeaningfulIndex2 < str.length()) {
                if (str.charAt(stringPosition.f61482i) == '\"') {
                    retrieveToken = retrieveQuoted(str, stringPosition);
                } else {
                    retrieveToken = retrieveToken(str, stringPosition);
                }
                mimeType.parameters.put(lowerCase, retrieveToken);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static void retrieveParams(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.parameters = new Hashtable();
        mimeType.systemParameters = new Hashtable();
        while (true) {
            int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f61482i);
            stringPosition.f61482i = nextMeaningfulIndex;
            if (nextMeaningfulIndex >= str.length()) {
                return;
            }
            if (str.charAt(stringPosition.f61482i) == ';') {
                stringPosition.f61482i++;
                retrieveParam(str, mimeType, stringPosition);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        stringPosition.f61482i++;
        boolean z3 = true;
        do {
            if (str.charAt(stringPosition.f61482i) == '\"' && z3) {
                stringPosition.f61482i++;
                return sb.toString();
            }
            int i4 = stringPosition.f61482i;
            stringPosition.f61482i = i4 + 1;
            char charAt = str.charAt(i4);
            if (!z3) {
                z3 = true;
            } else if (charAt == '\\') {
                z3 = false;
            }
            if (z3) {
                sb.append(charAt);
            }
        } while (stringPosition.f61482i != str.length());
        throw new IllegalArgumentException();
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f61482i);
        stringPosition.f61482i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && !isTSpecialChar(str.charAt(stringPosition.f61482i))) {
            do {
                int i4 = stringPosition.f61482i;
                stringPosition.f61482i = i4 + 1;
                sb.append(str.charAt(i4));
                if (stringPosition.f61482i >= str.length() || !isMeaningfulChar(str.charAt(stringPosition.f61482i))) {
                    break;
                }
            } while (!isTSpecialChar(str.charAt(stringPosition.f61482i)));
            return sb.toString();
        }
        throw new IllegalArgumentException();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.primaryType = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f61482i);
        stringPosition.f61482i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && str.charAt(stringPosition.f61482i) == '/') {
            stringPosition.f61482i++;
            mimeType.subType = retrieveToken(str, stringPosition).toLowerCase();
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class StringPosition {

        /* renamed from: i  reason: collision with root package name */
        int f61482i;

        private StringPosition() {
            this.f61482i = 0;
        }

        /* synthetic */ StringPosition(StringPosition stringPosition) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class MimeType implements Cloneable, Serializable {
        private static final long serialVersionUID = -6693571907475992044L;
        private Hashtable<String, String> parameters;
        private String primaryType;
        private String subType;
        private Hashtable<String, Object> systemParameters;

        MimeType() {
            this.primaryType = null;
            this.subType = null;
            this.parameters = null;
            this.systemParameters = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addParameter(String str, String str2) {
            if (str2 == null) {
                return;
            }
            if (str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                str2 = str2.substring(1, str2.length() - 2);
            }
            if (str2.length() == 0) {
                return;
            }
            this.parameters.put(str, str2);
        }

        void addSystemParameter(String str, Object obj) {
            this.systemParameters.put(str, obj);
        }

        public Object clone() {
            MimeType mimeType = new MimeType(this.primaryType, this.subType);
            mimeType.parameters = (Hashtable) this.parameters.clone();
            mimeType.systemParameters = (Hashtable) this.systemParameters.clone();
            return mimeType;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean equals(MimeType mimeType) {
            if (mimeType == null) {
                return false;
            }
            return getFullType().equals(mimeType.getFullType());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getFullType() {
            return String.valueOf(this.primaryType) + TTPathConst.sSeparator + this.subType;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getParameter(String str) {
            return this.parameters.get(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getPrimaryType() {
            return this.primaryType;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getSubType() {
            return this.subType;
        }

        Object getSystemParameter(String str) {
            return this.systemParameters.get(str);
        }

        void removeParameter(String str) {
            this.parameters.remove(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public MimeType(String str, String str2) {
            this.primaryType = str;
            this.subType = str2;
            this.parameters = new Hashtable<>();
            this.systemParameters = new Hashtable<>();
        }
    }
}
