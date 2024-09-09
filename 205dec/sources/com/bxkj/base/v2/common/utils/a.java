package com.bxkj.base.v2.common.utils;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.nio.charset.Charset;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AESUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/base/v2/common/utils/a;", "", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C0203a f18593a = new C0203a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f18594b = com.acse.ottn.f.f5641a;

    /* renamed from: c  reason: collision with root package name */
    private static final int f18595c = 24;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f18596d = "thanks,pig4cloud";
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final String f18597e = "thanks,pig4cloud";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AESUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/base/v2/common/utils/a$a;", "", "", "length", "", "d", "data", DomainCampaignEx.LOOPBACK_KEY, "b", "a", "c", "cipherMode", "Ljava/lang/String;", "iv", "keyLength", "I", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class C0203a {
        private C0203a() {
        }

        public /* synthetic */ C0203a(u uVar) {
            this();
        }

        @Nullable
        public final String a(@Nullable String str, @NotNull String key) throws Exception {
            f0.p(key, "key");
            try {
                int length = key.length();
                if (length != 16 && length != 24 && length != 32) {
                    System.out.println((Object) "\u957f\u5ea6\u5fc5\u987b\u4e3a16/24/32");
                    return null;
                }
                Charset forName = Charset.forName("utf-8");
                f0.o(forName, "Charset.forName(charsetName)");
                byte[] bytes = key.getBytes(forName);
                f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                Cipher cipher = Cipher.getInstance(a.f18594b);
                cipher.init(2, secretKeySpec);
                try {
                    byte[] original = cipher.doFinal(cn.bluemobi.dylan.base.utils.b.a(str));
                    f0.o(original, "original");
                    Charset forName2 = Charset.forName("UTF-8");
                    f0.o(forName2, "forName(\"UTF-8\")");
                    return new String(original, forName2);
                } catch (Exception e4) {
                    System.out.println((Object) e4.toString());
                    return null;
                }
            } catch (Exception e5) {
                System.out.println((Object) e5.toString());
                return null;
            }
        }

        @Nullable
        public final String b(@NotNull String data, @NotNull String key) throws Exception {
            f0.p(data, "data");
            f0.p(key, "key");
            int length = key.length();
            if (length != 16 && length != 24 && length != 32) {
                System.out.println((Object) "\u957f\u5ea6\u5fc5\u987b\u4e3a16/24/32");
                return null;
            }
            Charset forName = Charset.forName("utf-8");
            f0.o(forName, "Charset.forName(charsetName)");
            byte[] bytes = key.getBytes(forName);
            f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance(a.f18594b);
            cipher.init(1, secretKeySpec);
            Charset forName2 = Charset.forName("utf-8");
            f0.o(forName2, "Charset.forName(charsetName)");
            byte[] bytes2 = data.getBytes(forName2);
            f0.o(bytes2, "(this as java.lang.String).getBytes(charset)");
            return cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(bytes2));
        }

        @Nullable
        public final String c(@NotNull String data) throws Exception {
            f0.p(data, "data");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                int blockSize = cipher.getBlockSize();
                Charset charset = kotlin.text.d.a;
                byte[] bytes = data.getBytes(charset);
                f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
                int length = bytes.length;
                if (length % blockSize != 0) {
                    length += blockSize - (length % blockSize);
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                String str = a.f18596d;
                if (str != null) {
                    byte[] bytes2 = str.getBytes(charset);
                    f0.o(bytes2, "(this as java.lang.String).getBytes(charset)");
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
                    String str2 = a.f18597e;
                    if (str2 != null) {
                        byte[] bytes3 = str2.getBytes(charset);
                        f0.o(bytes3, "(this as java.lang.String).getBytes(charset)");
                        cipher.init(1, secretKeySpec, new IvParameterSpec(bytes3));
                        String b4 = cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(bArr));
                        f0.o(b4, "encode(encrypted)");
                        int length2 = b4.length() - 1;
                        int i4 = 0;
                        boolean z3 = false;
                        while (i4 <= length2) {
                            boolean z4 = f0.t(b4.charAt(!z3 ? i4 : length2), 32) <= 0;
                            if (z3) {
                                if (!z4) {
                                    break;
                                }
                                length2--;
                            } else if (z4) {
                                i4++;
                            } else {
                                z3 = true;
                            }
                        }
                        return b4.subSequence(i4, length2 + 1).toString();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        @Nullable
        public final String d(int i4) {
            if (i4 != 16 && i4 != 24 && i4 != 32) {
                System.out.println((Object) "\u957f\u5ea6\u5fc5\u987b\u4e3a16/24/32");
                return null;
            }
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (i4 > 0) {
                do {
                    i5++;
                    sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
                } while (i5 < i4);
                return sb.toString();
            }
            return sb.toString();
        }
    }
}
