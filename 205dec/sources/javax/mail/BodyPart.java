package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
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
