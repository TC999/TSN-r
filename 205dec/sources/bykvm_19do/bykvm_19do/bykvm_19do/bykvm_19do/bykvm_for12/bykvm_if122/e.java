package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import java.util.List;
import java.util.Map;

/* compiled from: PreLoadRequestCoreV2.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e extends c {
    private int P;
    private int Q;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, String str) {
        super(context, str);
        this.P = 0;
        this.Q = -1;
    }

    private void c(int i4) {
        Integer num;
        Map<Integer, List<h>> map;
        List<h> list;
        if (i4 > this.Q) {
            this.Q = i4;
            List<Integer> list2 = this.f27890m;
            if (list2 == null || i4 >= list2.size() || (num = this.f27890m.get(i4)) == null || (map = this.f27882e) == null || !map.containsKey(num) || (list = this.f27882e.get(num)) == null) {
                return;
            }
            this.P += list.size();
        }
    }

    public int A() {
        int i4 = this.P;
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
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
                                    break;
                                default:
                                    c5 = '[';
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                        break;
                    case '^':
                        if (c5 > 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void a(int i4, boolean z3) {
        try {
            c(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.a(i4, z3);
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
                                return 2;
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
                                    return 2;
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
                            return 2;
                        }
                }
            }
        }
    }
}
