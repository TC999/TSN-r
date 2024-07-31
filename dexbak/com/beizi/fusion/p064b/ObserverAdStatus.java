package com.beizi.fusion.p064b;

import com.beizi.fusion.p064b.AdProcessStatus;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.C3116af;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.beizi.fusion.b.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ObserverAdStatus implements Observer {

    /* renamed from: a */
    public AdProcessStatus.C3050i f10958a;

    /* renamed from: b */
    public AdProcessStatus.C3049h f10959b;

    /* renamed from: c */
    public AdProcessStatus.C3052k f10960c;

    /* renamed from: d */
    public AdProcessStatus.C3048g f10961d;

    /* renamed from: e */
    public AdProcessStatus.C3045d f10962e;

    /* renamed from: f */
    public AdProcessStatus.C3046e f10963f;

    /* renamed from: g */
    public AdProcessStatus.C3047f f10964g;

    /* renamed from: h */
    public AdProcessStatus.C3044c f10965h;

    /* renamed from: i */
    public AdProcessStatus.C3043b f10966i;

    /* renamed from: j */
    public AdProcessStatus.C3051j f10967j;

    /* renamed from: k */
    public AdProcessStatus.C3042a f10968k;

    /* renamed from: l */
    private final AdProcessStatus f10969l;

    /* renamed from: m */
    private EventBean f10970m;

    /* renamed from: n */
    private boolean f10971n = false;

    public ObserverAdStatus(EventBean eventBean) {
        this.f10970m = eventBean;
        AdProcessStatus adProcessStatus = new AdProcessStatus();
        this.f10969l = adProcessStatus;
        this.f10958a = new AdProcessStatus.C3050i();
        this.f10959b = new AdProcessStatus.C3049h();
        this.f10960c = new AdProcessStatus.C3052k();
        this.f10961d = new AdProcessStatus.C3048g();
        this.f10962e = new AdProcessStatus.C3045d();
        this.f10963f = new AdProcessStatus.C3046e();
        this.f10964g = new AdProcessStatus.C3047f();
        this.f10965h = new AdProcessStatus.C3044c();
        this.f10966i = new AdProcessStatus.C3043b();
        this.f10967j = new AdProcessStatus.C3051j();
        this.f10968k = new AdProcessStatus.C3042a();
    }

    /* renamed from: a */
    public AdProcessStatus m48860a() {
        return this.f10969l;
    }

    /* renamed from: b */
    public EventBean m48858b() {
        return this.f10970m;
    }

    /* renamed from: c */
    public boolean m48857c() {
        return this.f10971n;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof AdProcessStatus.C3053l) && (obj instanceof EventBean)) {
            EventBean eventBean = (EventBean) obj;
            String m48902k = eventBean.m48902k();
            String m48916d = eventBean.m48916d();
            int m48939O = eventBean.m48939O();
            String m48937P = eventBean.m48937P();
            String m48935Q = eventBean.m48935Q();
            String m48918c = eventBean.m48918c();
            C3116af.m48496a("BeiZis", "channel == " + m48902k + ",eventCode = " + m48916d + ";buyerSpaceId:" + eventBean.m48886s() + ",srcType = " + m48939O + ",price = " + m48937P + ",bidPrice = " + m48935Q + ",eventId = " + m48918c + ",buyerSpaceId = " + eventBean.m48898m());
            EventCar.m48869a(AdManager.m48786a().m48778e()).m48868a(eventBean);
        }
    }

    /* renamed from: a */
    public void m48859a(boolean z) {
        this.f10971n = z;
    }
}
