package xyz.adscope.common.network.connect;

import android.text.TextUtils;
import java.io.InputStream;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.ResponseBody;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class StreamBody implements ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    public String f64871a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f64872b;

    public StreamBody(String str, InputStream inputStream) {
        this.f64871a = str;
        this.f64872b = inputStream;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public byte[] byteArray() {
        return IOUtils.toByteArray(this.f64872b);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f64872b.close();
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public InputStream stream() {
        return this.f64872b;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public String string() {
        String parseSubValue = Headers.parseSubValue(this.f64871a, "charset", null);
        return TextUtils.isEmpty(parseSubValue) ? IOUtils.toString(this.f64872b) : IOUtils.toString(this.f64872b, parseSubValue);
    }
}
