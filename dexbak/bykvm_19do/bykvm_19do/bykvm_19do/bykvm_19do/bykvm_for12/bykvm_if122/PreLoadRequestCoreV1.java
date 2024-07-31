package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.os.Message;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.base.TTBaseAd;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PreLoadRequestCoreV1 extends PreLoadRequestCore {

    /* renamed from: P */
    private int f422P;

    /* JADX INFO: Access modifiers changed from: protected */
    public PreLoadRequestCoreV1(Context context, String str) {
        super(context, str);
        this.f422P = 0;
    }

    /* renamed from: A */
    private TTBaseAd m59660A() {
        for (char c = 'R'; c != 'P' && c != 'Q'; c = 'P') {
        }
        TTBaseAd tTBaseAd = null;
        List<TTBaseAdCache> m59663h = PreLoadManager.m59686a().m59663h(this.f21793f);
        if (m59663h != null && m59663h.size() > 0) {
            for (TTBaseAdCache tTBaseAdCache : m59663h) {
                if (tTBaseAdCache.f425a.isBidingAd()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(tTBaseAdCache.f425a);
                    m37351a(arrayList, tTBaseAdCache.f425a);
                    if (tTBaseAd == null || tTBaseAd.getCpm() > tTBaseAdCache.f425a.getCpm()) {
                        tTBaseAd = tTBaseAdCache.f425a;
                    }
                }
            }
        }
        return tTBaseAd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    public void mo37419a(int i, boolean z) {
        char c;
        int m59668e = PreLoadManager.m59686a().m59668e(this.f21793f);
        if (m37340h()) {
            m59668e++;
        }
        if (m37338j()) {
            m59668e += 2;
        }
        if (this.f422P >= m59668e) {
            Logger.m37562d("TTMediationSDK", "--==--loadAdByLoadSort(" + this.f422P + ")请求层数超过pre_load_sort_control(" + m59668e + ")");
            c = JSONLexer.EOI;
        } else {
            List<Integer> list = this.f21800m;
            if (list != null) {
                if (i < list.size()) {
                    if (this.f21805r.m37290o(this.f21800m.get(i).intValue())) {
                        return;
                    }
                    this.f422P++;
                    super.mo37419a(i, z);
                    return;
                }
                return;
            }
            c = 27;
        }
        while (true) {
            switch (c) {
                case 25:
                case 26:
                case 27:
                    return;
                default:
                    c = 25;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    public void mo37418a(Message message) {
        TTBaseAd m59660A;
        if (message.arg1 == 10001 && message.what == 1 && m37340h() && (m59660A = m59660A()) != null) {
            if (this.f21796i == Utils.DOUBLE_EPSILON && m59660A.getCpm() == Utils.DOUBLE_EPSILON) {
                return;
            }
            m37357a(m59660A);
            Logger.m37562d("TTMediationSDK", "--==-- 预请求 执行了client bidding过滤,lowestCpmAd: " + m59660A.getAdNetWorkName() + ", loadSort: " + m59660A.getLoadSort() + ", showSort: " + m59660A.getShowSort() + ", cpm: " + m59660A.getCpm());
        }
        super.mo37418a(message);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTADBidingRequestCore
    /* renamed from: b */
    public int mo37349b() {
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
                            case 21:
                                return 1;
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    return 1;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            return 1;
                        }
                }
            }
        }
    }
}
