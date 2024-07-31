package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class FastJsonpHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {
    private static final byte[] JSONP_FUNCTION_PREFIX_BYTES;
    private static final byte[] JSONP_FUNCTION_SUFFIX_BYTES;
    private FastJsonConfig fastJsonConfig;

    static {
        Charset charset = IOUtils.UTF8;
        JSONP_FUNCTION_PREFIX_BYTES = "/**/".getBytes(charset);
        JSONP_FUNCTION_SUFFIX_BYTES = ");".getBytes(charset);
    }

    public FastJsonpHttpMessageConverter4() {
        super(MediaType.ALL);
        this.fastJsonConfig = new FastJsonConfig();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), cls, this.fastJsonConfig.getFeatures());
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    protected boolean supports(Class<?> cls) {
        return true;
    }

    protected void writeInternal(Object obj, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = httpOutputMessage.getHeaders();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int writePrefix = writePrefix(byteArrayOutputStream, obj) + JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getValue() : obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures()) + writeSuffix(byteArrayOutputStream, obj);
        if (this.fastJsonConfig.isWriteContentLength()) {
            headers.setContentLength(writePrefix);
        }
        byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
        byteArrayOutputStream.close();
    }

    protected int writePrefix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        String jsonpFunction = obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null;
        if (jsonpFunction != null) {
            byte[] bArr = JSONP_FUNCTION_PREFIX_BYTES;
            byteArrayOutputStream.write(bArr);
            byte[] bytes = (jsonpFunction + "(").getBytes(IOUtils.UTF8);
            byteArrayOutputStream.write(bytes);
            return 0 + bArr.length + bytes.length;
        }
        return 0;
    }

    protected int writeSuffix(ByteArrayOutputStream byteArrayOutputStream, Object obj) throws IOException {
        if ((obj instanceof MappingFastJsonValue ? ((MappingFastJsonValue) obj).getJsonpFunction() : null) != null) {
            byte[] bArr = JSONP_FUNCTION_SUFFIX_BYTES;
            byteArrayOutputStream.write(bArr);
            return 0 + bArr.length;
        }
        return 0;
    }
}
