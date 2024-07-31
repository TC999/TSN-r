package com.bxkj.competition;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: com.bxkj.competition.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface CompeApiService {
    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteItems")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m43455b(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/cancelSignUpItem")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m43454c(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionList")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m43453d(@Field("competitionId") String competitionId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompeteItems")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m43452e(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/competeItemSignin")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m43451f(@Field("itemId") String itemId, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompetitionList")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m43450g(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/competeUserSignUp")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m43449h(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionDetail")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m43448i(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteAllItems")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m43447j(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getMaxGroupNumByScheduleId")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m43446k(@Field("scheduleId") String scheduleId);

    @FormUrlEncoded
    @POST("app/appCompetition/loadRollCallData")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m43445l(@Field("scheduleId") String scheduleId, @Field("groupNum") int groupNum, @Field("progressMode") String progressMode);

    @FormUrlEncoded
    @POST("app/appCompetition/competeRollCallUpdate")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m43444m(@Field("userId") String userId, @Field("rollCallJson") String rollCallJson);

    @FormUrlEncoded
    @POST("app/appCompetition/loadStuScoreData")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m43443n(@Field("scheduleId") String scheduleId, @Field("groupNum") int groupNum);

    @FormUrlEncoded
    @POST("app/appCompetition/getGroupListByCompetitionId")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m43442o(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getItemListByGroupId")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m43441p(@Field("groupId") String groupId);

    @FormUrlEncoded
    @POST("app/appCompetition/getCompeteItemAllPlayers")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m43440q(@Field("competeItemId") String competeItemId, @Field("status") int status, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/loadUserCompeteLetterData")
    /* renamed from: r */
    Observable<Response<ResponseBody>> m43439r(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/competeAliPay/appPay")
    /* renamed from: s */
    Observable<Response<ResponseBody>> m43438s(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("itemIds") String itemIds, @Field("insuranceFee") double insuranceFee, @Field("competitionFee") double competitionFee, @Field("totalPrice") double totalPrice, @Field("payPrize") double payPrize);

    @FormUrlEncoded
    @POST("app/appCompetition/loadCompeteScheduleData")
    /* renamed from: t */
    Observable<Response<ResponseBody>> m43437t(@Field("competitionId") String competitionId, @Field("groupId") Object groupId, @Field("itemId") Object itemId, @Field("dateId") Object dateId);

    @FormUrlEncoded
    @POST("app/competeWXPay/appPay")
    /* renamed from: u */
    Observable<Response<ResponseBody>> m43436u(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("itemIds") String itemIds, @Field("insuranceFee") double insuranceFee, @Field("competitionFee") double competitionFee, @Field("totalPrice") double totalPrice, @Field("payPrize") double payPrize);

    @FormUrlEncoded
    @POST("app/appCompetition/getDateListByCompetitionId")
    /* renamed from: v */
    Observable<Response<ResponseBody>> m43435v(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getUserEntryCard")
    /* renamed from: w */
    Observable<Response<ResponseBody>> m43434w(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/publishCompeteLetter")
    /* renamed from: x */
    Observable<Response<ResponseBody>> m43433x(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("content") String content);
}
