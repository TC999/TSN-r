package io.netty.channel.sctp;

import com.sun.nio.sctp.MessageInfo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SctpMessage extends DefaultByteBufHolder {
    private final MessageInfo msgInfo;
    private final int protocolIdentifier;
    private final int streamIdentifier;
    private final boolean unordered;

    public SctpMessage(int i4, int i5, ByteBuf byteBuf) {
        this(i4, i5, false, byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SctpMessage.class != obj.getClass()) {
            return false;
        }
        SctpMessage sctpMessage = (SctpMessage) obj;
        if (this.protocolIdentifier == sctpMessage.protocolIdentifier && this.streamIdentifier == sctpMessage.streamIdentifier && this.unordered == sctpMessage.unordered) {
            return content().equals(sctpMessage.content());
        }
        return false;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        return (((((this.streamIdentifier * 31) + this.protocolIdentifier) * 31) + (this.unordered ? 1231 : 1237)) * 31) + content().hashCode();
    }

    public boolean isComplete() {
        MessageInfo messageInfo = this.msgInfo;
        if (messageInfo != null) {
            return messageInfo.isComplete();
        }
        return true;
    }

    public boolean isUnordered() {
        return this.unordered;
    }

    public MessageInfo messageInfo() {
        return this.msgInfo;
    }

    public int protocolIdentifier() {
        return this.protocolIdentifier;
    }

    public int streamIdentifier() {
        return this.streamIdentifier;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return "SctpFrame{streamIdentifier=" + this.streamIdentifier + ", protocolIdentifier=" + this.protocolIdentifier + ", unordered=" + this.unordered + ", data=" + contentToString() + '}';
    }

    public SctpMessage(int i4, int i5, boolean z3, ByteBuf byteBuf) {
        super(byteBuf);
        this.protocolIdentifier = i4;
        this.streamIdentifier = i5;
        this.unordered = z3;
        this.msgInfo = null;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public SctpMessage copy() {
        return (SctpMessage) super.copy();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public SctpMessage duplicate() {
        return (SctpMessage) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public SctpMessage replace(ByteBuf byteBuf) {
        MessageInfo messageInfo = this.msgInfo;
        if (messageInfo == null) {
            return new SctpMessage(this.protocolIdentifier, this.streamIdentifier, this.unordered, byteBuf);
        }
        return new SctpMessage(messageInfo, byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public SctpMessage retainedDuplicate() {
        return (SctpMessage) super.retainedDuplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public SctpMessage retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public SctpMessage touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public SctpMessage retain(int i4) {
        super.retain(i4);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public SctpMessage touch(Object obj) {
        super.touch(obj);
        return this;
    }

    public SctpMessage(MessageInfo messageInfo, ByteBuf byteBuf) {
        super(byteBuf);
        if (messageInfo != null) {
            this.msgInfo = messageInfo;
            this.streamIdentifier = messageInfo.streamNumber();
            this.protocolIdentifier = messageInfo.payloadProtocolID();
            this.unordered = messageInfo.isUnordered();
            return;
        }
        throw new NullPointerException("msgInfo");
    }
}
