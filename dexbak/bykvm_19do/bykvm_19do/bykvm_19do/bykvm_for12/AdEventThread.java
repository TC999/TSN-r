package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.EventFace;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertory;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApi;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ListUtils;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bytedance.msdk.adapter.util.Logger;
import com.umeng.analytics.pro.C13131bm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdEventThread<T extends EventFace> extends HandlerThread implements Handler.Callback {

    /* renamed from: l */
    public static String f598l = "ttad_bk";

    /* renamed from: a */
    public String f599a;

    /* renamed from: b */
    public final AdEventRepertory<T> f600b;

    /* renamed from: c */
    public ReportNetApi<T> f601c;

    /* renamed from: d */
    public final List<T> f602d;

    /* renamed from: e */
    public long f603e;

    /* renamed from: f */
    public boolean f604f;

    /* renamed from: g */
    public int f605g;

    /* renamed from: h */
    public Handler f606h;

    /* renamed from: i */
    public final InterfaceC0976a f607i;

    /* renamed from: j */
    public final C0977b f608j;

    /* renamed from: k */
    private boolean f609k;

    /* compiled from: AdEventThread.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.e$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC0976a {
        /* renamed from: a */
        boolean mo59334a();
    }

    /* compiled from: AdEventThread.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.e$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0977b {

        /* renamed from: a */
        final int f610a;

        /* renamed from: b */
        final long f611b;

        /* renamed from: c */
        final long f612c;

        /* renamed from: d */
        final int f613d;

        /* renamed from: e */
        final long f614e;

        /* renamed from: f */
        final long f615f;

        C0977b(int i, long j, long j2, int i2, long j3, long j4) {
            this.f610a = i;
            this.f611b = j;
            this.f612c = j2;
            this.f613d = i2;
            this.f614e = j3;
            this.f615f = j4;
        }

        /* renamed from: a */
        public static C0977b m59333a() {
            return new C0977b(InternalContainer.m59943f().m59738i(), 120000L, 60000L, 5, C2624bk.f8681e, 300000L);
        }
    }

    public AdEventThread(String str, AdEventRepertory<T> adEventRepertory, ReportNetApi<T> reportNetApi, C0977b c0977b, InterfaceC0976a interfaceC0976a) {
        super(f598l);
        this.f599a = "AdEventThread-【";
        this.f599a += str + "】";
        this.f609k = "V3".equals(str);
        m59353a("tag=" + str);
        this.f608j = c0977b;
        this.f607i = interfaceC0976a;
        this.f600b = adEventRepertory;
        this.f601c = reportNetApi;
        this.f602d = Collections.synchronizedList(new LinkedList());
    }

    /* renamed from: a */
    private void m59352a(List<T> list) {
        int m59738i = InternalContainer.m59943f().m59738i();
        if (list == null) {
            return;
        }
        if (list.size() <= m59738i) {
            m59353a("start and return, checkAndDeleteEvent local size:" + list.size() + "小于:" + m59738i);
            return;
        }
        int size = list.size() - m59738i;
        m59353a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i));
        }
        list.removeAll(arrayList);
        m59353a("end checkAndDeleteEvent local size:" + list.size());
    }

    /* renamed from: b */
    private void m59349b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t : this.f602d) {
                        hashSet.add(t.mo59295a());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.mo59295a())) {
                            this.f602d.add(t2);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        m59353a("reloadCacheList adEventList is empty======");
    }

    /* renamed from: c */
    private AdEventUploadResult m59347c(List<T> list) {
        try {
            if (this.f601c == null) {
                this.f601c = InternalContainer.m59944e();
            }
        } catch (Exception unused) {
        }
        ReportNetApi<T> reportNetApi = this.f601c;
        if (reportNetApi == null) {
            return null;
        }
        return reportNetApi.mo59388a(list);
    }

    /* renamed from: d */
    private void m59346d() {
        m59356a(4, m59343g());
    }

    /* renamed from: e */
    private void m59345e() {
        m59353a("普通失败 ，触发重试机制：" + this.f608j.f612c + "毫秒后 重试.....");
        m59356a(3, this.f608j.f612c);
    }

    /* renamed from: f */
    private void m59344f() {
        this.f606h.removeMessages(3);
        this.f606h.removeMessages(2);
        if (ListUtils.m59174a(this.f602d)) {
            this.f603e = System.currentTimeMillis();
            m59348c();
        } else if (!this.f607i.mo59334a()) {
            m59353a("doRoutineUpload no net, wait retry");
            m59345e();
        } else {
            AdEventUploadResult m59347c = m59347c(this.f602d);
            if (m59347c != null) {
                if (m59347c.f616a) {
                    m59353a("doRoutineUpload success");
                    m59357a();
                    m59335o();
                } else if (m59350b(m59347c)) {
                    m59353a("doRoutineUpload serverbusy");
                    m59341i();
                } else if (m59355a(m59347c)) {
                    m59353a("服务端返回data error 抛弃数据 , 清空本次日志，重置上传状态....");
                    m59357a();
                    m59335o();
                } else if (this.f604f) {
                } else {
                    m59345e();
                    m59353a("doRoutineUpload net fail retry");
                }
            }
        }
    }

    /* renamed from: g */
    private long m59343g() {
        long j = ((this.f605g % 3) + 1) * this.f608j.f615f;
        m59353a("服务器繁忙，" + j + "毫秒后进行重试,当前重试次数：mServerBusyRetryCount=" + this.f605g + "，mServerBusyRetryBaseInternal=" + this.f608j.f615f);
        return ((this.f605g % 3) + 1) * this.f608j.f615f;
    }

    /* renamed from: h */
    private int m59342h() {
        return this.f609k ? 2 : 1;
    }

    /* renamed from: i */
    private void m59341i() {
        this.f604f = true;
        this.f600b.mo59428a(m59342h(), true);
        this.f602d.clear();
        this.f606h.removeMessages(3);
        this.f606h.removeMessages(2);
        m59346d();
    }

    /* renamed from: j */
    private boolean m59340j() {
        m59353a("mCacheList.size():" + this.f602d.size() + ",mPolicy.mMaxCacheCount=" + this.f608j.f610a + ",System.currentTimeMillis() - mLastSuccessUploadTime =" + (System.currentTimeMillis() - this.f603e) + ",mPolicy.mMaxCacheTime=" + this.f608j.f611b);
        return !this.f604f && (this.f602d.size() >= this.f608j.f610a || System.currentTimeMillis() - this.f603e >= this.f608j.f611b);
    }

    /* renamed from: k */
    private void m59339k() {
        m59353a("onHandleInitEvent 初始化日志组件.....");
        AdEventRepertory<T> adEventRepertory = this.f600b;
        C0977b c0977b = this.f608j;
        adEventRepertory.mo59434a(2, c0977b.f613d, c0977b.f614e);
        this.f604f = this.f600b.mo59436a(m59342h());
        this.f605g = this.f600b.mo59424b(m59342h());
        if (this.f604f) {
            m59353a("onHandleInitEvent serverBusy, retryCount = " + this.f605g);
            m59346d();
            return;
        }
        List<T> mo59433a = this.f600b.mo59433a(m59342h(), InternalContainer.m59943f().m59738i(), C13131bm.f37927d);
        Iterator<T> it = mo59433a.iterator();
        while (it.hasNext()) {
            m59353a("onHandleInitEvent----adEventList: " + it.next());
        }
        m59349b(mo59433a);
        m59353a("onHandleInitEvent cacheData count = " + this.f602d.size());
        m59344f();
    }

    /* renamed from: l */
    private void m59338l() {
        if (this.f604f) {
            m59353a("如果在容灾状态，直接返回, 安全起见这里判断一下,mIsServerBusy=" + this.f604f);
            return;
        }
        m59353a("onHandleRoutineRetryEvent");
        m59344f();
    }

    /* renamed from: m */
    private void m59337m() {
        if (this.f604f) {
            m59353a("如果在容灾状态，直接返回, 安全起见这里判断一下,mIsServerBusy=" + this.f604f);
            return;
        }
        m59353a("onHandleRoutineUploadEvent");
        m59344f();
    }

    /* renamed from: n */
    private void m59336n() {
        if (!this.f607i.mo59334a()) {
            m59356a(4, this.f608j.f612c);
            m59353a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> mo59433a = this.f600b.mo59433a(m59342h(), InternalContainer.m59943f().m59738i(), C13131bm.f37927d);
        m59352a(mo59433a);
        StringBuilder sb = new StringBuilder();
        sb.append("数据库查询出来的size=");
        sb.append(mo59433a != null ? mo59433a.size() : 0);
        m59353a(sb.toString());
        if (ListUtils.m59174a(mo59433a)) {
            m59353a("onHandleServerBusyRetryEvent, empty list start routine");
            m59351b();
            m59348c();
            return;
        }
        AdEventUploadResult m59347c = m59347c(mo59433a);
        if (m59347c != null) {
            if (m59347c.f616a) {
                m59353a("onHandleServerBusyRetryEvent, success");
                m59357a();
                m59335o();
            } else if (m59350b(m59347c)) {
                this.f605g++;
                this.f600b.mo59435a(m59342h(), this.f605g);
                AdEventRepertory<T> adEventRepertory = this.f600b;
                int m59342h = m59342h();
                C0977b c0977b = this.f608j;
                adEventRepertory.mo59429a(m59342h, mo59433a, c0977b.f613d, c0977b.f614e);
                m59346d();
                m59353a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f605g);
            } else if (m59355a(m59347c)) {
                m59353a("onHandleServerBusyRetryEvent, ---》 data Error直接抛弃数据 ");
                m59357a();
                m59335o();
            } else {
                m59345e();
                m59353a("onHandleServerBusyRetryEvent, net fail");
            }
        }
    }

    /* renamed from: o */
    private void m59335o() {
        this.f603e = System.currentTimeMillis();
        m59351b();
        m59348c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            m59354a((AdEventThread<T>) ((EventFace) message.obj));
        } else if (i == 2) {
            m59337m();
        } else if (i == 3) {
            m59353a("触发失败重试.....");
            m59338l();
        } else if (i == 4) {
            m59353a("触发服务器繁忙重试机制.....");
            m59336n();
        } else if (i == 5) {
            m59339k();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f603e = System.currentTimeMillis();
        this.f606h = new Handler(getLooper(), this);
    }

    /* renamed from: c */
    private void m59348c() {
        m59356a(2, this.f608j.f611b);
    }

    /* renamed from: b */
    private static boolean m59350b(AdEventUploadResult adEventUploadResult) {
        return adEventUploadResult.f617b == 509;
    }

    /* renamed from: b */
    private void m59351b() {
        this.f604f = false;
        this.f600b.mo59428a(m59342h(), false);
        this.f605g = 0;
        this.f600b.mo59435a(m59342h(), 0);
        this.f606h.removeMessages(4);
    }

    /* renamed from: a */
    private void m59354a(T t) {
        this.f600b.mo59431a(m59342h(), (int) t);
        if (this.f604f) {
            m59353a("如果在容灾状态，直接返回.......mIsServerBusy=" + this.f604f);
            return;
        }
        m59353a("onHandleReceivedAdEvent");
        this.f602d.add(t);
        m59352a(this.f602d);
        if (m59340j()) {
            m59353a("onHandleReceivedAdEvent upload");
            m59344f();
        }
    }

    /* renamed from: a */
    private void m59357a() {
        this.f600b.mo59430a(m59342h(), this.f602d);
        this.f602d.clear();
    }

    /* renamed from: a */
    private void m59356a(int i, long j) {
        Message obtainMessage = this.f606h.obtainMessage();
        obtainMessage.what = i;
        this.f606h.sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: a */
    private static boolean m59355a(AdEventUploadResult adEventUploadResult) {
        return adEventUploadResult.f619d;
    }

    /* renamed from: a */
    private void m59353a(String str) {
        Logger.m37554i(this.f599a, str);
    }
}
