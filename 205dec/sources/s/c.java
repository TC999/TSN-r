package s;

import com.bxkj.base.intercept.a;
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
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import kotlin.text.x;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;

/* compiled from: RequestInterceptor.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002J\"\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Ls/c;", "Lokhttp3/Interceptor;", "", "", "map", "b", DomainCampaignEx.LOOPBACK_KEY, "value", "", "isEncode", "a", "Lokhttp3/MultipartBody$Part;", "part", "c", "d", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class c implements Interceptor {
    private final String a(String str, String str2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=");
        if (z3) {
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

    private final String b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size() - 1;
        if (size > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                String str = (String) arrayList.get(i4);
                String str2 = map.get(str);
                sb.append(str2 == null ? null : a(str, str2, false));
                sb.append("&");
                if (i5 >= size) {
                    break;
                }
                i4 = i5;
            }
        }
        String str3 = (String) arrayList.get(arrayList.size() - 1);
        String str4 = map.get(str3);
        sb.append(str4 != null ? a(str3, str4, false) : null);
        a.C0196a c0196a = com.bxkj.base.intercept.a.f18282a;
        String b4 = com.bxkj.base.v2.data.a.b.a().b();
        String decode = URLDecoder.decode(sb.toString(), "UTF-8");
        f0.o(decode, "decode(authInfo.toString(),\"UTF-8\")");
        return c0196a.a(b4, decode);
    }

    private final String c(MultipartBody.Part part) {
        Field field;
        List T4;
        List T42;
        String k22;
        try {
            field = part.getClass().getDeclaredField("headers");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            field = null;
        }
        f0.m(field);
        field.setAccessible(true);
        try {
            Object obj = field.get(part);
            if (obj != null) {
                String str = ((Headers) obj).get("content-disposition");
                f0.m(str);
                T4 = x.T4(str, new String[]{";"}, false, 0, 6, null);
                Object[] array = T4.toArray(new String[0]);
                if (array != null) {
                    T42 = x.T4(((String[]) array)[1], new String[]{"="}, false, 0, 6, null);
                    Object[] array2 = T42.toArray(new String[0]);
                    if (array2 != null) {
                        k22 = w.k2(((String[]) array2)[1], "\"", "", false, 4, null);
                        return k22;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Headers");
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return "";
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    private final String d(MultipartBody.Part part) {
        Field field;
        try {
            field = part.getClass().getDeclaredField("body");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            field = null;
        }
        f0.m(field);
        field.setAccessible(true);
        try {
            Object obj = field.get(part);
            if (obj != null) {
                RequestBody requestBody = (RequestBody) obj;
                MediaType contentType = requestBody.contentType();
                f0.m(contentType);
                if (f0.g(contentType.subtype(), "form-data")) {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    Charset charset = contentType.charset(Charset.forName("UTF-8"));
                    f0.m(charset);
                    return buffer.readString(charset);
                }
                return "dylan_file";
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.RequestBody");
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0135, code lost:
        r14 = kotlin.text.w.k2(r17, "\n", "", false, 4, null);
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
        throw new UnsupportedOperationException("Method not decompiled: s.c.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
