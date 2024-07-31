package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class ProtocolFamilyConverter {

    /* renamed from: io.netty.channel.socket.nio.ProtocolFamilyConverter$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C137541 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ProtocolFamilyConverter() {
    }

    public static ProtocolFamily convert(InternetProtocolFamily internetProtocolFamily) {
        int i = C137541.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamily.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return StandardProtocolFamily.INET6;
            }
            throw new IllegalArgumentException();
        }
        return StandardProtocolFamily.INET;
    }
}
