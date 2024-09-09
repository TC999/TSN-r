package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.BiFunction
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
