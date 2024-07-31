package com.acse.ottn.p041c;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* renamed from: com.acse.ottn.c.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1470a extends Converter.Factory {
    /* renamed from: a */
    public static C1470a m56694a() {
        return new C1470a();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new C1471b();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new C1472c(type);
    }
}
