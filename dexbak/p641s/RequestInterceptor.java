package p641s;

import com.bxkj.base.intercept.EncryptionUtils;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14579x;
import kotlin.text.StringsJVM;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;

@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002J\"\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0015"}, m12616d2 = {"Ls/c;", "Lokhttp3/Interceptor;", "", "", "map", "b", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "", "isEncode", "a", "Lokhttp3/MultipartBody$Part;", "part", "c", "d", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: s.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RequestInterceptor implements Interceptor {
    /* renamed from: a */
    private final String m334a(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=");
        if (z) {
            try {
                sb.append(URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                sb.append(str2);
            }
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private final String m333b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size() - 1;
        if (size > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String str = (String) arrayList.get(i);
                String str2 = map.get(str);
                sb.append(str2 == null ? null : m334a(str, str2, false));
                sb.append("&");
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        String str3 = (String) arrayList.get(arrayList.size() - 1);
        String str4 = map.get(str3);
        sb.append(str4 != null ? m334a(str3, str4, false) : null);
        EncryptionUtils.C3873a c3873a = EncryptionUtils.f14797a;
        String m43662b = LoggedInUser.f15182b.m43634a().m43662b();
        String decode = URLDecoder.decode(sb.toString(), "UTF-8");
        C14342f0.m8185o(decode, "decode(authInfo.toString(),\"UTF-8\")");
        return c3873a.m44212a(m43662b, decode);
    }

    /* renamed from: c */
    private final String m332c(MultipartBody.Part part) {
        Field field;
        List m6471T4;
        List m6471T42;
        String m6568k2;
        try {
            field = part.getClass().getDeclaredField(TTDownloadField.TT_HEADERS);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            field = null;
        }
        C14342f0.m8187m(field);
        field.setAccessible(true);
        try {
            Object obj = field.get(part);
            if (obj != null) {
                String str = ((Headers) obj).get("content-disposition");
                C14342f0.m8187m(str);
                m6471T4 = C14579x.m6471T4(str, new String[]{";"}, false, 0, 6, null);
                Object[] array = m6471T4.toArray(new String[0]);
                if (array != null) {
                    m6471T42 = C14579x.m6471T4(((String[]) array)[1], new String[]{"="}, false, 0, 6, null);
                    Object[] array2 = m6471T42.toArray(new String[0]);
                    if (array2 != null) {
                        m6568k2 = StringsJVM.m6568k2(((String[]) array2)[1], "\"", "", false, 4, null);
                        return m6568k2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Headers");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    private final String m331d(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            field = null;
        }
        C14342f0.m8187m(field);
        field.setAccessible(true);
        try {
            Object obj = field.get(part);
            if (obj != null) {
                RequestBody requestBody = (RequestBody) obj;
                MediaType contentType = requestBody.contentType();
                C14342f0.m8187m(contentType);
                if (C14342f0.m8193g(contentType.subtype(), "form-data")) {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    Charset charset = contentType.charset(Charset.forName("UTF-8"));
                    C14342f0.m8187m(charset);
                    return buffer.readString(charset);
                }
                return "dylan_file";
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.RequestBody");
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0135, code lost:
        r14 = kotlin.text.StringsJVM.m6568k2(r17, com.snail.antifake.deviceid.ShellAdbUtils.f33810d, "", false, 4, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e0 A[SYNTHETIC] */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r24) {
        /*
            Method dump skipped, instructions count: 651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p641s.RequestInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
