package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class PseudoRandomFunction {
    private PseudoRandomFunction() {
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    static byte[] hash(byte[] bArr, byte[] bArr2, byte[] bArr3, int i4, String str) {
        if (i4 >= 0) {
            try {
                Mac mac = Mac.getInstance(str);
                mac.init(new SecretKeySpec(bArr, str));
                double d4 = i4;
                double macLength = mac.getMacLength();
                Double.isNaN(d4);
                Double.isNaN(macLength);
                int ceil = (int) Math.ceil(d4 / macLength);
                byte[] bArr4 = EmptyArrays.EMPTY_BYTES;
                byte[] concat = concat(bArr2, bArr3);
                byte[] bArr5 = concat;
                for (int i5 = 0; i5 < ceil; i5++) {
                    bArr5 = mac.doFinal(bArr5);
                    bArr4 = concat(bArr4, mac.doFinal(concat(bArr5, concat)));
                }
                return Arrays.copyOf(bArr4, i4);
            } catch (GeneralSecurityException e4) {
                throw new IllegalArgumentException("Could not find algo: " + str, e4);
            }
        }
        throw new IllegalArgumentException("You must provide a length greater than zero.");
    }
}
