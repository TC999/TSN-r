package xyz.adscope.common.network.simple;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.ResponseBody;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ByteArrayBody implements ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    public String f64975a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f64976b;

    public ByteArrayBody(String str, byte[] bArr) {
        this.f64975a = str;
        this.f64976b = bArr;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public byte[] byteArray() {
        return this.f64976b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f64976b = null;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public InputStream stream() {
        return new ByteArrayInputStream(this.f64976b);
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public String string() {
        String parseSubValue = Headers.parseSubValue(this.f64975a, "charset", null);
        return TextUtils.isEmpty(parseSubValue) ? IOUtils.toString(this.f64976b) : IOUtils.toString(this.f64976b, parseSubValue);
    }
}
