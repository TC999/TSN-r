package com.bxkj.base.v2.netty4android.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyEncoder.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/handler/c;", "Lio/netty/handler/codec/MessageToByteEncoder;", "Lcom/bxkj/base/v2/netty4android/client/command/a;", "Lio/netty/channel/ChannelHandlerContext;", "ctx", "msg", "Lio/netty/buffer/ByteBuf;", "out", "Lkotlin/f1;", "a", "Ljava/nio/charset/Charset;", "Ljava/nio/charset/Charset;", "charset", "<init>", "(Ljava/nio/charset/Charset;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class c extends MessageToByteEncoder<com.bxkj.base.v2.netty4android.client.command.a> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Charset f18773a;

    public c() {
        this(null, 1, null);
    }

    public /* synthetic */ c(Charset charset, int i4, u uVar) {
        this((i4 & 1) != 0 ? Charset.defaultCharset() : charset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /* renamed from: a */
    public void encode(@NotNull ChannelHandlerContext ctx, @NotNull com.bxkj.base.v2.netty4android.client.command.a msg, @NotNull ByteBuf out) throws Exception {
        byte[] D2;
        byte[] D22;
        byte[] D23;
        f0.p(ctx, "ctx");
        f0.p(msg, "msg");
        f0.p(out, "out");
        msg.d("\u5ba2\u6237\u7aef\u53d1\u9001\u6570\u636e\uff1a");
        out.writeBytes(new byte[]{-52, -52});
        out.writeByte(msg.a());
        out.writeShort(msg.c());
        byte[] bytes = msg.b().getBytes(kotlin.text.d.f58930b);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        out.writeBytes(bytes);
        t.a aVar = t.a.a;
        D2 = o.D2(new byte[]{-52, -52}, aVar.e(msg.a()));
        D22 = o.D2(D2, aVar.f((short) msg.c()));
        D23 = o.D2(D22, bytes);
        out.writeShort(a.f18767a.a(D23));
    }

    public c(@Nullable Charset charset) {
        if (charset != null) {
            this.f18773a = charset;
            return;
        }
        throw new NullPointerException("charset");
    }
}
