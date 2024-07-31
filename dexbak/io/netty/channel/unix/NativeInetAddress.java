package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class NativeInetAddress {
    private static final byte[] IPV4_MAPPED_IPV6_PREFIX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};
    final byte[] address;
    final int scopeId;

    public NativeInetAddress(byte[] bArr, int i) {
        this.address = bArr;
        this.scopeId = i;
    }

    static int decodeInt(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 24) | ((bArr[i + 1] & UByte.f41242c) << 16) | ((bArr[i + 2] & UByte.f41242c) << 8);
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

    public static InetSocketAddress address(byte[] bArr, int i, int i2) {
        InetAddress byAddress;
        int i3 = i + i2;
        int decodeInt = decodeInt(bArr, i3 - 4);
        try {
            if (i2 == 8) {
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i, bArr2, 0, 4);
                byAddress = InetAddress.getByAddress(bArr2);
            } else if (i2 == 24) {
                byte[] bArr3 = new byte[16];
                System.arraycopy(bArr, i, bArr3, 0, 16);
                byAddress = Inet6Address.getByAddress((String) null, bArr3, decodeInt(bArr, i3 - 8));
            } else {
                throw new Error();
            }
            return new InetSocketAddress(byAddress, decodeInt);
        } catch (UnknownHostException e) {
            throw new Error("Should never happen", e);
        }
    }

    public NativeInetAddress(byte[] bArr) {
        this(bArr, 0);
    }
}
