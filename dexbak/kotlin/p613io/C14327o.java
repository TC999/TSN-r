package kotlin.p613io;

import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

/* compiled from: Console.kt */
@Metadata(m12615k = 3, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final /* synthetic */ class C14327o extends MutablePropertyReference0Impl {
    C14327o(C14328p c14328p) {
        super(c14328p, C14328p.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.InterfaceC14450o
    @Nullable
    public Object get() {
        return C14328p.m8371a((C14328p) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.InterfaceC14440k
    public void set(@Nullable Object obj) {
        C14328p c14328p = (C14328p) this.receiver;
        C14328p.f41097b = (CharsetDecoder) obj;
    }
}
