package com.bxkj.base.v2.common.utils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bxkj.base.BaseApp;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AMapLocationClient.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/bxkj/base/v2/common/utils/c;", "", "Lcom/bxkj/base/v2/common/utils/m;", "locationObserver", "Lkotlin/f1;", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f18599a = new c();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(m locationObserver, AMapLocation aMapLocation) {
        f0.p(locationObserver, "$locationObserver");
        if (aMapLocation.getErrorCode() == 0) {
            com.orhanobut.logger.j.d(f0.C("GPS\u5b9a\u4f4d\u6210\u529f", aMapLocation.getAddress()), new Object[0]);
            locationObserver.a(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            return;
        }
        locationObserver.b(Integer.valueOf(aMapLocation.getErrorCode()), aMapLocation.getErrorInfo());
    }

    public final void b(@NotNull final m locationObserver) {
        f0.p(locationObserver, "locationObserver");
        AMapLocationClient aMapLocationClient = new AMapLocationClient(BaseApp.b());
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setOnceLocationLatest(true);
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.base.v2.common.utils.b
            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                c.c(m.this, aMapLocation);
            }
        });
        aMapLocationClient.startLocation();
    }
}
