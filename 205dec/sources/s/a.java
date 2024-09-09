package s;

import com.bxkj.base.v2.common.utils.f;
import com.orhanobut.logger.j;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.u;
import kotlin.text.Regex;
import kotlin.text.w;
import kotlin.text.x;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HttpLogInterceptor.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0015J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u00a8\u0006\u001e"}, d2 = {"Ls/a;", "Lokhttp3/Interceptor;", "Lokhttp3/Request;", "original", "Lkotlin/f1;", "b", "Lokhttp3/MultipartBody$Part;", "part", "", "f", "g", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "indent", "a", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "", "size", "c", "mss", "d", "jsonStr", "e", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a implements Interceptor {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f64366a = new StringBuilder();

    /* compiled from: ConnectState.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Ls/a$a;", "", "", "STATUS_CONNECT_CLOSED", "I", "STATUS_CONNECT_ERROR", "STATUS_CONNECT_SUCCESS", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: s.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class C1329a {
        private C1329a() {
        }

        public /* synthetic */ C1329a(u uVar) {
            this();
        }
    }

    private final void a(StringBuilder sb, int i4) {
        if (i4 > 0) {
            int i5 = 0;
            do {
                i5++;
                sb.append('\t');
            } while (i5 < i4);
        }
    }

    private final void b(Request request) {
        MediaType contentType;
        RequestBody body;
        MediaType contentType2;
        String str;
        if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            int i4 = 0;
            f0.m(formBody);
            int size = formBody.size();
            if (size <= 0) {
                return;
            }
            while (true) {
                int i5 = i4 + 1;
                String encodedName = formBody.encodedName(i4);
                String value = formBody.value(i4);
                if (this.f64366a.indexOf("=") != -1) {
                    this.f64366a.append("\n");
                    this.f64366a.append("\u3000\u3000\u3000\u3000\u3000");
                }
                this.f64366a.append(encodedName);
                this.f64366a.append("=");
                this.f64366a.append(value);
                if (i5 >= size) {
                    return;
                }
                i4 = i5;
            }
        } else {
            String str2 = null;
            if (request.body() instanceof MultipartBody) {
                MultipartBody multipartBody = (MultipartBody) request.body();
                f0.m(multipartBody);
                for (MultipartBody.Part part : multipartBody.parts()) {
                    if (part != null) {
                        MultipartBody.Part part2 = part;
                        String f4 = f(part2);
                        try {
                            String g4 = g(part2);
                            str = URLDecoder.decode(g4 == null ? null : new Regex("%(?![0-9a-fA-F]{2})").replace(g4, "%25"), "UTF-8");
                        } catch (UnsupportedEncodingException e4) {
                            e4.printStackTrace();
                            str = null;
                        }
                        if (this.f64366a.indexOf("=") != -1) {
                            this.f64366a.append("\n");
                            this.f64366a.append("\u3000\u3000\u3000\u3000\u3000");
                        }
                        this.f64366a.append(f4);
                        this.f64366a.append("=");
                        this.f64366a.append(str);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type okhttp3.MultipartBody.Part");
                    }
                }
                return;
            }
            RequestBody body2 = request.body();
            if (f0.g((body2 == null || (contentType = body2.contentType()) == null) ? null : contentType.type(), "application")) {
                RequestBody body3 = request.body();
                if (body3 != null && (contentType2 = body3.contentType()) != null) {
                    str2 = contentType2.subtype();
                }
                if (!f0.g(str2, "json") || (body = request.body()) == null) {
                    return;
                }
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                this.f64366a.append(e(buffer.readUtf8()));
            }
        }
    }

    private final String f(MultipartBody.Part part) {
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

    private final String g(MultipartBody.Part part) {
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
                if (!f0.g(contentType.type(), "multipart")) {
                    return f0.g(contentType.type(), "image") ? c(requestBody.contentLength()) : "";
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
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    @Nullable
    public final String c(long j4) {
        long j5 = 1024;
        long j6 = j5 * 1024;
        long j7 = j5 * j6;
        if (j4 >= j7) {
            s0 s0Var = s0.f55680a;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j4) / ((float) j7))}, 1));
            f0.o(format, "java.lang.String.format(format, *args)");
            return format;
        } else if (j4 >= j6) {
            float f4 = ((float) j4) / ((float) j6);
            s0 s0Var2 = s0.f55680a;
            String format2 = String.format(f4 > 100.0f ? "%.0f MB" : "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(f4)}, 1));
            f0.o(format2, "java.lang.String.format(format, *args)");
            return format2;
        } else if (j4 >= 1024) {
            float f5 = ((float) j4) / ((float) 1024);
            s0 s0Var3 = s0.f55680a;
            String format3 = String.format(f5 > 100.0f ? "%.0f KB" : "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(f5)}, 1));
            f0.o(format3, "java.lang.String.format(format, *args)");
            return format3;
        } else {
            s0 s0Var4 = s0.f55680a;
            String format4 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
            f0.o(format4, "java.lang.String.format(format, *args)");
            return format4;
        }
    }

    @Nullable
    public final String d(long j4) {
        if (j4 < 1000) {
            return j4 + "ms";
        } else if (j4 < 60000) {
            StringBuilder sb = new StringBuilder();
            sb.append((j4 % 60000) / 1000);
            sb.append('s');
            return sb.toString();
        } else {
            return ((j4 % 3600000) / 60000) + "min";
        }
    }

    @Nullable
    public final String e(@Nullable String str) {
        if (str == null || f0.g("", str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length > 0) {
            int i4 = 0;
            char c4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i4 + 1;
                char charAt = str.charAt(i4);
                boolean z3 = true;
                if (charAt == '{' || charAt == '[') {
                    sb.append(charAt);
                    sb.append('\n');
                    i5++;
                    a(sb, i5);
                } else {
                    if (charAt != '}' && charAt != ']') {
                        z3 = false;
                    }
                    if (z3) {
                        sb.append('\n');
                        i5--;
                        a(sb, i5);
                        sb.append(charAt);
                    } else if (charAt == ',') {
                        sb.append(charAt);
                        if (c4 != '\\') {
                            sb.append('\n');
                            a(sb, i5);
                        }
                    } else {
                        sb.append(charAt);
                    }
                }
                if (i6 >= length) {
                    break;
                }
                c4 = charAt;
                i4 = i6;
            }
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        f0.p(chain, "chain");
        try {
            this.f64366a.setLength(0);
            Request request = chain.request();
            this.f64366a.append("\u8bf7\u6c42\u5730\u5740\uff1a");
            this.f64366a.append(request.url());
            this.f64366a.append("\n");
            Response proceed = chain.proceed(request.newBuilder().build());
            if (f0.g("POST", request.method())) {
                this.f64366a.append("\u8bf7\u6c42\u53c2\u6570\uff1a");
                b(request);
                this.f64366a.append("\n");
                this.f64366a.append("\u8bf7\u6c42\u5927\u5c0f\uff1a");
                if (request.body() != null) {
                    StringBuilder sb = this.f64366a;
                    RequestBody body = request.body();
                    f0.m(body);
                    sb.append(c(body.contentLength()));
                }
                j.d(this.f64366a.toString(), new Object[0]);
                this.f64366a.setLength(0);
                this.f64366a.append("\u54cd\u5e94\u5730\u5740\uff1a");
                this.f64366a.append(proceed.request().url());
                this.f64366a.append("\n");
                this.f64366a.append("\u54cd\u5e94\u53c2\u6570\uff1a");
                b(proceed.request());
                this.f64366a.append("\n");
            }
            this.f64366a.append("\u54cd\u5e94\u8017\u65f6\uff1a");
            this.f64366a.append(d(proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis()));
            this.f64366a.append("\n");
            ResponseBody body2 = proceed.body();
            f0.m(body2);
            String string = body2.string();
            ResponseBody body3 = proceed.body();
            f0.m(body3);
            Response build = proceed.newBuilder().body(ResponseBody.Companion.create(body3.contentType(), string)).build();
            this.f64366a.append("\u54cd\u5e94\u5927\u5c0f\uff1a");
            if (request.body() != null) {
                StringBuilder sb2 = this.f64366a;
                ResponseBody body4 = build.body();
                f0.m(body4);
                sb2.append(c(body4.contentLength()));
            }
            this.f64366a.append("\n");
            this.f64366a.append("\u54cd\u5e94\u6570\u636e\uff1a");
            this.f64366a.append("\n");
            this.f64366a.append(e(f.a(string)));
            j.d(this.f64366a.toString(), new Object[0]);
            return build;
        } catch (Exception e4) {
            e4.printStackTrace();
            return chain.proceed(chain.request());
        }
    }
}
