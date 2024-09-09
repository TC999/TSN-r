package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import xyz.adscope.common.network.Response;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Converter {
    public static final Converter DEFAULT = new Converter() { // from class: xyz.adscope.common.network.simple.Converter.1
        @Override // xyz.adscope.common.network.simple.Converter
        public <S, F> SimpleResponse<S, F> convert(Type type, Type type2, Response response, boolean z3) {
            return SimpleResponse.newBuilder().code(response.code()).headers(response.headers()).fromCache(z3).succeed(type == String.class ? response.body().string() : null).build();
        }
    };

    <S, F> SimpleResponse<S, F> convert(Type type, Type type2, Response response, boolean z3);
}
