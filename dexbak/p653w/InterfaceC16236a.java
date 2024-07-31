package p653w;

import com.bxkj.base.user.LoginUser;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* compiled from: ApiService.java */
/* renamed from: w.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC16236a {

    /* renamed from: a */
    public static final String f47142a = LoginUser.getLoginUser().getServerUrl();

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/getMeaPerformanceFeedbackDetail")
    /* renamed from: A */
    Observable<Response<ResponseBody>> m189A(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appstu/userCheckUserNum")
    /* renamed from: A0 */
    Observable<Response<ResponseBody>> m188A0(@Field("userNum") String userNum, @Field("userName") String userName, @Field("userPhone") String userPhone);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/bluetoothDian")
    /* renamed from: A1 */
    Observable<Response<ResponseBody>> m187A1(@Field("teachingClockingin") String teachingClockingin, @Field("stuTeacherCurriculum") String stuTeacherCurriculum, @Field("weekNum") String weekNum, @Field("baddress") String bluetoothAddress, @Field("schoolId") String schoolId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/findStuLeaveCurriculumApplyById")
    /* renamed from: B */
    Observable<Response<ResponseBody>> m186B(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/updateStudentInfo")
    /* renamed from: B0 */
    Observable<Response<ResponseBody>> m185B0(@Field("userId") String userId, @Field("email") String email, @Field("nationId") Object nationId, @Field("sourceId") Object sourceId, @Field("address") String address, @Field("identityCard") String identityCard, @Field("suspId") String suspId, @Field("sysStuDetailId") String sysStuDetailId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/getStuCanInputExams")
    /* renamed from: B1 */
    Observable<Response<ResponseBody>> m184B1(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/applyMonitor")
    /* renamed from: C */
    Observable<Response<ResponseBody>> m183C(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/teacherCurriculum/chooseTeachingCurriculum")
    /* renamed from: C0 */
    Observable<Response<ResponseBody>> m182C0(@Field("stuid") String userId, @Field("parameter") Integer week);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list3")
    /* renamed from: C1 */
    Observable<Response<ResponseBody>> m181C1(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/evaluate/loadTeachingAssessExplain")
    /* renamed from: D */
    Observable<Response<ResponseBody>> m180D();

    @FormUrlEncoded
    @POST("app/getSysUserByThirdId")
    /* renamed from: D0 */
    Observable<Response<ResponseBody>> m179D0(@Field("type") String type, @Field("thirdId") String thirdId);

    @FormUrlEncoded
    @POST("app/actOrder/getCurriculum")
    /* renamed from: D1 */
    Observable<Response<ResponseBody>> m178D1(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/getScheduleView")
    /* renamed from: E */
    Observable<Response<ResponseBody>> m177E(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appsyshelp/appsyshelplist")
    /* renamed from: E0 */
    Observable<Response<ResponseBody>> m176E0(@Field("helpType") int helpType, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/announcementContent/appAnnouncementContentList")
    /* renamed from: E1 */
    Observable<Response<ResponseBody>> m175E1();

    @FormUrlEncoded
    @POST("app/stuPunchRecord/findPagerOk")
    /* renamed from: F */
    Observable<Response<ResponseBody>> m174F(@Field("userNum") String userNum, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/bindThirdInfo")
    /* renamed from: F0 */
    Observable<Response<ResponseBody>> m173F0(@Field("userId") String userId, @Field("type") String type, @Field("id") String id, @Field("nickName") String nickName, @Field("img") String img);

    @FormUrlEncoded
    @POST("app/competeSign/getAppCompetitionList")
    /* renamed from: F1 */
    Observable<Response<ResponseBody>> m172F1(@Field("pageSize") int pageSize, @Field("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("app/actOrder/del")
    /* renamed from: G */
    Observable<Response<ResponseBody>> m171G(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/competeSign/competeUserSignUp")
    /* renamed from: G0 */
    Observable<Response<ResponseBody>> m170G0(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/getStuGymClockRecords")
    /* renamed from: G1 */
    Observable<Response<ResponseBody>> m169G1(@Field("userId") String userId, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/face/checkUserByFace")
    /* renamed from: H */
    Observable<Response<ResponseBody>> m168H(@Field("base64Images") String base64Images, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/stulist")
    /* renamed from: H0 */
    Observable<Response<ResponseBody>> m167H0(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/dlbindThirdInfo")
    /* renamed from: H1 */
    Observable<Response<ResponseBody>> m166H1(@Field("userNum") String userNum, @Field("name") String name, @Field("type") String type, @Field("id") String id, @Field("nickName") String nickName, @Field("img") String img);

    @FormUrlEncoded
    @POST("app/bindUserPhoneByUserId")
    /* renamed from: I */
    Observable<Response<ResponseBody>> m165I(@Field("userId") String userId, @Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/applyMeaNonStuApply")
    /* renamed from: I0 */
    Observable<Response<ResponseBody>> m164I0(@Field("userId") String userId, @Field("address") String address, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs, @Field("meaStatusId") String meaStatusId, @Field("yearId") String yearId);

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/getMeaPerformanceFeedbackList")
    /* renamed from: J */
    Observable<Response<ResponseBody>> m163J(@Field("userId") String userId, @Field("meaScoreId") String meaScoreId);

    @POST("app/getStudentInfo")
    /* renamed from: J0 */
    Observable<Response<ResponseBody>> m162J0();

    @FormUrlEncoded
    @POST("app/validatePwdByUserId")
    /* renamed from: K */
    Observable<Response<ResponseBody>> m161K(@Field("userId") String userId, @Field("pwd") String password);

    @FormUrlEncoded
    @POST("app/appstu/checkInfo2RestPwd")
    /* renamed from: K0 */
    Observable<Response<ResponseBody>> m160K0(@Field("uname") String uname, @Field("cardId") String cardId, @Field("cnames") String cnames);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list")
    /* renamed from: L */
    Observable<Response<ResponseBody>> m159L(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/scheduleExamStu/getScheduleExamExplain")
    /* renamed from: L0 */
    Observable<Response<ResponseBody>> m158L0();

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/getMeaNonStuApplyRecordDetail")
    /* renamed from: M */
    Observable<Response<ResponseBody>> m157M(@Field("meaNonStuApplyId") String meaNonStuApplyId);

    @FormUrlEncoded
    @POST("app/stuTermPunchRecord/findList")
    /* renamed from: M0 */
    Observable<Response<ResponseBody>> m156M0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/getHealthStudentApplyDetail")
    /* renamed from: N */
    Observable<Response<ResponseBody>> m155N(@Field("id") String id);

    @POST("app/appMeaNonStuApply/loadSysYears")
    /* renamed from: N0 */
    Observable<Response<ResponseBody>> m154N0();

    @FormUrlEncoded
    @POST("punch/loadQualifiedPunchRecordWeekData")
    /* renamed from: O */
    Observable<Response<ResponseBody>> m153O(@Field("userId") String userId, @Field("termId") String termId);

    @FormUrlEncoded
    @POST("app/appnotice/appListNoticeData")
    /* renamed from: O0 */
    Observable<Response<ResponseBody>> m152O0(@Field("userId") String userId, @Field("identity") String identity, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/getUserInfoCountByTel")
    /* renamed from: P */
    Observable<Response<ResponseBody>> m151P(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/teaMeaSchedule/addScore")
    /* renamed from: P0 */
    Observable<Response<ResponseBody>> m150P0(@Field("userId") String userId, @Field("userNum") String userNum, @Field("examId") String examId, @Field("variable") String variable);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/viewMeaSpecification")
    /* renamed from: Q */
    Observable<Response<ResponseBody>> m149Q(@Field("type") String type, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/selstuTeacherCurriculum")
    /* renamed from: Q0 */
    Observable<Response<ResponseBody>> m148Q0(@Field("stuid") String userId, @Field("stuTermScoreid") String stuTermScoreid);

    @FormUrlEncoded
    @POST("app/measure/countStuMeaScore")
    /* renamed from: R */
    Observable<Response<ResponseBody>> m147R(@Field("sex") String sex, @Field("grade") String grade, @Field("height") String height, @Field("weight") String weight, @Field("vitalCapacity") String vitalCapacity, @Field("standingLongJump") String standingLongJump, @Field("sittingBodyFlexion") String sittingBodyFlexion, @Field("meters50") String meters50, @Field("meters") String meters, @Field("pullOrSit") String pullOrSit);

    @FormUrlEncoded
    @POST("adminApp/gaugePoint/gainGaugePoint")
    /* renamed from: R0 */
    Observable<Response<ResponseBody>> m146R0(@Field("uid") String userId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/findStuLeaveCurriculumApplyByUserId")
    /* renamed from: S */
    Observable<Response<ResponseBody>> m145S(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId);

    @POST("app/onlineExam/explainTeacherCurriculumList")
    /* renamed from: S0 */
    Observable<Response<ResponseBody>> m144S0();

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/applyMeaPerformanceFeedback")
    /* renamed from: T */
    Observable<Response<ResponseBody>> m143T(@Field("userId") String userId, @Field("meaScoreId") String meaScoreId, @Field("examId") String examId, @Field("rawScores") String score, @Field("complaintResults") String complaintResults, @Field("userPhone") String userPhone, @Field("applyReason") String applyReason);

    @FormUrlEncoded
    @POST("app/onlineExam/getExamOnlineStuPaperDetail")
    /* renamed from: T0 */
    Observable<Response<ResponseBody>> m142T0(@Field("stuId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/scheduleExamStuCancel")
    /* renamed from: U */
    Observable<Response<ResponseBody>> m141U(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appstu/getCheckInfo2RestPwd")
    /* renamed from: U0 */
    Observable<Response<ResponseBody>> m140U0(@Field("uname") String uname);

    @FormUrlEncoded
    @POST("app/actOrder/update")
    /* renamed from: V */
    Observable<Response<ResponseBody>> m139V(@Field("uid") String studentId, @Field("id") String id, @Field("curriculum") String curriculum);

    @FormUrlEncoded
    @POST("app/appnotice/noReadNotice")
    /* renamed from: V0 */
    Observable<Response<ResponseBody>> m138V0(@Field("userId") String userId, @Field("identity") String identity);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/cancelMeaRecordCtl")
    /* renamed from: W */
    Observable<Response<ResponseBody>> m137W(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/learnWork/saveWorkVoteOrWorkShare")
    /* renamed from: W0 */
    Observable<Response<ResponseBody>> m136W0(@Field("learnWorkId") String learnSelectionWorkId, @Field("workType") int workType, @Field("workStatus") int workStatus);

    @FormUrlEncoded
    @POST("app/evaluate/stuHasEvaluatedSuccess")
    /* renamed from: X */
    Observable<Response<ResponseBody>> m135X(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("stuId") String stuId, @Field("onlineType") int onlineType);

    @GET("app/config/getCustomerServiceConfig")
    /* renamed from: X0 */
    Observable<Response<ResponseBody>> m134X0();

    @FormUrlEncoded
    @POST("app/stuTermScore/isLookScoreFX")
    /* renamed from: Y */
    Observable<Response<ResponseBody>> m133Y(@Field("stuTermScoreid") String stuTermScoreid);

    @FormUrlEncoded
    @POST("app/evaluate/checkUserAssessTime1")
    /* renamed from: Y0 */
    Observable<Response<ResponseBody>> m132Y0(@Field("userId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list")
    /* renamed from: Z */
    Observable<Response<ResponseBody>> m131Z(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/learnWork/getLearnWorkdetail")
    /* renamed from: Z0 */
    Observable<Response<ResponseBody>> m130Z0(@Field("learnWorkId") String learnWorkId);

    @FormUrlEncoded
    @POST("app/fieldPlan/fieldPlanAppointedList")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m129a(@Field("userId") String userId, @Field("type") int type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/competeSign/cancelSignUpItem")
    /* renamed from: a0 */
    Observable<Response<ResponseBody>> m128a0(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/learnWork/getLearnWorkPagerList")
    /* renamed from: a1 */
    Observable<Response<ResponseBody>> m127a1(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize, @Field("learnQuestionName") String learnQuestionName);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteItems")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m126b(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/scheduleExam/stuScheduleExamList")
    /* renamed from: b0 */
    Observable<Response<ResponseBody>> m125b0(@Field("stuid") String stuid);

    @FormUrlEncoded
    @POST("app/actOrder/doList")
    /* renamed from: b1 */
    Observable<Response<ResponseBody>> m124b1(@Field("uid") String studentId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/cancelSignUpItem")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m123c(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/chooseTeachingCurriculum")
    /* renamed from: c0 */
    Observable<Response<ResponseBody>> m122c0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuPunchRecord/findPager")
    /* renamed from: c1 */
    Observable<Response<ResponseBody>> m121c1(@Field("userNum") String userNum, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionList")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m120d(@Field("competitionId") String competitionId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/onlineExam/explainList")
    /* renamed from: d0 */
    Observable<Response<ResponseBody>> m119d0(@Field("stuId") String stuId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/onlineExam/deleteStuPaper")
    /* renamed from: d1 */
    Observable<Response<ResponseBody>> m118d1(@Field("stuId") String stuId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompeteItems")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m117e(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/evaluate/checkUserAssessTime")
    /* renamed from: e0 */
    Observable<Response<ResponseBody>> m116e0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/addStuLeaveCurriculumApply")
    /* renamed from: e1 */
    Observable<Response<ResponseBody>> m115e1(@Field("userId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("weekNum") Integer weekNum, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs);

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m114f(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("detailId") String detailId, @Field("status") String status);

    @POST("punch/findAllTermList")
    /* renamed from: f0 */
    Observable<Response<ResponseBody>> m113f0();

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/chooseTeachingCurriculum")
    /* renamed from: f1 */
    Observable<Response<ResponseBody>> m112f1(@Field("stuid") String userId, @Field("teaCurriculumid") String teaCurriculumid);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompetitionList")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m111g(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/onlineExam/loadExamExplain")
    /* renamed from: g0 */
    Observable<Response<ResponseBody>> m110g0(@Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTeachingCurriculum")
    /* renamed from: g1 */
    Observable<Response<ResponseBody>> m109g1(@Field("userId") String userId, @Field("timeId") String timeId, @Field("parameter") String parameter, @Field("teachingId") String teachingId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/competeUserSignUp")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m108h(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/onlineExam/stuExamOnlineList")
    /* renamed from: h0 */
    Observable<Response<ResponseBody>> m107h0(@Field("userId") String userId, @Field("onlineType") int onlineType);

    @POST("app/onlineExam/loadExamContentDataYD")
    /* renamed from: h1 */
    Observable<Response<ResponseBody>> m106h1();

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionDetail")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m105i(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/callStuIdentify/userAddCallStuIdentify")
    /* renamed from: i0 */
    Observable<Response<ResponseBody>> m104i0(@Field("uid") String userId);

    @FormUrlEncoded
    @POST("app/field/getChilFieldByPid")
    /* renamed from: i1 */
    Observable<Response<ResponseBody>> m103i1(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/isMonitor")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m102j(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTeaSysUser")
    /* renamed from: j0 */
    Observable<Response<ResponseBody>> m101j0(@Field("teacherId") String teacherId);

    @POST("app/appHealthStudentApply/getHealthStudentStatus")
    /* renamed from: j1 */
    Observable<Response<ResponseBody>> m100j1();

    @POST("app/appMeaNonStuApply/loadMeaStatus")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m99k();

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/getMeaNonStuApplyRecords")
    /* renamed from: k0 */
    Observable<Response<ResponseBody>> m98k0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/actOrder/addOrder")
    /* renamed from: k1 */
    Observable<Response<ResponseBody>> m97k1(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/addStuGymClockRecord")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m96l(@Field("operatorID") String operatorID, @Field("stuCardNum") String stuCardNum, @Field("type") String type);

    @FormUrlEncoded
    @POST("app/getUserInfoByTel")
    /* renamed from: l0 */
    Observable<Response<ResponseBody>> m95l0(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/stuIgnIn")
    /* renamed from: l1 */
    Observable<Response<ResponseBody>> m94l1(@Field("stuTeacherCurriculum") String stuTeacherCurriculum);

    @FormUrlEncoded
    @POST("app/competeSign/getAppItemByUserAndCompetitionId")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m93m(@Field("competionId") String competionId, @Field("userId") String userId, @Field("pageSize") int pageSize, @Field("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTime")
    /* renamed from: m0 */
    Observable<Response<ResponseBody>> m92m0(@Field("userId") String userId, @Field("teachingId") String teachingId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list2")
    /* renamed from: m1 */
    Observable<Response<ResponseBody>> m91m1(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/getStuAllGymClockRecords")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m90n(@Field("userId") String userId, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/modPasswd")
    /* renamed from: n0 */
    Observable<Response<ResponseBody>> m89n0(@Field("userId") String userId, @Field("originalpwd") String originalpwd, @Field("newpwd") String newpwd);

    @POST("app/getSources")
    /* renamed from: n1 */
    Observable<Response<ResponseBody>> m88n1();

    @FormUrlEncoded
    @POST("app/actOrder/pagerActOrder")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m87o(@Field("uid") String studentId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/scheduleExamStuCtlStulist")
    /* renamed from: o0 */
    Observable<Response<ResponseBody>> m86o0(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/changeUserPassword")
    /* renamed from: o1 */
    Observable<Response<ResponseBody>> m85o1(@Field("userNum") String userNum, @Field("pwd") String pwd);

    @POST("app/learnWork/getLearnWorkProject")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m84p();

    @FormUrlEncoded
    @POST("app/ispwdmod")
    /* renamed from: p0 */
    Observable<Response<ResponseBody>> m83p0(@Field("userNum") String userNum);

    @POST("app/getNations")
    /* renamed from: p1 */
    Observable<Response<ResponseBody>> m82p1();

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/getHealthStudentApplyList")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m81q(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTermScore/uidSelect")
    /* renamed from: q0 */
    Observable<Response<ResponseBody>> m80q0(@Field("uid") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/loadStuTeacherCurriculumData")
    /* renamed from: q1 */
    Observable<Response<ResponseBody>> m79q1(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/applyHealthStudentApply")
    /* renamed from: r */
    Observable<Response<ResponseBody>> m78r(@Field("userId") String userId, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs, @Field("type") String type);

    @FormUrlEncoded
    @POST("app/evaluate/saveAssessPaper")
    /* renamed from: r0 */
    Observable<Response<ResponseBody>> m77r0(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("stuId") String stuId, @Field("data") String data);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/cancelMeaNonStuApply")
    /* renamed from: r1 */
    Observable<Response<ResponseBody>> m76r1(@Field("id") String id);

    @FormUrlEncoded
    @POST("punch/loadPunchRecordWeekData1")
    /* renamed from: s */
    Observable<Response<ResponseBody>> m75s(@Field("userId") String userId, @Field("termId") String termId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appstu/uploadGatherPhotoBase64")
    /* renamed from: s0 */
    Observable<Response<ResponseBody>> m74s0(@Field("userId") String userId, @Field("base64") String base64);

    @FormUrlEncoded
    @POST("punch/getTermWeekNum")
    /* renamed from: s1 */
    Observable<Response<ResponseBody>> m73s1(@Field("termId") String termId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/getTermTotalScore")
    /* renamed from: t */
    Observable<Response<ResponseBody>> m72t(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/evaluate/loadAssessData")
    /* renamed from: t0 */
    Observable<Response<ResponseBody>> m71t0(@Field("stuId") String stuId);

    @FormUrlEncoded
    @POST("app/onlineExam/saveExamPaper")
    /* renamed from: t1 */
    Observable<Response<ResponseBody>> m70t1(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("userId") String stuId, @Field("radio") String data, @Field("check") String check, @Field("quest") String quest, @Field("startTime") String startTime, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/onlineExam/loadExamContentData")
    /* renamed from: u */
    Observable<Response<ResponseBody>> m69u(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("teachingCurrIds") String teachingCurrIds, @Field("userId") String userId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/evaluate/stuAssessTeaList")
    /* renamed from: u0 */
    Observable<Response<ResponseBody>> m68u0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/fieldPlan/getRecordCount")
    /* renamed from: u1 */
    Observable<Response<ResponseBody>> m67u1(@Field("userId") String userId, @Field("appointType") int appointType, @Field("date") String date);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showCurriculums")
    /* renamed from: v */
    Observable<Response<ResponseBody>> m66v(@Field("userId") String userId, @Field("timeId") String timeId);

    @FormUrlEncoded
    @POST("app/measure/getStuScoreDetail")
    /* renamed from: v0 */
    Observable<Response<ResponseBody>> m65v0(@Field("meaScoreId") String meaScoreId);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/toadd")
    /* renamed from: v1 */
    Observable<Response<ResponseBody>> m64v1(@Field("stuId") String stuId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/runingFace/isUpFaces")
    /* renamed from: w */
    Observable<Response<ResponseBody>> m63w(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/relieveBindThirdInfo")
    /* renamed from: w0 */
    Observable<Response<ResponseBody>> m62w0(@Field("type") String type, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/deleteStuTeaCurr")
    /* renamed from: w1 */
    Observable<Response<ResponseBody>> m61w1(@Field("stuTeacherCurriculumid") String stuTeacherCurriculumid);

    @FormUrlEncoded
    @POST("app/stuTermScore/listcallStu")
    /* renamed from: x */
    Observable<Response<ResponseBody>> m60x(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/doadd")
    /* renamed from: x0 */
    Observable<Response<ResponseBody>> m59x0(@Field("id") String id, @Field("userId") String userId);

    @POST("app/runingFace/registerFaceApi")
    @Multipart
    /* renamed from: x1 */
    Observable<Response<ResponseBody>> m58x1(@Part("userId") RequestBody userId, @Part("file\"; filename=\"img.jpg ") RequestBody file);

    @FormUrlEncoded
    @POST("app/actOrder/actOrderListView")
    /* renamed from: y */
    Observable<Response<ResponseBody>> m57y(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/config/getUploadMethod")
    /* renamed from: y0 */
    Observable<Response<ResponseBody>> m56y0(@Field("method") String method);

    @GET("app/appStuMeaSchedule/getStuMeaInfo")
    /* renamed from: y1 */
    Observable<Response<ResponseBody>> m55y1();

    @FormUrlEncoded
    @POST("app/appstu/login")
    /* renamed from: z */
    Observable<Response<ResponseBody>> m54z(@Field("uname") String username, @Field("pwd") String password);

    @FormUrlEncoded
    @POST("app/onlineExam/isCourseSelection")
    /* renamed from: z0 */
    Observable<Response<ResponseBody>> m53z0(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/measure/getStuTotalScore")
    /* renamed from: z1 */
    Observable<Response<ResponseBody>> m52z1(@Field("userId") String userId);
}
