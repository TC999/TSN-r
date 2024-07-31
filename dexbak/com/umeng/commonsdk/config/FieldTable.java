package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.config.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FieldTable {

    /* renamed from: a */
    public static final long f38629a = 1000;

    /* renamed from: b */
    public static final String f38630b = "_LAST_FIELD";

    /* renamed from: c */
    public static final String f38631c = "3749699455";

    /* renamed from: d */
    public static final String f38632d = "2130669566";

    /* renamed from: e */
    public static final String f38633e = "262139";

    /* renamed from: f */
    public static final String f38634f = "1983";

    /* renamed from: g */
    public static final int f38635g = 64;

    /* renamed from: l */
    private static Map<String, String[]> f38640l = new HashMap();

    /* renamed from: h */
    public static String[] f38636h = new String[EnumC13208a.values().length];

    /* renamed from: i */
    public static String[] f38637i = new String[EnumC13209b.values().length];

    /* renamed from: j */
    public static String[] f38638j = new String[EnumC13210c.values().length];

    /* renamed from: k */
    public static String[] f38639k = new String[EnumC13211d.values().length];

    /* compiled from: FieldTable.java */
    /* renamed from: com.umeng.commonsdk.config.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13208a {
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

    /* compiled from: FieldTable.java */
    /* renamed from: com.umeng.commonsdk.config.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13209b {
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

    /* compiled from: FieldTable.java */
    /* renamed from: com.umeng.commonsdk.config.d$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13210c {
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

    /* compiled from: FieldTable.java */
    /* renamed from: com.umeng.commonsdk.config.d$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13211d {
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
        String[] strArr = f38636h;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < EnumC13208a.values().length; i++) {
                f38636h[i] = EnumC13208a.values()[i].toString();
            }
            Map<String, String[]> map = f38640l;
            if (map != null) {
                map.put(EnumC13208a.class.getName(), f38636h);
            }
        }
        String[] strArr2 = f38637i;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i2 = 0; i2 < EnumC13209b.values().length; i2++) {
                f38637i[i2] = EnumC13209b.values()[i2].toString();
            }
            Map<String, String[]> map2 = f38640l;
            if (map2 != null) {
                map2.put(EnumC13209b.class.getName(), f38637i);
            }
        }
        String[] strArr3 = f38638j;
        if (strArr3 != null && strArr3.length > 0) {
            for (int i3 = 0; i3 < EnumC13210c.values().length; i3++) {
                f38638j[i3] = EnumC13210c.values()[i3].toString();
            }
            Map<String, String[]> map3 = f38640l;
            if (map3 != null) {
                map3.put(EnumC13210c.class.getName(), f38638j);
            }
        }
        String[] strArr4 = f38639k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        for (int i4 = 0; i4 < EnumC13211d.values().length; i4++) {
            f38639k[i4] = EnumC13211d.values()[i4].toString();
        }
        Map<String, String[]> map4 = f38640l;
        if (map4 != null) {
            map4.put(EnumC13211d.class.getName(), f38639k);
        }
    }

    /* renamed from: a */
    public static boolean m14020a(String str) {
        return (str == null || str.length() <= 0 || f38630b.equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: b */
    public static String[] m14019b(String str) {
        if (str == null || str.length() <= 0 || !f38640l.containsKey(str)) {
            return null;
        }
        return f38640l.get(str);
    }
}
