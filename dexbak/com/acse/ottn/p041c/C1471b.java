package com.acse.ottn.p041c;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* renamed from: com.acse.ottn.c.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1471b<T> implements Converter<T, RequestBody> {

    /* renamed from: a */
    private static final MediaType f2701a = MediaType.parse("application/json; charset=UTF-8");

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((C1471b<T>) obj);
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t) throws IOException {
        return RequestBody.create(f2701a, JSON.toJSONBytes(t, new SerializerFeature[0]));
    }
}
