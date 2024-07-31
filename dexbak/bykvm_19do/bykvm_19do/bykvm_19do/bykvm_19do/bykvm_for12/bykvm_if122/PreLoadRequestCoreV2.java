package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import java.util.List;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PreLoadRequestCoreV2 extends PreLoadRequestCore {

    /* renamed from: P */
    private int f423P;

    /* renamed from: Q */
    private int f424Q;

    /* JADX INFO: Access modifiers changed from: protected */
    public PreLoadRequestCoreV2(Context context, String str) {
        super(context, str);
        this.f423P = 0;
        this.f424Q = -1;
    }

    /* renamed from: c */
    private void m59658c(int i) {
        Integer num;
        Map<Integer, List<WaterFallConfig>> map;
        List<WaterFallConfig> list;
        if (i > this.f424Q) {
            this.f424Q = i;
            List<Integer> list2 = this.f21800m;
            if (list2 == null || i >= list2.size() || (num = this.f21800m.get(i)) == null || (map = this.f21792e) == null || !map.containsKey(num) || (list = this.f21792e.get(num)) == null) {
                return;
            }
            this.f423P += list.size();
        }
    }

    /* renamed from: A */
    public int m59659A() {
        int i = this.f423P;
        while (true) {
            char c = ']';
            char c2 = ']';
            while (true) {
                switch (c) {
                    case '\\':
                        switch (c2) {
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
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    /* renamed from: a */
    public void mo37419a(int i, boolean z) {
        try {
            m59658c(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.mo37419a(i, z);
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
                                return 2;
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
                                    return 2;
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
                            return 2;
                        }
                }
            }
        }
    }
}
