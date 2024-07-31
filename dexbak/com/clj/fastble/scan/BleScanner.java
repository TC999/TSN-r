package com.clj.fastble.scan;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.utils.BleLog;
import java.util.List;
import java.util.UUID;
import p589f0.BleScanAndConnectCallback;
import p589f0.BleScanCallback;
import p589f0.BleScanPresenterImp;

@TargetApi(18)
/* renamed from: com.clj.fastble.scan.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleScanner {

    /* renamed from: a */
    private BleScanState f23044a = BleScanState.STATE_IDLE;

    /* renamed from: b */
    private BleScanPresenter f23045b = new C6533a();

    /* compiled from: BleScanner.java */
    /* renamed from: com.clj.fastble.scan.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6533a extends BleScanPresenter {

        /* compiled from: BleScanner.java */
        /* renamed from: com.clj.fastble.scan.c$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class RunnableC6534a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f23047a;

            /* renamed from: b */
            final /* synthetic */ BleScanAndConnectCallback f23048b;

            RunnableC6534a(List list, BleScanAndConnectCallback bleScanAndConnectCallback) {
                this.f23047a = list;
                this.f23048b = bleScanAndConnectCallback;
            }

            @Override // java.lang.Runnable
            public void run() {
                BleManager.m36123v().m36154c((BleDevice) this.f23047a.get(0), this.f23048b);
            }
        }

        C6533a() {
        }

        @Override // com.clj.fastble.scan.BleScanPresenter
        /* renamed from: j */
        public void mo35965j(BleDevice bleDevice) {
            if (BleScanner.this.f23045b.m35996g()) {
                BleScanAndConnectCallback bleScanAndConnectCallback = (BleScanAndConnectCallback) BleScanner.this.f23045b.m35998e();
                if (bleScanAndConnectCallback != null) {
                    bleScanAndConnectCallback.m12760g(bleDevice);
                    return;
                }
                return;
            }
            BleScanCallback bleScanCallback = (BleScanCallback) BleScanner.this.f23045b.m35998e();
            if (bleScanCallback != null) {
                bleScanCallback.mo12758c(bleDevice);
            }
        }

        @Override // com.clj.fastble.scan.BleScanPresenter
        /* renamed from: k */
        public void mo35964k(List<BleDevice> list) {
            if (BleScanner.this.f23045b.m35996g()) {
                BleScanAndConnectCallback bleScanAndConnectCallback = (BleScanAndConnectCallback) BleScanner.this.f23045b.m35998e();
                if (list == null || list.size() < 1) {
                    if (bleScanAndConnectCallback != null) {
                        bleScanAndConnectCallback.m12759h(null);
                        return;
                    }
                    return;
                }
                if (bleScanAndConnectCallback != null) {
                    bleScanAndConnectCallback.m12759h(list.get(0));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC6534a(list, bleScanAndConnectCallback), 100L);
                return;
            }
            BleScanCallback bleScanCallback = (BleScanCallback) BleScanner.this.f23045b.m35998e();
            if (bleScanCallback != null) {
                bleScanCallback.mo12757d(list);
            }
        }

        @Override // com.clj.fastble.scan.BleScanPresenter
        /* renamed from: l */
        public void mo35963l(boolean z) {
            BleScanPresenterImp m35998e = BleScanner.this.f23045b.m35998e();
            if (m35998e != null) {
                m35998e.mo12756a(z);
            }
        }

        @Override // com.clj.fastble.scan.BleScanPresenter
        /* renamed from: m */
        public void mo35962m(BleDevice bleDevice) {
            BleScanPresenterImp m35998e = BleScanner.this.f23045b.m35998e();
            if (m35998e != null) {
                m35998e.mo12755b(bleDevice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BleScanner.java */
    /* renamed from: com.clj.fastble.scan.c$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6535b {

        /* renamed from: a */
        private static final BleScanner f23050a = new BleScanner();

        private C6535b() {
        }
    }

    /* renamed from: b */
    public static BleScanner m35971b() {
        return C6535b.f23050a;
    }

    /* renamed from: f */
    private synchronized void m35967f(UUID[] uuidArr, String[] strArr, String str, boolean z, boolean z2, long j, BleScanPresenterImp bleScanPresenterImp) {
        BleScanState bleScanState = this.f23044a;
        BleScanState bleScanState2 = BleScanState.STATE_IDLE;
        if (bleScanState != bleScanState2) {
            BleLog.m35957d("scan action already exists, complete the previous scan action first");
            if (bleScanPresenterImp != null) {
                bleScanPresenterImp.mo12756a(false);
            }
            return;
        }
        this.f23045b.m35993n(strArr, str, z, z2, j, bleScanPresenterImp);
        boolean startLeScan = BleManager.m36123v().m36130o().startLeScan(uuidArr, this.f23045b);
        if (startLeScan) {
            bleScanState2 = BleScanState.STATE_SCANNING;
        }
        this.f23044a = bleScanState2;
        this.f23045b.m35995h(startLeScan);
    }

    /* renamed from: c */
    public BleScanState m35970c() {
        return this.f23044a;
    }

    /* renamed from: d */
    public void m35969d(UUID[] uuidArr, String[] strArr, String str, boolean z, long j, BleScanCallback bleScanCallback) {
        m35967f(uuidArr, strArr, str, z, false, j, bleScanCallback);
    }

    /* renamed from: e */
    public void m35968e(UUID[] uuidArr, String[] strArr, String str, boolean z, long j, BleScanAndConnectCallback bleScanAndConnectCallback) {
        m35967f(uuidArr, strArr, str, z, true, j, bleScanAndConnectCallback);
    }

    /* renamed from: g */
    public synchronized void m35966g() {
        BleManager.m36123v().m36130o().stopLeScan(this.f23045b);
        this.f23044a = BleScanState.STATE_IDLE;
        this.f23045b.m35994i();
    }
}
