package com.bxkj.base.util;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RSAUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final int f18429a = 117;

    /* renamed from: b  reason: collision with root package name */
    private final int f18430b = 256;

    /* renamed from: c  reason: collision with root package name */
    private final String f18431c = "RSA";

    /* renamed from: d  reason: collision with root package name */
    private final String f18432d = "RSA/ECB/PKCS1Padding";

    /* renamed from: e  reason: collision with root package name */
    private final String f18433e = "UTF-8";

    /* renamed from: f  reason: collision with root package name */
    private final String f18434f = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4laolA7zAk7jzsqDb3Oa5pS/uCPlZfASK8Soh/NzEmry77QDZ2koyr96M5Wx+A9cxwewQMHzi8RoOfb3UcQO4UDQlMUImLuzUnfbk3TTppijSLH+PU88XQxcgYm2JTa546c7JdZSI6dBeXOJH20quuxWyzgLk9jAlt3ytYygPQ7C6o6ZSmjcMgE3xgLaHGvixEVpOjL/pdVLzXhrMqWVAnB/snMjpCqesDVTDe5c6OOmj2q5J8n+tzIXtnvrkxQSDaUp8DWF8meMwyTErmYklMXzKic2rjdYZpHh4x98Fg0Q28sp6i2ZoWiGrJDKW29mntVQQiDNhKDawb4B45zUwIDAQAB";

    private PublicKey b(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(cn.bluemobi.dylan.base.utils.b.a(str)));
    }

    public String a(String str) throws Exception {
        byte[] doFinal;
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, b("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4laolA7zAk7jzsqDb3Oa5pS/uCPlZfASK8Soh/NzEmry77QDZ2koyr96M5Wx+A9cxwewQMHzi8RoOfb3UcQO4UDQlMUImLuzUnfbk3TTppijSLH+PU88XQxcgYm2JTa546c7JdZSI6dBeXOJH20quuxWyzgLk9jAlt3ytYygPQ7C6o6ZSmjcMgE3xgLaHGvixEVpOjL/pdVLzXhrMqWVAnB/snMjpCqesDVTDe5c6OOmj2q5J8n+tzIXtnvrkxQSDaUp8DWF8meMwyTErmYklMXzKic2rjdYZpHh4x98Fg0Q28sp6i2ZoWiGrJDKW29mntVQQiDNhKDawb4B45zUwIDAQAB"));
        int length = str.getBytes("UTF-8").length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = length - i4;
            if (i6 > 0) {
                if (i6 > 117) {
                    doFinal = cipher.doFinal(str.getBytes("UTF-8"), i4, 117);
                } else {
                    doFinal = cipher.doFinal(str.getBytes("UTF-8"), i4, i6);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i5++;
                i4 = i5 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return cn.bluemobi.dylan.base.utils.b.b(byteArray);
            }
        }
    }
}
