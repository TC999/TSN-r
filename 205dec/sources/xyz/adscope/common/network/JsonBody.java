package xyz.adscope.common.network;

import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class JsonBody extends StringBody {
    public JsonBody(String str) {
        this(str, Kalle.getConfig().getCharset());
    }

    public JsonBody(String str, Charset charset) {
        super(str, charset, "application/json");
    }
}
