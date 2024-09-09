package xyz.adscope.common.network.secure;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Secret {
    String decrypt(String str);

    byte[] decrypt(byte[] bArr);

    String encrypt(String str);

    byte[] encrypt(byte[] bArr);
}
