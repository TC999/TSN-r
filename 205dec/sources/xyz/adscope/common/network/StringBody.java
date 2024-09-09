package xyz.adscope.common.network;

import android.text.TextUtils;
import java.io.OutputStream;
import java.nio.charset.Charset;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StringBody extends BaseContent<StringBody> implements RequestBody {

    /* renamed from: b  reason: collision with root package name */
    public final String f64843b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f64844c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64845d;

    public StringBody(String str) {
        this(str, Kalle.getConfig().getCharset());
    }

    public StringBody(String str, String str2) {
        this(str, Kalle.getConfig().getCharset(), str2);
    }

    public StringBody(String str, Charset charset) {
        this(str, charset, "application/octet-stream");
    }

    public StringBody(String str, Charset charset, String str2) {
        this.f64843b = str;
        this.f64844c = charset;
        this.f64845d = str2;
    }

    @Override // xyz.adscope.common.network.BaseContent
    public void a(OutputStream outputStream) {
        IOUtils.write(outputStream, this.f64843b, this.f64844c);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        if (TextUtils.isEmpty(this.f64843b)) {
            return 0L;
        }
        return IOUtils.toByteArray(this.f64843b, this.f64844c).length;
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        return this.f64845d + "; charset=" + this.f64844c.name();
    }

    public String toString() {
        return this.f64843b;
    }
}
