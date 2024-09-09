package com.bytedance.msdk.core.r;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.f.yu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class f extends ux {
    protected Map<Integer, Integer> ge;
    protected boolean ta;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context, String str, int i4) {
        super(context, str, i4);
        this.ge = new HashMap();
        this.ta = false;
    }

    protected boolean a(int i4) {
        List<p> list;
        long j4;
        Handler handler;
        Handler handler2;
        Map<Integer, List<p>> map = this.ev;
        boolean z3 = false;
        if (map == null || (list = map.get(Integer.valueOf(i4))) == null || list.size() == 0) {
            return false;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "loadAdByLoadSort start...\u6267\u884c\u5f53\u524d\u52a0\u8f7d\u5c42\u7ea7\uff1aloadSort:" + i4 + "  waterFallConfig.size:" + list.size());
        boolean z4 = list.get(0) != null && list.get(0).s() == 100;
        boolean z5 = list.get(0) != null && (list.get(0).s() == 1 || list.get(0).s() == 3);
        boolean z6 = list.get(0) != null && list.get(0).s() == 2;
        if (list.get(0) != null && list.get(0).s() == 0) {
            z3 = true;
        }
        if (z5) {
            this.f28158q.w(list.size());
        }
        this.f28158q.c(i4, list.size());
        Message obtain = Message.obtain();
        if (z4) {
            obtain.what = 4;
            obtain.obj = q.c(i4);
        } else if (z5) {
            obtain.what = 5;
        } else if (z3) {
            obtain.what = 1;
            obtain.arg1 = 10003;
            obtain.obj = q.c(i4);
        }
        if (z5) {
            j4 = this.f28110m;
        } else {
            j4 = this.bw;
        }
        if (!z6 && (handler2 = this.f28157p) != null) {
            if (obtain.what == 4) {
                handler2.removeMessages(4, q.c(i4));
            } else if (obtain.arg1 == 10003) {
                handler2.removeMessages(1, q.c(i4));
            } else {
                handler2.removeMessages(1);
            }
            this.f28157p.sendMessageDelayed(obtain, j4);
        }
        if (this.pr != 0 && (handler = this.f28157p) != null) {
            handler.removeMessages(3);
            this.f28157p.sendEmptyMessageDelayed(3, this.pr);
        }
        return sr(list);
    }

    protected int bk(int i4) {
        int i5 = -1;
        for (int i6 = 0; i6 < this.ia.size(); i6++) {
            if (this.ia.get(i6).intValue() == i4) {
                i5 = i6;
            }
        }
        return i5;
    }

    protected boolean bs() {
        for (int i4 = 0; i4 < this.ia.size(); i4++) {
            if (this.ia.get(i4).intValue() < -100 && (this.ge.get(this.ia.get(i4)).intValue() == 0 || this.ge.get(this.ia.get(i4)).intValue() == 1)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux, com.bytedance.msdk.core.r.xv
    public void c(int i4, boolean z3) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            xv(i4, z3);
        } else {
            super.c(i4, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void ck() {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            k();
        } else {
            super.ck();
        }
    }

    protected void g() {
        if (yu.w(this.ia)) {
            return;
        }
        int intValue = this.ia.get(0).intValue();
        if (intValue < -100) {
            for (int i4 = 0; i4 < bj(); i4++) {
                if (i4 < this.ia.size() && this.ia.get(i4).intValue() < -100) {
                    c(i4, false);
                }
            }
        } else if (intValue != -100 && intValue != 0) {
            for (int i5 = 0; i5 < bj(); i5++) {
                if (i5 < this.ia.size()) {
                    c(i5, false);
                }
            }
        } else {
            c(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.xv
    public void gb() {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            this.ta = false;
            p();
            g();
            ck();
            return;
        }
        super.gb();
    }

    protected int gd(int i4) {
        for (int i5 = 0; i5 < this.ia.size(); i5++) {
            int i6 = i4 + i5 + 1;
            if (i6 < this.ia.size()) {
                int intValue = this.ia.get(i6).intValue();
                if (this.ge.get(Integer.valueOf(intValue)) != null && this.ge.get(Integer.valueOf(intValue)).intValue() == 0) {
                    return i6;
                }
            }
        }
        return -1;
    }

    protected int k(int i4) {
        int intValue;
        for (int i5 = 0; i5 < this.ia.size(); i5++) {
            int i6 = i4 + i5 + 1;
            if (i6 < this.ia.size() && (intValue = this.ia.get(i6).intValue()) > 0 && this.ge.get(Integer.valueOf(intValue)).intValue() == 0) {
                return i6;
            }
        }
        return -1;
    }

    protected void lf() {
        for (int i4 = 0; i4 < this.ia.size(); i4++) {
            this.ge.put(this.ia.get(i4), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void ng() {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            lf();
            g();
            return;
        }
        super.ng();
    }

    protected int p(int i4) {
        int intValue;
        for (int i5 = 0; i5 < this.ia.size(); i5++) {
            int i6 = i4 + i5 + 1;
            if (i6 < this.ia.size() && (intValue = this.ia.get(i6).intValue()) < -100 && this.ge.get(Integer.valueOf(intValue)).intValue() == 0) {
                return i6;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public boolean r(int i4) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            return a(i4);
        }
        return super.r(i4);
    }

    protected void sr(int i4, boolean z3) {
        int p3 = p(i4);
        if (p3 > -1) {
            c(p3, z3);
        } else if (bs() && !this.ta) {
            this.ta = true;
            int gd = gd(i4);
            if (gd > 0) {
                if (this.ia.get(gd).intValue() > 0) {
                    for (int i5 = 0; i5 < bj(); i5++) {
                        int i6 = gd + i5;
                        if (i6 < this.ia.size()) {
                            c(i6, z3);
                        }
                    }
                } else if (this.ia.get(gd).intValue() == 0) {
                    c(gd, z3);
                } else if (!me()) {
                    c(gd, z3);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w(int i4, boolean z3) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            for (int i5 = 0; i5 < bj(); i5++) {
                int i6 = i4 + i5 + 1;
                if (i6 < this.ia.size()) {
                    c(i6, false);
                }
            }
            return;
        }
        super.w(i4, z3);
    }

    protected void xv(int i4, boolean z3) {
        if (this.sr.get() || fz()) {
            return;
        }
        if (i4 < this.ia.size()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cindex:" + i4 + "   \u5c42\u6570\uff1a" + this.ia.get(i4) + "  \u7684config\u914d\u7f6e............");
        }
        if (this.bj) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5df2\u7ecf\u8c03\u7528destroy\u65b9\u6cd5\uff0c\u4e0d\u518d\u7ee7\u7eed\u5e7f\u544a\u8bf7\u6c42");
            return;
        }
        if (i4 >= this.ia.size() || this.f28158q.ux(this.ia.get(i4).intValue())) {
            if (this.f28158q.r()) {
                if (this.f28162u.size() <= 0 && this.f28160s.size() <= 0 && this.fz.size() <= 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u6240\u6709\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210\uff0c\u4e14\u65e0\u5e7f\u544a\u8fd4\u56de.......");
                    w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
                } else {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u6240\u6709\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210\uff0c\u4e14\u6709\u5e7f\u544a\u8fd4\u56de.......invokeAdLoadedOnMSDKThread");
                    if (n()) {
                        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5b58\u5728client bidding\u4e14\u6ee1\u8db3\u89e6\u53d1\u6210\u529f\u56de\u8c03\u7684\u6761\u4ef6\uff0c\u5219\u7ed9\u51fa\u6210\u529f\u56de\u8c03.....");
                        ev();
                    }
                }
            }
            if (z3) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u8be5\u5c42\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u8fc7\uff0cisFromFailCallback\u4e3atrue.......");
                return;
            } else if (i4 >= this.ia.size()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......idx\u4e0b\u6807\u8d8a\u754c.......");
                return;
            } else if (this.ia.get(i4).intValue() == -100 && me()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u8be5\u5c42\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u8fc7,p\u5c42\u548cclientBidding\u591a\u9636\u5e95\u4ef7\u5e7f\u544a\u5e76\u884c\u7684\u60c5\u51b5\u4e0b\uff0cP\u5c42\u5df2\u7ecf\u6267\u884c\u5b8c\u4e14\u5168\u90e8\u8bf7\u6c42\u5931\u8d25,\u4e0d\u7528\u8bf7\u6c42\u4e0b\u4e00\u5c42.......");
                return;
            }
        }
        int intValue = this.ia.get(i4).intValue();
        if (!this.f28158q.ux(intValue)) {
            if (intValue < -100) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cP\u5c42\u5e7f\u544a............");
            } else if (intValue == -100) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cClientBidding\u548c\u591a\u9636\u5e95\u4ef7\u5c42\u5e7f\u544a............");
            } else if (intValue == 0) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884cserverBidding\u5c42\u5e7f\u544a............hasServerBidding: " + y());
            } else {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......\u5f00\u59cb\u6267\u884c\u666e\u901a\u5c42\u5e7f\u544a............");
            }
            if (intValue == 0 && y() && !this.f28158q.ev()) {
                this.f28158q.w(true);
                if (f(intValue)) {
                    this.ge.put(Integer.valueOf(intValue), 3);
                    w(new com.bytedance.msdk.api.c("\u6e32\u67d3\u7c7b\u578b\u9519\u8bef"), (com.bytedance.msdk.core.k.xv) null);
                    return;
                }
                xv(this.ev.get(Integer.valueOf(intValue)));
                w(i4, false);
                return;
            }
            if (intValue < -100) {
                this.wo = intValue;
            } else {
                this.f28107b = intValue;
            }
            this.f28158q.f(intValue);
            this.f28158q.c(intValue, true);
            if (this.ge.get(Integer.valueOf(intValue)) != null && this.ge.get(Integer.valueOf(intValue)).intValue() == 0) {
                this.ge.put(Integer.valueOf(intValue), 1);
            }
            if (!r(intValue)) {
                this.ge.put(Integer.valueOf(intValue), 3);
                c(i4, intValue, false);
                return;
            }
            if (intValue == -100) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......ClientBidding\u3001\u591a\u9636\u3001ServerBidding\u5e7f\u544a\u540c\u65f6\u53d1\u8d77\u8bf7\u6c42............");
                c(i4 + 1, false);
            }
            if (intValue == 0) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......ServerBidding ,\u666e\u901a\u5e7f\u544a\u540c\u65f6\u53d1\u8d77\u8bf7\u6c42............");
                for (int i5 = 0; i5 < bj(); i5++) {
                    int i6 = i4 + i5 + 1;
                    if (i6 < this.ia.size()) {
                        c(i6, false);
                    }
                }
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5c42\u64cd\u4f5c......index:" + i4 + "   \u5c42\u6570\uff1a" + this.ia.get(i4) + "\u7684\u5e7f\u544a\u5df2\u7ecf\u52a0\u8f7d\u8fc7\u4e86\uff0c\u5f00\u59cb\u6267\u884c\u4e0b\u4e00\u5c42............\uff1a" + intValue);
        c(i4, intValue, false);
    }

    protected void c(int i4, int i5, boolean z3) {
        if (i5 < -100) {
            sr(i4, z3);
        } else if (i5 == -100) {
            c(i4 + 1, z3);
        } else if (i5 == 0) {
            for (int i6 = 0; i6 < bj(); i6++) {
                int i7 = i4 + i6 + 1;
                if (i7 < this.ia.size()) {
                    c(i7, z3);
                }
            }
        } else {
            int k4 = k(i4);
            if (k4 > -1) {
                c(k4, z3);
            }
        }
    }

    private void k() {
        if (mt()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u629b\u51fa\u6210\u529f\u56de\u8c03_\u5e7f\u544a\u6c60\u4e2d\u5e7f\u544a\u6ee1\u8db3\u6570\u91cf\u76f4\u63a5\u8fd4\u56de......");
            if (n()) {
                com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5e7f\u544a\u6c60\u4e2d\u6709\u5e7f\u544a\u4e14\u6ee1\u8db3client bididing\u7684\u8fd4\u56de\u6761\u4ef6...\u7ed9\u51fa\u6210\u529f\u56de\u8c03...");
                ev();
            }
        }
    }

    private void p() {
        for (int i4 = 0; i4 < this.ia.size(); i4++) {
            if (this.ge.get(this.ia.get(i4)) == null) {
                this.ge.put(this.ia.get(i4), 0);
            }
        }
    }

    protected void w(Message message) {
        int k4;
        int k5;
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        int i4 = message.what;
        if (i4 == 1) {
            if (message.arg1 == 10003) {
                int intValue = ((Integer) message.obj).intValue();
                this.ge.put(Integer.valueOf(intValue), 4);
                if (y() && !wv()) {
                    com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....server Bidding \u7684\u8bf7\u6c42\u8fd8\u6ca1\u6709\u8fd4\u56de\uff0c\u7ee7\u7eed\u6267\u884c\u4e0b\u4e00\u5c42\u666e\u901a\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                    int bk = bk(intValue);
                    if (bk <= -1 || (k5 = k(bk)) <= -1) {
                        return;
                    }
                    c(k5, false);
                } else if (!mt()) {
                    com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u666e\u901a\u5e7f\u544a\u6c60\u6ca1\u5e7f\u544a\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                    int bk2 = bk(intValue);
                    if (bk2 <= -1 || (k4 = k(bk2)) <= -1) {
                        return;
                    }
                    c(k4, false);
                } else {
                    com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                    if (n()) {
                        com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42\u4e14\u6ee1\u8db3client bidding\u7684\u8fd4\u56de\u6761\u4ef6....mTTCommonAdPoolList.size()=" + this.f28160s.size());
                        ev();
                    }
                }
            }
        } else if (i4 == 2) {
            ok();
        } else if (i4 == 3) {
            h();
        } else if (i4 == 4) {
            int intValue2 = ((Integer) message.obj).intValue();
            if (this.ge.get(Integer.valueOf(intValue2)) != null && this.ge.get(Integer.valueOf(intValue2)).intValue() == 1) {
                this.ge.put(Integer.valueOf(intValue2), 4);
            }
            if (!up()) {
                com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....P\u5c42\u5e7f\u544a\u6c60\u6ca1\u5e7f\u544a\u6216\u8005\u6570\u91cf\u4e0d\u8fbe\u6807,\u5c1d\u8bd5\u6267\u884c\u4e0b\u5c42(\u4e0d\u4e00\u5b9a\u6267\u884c)....mTTPAdPoolList.size()=" + this.f28162u.size());
                int bk3 = bk(intValue2);
                if (bk3 > -1) {
                    sr(bk3, false);
                    return;
                }
                return;
            }
            com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5c42\u8d85\u65f6....\u5e7f\u544a\u6c60\u5df2\u6709P\u5c42\u7c7b\u578b\u5e7f\u544a\u4e0d\u6267\u884c\u4e0b\u5c42....mTTPAdPoolList.size()=" + this.f28162u.size());
            ev();
        } else if (i4 != 5) {
        } else {
            this.f28156n.set(true);
            if (y() && wv()) {
                if (mt()) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6210\u529f\u8fd4\u56de\u4e14\u5230\u8fbeClientBidding\u7684\u7b49\u5f85\u65f6\u95f4\uff0c\u5e7f\u544a\u6c60\u4e2d\u7684\u5e7f\u544a\u6570\u91cf\u6ee1\u8db3...\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                }
                if (this.f28158q.c() || !this.f28158q.r()) {
                    return;
                }
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5e7f\u544a\u90fd\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6210....... ");
                List<com.bytedance.msdk.c.ux> list3 = this.f28162u;
                if ((list3 != null && list3.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u8fd4\u56de\u4e14\u5230\u8fbeClientBidding\u7684\u7b49\u5f85\u65f6\u95f4\uff0c\u6240\u6709\u5e7f\u544a\u90fd\u6709\u8fd4\u56de\u7ed3\u679c...\u76f4\u63a5\u8fd4\u56de......");
                    ev();
                    return;
                }
                w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), (com.bytedance.msdk.core.k.xv) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(Message message) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            w(message);
        } else {
            super.c(message);
        }
    }

    @Override // com.bytedance.msdk.core.r.ux, com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            sr(list, xvVar);
        } else {
            super.c(list, xvVar);
        }
    }

    public void sr(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.xv xvVar) {
        if (this.f28157p == null || xvVar == null) {
            return;
        }
        c(list, this.f28159r);
        c(xvVar.bk(), xvVar.k(), xvVar.a(), com.bytedance.msdk.c.c.c(xvVar.w(), xvVar.c()), 0, AdLoadInfo.AD_LOADED);
        xv(list, xvVar);
        if (xvVar.ev() == 0 && !yu.w(list)) {
            String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
            if (ux(adNetworkSlotId)) {
                this.ge.put(Integer.valueOf(list.get(0).getShowSort()), 3);
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u8fd4\u56de\u7684\u666e\u901a\u5e7f\u544a\u88abserver Bidding\u8fc7\u6ee4\u4e86......slotId:" + adNetworkSlotId);
                return;
            }
        }
        this.f28158q.c(xvVar.bk());
        if (n_()) {
            w(list, xvVar);
        }
        ux(list);
        w(list, false);
        if (this.sr.get() || fz()) {
            return;
        }
        if (!yu.w(list) && list.get(0).isPAd() && up()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "P\u5c42\u5e7f\u544a\u5df2\u7ecf\u6210\u529f\u8fd4\u56deloadSort:" + list.get(0).getLoadSort() + " ,showSort:" + list.get(0).getShowSort());
            this.ge.put(Integer.valueOf(list.get(0).getShowSort()), 2);
            ev();
        } else if (((!y() && !eq()) || (y() && wv())) && !yu.w(list) && list.get(0).isNormalAd() && mt()) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u666e\u901a\u5c42\u5e7f\u544a\u5df2\u7ecf\u6210\u529f\u8fd4\u56deloadSort:" + list.get(0).getLoadSort() + " ,showSort:" + list.get(0).getShowSort());
            if (n()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6ee1\u8db3\u5e7f\u544a\u7684\u8fd4\u56de\u6761\u4ef6...\u76f4\u63a5\u8fd4\u56de...");
                ev();
            }
        } else if (xvVar.xv() && mt() && n()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u8fd4\u56de\u7ed3\u679c\u4e14\u6ee1\u8db3ClientBidding\u7b49\u5f85\u65f6\u95f4\u65f6\u5e7f\u544a\u6c60\u4e2d\u6709\u5e7f\u544a\u76f4\u63a5\u8fd4\u56de......");
            ev();
        } else if (this.f28158q.r() && n()) {
            com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5c42\u7ea7\u548c\u6240\u6709waterfall\u90fd\u5df2\u5b8c\u6210\u76f4\u63a5\u56de\u8c03...");
            ev();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux, com.bytedance.msdk.adapter.c.InterfaceC0386c
    public void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        com.bytedance.msdk.core.k.w wVar = this.f28159r;
        if (wVar != null && wVar.k()) {
            xv(cVar, xvVar);
        } else {
            super.c(cVar, xvVar);
        }
    }

    public void xv(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
        List<com.bytedance.msdk.c.ux> list;
        List<com.bytedance.msdk.c.ux> list2;
        com.bytedance.msdk.api.c.w wVar;
        int k4;
        if (this.f28157p == null || xvVar == null) {
            return;
        }
        w((List<com.bytedance.msdk.c.ux>) null, cVar);
        if (cVar != null) {
            c(xvVar.bk(), xvVar.k(), xvVar.a(), com.bytedance.msdk.c.c.c(xvVar.w(), xvVar.c()), cVar.xv, cVar.sr);
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5e7f\u544a\u52a0\u8f7d\u5931\u8d25...........adnName:" + xvVar.k() + " ,slotId:" + xvVar.bk() + ",slotType:" + xvVar.ev() + ",loadSort:" + xvVar.gd() + ",showSort:" + xvVar.p() + " \uff0cadError:" + cVar.toString());
        }
        if (xvVar.ev() == 0 && ux(xvVar.bk())) {
            return;
        }
        this.f28158q.c(xvVar.bk());
        this.f28158q.xv(xvVar.gd());
        if (xvVar.ux() || xvVar.sr()) {
            this.f28158q.xv();
            oh();
        }
        if (xvVar.xv() && mt() && n()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "SeverBidding\u5e7f\u544a\u6709\u8fd4\u56de\u7ed3\u679c\u4e14\u6ee1\u8db3ClientBidding\u7b49\u5f85\u65f6\u95f4\u65f6\u5e7f\u544a\u6c60\u4e2d\u6709\u5e7f\u544a\u76f4\u63a5\u8fd4\u56de......");
            ev();
        } else if (this.sr.get() || fz()) {
        } else {
            List<com.bytedance.msdk.c.ux> list3 = this.f28162u;
            if ((list3 != null && list3.size() > 0) || (((list = this.f28160s) != null && list.size() > 0) || ((list2 = this.fz) != null && list2.size() > 0))) {
                if (!this.f28158q.c() && this.f28158q.r() && n()) {
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5c42\u7ea7\u548c\u6240\u6709waterfall\u90fd\u5df2\u5b8c\u6210\u76f4\u63a5\u56de\u8c03...");
                    com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524d\u5e7f\u544a\u6c60\u4e2d\u6709\u5e7f\u544a\u4e14\u6ee1\u8db3client bididing\u7684\u8fd4\u56de\u6761\u4ef6...\u7ed9\u51fa\u6210\u529f\u56de\u8c03...");
                    ev();
                    return;
                }
            } else if (!this.f28158q.c() && this.f28158q.r() && (wVar = this.f28155k) != null && !TextUtils.isEmpty(com.bytedance.msdk.core.ia.c.c(wVar.wv()))) {
                w(cVar, xvVar);
                return;
            }
            if (xvVar.p() < -100) {
                if (this.ge.get(Integer.valueOf(xvVar.p())) != null && this.ge.get(Integer.valueOf(xvVar.p())).intValue() != 4) {
                    Handler handler = this.f28157p;
                    if (handler != null) {
                        handler.removeMessages(4, q.c(xvVar.p()));
                    }
                    this.ge.put(Integer.valueOf(xvVar.p()), 3);
                    int bk = bk(xvVar.p());
                    if (bk > -1) {
                        com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524dlevel\u4e3a\uff1a" + xvVar.p() + "\u7684P\u5c42\u8bf7\u6c42\u5931\u8d25-----onAdFailed--\u300b \u52a0\u8f7d\u4e0b\u4e00\u5c42-nextIdx=" + bk);
                        sr(bk, true);
                    }
                }
            } else if (xvVar.r() && this.ge.get(Integer.valueOf(xvVar.p())) != null && this.ge.get(Integer.valueOf(xvVar.p())).intValue() != 4) {
                Handler handler2 = this.f28157p;
                if (handler2 != null) {
                    handler2.removeMessages(1, q.c(xvVar.p()));
                }
                this.ge.put(Integer.valueOf(xvVar.p()), 3);
                int bk2 = bk(xvVar.p());
                if (bk2 > -1 && (k4 = k(bk2)) > -1) {
                    com.bytedance.msdk.adapter.sr.xv.xv("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u5f53\u524dlevel\u4e3a\uff1a" + xvVar.p() + "\u7684\u666e\u901a\u5c42\u8bf7\u6c42\u5931\u8d25-----onAdFailed--\u300b \u52a0\u8f7d\u4e0b\u4e00\u5c42-nextIdx=" + k4);
                    c(k4, true);
                }
            }
            if ((this.f28158q.c() || this.f28158q.r()) && n()) {
                com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(this.gd) + "\u6240\u6709\u5e7f\u544a\u90fd\u52a0\u8f7d\u5931\u8d25....");
                w(new com.bytedance.msdk.api.c(20005, com.bytedance.msdk.api.c.c(20005)), xvVar);
            }
        }
    }
}
