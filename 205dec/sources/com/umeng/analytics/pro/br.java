package com.umeng.analytics.pro;

import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.by;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TBase.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface br<T extends br<?, ?>, F extends by> extends Serializable {
    void clear();

    br<T, F> deepCopy();

    F fieldForId(int i4);

    void read(cq cqVar) throws bx;

    void write(cq cqVar) throws bx;
}
