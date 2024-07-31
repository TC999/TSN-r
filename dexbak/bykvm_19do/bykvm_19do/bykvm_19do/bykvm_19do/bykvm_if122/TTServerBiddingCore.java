package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTCollectionUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTServerBiddingCore implements ITTBiddingCore {
    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.ITTBiddingCore
    /* renamed from: a */
    public void mo59647a(BiddingRequestModel biddingRequestModel, @NonNull ITTBiddingCore.InterfaceC0962a interfaceC0962a) {
        if (biddingRequestModel != null && biddingRequestModel.f437c != null && biddingRequestModel.f439e != null && !TTCollectionUtils.m59112a(biddingRequestModel.f438d)) {
            String m59531t = biddingRequestModel.f439e.m59531t();
            Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(biddingRequestModel.f437c.getAdUnitId()) + "开启server bidding网络请求......：");
            AdEventUtil.m59304b(biddingRequestModel.f437c, m59531t);
            ServerBiddingHelper.m59793d().m59802a(biddingRequestModel.f437c, biddingRequestModel.f438d, biddingRequestModel.f439e, biddingRequestModel.f440f, new C0964a(System.currentTimeMillis(), biddingRequestModel, new int[]{4}, m59531t, interfaceC0962a));
            return;
        }
        interfaceC0962a.mo37332a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<WaterFallConfig> m59645a(List<WaterFallConfig> list, AdsenseRitConfig adsenseRitConfig) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0 && adsenseRitConfig != null && adsenseRitConfig.m59532s() != null && adsenseRitConfig.m59532s().size() != 0) {
            arrayList = new ArrayList();
            for (WaterFallConfig waterFallConfig : adsenseRitConfig.m59532s()) {
                Iterator<WaterFallConfig> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        WaterFallConfig next = it.next();
                        if (waterFallConfig != null && next != null && waterFallConfig.m59474e() == 0 && !TextUtils.isEmpty(waterFallConfig.m59480c()) && waterFallConfig.m59480c().equals(next.m59480c())) {
                            arrayList.add(waterFallConfig);
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* compiled from: TTServerBiddingCore.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C0964a implements ServerBiddingHelper.InterfaceC0954d {

        /* renamed from: a */
        final /* synthetic */ long f441a;

        /* renamed from: b */
        final /* synthetic */ BiddingRequestModel f442b;

        /* renamed from: c */
        final /* synthetic */ int[] f443c;

        /* renamed from: d */
        final /* synthetic */ String f444d;

        /* renamed from: e */
        final /* synthetic */ ITTBiddingCore.InterfaceC0962a f445e;

        C0964a(long j, BiddingRequestModel biddingRequestModel, int[] iArr, String str, ITTBiddingCore.InterfaceC0962a interfaceC0962a) {
            this.f441a = j;
            this.f442b = biddingRequestModel;
            this.f443c = iArr;
            this.f444d = str;
            this.f445e = interfaceC0962a;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.InterfaceC0954d
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo59644a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ServerBiddingModel r11) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTServerBiddingCore.C0964a.mo59644a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.e):void");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_char12.ServerBiddingHelper.InterfaceC0954d
        /* renamed from: a */
        public void mo59643a(AdError adError) {
            Logger.m37557e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f442b.f437c.getAdUnitId()) + "server bidding网络请求响应失败......：");
            int[] iArr = this.f443c;
            iArr[0] = 5;
            AdEventUtil.m59320a(this.f442b.f437c, iArr[0], System.currentTimeMillis() - this.f441a, this.f444d, null);
            ITTBiddingCore.InterfaceC0962a interfaceC0962a = this.f445e;
            if (interfaceC0962a != null) {
                interfaceC0962a.mo37332a(null);
            }
        }
    }
}
