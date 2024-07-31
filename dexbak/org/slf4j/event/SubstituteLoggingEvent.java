package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* renamed from: org.slf4j.event.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SubstituteLoggingEvent implements LoggingEvent {

    /* renamed from: a */
    Level f44332a;

    /* renamed from: b */
    Marker f44333b;

    /* renamed from: c */
    String f44334c;

    /* renamed from: d */
    SubstituteLogger f44335d;

    /* renamed from: e */
    String f44336e;

    /* renamed from: f */
    String f44337f;

    /* renamed from: g */
    Object[] f44338g;

    /* renamed from: h */
    long f44339h;

    /* renamed from: i */
    Throwable f44340i;

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: a */
    public Object[] mo2632a() {
        return this.f44338g;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: b */
    public Marker mo2631b() {
        return this.f44333b;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: c */
    public String mo2630c() {
        return this.f44336e;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: d */
    public long mo2629d() {
        return this.f44339h;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: e */
    public String mo2628e() {
        return this.f44334c;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: f */
    public Level mo2627f() {
        return this.f44332a;
    }

    @Override // org.slf4j.event.LoggingEvent
    /* renamed from: g */
    public Throwable mo2626g() {
        return this.f44340i;
    }

    @Override // org.slf4j.event.LoggingEvent
    public String getMessage() {
        return this.f44337f;
    }

    /* renamed from: h */
    public SubstituteLogger m2625h() {
        return this.f44335d;
    }

    /* renamed from: i */
    public void m2624i(Object[] objArr) {
        this.f44338g = objArr;
    }

    /* renamed from: j */
    public void m2623j(Level level) {
        this.f44332a = level;
    }

    /* renamed from: k */
    public void m2622k(SubstituteLogger substituteLogger) {
        this.f44335d = substituteLogger;
    }

    /* renamed from: l */
    public void m2621l(String str) {
        this.f44334c = str;
    }

    /* renamed from: m */
    public void m2620m(Marker marker) {
        this.f44333b = marker;
    }

    /* renamed from: n */
    public void m2619n(String str) {
        this.f44337f = str;
    }

    /* renamed from: o */
    public void m2618o(String str) {
        this.f44336e = str;
    }

    /* renamed from: p */
    public void m2617p(Throwable th) {
        this.f44340i = th;
    }

    /* renamed from: q */
    public void m2616q(long j) {
        this.f44339h = j;
    }
}
