package com.beizi.fusion.p066d;

import android.content.Context;
import com.beizi.fusion.BaseAdListener;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.work.AdWorker;
import com.beizi.fusion.work.p080e.FinalLinkNativeNotificationWorker;
import com.tencent.connect.common.Constants;
import java.util.List;

/* renamed from: com.beizi.fusion.d.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NativeNotificationManager extends BaseManager {
    public NativeNotificationManager(Context context, String str, BaseAdListener baseAdListener, long j) {
        super(context, str, baseAdListener, j);
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    protected void mo48582a() {
        EventBean eventBean = this.f11097c;
        if (eventBean != null) {
            eventBean.m48915d(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        }
    }

    @Override // com.beizi.fusion.p066d.BaseManager
    /* renamed from: a */
    public AdWorker mo48580a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, AdWorker adWorker) {
        str.hashCode();
        return !str.equals("FinalLink") ? adWorker : new FinalLinkNativeNotificationWorker(this.f11096b, this.f11099e, this.f11100f, buyerBean, forwardBean, this);
    }
}
