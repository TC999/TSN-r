package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FastjsonSockJsMessageCodec extends AbstractSockJsMessageCodec {
    protected char[] applyJsonQuoting(String str) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write(str);
            return serializeWriter.toCharArrayForSpringWebSocket();
        } finally {
            serializeWriter.close();
        }
    }

    public String[] decode(String str) throws IOException {
        return (String[]) JSON.parseObject(str, String[].class);
    }

    public String[] decodeInputStream(InputStream inputStream) throws IOException {
        return (String[]) JSON.parseObject(inputStream, String[].class, new Feature[0]);
    }
}
