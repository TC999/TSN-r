package com.baidu.mobads.sdk.internal;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ar implements Comparator<Map.Entry<String, Long>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f12415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.f12415a = aqVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
