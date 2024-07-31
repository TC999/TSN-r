package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class BodyPart implements Part {
    protected Multipart parent;

    public Multipart getParent() {
        return this.parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParent(Multipart multipart) {
        this.parent = multipart;
    }
}
