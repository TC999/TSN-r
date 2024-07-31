package io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class CompactObjectOutputStream extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactObjectOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> forClass = objectStreamClass.forClass();
        if (!forClass.isPrimitive() && !forClass.isArray() && !forClass.isInterface() && objectStreamClass.getSerialVersionUID() != 0) {
            write(1);
            writeUTF(objectStreamClass.getName());
            return;
        }
        write(0);
        super.writeClassDescriptor(objectStreamClass);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeStreamHeader() throws IOException {
        writeByte(5);
    }
}
