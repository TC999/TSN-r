package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: HttpMethod.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, m12616d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String method) {
        C14342f0.m8184p(method, "method");
        return (C14342f0.m8193g(method, "GET") || C14342f0.m8193g(method, "HEAD")) ? false : true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String method) {
        C14342f0.m8184p(method, "method");
        return C14342f0.m8193g(method, "POST") || C14342f0.m8193g(method, "PUT") || C14342f0.m8193g(method, "PATCH") || C14342f0.m8193g(method, "PROPPATCH") || C14342f0.m8193g(method, "REPORT");
    }

    public final boolean invalidatesCache(@NotNull String method) {
        C14342f0.m8184p(method, "method");
        return C14342f0.m8193g(method, "POST") || C14342f0.m8193g(method, "PATCH") || C14342f0.m8193g(method, "PUT") || C14342f0.m8193g(method, "DELETE") || C14342f0.m8193g(method, "MOVE");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        C14342f0.m8184p(method, "method");
        return !C14342f0.m8193g(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        C14342f0.m8184p(method, "method");
        return C14342f0.m8193g(method, "PROPFIND");
    }
}
