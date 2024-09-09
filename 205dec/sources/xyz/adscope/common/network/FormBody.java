package xyz.adscope.common.network;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.util.IOUtils;
import xyz.adscope.common.network.util.LengthOutputStream;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FormBody extends BaseContent<FormBody> implements RequestBody {

    /* renamed from: b  reason: collision with root package name */
    public final Charset f64773b;

    /* renamed from: c  reason: collision with root package name */
    public final String f64774c;

    /* renamed from: d  reason: collision with root package name */
    public final Params f64775d;

    /* renamed from: e  reason: collision with root package name */
    public String f64776e;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Charset f64777a;

        /* renamed from: b  reason: collision with root package name */
        public String f64778b;

        /* renamed from: c  reason: collision with root package name */
        public Params.Builder f64779c;

        public Builder() {
            this.f64779c = Params.newBuilder();
        }

        public Builder binaries(String str, List<Binary> list) {
            this.f64779c.binaries(str, list);
            return this;
        }

        public Builder binary(String str, Binary binary) {
            this.f64779c.binary(str, binary);
            return this;
        }

        public FormBody build() {
            return new FormBody(this);
        }

        public Builder charset(Charset charset) {
            this.f64777a = charset;
            return this;
        }

        public Builder clearParams() {
            this.f64779c.clear();
            return this;
        }

        public Builder contentType(String str) {
            this.f64778b = str;
            return this;
        }

        public Builder file(String str, File file) {
            this.f64779c.file(str, file);
            return this;
        }

        public Builder files(String str, List<File> list) {
            this.f64779c.files(str, list);
            return this;
        }

        public Builder param(String str, char c4) {
            this.f64779c.add(str, c4);
            return this;
        }

        public Builder param(String str, double d4) {
            this.f64779c.add(str, d4);
            return this;
        }

        public Builder param(String str, float f4) {
            this.f64779c.add(str, f4);
            return this;
        }

        public Builder param(String str, int i4) {
            this.f64779c.add(str, i4);
            return this;
        }

        public Builder param(String str, long j4) {
            this.f64779c.add(str, j4);
            return this;
        }

        public Builder param(String str, CharSequence charSequence) {
            this.f64779c.add(str, charSequence);
            return this;
        }

        public Builder param(String str, String str2) {
            this.f64779c.add(str, str2);
            return this;
        }

        public Builder param(String str, List<String> list) {
            this.f64779c.add(str, list);
            return this;
        }

        public Builder param(String str, short s3) {
            this.f64779c.add(str, s3);
            return this;
        }

        public Builder param(String str, boolean z3) {
            this.f64779c.add(str, z3);
            return this;
        }

        public Builder params(Params params) {
            this.f64779c.add(params);
            return this;
        }

        public Builder removeParam(String str) {
            this.f64779c.remove(str);
            return this;
        }
    }

    public FormBody(Builder builder) {
        this.f64773b = builder.f64777a == null ? Kalle.getConfig().getCharset() : builder.f64777a;
        this.f64774c = TextUtils.isEmpty(builder.f64778b) ? "multipart/form-data" : builder.f64778b;
        this.f64775d = builder.f64779c.build();
        this.f64776e = a();
    }

    public static String a() {
        StringBuilder sb = new StringBuilder("-------FormBoundary");
        for (int i4 = 1; i4 < 12; i4++) {
            long currentTimeMillis = System.currentTimeMillis() + i4;
            long j4 = currentTimeMillis % 3;
            if (j4 == 0) {
                sb.append(((char) currentTimeMillis) % '\t');
            } else {
                sb.append((char) ((currentTimeMillis % 26) + (j4 == 1 ? 65L : 97L)));
            }
        }
        return sb.toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // xyz.adscope.common.network.BaseContent
    public void a(OutputStream outputStream) {
        for (String str : this.f64775d.keySet()) {
            for (Object obj : this.f64775d.get(str)) {
                if (obj instanceof String) {
                    a(outputStream, str, (String) obj);
                } else if (obj instanceof Binary) {
                    a(outputStream, str, (Binary) obj);
                }
            }
        }
        IOUtils.write(outputStream, "\r\n", this.f64773b);
        IOUtils.write(outputStream, "--" + this.f64776e + "--\r\n", this.f64773b);
    }

    public final void a(OutputStream outputStream, String str, String str2) {
        IOUtils.write(outputStream, "--" + this.f64776e + "\r\n", this.f64773b);
        IOUtils.write(outputStream, "Content-Disposition: form-data; name=\"" + str + "\"", this.f64773b);
        IOUtils.write(outputStream, "\r\n\r\n", this.f64773b);
        IOUtils.write(outputStream, str2, this.f64773b);
        IOUtils.write(outputStream, "\r\n", this.f64773b);
    }

    public final void a(OutputStream outputStream, String str, Binary binary) {
        IOUtils.write(outputStream, "--" + this.f64776e + "\r\n", this.f64773b);
        IOUtils.write(outputStream, "Content-Disposition: form-data; name=\"" + str + "\"", this.f64773b);
        IOUtils.write(outputStream, "; filename=\"" + binary.name() + "\"", this.f64773b);
        IOUtils.write(outputStream, "\r\n", this.f64773b);
        IOUtils.write(outputStream, "Content-Type: " + binary.contentType() + "\r\n\r\n", this.f64773b);
        if (outputStream instanceof LengthOutputStream) {
            ((LengthOutputStream) outputStream).write(binary.contentLength());
        } else {
            binary.writeTo(outputStream);
        }
        IOUtils.write(outputStream, "\r\n", this.f64773b);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        LengthOutputStream lengthOutputStream = new LengthOutputStream();
        try {
            a(lengthOutputStream);
        } catch (IOException unused) {
        }
        return lengthOutputStream.getLength();
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        return this.f64774c + "; boundary=" + this.f64776e;
    }

    public Params copyParams() {
        return this.f64775d;
    }
}
