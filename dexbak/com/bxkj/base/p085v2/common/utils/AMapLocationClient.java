package com.bxkj.base.p085v2.common.utils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bxkj.base.BaseApp;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/c;", "", "Lcom/bxkj/base/v2/common/utils/m;", "locationObserver", "Lkotlin/f1;", "b", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AMapLocationClient {
    @NotNull

    /* renamed from: a */
    public static final AMapLocationClient f15111a = new AMapLocationClient();

    private AMapLocationClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final void m43809c(LocationObserver locationObserver, AMapLocation aMapLocation) {
        C14342f0.m8184p(locationObserver, "$locationObserver");
        if (aMapLocation.getErrorCode() == 0) {
            C11792j.m20469d(C14342f0.m8216C("GPS定位成功", aMapLocation.getAddress()), new Object[0]);
            locationObserver.mo43544a(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            return;
        }
        locationObserver.mo43543b(Integer.valueOf(aMapLocation.getErrorCode()), aMapLocation.getErrorInfo());
    }

    /* renamed from: b */
    public final void m43810b(@NotNull final LocationObserver locationObserver) {
        C14342f0.m8184p(locationObserver, "locationObserver");
        com.amap.api.location.AMapLocationClient aMapLocationClient = new com.amap.api.location.AMapLocationClient(BaseApp.m44341b());
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setOnceLocationLatest(true);
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.base.v2.common.utils.b
            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                AMapLocationClient.m43809c(LocationObserver.this, aMapLocation);
            }
        });
        aMapLocationClient.startLocation();
    }
}
