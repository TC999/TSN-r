package com.bxkj.student;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.student.databinding.AcExtraExerciseTypeBindingImpl;
import com.bxkj.student.databinding.AcFacePrivacyAgreementBindingImpl;
import com.bxkj.student.databinding.AcQrcodeScanBindingImpl;
import com.bxkj.student.databinding.AcRunQuestionBindingImpl;
import com.bxkj.student.databinding.AcSchoolListV2BindingImpl;
import com.bxkj.student.databinding.AcSplashBindingImpl;
import com.bxkj.student.databinding.AcV2H5AppBindingImpl;
import com.bxkj.student.databinding.AcV2PermissionSetBindingImpl;
import com.bxkj.student.databinding.AcV2SoundSetFrequencyBindingImpl;
import com.bxkj.student.databinding.AcV2SportsDescriptionBindingImpl;
import com.bxkj.student.databinding.AcV2SportsRankBindingImpl;
import com.bxkj.student.databinding.AcV2SportsSetBindingImpl;
import com.bxkj.student.databinding.AcV3RecordDetailBindingImpl;
import com.bxkj.student.databinding.AcV3RecordListBindingImpl;
import com.bxkj.student.databinding.AcV3SportsAppealBindingImpl;
import com.bxkj.student.databinding.AcV3SportsBindingImpl;
import com.bxkj.student.databinding.AcV3SportsFinishBindingImpl;
import com.bxkj.student.databinding.AcV3SportsHomeBindingImpl;
import com.bxkj.student.databinding.AcV3SportsMapBindingImpl;
import com.bxkj.student.databinding.AcV3SportsStatisticsBindingImpl;
import com.bxkj.student.databinding.DialogTipsBindingImpl;
import com.bxkj.student.databinding.FmV2SportsStatisticsBindingImpl;
import com.bxkj.student.databinding.FmV2SportsStepBindingImpl;
import com.bxkj.student.databinding.FmV2SportsTraceBindingImpl;
import com.bxkj.student.databinding.FmV3RecordListTotalBindingImpl;
import com.bxkj.student.databinding.FmV3SportsChartBindingImpl;
import com.bxkj.student.databinding.FmV3SportsTraceBindingImpl;
import com.bxkj.student.databinding.ItemForPaceKmBindingImpl;
import com.bxkj.student.databinding.ItemForSchoolListV2BindingImpl;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBindingImpl;
import com.bxkj.student.databinding.PubTitleBindingImpl;
import com.bxkj.student.databinding.V2AboutUsBindingImpl;
import com.bxkj.student.databinding.V2AcLoginBindingImpl;
import com.bxkj.student.databinding.V2AcScanQrcodeBindingImpl;
import com.bxkj.student.databinding.V2AdSwitchBindingImpl;
import com.bxkj.student.databinding.V2DialogQrCodeBindingImpl;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBindingImpl;
import com.bxkj.student.databinding.V2ItemForClassifyTitleBindingImpl;
import com.bxkj.student.databinding.V2ItemForHomeMenuBindingImpl;
import com.bxkj.student.databinding.V2ItemForMyMenuBindingImpl;
import com.bxkj.student.databinding.V2MainBindingImpl;
import com.bxkj.student.databinding.V2MainTabClassifyFragmentBindingImpl;
import com.bxkj.student.databinding.V2MainTabDiscoveryFragmentBindingImpl;
import com.bxkj.student.databinding.V2MainTabHomeFragmentBindingImpl;
import com.bxkj.student.databinding.V2MainTabMsgFragmentBindingImpl;
import com.bxkj.student.databinding.V2MainTabMyFragmentBindingImpl;
import com.bxkj.student.databinding.V2MyQrcodeBindingImpl;
import com.bxkj.student.databinding.V2PubTitleBindingImpl;
import com.bxkj.student.databinding.V3AcThreetwooneBindingImpl;
import com.bxkj.student.databinding.V3ExceptionDialogBindingImpl;
import com.bxkj.student.databinding.V3FaceCollectConfirmBindingImpl;
import com.bxkj.student.databinding.V3FmBasicBindingImpl;
import com.bxkj.student.databinding.V3FmDataBindingImpl;
import com.bxkj.student.databinding.V3FmInvalidRecordListBindingImpl;
import com.bxkj.student.databinding.V3FmValidRecordListBindingImpl;
import com.bxkj.student.databinding.V3ItemForInvalidRecordListBindingImpl;
import com.bxkj.student.databinding.V3ItemForValidRecordListBindingImpl;
import com.bxkj.student.databinding.V3ItemForValidRecordListTraceBindingImpl;
import com.bxkj.student.databinding.V3LayoutSportDetailDataCommonBindingImpl;
import com.bxkj.student.databinding.V3PassPointDialogBindingImpl;
import com.bxkj.student.databinding.V3PubTitleBindingImpl;
import com.bxkj.student.databinding.V3RankDialogBindingImpl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: A */
    private static final int f15900A = 27;

    /* renamed from: B */
    private static final int f15901B = 28;

    /* renamed from: C */
    private static final int f15902C = 29;

    /* renamed from: D */
    private static final int f15903D = 30;

    /* renamed from: E */
    private static final int f15904E = 31;

    /* renamed from: F */
    private static final int f15905F = 32;

    /* renamed from: G */
    private static final int f15906G = 33;

    /* renamed from: H */
    private static final int f15907H = 34;

    /* renamed from: I */
    private static final int f15908I = 35;

    /* renamed from: J */
    private static final int f15909J = 36;

    /* renamed from: K */
    private static final int f15910K = 37;

    /* renamed from: L */
    private static final int f15911L = 38;

    /* renamed from: M */
    private static final int f15912M = 39;

    /* renamed from: N */
    private static final int f15913N = 40;

    /* renamed from: O */
    private static final int f15914O = 41;

    /* renamed from: P */
    private static final int f15915P = 42;

    /* renamed from: Q */
    private static final int f15916Q = 43;

    /* renamed from: R */
    private static final int f15917R = 44;

    /* renamed from: S */
    private static final int f15918S = 45;

    /* renamed from: T */
    private static final int f15919T = 46;

    /* renamed from: U */
    private static final int f15920U = 47;

    /* renamed from: V */
    private static final int f15921V = 48;

    /* renamed from: W */
    private static final int f15922W = 49;

    /* renamed from: X */
    private static final int f15923X = 50;

    /* renamed from: Y */
    private static final int f15924Y = 51;

    /* renamed from: Z */
    private static final int f15925Z = 52;

    /* renamed from: a */
    private static final int f15926a = 1;

    /* renamed from: a0 */
    private static final int f15927a0 = 53;

    /* renamed from: b */
    private static final int f15928b = 2;

    /* renamed from: b0 */
    private static final int f15929b0 = 54;

    /* renamed from: c */
    private static final int f15930c = 3;

    /* renamed from: c0 */
    private static final int f15931c0 = 55;

    /* renamed from: d */
    private static final int f15932d = 4;

    /* renamed from: d0 */
    private static final int f15933d0 = 56;

    /* renamed from: e */
    private static final int f15934e = 5;

    /* renamed from: e0 */
    private static final int f15935e0 = 57;

    /* renamed from: f */
    private static final int f15936f = 6;

    /* renamed from: f0 */
    private static final int f15937f0 = 58;

    /* renamed from: g */
    private static final int f15938g = 7;

    /* renamed from: g0 */
    private static final int f15939g0 = 59;

    /* renamed from: h */
    private static final int f15940h = 8;

    /* renamed from: h0 */
    private static final int f15941h0 = 60;

    /* renamed from: i */
    private static final int f15942i = 9;

    /* renamed from: i0 */
    private static final int f15943i0 = 61;

    /* renamed from: j */
    private static final int f15944j = 10;

    /* renamed from: j0 */
    private static final int f15945j0 = 62;

    /* renamed from: k */
    private static final int f15946k = 11;

    /* renamed from: k0 */
    private static final SparseIntArray f15947k0;

    /* renamed from: l */
    private static final int f15948l = 12;

    /* renamed from: m */
    private static final int f15949m = 13;

    /* renamed from: n */
    private static final int f15950n = 14;

    /* renamed from: o */
    private static final int f15951o = 15;

    /* renamed from: p */
    private static final int f15952p = 16;

    /* renamed from: q */
    private static final int f15953q = 17;

    /* renamed from: r */
    private static final int f15954r = 18;

    /* renamed from: s */
    private static final int f15955s = 19;

    /* renamed from: t */
    private static final int f15956t = 20;

    /* renamed from: u */
    private static final int f15957u = 21;

    /* renamed from: v */
    private static final int f15958v = 22;

    /* renamed from: w */
    private static final int f15959w = 23;

    /* renamed from: x */
    private static final int f15960x = 24;

    /* renamed from: y */
    private static final int f15961y = 25;

    /* renamed from: z */
    private static final int f15962z = 26;

    /* renamed from: com.bxkj.student.DataBinderMapperImpl$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static class C4206a {

        /* renamed from: a */
        static final SparseArray<String> f15963a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(30);
            f15963a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, TTDownloadField.TT_ACTIVITY);
            sparseArray.put(2, "answer");
            sparseArray.put(3, "backEvent");
            sparseArray.put(4, "checkedId");
            sparseArray.put(5, "classifyFragment");
            sparseArray.put(6, "data");
            sparseArray.put(7, "dataMap");
            sparseArray.put(8, "dialog");
            sparseArray.put(9, "isClock");
            sparseArray.put(10, "isHideBack");
            sparseArray.put(11, "isShowRightAnswer");
            sparseArray.put(12, "loggedInUser");
            sparseArray.put(13, "loginInUser");
            sparseArray.put(14, "loginViewModel");
            sparseArray.put(15, "mActivity");
            sparseArray.put(16, "mActvity");
            sparseArray.put(17, "mSportsSetActivity");
            sparseArray.put(18, "map");
            sparseArray.put(19, "myFragment");
            sparseArray.put(20, "notice");
            sparseArray.put(21, "qrScanActivity");
            sparseArray.put(22, "recordMap");
            sparseArray.put(23, "showBottom");
            sparseArray.put(24, "signTypeActivity");
            sparseArray.put(25, "sportType");
            sparseArray.put(26, "startButtonEnable");
            sparseArray.put(27, "tipsText");
            sparseArray.put(28, "title");
            sparseArray.put(29, ConstantHelper.LOG_VS);
        }

        private C4206a() {
        }
    }

    /* renamed from: com.bxkj.student.DataBinderMapperImpl$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static class C4207b {

        /* renamed from: a */
        static final HashMap<String, Integer> f15964a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(62);
            f15964a = hashMap;
            hashMap.put("layout/ac_extra_exercise_type_0", Integer.valueOf((int) C4215R.C4221layout.ac_extra_exercise_type));
            hashMap.put("layout/ac_face_privacy_agreement_0", Integer.valueOf((int) C4215R.C4221layout.ac_face_privacy_agreement));
            hashMap.put("layout/ac_qrcode_scan_0", Integer.valueOf((int) C4215R.C4221layout.ac_qrcode_scan));
            hashMap.put("layout/ac_run_question_0", Integer.valueOf((int) C4215R.C4221layout.ac_run_question));
            hashMap.put("layout/ac_school_list_v2_0", Integer.valueOf((int) C4215R.C4221layout.ac_school_list_v2));
            hashMap.put("layout/ac_splash_0", Integer.valueOf((int) C4215R.C4221layout.ac_splash));
            hashMap.put("layout/ac_v2_h5_app_0", Integer.valueOf((int) C4215R.C4221layout.ac_v2_h5_app));
            hashMap.put("layout/ac_v2_permission_set_0", Integer.valueOf((int) C4215R.C4221layout.ac_v2_permission_set));
            hashMap.put("layout/ac_v2_sound_set_frequency_0", Integer.valueOf((int) C4215R.C4221layout.ac_v2_sound_set_frequency));
            hashMap.put("layout/ac_v2_sports_description_0", Integer.valueOf((int) C4215R.C4221layout.ac_v2_sports_description));
            hashMap.put("layout/ac_v2_sports_rank_0", Integer.valueOf((int) C4215R.C4221layout.ac_v2_sports_rank));
            hashMap.put("layout/ac_v2_sports_set_0", Integer.valueOf((int) C4215R.C4221layout.ac_v2_sports_set));
            hashMap.put("layout/ac_v3_record_detail_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_record_detail));
            hashMap.put("layout/ac_v3_record_list_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_record_list));
            hashMap.put("layout/ac_v3_sports_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_sports));
            hashMap.put("layout/ac_v3_sports_appeal_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_sports_appeal));
            hashMap.put("layout/ac_v3_sports_finish_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_sports_finish));
            hashMap.put("layout/ac_v3_sports_home_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_sports_home));
            hashMap.put("layout/ac_v3_sports_map_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_sports_map));
            hashMap.put("layout/ac_v3_sports_statistics_0", Integer.valueOf((int) C4215R.C4221layout.ac_v3_sports_statistics));
            hashMap.put("layout/dialog_tips_0", Integer.valueOf((int) C4215R.C4221layout.dialog_tips));
            hashMap.put("layout/fm_v2_sports_statistics_0", Integer.valueOf((int) C4215R.C4221layout.fm_v2_sports_statistics));
            hashMap.put("layout/fm_v2_sports_step_0", Integer.valueOf((int) C4215R.C4221layout.fm_v2_sports_step));
            hashMap.put("layout/fm_v2_sports_trace_0", Integer.valueOf((int) C4215R.C4221layout.fm_v2_sports_trace));
            hashMap.put("layout/fm_v3_record_list_total_0", Integer.valueOf((int) C4215R.C4221layout.fm_v3_record_list_total));
            hashMap.put("layout/fm_v3_sports_chart_0", Integer.valueOf((int) C4215R.C4221layout.fm_v3_sports_chart));
            hashMap.put("layout/fm_v3_sports_trace_0", Integer.valueOf((int) C4215R.C4221layout.fm_v3_sports_trace));
            hashMap.put("layout/item_for_pace_km_0", Integer.valueOf((int) C4215R.C4221layout.item_for_pace_km));
            hashMap.put("layout/item_for_school_list_v2_0", Integer.valueOf((int) C4215R.C4221layout.item_for_school_list_v2));
            hashMap.put("layout/item_for_v3_pass_point_dialog_0", Integer.valueOf((int) C4215R.C4221layout.item_for_v3_pass_point_dialog));
            hashMap.put("layout/pub_title_0", Integer.valueOf((int) C4215R.C4221layout.pub_title));
            hashMap.put("layout/v2_about_us_0", Integer.valueOf((int) C4215R.C4221layout.v2_about_us));
            hashMap.put("layout/v2_ac_login_0", Integer.valueOf((int) C4215R.C4221layout.v2_ac_login));
            hashMap.put("layout/v2_ac_scan_qrcode_0", Integer.valueOf((int) C4215R.C4221layout.v2_ac_scan_qrcode));
            hashMap.put("layout/v2_ad_switch_0", Integer.valueOf((int) C4215R.C4221layout.v2_ad_switch));
            hashMap.put("layout/v2_dialog_qr_code_0", Integer.valueOf((int) C4215R.C4221layout.v2_dialog_qr_code));
            hashMap.put("layout/v2_item_for_classify_menu_0", Integer.valueOf((int) C4215R.C4221layout.v2_item_for_classify_menu));
            hashMap.put("layout/v2_item_for_classify_title_0", Integer.valueOf((int) C4215R.C4221layout.v2_item_for_classify_title));
            hashMap.put("layout/v2_item_for_home_menu_0", Integer.valueOf((int) C4215R.C4221layout.v2_item_for_home_menu));
            hashMap.put("layout/v2_item_for_my_menu_0", Integer.valueOf((int) C4215R.C4221layout.v2_item_for_my_menu));
            hashMap.put("layout/v2_main_0", Integer.valueOf((int) C4215R.C4221layout.v2_main));
            hashMap.put("layout/v2_main_tab_classify_fragment_0", Integer.valueOf((int) C4215R.C4221layout.v2_main_tab_classify_fragment));
            hashMap.put("layout/v2_main_tab_discovery_fragment_0", Integer.valueOf((int) C4215R.C4221layout.v2_main_tab_discovery_fragment));
            hashMap.put("layout/v2_main_tab_home_fragment_0", Integer.valueOf((int) C4215R.C4221layout.v2_main_tab_home_fragment));
            hashMap.put("layout/v2_main_tab_msg_fragment_0", Integer.valueOf((int) C4215R.C4221layout.v2_main_tab_msg_fragment));
            hashMap.put("layout/v2_main_tab_my_fragment_0", Integer.valueOf((int) C4215R.C4221layout.v2_main_tab_my_fragment));
            hashMap.put("layout/v2_my_qrcode_0", Integer.valueOf((int) C4215R.C4221layout.v2_my_qrcode));
            hashMap.put("layout/v2_pub_title_0", Integer.valueOf((int) C4215R.C4221layout.v2_pub_title));
            hashMap.put("layout/v3_ac_threetwoone_0", Integer.valueOf((int) C4215R.C4221layout.v3_ac_threetwoone));
            hashMap.put("layout/v3_exception_dialog_0", Integer.valueOf((int) C4215R.C4221layout.v3_exception_dialog));
            hashMap.put("layout/v3_face_collect_confirm_0", Integer.valueOf((int) C4215R.C4221layout.v3_face_collect_confirm));
            hashMap.put("layout/v3_fm_basic_0", Integer.valueOf((int) C4215R.C4221layout.v3_fm_basic));
            hashMap.put("layout/v3_fm_data_0", Integer.valueOf((int) C4215R.C4221layout.v3_fm_data));
            hashMap.put("layout/v3_fm_invalid_record_list_0", Integer.valueOf((int) C4215R.C4221layout.v3_fm_invalid_record_list));
            hashMap.put("layout/v3_fm_valid_record_list_0", Integer.valueOf((int) C4215R.C4221layout.v3_fm_valid_record_list));
            hashMap.put("layout/v3_item_for_invalid_record_list_0", Integer.valueOf((int) C4215R.C4221layout.v3_item_for_invalid_record_list));
            hashMap.put("layout/v3_item_for_valid_record_list_0", Integer.valueOf((int) C4215R.C4221layout.v3_item_for_valid_record_list));
            hashMap.put("layout/v3_item_for_valid_record_list_trace_0", Integer.valueOf((int) C4215R.C4221layout.v3_item_for_valid_record_list_trace));
            hashMap.put("layout/v3_layout_sport_detail_data_common_0", Integer.valueOf((int) C4215R.C4221layout.v3_layout_sport_detail_data_common));
            hashMap.put("layout/v3_pass_point_dialog_0", Integer.valueOf((int) C4215R.C4221layout.v3_pass_point_dialog));
            hashMap.put("layout/v3_pub_title_0", Integer.valueOf((int) C4215R.C4221layout.v3_pub_title));
            hashMap.put("layout/v3_rank_dialog_0", Integer.valueOf((int) C4215R.C4221layout.v3_rank_dialog));
        }

        private C4207b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(62);
        f15947k0 = sparseIntArray;
        sparseIntArray.put(C4215R.C4221layout.ac_extra_exercise_type, 1);
        sparseIntArray.put(C4215R.C4221layout.ac_face_privacy_agreement, 2);
        sparseIntArray.put(C4215R.C4221layout.ac_qrcode_scan, 3);
        sparseIntArray.put(C4215R.C4221layout.ac_run_question, 4);
        sparseIntArray.put(C4215R.C4221layout.ac_school_list_v2, 5);
        sparseIntArray.put(C4215R.C4221layout.ac_splash, 6);
        sparseIntArray.put(C4215R.C4221layout.ac_v2_h5_app, 7);
        sparseIntArray.put(C4215R.C4221layout.ac_v2_permission_set, 8);
        sparseIntArray.put(C4215R.C4221layout.ac_v2_sound_set_frequency, 9);
        sparseIntArray.put(C4215R.C4221layout.ac_v2_sports_description, 10);
        sparseIntArray.put(C4215R.C4221layout.ac_v2_sports_rank, 11);
        sparseIntArray.put(C4215R.C4221layout.ac_v2_sports_set, 12);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_record_detail, 13);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_record_list, 14);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_sports, 15);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_sports_appeal, 16);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_sports_finish, 17);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_sports_home, 18);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_sports_map, 19);
        sparseIntArray.put(C4215R.C4221layout.ac_v3_sports_statistics, 20);
        sparseIntArray.put(C4215R.C4221layout.dialog_tips, 21);
        sparseIntArray.put(C4215R.C4221layout.fm_v2_sports_statistics, 22);
        sparseIntArray.put(C4215R.C4221layout.fm_v2_sports_step, 23);
        sparseIntArray.put(C4215R.C4221layout.fm_v2_sports_trace, 24);
        sparseIntArray.put(C4215R.C4221layout.fm_v3_record_list_total, 25);
        sparseIntArray.put(C4215R.C4221layout.fm_v3_sports_chart, 26);
        sparseIntArray.put(C4215R.C4221layout.fm_v3_sports_trace, 27);
        sparseIntArray.put(C4215R.C4221layout.item_for_pace_km, 28);
        sparseIntArray.put(C4215R.C4221layout.item_for_school_list_v2, 29);
        sparseIntArray.put(C4215R.C4221layout.item_for_v3_pass_point_dialog, 30);
        sparseIntArray.put(C4215R.C4221layout.pub_title, 31);
        sparseIntArray.put(C4215R.C4221layout.v2_about_us, 32);
        sparseIntArray.put(C4215R.C4221layout.v2_ac_login, 33);
        sparseIntArray.put(C4215R.C4221layout.v2_ac_scan_qrcode, 34);
        sparseIntArray.put(C4215R.C4221layout.v2_ad_switch, 35);
        sparseIntArray.put(C4215R.C4221layout.v2_dialog_qr_code, 36);
        sparseIntArray.put(C4215R.C4221layout.v2_item_for_classify_menu, 37);
        sparseIntArray.put(C4215R.C4221layout.v2_item_for_classify_title, 38);
        sparseIntArray.put(C4215R.C4221layout.v2_item_for_home_menu, 39);
        sparseIntArray.put(C4215R.C4221layout.v2_item_for_my_menu, 40);
        sparseIntArray.put(C4215R.C4221layout.v2_main, 41);
        sparseIntArray.put(C4215R.C4221layout.v2_main_tab_classify_fragment, 42);
        sparseIntArray.put(C4215R.C4221layout.v2_main_tab_discovery_fragment, 43);
        sparseIntArray.put(C4215R.C4221layout.v2_main_tab_home_fragment, 44);
        sparseIntArray.put(C4215R.C4221layout.v2_main_tab_msg_fragment, 45);
        sparseIntArray.put(C4215R.C4221layout.v2_main_tab_my_fragment, 46);
        sparseIntArray.put(C4215R.C4221layout.v2_my_qrcode, 47);
        sparseIntArray.put(C4215R.C4221layout.v2_pub_title, 48);
        sparseIntArray.put(C4215R.C4221layout.v3_ac_threetwoone, 49);
        sparseIntArray.put(C4215R.C4221layout.v3_exception_dialog, 50);
        sparseIntArray.put(C4215R.C4221layout.v3_face_collect_confirm, 51);
        sparseIntArray.put(C4215R.C4221layout.v3_fm_basic, 52);
        sparseIntArray.put(C4215R.C4221layout.v3_fm_data, 53);
        sparseIntArray.put(C4215R.C4221layout.v3_fm_invalid_record_list, 54);
        sparseIntArray.put(C4215R.C4221layout.v3_fm_valid_record_list, 55);
        sparseIntArray.put(C4215R.C4221layout.v3_item_for_invalid_record_list, 56);
        sparseIntArray.put(C4215R.C4221layout.v3_item_for_valid_record_list, 57);
        sparseIntArray.put(C4215R.C4221layout.v3_item_for_valid_record_list_trace, 58);
        sparseIntArray.put(C4215R.C4221layout.v3_layout_sport_detail_data_common, 59);
        sparseIntArray.put(C4215R.C4221layout.v3_pass_point_dialog, 60);
        sparseIntArray.put(C4215R.C4221layout.v3_pub_title, 61);
        sparseIntArray.put(C4215R.C4221layout.v3_rank_dialog, 62);
    }

    /* renamed from: a */
    private final ViewDataBinding m42990a(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/ac_extra_exercise_type_0".equals(tag)) {
                    return new AcExtraExerciseTypeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_extra_exercise_type is invalid. Received: " + tag);
            case 2:
                if ("layout/ac_face_privacy_agreement_0".equals(tag)) {
                    return new AcFacePrivacyAgreementBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_face_privacy_agreement is invalid. Received: " + tag);
            case 3:
                if ("layout/ac_qrcode_scan_0".equals(tag)) {
                    return new AcQrcodeScanBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_qrcode_scan is invalid. Received: " + tag);
            case 4:
                if ("layout/ac_run_question_0".equals(tag)) {
                    return new AcRunQuestionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_run_question is invalid. Received: " + tag);
            case 5:
                if ("layout/ac_school_list_v2_0".equals(tag)) {
                    return new AcSchoolListV2BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_school_list_v2 is invalid. Received: " + tag);
            case 6:
                if ("layout/ac_splash_0".equals(tag)) {
                    return new AcSplashBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_splash is invalid. Received: " + tag);
            case 7:
                if ("layout/ac_v2_h5_app_0".equals(tag)) {
                    return new AcV2H5AppBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v2_h5_app is invalid. Received: " + tag);
            case 8:
                if ("layout/ac_v2_permission_set_0".equals(tag)) {
                    return new AcV2PermissionSetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v2_permission_set is invalid. Received: " + tag);
            case 9:
                if ("layout/ac_v2_sound_set_frequency_0".equals(tag)) {
                    return new AcV2SoundSetFrequencyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v2_sound_set_frequency is invalid. Received: " + tag);
            case 10:
                if ("layout/ac_v2_sports_description_0".equals(tag)) {
                    return new AcV2SportsDescriptionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v2_sports_description is invalid. Received: " + tag);
            case 11:
                if ("layout/ac_v2_sports_rank_0".equals(tag)) {
                    return new AcV2SportsRankBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v2_sports_rank is invalid. Received: " + tag);
            case 12:
                if ("layout/ac_v2_sports_set_0".equals(tag)) {
                    return new AcV2SportsSetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v2_sports_set is invalid. Received: " + tag);
            case 13:
                if ("layout/ac_v3_record_detail_0".equals(tag)) {
                    return new AcV3RecordDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_record_detail is invalid. Received: " + tag);
            case 14:
                if ("layout/ac_v3_record_list_0".equals(tag)) {
                    return new AcV3RecordListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_record_list is invalid. Received: " + tag);
            case 15:
                if ("layout/ac_v3_sports_0".equals(tag)) {
                    return new AcV3SportsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_sports is invalid. Received: " + tag);
            case 16:
                if ("layout/ac_v3_sports_appeal_0".equals(tag)) {
                    return new AcV3SportsAppealBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_sports_appeal is invalid. Received: " + tag);
            case 17:
                if ("layout/ac_v3_sports_finish_0".equals(tag)) {
                    return new AcV3SportsFinishBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_sports_finish is invalid. Received: " + tag);
            case 18:
                if ("layout/ac_v3_sports_home_0".equals(tag)) {
                    return new AcV3SportsHomeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_sports_home is invalid. Received: " + tag);
            case 19:
                if ("layout/ac_v3_sports_map_0".equals(tag)) {
                    return new AcV3SportsMapBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_sports_map is invalid. Received: " + tag);
            case 20:
                if ("layout/ac_v3_sports_statistics_0".equals(tag)) {
                    return new AcV3SportsStatisticsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ac_v3_sports_statistics is invalid. Received: " + tag);
            case 21:
                if ("layout/dialog_tips_0".equals(tag)) {
                    return new DialogTipsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tips is invalid. Received: " + tag);
            case 22:
                if ("layout/fm_v2_sports_statistics_0".equals(tag)) {
                    return new FmV2SportsStatisticsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fm_v2_sports_statistics is invalid. Received: " + tag);
            case 23:
                if ("layout/fm_v2_sports_step_0".equals(tag)) {
                    return new FmV2SportsStepBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fm_v2_sports_step is invalid. Received: " + tag);
            case 24:
                if ("layout/fm_v2_sports_trace_0".equals(tag)) {
                    return new FmV2SportsTraceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fm_v2_sports_trace is invalid. Received: " + tag);
            case 25:
                if ("layout/fm_v3_record_list_total_0".equals(tag)) {
                    return new FmV3RecordListTotalBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fm_v3_record_list_total is invalid. Received: " + tag);
            case 26:
                if ("layout/fm_v3_sports_chart_0".equals(tag)) {
                    return new FmV3SportsChartBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fm_v3_sports_chart is invalid. Received: " + tag);
            case 27:
                if ("layout/fm_v3_sports_trace_0".equals(tag)) {
                    return new FmV3SportsTraceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fm_v3_sports_trace is invalid. Received: " + tag);
            case 28:
                if ("layout/item_for_pace_km_0".equals(tag)) {
                    return new ItemForPaceKmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_for_pace_km is invalid. Received: " + tag);
            case 29:
                if ("layout/item_for_school_list_v2_0".equals(tag)) {
                    return new ItemForSchoolListV2BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_for_school_list_v2 is invalid. Received: " + tag);
            case 30:
                if ("layout/item_for_v3_pass_point_dialog_0".equals(tag)) {
                    return new ItemForV3PassPointDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_for_v3_pass_point_dialog is invalid. Received: " + tag);
            case 31:
                if ("layout/pub_title_0".equals(tag)) {
                    return new PubTitleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for pub_title is invalid. Received: " + tag);
            case 32:
                if ("layout/v2_about_us_0".equals(tag)) {
                    return new V2AboutUsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_about_us is invalid. Received: " + tag);
            case 33:
                if ("layout/v2_ac_login_0".equals(tag)) {
                    return new V2AcLoginBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_ac_login is invalid. Received: " + tag);
            case 34:
                if ("layout/v2_ac_scan_qrcode_0".equals(tag)) {
                    return new V2AcScanQrcodeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_ac_scan_qrcode is invalid. Received: " + tag);
            case 35:
                if ("layout/v2_ad_switch_0".equals(tag)) {
                    return new V2AdSwitchBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_ad_switch is invalid. Received: " + tag);
            case 36:
                if ("layout/v2_dialog_qr_code_0".equals(tag)) {
                    return new V2DialogQrCodeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_dialog_qr_code is invalid. Received: " + tag);
            case 37:
                if ("layout/v2_item_for_classify_menu_0".equals(tag)) {
                    return new V2ItemForClassifyMenuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_item_for_classify_menu is invalid. Received: " + tag);
            case 38:
                if ("layout/v2_item_for_classify_title_0".equals(tag)) {
                    return new V2ItemForClassifyTitleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_item_for_classify_title is invalid. Received: " + tag);
            case 39:
                if ("layout/v2_item_for_home_menu_0".equals(tag)) {
                    return new V2ItemForHomeMenuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_item_for_home_menu is invalid. Received: " + tag);
            case 40:
                if ("layout/v2_item_for_my_menu_0".equals(tag)) {
                    return new V2ItemForMyMenuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_item_for_my_menu is invalid. Received: " + tag);
            case 41:
                if ("layout/v2_main_0".equals(tag)) {
                    return new V2MainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_main is invalid. Received: " + tag);
            case 42:
                if ("layout/v2_main_tab_classify_fragment_0".equals(tag)) {
                    return new V2MainTabClassifyFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_main_tab_classify_fragment is invalid. Received: " + tag);
            case 43:
                if ("layout/v2_main_tab_discovery_fragment_0".equals(tag)) {
                    return new V2MainTabDiscoveryFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_main_tab_discovery_fragment is invalid. Received: " + tag);
            case 44:
                if ("layout/v2_main_tab_home_fragment_0".equals(tag)) {
                    return new V2MainTabHomeFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_main_tab_home_fragment is invalid. Received: " + tag);
            case 45:
                if ("layout/v2_main_tab_msg_fragment_0".equals(tag)) {
                    return new V2MainTabMsgFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_main_tab_msg_fragment is invalid. Received: " + tag);
            case 46:
                if ("layout/v2_main_tab_my_fragment_0".equals(tag)) {
                    return new V2MainTabMyFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_main_tab_my_fragment is invalid. Received: " + tag);
            case 47:
                if ("layout/v2_my_qrcode_0".equals(tag)) {
                    return new V2MyQrcodeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_my_qrcode is invalid. Received: " + tag);
            case 48:
                if ("layout/v2_pub_title_0".equals(tag)) {
                    return new V2PubTitleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v2_pub_title is invalid. Received: " + tag);
            case 49:
                if ("layout/v3_ac_threetwoone_0".equals(tag)) {
                    return new V3AcThreetwooneBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_ac_threetwoone is invalid. Received: " + tag);
            case 50:
                if ("layout/v3_exception_dialog_0".equals(tag)) {
                    return new V3ExceptionDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_exception_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    /* renamed from: b */
    private final ViewDataBinding m42989b(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/v3_face_collect_confirm_0".equals(tag)) {
                    return new V3FaceCollectConfirmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_face_collect_confirm is invalid. Received: " + tag);
            case 52:
                if ("layout/v3_fm_basic_0".equals(tag)) {
                    return new V3FmBasicBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_fm_basic is invalid. Received: " + tag);
            case 53:
                if ("layout/v3_fm_data_0".equals(tag)) {
                    return new V3FmDataBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_fm_data is invalid. Received: " + tag);
            case 54:
                if ("layout/v3_fm_invalid_record_list_0".equals(tag)) {
                    return new V3FmInvalidRecordListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_fm_invalid_record_list is invalid. Received: " + tag);
            case 55:
                if ("layout/v3_fm_valid_record_list_0".equals(tag)) {
                    return new V3FmValidRecordListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_fm_valid_record_list is invalid. Received: " + tag);
            case 56:
                if ("layout/v3_item_for_invalid_record_list_0".equals(tag)) {
                    return new V3ItemForInvalidRecordListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_item_for_invalid_record_list is invalid. Received: " + tag);
            case 57:
                if ("layout/v3_item_for_valid_record_list_0".equals(tag)) {
                    return new V3ItemForValidRecordListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_item_for_valid_record_list is invalid. Received: " + tag);
            case 58:
                if ("layout/v3_item_for_valid_record_list_trace_0".equals(tag)) {
                    return new V3ItemForValidRecordListTraceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_item_for_valid_record_list_trace is invalid. Received: " + tag);
            case 59:
                if ("layout/v3_layout_sport_detail_data_common_0".equals(tag)) {
                    return new V3LayoutSportDetailDataCommonBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_layout_sport_detail_data_common is invalid. Received: " + tag);
            case 60:
                if ("layout/v3_pass_point_dialog_0".equals(tag)) {
                    return new V3PassPointDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_pass_point_dialog is invalid. Received: " + tag);
            case 61:
                if ("layout/v3_pub_title_0".equals(tag)) {
                    return new V3PubTitleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_pub_title is invalid. Received: " + tag);
            case 62:
                if ("layout/v3_rank_dialog_0".equals(tag)) {
                    return new V3RankDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for v3_rank_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.bxkj.base.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return C4206a.f15963a.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = f15947k0.get(layoutId);
        if (i > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i2 = (i - 1) / 50;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return null;
                    }
                    return m42989b(component, view, i, tag);
                }
                return m42990a(component, view, i, tag);
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = C4207b.f15964a.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || f15947k0.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
