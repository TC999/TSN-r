package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: AbstractParser.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b<MessageType extends n> implements p<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final f f57623a = f.c();

    private MessageType e(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException f(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: g */
    public MessageType d(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(j(inputStream, fVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: h */
    public MessageType a(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(k(inputStream, fVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: i */
    public MessageType b(d dVar, f fVar) throws InvalidProtocolBufferException {
        return e(l(dVar, fVar));
    }

    public MessageType j(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return k(new a.AbstractC1158a.C1159a(inputStream, e.B(read, inputStream)), fVar);
        } catch (IOException e4) {
            throw new InvalidProtocolBufferException(e4.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        e g4 = e.g(inputStream);
        MessageType messagetype = (MessageType) c(g4, fVar);
        try {
            g4.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e4) {
            throw e4.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType l(d dVar, f fVar) throws InvalidProtocolBufferException {
        try {
            e t3 = dVar.t();
            MessageType messagetype = (MessageType) c(t3, fVar);
            try {
                t3.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e4) {
                throw e4.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e5) {
            throw e5;
        }
    }
}
