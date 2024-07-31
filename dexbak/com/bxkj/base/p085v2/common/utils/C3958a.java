package com.bxkj.base.p085v2.common.utils;

import cn.bluemobi.dylan.base.utils.C1138b;
import com.kuaishou.weapon.p205p0.C7183b;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.nio.charset.Charset;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AESUtils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/a;", "", "<init>", "()V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C3958a {
    @NotNull

    /* renamed from: a */
    public static final C3959a f15105a = new C3959a(null);
    @NotNull

    /* renamed from: b */
    private static final String f15106b = "AES/ECB/PKCS5Padding";

    /* renamed from: c */
    private static final int f15107c = 24;
    @NotNull

    /* renamed from: d */
    private static final String f15108d = "thanks,pig4cloud";
    @NotNull

    /* renamed from: e */
    private static final String f15109e = "thanks,pig4cloud";

    /* compiled from: AESUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/a$a;", "", "", "length", "", "d", "data", DomainCampaignEx.LOOPBACK_KEY, "b", "a", "c", "cipherMode", "Ljava/lang/String;", "iv", "keyLength", "I", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3959a {
        private C3959a() {
        }

        public /* synthetic */ C3959a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        /* renamed from: a */
        public final String m43815a(@Nullable String str, @NotNull String key) throws Exception {
            C14342f0.m8184p(key, "key");
            try {
                int length = key.length();
                if (length != 16 && length != 24 && length != 32) {
                    System.out.println((Object) "长度必须为16/24/32");
                    return null;
                }
                Charset forName = Charset.forName("utf-8");
                C14342f0.m8185o(forName, "Charset.forName(charsetName)");
                byte[] bytes = key.getBytes(forName);
                C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                Cipher cipher = Cipher.getInstance(C3958a.f15106b);
                cipher.init(2, secretKeySpec);
                try {
                    byte[] original = cipher.doFinal(C1138b.m57769a(str));
                    C14342f0.m8185o(original, "original");
                    Charset forName2 = Charset.forName("UTF-8");
                    C14342f0.m8185o(forName2, "forName(\"UTF-8\")");
                    return new String(original, forName2);
                } catch (Exception e) {
                    System.out.println((Object) e.toString());
                    return null;
                }
            } catch (Exception e2) {
                System.out.println((Object) e2.toString());
                return null;
            }
        }

        @Nullable
        /* renamed from: b */
        public final String m43814b(@NotNull String data, @NotNull String key) throws Exception {
            C14342f0.m8184p(data, "data");
            C14342f0.m8184p(key, "key");
            int length = key.length();
            if (length != 16 && length != 24 && length != 32) {
                System.out.println((Object) "长度必须为16/24/32");
                return null;
            }
            Charset forName = Charset.forName("utf-8");
            C14342f0.m8185o(forName, "Charset.forName(charsetName)");
            byte[] bytes = key.getBytes(forName);
            C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance(C3958a.f15106b);
            cipher.init(1, secretKeySpec);
            Charset forName2 = Charset.forName("utf-8");
            C14342f0.m8185o(forName2, "Charset.forName(charsetName)");
            byte[] bytes2 = data.getBytes(forName2);
            C14342f0.m8185o(bytes2, "(this as java.lang.String).getBytes(charset)");
            return C1138b.m57768b(cipher.doFinal(bytes2));
        }

        @Nullable
        /* renamed from: c */
        public final String m43813c(@NotNull String data) throws Exception {
            C14342f0.m8184p(data, "data");
            try {
                Cipher cipher = Cipher.getInstance(C7183b.f24540a);
                int blockSize = cipher.getBlockSize();
                Charset charset = Charsets.f41591a;
                byte[] bytes = data.getBytes(charset);
                C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
                int length = bytes.length;
                if (length % blockSize != 0) {
                    length += blockSize - (length % blockSize);
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                String str = C3958a.f15108d;
                if (str != null) {
                    byte[] bytes2 = str.getBytes(charset);
                    C14342f0.m8185o(bytes2, "(this as java.lang.String).getBytes(charset)");
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
                    String str2 = C3958a.f15109e;
                    if (str2 != null) {
                        byte[] bytes3 = str2.getBytes(charset);
                        C14342f0.m8185o(bytes3, "(this as java.lang.String).getBytes(charset)");
                        cipher.init(1, secretKeySpec, new IvParameterSpec(bytes3));
                        String m57768b = C1138b.m57768b(cipher.doFinal(bArr));
                        C14342f0.m8185o(m57768b, "encode(encrypted)");
                        int length2 = m57768b.length() - 1;
                        int i = 0;
                        boolean z = false;
                        while (i <= length2) {
                            boolean z2 = C14342f0.m8180t(m57768b.charAt(!z ? i : length2), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length2--;
                            } else if (z2) {
                                i++;
                            } else {
                                z = true;
                            }
                        }
                        return m57768b.subSequence(i, length2 + 1).toString();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Nullable
        /* renamed from: d */
        public final String m43812d(int i) {
            if (i != 16 && i != 24 && i != 32) {
                System.out.println((Object) "长度必须为16/24/32");
                return null;
            }
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (i > 0) {
                do {
                    i2++;
                    sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
                } while (i2 < i);
                return sb.toString();
            }
            return sb.toString();
        }
    }
}
