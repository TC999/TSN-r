package com.acse.ottn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class y0<T> implements Converter<T, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f7002a = MediaType.parse("application/json; charset=UTF-8");

    @Override // retrofit2.Converter
    /* renamed from: a */
    public RequestBody convert(T t3) throws IOException {
        return RequestBody.create(f7002a, JSON.toJSONBytes(t3, new SerializerFeature[0]));
    }
}
