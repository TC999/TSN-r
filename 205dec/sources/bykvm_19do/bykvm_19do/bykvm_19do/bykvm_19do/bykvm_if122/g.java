package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.u;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TTServerBiddingCore.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g implements d {
    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d
    public void a(b bVar, @NonNull d.a aVar) {
        if (bVar != null && bVar.f430c != null && bVar.f432e != null && !u.a(bVar.f431d)) {
            String t3 = bVar.f432e.t();
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(bVar.f430c.getAdUnitId()) + "\u5f00\u542fserver bidding\u7f51\u7edc\u8bf7\u6c42......\uff1a");
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.b(bVar.f430c, t3);
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.d().a(bVar.f430c, bVar.f431d, bVar.f432e, bVar.f433f, new a(System.currentTimeMillis(), bVar, new int[]{4}, t3, aVar));
            return;
        }
        aVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(List<h> list, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.c cVar) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0 && cVar != null && cVar.s() != null && cVar.s().size() != 0) {
            arrayList = new ArrayList();
            for (h hVar : cVar.s()) {
                Iterator<h> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        h next = it.next();
                        if (hVar != null && next != null && hVar.e() == 0 && !TextUtils.isEmpty(hVar.c()) && hVar.c().equals(next.c())) {
                            arrayList.add(hVar);
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* compiled from: TTServerBiddingCore.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f434a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f435b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int[] f436c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f437d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d.a f438e;

        a(long j4, b bVar, int[] iArr, String str, d.a aVar) {
            this.f434a = j4;
            this.f435b = bVar;
            this.f436c = iArr;
            this.f437d = str;
            this.f438e = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.e r11) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.g.a.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.e):void");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.a.d
        public void a(AdError adError) {
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f435b.f430c.getAdUnitId()) + "server bidding\u7f51\u7edc\u8bf7\u6c42\u54cd\u5e94\u5931\u8d25......\uff1a");
            int[] iArr = this.f436c;
            iArr[0] = 5;
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(this.f435b.f430c, iArr[0], System.currentTimeMillis() - this.f434a, this.f437d, null);
            d.a aVar = this.f438e;
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }
}
