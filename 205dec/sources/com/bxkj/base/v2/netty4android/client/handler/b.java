package com.bxkj.base.v2.netty4android.client.handler;

import com.orhanobut.logger.j;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyDecoder.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001b\u0010\u001cJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J&\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/handler/b;", "Lio/netty/handler/codec/MessageToMessageDecoder;", "Lio/netty/buffer/ByteBuf;", "msg", "", "allLength", "Lio/netty/channel/ChannelHandlerContext;", "ctx", "", "", "out", "Lkotlin/f1;", "a", "decode", "Ljava/nio/charset/Charset;", "Ljava/nio/charset/Charset;", "charset", "", "b", "Ljava/lang/String;", "dataStr", "c", "Lio/netty/buffer/ByteBuf;", "tempDat", "d", "I", "length", "<init>", "(Ljava/nio/charset/Charset;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class b extends MessageToMessageDecoder<ByteBuf> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Charset f18769a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f18770b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ByteBuf f18771c;

    /* renamed from: d  reason: collision with root package name */
    private int f18772d;

    public b() {
        this(null, 1, null);
    }

    public /* synthetic */ b(Charset charset, int i4, u uVar) {
        this((i4 & 1) != 0 ? Charset.defaultCharset() : charset);
    }

    private final void a(ByteBuf byteBuf, int i4, ChannelHandlerContext channelHandlerContext, List<Object> list) {
        byte[] D2;
        byte[] D22;
        byte[] D23;
        ByteBuf copy = byteBuf.copy();
        byteBuf.readShort();
        byte readByte = byteBuf.readByte();
        int readShort = byteBuf.readShort();
        this.f18772d = readShort;
        if (i4 < readShort + 7) {
            j.d("\u65ad\u5305allLength=" + i4 + " length=" + this.f18772d + " \u957f\u5ea6\u4e0d\u591f\u7b49\u5f85\u4e0b\u6b21\u6570\u636e\u5230\u6765", new Object[0]);
            this.f18771c = copy;
            return;
        }
        byte[] bArr = new byte[readShort];
        byteBuf.readBytes(bArr);
        short readShort2 = byteBuf.readShort();
        t.a aVar = t.a.a;
        D2 = o.D2(new byte[]{-52, -52}, aVar.e(readByte));
        D22 = o.D2(D2, aVar.f((short) this.f18772d));
        D23 = o.D2(D22, bArr);
        if (readShort2 != a.f18767a.a(D23)) {
            j.e("\u6821\u9a8c\u4f4d\u5f02\u5e38", new Object[0]);
            channelHandlerContext.close();
        }
        list.add(new com.bxkj.base.v2.netty4android.client.command.a(readByte, this.f18772d, new String(bArr, kotlin.text.d.f58930b)));
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public b(@Nullable Charset charset) {
        this.f18770b = "";
        if (charset != null) {
            this.f18769a = charset;
            return;
        }
        throw new NullPointerException("charset");
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf msg, @NotNull List<Object> out) throws Exception {
        f0.p(ctx, "ctx");
        f0.p(msg, "msg");
        f0.p(out, "out");
        int readableBytes = msg.readableBytes();
        try {
            ByteBuf byteBuf = this.f18771c;
            if (byteBuf != null) {
                f0.m(byteBuf);
                int readableBytes2 = byteBuf.readableBytes();
                int i4 = this.f18772d + 7;
                ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(this.f18771c, msg.readBytes(Math.min(readableBytes, i4 - readableBytes2)));
                this.f18771c = wrappedBuffer;
                f0.m(wrappedBuffer);
                if (wrappedBuffer.readableBytes() == i4) {
                    t.a aVar = t.a.a;
                    ByteBuf byteBuf2 = this.f18771c;
                    f0.m(byteBuf2);
                    ByteBuf copy = byteBuf2.copy();
                    f0.o(copy, "tempDat!!.copy()");
                    aVar.c(copy, "\u65ad\u5305\u5408\u5e76\u540e\u7684\u6570\u636e\uff1a");
                    ByteBuf byteBuf3 = this.f18771c;
                    f0.m(byteBuf3);
                    a(byteBuf3, i4, ctx, out);
                    this.f18771c = null;
                    this.f18772d = 0;
                }
            } else {
                a(msg, readableBytes, ctx, out);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            msg.resetReaderIndex();
            byte[] bArr = new byte[readableBytes];
            msg.readBytes(bArr);
            j.e(t.a.a.b(bArr), new Object[0]);
        }
    }
}
