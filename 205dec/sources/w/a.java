package w;

import com.bxkj.base.user.LoginUser;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f64432a = LoginUser.getLoginUser().getServerUrl();

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/getMeaPerformanceFeedbackDetail")
    e<Response<ResponseBody>> A(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appstu/userCheckUserNum")
    e<Response<ResponseBody>> A0(@Field("userNum") String userNum, @Field("userName") String userName, @Field("userPhone") String userPhone);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/bluetoothDian")
    e<Response<ResponseBody>> A1(@Field("teachingClockingin") String teachingClockingin, @Field("stuTeacherCurriculum") String stuTeacherCurriculum, @Field("weekNum") String weekNum, @Field("baddress") String bluetoothAddress, @Field("schoolId") String schoolId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/findStuLeaveCurriculumApplyById")
    e<Response<ResponseBody>> B(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/updateStudentInfo")
    e<Response<ResponseBody>> B0(@Field("userId") String userId, @Field("email") String email, @Field("nationId") Object nationId, @Field("sourceId") Object sourceId, @Field("address") String address, @Field("identityCard") String identityCard, @Field("suspId") String suspId, @Field("sysStuDetailId") String sysStuDetailId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/getStuCanInputExams")
    e<Response<ResponseBody>> B1(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/applyMonitor")
    e<Response<ResponseBody>> C(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/teacherCurriculum/chooseTeachingCurriculum")
    e<Response<ResponseBody>> C0(@Field("stuid") String userId, @Field("parameter") Integer week);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list3")
    e<Response<ResponseBody>> C1(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/evaluate/loadTeachingAssessExplain")
    e<Response<ResponseBody>> D();

    @FormUrlEncoded
    @POST("app/getSysUserByThirdId")
    e<Response<ResponseBody>> D0(@Field("type") String type, @Field("thirdId") String thirdId);

    @FormUrlEncoded
    @POST("app/actOrder/getCurriculum")
    e<Response<ResponseBody>> D1(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/getScheduleView")
    e<Response<ResponseBody>> E(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appsyshelp/appsyshelplist")
    e<Response<ResponseBody>> E0(@Field("helpType") int helpType, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/announcementContent/appAnnouncementContentList")
    e<Response<ResponseBody>> E1();

    @FormUrlEncoded
    @POST("app/stuPunchRecord/findPagerOk")
    e<Response<ResponseBody>> F(@Field("userNum") String userNum, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/bindThirdInfo")
    e<Response<ResponseBody>> F0(@Field("userId") String userId, @Field("type") String type, @Field("id") String id, @Field("nickName") String nickName, @Field("img") String img);

    @FormUrlEncoded
    @POST("app/competeSign/getAppCompetitionList")
    e<Response<ResponseBody>> F1(@Field("pageSize") int pageSize, @Field("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("app/actOrder/del")
    e<Response<ResponseBody>> G(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/competeSign/competeUserSignUp")
    e<Response<ResponseBody>> G0(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/getStuGymClockRecords")
    e<Response<ResponseBody>> G1(@Field("userId") String userId, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/face/checkUserByFace")
    e<Response<ResponseBody>> H(@Field("base64Images") String base64Images, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/stulist")
    e<Response<ResponseBody>> H0(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/dlbindThirdInfo")
    e<Response<ResponseBody>> H1(@Field("userNum") String userNum, @Field("name") String name, @Field("type") String type, @Field("id") String id, @Field("nickName") String nickName, @Field("img") String img);

    @FormUrlEncoded
    @POST("app/bindUserPhoneByUserId")
    e<Response<ResponseBody>> I(@Field("userId") String userId, @Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/applyMeaNonStuApply")
    e<Response<ResponseBody>> I0(@Field("userId") String userId, @Field("address") String address, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs, @Field("meaStatusId") String meaStatusId, @Field("yearId") String yearId);

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/getMeaPerformanceFeedbackList")
    e<Response<ResponseBody>> J(@Field("userId") String userId, @Field("meaScoreId") String meaScoreId);

    @POST("app/getStudentInfo")
    e<Response<ResponseBody>> J0();

    @FormUrlEncoded
    @POST("app/validatePwdByUserId")
    e<Response<ResponseBody>> K(@Field("userId") String userId, @Field("pwd") String password);

    @FormUrlEncoded
    @POST("app/appstu/checkInfo2RestPwd")
    e<Response<ResponseBody>> K0(@Field("uname") String uname, @Field("cardId") String cardId, @Field("cnames") String cnames);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list")
    e<Response<ResponseBody>> L(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/scheduleExamStu/getScheduleExamExplain")
    e<Response<ResponseBody>> L0();

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/getMeaNonStuApplyRecordDetail")
    e<Response<ResponseBody>> M(@Field("meaNonStuApplyId") String meaNonStuApplyId);

    @FormUrlEncoded
    @POST("app/stuTermPunchRecord/findList")
    e<Response<ResponseBody>> M0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/getHealthStudentApplyDetail")
    e<Response<ResponseBody>> N(@Field("id") String id);

    @POST("app/appMeaNonStuApply/loadSysYears")
    e<Response<ResponseBody>> N0();

    @FormUrlEncoded
    @POST("punch/loadQualifiedPunchRecordWeekData")
    e<Response<ResponseBody>> O(@Field("userId") String userId, @Field("termId") String termId);

    @FormUrlEncoded
    @POST("app/appnotice/appListNoticeData")
    e<Response<ResponseBody>> O0(@Field("userId") String userId, @Field("identity") String identity, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/getUserInfoCountByTel")
    e<Response<ResponseBody>> P(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/teaMeaSchedule/addScore")
    e<Response<ResponseBody>> P0(@Field("userId") String userId, @Field("userNum") String userNum, @Field("examId") String examId, @Field("variable") String variable);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/viewMeaSpecification")
    e<Response<ResponseBody>> Q(@Field("type") String type, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/selstuTeacherCurriculum")
    e<Response<ResponseBody>> Q0(@Field("stuid") String userId, @Field("stuTermScoreid") String stuTermScoreid);

    @FormUrlEncoded
    @POST("app/measure/countStuMeaScore")
    e<Response<ResponseBody>> R(@Field("sex") String sex, @Field("grade") String grade, @Field("height") String height, @Field("weight") String weight, @Field("vitalCapacity") String vitalCapacity, @Field("standingLongJump") String standingLongJump, @Field("sittingBodyFlexion") String sittingBodyFlexion, @Field("meters50") String meters50, @Field("meters") String meters, @Field("pullOrSit") String pullOrSit);

    @FormUrlEncoded
    @POST("adminApp/gaugePoint/gainGaugePoint")
    e<Response<ResponseBody>> R0(@Field("uid") String userId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/findStuLeaveCurriculumApplyByUserId")
    e<Response<ResponseBody>> S(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId);

    @POST("app/onlineExam/explainTeacherCurriculumList")
    e<Response<ResponseBody>> S0();

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/applyMeaPerformanceFeedback")
    e<Response<ResponseBody>> T(@Field("userId") String userId, @Field("meaScoreId") String meaScoreId, @Field("examId") String examId, @Field("rawScores") String score, @Field("complaintResults") String complaintResults, @Field("userPhone") String userPhone, @Field("applyReason") String applyReason);

    @FormUrlEncoded
    @POST("app/onlineExam/getExamOnlineStuPaperDetail")
    e<Response<ResponseBody>> T0(@Field("stuId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/scheduleExamStuCancel")
    e<Response<ResponseBody>> U(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appstu/getCheckInfo2RestPwd")
    e<Response<ResponseBody>> U0(@Field("uname") String uname);

    @FormUrlEncoded
    @POST("app/actOrder/update")
    e<Response<ResponseBody>> V(@Field("uid") String studentId, @Field("id") String id, @Field("curriculum") String curriculum);

    @FormUrlEncoded
    @POST("app/appnotice/noReadNotice")
    e<Response<ResponseBody>> V0(@Field("userId") String userId, @Field("identity") String identity);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/cancelMeaRecordCtl")
    e<Response<ResponseBody>> W(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/learnWork/saveWorkVoteOrWorkShare")
    e<Response<ResponseBody>> W0(@Field("learnWorkId") String learnSelectionWorkId, @Field("workType") int workType, @Field("workStatus") int workStatus);

    @FormUrlEncoded
    @POST("app/evaluate/stuHasEvaluatedSuccess")
    e<Response<ResponseBody>> X(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("stuId") String stuId, @Field("onlineType") int onlineType);

    @GET("app/config/getCustomerServiceConfig")
    e<Response<ResponseBody>> X0();

    @FormUrlEncoded
    @POST("app/stuTermScore/isLookScoreFX")
    e<Response<ResponseBody>> Y(@Field("stuTermScoreid") String stuTermScoreid);

    @FormUrlEncoded
    @POST("app/evaluate/checkUserAssessTime1")
    e<Response<ResponseBody>> Y0(@Field("userId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list")
    e<Response<ResponseBody>> Z(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/learnWork/getLearnWorkdetail")
    e<Response<ResponseBody>> Z0(@Field("learnWorkId") String learnWorkId);

    @FormUrlEncoded
    @POST("app/fieldPlan/fieldPlanAppointedList")
    e<Response<ResponseBody>> a(@Field("userId") String userId, @Field("type") int type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/competeSign/cancelSignUpItem")
    e<Response<ResponseBody>> a0(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/learnWork/getLearnWorkPagerList")
    e<Response<ResponseBody>> a1(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize, @Field("learnQuestionName") String learnQuestionName);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteItems")
    e<Response<ResponseBody>> b(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/scheduleExam/stuScheduleExamList")
    e<Response<ResponseBody>> b0(@Field("stuid") String stuid);

    @FormUrlEncoded
    @POST("app/actOrder/doList")
    e<Response<ResponseBody>> b1(@Field("uid") String studentId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/cancelSignUpItem")
    e<Response<ResponseBody>> c(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/chooseTeachingCurriculum")
    e<Response<ResponseBody>> c0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuPunchRecord/findPager")
    e<Response<ResponseBody>> c1(@Field("userNum") String userNum, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionList")
    e<Response<ResponseBody>> d(@Field("competitionId") String competitionId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/onlineExam/explainList")
    e<Response<ResponseBody>> d0(@Field("stuId") String stuId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/onlineExam/deleteStuPaper")
    e<Response<ResponseBody>> d1(@Field("stuId") String stuId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompeteItems")
    e<Response<ResponseBody>> e(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/evaluate/checkUserAssessTime")
    e<Response<ResponseBody>> e0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/addStuLeaveCurriculumApply")
    e<Response<ResponseBody>> e1(@Field("userId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("weekNum") Integer weekNum, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs);

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    e<Response<ResponseBody>> f(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("detailId") String detailId, @Field("status") String status);

    @POST("punch/findAllTermList")
    e<Response<ResponseBody>> f0();

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/chooseTeachingCurriculum")
    e<Response<ResponseBody>> f1(@Field("stuid") String userId, @Field("teaCurriculumid") String teaCurriculumid);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompetitionList")
    e<Response<ResponseBody>> g(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/onlineExam/loadExamExplain")
    e<Response<ResponseBody>> g0(@Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTeachingCurriculum")
    e<Response<ResponseBody>> g1(@Field("userId") String userId, @Field("timeId") String timeId, @Field("parameter") String parameter, @Field("teachingId") String teachingId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/competeUserSignUp")
    e<Response<ResponseBody>> h(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/onlineExam/stuExamOnlineList")
    e<Response<ResponseBody>> h0(@Field("userId") String userId, @Field("onlineType") int onlineType);

    @POST("app/onlineExam/loadExamContentDataYD")
    e<Response<ResponseBody>> h1();

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionDetail")
    e<Response<ResponseBody>> i(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/callStuIdentify/userAddCallStuIdentify")
    e<Response<ResponseBody>> i0(@Field("uid") String userId);

    @FormUrlEncoded
    @POST("app/field/getChilFieldByPid")
    e<Response<ResponseBody>> i1(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/isMonitor")
    e<Response<ResponseBody>> j(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTeaSysUser")
    e<Response<ResponseBody>> j0(@Field("teacherId") String teacherId);

    @POST("app/appHealthStudentApply/getHealthStudentStatus")
    e<Response<ResponseBody>> j1();

    @POST("app/appMeaNonStuApply/loadMeaStatus")
    e<Response<ResponseBody>> k();

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/getMeaNonStuApplyRecords")
    e<Response<ResponseBody>> k0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/actOrder/addOrder")
    e<Response<ResponseBody>> k1(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/addStuGymClockRecord")
    e<Response<ResponseBody>> l(@Field("operatorID") String operatorID, @Field("stuCardNum") String stuCardNum, @Field("type") String type);

    @FormUrlEncoded
    @POST("app/getUserInfoByTel")
    e<Response<ResponseBody>> l0(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/stuIgnIn")
    e<Response<ResponseBody>> l1(@Field("stuTeacherCurriculum") String stuTeacherCurriculum);

    @FormUrlEncoded
    @POST("app/competeSign/getAppItemByUserAndCompetitionId")
    e<Response<ResponseBody>> m(@Field("competionId") String competionId, @Field("userId") String userId, @Field("pageSize") int pageSize, @Field("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTime")
    e<Response<ResponseBody>> m0(@Field("userId") String userId, @Field("teachingId") String teachingId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list2")
    e<Response<ResponseBody>> m1(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/getStuAllGymClockRecords")
    e<Response<ResponseBody>> n(@Field("userId") String userId, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/modPasswd")
    e<Response<ResponseBody>> n0(@Field("userId") String userId, @Field("originalpwd") String originalpwd, @Field("newpwd") String newpwd);

    @POST("app/getSources")
    e<Response<ResponseBody>> n1();

    @FormUrlEncoded
    @POST("app/actOrder/pagerActOrder")
    e<Response<ResponseBody>> o(@Field("uid") String studentId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/scheduleExamStuCtlStulist")
    e<Response<ResponseBody>> o0(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/changeUserPassword")
    e<Response<ResponseBody>> o1(@Field("userNum") String userNum, @Field("pwd") String pwd);

    @POST("app/learnWork/getLearnWorkProject")
    e<Response<ResponseBody>> p();

    @FormUrlEncoded
    @POST("app/ispwdmod")
    e<Response<ResponseBody>> p0(@Field("userNum") String userNum);

    @POST("app/getNations")
    e<Response<ResponseBody>> p1();

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/getHealthStudentApplyList")
    e<Response<ResponseBody>> q(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTermScore/uidSelect")
    e<Response<ResponseBody>> q0(@Field("uid") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/loadStuTeacherCurriculumData")
    e<Response<ResponseBody>> q1(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/applyHealthStudentApply")
    e<Response<ResponseBody>> r(@Field("userId") String userId, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs, @Field("type") String type);

    @FormUrlEncoded
    @POST("app/evaluate/saveAssessPaper")
    e<Response<ResponseBody>> r0(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("stuId") String stuId, @Field("data") String data);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/cancelMeaNonStuApply")
    e<Response<ResponseBody>> r1(@Field("id") String id);

    @FormUrlEncoded
    @POST("punch/loadPunchRecordWeekData1")
    e<Response<ResponseBody>> s(@Field("userId") String userId, @Field("termId") String termId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appstu/uploadGatherPhotoBase64")
    e<Response<ResponseBody>> s0(@Field("userId") String userId, @Field("base64") String base64);

    @FormUrlEncoded
    @POST("punch/getTermWeekNum")
    e<Response<ResponseBody>> s1(@Field("termId") String termId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/getTermTotalScore")
    e<Response<ResponseBody>> t(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/evaluate/loadAssessData")
    e<Response<ResponseBody>> t0(@Field("stuId") String stuId);

    @FormUrlEncoded
    @POST("app/onlineExam/saveExamPaper")
    e<Response<ResponseBody>> t1(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("userId") String stuId, @Field("radio") String data, @Field("check") String check, @Field("quest") String quest, @Field("startTime") String startTime, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/onlineExam/loadExamContentData")
    e<Response<ResponseBody>> u(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("teachingCurrIds") String teachingCurrIds, @Field("userId") String userId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/evaluate/stuAssessTeaList")
    e<Response<ResponseBody>> u0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/fieldPlan/getRecordCount")
    e<Response<ResponseBody>> u1(@Field("userId") String userId, @Field("appointType") int appointType, @Field("date") String date);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showCurriculums")
    e<Response<ResponseBody>> v(@Field("userId") String userId, @Field("timeId") String timeId);

    @FormUrlEncoded
    @POST("app/measure/getStuScoreDetail")
    e<Response<ResponseBody>> v0(@Field("meaScoreId") String meaScoreId);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/toadd")
    e<Response<ResponseBody>> v1(@Field("stuId") String stuId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/runingFace/isUpFaces")
    e<Response<ResponseBody>> w(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/relieveBindThirdInfo")
    e<Response<ResponseBody>> w0(@Field("type") String type, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/deleteStuTeaCurr")
    e<Response<ResponseBody>> w1(@Field("stuTeacherCurriculumid") String stuTeacherCurriculumid);

    @FormUrlEncoded
    @POST("app/stuTermScore/listcallStu")
    e<Response<ResponseBody>> x(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/doadd")
    e<Response<ResponseBody>> x0(@Field("id") String id, @Field("userId") String userId);

    @POST("app/runingFace/registerFaceApi")
    @Multipart
    e<Response<ResponseBody>> x1(@Part("userId") RequestBody userId, @Part("file\"; filename=\"img.jpg ") RequestBody file);

    @FormUrlEncoded
    @POST("app/actOrder/actOrderListView")
    e<Response<ResponseBody>> y(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/config/getUploadMethod")
    e<Response<ResponseBody>> y0(@Field("method") String method);

    @GET("app/appStuMeaSchedule/getStuMeaInfo")
    e<Response<ResponseBody>> y1();

    @FormUrlEncoded
    @POST("app/appstu/login")
    e<Response<ResponseBody>> z(@Field("uname") String username, @Field("pwd") String password);

    @FormUrlEncoded
    @POST("app/onlineExam/isCourseSelection")
    e<Response<ResponseBody>> z0(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/measure/getStuTotalScore")
    e<Response<ResponseBody>> z1(@Field("userId") String userId);
}
