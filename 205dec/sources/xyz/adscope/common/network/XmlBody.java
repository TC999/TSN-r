package xyz.adscope.common.network;

import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class XmlBody extends StringBody {
    public XmlBody(String str) {
        this(str, Kalle.getConfig().getCharset());
    }

    public XmlBody(String str, Charset charset) {
        super(str, charset, Headers.VALUE_APPLICATION_XML);
    }
}
