package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import android.util.Pair;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalFreqctlRepertory;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalFreqctlRepertoryImpl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalPacingRepertory;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdIntervalPacingRepertoryImpl;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IntervalShowControl {

    /* renamed from: a */
    private Map<String, IntervalFreqctlBean> f477a;

    /* renamed from: b */
    private Map<String, IntervalPacingBean> f478b;

    /* renamed from: c */
    private AdIntervalPacingRepertory<IntervalPacingBean> f479c;

    /* renamed from: d */
    private AdIntervalFreqctlRepertory<IntervalFreqctlBean> f480d;

    /* renamed from: e */
    private Map<String, Long> f481e;

    /* renamed from: f */
    private Map<String, Pair<String, String>> f482f;

    /* compiled from: IntervalShowControl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC0969a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f483a;

        RunnableC0969a(String str) {
            this.f483a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + this.f483a);
            IntervalPacingBean m59576i = IntervalShowControl.this.m59576i(this.f483a);
            if (m59576i == null || !m59576i.mo59600a()) {
                return;
            }
            Date date = new Date();
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount save time = " + IntervalEffectiveTime.m59607b(date.getTime()));
            IntervalShowControl.this.m59588a(this.f483a, date.getTime());
        }
    }

    /* compiled from: IntervalShowControl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC0970b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f485a;

        RunnableC0970b(String str) {
            this.f485a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + this.f485a);
            IntervalFreqctlBean m59577h = IntervalShowControl.this.m59577h(this.f485a);
            if (m59577h == null || !m59577h.mo59600a()) {
                return;
            }
            for (FreqctlBean freqctlBean : m59577h.m59604e()) {
                if (freqctlBean.m59620a() < freqctlBean.m59612c()) {
                    IntervalShowControl.this.m59592a(m59577h, freqctlBean.m59611d(), freqctlBean.m59620a() + 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntervalShowControl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0971c {

        /* renamed from: a */
        private static IntervalShowControl f487a = new IntervalShowControl(null);
    }

    /* synthetic */ IntervalShowControl(RunnableC0969a runnableC0969a) {
        this();
    }

    /* renamed from: b */
    public static IntervalShowControl m59587b() {
        return C0971c.f487a;
    }

    /* renamed from: a */
    public void m59594a() {
        this.f479c = new AdIntervalPacingRepertoryImpl(InternalContainer.m59945d());
        this.f480d = new AdIntervalFreqctlRepertoryImpl(InternalContainer.m59945d());
        this.f477a = new ConcurrentHashMap();
        this.f478b = new ConcurrentHashMap();
        this.f482f = new ConcurrentHashMap();
        this.f481e = new ConcurrentHashMap();
    }

    /* renamed from: c */
    public boolean m59582c(String str) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkPacing ritId = " + str);
        IntervalPacingBean m59576i = m59576i(str);
        if (m59576i != null && m59576i.mo59600a() && m59576i.m59595h()) {
            long time = new Date().getTime();
            long m59596g = m59576i.m59596g();
            long m59596g2 = m59576i.m59596g() + m59576i.m59598e();
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + IntervalEffectiveTime.m59607b(time) + " showTime = " + IntervalEffectiveTime.m59607b(m59596g) + " pacingBean.getPacing() = " + m59576i.m59598e() + " pacingTime = " + IntervalEffectiveTime.m59607b(m59596g2));
            if (time <= m59596g2) {
                this.f481e.put(str, Long.valueOf(time - m59596g));
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public void m59581d(String str) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "deleteFreqctlByRitId = " + str);
        if (this.f480d != null) {
            Map<String, IntervalFreqctlBean> map = this.f477a;
            if (map != null) {
                map.remove(str);
            }
            this.f480d.mo59405a(str);
        }
    }

    /* renamed from: e */
    public void m59580e(String str) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "deletePacingByRitId = " + str);
        if (this.f479c != null) {
            Map<String, IntervalPacingBean> map = this.f478b;
            if (map != null) {
                map.remove(str);
            }
            this.f479c.mo59405a(str);
        }
    }

    /* renamed from: f */
    public Pair<String, String> m59579f(String str) {
        return this.f482f.get(str);
    }

    /* renamed from: g */
    public long m59578g(String str) {
        Long l = this.f481e.get(str);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    /* renamed from: h */
    public IntervalFreqctlBean m59577h(String str) {
        if (this.f480d != null) {
            Map<String, IntervalFreqctlBean> map = this.f477a;
            IntervalFreqctlBean intervalFreqctlBean = map != null ? map.get(str) : null;
            if (intervalFreqctlBean != null) {
                return intervalFreqctlBean;
            }
            IntervalFreqctlBean mo59404b = this.f480d.mo59404b(str);
            if (mo59404b != null) {
                Map<String, IntervalFreqctlBean> map2 = this.f477a;
                if (map2 != null) {
                    map2.put(mo59404b.m59623b(), mo59404b);
                }
                return mo59404b;
            }
        }
        return null;
    }

    /* renamed from: i */
    public IntervalPacingBean m59576i(String str) {
        if (this.f479c != null) {
            Map<String, IntervalPacingBean> map = this.f478b;
            IntervalPacingBean intervalPacingBean = map != null ? map.get(str) : null;
            if (intervalPacingBean != null) {
                return intervalPacingBean;
            }
            IntervalPacingBean mo59404b = this.f479c.mo59404b(str);
            if (mo59404b != null) {
                this.f478b.put(mo59404b.m59623b(), mo59404b);
            }
            return mo59404b;
        }
        return null;
    }

    /* renamed from: j */
    public void m59575j(String str) {
        ThreadHelper.runOnMSDKThread(new RunnableC0969a(str));
    }

    private IntervalShowControl() {
    }

    /* renamed from: b */
    public void m59585b(IntervalPacingBean intervalPacingBean) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "saveIntervalPacingBean = " + intervalPacingBean.toString());
        if (this.f479c == null || TextUtils.isEmpty(intervalPacingBean.m59597f())) {
            return;
        }
        Map<String, IntervalPacingBean> map = this.f478b;
        if (map != null) {
            map.put(intervalPacingBean.m59623b(), intervalPacingBean);
        }
        this.f479c.mo59406a((AdIntervalPacingRepertory<IntervalPacingBean>) intervalPacingBean);
    }

    /* renamed from: a */
    public void m59588a(String str, long j) {
        if (this.f479c != null) {
            Map<String, IntervalPacingBean> map = this.f478b;
            IntervalPacingBean intervalPacingBean = map != null ? map.get(str) : null;
            if (intervalPacingBean != null) {
                intervalPacingBean.m59599a(j);
            }
            this.f479c.mo59407a(str, j);
        }
    }

    /* renamed from: b */
    public boolean m59584b(String str) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkFreqctl ritId = " + str);
        IntervalFreqctlBean m59577h = m59577h(str);
        if (m59577h == null || !m59577h.mo59600a()) {
            return true;
        }
        for (FreqctlBean freqctlBean : m59577h.m59604e()) {
            Date date = new Date();
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + freqctlBean.m59615b());
            if (date.getTime() <= freqctlBean.m59615b()) {
                if (freqctlBean.m59620a() >= freqctlBean.m59612c()) {
                    Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + freqctlBean.m59611d() + " count = " + freqctlBean.m59620a());
                    Map<String, Pair<String, String>> map = this.f482f;
                    String m59611d = freqctlBean.m59611d();
                    map.put(str, new Pair<>(m59611d, freqctlBean.m59620a() + ""));
                    return false;
                }
                Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkFreqctl 未到上线可以展示 ruleId = " + freqctlBean.m59611d() + " count = " + freqctlBean.m59620a());
            } else {
                m59592a(m59577h, freqctlBean.m59611d(), 0);
                m59591a(m59577h, freqctlBean.m59611d(), IntervalEffectiveTime.m59609a(freqctlBean.m59610e()));
                Logger.m37562d("TTMediationSDK_IntervalShowControl", "checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + freqctlBean.m59611d());
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m59590a(IntervalPacingBean intervalPacingBean) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "pacing checkPacingUpdate ritId = " + intervalPacingBean.m59623b());
        IntervalPacingBean m59576i = m59576i(intervalPacingBean.m59623b());
        if (m59576i == null) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
            return true;
        } else if (TextUtils.isEmpty(intervalPacingBean.m59597f())) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
            m59580e(intervalPacingBean.m59623b());
            return false;
        } else if (TextUtils.equals(m59576i.m59597f(), intervalPacingBean.m59597f())) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + m59576i.m59597f() + " 无需处理");
            return false;
        } else {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + m59576i.m59597f() + "  new ruleId" + intervalPacingBean.m59597f());
            StringBuilder sb = new StringBuilder();
            sb.append("pacing 删除 ritId = ");
            sb.append(intervalPacingBean.m59623b());
            Logger.m37562d("TTMediationSDK_IntervalShowControl", sb.toString());
            m59580e(intervalPacingBean.m59623b());
            return true;
        }
    }

    /* renamed from: c */
    public void m59583c(IntervalFreqctlBean intervalFreqctlBean) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "updateFreqctlItem bean = " + intervalFreqctlBean.toString());
        if (this.f480d != null) {
            Map<String, IntervalFreqctlBean> map = this.f477a;
            if (map != null) {
                map.put(intervalFreqctlBean.m59623b(), intervalFreqctlBean);
            }
            this.f480d.mo59412b((AdIntervalFreqctlRepertory<IntervalFreqctlBean>) intervalFreqctlBean);
        }
    }

    /* renamed from: a */
    public void m59589a(String str) {
        ThreadHelper.runOnMSDKThread(new RunnableC0970b(str));
    }

    /* renamed from: a */
    public boolean m59593a(IntervalFreqctlBean intervalFreqctlBean) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "pacing checkFreqctlUpdate ritId = " + intervalFreqctlBean.m59623b());
        IntervalFreqctlBean m59577h = m59577h(intervalFreqctlBean.m59623b());
        if (m59577h == null) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "freqctl 规则为空直接存储");
            return true;
        } else if (TextUtils.isEmpty(intervalFreqctlBean.m59622c())) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
            m59581d(intervalFreqctlBean.m59623b());
            return false;
        } else if (TextUtils.equals(m59577h.m59622c(), intervalFreqctlBean.m59622c())) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + m59577h.m59622c() + "无需处理");
            return false;
        } else {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "freqctl version不一致，缓存新规则 old version = " + m59577h.m59622c() + "  new version " + intervalFreqctlBean.m59622c());
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "freqctl 需要取出json重新赋值");
            return true;
        }
    }

    /* renamed from: b */
    public void m59586b(IntervalFreqctlBean intervalFreqctlBean) {
        FreqctlBean freqctlBean;
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "saveIntervalFreqctlBean = " + intervalFreqctlBean.toString());
        IntervalFreqctlBean m59577h = m59577h(intervalFreqctlBean.m59623b());
        if (m59577h == null) {
            Logger.m37562d("TTMediationSDK_IntervalShowControl", "saveIntervalFreqctlBean 数据库中无内容直接存储");
            if (this.f480d != null) {
                Map<String, IntervalFreqctlBean> map = this.f477a;
                if (map != null) {
                    map.put(intervalFreqctlBean.m59623b(), intervalFreqctlBean);
                }
                this.f480d.mo59406a((AdIntervalFreqctlRepertory<IntervalFreqctlBean>) intervalFreqctlBean);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (FreqctlBean freqctlBean2 : m59577h.m59604e()) {
            hashMap.put(freqctlBean2.m59611d(), freqctlBean2);
        }
        for (FreqctlBean freqctlBean3 : intervalFreqctlBean.m59604e()) {
            if (hashMap.containsKey(freqctlBean3.m59611d()) && (freqctlBean = (FreqctlBean) hashMap.get(freqctlBean3.m59611d())) != null) {
                freqctlBean3.m59617a(freqctlBean);
            }
        }
        Map<String, IntervalFreqctlBean> map2 = this.f477a;
        if (map2 != null) {
            map2.put(intervalFreqctlBean.m59623b(), intervalFreqctlBean);
        }
        m59583c(intervalFreqctlBean);
    }

    /* renamed from: a */
    public void m59592a(IntervalFreqctlBean intervalFreqctlBean, String str, int i) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "updateFreqctlCount bean = " + intervalFreqctlBean.toString() + " ruleId = " + str + " count = " + i);
        if (this.f480d != null) {
            intervalFreqctlBean.m59606a(str, i);
            Map<String, IntervalFreqctlBean> map = this.f477a;
            if (map != null) {
                map.put(intervalFreqctlBean.m59623b(), intervalFreqctlBean);
            }
            this.f480d.mo59415a((AdIntervalFreqctlRepertory<IntervalFreqctlBean>) intervalFreqctlBean, str, i);
        }
    }

    /* renamed from: a */
    public void m59591a(IntervalFreqctlBean intervalFreqctlBean, String str, long j) {
        Logger.m37562d("TTMediationSDK_IntervalShowControl", "updateFreqctlTime bean = " + intervalFreqctlBean.toString() + " ruleId = " + str + " time = " + j);
        if (this.f480d != null) {
            intervalFreqctlBean.m59605a(str, j);
            Map<String, IntervalFreqctlBean> map = this.f477a;
            if (map != null) {
                map.put(intervalFreqctlBean.m59623b(), intervalFreqctlBean);
            }
            this.f480d.mo59414a((AdIntervalFreqctlRepertory<IntervalFreqctlBean>) intervalFreqctlBean, str, j);
        }
    }
}
