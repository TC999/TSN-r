package io.netty.util.internal.logging;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
class FormattingTuple {
    static final FormattingTuple NULL = new FormattingTuple(null);
    private final Object[] argArray;
    private final String message;
    private final Throwable throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormattingTuple(String str) {
        this(str, null, null);
    }

    static Object[] trimmedCopy(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }

    public Object[] getArgArray() {
        return this.argArray;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.message = str;
        this.throwable = th;
        if (th == null) {
            this.argArray = objArr;
        } else {
            this.argArray = trimmedCopy(objArr);
        }
    }
}
