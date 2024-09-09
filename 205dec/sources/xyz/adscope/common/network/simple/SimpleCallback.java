package xyz.adscope.common.network.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class SimpleCallback<V> extends Callback<V, String> {
    @Override // xyz.adscope.common.network.simple.Callback
    public Type getFailed() {
        return String.class;
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public Type getSucceed() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onCancel() {
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onEnd() {
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onException(Exception exc) {
    }

    @Override // xyz.adscope.common.network.simple.Callback
    public void onStart() {
    }
}
