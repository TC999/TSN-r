package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: FieldTable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final long f53300a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static final String f53301b = "_LAST_FIELD";

    /* renamed from: c  reason: collision with root package name */
    public static final String f53302c = "3749699455";

    /* renamed from: d  reason: collision with root package name */
    public static final String f53303d = "2130669566";

    /* renamed from: e  reason: collision with root package name */
    public static final String f53304e = "262139";

    /* renamed from: f  reason: collision with root package name */
    public static final String f53305f = "1983";

    /* renamed from: g  reason: collision with root package name */
    public static final int f53306g = 64;

    /* renamed from: l  reason: collision with root package name */
    private static Map<String, String[]> f53311l = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public static String[] f53307h = new String[a.values().length];

    /* renamed from: i  reason: collision with root package name */
    public static String[] f53308i = new String[b.values().length];

    /* renamed from: j  reason: collision with root package name */
    public static String[] f53309j = new String[c.values().length];

    /* renamed from: k  reason: collision with root package name */
    public static String[] f53310k = new String[EnumC1057d.values().length];

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: FieldTable.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum a {
        header_utoken,
        header_cpu,
        header_mccmnc,
        header_sub_os_name,
        header_sub_os_version,
        header_device_type,
        header_device_id_imei,
        header_device_id_mac,
        header_device_id_android_id,
        header_device_id_serialNo,
        header_bulid,
        header_os_version,
        header_resolution,
        header_mc,
        header_timezone,
        header_local_info,
        header_carrier,
        header_access,
        header_tracking_imei,
        header_tracking_android_id,
        header_tracking_utdid,
        header_tracking_idmd5,
        header_tracking_idfa,
        header_tracking_mac,
        header_tracking_serial,
        header_tracking_uuid,
        header_tracking_uop,
        header_tracking_oldumid,
        header_tracking_newumid,
        header_ekv_send_on_exit,
        header_device_oaid,
        header_local_ip,
        header_foreground_count,
        header_first_resume,
        header_sub_os_info,
        _LAST_FIELD
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: FieldTable.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum b {
        inner_rs,
        inner_by,
        inner_gp,
        inner_to,
        inner_mo,
        inner_ca,
        inner_fl,
        inner_gdf_r,
        inner_thm_z,
        inner_dsk_s,
        inner_sd,
        inner_build,
        inner_sr,
        inner_scr,
        inner_sinfo,
        inner_winfo,
        inner_input,
        inner_bt,
        inner_mem,
        inner_cpu,
        inner_rom,
        inner_bstn,
        inner_cam,
        inner_appls,
        inner_lbs,
        internal_run_server,
        internal_imsi,
        internal_meid,
        tp_tp,
        inner_imei2,
        inner_iccid,
        inner_batt2,
        inner_build2,
        inner_cpu2,
        ccg_switch,
        check_system_app,
        check_pus_permission,
        _LAST_FIELD
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: FieldTable.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum c {
        push_cpu,
        push_imei,
        push_mac,
        push_android_id,
        push_serialNo,
        push_settings_android_id,
        push_network_access_mode,
        push_on_line,
        push_time_zone,
        push_locale_info,
        push_resolution,
        push_operator,
        push_utdid,
        push_service_work,
        push_service_name,
        push_intent_exist,
        push_data_data,
        push_notification_enabled,
        _LAST_FIELD
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: FieldTable.java */
    /* renamed from: com.umeng.commonsdk.config.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum EnumC1057d {
        share_device_id,
        share_imsi,
        share_iccid,
        share_sn,
        share_net_accmode,
        share_android_id,
        share_wifi_mac,
        share_sd_size,
        share_ssid,
        share_resolution,
        share_conn_type,
        _LAST_FIELD
    }

    static {
        String[] strArr = f53307h;
        if (strArr != null && strArr.length > 0) {
            for (int i4 = 0; i4 < a.values().length; i4++) {
                f53307h[i4] = a.values()[i4].toString();
            }
            Map<String, String[]> map = f53311l;
            if (map != null) {
                map.put(a.class.getName(), f53307h);
            }
        }
        String[] strArr2 = f53308i;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i5 = 0; i5 < b.values().length; i5++) {
                f53308i[i5] = b.values()[i5].toString();
            }
            Map<String, String[]> map2 = f53311l;
            if (map2 != null) {
                map2.put(b.class.getName(), f53308i);
            }
        }
        String[] strArr3 = f53309j;
        if (strArr3 != null && strArr3.length > 0) {
            for (int i6 = 0; i6 < c.values().length; i6++) {
                f53309j[i6] = c.values()[i6].toString();
            }
            Map<String, String[]> map3 = f53311l;
            if (map3 != null) {
                map3.put(c.class.getName(), f53309j);
            }
        }
        String[] strArr4 = f53310k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        for (int i7 = 0; i7 < EnumC1057d.values().length; i7++) {
            f53310k[i7] = EnumC1057d.values()[i7].toString();
        }
        Map<String, String[]> map4 = f53311l;
        if (map4 != null) {
            map4.put(EnumC1057d.class.getName(), f53310k);
        }
    }

    public static boolean a(String str) {
        return (str == null || str.length() <= 0 || "_LAST_FIELD".equalsIgnoreCase(str)) ? false : true;
    }

    public static String[] b(String str) {
        if (str == null || str.length() <= 0 || !f53311l.containsKey(str)) {
            return null;
        }
        return f53311l.get(str);
    }
}
