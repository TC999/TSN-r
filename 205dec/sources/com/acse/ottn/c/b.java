package com.acse.ottn.c;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b<T> implements Converter<T, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    private static final MediaType f5312a = MediaType.parse("application/json; charset=UTF-8");

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((b<T>) obj);
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t3) throws IOException {
        return RequestBody.create(f5312a, JSON.toJSONBytes(t3, new SerializerFeature[0]));
    }
}
