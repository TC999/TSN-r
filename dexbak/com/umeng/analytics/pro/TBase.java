package com.umeng.analytics.pro;

import com.umeng.analytics.pro.TBase;
import com.umeng.analytics.pro.TFieldIdEnum;
import java.io.Serializable;

/* renamed from: com.umeng.analytics.pro.br */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface TBase<T extends TBase<?, ?>, F extends TFieldIdEnum> extends Serializable {
    void clear();

    TBase<T, F> deepCopy();

    F fieldForId(int i);

    void read(TProtocol tProtocol) throws TException;

    void write(TProtocol tProtocol) throws TException;
}
