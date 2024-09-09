package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BasicMarkerFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b implements org.slf4j.b {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<String, Marker> f61744a = new ConcurrentHashMap();

    @Override // org.slf4j.b
    public Marker a(String str) {
        if (str != null) {
            Marker marker = this.f61744a.get(str);
            if (marker == null) {
                BasicMarker basicMarker = new BasicMarker(str);
                Marker putIfAbsent = this.f61744a.putIfAbsent(str, basicMarker);
                return putIfAbsent != null ? putIfAbsent : basicMarker;
            }
            return marker;
        }
        throw new IllegalArgumentException("Marker name cannot be null");
    }

    @Override // org.slf4j.b
    public boolean b(String str) {
        return (str == null || this.f61744a.remove(str) == null) ? false : true;
    }

    @Override // org.slf4j.b
    public Marker c(String str) {
        return new BasicMarker(str);
    }

    @Override // org.slf4j.b
    public boolean d(String str) {
        if (str == null) {
            return false;
        }
        return this.f61744a.containsKey(str);
    }
}
