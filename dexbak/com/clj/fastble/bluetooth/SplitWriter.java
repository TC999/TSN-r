package com.clj.fastble.bluetooth;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.BleManager;
import com.clj.fastble.exception.BleException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.utils.BleLog;
import java.util.LinkedList;
import java.util.Queue;
import p589f0.BleWriteCallback;

/* renamed from: com.clj.fastble.bluetooth.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SplitWriter {

    /* renamed from: a */
    private HandlerThread f22955a;

    /* renamed from: b */
    private Handler f22956b;

    /* renamed from: c */
    private BleBluetooth f22957c;

    /* renamed from: d */
    private String f22958d;

    /* renamed from: e */
    private String f22959e;

    /* renamed from: f */
    private byte[] f22960f;

    /* renamed from: g */
    private int f22961g;

    /* renamed from: h */
    private boolean f22962h;

    /* renamed from: i */
    private long f22963i;

    /* renamed from: j */
    private BleWriteCallback f22964j;

    /* renamed from: k */
    private Queue<byte[]> f22965k;

    /* renamed from: l */
    private int f22966l;

    /* compiled from: SplitWriter.java */
    /* renamed from: com.clj.fastble.bluetooth.d$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC6522a extends Handler {
        HandlerC6522a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 51) {
                SplitWriter.this.m36020l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplitWriter.java */
    /* renamed from: com.clj.fastble.bluetooth.d$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6523b extends BleWriteCallback {
        C6523b() {
        }

        @Override // p589f0.BleWriteCallback
        /* renamed from: e */
        public void mo12754e(BleException bleException) {
            if (SplitWriter.this.f22964j != null) {
                BleWriteCallback bleWriteCallback = SplitWriter.this.f22964j;
                bleWriteCallback.mo12754e(new OtherException("exception occur while writing: " + bleException.getDescription()));
            }
            if (SplitWriter.this.f22962h) {
                SplitWriter.this.f22956b.sendMessageDelayed(SplitWriter.this.f22956b.obtainMessage(51), SplitWriter.this.f22963i);
            }
        }

        @Override // p589f0.BleWriteCallback
        /* renamed from: f */
        public void mo12753f(int i, int i2, byte[] bArr) {
            int size = SplitWriter.this.f22966l - SplitWriter.this.f22965k.size();
            if (SplitWriter.this.f22964j != null) {
                SplitWriter.this.f22964j.mo12753f(size, SplitWriter.this.f22966l, bArr);
            }
            if (SplitWriter.this.f22962h) {
                SplitWriter.this.f22956b.sendMessageDelayed(SplitWriter.this.f22956b.obtainMessage(51), SplitWriter.this.f22963i);
            }
        }
    }

    public SplitWriter() {
        HandlerThread handlerThread = new HandlerThread("splitWriter");
        this.f22955a = handlerThread;
        handlerThread.start();
        this.f22956b = new HandlerC6522a(this.f22955a.getLooper());
    }

    /* renamed from: h */
    private void m36024h() {
        this.f22955a.quit();
        this.f22956b.removeCallbacksAndMessages(null);
    }

    /* renamed from: i */
    private static Queue<byte[]> m36023i(byte[] bArr, int i) {
        int round;
        byte[] bArr2;
        if (i > 20) {
            BleLog.m35957d("Be careful: split count beyond 20! Ensure MTU higher than 23!");
        }
        LinkedList linkedList = new LinkedList();
        if (bArr.length % i == 0) {
            round = bArr.length / i;
        } else {
            round = Math.round((bArr.length / i) + 1);
        }
        if (round > 0) {
            for (int i2 = 0; i2 < round; i2++) {
                if (round != 1 && i2 != round - 1) {
                    bArr2 = new byte[i];
                    System.arraycopy(bArr, i2 * i, bArr2, 0, i);
                } else {
                    int length = bArr.length % i == 0 ? i : bArr.length % i;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr, i2 * i, bArr3, 0, length);
                    bArr2 = bArr3;
                }
                linkedList.offer(bArr2);
            }
        }
        return linkedList;
    }

    /* renamed from: j */
    private void m36022j() {
        byte[] bArr = this.f22960f;
        if (bArr != null) {
            int i = this.f22961g;
            if (i >= 1) {
                Queue<byte[]> m36023i = m36023i(bArr, i);
                this.f22965k = m36023i;
                this.f22966l = m36023i.size();
                m36020l();
                return;
            }
            throw new IllegalArgumentException("split count should higher than 0!");
        }
        throw new IllegalArgumentException("data is Null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m36020l() {
        if (this.f22965k.peek() == null) {
            m36024h();
            return;
        }
        this.f22957c.m36106L().m36048x(this.f22958d, this.f22959e).m36047y(this.f22965k.poll(), new C6523b(), this.f22959e);
        if (this.f22962h) {
            return;
        }
        this.f22956b.sendMessageDelayed(this.f22956b.obtainMessage(51), this.f22963i);
    }

    /* renamed from: k */
    public void m36021k(BleBluetooth bleBluetooth, String str, String str2, byte[] bArr, boolean z, long j, BleWriteCallback bleWriteCallback) {
        this.f22957c = bleBluetooth;
        this.f22958d = str;
        this.f22959e = str2;
        this.f22960f = bArr;
        this.f22962h = z;
        this.f22963i = j;
        this.f22961g = BleManager.m36123v().m36181D();
        this.f22964j = bleWriteCallback;
        m36022j();
    }
}
