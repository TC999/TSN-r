package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.InterfaceC15424c;
import org.slf4j.event.SubstituteLoggingEvent;

/* renamed from: org.slf4j.helpers.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {

    /* renamed from: a */
    boolean f44360a = false;

    /* renamed from: b */
    final Map<String, SubstituteLogger> f44361b = new HashMap();

    /* renamed from: c */
    final LinkedBlockingQueue<SubstituteLoggingEvent> f44362c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    /* renamed from: a */
    public synchronized InterfaceC15424c mo2557a(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = this.f44361b.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.f44362c, this.f44360a);
            this.f44361b.put(str, substituteLogger);
        }
        return substituteLogger;
    }

    /* renamed from: b */
    public void m2573b() {
        this.f44361b.clear();
        this.f44362c.clear();
    }

    /* renamed from: c */
    public LinkedBlockingQueue<SubstituteLoggingEvent> m2572c() {
        return this.f44362c;
    }

    /* renamed from: d */
    public List<String> m2571d() {
        return new ArrayList(this.f44361b.keySet());
    }

    /* renamed from: e */
    public List<SubstituteLogger> m2570e() {
        return new ArrayList(this.f44361b.values());
    }

    /* renamed from: f */
    public void m2569f() {
        this.f44360a = true;
    }
}
