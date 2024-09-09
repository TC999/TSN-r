package z;

import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: UpdateUiCallBack.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface a {
    void a(LatLng newLatLng, LatLng lastLatLng, float speed, String distance, String avgSpeed, String pace, boolean isPause);

    void b(LatLng latLng);

    void c(String msg);

    void d(String countTime);

    void e(String avgSpeed, String pace, String countTime, String distance, List<LatLngTimeSpeed> latLngTimeSpeedList);

    void f(LatLng startLatLng);

    void g(String status, int resId);

    void h();
}
