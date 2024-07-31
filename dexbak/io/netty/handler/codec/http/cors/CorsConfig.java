package io.netty.handler.codec.http.cors;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class CorsConfig {
    private final boolean allowCredentials;
    private final boolean allowNullOrigin;
    private final Set<String> allowedRequestHeaders;
    private final Set<HttpMethod> allowedRequestMethods;
    private final boolean anyOrigin;
    private final boolean enabled;
    private final Set<String> exposeHeaders;
    private final long maxAge;
    private final Set<String> origins;
    private final Map<CharSequence, Callable<?>> preflightHeaders;
    private final boolean shortCircuit;

    @Deprecated
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Builder {
        private final CorsConfigBuilder builder;

        @Deprecated
        public Builder(String... strArr) {
            this.builder = new CorsConfigBuilder(strArr);
        }

        @Deprecated
        public Builder allowCredentials() {
            this.builder.allowCredentials();
            return this;
        }

        @Deprecated
        public Builder allowNullOrigin() {
            this.builder.allowNullOrigin();
            return this;
        }

        @Deprecated
        public Builder allowedRequestHeaders(String... strArr) {
            this.builder.allowedRequestHeaders(strArr);
            return this;
        }

        @Deprecated
        public Builder allowedRequestMethods(HttpMethod... httpMethodArr) {
            this.builder.allowedRequestMethods(httpMethodArr);
            return this;
        }

        @Deprecated
        public CorsConfig build() {
            return this.builder.build();
        }

        @Deprecated
        public Builder disable() {
            this.builder.disable();
            return this;
        }

        @Deprecated
        public Builder exposeHeaders(String... strArr) {
            this.builder.exposeHeaders(strArr);
            return this;
        }

        @Deprecated
        public Builder maxAge(long j) {
            this.builder.maxAge(j);
            return this;
        }

        @Deprecated
        public Builder noPreflightResponseHeaders() {
            this.builder.noPreflightResponseHeaders();
            return this;
        }

        @Deprecated
        public Builder preflightResponseHeader(CharSequence charSequence, Object... objArr) {
            this.builder.preflightResponseHeader(charSequence, objArr);
            return this;
        }

        @Deprecated
        public Builder shortCurcuit() {
            this.builder.shortCircuit();
            return this;
        }

        @Deprecated
        public <T> Builder preflightResponseHeader(CharSequence charSequence, Iterable<T> iterable) {
            this.builder.preflightResponseHeader(charSequence, iterable);
            return this;
        }

        @Deprecated
        public Builder() {
            this.builder = new CorsConfigBuilder();
        }

        @Deprecated
        public <T> Builder preflightResponseHeader(String str, Callable<T> callable) {
            this.builder.preflightResponseHeader(str, callable);
            return this;
        }
    }

    @Deprecated
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class DateValueGenerator implements Callable<Date> {
        @Override // java.util.concurrent.Callable
        public Date call() throws Exception {
            return new Date();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CorsConfig(CorsConfigBuilder corsConfigBuilder) {
        this.origins = new LinkedHashSet(corsConfigBuilder.origins);
        this.anyOrigin = corsConfigBuilder.anyOrigin;
        this.enabled = corsConfigBuilder.enabled;
        this.exposeHeaders = corsConfigBuilder.exposeHeaders;
        this.allowCredentials = corsConfigBuilder.allowCredentials;
        this.maxAge = corsConfigBuilder.maxAge;
        this.allowedRequestMethods = corsConfigBuilder.requestMethods;
        this.allowedRequestHeaders = corsConfigBuilder.requestHeaders;
        this.allowNullOrigin = corsConfigBuilder.allowNullOrigin;
        this.preflightHeaders = corsConfigBuilder.preflightHeaders;
        this.shortCircuit = corsConfigBuilder.shortCircuit;
    }

    private static <T> T getValue(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new IllegalStateException("Could not generate value for callable [" + callable + ']', e);
        }
    }

    @Deprecated
    public static Builder withAnyOrigin() {
        return new Builder();
    }

    @Deprecated
    public static Builder withOrigin(String str) {
        if ("*".equals(str)) {
            return new Builder();
        }
        return new Builder(str);
    }

    @Deprecated
    public static Builder withOrigins(String... strArr) {
        return new Builder(strArr);
    }

    public Set<String> allowedRequestHeaders() {
        return Collections.unmodifiableSet(this.allowedRequestHeaders);
    }

    public Set<HttpMethod> allowedRequestMethods() {
        return Collections.unmodifiableSet(this.allowedRequestMethods);
    }

    public Set<String> exposedHeaders() {
        return Collections.unmodifiableSet(this.exposeHeaders);
    }

    public boolean isAnyOriginSupported() {
        return this.anyOrigin;
    }

    public boolean isCorsSupportEnabled() {
        return this.enabled;
    }

    public boolean isCredentialsAllowed() {
        return this.allowCredentials;
    }

    public boolean isNullOriginAllowed() {
        return this.allowNullOrigin;
    }

    public boolean isShortCircuit() {
        return this.shortCircuit;
    }

    @Deprecated
    public boolean isShortCurcuit() {
        return isShortCircuit();
    }

    public long maxAge() {
        return this.maxAge;
    }

    public String origin() {
        return this.origins.isEmpty() ? "*" : this.origins.iterator().next();
    }

    public Set<String> origins() {
        return this.origins;
    }

    public HttpHeaders preflightResponseHeaders() {
        if (this.preflightHeaders.isEmpty()) {
            return EmptyHttpHeaders.INSTANCE;
        }
        DefaultHttpHeaders defaultHttpHeaders = new DefaultHttpHeaders();
        for (Map.Entry<CharSequence, Callable<?>> entry : this.preflightHeaders.entrySet()) {
            Object value = getValue(entry.getValue());
            if (value instanceof Iterable) {
                defaultHttpHeaders.add(entry.getKey(), (Iterable) value);
            } else {
                defaultHttpHeaders.add(entry.getKey(), value);
            }
        }
        return defaultHttpHeaders;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[enabled=" + this.enabled + ", origins=" + this.origins + ", anyOrigin=" + this.anyOrigin + ", exposedHeaders=" + this.exposeHeaders + ", isCredentialsAllowed=" + this.allowCredentials + ", maxAge=" + this.maxAge + ", allowedRequestMethods=" + this.allowedRequestMethods + ", allowedRequestHeaders=" + this.allowedRequestHeaders + ", preflightHeaders=" + this.preflightHeaders + ']';
    }
}
