package com.bxkj.student;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final int A = 27;
    private static final int B = 28;
    private static final int C = 29;
    private static final int D = 30;
    private static final int E = 31;
    private static final int F = 32;
    private static final int G = 33;
    private static final int H = 34;
    private static final int I = 35;
    private static final int J = 36;
    private static final int K = 37;

    /* renamed from: L  reason: collision with root package name */
    private static final int f19380L = 38;
    private static final int M = 39;
    private static final int N = 40;
    private static final int O = 41;
    private static final int P = 42;
    private static final int Q = 43;
    private static final int R = 44;
    private static final int S = 45;
    private static final int T = 46;
    private static final int U = 47;
    private static final int V = 48;
    private static final int W = 49;
    private static final int X = 50;
    private static final int Y = 51;
    private static final int Z = 52;

    /* renamed from: a  reason: collision with root package name */
    private static final int f19381a = 1;

    /* renamed from: a0  reason: collision with root package name */
    private static final int f19382a0 = 53;

    /* renamed from: b  reason: collision with root package name */
    private static final int f19383b = 2;

    /* renamed from: b0  reason: collision with root package name */
    private static final int f19384b0 = 54;

    /* renamed from: c  reason: collision with root package name */
    private static final int f19385c = 3;

    /* renamed from: c0  reason: collision with root package name */
    private static final int f19386c0 = 55;

    /* renamed from: d  reason: collision with root package name */
    private static final int f19387d = 4;

    /* renamed from: d0  reason: collision with root package name */
    private static final int f19388d0 = 56;

    /* renamed from: e  reason: collision with root package name */
    private static final int f19389e = 5;

    /* renamed from: e0  reason: collision with root package name */
    private static final int f19390e0 = 57;

    /* renamed from: f  reason: collision with root package name */
    private static final int f19391f = 6;

    /* renamed from: f0  reason: collision with root package name */
    private static final int f19392f0 = 58;

    /* renamed from: g  reason: collision with root package name */
    private static final int f19393g = 7;

    /* renamed from: g0  reason: collision with root package name */
    private static final int f19394g0 = 59;

    /* renamed from: h  reason: collision with root package name */
    private static final int f19395h = 8;

    /* renamed from: h0  reason: collision with root package name */
    private static final int f19396h0 = 60;

    /* renamed from: i  reason: collision with root package name */
    private static final int f19397i = 9;

    /* renamed from: i0  reason: collision with root package name */
    private static final int f19398i0 = 61;

    /* renamed from: j  reason: collision with root package name */
    private static final int f19399j = 10;

    /* renamed from: j0  reason: collision with root package name */
    private static final int f19400j0 = 62;

    /* renamed from: k  reason: collision with root package name */
    private static final int f19401k = 11;

    /* renamed from: k0  reason: collision with root package name */
    private static final SparseIntArray f19402k0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f19403l = 12;

    /* renamed from: m  reason: collision with root package name */
    private static final int f19404m = 13;

    /* renamed from: n  reason: collision with root package name */
    private static final int f19405n = 14;

    /* renamed from: o  reason: collision with root package name */
    private static final int f19406o = 15;

    /* renamed from: p  reason: collision with root package name */
    private static final int f19407p = 16;

    /* renamed from: q  reason: collision with root package name */
    private static final int f19408q = 17;

    /* renamed from: r  reason: collision with root package name */
    private static final int f19409r = 18;

    /* renamed from: s  reason: collision with root package name */
    private static final int f19410s = 19;

    /* renamed from: t  reason: collision with root package name */
    private static final int f19411t = 20;

    /* renamed from: u  reason: collision with root package name */
    private static final int f19412u = 21;

    /* renamed from: v  reason: collision with root package name */
    private static final int f19413v = 22;

    /* renamed from: w  reason: collision with root package name */
    private static final int f19414w = 23;

    /* renamed from: x  reason: collision with root package name */
    private static final int f19415x = 24;

    /* renamed from: y  reason: collision with root package name */
    private static final int f19416y = 25;

    /* renamed from: z  reason: collision with root package name */
    private static final int f19417z = 26;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f19418a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(30);
            f19418a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "activity");
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
            sparseArray.put(29, "version");
        }

        private a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f19419a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(62);
            f19419a = hashMap;
            hashMap.put("layout/ac_extra_exercise_type_0", 2131427398);
            hashMap.put("layout/ac_face_privacy_agreement_0", 2131427399);
            hashMap.put("layout/ac_qrcode_scan_0", 2131427466);
            hashMap.put("layout/ac_run_question_0", 2131427476);
            hashMap.put("layout/ac_school_list_v2_0", 2131427485);
            hashMap.put("layout/ac_splash_0", 2131427494);
            hashMap.put("layout/ac_v2_h5_app_0", 2131427506);
            hashMap.put("layout/ac_v2_permission_set_0", 2131427507);
            hashMap.put("layout/ac_v2_sound_set_frequency_0", 2131427508);
            hashMap.put("layout/ac_v2_sports_description_0", 2131427509);
            hashMap.put("layout/ac_v2_sports_rank_0", 2131427510);
            hashMap.put("layout/ac_v2_sports_set_0", 2131427511);
            hashMap.put("layout/ac_v3_record_detail_0", 2131427512);
            hashMap.put("layout/ac_v3_record_list_0", 2131427513);
            hashMap.put("layout/ac_v3_sports_0", 2131427514);
            hashMap.put("layout/ac_v3_sports_appeal_0", 2131427515);
            hashMap.put("layout/ac_v3_sports_finish_0", 2131427516);
            hashMap.put("layout/ac_v3_sports_home_0", 2131427517);
            hashMap.put("layout/ac_v3_sports_map_0", 2131427518);
            hashMap.put("layout/ac_v3_sports_statistics_0", 2131427519);
            hashMap.put("layout/dialog_tips_0", 2131427609);
            hashMap.put("layout/fm_v2_sports_statistics_0", 2131427645);
            hashMap.put("layout/fm_v2_sports_step_0", 2131427646);
            hashMap.put("layout/fm_v2_sports_trace_0", 2131427647);
            hashMap.put("layout/fm_v3_record_list_total_0", 2131427648);
            hashMap.put("layout/fm_v3_sports_chart_0", 2131427649);
            hashMap.put("layout/fm_v3_sports_trace_0", 2131427650);
            hashMap.put("layout/item_for_pace_km_0", 2131427735);
            hashMap.put("layout/item_for_school_list_v2_0", 2131427757);
            hashMap.put("layout/item_for_v3_pass_point_dialog_0", 2131427774);
            hashMap.put("layout/pub_title_0", 2131428029);
            hashMap.put("layout/v2_about_us_0", 2131428081);
            hashMap.put("layout/v2_ac_login_0", 2131428082);
            hashMap.put("layout/v2_ac_scan_qrcode_0", 2131428083);
            hashMap.put("layout/v2_ad_switch_0", 2131428084);
            hashMap.put("layout/v2_dialog_qr_code_0", 2131428085);
            hashMap.put("layout/v2_item_for_classify_menu_0", 2131428086);
            hashMap.put("layout/v2_item_for_classify_title_0", 2131428087);
            hashMap.put("layout/v2_item_for_home_menu_0", 2131428088);
            hashMap.put("layout/v2_item_for_my_menu_0", 2131428089);
            hashMap.put("layout/v2_main_0", 2131428090);
            hashMap.put("layout/v2_main_tab_classify_fragment_0", 2131428091);
            hashMap.put("layout/v2_main_tab_discovery_fragment_0", 2131428092);
            hashMap.put("layout/v2_main_tab_home_fragment_0", 2131428093);
            hashMap.put("layout/v2_main_tab_msg_fragment_0", 2131428094);
            hashMap.put("layout/v2_main_tab_my_fragment_0", 2131428095);
            hashMap.put("layout/v2_my_qrcode_0", 2131428096);
            hashMap.put("layout/v2_pub_title_0", 2131428100);
            hashMap.put("layout/v3_ac_threetwoone_0", 2131428101);
            hashMap.put("layout/v3_exception_dialog_0", 2131428103);
            hashMap.put("layout/v3_face_collect_confirm_0", 2131428104);
            hashMap.put("layout/v3_fm_basic_0", 2131428105);
            hashMap.put("layout/v3_fm_data_0", 2131428106);
            hashMap.put("layout/v3_fm_invalid_record_list_0", 2131428107);
            hashMap.put("layout/v3_fm_valid_record_list_0", 2131428108);
            hashMap.put("layout/v3_item_for_invalid_record_list_0", 2131428109);
            hashMap.put("layout/v3_item_for_valid_record_list_0", 2131428110);
            hashMap.put("layout/v3_item_for_valid_record_list_trace_0", 2131428111);
            hashMap.put("layout/v3_layout_sport_detail_data_common_0", 2131428112);
            hashMap.put("layout/v3_pass_point_dialog_0", 2131428114);
            hashMap.put("layout/v3_pub_title_0", 2131428115);
            hashMap.put("layout/v3_rank_dialog_0", 2131428116);
        }

        private b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(62);
        f19402k0 = sparseIntArray;
        sparseIntArray.put(2131427398, 1);
        sparseIntArray.put(2131427399, 2);
        sparseIntArray.put(2131427466, 3);
        sparseIntArray.put(2131427476, 4);
        sparseIntArray.put(2131427485, 5);
        sparseIntArray.put(2131427494, 6);
        sparseIntArray.put(2131427506, 7);
        sparseIntArray.put(2131427507, 8);
        sparseIntArray.put(2131427508, 9);
        sparseIntArray.put(2131427509, 10);
        sparseIntArray.put(2131427510, 11);
        sparseIntArray.put(2131427511, 12);
        sparseIntArray.put(2131427512, 13);
        sparseIntArray.put(2131427513, 14);
        sparseIntArray.put(2131427514, 15);
        sparseIntArray.put(2131427515, 16);
        sparseIntArray.put(2131427516, 17);
        sparseIntArray.put(2131427517, 18);
        sparseIntArray.put(2131427518, 19);
        sparseIntArray.put(2131427519, 20);
        sparseIntArray.put(2131427609, 21);
        sparseIntArray.put(2131427645, 22);
        sparseIntArray.put(2131427646, 23);
        sparseIntArray.put(2131427647, 24);
        sparseIntArray.put(2131427648, 25);
        sparseIntArray.put(2131427649, 26);
        sparseIntArray.put(2131427650, 27);
        sparseIntArray.put(2131427735, 28);
        sparseIntArray.put(2131427757, 29);
        sparseIntArray.put(2131427774, 30);
        sparseIntArray.put(2131428029, 31);
        sparseIntArray.put(2131428081, 32);
        sparseIntArray.put(2131428082, 33);
        sparseIntArray.put(2131428083, 34);
        sparseIntArray.put(2131428084, 35);
        sparseIntArray.put(2131428085, 36);
        sparseIntArray.put(2131428086, 37);
        sparseIntArray.put(2131428087, 38);
        sparseIntArray.put(2131428088, 39);
        sparseIntArray.put(2131428089, 40);
        sparseIntArray.put(2131428090, 41);
        sparseIntArray.put(2131428091, 42);
        sparseIntArray.put(2131428092, 43);
        sparseIntArray.put(2131428093, 44);
        sparseIntArray.put(2131428094, 45);
        sparseIntArray.put(2131428095, 46);
        sparseIntArray.put(2131428096, 47);
        sparseIntArray.put(2131428100, 48);
        sparseIntArray.put(2131428101, 49);
        sparseIntArray.put(2131428103, 50);
        sparseIntArray.put(2131428104, 51);
        sparseIntArray.put(2131428105, 52);
        sparseIntArray.put(2131428106, 53);
        sparseIntArray.put(2131428107, 54);
        sparseIntArray.put(2131428108, 55);
        sparseIntArray.put(2131428109, 56);
        sparseIntArray.put(2131428110, 57);
        sparseIntArray.put(2131428111, 58);
        sparseIntArray.put(2131428112, 59);
        sparseIntArray.put(2131428114, 60);
        sparseIntArray.put(2131428115, 61);
        sparseIntArray.put(2131428116, 62);
    }

    private final ViewDataBinding a(DataBindingComponent component, View view, int internalId, Object tag) {
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

    private final ViewDataBinding b(DataBindingComponent component, View view, int internalId, Object tag) {
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
        return a.f19418a.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i4 = f19402k0.get(layoutId);
        if (i4 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i5 = (i4 - 1) / 50;
                if (i5 != 0) {
                    if (i5 != 1) {
                        return null;
                    }
                    return b(component, view, i4, tag);
                }
                return a(component, view, i4, tag);
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = b.f19419a.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || f19402k0.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
