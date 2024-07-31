package io.netty.handler.codec.http.multipart;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.AbstractReferenceCounted;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class InternalAttribute extends AbstractReferenceCounted implements InterfaceHttpData {
    private final Charset charset;
    private int size;
    private final List<ByteBuf> value = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalAttribute(Charset charset) {
        this.charset = charset;
    }

    public void addValue(String str) {
        if (str != null) {
            ByteBuf copiedBuffer = Unpooled.copiedBuffer(str, this.charset);
            this.value.add(copiedBuffer);
            this.size += copiedBuffer.readableBytes();
            return;
        }
        throw new NullPointerException(DomainCampaignEx.LOOPBACK_VALUE);
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalAttribute) {
            return getName().equalsIgnoreCase(((InternalAttribute) obj).getName());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.InternalAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return "InternalAttribute";
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public void setValue(String str, int i) {
        if (str != null) {
            ByteBuf copiedBuffer = Unpooled.copiedBuffer(str, this.charset);
            ByteBuf byteBuf = this.value.set(i, copiedBuffer);
            if (byteBuf != null) {
                this.size -= byteBuf.readableBytes();
                byteBuf.release();
            }
            this.size += copiedBuffer.readableBytes();
            return;
        }
        throw new NullPointerException(DomainCampaignEx.LOOPBACK_VALUE);
    }

    public int size() {
        return this.size;
    }

    public ByteBuf toByteBuf() {
        return Unpooled.compositeBuffer().addComponents(this.value).writerIndex(size()).readerIndex(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ByteBuf byteBuf : this.value) {
            sb.append(byteBuf.toString(this.charset));
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof InternalAttribute) {
            return compareTo((InternalAttribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData retain() {
        for (ByteBuf byteBuf : this.value) {
            byteBuf.retain();
        }
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData touch() {
        for (ByteBuf byteBuf : this.value) {
            byteBuf.touch();
        }
        return this;
    }

    public void addValue(String str, int i) {
        if (str != null) {
            ByteBuf copiedBuffer = Unpooled.copiedBuffer(str, this.charset);
            this.value.add(i, copiedBuffer);
            this.size += copiedBuffer.readableBytes();
            return;
        }
        throw new NullPointerException(DomainCampaignEx.LOOPBACK_VALUE);
    }

    public int compareTo(InternalAttribute internalAttribute) {
        return getName().compareToIgnoreCase(internalAttribute.getName());
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData retain(int i) {
        for (ByteBuf byteBuf : this.value) {
            byteBuf.retain(i);
        }
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public InterfaceHttpData touch(Object obj) {
        for (ByteBuf byteBuf : this.value) {
            byteBuf.touch(obj);
        }
        return this;
    }
}
