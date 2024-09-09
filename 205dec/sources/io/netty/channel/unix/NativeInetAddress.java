package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class NativeInetAddress {
    private static final byte[] IPV4_MAPPED_IPV6_PREFIX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};
    final byte[] address;
    final int scopeId;

    public NativeInetAddress(byte[] bArr, int i4) {
        this.address = bArr;
        this.scopeId = i4;
    }

    static int decodeInt(byte[] bArr, int i4) {
        return (bArr[i4 + 3] & 255) | ((bArr[i4] & 255) << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8);
    }

    public static byte[] ipv4MappedIpv6Address(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = IPV4_MAPPED_IPV6_PREFIX;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        return bArr2;
    }

    public static NativeInetAddress newInstance(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        if (inetAddress instanceof Inet6Address) {
            return new NativeInetAddress(address, ((Inet6Address) inetAddress).getScopeId());
        }
        return new NativeInetAddress(ipv4MappedIpv6Address(address));
    }

    public byte[] address() {
        return this.address;
    }

    public int scopeId() {
        return this.scopeId;
    }

    public static InetSocketAddress address(byte[] bArr, int i4, int i5) {
        InetAddress byAddress;
        int i6 = i4 + i5;
        int decodeInt = decodeInt(bArr, i6 - 4);
        try {
            if (i5 == 8) {
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i4, bArr2, 0, 4);
                byAddress = InetAddress.getByAddress(bArr2);
            } else if (i5 == 24) {
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr, i4, bArr3, 0, 16);
                byAddress = Inet6Address.getByAddress((String) null, bArr3, decodeInt(bArr, i6 - 8));
            } else {
                throw new Error();
            }
            return new InetSocketAddress(byAddress, decodeInt);
        } catch (UnknownHostException e4) {
            throw new Error("Should never happen", e4);
        }
    }

    public NativeInetAddress(byte[] bArr) {
        this(bArr, 0);
    }
}
