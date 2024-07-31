package p662z;

import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.util.List;

/* renamed from: z.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface UpdateUiCallBack {
    /* renamed from: a */
    void m16a(LatLng newLatLng, LatLng lastLatLng, float speed, String distance, String avgSpeed, String pace, boolean isPause);

    /* renamed from: b */
    void m15b(LatLng latLng);

    /* renamed from: c */
    void m14c(String msg);

    /* renamed from: d */
    void m13d(String countTime);

    /* renamed from: e */
    void m12e(String avgSpeed, String pace, String countTime, String distance, List<LatLngTimeSpeed> latLngTimeSpeedList);

    /* renamed from: f */
    void m11f(LatLng startLatLng);

    /* renamed from: g */
    void m10g(String status, int resId);

    /* renamed from: h */
    void m9h();
}
