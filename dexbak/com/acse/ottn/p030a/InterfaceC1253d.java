package com.acse.ottn.p030a;

import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdInfoModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* renamed from: com.acse.ottn.a.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface InterfaceC1253d {
    @POST("api/mobile_app")
    /* renamed from: a */
    Observable<String> m57355a(@Body RequestBody requestBody);

    @POST("api/report")
    /* renamed from: b */
    Observable<String> m57354b(@Body RequestBody requestBody);

    @POST("api/an/gc/scroll")
    /* renamed from: c */
    Observable<AccessiblityModel> m57353c(@Body RequestBody requestBody);

    @POST("api/data_check")
    /* renamed from: d */
    Observable<String> m57352d(@Body RequestBody requestBody);

    @POST("api/clear_ad_time")
    /* renamed from: e */
    Observable<String> m57351e(@Body RequestBody requestBody);

    @POST("api/close_plugin")
    /* renamed from: f */
    Observable<String> m57350f(@Body RequestBody requestBody);

    @POST("api/plugin_change")
    /* renamed from: g */
    Observable<String> m57349g(@Body RequestBody requestBody);

    @POST("api/an/gc/pn")
    /* renamed from: h */
    Observable<AccessiblityModel> m57348h(@Body RequestBody requestBody);

    @POST("api/an/gc/mt_ele")
    /* renamed from: i */
    Observable<String> m57347i(@Body RequestBody requestBody);

    @POST("api/check_session")
    /* renamed from: j */
    Observable<String> m57346j(@Body RequestBody requestBody);

    @POST("api/cut_down")
    /* renamed from: k */
    Observable<AdInfoModel> m57345k(@Body RequestBody requestBody);

    @POST("api/member")
    /* renamed from: l */
    Observable<String> m57344l(@Body RequestBody requestBody);

    @POST("api/time_limit")
    /* renamed from: m */
    Observable<String> m57343m(@Body RequestBody requestBody);

    @POST("api/push_ad_ecpm")
    /* renamed from: n */
    Observable<String> m57342n(@Body RequestBody requestBody);

    @POST("api/an/gc/save_settings")
    /* renamed from: o */
    Observable<String> m57341o(@Body RequestBody requestBody);

    @POST("api/limit_tips")
    /* renamed from: p */
    Observable<String> m57340p(@Body RequestBody requestBody);

    @POST("api/mobile_check")
    /* renamed from: q */
    Observable<String> m57339q(@Body RequestBody requestBody);

    @POST("api/plugin_check")
    /* renamed from: r */
    Observable<String> m57338r(@Body RequestBody requestBody);

    @POST("api/an/gc/jlj")
    /* renamed from: s */
    Observable<String> m57337s(@Body RequestBody requestBody);

    @POST("api/close_remind")
    /* renamed from: t */
    Observable<String> m57336t(@Body RequestBody requestBody);
}
