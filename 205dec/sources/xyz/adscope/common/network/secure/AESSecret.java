package xyz.adscope.common.network.secure;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AESSecret implements Secret {

    /* renamed from: a  reason: collision with root package name */
    public Cipher f64965a;

    /* renamed from: b  reason: collision with root package name */
    public Cipher f64966b;

    public AESSecret(String str) {
        Key a4 = a(str.getBytes());
        Cipher cipher = Cipher.getInstance("AES");
        this.f64965a = cipher;
        cipher.init(1, a4);
        Cipher cipher2 = Cipher.getInstance("AES");
        this.f64966b = cipher2;
        cipher2.init(2, a4);
    }

    public final Key a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        for (int i4 = 0; i4 < bArr.length && i4 < 8; i4++) {
            bArr2[i4] = bArr[i4];
        }
        return new SecretKeySpec(bArr2, "AES");
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public String decrypt(String str) {
        return new String(decrypt(Encryption.hexToByteArray(str)));
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] decrypt(byte[] bArr) {
        return this.f64966b.doFinal(bArr);
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public String encrypt(String str) {
        return Encryption.byteArrayToHex(encrypt(str.getBytes()));
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] encrypt(byte[] bArr) {
        return this.f64965a.doFinal(bArr);
    }
}
