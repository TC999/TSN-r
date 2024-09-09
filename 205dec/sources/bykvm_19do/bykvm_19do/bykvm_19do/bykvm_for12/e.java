package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.l;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: AdEventThread.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e<T extends i> extends HandlerThread implements Handler.Callback {

    /* renamed from: l  reason: collision with root package name */
    public static String f591l = "ttad_bk";

    /* renamed from: a  reason: collision with root package name */
    public String f592a;

    /* renamed from: b  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a<T> f593b;

    /* renamed from: c  reason: collision with root package name */
    public bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a<T> f594c;

    /* renamed from: d  reason: collision with root package name */
    public final List<T> f595d;

    /* renamed from: e  reason: collision with root package name */
    public long f596e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f597f;

    /* renamed from: g  reason: collision with root package name */
    public int f598g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f599h;

    /* renamed from: i  reason: collision with root package name */
    public final a f600i;

    /* renamed from: j  reason: collision with root package name */
    public final b f601j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f602k;

    /* compiled from: AdEventThread.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        boolean a();
    }

    /* compiled from: AdEventThread.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f603a;

        /* renamed from: b  reason: collision with root package name */
        final long f604b;

        /* renamed from: c  reason: collision with root package name */
        final long f605c;

        /* renamed from: d  reason: collision with root package name */
        final int f606d;

        /* renamed from: e  reason: collision with root package name */
        final long f607e;

        /* renamed from: f  reason: collision with root package name */
        final long f608f;

        b(int i4, long j4, long j5, int i5, long j6, long j7) {
            this.f603a = i4;
            this.f604b = j4;
            this.f605c = j5;
            this.f606d = i5;
            this.f607e = j6;
            this.f608f = j7;
        }

        public static b a() {
            return new b(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().i(), PolicyConfig.THREAD_BLOCK_TIMEOUT, 60000L, 5, 172800000L, 300000L);
        }
    }

    public e(String str, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a<T> aVar, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a<T> aVar2, b bVar, a aVar3) {
        super(f591l);
        this.f592a = "AdEventThread-\u3010";
        this.f592a += str + "\u3011";
        this.f602k = "V3".equals(str);
        a("tag=" + str);
        this.f601j = bVar;
        this.f600i = aVar3;
        this.f593b = aVar;
        this.f594c = aVar2;
        this.f595d = Collections.synchronizedList(new LinkedList());
    }

    private void a(List<T> list) {
        int i4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().i();
        if (list == null) {
            return;
        }
        if (list.size() <= i4) {
            a("start and return, checkAndDeleteEvent local size:" + list.size() + "\u5c0f\u4e8e:" + i4);
            return;
        }
        int size = list.size() - i4;
        a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(list.get(i5));
        }
        list.removeAll(arrayList);
        a("end checkAndDeleteEvent local size:" + list.size());
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t3 : this.f595d) {
                        hashSet.add(t3.a());
                    }
                    for (T t4 : list) {
                        if (!hashSet.contains(t4.a())) {
                            this.f595d.add(t4);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private f c(List<T> list) {
        try {
            if (this.f594c == null) {
                this.f594c = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.e();
            }
        } catch (Exception unused) {
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a<T> aVar = this.f594c;
        if (aVar == null) {
            return null;
        }
        return aVar.a(list);
    }

    private void d() {
        a(4, g());
    }

    private void e() {
        a("\u666e\u901a\u5931\u8d25 \uff0c\u89e6\u53d1\u91cd\u8bd5\u673a\u5236\uff1a" + this.f601j.f605c + "\u6beb\u79d2\u540e \u91cd\u8bd5.....");
        a(3, this.f601j.f605c);
    }

    private void f() {
        this.f599h.removeMessages(3);
        this.f599h.removeMessages(2);
        if (l.a(this.f595d)) {
            this.f596e = System.currentTimeMillis();
            c();
        } else if (!this.f600i.a()) {
            a("doRoutineUpload no net, wait retry");
            e();
        } else {
            f c4 = c(this.f595d);
            if (c4 != null) {
                if (c4.f609a) {
                    a("doRoutineUpload success");
                    a();
                    o();
                } else if (b(c4)) {
                    a("doRoutineUpload serverbusy");
                    i();
                } else if (a(c4)) {
                    a("\u670d\u52a1\u7aef\u8fd4\u56dedata error \u629b\u5f03\u6570\u636e , \u6e05\u7a7a\u672c\u6b21\u65e5\u5fd7\uff0c\u91cd\u7f6e\u4e0a\u4f20\u72b6\u6001....");
                    a();
                    o();
                } else if (this.f597f) {
                } else {
                    e();
                    a("doRoutineUpload net fail retry");
                }
            }
        }
    }

    private long g() {
        long j4 = ((this.f598g % 3) + 1) * this.f601j.f608f;
        a("\u670d\u52a1\u5668\u7e41\u5fd9\uff0c" + j4 + "\u6beb\u79d2\u540e\u8fdb\u884c\u91cd\u8bd5,\u5f53\u524d\u91cd\u8bd5\u6b21\u6570\uff1amServerBusyRetryCount=" + this.f598g + "\uff0cmServerBusyRetryBaseInternal=" + this.f601j.f608f);
        return ((this.f598g % 3) + 1) * this.f601j.f608f;
    }

    private int h() {
        return this.f602k ? 2 : 1;
    }

    private void i() {
        this.f597f = true;
        this.f593b.a(h(), true);
        this.f595d.clear();
        this.f599h.removeMessages(3);
        this.f599h.removeMessages(2);
        d();
    }

    private boolean j() {
        a("mCacheList.size():" + this.f595d.size() + ",mPolicy.mMaxCacheCount=" + this.f601j.f603a + ",System.currentTimeMillis() - mLastSuccessUploadTime =" + (System.currentTimeMillis() - this.f596e) + ",mPolicy.mMaxCacheTime=" + this.f601j.f604b);
        return !this.f597f && (this.f595d.size() >= this.f601j.f603a || System.currentTimeMillis() - this.f596e >= this.f601j.f604b);
    }

    private void k() {
        a("onHandleInitEvent \u521d\u59cb\u5316\u65e5\u5fd7\u7ec4\u4ef6.....");
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a<T> aVar = this.f593b;
        b bVar = this.f601j;
        aVar.a(2, bVar.f606d, bVar.f607e);
        this.f597f = this.f593b.a(h());
        this.f598g = this.f593b.b(h());
        if (this.f597f) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f598g);
            d();
            return;
        }
        List<T> a4 = this.f593b.a(h(), bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().i(), "_id");
        Iterator<T> it = a4.iterator();
        while (it.hasNext()) {
            a("onHandleInitEvent----adEventList: " + it.next());
        }
        b(a4);
        a("onHandleInitEvent cacheData count = " + this.f595d.size());
        f();
    }

    private void l() {
        if (this.f597f) {
            a("\u5982\u679c\u5728\u5bb9\u707e\u72b6\u6001\uff0c\u76f4\u63a5\u8fd4\u56de, \u5b89\u5168\u8d77\u89c1\u8fd9\u91cc\u5224\u65ad\u4e00\u4e0b,mIsServerBusy=" + this.f597f);
            return;
        }
        a("onHandleRoutineRetryEvent");
        f();
    }

    private void m() {
        if (this.f597f) {
            a("\u5982\u679c\u5728\u5bb9\u707e\u72b6\u6001\uff0c\u76f4\u63a5\u8fd4\u56de, \u5b89\u5168\u8d77\u89c1\u8fd9\u91cc\u5224\u65ad\u4e00\u4e0b,mIsServerBusy=" + this.f597f);
            return;
        }
        a("onHandleRoutineUploadEvent");
        f();
    }

    private void n() {
        if (!this.f600i.a()) {
            a(4, this.f601j.f605c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> a4 = this.f593b.a(h(), bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().i(), "_id");
        a(a4);
        StringBuilder sb = new StringBuilder();
        sb.append("\u6570\u636e\u5e93\u67e5\u8be2\u51fa\u6765\u7684size=");
        sb.append(a4 != null ? a4.size() : 0);
        a(sb.toString());
        if (l.a(a4)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            b();
            c();
            return;
        }
        f c4 = c(a4);
        if (c4 != null) {
            if (c4.f609a) {
                a("onHandleServerBusyRetryEvent, success");
                a();
                o();
            } else if (b(c4)) {
                this.f598g++;
                this.f593b.a(h(), this.f598g);
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a<T> aVar = this.f593b;
                int h4 = h();
                b bVar = this.f601j;
                aVar.a(h4, a4, bVar.f606d, bVar.f607e);
                d();
                a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f598g);
            } else if (a(c4)) {
                a("onHandleServerBusyRetryEvent, ---\u300b data Error\u76f4\u63a5\u629b\u5f03\u6570\u636e ");
                a();
                o();
            } else {
                e();
                a("onHandleServerBusyRetryEvent, net fail");
            }
        }
    }

    private void o() {
        this.f596e = System.currentTimeMillis();
        b();
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 1) {
            a((e<T>) ((i) message.obj));
        } else if (i4 == 2) {
            m();
        } else if (i4 == 3) {
            a("\u89e6\u53d1\u5931\u8d25\u91cd\u8bd5.....");
            l();
        } else if (i4 == 4) {
            a("\u89e6\u53d1\u670d\u52a1\u5668\u7e41\u5fd9\u91cd\u8bd5\u673a\u5236.....");
            n();
        } else if (i4 == 5) {
            k();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f596e = System.currentTimeMillis();
        this.f599h = new Handler(getLooper(), this);
    }

    private void c() {
        a(2, this.f601j.f604b);
    }

    private static boolean b(f fVar) {
        return fVar.f610b == 509;
    }

    private void b() {
        this.f597f = false;
        this.f593b.a(h(), false);
        this.f598g = 0;
        this.f593b.a(h(), 0);
        this.f599h.removeMessages(4);
    }

    private void a(T t3) {
        this.f593b.a(h(), (int) t3);
        if (this.f597f) {
            a("\u5982\u679c\u5728\u5bb9\u707e\u72b6\u6001\uff0c\u76f4\u63a5\u8fd4\u56de.......mIsServerBusy=" + this.f597f);
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f595d.add(t3);
        a(this.f595d);
        if (j()) {
            a("onHandleReceivedAdEvent upload");
            f();
        }
    }

    private void a() {
        this.f593b.a(h(), this.f595d);
        this.f595d.clear();
    }

    private void a(int i4, long j4) {
        Message obtainMessage = this.f599h.obtainMessage();
        obtainMessage.what = i4;
        this.f599h.sendMessageDelayed(obtainMessage, j4);
    }

    private static boolean a(f fVar) {
        return fVar.f612d;
    }

    private void a(String str) {
        Logger.i(this.f592a, str);
    }
}
