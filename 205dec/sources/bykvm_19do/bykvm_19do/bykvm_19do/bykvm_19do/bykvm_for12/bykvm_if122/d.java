package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.os.Message;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PreLoadRequestCoreV1.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d extends c {
    private int P;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, String str) {
        super(context, str);
        this.P = 0;
    }

    private TTBaseAd A() {
        for (char c4 = 'R'; c4 != 'P' && c4 != 'Q'; c4 = 'P') {
        }
        TTBaseAd tTBaseAd = null;
        List<f> h4 = b.a().h(this.f27883f);
        if (h4 != null && h4.size() > 0) {
            for (f fVar : h4) {
                if (fVar.f418a.isBidingAd()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(fVar.f418a);
                    a(arrayList, fVar.f418a);
                    if (tTBaseAd == null || tTBaseAd.getCpm() > fVar.f418a.getCpm()) {
                        tTBaseAd = fVar.f418a;
                    }
                }
            }
        }
        return tTBaseAd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void a(int i4, boolean z3) {
        char c4;
        int e4 = b.a().e(this.f27883f);
        if (h()) {
            e4++;
        }
        if (j()) {
            e4 += 2;
        }
        if (this.P >= e4) {
            Logger.d("TTMediationSDK", "--==--loadAdByLoadSort(" + this.P + ")\u8bf7\u6c42\u5c42\u6570\u8d85\u8fc7pre_load_sort_control(" + e4 + ")");
            c4 = 26;
        } else {
            List<Integer> list = this.f27890m;
            if (list != null) {
                if (i4 < list.size()) {
                    if (this.f27895r.o(this.f27890m.get(i4).intValue())) {
                        return;
                    }
                    this.P++;
                    super.a(i4, z3);
                    return;
                }
                return;
            }
            c4 = 27;
        }
        while (true) {
            switch (c4) {
                case 25:
                case 26:
                case 27:
                    return;
                default:
                    c4 = 25;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void a(Message message) {
        TTBaseAd A;
        if (message.arg1 == 10001 && message.what == 1 && h() && (A = A()) != null) {
            if (this.f27886i == 0.0d && A.getCpm() == 0.0d) {
                return;
            }
            a(A);
            Logger.d("TTMediationSDK", "--==-- \u9884\u8bf7\u6c42 \u6267\u884c\u4e86client bidding\u8fc7\u6ee4,lowestCpmAd: " + A.getAdNetWorkName() + ", loadSort: " + A.getLoadSort() + ", showSort: " + A.getShowSort() + ", cpm: " + A.getCpm());
        }
        super.a(message);
    }

    @Override // com.bytedance.msdk.core.corelogic.d
    public int b() {
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                            case 21:
                                return 1;
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c5) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    return 1;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 <= 4) {
                            break;
                        } else {
                            return 1;
                        }
                }
            }
        }
    }
}
