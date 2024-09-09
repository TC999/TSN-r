package com.clj.fastble.bluetooth;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.exception.BleException;
import com.clj.fastble.exception.OtherException;
import java.util.LinkedList;
import java.util.Queue;
import z0.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SplitWriter.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f36631a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f36632b;

    /* renamed from: c  reason: collision with root package name */
    private com.clj.fastble.bluetooth.a f36633c;

    /* renamed from: d  reason: collision with root package name */
    private String f36634d;

    /* renamed from: e  reason: collision with root package name */
    private String f36635e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f36636f;

    /* renamed from: g  reason: collision with root package name */
    private int f36637g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36638h;

    /* renamed from: i  reason: collision with root package name */
    private long f36639i;

    /* renamed from: j  reason: collision with root package name */
    private k f36640j;

    /* renamed from: k  reason: collision with root package name */
    private Queue<byte[]> f36641k;

    /* renamed from: l  reason: collision with root package name */
    private int f36642l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SplitWriter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 51) {
                d.this.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SplitWriter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class b extends k {
        b() {
        }

        @Override // z0.k
        public void e(BleException bleException) {
            if (d.this.f36640j != null) {
                k kVar = d.this.f36640j;
                kVar.e(new OtherException("exception occur while writing: " + bleException.getDescription()));
            }
            if (d.this.f36638h) {
                d.this.f36632b.sendMessageDelayed(d.this.f36632b.obtainMessage(51), d.this.f36639i);
            }
        }

        @Override // z0.k
        public void f(int i4, int i5, byte[] bArr) {
            int size = d.this.f36642l - d.this.f36641k.size();
            if (d.this.f36640j != null) {
                d.this.f36640j.f(size, d.this.f36642l, bArr);
            }
            if (d.this.f36638h) {
                d.this.f36632b.sendMessageDelayed(d.this.f36632b.obtainMessage(51), d.this.f36639i);
            }
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("splitWriter");
        this.f36631a = handlerThread;
        handlerThread.start();
        this.f36632b = new a(this.f36631a.getLooper());
    }

    private void h() {
        this.f36631a.quit();
        this.f36632b.removeCallbacksAndMessages(null);
    }

    private static Queue<byte[]> i(byte[] bArr, int i4) {
        int round;
        byte[] bArr2;
        if (i4 > 20) {
            com.clj.fastble.utils.a.d("Be careful: split count beyond 20! Ensure MTU higher than 23!");
        }
        LinkedList linkedList = new LinkedList();
        if (bArr.length % i4 == 0) {
            round = bArr.length / i4;
        } else {
            round = Math.round((bArr.length / i4) + 1);
        }
        if (round > 0) {
            for (int i5 = 0; i5 < round; i5++) {
                if (round != 1 && i5 != round - 1) {
                    bArr2 = new byte[i4];
                    System.arraycopy(bArr, i5 * i4, bArr2, 0, i4);
                } else {
                    int length = bArr.length % i4 == 0 ? i4 : bArr.length % i4;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr, i5 * i4, bArr3, 0, length);
                    bArr2 = bArr3;
                }
                linkedList.offer(bArr2);
            }
        }
        return linkedList;
    }

    private void j() {
        byte[] bArr = this.f36636f;
        if (bArr != null) {
            int i4 = this.f36637g;
            if (i4 >= 1) {
                Queue<byte[]> i5 = i(bArr, i4);
                this.f36641k = i5;
                this.f36642l = i5.size();
                l();
                return;
            }
            throw new IllegalArgumentException("split count should higher than 0!");
        }
        throw new IllegalArgumentException("data is Null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f36641k.peek() == null) {
            h();
            return;
        }
        this.f36633c.L().x(this.f36634d, this.f36635e).y(this.f36641k.poll(), new b(), this.f36635e);
        if (this.f36638h) {
            return;
        }
        this.f36632b.sendMessageDelayed(this.f36632b.obtainMessage(51), this.f36639i);
    }

    public void k(com.clj.fastble.bluetooth.a aVar, String str, String str2, byte[] bArr, boolean z3, long j4, k kVar) {
        this.f36633c = aVar;
        this.f36634d = str;
        this.f36635e = str2;
        this.f36636f = bArr;
        this.f36638h = z3;
        this.f36639i = j4;
        this.f36637g = com.clj.fastble.a.v().D();
        this.f36640j = kVar;
        j();
    }
}
