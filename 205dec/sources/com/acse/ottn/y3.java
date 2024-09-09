package com.acse.ottn;

import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdInfoModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface y3 {
    @POST("api/check_session")
    Observable<String> a(@Body RequestBody requestBody);

    @POST("api/mobile_app")
    Observable<String> b(@Body RequestBody requestBody);

    @POST("api/cut_down")
    Observable<AdInfoModel> c(@Body RequestBody requestBody);

    @POST("api/report")
    Observable<String> d(@Body RequestBody requestBody);

    @POST("api/member")
    Observable<String> e(@Body RequestBody requestBody);

    @POST("api/an/gc/scroll")
    Observable<AccessiblityModel> f(@Body RequestBody requestBody);

    @POST("api/time_limit")
    Observable<String> g(@Body RequestBody requestBody);

    @POST("api/push_ad_ecpm")
    Observable<String> h(@Body RequestBody requestBody);

    @POST("api/an/gc/save_settings")
    Observable<String> i(@Body RequestBody requestBody);

    @POST("api/data_check")
    Observable<String> j(@Body RequestBody requestBody);

    @POST("api/clear_ad_time")
    Observable<String> k(@Body RequestBody requestBody);

    @POST("api/limit_tips")
    Observable<String> l(@Body RequestBody requestBody);

    @POST("api/close_plugin")
    Observable<String> m(@Body RequestBody requestBody);

    @POST("api/mobile_check")
    Observable<String> n(@Body RequestBody requestBody);

    @POST("api/plugin_check")
    Observable<String> o(@Body RequestBody requestBody);

    @POST("api/plugin_change")
    Observable<String> p(@Body RequestBody requestBody);

    @POST("api/an/gc/pn")
    Observable<AccessiblityModel> q(@Body RequestBody requestBody);

    @POST("api/an/gc/jlj")
    Observable<String> r(@Body RequestBody requestBody);

    @POST("api/close_remind")
    Observable<String> s(@Body RequestBody requestBody);

    @POST("api/an/gc/mt_ele")
    Observable<String> t(@Body RequestBody requestBody);
}
