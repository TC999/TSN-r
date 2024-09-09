package javax.activation;

import myjava.awt.datatransfer.DataFlavor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ActivationDataFlavor extends DataFlavor {
    private String humanPresentableName;
    private MimeType mimeObject;
    private String mimeType;
    private Class representationClass;

    public ActivationDataFlavor(Class cls, String str, String str2) {
        super(str, str2);
        this.mimeObject = null;
        this.mimeType = str;
        this.humanPresentableName = str2;
        this.representationClass = cls;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public boolean equals(DataFlavor dataFlavor) {
        return isMimeTypeEqual(dataFlavor) && dataFlavor.getRepresentationClass() == this.representationClass;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public String getHumanPresentableName() {
        return this.humanPresentableName;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public Class getRepresentationClass() {
        return this.representationClass;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public boolean isMimeTypeEqual(String str) {
        try {
            if (this.mimeObject == null) {
                this.mimeObject = new MimeType(this.mimeType);
            }
            return this.mimeObject.match(new MimeType(str));
        } catch (MimeTypeParseException unused) {
            return this.mimeType.equalsIgnoreCase(str);
        }
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    protected String normalizeMimeType(String str) {
        return str;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    protected String normalizeMimeTypeParameter(String str, String str2) {
        return str2;
    }

    @Override // myjava.awt.datatransfer.DataFlavor
    public void setHumanPresentableName(String str) {
        this.humanPresentableName = str;
    }

    public ActivationDataFlavor(Class cls, String str) {
        super(cls, str);
        this.mimeType = null;
        this.mimeObject = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = super.getMimeType();
        this.representationClass = cls;
        this.humanPresentableName = str;
    }

    public ActivationDataFlavor(String str, String str2) {
        super(str, str2);
        this.mimeObject = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = str;
        try {
            this.representationClass = Class.forName("java.io.InputStream");
        } catch (ClassNotFoundException unused) {
        }
        this.humanPresentableName = str2;
    }
}
