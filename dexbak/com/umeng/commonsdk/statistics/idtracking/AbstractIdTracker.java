package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.proto.IdJournal;
import com.umeng.commonsdk.statistics.proto.IdSnapshot;
import com.umeng.commonsdk.statistics.proto.IdTracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractIdTracker {

    /* renamed from: a */
    private final int f38975a = 10;

    /* renamed from: b */
    private final int f38976b = 100;

    /* renamed from: c */
    private final String f38977c;

    /* renamed from: d */
    private List<IdJournal> f38978d;

    /* renamed from: e */
    private IdSnapshot f38979e;

    public AbstractIdTracker(String str) {
        this.f38977c = str;
    }

    /* renamed from: g */
    private boolean m13710g() {
        IdSnapshot idSnapshot = this.f38979e;
        String m13613b = idSnapshot == null ? null : idSnapshot.m13613b();
        int m13604h = idSnapshot == null ? 0 : idSnapshot.m13604h();
        String m13716a = m13716a(mo13690f());
        if (m13716a == null || m13716a.equals(m13613b)) {
            return false;
        }
        if (idSnapshot == null) {
            idSnapshot = new IdSnapshot();
        }
        idSnapshot.m13615a(m13716a);
        idSnapshot.m13618a(System.currentTimeMillis());
        idSnapshot.m13619a(m13604h + 1);
        IdJournal idJournal = new IdJournal();
        idJournal.m13654a(this.f38977c);
        idJournal.m13648c(m13716a);
        idJournal.m13651b(m13613b);
        idJournal.m13657a(idSnapshot.m13607e());
        if (this.f38978d == null) {
            this.f38978d = new ArrayList(2);
        }
        this.f38978d.add(idJournal);
        if (this.f38978d.size() > 10) {
            this.f38978d.remove(0);
        }
        this.f38979e = idSnapshot;
        return true;
    }

    /* renamed from: a */
    public boolean m13719a() {
        return m13710g();
    }

    /* renamed from: b */
    public String m13714b() {
        return this.f38977c;
    }

    /* renamed from: c */
    public boolean m13713c() {
        IdSnapshot idSnapshot = this.f38979e;
        return idSnapshot == null || idSnapshot.m13604h() <= 100;
    }

    /* renamed from: d */
    public IdSnapshot m13712d() {
        return this.f38979e;
    }

    /* renamed from: e */
    public List<IdJournal> m13711e() {
        return this.f38978d;
    }

    /* renamed from: f */
    public abstract String mo13690f();

    /* renamed from: a */
    public void m13718a(IdSnapshot idSnapshot) {
        this.f38979e = idSnapshot;
    }

    /* renamed from: a */
    public void m13715a(List<IdJournal> list) {
        this.f38978d = list;
    }

    /* renamed from: a */
    public String m13716a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public void m13717a(IdTracking idTracking) {
        this.f38979e = idTracking.m13575c().get(this.f38977c);
        List<IdJournal> m13569h = idTracking.m13569h();
        if (m13569h == null || m13569h.size() <= 0) {
            return;
        }
        if (this.f38978d == null) {
            this.f38978d = new ArrayList();
        }
        for (IdJournal idJournal : m13569h) {
            if (this.f38977c.equals(idJournal.f39041a)) {
                this.f38978d.add(idJournal);
            }
        }
    }
}
