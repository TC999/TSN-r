package io.netty.util.internal;

import io.netty.util.NetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class MacAddressUtil {
    private static final int EUI48_MAC_ADDRESS_LENGTH = 6;
    private static final int EUI64_MAC_ADDRESS_LENGTH = 8;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(MacAddressUtil.class);

    private MacAddressUtil() {
    }

    public static byte[] bestAvailableMac() {
        int compareAddresses;
        byte[] bArr = EmptyArrays.EMPTY_BYTES;
        InetAddress inetAddress = NetUtil.LOCALHOST4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> addressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(nextElement);
                    if (addressesFromNetworkInterface.hasMoreElements()) {
                        InetAddress nextElement2 = addressesFromNetworkInterface.nextElement();
                        if (!nextElement2.isLoopbackAddress()) {
                            linkedHashMap.put(nextElement, nextElement2);
                        }
                    }
                }
            }
        } catch (SocketException e4) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e4);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            boolean z3 = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            NetworkInterface networkInterface = (NetworkInterface) entry.getKey();
            InetAddress inetAddress2 = (InetAddress) entry.getValue();
            if (!networkInterface.isVirtual()) {
                try {
                    byte[] hardwareAddressFromNetworkInterface = SocketUtils.hardwareAddressFromNetworkInterface(networkInterface);
                    int compareAddresses2 = compareAddresses(bArr, hardwareAddressFromNetworkInterface);
                    if (compareAddresses2 < 0 || (compareAddresses2 == 0 && ((compareAddresses = compareAddresses(inetAddress, inetAddress2)) < 0 || (compareAddresses == 0 && bArr.length < hardwareAddressFromNetworkInterface.length)))) {
                        z3 = true;
                    }
                    if (z3) {
                        inetAddress = inetAddress2;
                        bArr = hardwareAddressFromNetworkInterface;
                    }
                } catch (SocketException e5) {
                    logger.debug("Failed to get the hardware address of a network interface: {}", networkInterface, e5);
                }
            }
        }
        if (bArr == EmptyArrays.EMPTY_BYTES) {
            return null;
        }
        if (bArr.length != 6) {
            return Arrays.copyOf(bArr, 8);
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 3);
        bArr2[3] = -1;
        bArr2[4] = -2;
        System.arraycopy(bArr, 3, bArr2, 5, 3);
        return bArr2;
    }

    static int compareAddresses(byte[] bArr, byte[] bArr2) {
        boolean z3;
        if (bArr2 == null || bArr2.length < 6) {
            return 1;
        }
        int length = bArr2.length;
        int i4 = 0;
        while (true) {
            if (i4 < length) {
                byte b4 = bArr2[i4];
                if (b4 != 0 && b4 != 1) {
                    z3 = false;
                    break;
                }
                i4++;
            } else {
                z3 = true;
                break;
            }
        }
        if (!z3 && (bArr2[0] & 1) == 0) {
            return (bArr2[0] & 2) == 0 ? (bArr.length == 0 || (bArr[0] & 2) != 0) ? -1 : 0 : (bArr.length == 0 || (bArr[0] & 2) != 0) ? 0 : 1;
        }
        return 1;
    }

    public static byte[] defaultMachineId() {
        byte[] bestAvailableMac = bestAvailableMac();
        if (bestAvailableMac == null) {
            byte[] bArr = new byte[8];
            PlatformDependent.threadLocalRandom().nextBytes(bArr);
            logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", formatAddress(bArr));
            return bArr;
        }
        return bestAvailableMac;
    }

    public static String formatAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder(24);
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(String.format("%02x:", Integer.valueOf(bArr[i4] & 255)));
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static byte[] parseMAC(String str) {
        char charAt;
        byte[] bArr;
        int length = str.length();
        if (length == 17) {
            charAt = str.charAt(2);
            validateMacSeparator(charAt);
            bArr = new byte[6];
        } else if (length == 23) {
            charAt = str.charAt(2);
            validateMacSeparator(charAt);
            bArr = new byte[8];
        } else {
            throw new IllegalArgumentException("value is not supported [MAC-48, EUI-48, EUI-64]");
        }
        int length2 = bArr.length - 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length2) {
            int i6 = i5 + 2;
            bArr[i4] = StringUtil.decodeHexByte(str, i5);
            if (str.charAt(i6) != charAt) {
                throw new IllegalArgumentException("expected separator '" + charAt + " but got '" + str.charAt(i6) + "' at index: " + i6);
            }
            i4++;
            i5 += 3;
        }
        bArr[length2] = StringUtil.decodeHexByte(str, i5);
        return bArr;
    }

    private static int scoreAddress(InetAddress inetAddress) {
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            return 0;
        }
        if (inetAddress.isMulticastAddress()) {
            return 1;
        }
        if (inetAddress.isLinkLocalAddress()) {
            return 2;
        }
        return inetAddress.isSiteLocalAddress() ? 3 : 4;
    }

    private static void validateMacSeparator(char c4) {
        if (c4 == ':' || c4 == '-') {
            return;
        }
        throw new IllegalArgumentException("unsupported separator: " + c4 + " (expected: [:-])");
    }

    private static int compareAddresses(InetAddress inetAddress, InetAddress inetAddress2) {
        return scoreAddress(inetAddress) - scoreAddress(inetAddress2);
    }
}
