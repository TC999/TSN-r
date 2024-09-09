package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: MessageLite.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface n extends o {

    /* compiled from: MessageLite.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a extends Cloneable, o {
        n build();

        a g(e eVar, f fVar) throws IOException;
    }

    p<? extends n> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
