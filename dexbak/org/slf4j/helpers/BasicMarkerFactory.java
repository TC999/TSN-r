package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

/* renamed from: org.slf4j.helpers.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class BasicMarkerFactory implements IMarkerFactory {

    /* renamed from: a */
    private final ConcurrentMap<String, Marker> f44344a = new ConcurrentHashMap();

    @Override // org.slf4j.IMarkerFactory
    /* renamed from: a */
    public Marker mo2609a(String str) {
        if (str != null) {
            Marker marker = this.f44344a.get(str);
            if (marker == null) {
                BasicMarker basicMarker = new BasicMarker(str);
                Marker putIfAbsent = this.f44344a.putIfAbsent(str, basicMarker);
                return putIfAbsent != null ? putIfAbsent : basicMarker;
            }
            return marker;
        }
        throw new IllegalArgumentException("Marker name cannot be null");
    }

    @Override // org.slf4j.IMarkerFactory
    /* renamed from: b */
    public boolean mo2608b(String str) {
        return (str == null || this.f44344a.remove(str) == null) ? false : true;
    }

    @Override // org.slf4j.IMarkerFactory
    /* renamed from: c */
    public Marker mo2607c(String str) {
        return new BasicMarker(str);
    }

    @Override // org.slf4j.IMarkerFactory
    /* renamed from: d */
    public boolean mo2606d(String str) {
        if (str == null) {
            return false;
        }
        return this.f44344a.containsKey(str);
    }
}
