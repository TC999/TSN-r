package com.bxkj.base.intercept;

import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.http.MD5Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/base/intercept/a;", "", "<init>", "()V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.intercept.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class EncryptionUtils {
    @NotNull

    /* renamed from: a */
    public static final C3873a f14797a = new C3873a(null);

    /* compiled from: EncryptionUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¨\u0006\f"}, m12616d2 = {"Lcom/bxkj/base/intercept/a$a;", "", "", "appId", BidResponsed.KEY_TOKEN, CampaignEx.JSON_KEY_TIMESTAMP, "b", "c", "encryptStr", "a", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.intercept.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3873a {
        private C3873a() {
        }

        public /* synthetic */ C3873a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final String m44212a(@NotNull String token, @NotNull String encryptStr) {
            C14342f0.m8184p(token, "token");
            C14342f0.m8184p(encryptStr, "encryptStr");
            String md5Token = MD5Utils.md5(token);
            C14342f0.m8185o(md5Token, "md5Token");
            String substring = md5Token.substring(0, 16);
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = md5Token.substring(16, 32);
            C14342f0.m8185o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset forName = Charset.forName("utf-8");
            C14342f0.m8185o(forName, "Charset.forName(charsetName)");
            if (substring != null) {
                byte[] bytes = substring.getBytes(forName);
                C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                Charset charset = Charsets.f41591a;
                if (substring2 != null) {
                    byte[] bytes2 = substring2.getBytes(charset);
                    C14342f0.m8185o(bytes2, "(this as java.lang.String).getBytes(charset)");
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    Charset forName2 = Charset.forName("utf-8");
                    C14342f0.m8185o(forName2, "Charset.forName(charsetName)");
                    byte[] bytes3 = encryptStr.getBytes(forName2);
                    C14342f0.m8185o(bytes3, "(this as java.lang.String).getBytes(charset)");
                    String m57768b = C1138b.m57768b(cipher.doFinal(bytes3));
                    C14342f0.m8185o(m57768b, "encode(encrypted)");
                    return m57768b;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        @NotNull
        /* renamed from: b */
        public final String m44211b(@NotNull String appId, @NotNull String token, @NotNull String timestamp) {
            C14342f0.m8184p(appId, "appId");
            C14342f0.m8184p(token, "token");
            C14342f0.m8184p(timestamp, "timestamp");
            String str = appId + token + timestamp;
            C14342f0.m8185o(str, "sb.toString()");
            String md5AppId = MD5Utils.md5(m44212a(token, str));
            C14342f0.m8185o(md5AppId, "md5AppId");
            return md5AppId;
        }

        @NotNull
        /* renamed from: c */
        public final String m44210c(@NotNull String token, @NotNull String timestamp) {
            C14342f0.m8184p(token, "token");
            C14342f0.m8184p(timestamp, "timestamp");
            String str = token + timestamp;
            C14342f0.m8185o(str, "sb.toString()");
            String md5aesAppSecret = MD5Utils.md5(m44212a(token, str));
            C14342f0.m8185o(md5aesAppSecret, "md5aesAppSecret");
            return md5aesAppSecret;
        }
    }
}
