package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Retrofit2ConverterFactory extends Converter.Factory {
    private Feature[] features;
    private SerializeConfig serializeConfig;
    private SerializerFeature[] serializerFeatures;
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
    private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
    private int featureValues = JSON.DEFAULT_PARSER_FEATURE;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class RequestBodyConverter<T> implements Converter<T, RequestBody> {
        RequestBodyConverter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
            return convert2((RequestBodyConverter<T>) obj);
        }

        @Override // retrofit2.Converter
        /* renamed from: convert  reason: avoid collision after fix types in other method */
        public RequestBody convert2(T t3) throws IOException {
            return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, JSON.toJSONBytes(t3, Retrofit2ConverterFactory.this.serializeConfig == null ? SerializeConfig.globalInstance : Retrofit2ConverterFactory.this.serializeConfig, Retrofit2ConverterFactory.this.serializerFeatures == null ? SerializerFeature.EMPTY : Retrofit2ConverterFactory.this.serializerFeatures));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        private Type type;

        ResponseBodyConverter(Type type) {
            this.type = type;
        }

        @Override // retrofit2.Converter
        public T convert(ResponseBody responseBody) throws IOException {
            Feature[] featureArr;
            try {
                String string = responseBody.string();
                Type type = this.type;
                ParserConfig parserConfig = Retrofit2ConverterFactory.this.parserConfig;
                int i4 = Retrofit2ConverterFactory.this.featureValues;
                if (Retrofit2ConverterFactory.this.features != null) {
                    featureArr = Retrofit2ConverterFactory.this.features;
                } else {
                    featureArr = Retrofit2ConverterFactory.EMPTY_SERIALIZER_FEATURES;
                }
                return (T) JSON.parseObject(string, type, parserConfig, i4, featureArr);
            } finally {
                responseBody.close();
            }
        }
    }

    public ParserConfig getParserConfig() {
        return this.parserConfig;
    }

    public int getParserFeatureValues() {
        return this.featureValues;
    }

    public Feature[] getParserFeatures() {
        return this.features;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new RequestBodyConverter();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new ResponseBodyConverter(type);
    }

    public Retrofit2ConverterFactory setParserConfig(ParserConfig parserConfig) {
        this.parserConfig = parserConfig;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatureValues(int i4) {
        this.featureValues = i4;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatures(Feature[] featureArr) {
        this.features = featureArr;
        return this;
    }

    public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
        return this;
    }

    public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
        return this;
    }
}
