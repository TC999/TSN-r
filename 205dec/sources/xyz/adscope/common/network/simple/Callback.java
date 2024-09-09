package xyz.adscope.common.network.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class Callback<Succeed, Failed> {
    public Type getFailed() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Type getSucceed() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public abstract void onCancel();

    public abstract void onEnd();

    public abstract void onException(Exception exc);

    public abstract void onResponse(SimpleResponse<Succeed, Failed> simpleResponse);

    public abstract void onStart();
}
