package com.alibaba.fastjson.asm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class FieldWriter {
    private final int access;
    private final int desc;
    private final int name;
    FieldWriter next;

    public FieldWriter(ClassWriter classWriter, int i4, String str, String str2) {
        if (classWriter.firstField == null) {
            classWriter.firstField = this;
        } else {
            classWriter.lastField.next = this;
        }
        classWriter.lastField = this;
        this.access = i4;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSize() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        byteVector.putShort(0);
    }

    public void visitEnd() {
    }
}
