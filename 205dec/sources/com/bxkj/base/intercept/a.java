package com.bxkj.base.intercept;

import cn.bluemobi.dylan.http.MD5Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EncryptionUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/base/intercept/a;", "", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C0196a f18282a = new C0196a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EncryptionUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/base/intercept/a$a;", "", "", "appId", "token", CampaignEx.JSON_KEY_TIMESTAMP, "b", "c", "encryptStr", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.intercept.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class C0196a {
        private C0196a() {
        }

        public /* synthetic */ C0196a(u uVar) {
            this();
        }

        @NotNull
        public final String a(@NotNull String token, @NotNull String encryptStr) {
            f0.p(token, "token");
            f0.p(encryptStr, "encryptStr");
            String md5Token = MD5Utils.md5(token);
            f0.o(md5Token, "md5Token");
            String substring = md5Token.substring(0, 16);
            f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            String substring2 = md5Token.substring(16, 32);
            f0.o(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            Charset forName = Charset.forName("utf-8");
            f0.o(forName, "Charset.forName(charsetName)");
            if (substring != null) {
                byte[] bytes = substring.getBytes(forName);
                f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                Charset charset = kotlin.text.d.a;
                if (substring2 != null) {
                    byte[] bytes2 = substring2.getBytes(charset);
                    f0.o(bytes2, "(this as java.lang.String).getBytes(charset)");
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    Charset forName2 = Charset.forName("utf-8");
                    f0.o(forName2, "Charset.forName(charsetName)");
                    byte[] bytes3 = encryptStr.getBytes(forName2);
                    f0.o(bytes3, "(this as java.lang.String).getBytes(charset)");
                    String b4 = cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(bytes3));
                    f0.o(b4, "encode(encrypted)");
                    return b4;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        @NotNull
        public final String b(@NotNull String appId, @NotNull String token, @NotNull String timestamp) {
            f0.p(appId, "appId");
            f0.p(token, "token");
            f0.p(timestamp, "timestamp");
            String str = appId + token + timestamp;
            f0.o(str, "sb.toString()");
            String md5AppId = MD5Utils.md5(a(token, str));
            f0.o(md5AppId, "md5AppId");
            return md5AppId;
        }

        @NotNull
        public final String c(@NotNull String token, @NotNull String timestamp) {
            f0.p(token, "token");
            f0.p(timestamp, "timestamp");
            String str = token + timestamp;
            f0.o(str, "sb.toString()");
            String md5aesAppSecret = MD5Utils.md5(a(token, str));
            f0.o(md5aesAppSecret, "md5aesAppSecret");
            return md5aesAppSecret;
        }
    }
}
