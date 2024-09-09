package com.clj.fastble.scan;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import java.util.List;
import java.util.UUID;
import z0.h;
import z0.i;
import z0.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleScanner.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private BleScanState f36711a = BleScanState.STATE_IDLE;

    /* renamed from: b  reason: collision with root package name */
    private com.clj.fastble.scan.a f36712b = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanner.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a extends com.clj.fastble.scan.a {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: BleScanner.java */
        /* renamed from: com.clj.fastble.scan.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6241084.dex */
        class RunnableC0542a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List f36714a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h f36715b;

            RunnableC0542a(List list, h hVar) {
                this.f36714a = list;
                this.f36715b = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.clj.fastble.a.v().c((BleDevice) this.f36714a.get(0), this.f36715b);
            }
        }

        a() {
        }

        @Override // com.clj.fastble.scan.a
        public void j(BleDevice bleDevice) {
            if (c.this.f36712b.g()) {
                h hVar = (h) c.this.f36712b.e();
                if (hVar != null) {
                    hVar.g(bleDevice);
                    return;
                }
                return;
            }
            i iVar = (i) c.this.f36712b.e();
            if (iVar != null) {
                iVar.c(bleDevice);
            }
        }

        @Override // com.clj.fastble.scan.a
        public void k(List<BleDevice> list) {
            if (c.this.f36712b.g()) {
                h hVar = (h) c.this.f36712b.e();
                if (list == null || list.size() < 1) {
                    if (hVar != null) {
                        hVar.h(null);
                        return;
                    }
                    return;
                }
                if (hVar != null) {
                    hVar.h(list.get(0));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0542a(list, hVar), 100L);
                return;
            }
            i iVar = (i) c.this.f36712b.e();
            if (iVar != null) {
                iVar.d(list);
            }
        }

        @Override // com.clj.fastble.scan.a
        public void l(boolean z3) {
            j e4 = c.this.f36712b.e();
            if (e4 != null) {
                e4.a(z3);
            }
        }

        @Override // com.clj.fastble.scan.a
        public void m(BleDevice bleDevice) {
            j e4 = c.this.f36712b.e();
            if (e4 != null) {
                e4.b(bleDevice);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanner.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final c f36717a = new c();

        private b() {
        }
    }

    public static c b() {
        return b.f36717a;
    }

    private synchronized void f(UUID[] uuidArr, String[] strArr, String str, boolean z3, boolean z4, long j4, j jVar) {
        BleScanState bleScanState = this.f36711a;
        BleScanState bleScanState2 = BleScanState.STATE_IDLE;
        if (bleScanState != bleScanState2) {
            com.clj.fastble.utils.a.d("scan action already exists, complete the previous scan action first");
            if (jVar != null) {
                jVar.a(false);
            }
            return;
        }
        this.f36712b.n(strArr, str, z3, z4, j4, jVar);
        boolean startLeScan = com.clj.fastble.a.v().o().startLeScan(uuidArr, this.f36712b);
        if (startLeScan) {
            bleScanState2 = BleScanState.STATE_SCANNING;
        }
        this.f36711a = bleScanState2;
        this.f36712b.h(startLeScan);
    }

    public BleScanState c() {
        return this.f36711a;
    }

    public void d(UUID[] uuidArr, String[] strArr, String str, boolean z3, long j4, i iVar) {
        f(uuidArr, strArr, str, z3, false, j4, iVar);
    }

    public void e(UUID[] uuidArr, String[] strArr, String str, boolean z3, long j4, h hVar) {
        f(uuidArr, strArr, str, z3, true, j4, hVar);
    }

    public synchronized void g() {
        com.clj.fastble.a.v().o().stopLeScan(this.f36712b);
        this.f36711a = BleScanState.STATE_IDLE;
        this.f36712b.i();
    }
}
