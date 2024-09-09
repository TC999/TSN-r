package xyz.adscope.common.network.secure;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SafeSecret implements Secret {
    @Override // xyz.adscope.common.network.secure.Secret
    public String decrypt(String str) {
        return str;
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] decrypt(byte[] bArr) {
        return bArr;
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public String encrypt(String str) {
        return str;
    }

    @Override // xyz.adscope.common.network.secure.Secret
    public byte[] encrypt(byte[] bArr) {
        return bArr;
    }
}
