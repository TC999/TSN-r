package xyz.adscope.common.network;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Type;
import xyz.adscope.common.R;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.network.simple.Converter;
import xyz.adscope.common.network.simple.SimpleResponse;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class JsonConverter implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public Context f64780a;

    public JsonConverter(Context context) {
        this.f64780a = context;
    }

    @Override // xyz.adscope.common.network.simple.Converter
    public <S, F> SimpleResponse<S, F> convert(Type type, Type type2, Response response, boolean z3) {
        Context context;
        int i4;
        int code = response.code();
        String string = response.body().string();
        LogUtil.i(CommonConstants.TAG, "JsonConverter response code : " + code + " , serverJson : " + string);
        String str = null;
        if (code < 200 || code >= 300) {
            if (code == 302) {
                string = response.toString();
            } else {
                if (code >= 400 && code < 500) {
                    context = this.f64780a;
                    i4 = R.string.adscope_server_unknown_exception;
                } else if (code >= 500) {
                    context = this.f64780a;
                    i4 = R.string.adscope_server_not_response;
                } else {
                    string = null;
                }
                string = null;
                str = context.getString(i4);
            }
        } else if (Build.VERSION.SDK_INT >= 28) {
            type.getTypeName().equals("java.lang.String");
        }
        return SimpleResponse.newBuilder().code(response.code()).headers(response.headers()).fromCache(z3).succeed(string).failed(str).build();
    }
}
