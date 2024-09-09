package xyz.adscope.common.network;

import android.text.TextUtils;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UrlBody extends BaseContent<StringBody> implements RequestBody {

    /* renamed from: b  reason: collision with root package name */
    public final Params f64858b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f64859c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64860d;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Charset f64861a;

        /* renamed from: b  reason: collision with root package name */
        public String f64862b;

        /* renamed from: c  reason: collision with root package name */
        public Params.Builder f64863c;

        public Builder() {
            this.f64863c = Params.newBuilder();
        }

        public UrlBody build() {
            return new UrlBody(this);
        }

        public Builder charset(Charset charset) {
            this.f64861a = charset;
            return this;
        }

        public Builder clearParams() {
            this.f64863c.clear();
            return this;
        }

        public Builder contentType(String str) {
            this.f64862b = str;
            return this;
        }

        public Builder param(String str, char c4) {
            this.f64863c.add(str, c4);
            return this;
        }

        public Builder param(String str, double d4) {
            this.f64863c.add(str, d4);
            return this;
        }

        public Builder param(String str, float f4) {
            this.f64863c.add(str, f4);
            return this;
        }

        public Builder param(String str, int i4) {
            this.f64863c.add(str, i4);
            return this;
        }

        public Builder param(String str, long j4) {
            this.f64863c.add(str, j4);
            return this;
        }

        public Builder param(String str, CharSequence charSequence) {
            this.f64863c.add(str, charSequence);
            return this;
        }

        public Builder param(String str, String str2) {
            this.f64863c.add(str, str2);
            return this;
        }

        public Builder param(String str, List<String> list) {
            this.f64863c.add(str, list);
            return this;
        }

        public Builder param(String str, short s3) {
            this.f64863c.add(str, s3);
            return this;
        }

        public Builder param(String str, boolean z3) {
            this.f64863c.add(str, z3);
            return this;
        }

        public Builder params(Params params) {
            this.f64863c.add(params);
            return this;
        }

        public Builder removeParam(String str) {
            this.f64863c.remove(str);
            return this;
        }
    }

    public UrlBody(Builder builder) {
        this.f64858b = builder.f64863c.build();
        this.f64859c = builder.f64861a == null ? Kalle.getConfig().getCharset() : builder.f64861a;
        this.f64860d = TextUtils.isEmpty(builder.f64862b) ? "application/x-www-form-urlencoded" : builder.f64862b;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // xyz.adscope.common.network.BaseContent
    public void a(OutputStream outputStream) {
        IOUtils.write(outputStream, this.f64858b.toString(true), this.f64859c);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        return IOUtils.toByteArray(this.f64858b.toString(true), this.f64859c).length;
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        return this.f64860d + "; charset=" + this.f64859c.name();
    }

    public Params copyParams() {
        return this.f64858b;
    }

    public String toString() {
        return toString(false);
    }

    public String toString(boolean z3) {
        return this.f64858b.toString(z3);
    }
}
