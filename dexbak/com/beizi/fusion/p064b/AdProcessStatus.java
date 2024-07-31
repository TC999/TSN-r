package com.beizi.fusion.p064b;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p071f.AdStrategy;
import com.beizi.fusion.p072g.C3116af;
import com.github.mikephil.charting.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* renamed from: com.beizi.fusion.b.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdProcessStatus {

    /* renamed from: a */
    public static SparseArray<String> f10871a = new SparseArray<>();

    /* renamed from: b */
    public static SparseArray<String> f10872b = new SparseArray<>();

    /* renamed from: c */
    public static SparseArray<String> f10873c = new SparseArray<>();

    /* renamed from: d */
    public static SparseArray<String> f10874d = new SparseArray<>();

    /* renamed from: e */
    public static SparseArray<String> f10875e = new SparseArray<>();

    /* renamed from: f */
    public static SparseArray<String> f10876f = new SparseArray<>();

    /* renamed from: g */
    public static SparseArray<String> f10877g = new SparseArray<>();

    /* renamed from: h */
    public static SparseArray<String> f10878h = new SparseArray<>();

    /* renamed from: i */
    public static SparseArray<String> f10879i = new SparseArray<>();

    /* renamed from: j */
    public static SparseArray<String> f10880j = new SparseArray<>();

    /* renamed from: k */
    public static SparseArray<String> f10881k = new SparseArray<>();

    /* renamed from: l */
    private HashMap<String, Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean>> f10882l = new HashMap<>();

    /* renamed from: m */
    private HashMap<String, EventBean> f10883m = new HashMap<>();

    /* renamed from: n */
    private EventBean f10884n;

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3042a extends C3053l {
        public C3042a() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3043b extends C3053l {
        public C3043b() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3044c extends C3053l {
        public C3044c() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3045d extends C3053l {
        public C3045d() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3046e extends C3053l {
        public C3046e() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3047f extends C3053l {
        public C3047f() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3048g extends C3053l {
        public C3048g() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3049h extends C3053l {
        public C3049h() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3050i extends C3053l {
        public C3050i() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$j */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3051j extends C3053l {
        public C3051j() {
            super();
        }
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$k */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3052k extends C3053l {
        public C3052k() {
            super();
        }
    }

    static {
        f10871a.put(1, "100.000");
        f10871a.put(2, "100.200");
        f10872b.put(-1, "210.400");
        f10872b.put(-2, "210.999");
        f10872b.put(1, "200.001");
        f10872b.put(2, "210.100");
        f10872b.put(3, "210.200");
        f10872b.put(4, "210.401");
        f10872b.put(5, "210.402");
        f10872b.put(6, "210.403");
        f10872b.put(7, "210.404");
        f10873c.put(-1, "220.400");
        f10873c.put(-2, "220.999");
        f10873c.put(1, "220.000");
        f10873c.put(2, "200.000");
        f10873c.put(3, "220.401");
        f10873c.put(4, "220.402");
        f10873c.put(5, "220.403");
        f10873c.put(6, "220.404");
        f10874d.put(-1, "230.400");
        f10874d.put(-2, "230.999");
        f10874d.put(1, "230.000");
        f10874d.put(2, "230.200");
        f10874d.put(3, "230.401");
        f10874d.put(4, "230.402");
        f10875e.put(-1, "245.400");
        f10875e.put(-2, "245.999");
        f10875e.put(1, "240.000");
        f10875e.put(2, "245.000");
        f10875e.put(3, "245.200");
        f10875e.put(4, "245.401");
        f10875e.put(5, "245.402");
        f10875e.put(6, "245.403");
        f10875e.put(7, "245.404");
        f10875e.put(8, "245.300");
        f10875e.put(9, "240.100");
        f10875e.put(10, "245.405");
        f10876f.put(-1, "249.400");
        f10876f.put(-2, "249.999");
        f10876f.put(1, "248.000");
        f10876f.put(2, "249.000");
        f10876f.put(3, "248.401");
        f10876f.put(4, "248.402");
        f10876f.put(5, "249.401");
        f10876f.put(6, "249.402");
        f10877g.put(-1, "280.600");
        f10877g.put(1, "250.100");
        f10877g.put(2, "250.200");
        f10877g.put(16, "250.401");
        f10877g.put(3, "255.200");
        f10877g.put(4, "280.200");
        f10877g.put(5, "280.280");
        f10877g.put(6, "280.300");
        f10877g.put(12, "280.350");
        f10877g.put(7, "290.300");
        f10877g.put(17, "290.301");
        f10877g.put(8, "280.400");
        f10877g.put(9, "280.450");
        f10877g.put(11, "280.500");
        f10877g.put(13, "280.301");
        f10877g.put(14, "280.302");
        f10877g.put(15, "280.303");
        f10877g.put(18, "250.000");
        f10877g.put(19, "250.400");
        f10877g.put(20, "280.000");
        f10877g.put(21, "250.500");
        f10877g.put(22, "290.500");
        f10878h.put(1, "280.210");
        f10878h.put(-2, "280.249");
        f10878h.put(2, "280.220");
        f10878h.put(3, "280.250");
        f10878h.put(4, "280.241");
        f10878h.put(5, "280.240");
        f10878h.put(6, "280.242");
        f10878h.put(7, "280.243");
        f10879i.put(1, "280.261");
        f10879i.put(2, "280.262");
        f10879i.put(3, "280.263");
        f10879i.put(4, "280.264");
        f10881k.put(1, "212.000");
        f10881k.put(2, "212.400");
        f10881k.put(3, "212.401");
        f10881k.put(4, "212.999");
        f10881k.put(5, "214.000");
        f10881k.put(6, "214.200");
        f10881k.put(7, "216.200");
        f10881k.put(8, "216.401");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public EventBean m48973b(String str) {
        EventBean eventBean = this.f10884n;
        if (eventBean == null || str == null) {
            return null;
        }
        try {
            EventBean clone = eventBean.clone();
            clone.m48917c(str);
            clone.m48907h(String.valueOf(System.currentTimeMillis()));
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> m48972c(String str) {
        if (this.f10882l.containsKey(str)) {
            return this.f10882l.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public static String m48983a(C3053l c3053l) {
        if (c3053l instanceof C3050i) {
            return f10871a.get(c3053l.m48971a());
        }
        if (c3053l instanceof C3049h) {
            return f10872b.get(c3053l.m48971a());
        }
        if (c3053l instanceof C3052k) {
            return f10873c.get(c3053l.m48971a());
        }
        if (c3053l instanceof C3048g) {
            return f10874d.get(c3053l.m48971a());
        }
        return c3053l instanceof C3051j ? f10880j.get(c3053l.m48971a()) : "0";
    }

    /* compiled from: AdProcessStatus.java */
    /* renamed from: com.beizi.fusion.b.a$l */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3053l extends Observable {

        /* renamed from: a */
        private int f10896a = 0;

        /* renamed from: c */
        private Map<String, Integer> f10898c = new HashMap();

        public C3053l() {
        }

        /* renamed from: a */
        public void m48970a(int i) {
            if (this.f10896a != i) {
                this.f10896a = i;
                EventBean m48973b = AdProcessStatus.this.m48973b(AdProcessStatus.m48983a(this));
                setChanged();
                notifyObservers(m48973b);
            }
        }

        /* renamed from: a */
        public int m48971a() {
            return this.f10896a;
        }

        /* renamed from: a */
        public void m48968a(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i2 = 0;
            Map<String, Integer> map = this.f10898c;
            if (map != null && map.containsKey(str)) {
                i2 = this.f10898c.get(str).intValue();
            }
            if (i2 != i || i == 17) {
                this.f10898c.put(str, Integer.valueOf(i));
                String m48976a = AdProcessStatus.m48976a(str, this);
                C3116af.m48495b("BeiZis", "changeStatus channel = " + str + ",eventCode = " + m48976a);
                EventBean m48974a = AdProcessStatus.this.m48974a(str, m48976a);
                if ("290.300".equalsIgnoreCase(m48976a)) {
                    C3116af.m48495b("BeiZis", "eventBean = " + m48974a);
                }
                setChanged();
                notifyObservers(m48974a);
            }
        }

        /* renamed from: a */
        public int m48969a(String str) {
            Map<String, Integer> map;
            if (TextUtils.isEmpty(str) || (map = this.f10898c) == null || !map.containsKey(str)) {
                return 0;
            }
            return this.f10898c.get(str).intValue();
        }
    }

    /* renamed from: a */
    public static String m48976a(String str, C3053l c3053l) {
        if (c3053l instanceof C3045d) {
            return f10875e.get(c3053l.m48969a(str));
        }
        if (c3053l instanceof C3046e) {
            return f10876f.get(c3053l.m48969a(str));
        }
        if (c3053l instanceof C3047f) {
            return f10877g.get(c3053l.m48969a(str));
        }
        if (c3053l instanceof C3044c) {
            return f10878h.get(c3053l.m48969a(str));
        }
        if (c3053l instanceof C3043b) {
            return f10879i.get(c3053l.m48969a(str));
        }
        return c3053l instanceof C3042a ? f10881k.get(c3053l.m48969a(str)) : "0";
    }

    /* renamed from: a */
    public void m48980a(EventBean eventBean) {
        this.f10884n = eventBean;
    }

    /* renamed from: a */
    public EventBean m48977a(String str) {
        if (this.f10883m.containsKey(str)) {
            try {
                EventBean eventBean = this.f10883m.get(str);
                if (eventBean != null) {
                    EventBean clone = eventBean.clone();
                    this.f10883m.put(str, clone);
                    return clone;
                }
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } else {
            EventBean eventBean2 = this.f10884n;
            if (eventBean2 != null) {
                try {
                    EventBean clone2 = eventBean2.clone();
                    this.f10883m.put(str, clone2);
                    return clone2;
                } catch (CloneNotSupportedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        EventBean eventBean3 = new EventBean(AdManager.f11053b, "", "", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), "");
        this.f10883m.put(str, eventBean3);
        return eventBean3;
    }

    /* renamed from: a */
    public void m48975a(String str, EventBean eventBean) {
        if (TextUtils.isEmpty(str) || eventBean == null) {
            return;
        }
        this.f10883m.put(str, eventBean);
    }

    /* renamed from: a */
    public void m48978a(AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> pair = new Pair<>(buyerBean, forwardBean);
        if (buyerBean == null || TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId())) {
            return;
        }
        this.f10882l.put(buyerBean.getBuyerSpaceUuId(), pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public EventBean m48974a(String str, String str2) {
        Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> m48972c = m48972c(str);
        StringBuilder sb = new StringBuilder();
        sb.append("getChannelEventBean eventCode = ");
        sb.append(str2);
        sb.append(",channelData == null ");
        sb.append(m48972c == null);
        C3116af.m48495b("BeiZis", sb.toString());
        if (m48972c != null) {
            AdSpacesBean.BuyerBean buyerBean = (AdSpacesBean.BuyerBean) m48972c.first;
            AdSpacesBean.ForwardBean forwardBean = (AdSpacesBean.ForwardBean) m48972c.second;
            EventBean m48977a = m48977a(str);
            if (m48977a == null || buyerBean == null || forwardBean == null) {
                return m48977a;
            }
            m48977a.m48917c(str2);
            m48977a.m48907h(String.valueOf(System.currentTimeMillis()));
            m48979a(m48977a, str, buyerBean, forwardBean);
            this.f10883m.put(str, m48977a);
            return m48977a;
        }
        C3116af.m48494c("BeiZis", "getChannelEventBean eventCode = " + str2 + ",but channelData is null !!!");
        return null;
    }

    /* renamed from: a */
    private static void m48979a(EventBean eventBean, String str, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        if (eventBean == null) {
            return;
        }
        eventBean.m48903j(String.valueOf(AdStrategy.m48525a(buyerBean.getId())));
        eventBean.m48901k(buyerBean.getAppId());
        eventBean.m48899l(buyerBean.getSpaceId());
        eventBean.m48960D(buyerBean.getFilterSsid());
        eventBean.m48958E(buyerBean.getRenderViewSsid());
        eventBean.m48942M(String.valueOf(buyerBean.getAvgPrice()));
        eventBean.m48944L(AdStrategy.m48522b(forwardBean.getBaseId()));
        if (!"BPDI".equalsIgnoreCase(buyerBean.getBidType()) && !"C2S".equalsIgnoreCase(buyerBean.getBidType()) && !"S2S".equalsIgnoreCase(buyerBean.getBidType())) {
            eventBean.m48922a(0);
        } else {
            eventBean.m48922a(1);
            if (buyerBean.getBidPrice() > Utils.DOUBLE_EPSILON) {
                eventBean.m48940N(String.valueOf(buyerBean.getBidPrice()));
            } else {
                eventBean.m48940N("0");
            }
        }
        if (forwardBean != null) {
            eventBean.m48895n(forwardBean.getForwardId());
            eventBean.m48893o(forwardBean.getParentForwardId());
            eventBean.m48891p(forwardBean.getLevel());
            eventBean.m48889q(forwardBean.getBuyerSpaceUuId());
        }
    }
}
