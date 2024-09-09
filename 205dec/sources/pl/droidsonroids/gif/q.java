package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RenderTask.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class q extends s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(e eVar) {
        super(eVar);
    }

    @Override // pl.droidsonroids.gif.s
    public void a() {
        e eVar = this.f61882a;
        long B = eVar.f61830g.B(eVar.f61829f);
        if (B >= 0) {
            this.f61882a.f61826c = SystemClock.uptimeMillis() + B;
            if (this.f61882a.isVisible() && this.f61882a.f61825b) {
                e eVar2 = this.f61882a;
                if (!eVar2.f61835l) {
                    eVar2.f61824a.remove(this);
                    e eVar3 = this.f61882a;
                    eVar3.f61839p = eVar3.f61824a.schedule(this, B, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f61882a.f61831h.isEmpty() && this.f61882a.h() == this.f61882a.f61830g.n() - 1) {
                e eVar4 = this.f61882a;
                eVar4.f61836m.sendEmptyMessageAtTime(eVar4.i(), this.f61882a.f61826c);
            }
        } else {
            e eVar5 = this.f61882a;
            eVar5.f61826c = Long.MIN_VALUE;
            eVar5.f61825b = false;
        }
        if (!this.f61882a.isVisible() || this.f61882a.f61836m.hasMessages(-1)) {
            return;
        }
        this.f61882a.f61836m.sendEmptyMessageAtTime(-1, 0L);
    }
}
