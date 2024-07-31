package p641s;

import com.bxkj.base.p085v2.common.utils.C3961f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.C14361s0;
import kotlin.text.C14579x;
import kotlin.text.Regex;
import kotlin.text.StringsJVM;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0015J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b¨\u0006\u001e"}, m12616d2 = {"Ls/a;", "Lokhttp3/Interceptor;", "Lokhttp3/Request;", "original", "Lkotlin/f1;", "b", "Lokhttp3/MultipartBody$Part;", "part", "", "f", "g", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "indent", "a", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "", "size", "c", "mss", "d", "jsonStr", "e", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: s.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class HttpLogInterceptor implements Interceptor {
    @NotNull

    /* renamed from: a */
    private final StringBuilder f47096a = new StringBuilder();

    /* renamed from: a */
    private final void m341a(StringBuilder sb, int i) {
        if (i > 0) {
            int i2 = 0;
            do {
                i2++;
                sb.append('\t');
            } while (i2 < i);
        }
    }

    /* renamed from: b */
    private final void m340b(Request request) {
        MediaType contentType;
        RequestBody body;
        MediaType contentType2;
        String str;
        if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            int i = 0;
            C14342f0.m8187m(formBody);
            int size = formBody.size();
            if (size <= 0) {
                return;
            }
            while (true) {
                int i2 = i + 1;
                String encodedName = formBody.encodedName(i);
                String value = formBody.value(i);
                if (this.f47096a.indexOf("=") != -1) {
                    this.f47096a.append(ShellAdbUtils.f33810d);
                    this.f47096a.append("\u3000\u3000\u3000\u3000\u3000");
                }
                this.f47096a.append(encodedName);
                this.f47096a.append("=");
                this.f47096a.append(value);
                if (i2 >= size) {
                    return;
                }
                i = i2;
            }
        } else {
            String str2 = null;
            if (request.body() instanceof MultipartBody) {
                MultipartBody multipartBody = (MultipartBody) request.body();
                C14342f0.m8187m(multipartBody);
                for (MultipartBody.Part part : multipartBody.parts()) {
                    if (part != null) {
                        MultipartBody.Part part2 = part;
                        String m336f = m336f(part2);
                        try {
                            String m335g = m335g(part2);
                            str = URLDecoder.decode(m335g == null ? null : new Regex("%(?![0-9a-fA-F]{2})").replace(m335g, "%25"), "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            str = null;
                        }
                        if (this.f47096a.indexOf("=") != -1) {
                            this.f47096a.append(ShellAdbUtils.f33810d);
                            this.f47096a.append("\u3000\u3000\u3000\u3000\u3000");
                        }
                        this.f47096a.append(m336f);
                        this.f47096a.append("=");
                        this.f47096a.append(str);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type okhttp3.MultipartBody.Part");
                    }
                }
                return;
            }
            RequestBody body2 = request.body();
            if (C14342f0.m8193g((body2 == null || (contentType = body2.contentType()) == null) ? null : contentType.type(), "application")) {
                RequestBody body3 = request.body();
                if (body3 != null && (contentType2 = body3.contentType()) != null) {
                    str2 = contentType2.subtype();
                }
                if (!C14342f0.m8193g(str2, "json") || (body = request.body()) == null) {
                    return;
                }
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                this.f47096a.append(m337e(buffer.readUtf8()));
            }
        }
    }

    /* renamed from: f */
    private final String m336f(MultipartBody.Part part) {
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

    /* renamed from: g */
    private final String m335g(MultipartBody.Part part) {
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
                if (!C14342f0.m8193g(contentType.type(), "multipart")) {
                    return C14342f0.m8193g(contentType.type(), SocializeProtocolConstants.IMAGE) ? m339c(requestBody.contentLength()) : "";
                }
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                Charset charset = contentType.charset(Charset.forName("UTF-8"));
                if (charset == null) {
                    return null;
                }
                return buffer.readString(charset);
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

    @Nullable
    /* renamed from: c */
    public final String m339c(long j) {
        long j2 = 1024;
        long j3 = j2 * 1024;
        long j4 = j2 * j3;
        if (j >= j4) {
            C14361s0 c14361s0 = C14361s0.f41190a;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / ((float) j4))}, 1));
            C14342f0.m8185o(format, "java.lang.String.format(format, *args)");
            return format;
        } else if (j >= j3) {
            float f = ((float) j) / ((float) j3);
            C14361s0 c14361s02 = C14361s0.f41190a;
            String format2 = String.format(f > 100.0f ? "%.0f MB" : "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            C14342f0.m8185o(format2, "java.lang.String.format(format, *args)");
            return format2;
        } else if (j >= 1024) {
            float f2 = ((float) j) / ((float) 1024);
            C14361s0 c14361s03 = C14361s0.f41190a;
            String format3 = String.format(f2 > 100.0f ? "%.0f KB" : "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
            C14342f0.m8185o(format3, "java.lang.String.format(format, *args)");
            return format3;
        } else {
            C14361s0 c14361s04 = C14361s0.f41190a;
            String format4 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
            C14342f0.m8185o(format4, "java.lang.String.format(format, *args)");
            return format4;
        }
    }

    @Nullable
    /* renamed from: d */
    public final String m338d(long j) {
        if (j < 1000) {
            return j + "ms";
        } else if (j < 60000) {
            StringBuilder sb = new StringBuilder();
            sb.append((j % 60000) / 1000);
            sb.append('s');
            return sb.toString();
        } else {
            return ((j % 3600000) / 60000) + "min";
        }
    }

    @Nullable
    /* renamed from: e */
    public final String m337e(@Nullable String str) {
        if (str == null || C14342f0.m8193g("", str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length > 0) {
            int i = 0;
            char c = 0;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                char charAt = str.charAt(i);
                boolean z = true;
                if (charAt == '{' || charAt == '[') {
                    sb.append(charAt);
                    sb.append('\n');
                    i2++;
                    m341a(sb, i2);
                } else {
                    if (charAt != '}' && charAt != ']') {
                        z = false;
                    }
                    if (z) {
                        sb.append('\n');
                        i2--;
                        m341a(sb, i2);
                        sb.append(charAt);
                    } else if (charAt == ',') {
                        sb.append(charAt);
                        if (c != '\\') {
                            sb.append('\n');
                            m341a(sb, i2);
                        }
                    } else {
                        sb.append(charAt);
                    }
                }
                if (i3 >= length) {
                    break;
                }
                c = charAt;
                i = i3;
            }
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        C14342f0.m8184p(chain, "chain");
        try {
            this.f47096a.setLength(0);
            Request request = chain.request();
            this.f47096a.append("请求地址：");
            this.f47096a.append(request.url());
            this.f47096a.append(ShellAdbUtils.f33810d);
            Response proceed = chain.proceed(request.newBuilder().build());
            if (C14342f0.m8193g("POST", request.method())) {
                this.f47096a.append("请求参数：");
                m340b(request);
                this.f47096a.append(ShellAdbUtils.f33810d);
                this.f47096a.append("请求大小：");
                if (request.body() != null) {
                    StringBuilder sb = this.f47096a;
                    RequestBody body = request.body();
                    C14342f0.m8187m(body);
                    sb.append(m339c(body.contentLength()));
                }
                C11792j.m20469d(this.f47096a.toString(), new Object[0]);
                this.f47096a.setLength(0);
                this.f47096a.append("响应地址：");
                this.f47096a.append(proceed.request().url());
                this.f47096a.append(ShellAdbUtils.f33810d);
                this.f47096a.append("响应参数：");
                m340b(proceed.request());
                this.f47096a.append(ShellAdbUtils.f33810d);
            }
            this.f47096a.append("响应耗时：");
            this.f47096a.append(m338d(proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis()));
            this.f47096a.append(ShellAdbUtils.f33810d);
            ResponseBody body2 = proceed.body();
            C14342f0.m8187m(body2);
            String string = body2.string();
            ResponseBody body3 = proceed.body();
            C14342f0.m8187m(body3);
            Response build = proceed.newBuilder().body(ResponseBody.Companion.create(body3.contentType(), string)).build();
            this.f47096a.append("响应大小：");
            if (request.body() != null) {
                StringBuilder sb2 = this.f47096a;
                ResponseBody body4 = build.body();
                C14342f0.m8187m(body4);
                sb2.append(m339c(body4.contentLength()));
            }
            this.f47096a.append(ShellAdbUtils.f33810d);
            this.f47096a.append("响应数据：");
            this.f47096a.append(ShellAdbUtils.f33810d);
            this.f47096a.append(m337e(C3961f.m43804a(string)));
            C11792j.m20469d(this.f47096a.toString(), new Object[0]);
            return build;
        } catch (Exception e) {
            e.printStackTrace();
            return chain.proceed(chain.request());
        }
    }
}
