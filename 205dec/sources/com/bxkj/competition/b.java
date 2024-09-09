package com.bxkj.competition;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CompeApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface b {
    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteItems")
    e<Response<ResponseBody>> b(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/cancelSignUpItem")
    e<Response<ResponseBody>> c(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionList")
    e<Response<ResponseBody>> d(@Field("competitionId") String competitionId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompeteItems")
    e<Response<ResponseBody>> e(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/competeItemSignin")
    e<Response<ResponseBody>> f(@Field("itemId") String itemId, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompetitionList")
    e<Response<ResponseBody>> g(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/competeUserSignUp")
    e<Response<ResponseBody>> h(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionDetail")
    e<Response<ResponseBody>> i(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteAllItems")
    e<Response<ResponseBody>> j(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getMaxGroupNumByScheduleId")
    e<Response<ResponseBody>> k(@Field("scheduleId") String scheduleId);

    @FormUrlEncoded
    @POST("app/appCompetition/loadRollCallData")
    e<Response<ResponseBody>> l(@Field("scheduleId") String scheduleId, @Field("groupNum") int groupNum, @Field("progressMode") String progressMode);

    @FormUrlEncoded
    @POST("app/appCompetition/competeRollCallUpdate")
    e<Response<ResponseBody>> m(@Field("userId") String userId, @Field("rollCallJson") String rollCallJson);

    @FormUrlEncoded
    @POST("app/appCompetition/loadStuScoreData")
    e<Response<ResponseBody>> n(@Field("scheduleId") String scheduleId, @Field("groupNum") int groupNum);

    @FormUrlEncoded
    @POST("app/appCompetition/getGroupListByCompetitionId")
    e<Response<ResponseBody>> o(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getItemListByGroupId")
    e<Response<ResponseBody>> p(@Field("groupId") String groupId);

    @FormUrlEncoded
    @POST("app/appCompetition/getCompeteItemAllPlayers")
    e<Response<ResponseBody>> q(@Field("competeItemId") String competeItemId, @Field("status") int status, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/loadUserCompeteLetterData")
    e<Response<ResponseBody>> r(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/competeAliPay/appPay")
    e<Response<ResponseBody>> s(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("itemIds") String itemIds, @Field("insuranceFee") double insuranceFee, @Field("competitionFee") double competitionFee, @Field("totalPrice") double totalPrice, @Field("payPrize") double payPrize);

    @FormUrlEncoded
    @POST("app/appCompetition/loadCompeteScheduleData")
    e<Response<ResponseBody>> t(@Field("competitionId") String competitionId, @Field("groupId") Object groupId, @Field("itemId") Object itemId, @Field("dateId") Object dateId);

    @FormUrlEncoded
    @POST("app/competeWXPay/appPay")
    e<Response<ResponseBody>> u(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("itemIds") String itemIds, @Field("insuranceFee") double insuranceFee, @Field("competitionFee") double competitionFee, @Field("totalPrice") double totalPrice, @Field("payPrize") double payPrize);

    @FormUrlEncoded
    @POST("app/appCompetition/getDateListByCompetitionId")
    e<Response<ResponseBody>> v(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getUserEntryCard")
    e<Response<ResponseBody>> w(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/publishCompeteLetter")
    e<Response<ResponseBody>> x(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("content") String content);
}
