package myjava.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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

    private static int getNextMeaningfulIndex(String str, int i) {
        while (i < str.length() && !isMeaningfulChar(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static boolean isMeaningfulChar(char c) {
        return c >= '!' && c <= '~';
    }

    private static boolean isTSpecialChar(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' || c == '<' || c == '>' || c == '@' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '\"' || c == '/' || c == '?' || c == '=';
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
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f44094i);
        stringPosition.f44094i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && str.charAt(stringPosition.f44094i) == '=') {
            int i = stringPosition.f44094i + 1;
            stringPosition.f44094i = i;
            int nextMeaningfulIndex2 = getNextMeaningfulIndex(str, i);
            stringPosition.f44094i = nextMeaningfulIndex2;
            if (nextMeaningfulIndex2 < str.length()) {
                if (str.charAt(stringPosition.f44094i) == '\"') {
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
            int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f44094i);
            stringPosition.f44094i = nextMeaningfulIndex;
            if (nextMeaningfulIndex >= str.length()) {
                return;
            }
            if (str.charAt(stringPosition.f44094i) == ';') {
                stringPosition.f44094i++;
                retrieveParam(str, mimeType, stringPosition);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static String retrieveQuoted(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        stringPosition.f44094i++;
        boolean z = true;
        do {
            if (str.charAt(stringPosition.f44094i) == '\"' && z) {
                stringPosition.f44094i++;
                return sb.toString();
            }
            int i = stringPosition.f44094i;
            stringPosition.f44094i = i + 1;
            char charAt = str.charAt(i);
            if (!z) {
                z = true;
            } else if (charAt == '\\') {
                z = false;
            }
            if (z) {
                sb.append(charAt);
            }
        } while (stringPosition.f44094i != str.length());
        throw new IllegalArgumentException();
    }

    private static String retrieveToken(String str, StringPosition stringPosition) {
        StringBuilder sb = new StringBuilder();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f44094i);
        stringPosition.f44094i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && !isTSpecialChar(str.charAt(stringPosition.f44094i))) {
            do {
                int i = stringPosition.f44094i;
                stringPosition.f44094i = i + 1;
                sb.append(str.charAt(i));
                if (stringPosition.f44094i >= str.length() || !isMeaningfulChar(str.charAt(stringPosition.f44094i))) {
                    break;
                }
            } while (!isTSpecialChar(str.charAt(stringPosition.f44094i)));
            return sb.toString();
        }
        throw new IllegalArgumentException();
    }

    private static void retrieveType(String str, MimeType mimeType, StringPosition stringPosition) {
        mimeType.primaryType = retrieveToken(str, stringPosition).toLowerCase();
        int nextMeaningfulIndex = getNextMeaningfulIndex(str, stringPosition.f44094i);
        stringPosition.f44094i = nextMeaningfulIndex;
        if (nextMeaningfulIndex < str.length() && str.charAt(stringPosition.f44094i) == '/') {
            stringPosition.f44094i++;
            mimeType.subType = retrieveToken(str, stringPosition).toLowerCase();
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class StringPosition {

        /* renamed from: i */
        int f44094i;

        private StringPosition() {
            this.f44094i = 0;
        }

        /* synthetic */ StringPosition(StringPosition stringPosition) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
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
            return String.valueOf(this.primaryType) + "/" + this.subType;
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
