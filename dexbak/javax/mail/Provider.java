package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Provider {
    private String className;
    private String protocol;
    private Type type;
    private String vendor;
    private String version;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class Type {
        public static final Type STORE = new Type("STORE");
        public static final Type TRANSPORT = new Type("TRANSPORT");
        private String type;

        private Type(String str) {
            this.type = str;
        }

        public String toString() {
            return this.type;
        }
    }

    public Provider(Type type, String str, String str2, String str3, String str4) {
        this.type = type;
        this.protocol = str;
        this.className = str2;
        this.vendor = str3;
        this.version = str4;
    }

    public String getClassName() {
        return this.className;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Type getType() {
        return this.type;
    }

    public String getVendor() {
        return this.vendor;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        String str = "javax.mail.Provider[" + this.type + "," + this.protocol + "," + this.className;
        if (this.vendor != null) {
            str = String.valueOf(str) + "," + this.vendor;
        }
        if (this.version != null) {
            str = String.valueOf(str) + "," + this.version;
        }
        return String.valueOf(str) + "]";
    }
}
