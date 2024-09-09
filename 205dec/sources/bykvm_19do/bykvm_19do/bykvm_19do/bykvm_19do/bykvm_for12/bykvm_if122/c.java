package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore;
import java.util.List;

/* compiled from: PreLoadRequestCore.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c extends TTAdHeaderBidingRequestCore {
    private long O;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, String str) {
        super(context, str);
    }

    static /* synthetic */ void a(c cVar, AdError adError, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        super.onAdFailed(adError, dVar);
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
                                default:
                                    c5 = '[';
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                            }
                        }
                        c4 = '^';
                        c5 = 'K';
                    case '^':
                        if (c5 <= 4) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                        case 21:
                            return;
                        case 22:
                        case 23:
                            c4 = ']';
                            c5 = ']';
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        return;
                    default:
                        c5 = '[';
                }
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.O = SystemClock.currentThreadTimeMillis();
        b.a().a(this.f27883f, this.O);
        this.f27885h = adSlot;
        this.A = null;
        x();
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void a(List<TTBaseAd> list, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        for (TTBaseAd tTBaseAd : list) {
            if (tTBaseAd != null) {
                b.a().a(this.f27883f, new f(tTBaseAd, dVar, this.O, SystemClock.elapsedRealtime(), this.f27885h));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.corelogic.d
    public boolean i() {
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                            case 21:
                                return true;
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
                                    return true;
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
                            return true;
                        }
                }
            }
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
    public void onAdFailed(AdError adError, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar) {
        a(this, adError, dVar);
        b.a().a(this.f27883f, dVar.d(), this.O, adError);
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        while (true) {
            char c4 = '^';
            char c5 = 'K';
            while (true) {
                if (c4 == '\\') {
                    switch (c5) {
                        case 21:
                            return;
                        case 22:
                        case 23:
                            c4 = ']';
                            c5 = ']';
                    }
                } else if (c4 != ']') {
                    c4 = ']';
                    c5 = ']';
                }
            }
            while (true) {
                switch (c5) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        return;
                    default:
                        c5 = '[';
                }
            }
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
        while (true) {
            char c4 = ']';
            char c5 = ']';
            while (true) {
                switch (c4) {
                    case '\\':
                        switch (c5) {
                            case 21:
                                return;
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
                                    return;
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
                            return;
                        }
                }
            }
        }
    }
}
