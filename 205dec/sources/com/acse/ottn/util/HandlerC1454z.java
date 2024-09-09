package com.acse.ottn.util;

import android.os.Handler;
import android.os.Message;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.service.ShopHelperService;
import io.reactivex.annotations.NonNull;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.z  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class HandlerC1454z extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f6902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1454z(A a4) {
        this.f6902a = a4;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        String str;
        int i4;
        int i5;
        int i6;
        String string;
        String str2;
        PageSettingTypeModel pageSettingTypeModel;
        A a4;
        String str3;
        boolean a5;
        boolean b4;
        super.handleMessage(message);
        this.f6902a.f6696o = true;
        try {
            int i7 = message.what;
            i4 = this.f6902a.f6689h;
            if (i7 == i4) {
                String string2 = message.getData().getString("coupon_packagename");
                String string3 = message.getData().getString("genuine_packagename");
                CommonUtil.isShowConpunInfor = true;
                this.f6902a.a((List<String>) null, string2, string3, "");
                return;
            }
            int i8 = message.what;
            i5 = this.f6902a.f6690i;
            if (i8 == i5) {
                str3 = A.f6686e;
                ra.a(str3, "\u5f53\u524d\u72b6\u6001 =adRequestCode");
                CommonUtil.isShowConpunInfor = true;
                String string4 = message.getData().getString("coupon_packagename");
                string = message.getData().getString("genuine_packagename");
                pageSettingTypeModel = V.a().b(string4);
                if (pageSettingTypeModel == null) {
                    return;
                }
                if (pageSettingTypeModel.getRead_type().equals("0")) {
                    this.f6902a.a((List<String>) null, pageSettingTypeModel.getPackage_name(), string, "");
                    return;
                } else if (!pageSettingTypeModel.getRead_type().equals("1")) {
                    return;
                } else {
                    a5 = this.f6902a.a(string4);
                    if (!a5) {
                        return;
                    }
                    b4 = this.f6902a.b(string);
                    if (!b4) {
                        return;
                    }
                    A.b().d(ShopHelperService.mService);
                    CommonUtil.isReadActivityPage = true;
                    a4 = this.f6902a;
                }
            } else {
                int i9 = message.what;
                i6 = this.f6902a.f6688g;
                if (i9 != i6) {
                    return;
                }
                String string5 = message.getData().getString("coupon_packagename");
                string = message.getData().getString("genuine_packagename");
                CommonUtil.isReadActivityPage = true;
                AdPackageModel b5 = V.a().b();
                str2 = A.f6686e;
                StringBuilder sb = new StringBuilder();
                sb.append("AdPackageModel.toString() =");
                sb.append(b5.toString());
                ra.a(str2, sb.toString());
                pageSettingTypeModel = new PageSettingTypeModel();
                pageSettingTypeModel.setPackage_name(string5);
                pageSettingTypeModel.setIs_click_jd_title(b5.getIs_click_jd_title());
                pageSettingTypeModel.setRead_time(b5.getReadpage_time());
                pageSettingTypeModel.setRead_description(b5.getRead_description());
                if (H.a().ra.equals(string5)) {
                    pageSettingTypeModel.setRead_length(b5.getTb_readpage_size());
                } else {
                    if (H.a().ta.equals(string5)) {
                        pageSettingTypeModel.setRead_type(b5.getJd_readpage_type());
                        pageSettingTypeModel.setRead_length(b5.getJd_readpage_size());
                    } else if (H.a().ua.equals(string5)) {
                        pageSettingTypeModel.setRead_length(b5.getTb_readpage_size());
                    } else if (H.a().sa.equals(string5)) {
                        pageSettingTypeModel.setRead_length(b5.getTb_readpage_size());
                    }
                    a4 = this.f6902a;
                }
                pageSettingTypeModel.setRead_type(b5.getTb_readpage_type());
                a4 = this.f6902a;
            }
            a4.a(pageSettingTypeModel, string);
        } catch (Exception e4) {
            str = A.f6686e;
            ra.a(str, "mHandler =" + e4.getMessage());
        }
    }
}
