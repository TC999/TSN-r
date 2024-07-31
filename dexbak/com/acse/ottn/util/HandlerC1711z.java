package com.acse.ottn.util;

import android.os.Handler;
import android.os.Message;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.service.ShopHelperService;
import io.reactivex.annotations.NonNull;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class HandlerC1711z extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1617A f3392a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1711z(C1617A c1617a) {
        this.f3392a = c1617a;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        String str;
        int i;
        int i2;
        int i3;
        String string;
        String str2;
        PageSettingTypeModel pageSettingTypeModel;
        C1617A c1617a;
        String str3;
        boolean m56336a;
        boolean m56324b;
        super.handleMessage(message);
        this.f3392a.f3123o = true;
        try {
            int i4 = message.what;
            i = this.f3392a.f3116h;
            if (i4 == i) {
                String string2 = message.getData().getString("coupon_packagename");
                String string3 = message.getData().getString("genuine_packagename");
                CommonUtil.isShowConpunInfor = true;
                this.f3392a.m56332a((List<String>) null, string2, string3, "");
                return;
            }
            int i5 = message.what;
            i2 = this.f3392a.f3117i;
            if (i5 == i2) {
                str3 = C1617A.f3113e;
                C1694ra.m55917a(str3, "当前状态 =adRequestCode");
                CommonUtil.isShowConpunInfor = true;
                String string4 = message.getData().getString("coupon_packagename");
                string = message.getData().getString("genuine_packagename");
                pageSettingTypeModel = C1652V.m56140a().m56131b(string4);
                if (pageSettingTypeModel == null) {
                    return;
                }
                if (pageSettingTypeModel.getRead_type().equals("0")) {
                    this.f3392a.m56332a((List<String>) null, pageSettingTypeModel.getPackage_name(), string, "");
                    return;
                } else if (!pageSettingTypeModel.getRead_type().equals("1")) {
                    return;
                } else {
                    m56336a = this.f3392a.m56336a(string4);
                    if (!m56336a) {
                        return;
                    }
                    m56324b = this.f3392a.m56324b(string);
                    if (!m56324b) {
                        return;
                    }
                    C1617A.m56331b().m56315d(ShopHelperService.mService);
                    CommonUtil.isReadActivityPage = true;
                    c1617a = this.f3392a;
                }
            } else {
                int i6 = message.what;
                i3 = this.f3392a.f3115g;
                if (i6 != i3) {
                    return;
                }
                String string5 = message.getData().getString("coupon_packagename");
                string = message.getData().getString("genuine_packagename");
                CommonUtil.isReadActivityPage = true;
                AdPackageModel m56133b = C1652V.m56140a().m56133b();
                str2 = C1617A.f3113e;
                StringBuilder sb = new StringBuilder();
                sb.append("AdPackageModel.toString() =");
                sb.append(m56133b.toString());
                C1694ra.m55917a(str2, sb.toString());
                pageSettingTypeModel = new PageSettingTypeModel();
                pageSettingTypeModel.setPackage_name(string5);
                pageSettingTypeModel.setIs_click_jd_title(m56133b.getIs_click_jd_title());
                pageSettingTypeModel.setRead_time(m56133b.getReadpage_time());
                pageSettingTypeModel.setRead_description(m56133b.getRead_description());
                if (C1631H.m56262a().f3227ra.equals(string5)) {
                    pageSettingTypeModel.setRead_length(m56133b.getTb_readpage_size());
                } else {
                    if (C1631H.m56262a().f3231ta.equals(string5)) {
                        pageSettingTypeModel.setRead_type(m56133b.getJd_readpage_type());
                        pageSettingTypeModel.setRead_length(m56133b.getJd_readpage_size());
                    } else if (C1631H.m56262a().f3233ua.equals(string5)) {
                        pageSettingTypeModel.setRead_length(m56133b.getTb_readpage_size());
                    } else if (C1631H.m56262a().f3229sa.equals(string5)) {
                        pageSettingTypeModel.setRead_length(m56133b.getTb_readpage_size());
                    }
                    c1617a = this.f3392a;
                }
                pageSettingTypeModel.setRead_type(m56133b.getTb_readpage_type());
                c1617a = this.f3392a;
            }
            c1617a.m56345a(pageSettingTypeModel, string);
        } catch (Exception e) {
            str = C1617A.f3113e;
            C1694ra.m55917a(str, "mHandler =" + e.getMessage());
        }
    }
}
