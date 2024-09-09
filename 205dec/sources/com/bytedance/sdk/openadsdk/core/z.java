package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.msdk.api.AdError;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.u.x;
import com.bytedance.sdk.openadsdk.core.u.xu;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class z implements ck<com.bytedance.sdk.openadsdk.core.a.c> {

    /* renamed from: c  reason: collision with root package name */
    private final Context f35680c;

    /* renamed from: w  reason: collision with root package name */
    private AtomicLong f35681w = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.z$18  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class AnonymousClass18 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f35701c;

        static {
            int[] iArr = new int[TTAdLoadType.values().length];
            f35701c = iArr;
            try {
                iArr[TTAdLoadType.LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35701c[TTAdLoadType.PRELOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        final int f35729c;
        public final com.bytedance.sdk.openadsdk.core.u.c ev;

        /* renamed from: f  reason: collision with root package name */
        final int f35730f;
        final String gd;

        /* renamed from: p  reason: collision with root package name */
        final ArrayList<Integer> f35731p;

        /* renamed from: r  reason: collision with root package name */
        final String f35732r;
        final int sr;
        final String ux;

        /* renamed from: w  reason: collision with root package name */
        final long f35733w;
        final long xv;

        private c(String str, int i4, int i5, String str2, int i6, String str3, com.bytedance.sdk.openadsdk.core.u.c cVar, long j4, long j5, ArrayList<Integer> arrayList) {
            this.f35729c = i4;
            this.sr = i5;
            this.ux = str2;
            this.f35732r = str3;
            this.ev = cVar;
            this.gd = str;
            this.f35730f = i6;
            this.f35733w = j4;
            this.xv = j5;
            this.f35731p = arrayList;
        }

        public static c c(JSONObject jSONObject) {
            return c(jSONObject, null, null);
        }

        public static c c(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar) {
            Object obj;
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString(ConstantAd.KEY_CACHE_AD);
            int optInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.u.c, ArrayList<Integer>> c4 = com.bytedance.sdk.openadsdk.core.w.c(jSONObject, wVar, wvVar, optLong2);
            if (c4 != null && (obj = c4.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.u.c) obj).c(jSONObject.optLong("request_after"));
            }
            if (c4 == null) {
                return new c(optString, optInt, optInt2, optString2, optInt3, optString3, null, optLong, optLong2, null);
            }
            return new c(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.u.c) c4.first, optLong, optLong2, (ArrayList) c4.second);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class sr {

        /* renamed from: c  reason: collision with root package name */
        public final int f35780c;

        /* renamed from: w  reason: collision with root package name */
        public final boolean f35781w;
        public final xu xv;

        private sr(int i4, boolean z3, xu xuVar) {
            this.f35780c = i4;
            this.f35781w = z3;
            this.xv = xuVar;
        }

        public static sr c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            xu xuVar = new xu();
            if (optJSONObject != null) {
                try {
                    xuVar.c(optJSONObject.optInt("reason"));
                    xuVar.w(optJSONObject.optInt("corp_type"));
                    xuVar.xv(optJSONObject.optInt("reward_amount"));
                    xuVar.c(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new sr(optInt, optBoolean, xuVar);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        public final int f35789c;

        /* renamed from: w  reason: collision with root package name */
        public final boolean f35790w;

        private w(int i4, boolean z3) {
            this.f35789c = i4;
            this.f35790w = z3;
        }

        public static w c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new w(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class xv {

        /* renamed from: c  reason: collision with root package name */
        public final int f35792c;

        /* renamed from: w  reason: collision with root package name */
        public final String f35793w;
        public final x xv;

        private xv(int i4, String str, x xVar) {
            this.f35792c = i4;
            this.f35793w = str;
            this.xv = xVar;
        }

        public static xv c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            x xVar = new x();
            if (optJSONObject != null) {
                try {
                    xVar.c(optJSONObject.optBoolean("is_open"));
                    xVar.c(optJSONObject.optString("req_id"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new xv(optInt, optString, xVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context) {
        this.f35680c = context;
    }

    private boolean w(int i4) {
        return i4 == 3 || i4 == 4;
    }

    private boolean w(String str) {
        if (com.bytedance.sdk.openadsdk.core.bk.w.c()) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.bk.w.c(str)) {
            String w3 = com.bytedance.sdk.openadsdk.core.bk.w.w();
            if (!TextUtils.isEmpty(w3)) {
                com.bytedance.sdk.openadsdk.core.a.xv.c(w3, System.currentTimeMillis());
            }
            return true;
        }
        return false;
    }

    public void sr(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, ck.w wVar2) {
        w(wVar, wvVar, i4, wVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    public void ux(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.core.u.wv wvVar, final int i4, ck.w wVar2) {
        final com.bytedance.sdk.openadsdk.core.c.c cVar = new com.bytedance.sdk.openadsdk.core.c.c(wVar2);
        com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("bid_p_f") { // from class: com.bytedance.sdk.openadsdk.core.z.22
            @Override // java.lang.Runnable
            public void run() {
                z.this.c(wVar, wvVar, i4, cVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void xv(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.core.u.wv wvVar, final int i4, ck.w wVar2) {
        final com.bytedance.sdk.openadsdk.core.c.c cVar = new com.bytedance.sdk.openadsdk.core.c.c(wVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("bid_g_m") { // from class: com.bytedance.sdk.openadsdk.core.z.23
                @Override // java.lang.Runnable
                public void run() {
                    z.this.c(wVar, wvVar, i4, cVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            c(wVar, wvVar, i4, cVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    private boolean sr(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        return wVar != null && wVar.gd() == 320 && wVar.ev() == 640;
    }

    private static String xv(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        String bk = k.sr().bk();
        String ls = wVar != null ? wVar.ls() : null;
        if (TextUtils.isEmpty(bk)) {
            return ls;
        }
        try {
            if (!TextUtils.isEmpty(bk) && bk.contains("game_adapter_did")) {
                bk = c(new JSONArray(bk)).toString();
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (TextUtils.isEmpty(ls)) {
            return bk;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(ls);
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString("name", null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(bk);
                int length2 = jSONArray2.length();
                for (int i5 = 0; i5 < length2; i5++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i5);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return c(jSONArray).toString();
            } catch (Throwable unused) {
                return ls;
            }
        } catch (Throwable unused2) {
            return bk;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void w(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.core.u.wv wvVar, final int i4, ck.w wVar2) {
        final com.bytedance.sdk.openadsdk.core.c.c cVar = new com.bytedance.sdk.openadsdk.core.c.c(wVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("bid_pre") { // from class: com.bytedance.sdk.openadsdk.core.z.11
                @Override // java.lang.Runnable
                public void run() {
                    z.this.c(wVar, wvVar, i4, cVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            c(wVar, wvVar, i4, cVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:1|(3:147|148|(1:150)(35:151|4|(2:8|(1:(1:11)(1:12))(1:13))|14|(2:(1:19)|(1:23))(2:141|(1:146))|24|25|(1:27)|(2:29|(1:31))(1:139)|32|(1:34)|35|(1:137)|41|(1:43)(1:136)|44|(1:46)(1:135)|47|(1:49)|50|(1:52)(1:134)|53|(10:55|(1:59)|(1:63)|64|(1:66)|67|68|(1:70)(1:74)|(1:72)|73)|75|76|(1:133)(1:80)|81|(1:83)|84|(1:86)(1:132)|87|(1:131)(1:90)|91|(4:93|(1:95)(1:129)|96|(1:98))(1:130)|(2:100|101)(3:103|(5:105|(1:107)(1:(2:123|(1:125)(1:126))(1:127))|108|(3:110|(4:113|(2:115|116)(2:118|119)|117|111)|120)|121)|128)))|3|4|(3:6|8|(0)(0))|14|(0)(0)|24|25|(0)|(0)(0)|32|(0)|35|(1:37)|137|41|(0)(0)|44|(0)(0)|47|(0)|50|(0)(0)|53|(0)|75|76|(1:78)|133|81|(0)|84|(0)(0)|87|(0)|131|91|(0)(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:102:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02c1 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:4:0x0017, B:7:0x0020, B:11:0x002e, B:13:0x0034, B:16:0x0044, B:17:0x0049, B:18:0x004d, B:22:0x0055, B:24:0x0059, B:26:0x005e, B:28:0x0066, B:53:0x00db, B:57:0x0105, B:61:0x013c, B:63:0x0149, B:64:0x014e, B:68:0x015b, B:70:0x0180, B:72:0x018a, B:74:0x0190, B:76:0x0197, B:78:0x019d, B:79:0x01a6, B:81:0x01b0, B:82:0x01bd, B:85:0x01cb, B:88:0x01e2, B:89:0x01eb, B:86:0x01d2, B:90:0x01f7, B:93:0x0224, B:95:0x0228, B:97:0x022f, B:99:0x0257, B:100:0x025c, B:104:0x027e, B:107:0x02a4, B:109:0x02b6, B:111:0x02c1, B:113:0x02e8, B:115:0x02fd, B:117:0x0301, B:120:0x030f, B:124:0x0318, B:126:0x0330, B:133:0x0346, B:136:0x0359, B:138:0x035f, B:140:0x036d, B:142:0x0385, B:141:0x0382, B:143:0x0388, B:128:0x0337, B:114:0x02f1, B:32:0x007b, B:34:0x007f, B:8:0x0023), top: B:147:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x030f A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:4:0x0017, B:7:0x0020, B:11:0x002e, B:13:0x0034, B:16:0x0044, B:17:0x0049, B:18:0x004d, B:22:0x0055, B:24:0x0059, B:26:0x005e, B:28:0x0066, B:53:0x00db, B:57:0x0105, B:61:0x013c, B:63:0x0149, B:64:0x014e, B:68:0x015b, B:70:0x0180, B:72:0x018a, B:74:0x0190, B:76:0x0197, B:78:0x019d, B:79:0x01a6, B:81:0x01b0, B:82:0x01bd, B:85:0x01cb, B:88:0x01e2, B:89:0x01eb, B:86:0x01d2, B:90:0x01f7, B:93:0x0224, B:95:0x0228, B:97:0x022f, B:99:0x0257, B:100:0x025c, B:104:0x027e, B:107:0x02a4, B:109:0x02b6, B:111:0x02c1, B:113:0x02e8, B:115:0x02fd, B:117:0x0301, B:120:0x030f, B:124:0x0318, B:126:0x0330, B:133:0x0346, B:136:0x0359, B:138:0x035f, B:140:0x036d, B:142:0x0385, B:141:0x0382, B:143:0x0388, B:128:0x0337, B:114:0x02f1, B:32:0x007b, B:34:0x007f, B:8:0x0023), top: B:147:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:4:0x0017, B:7:0x0020, B:11:0x002e, B:13:0x0034, B:16:0x0044, B:17:0x0049, B:18:0x004d, B:22:0x0055, B:24:0x0059, B:26:0x005e, B:28:0x0066, B:53:0x00db, B:57:0x0105, B:61:0x013c, B:63:0x0149, B:64:0x014e, B:68:0x015b, B:70:0x0180, B:72:0x018a, B:74:0x0190, B:76:0x0197, B:78:0x019d, B:79:0x01a6, B:81:0x01b0, B:82:0x01bd, B:85:0x01cb, B:88:0x01e2, B:89:0x01eb, B:86:0x01d2, B:90:0x01f7, B:93:0x0224, B:95:0x0228, B:97:0x022f, B:99:0x0257, B:100:0x025c, B:104:0x027e, B:107:0x02a4, B:109:0x02b6, B:111:0x02c1, B:113:0x02e8, B:115:0x02fd, B:117:0x0301, B:120:0x030f, B:124:0x0318, B:126:0x0330, B:133:0x0346, B:136:0x0359, B:138:0x035f, B:140:0x036d, B:142:0x0385, B:141:0x0382, B:143:0x0388, B:128:0x0337, B:114:0x02f1, B:32:0x007b, B:34:0x007f, B:8:0x0023), top: B:147:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009d A[Catch: all -> 0x00db, TryCatch #1 {all -> 0x00db, blocks: (B:35:0x0082, B:37:0x009d, B:39:0x00a4, B:41:0x00b2, B:43:0x00b9, B:45:0x00bf, B:46:0x00c4, B:48:0x00ca, B:50:0x00d0, B:52:0x00d6), top: B:148:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a4 A[Catch: all -> 0x00db, TryCatch #1 {all -> 0x00db, blocks: (B:35:0x0082, B:37:0x009d, B:39:0x00a4, B:41:0x00b2, B:43:0x00b9, B:45:0x00bf, B:46:0x00c4, B:48:0x00ca, B:50:0x00d0, B:52:0x00d6), top: B:148:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf A[Catch: all -> 0x00db, TryCatch #1 {all -> 0x00db, blocks: (B:35:0x0082, B:37:0x009d, B:39:0x00a4, B:41:0x00b2, B:43:0x00b9, B:45:0x00bf, B:46:0x00c4, B:48:0x00ca, B:50:0x00d0, B:52:0x00d6), top: B:148:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:4:0x0017, B:7:0x0020, B:11:0x002e, B:13:0x0034, B:16:0x0044, B:17:0x0049, B:18:0x004d, B:22:0x0055, B:24:0x0059, B:26:0x005e, B:28:0x0066, B:53:0x00db, B:57:0x0105, B:61:0x013c, B:63:0x0149, B:64:0x014e, B:68:0x015b, B:70:0x0180, B:72:0x018a, B:74:0x0190, B:76:0x0197, B:78:0x019d, B:79:0x01a6, B:81:0x01b0, B:82:0x01bd, B:85:0x01cb, B:88:0x01e2, B:89:0x01eb, B:86:0x01d2, B:90:0x01f7, B:93:0x0224, B:95:0x0228, B:97:0x022f, B:99:0x0257, B:100:0x025c, B:104:0x027e, B:107:0x02a4, B:109:0x02b6, B:111:0x02c1, B:113:0x02e8, B:115:0x02fd, B:117:0x0301, B:120:0x030f, B:124:0x0318, B:126:0x0330, B:133:0x0346, B:136:0x0359, B:138:0x035f, B:140:0x036d, B:142:0x0385, B:141:0x0382, B:143:0x0388, B:128:0x0337, B:114:0x02f1, B:32:0x007b, B:34:0x007f, B:8:0x0023), top: B:147:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0180 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:4:0x0017, B:7:0x0020, B:11:0x002e, B:13:0x0034, B:16:0x0044, B:17:0x0049, B:18:0x004d, B:22:0x0055, B:24:0x0059, B:26:0x005e, B:28:0x0066, B:53:0x00db, B:57:0x0105, B:61:0x013c, B:63:0x0149, B:64:0x014e, B:68:0x015b, B:70:0x0180, B:72:0x018a, B:74:0x0190, B:76:0x0197, B:78:0x019d, B:79:0x01a6, B:81:0x01b0, B:82:0x01bd, B:85:0x01cb, B:88:0x01e2, B:89:0x01eb, B:86:0x01d2, B:90:0x01f7, B:93:0x0224, B:95:0x0228, B:97:0x022f, B:99:0x0257, B:100:0x025c, B:104:0x027e, B:107:0x02a4, B:109:0x02b6, B:111:0x02c1, B:113:0x02e8, B:115:0x02fd, B:117:0x0301, B:120:0x030f, B:124:0x0318, B:126:0x0330, B:133:0x0346, B:136:0x0359, B:138:0x035f, B:140:0x036d, B:142:0x0385, B:141:0x0382, B:143:0x0388, B:128:0x0337, B:114:0x02f1, B:32:0x007b, B:34:0x007f, B:8:0x0023), top: B:147:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0257 A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:4:0x0017, B:7:0x0020, B:11:0x002e, B:13:0x0034, B:16:0x0044, B:17:0x0049, B:18:0x004d, B:22:0x0055, B:24:0x0059, B:26:0x005e, B:28:0x0066, B:53:0x00db, B:57:0x0105, B:61:0x013c, B:63:0x0149, B:64:0x014e, B:68:0x015b, B:70:0x0180, B:72:0x018a, B:74:0x0190, B:76:0x0197, B:78:0x019d, B:79:0x01a6, B:81:0x01b0, B:82:0x01bd, B:85:0x01cb, B:88:0x01e2, B:89:0x01eb, B:86:0x01d2, B:90:0x01f7, B:93:0x0224, B:95:0x0228, B:97:0x022f, B:99:0x0257, B:100:0x025c, B:104:0x027e, B:107:0x02a4, B:109:0x02b6, B:111:0x02c1, B:113:0x02e8, B:115:0x02fd, B:117:0x0301, B:120:0x030f, B:124:0x0318, B:126:0x0330, B:133:0x0346, B:136:0x0359, B:138:0x035f, B:140:0x036d, B:142:0x0385, B:141:0x0382, B:143:0x0388, B:128:0x0337, B:114:0x02f1, B:32:0x007b, B:34:0x007f, B:8:0x0023), top: B:147:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject c(com.bytedance.sdk.openadsdk.ys.w.xv.w r22, com.bytedance.sdk.openadsdk.core.u.wv r23, int r24, boolean r25, int r26) {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.z.c(com.bytedance.sdk.openadsdk.ys.w.xv.w, com.bytedance.sdk.openadsdk.core.u.wv, int, boolean, int):org.json.JSONObject");
    }

    private void w(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.core.u.wv wvVar, final int i4, final ck.w wVar2, String str, final int i5) {
        final com.bytedance.sdk.openadsdk.core.u.w wVar3 = new com.bytedance.sdk.openadsdk.core.u.w();
        wVar3.c(wVar);
        try {
            if (c(wVar, wVar3, wVar2, i5 == 5, wvVar, i4)) {
                return;
            }
            com.bytedance.sdk.component.ev.w.sr c4 = c(wVar, wvVar, i4, wVar2, str, i5, wVar3);
            if (c4 == null) {
                wVar3.c(-15);
                wVar2.c(-15, p.c(-15), wVar3);
                return;
            }
            c4.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.19
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar4) {
                    z.this.c(xvVar, wVar4, wVar3, wVar2, wVar, wvVar, i4, i5);
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                    z.this.c(xvVar, iOException, wVar3, wVar2);
                }
            });
            ux.c().xv();
            c();
        } catch (Throwable th) {
            c(th, wVar3, wVar2);
        }
    }

    private JSONObject w(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, List<com.bytedance.sdk.openadsdk.ys.w.w.f> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", InteractionCommon.DISLIKE_TYPE_EXECUTION);
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", eq.xv);
            com.bytedance.sdk.openadsdk.t.c.c(this.f35680c, jSONObject2);
            if (wVar != null) {
                jSONObject2.put("extra", wVar.sr());
                if (wVar.w() == null) {
                    wVar.c("other");
                }
                jSONObject2.put("dislike_source", wVar.w());
            }
            String c4 = c(list);
            if (c4 != null) {
                jSONObject2.put("comment", c4);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", w(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void xv(String str) {
        com.bytedance.sdk.component.ev.w.w xv2 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
        xv2.c(str);
        xv2.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.17
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                com.bytedance.sdk.component.utils.a.w("client bidding success", wVar.sr());
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                com.bytedance.sdk.component.utils.a.w("client bidding fail", iOException.toString());
            }
        });
    }

    private JSONArray w(List<com.bytedance.sdk.openadsdk.ys.w.w.f> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.bytedance.sdk.openadsdk.ys.w.w.f fVar : list) {
                jSONArray.put(fVar.c());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    private static String w(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        String xv2 = xv(wVar);
        Map<String, Object> t3 = k.sr().t();
        if (t3 != null && !t3.isEmpty()) {
            try {
                JSONArray jSONArray = TextUtils.isEmpty(xv2) ? new JSONArray() : new JSONArray(xv2);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    String optString = optJSONObject != null ? optJSONObject.optString("name") : "";
                    if (!TextUtils.isEmpty(optString) && t3.containsKey(optString)) {
                        t3.remove(optString);
                    }
                }
                for (Map.Entry<String, Object> entry : t3.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", entry.getKey());
                        jSONObject.put("value", entry.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
                return c(jSONArray).toString();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return xv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ok okVar, String str, String str2, final ck.xv xvVar, int i4, long j4) {
        JSONObject c4 = c(okVar, str, str2);
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        if (i4 == 1) {
            w3.c(okVar.r());
        } else {
            w3.c(okVar.c());
        }
        w3.c(c4);
        w3.sr(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.12
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, "time out!");
            }
        }, j4);
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.13
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, com.bytedance.sdk.component.ev.w wVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (wVar == null) {
                    xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                } else if (wVar.ev()) {
                    try {
                        JSONObject jSONObject = new JSONObject(wVar.sr());
                        String optString = jSONObject.optString("message");
                        int optInt = jSONObject.optInt("status", -1);
                        if (optInt != 200) {
                            xvVar.c(optInt, optString);
                            return;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            ck.xv xvVar3 = xvVar;
                            xvVar3.c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, optString + ", data is null!");
                            return;
                        }
                        xvVar.c(optJSONObject);
                    } catch (Throwable th) {
                        xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                    }
                } else {
                    xvVar.c(wVar.c(), wVar.w());
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
            }
        });
    }

    public void w(long j4, final ck.xv<JSONObject> xvVar) {
        JSONObject c4 = c(j4);
        String c5 = com.bytedance.sdk.openadsdk.core.eq.wv.c("/api/ad/union/sdk/get_dynamic_slot_info/", false);
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        w3.c(com.bytedance.sdk.openadsdk.f.sr.c(w3, c5));
        w3.c(c4);
        w3.sr(new HashMap());
        HashMap hashMap = new HashMap();
        com.bytedance.sdk.openadsdk.core.eq.me.c(hashMap);
        if (hashMap.size() > 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                w3.w((String) entry.getKey(), (String) entry.getValue());
            }
        }
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.14
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar == null) {
                    xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                } else if (wVar.ev()) {
                    try {
                        JSONObject jSONObject = new JSONObject(wVar.sr());
                        int optInt = jSONObject.optInt("cypher", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt != 3) {
                            if (optInt == -1) {
                                xvVar.c(jSONObject.optInt("code", -1), optString);
                                return;
                            }
                            xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, "decrypt failed cypher unsupport!");
                            return;
                        }
                        String xv2 = com.bytedance.sdk.component.utils.c.xv(optString);
                        if (!TextUtils.isEmpty(xv2)) {
                            xvVar.c(new JSONObject(xv2));
                            return;
                        }
                        xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, "decrypt failed!");
                    } catch (Throwable th) {
                        xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                    }
                } else {
                    xvVar.c(wVar.c(), wVar.w());
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, IOException iOException) {
                xvVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject, final ck.xv<com.bytedance.sdk.component.ev.w> xvVar) {
        String c4 = com.bytedance.sdk.openadsdk.core.eq.wv.c("/api/ad/union/sdk/apply_coupon/v2", false);
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        w3.c(c4);
        w3.c(jSONObject);
        w3.sr(new HashMap());
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.16
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, com.bytedance.sdk.component.ev.w wVar) {
                ck.xv xvVar3 = xvVar;
                if (xvVar3 != null) {
                    xvVar3.c(wVar);
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, IOException iOException) {
                ck.xv xvVar3 = xvVar;
                if (xvVar3 != null) {
                    xvVar3.c(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }

    private void c(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.u.wv wvVar) {
        JSONArray jSONArray;
        if (wvVar != null && (jSONArray = wvVar.f34864f) != null) {
            try {
                jSONObject.put("source_temai_product_ids", jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.u.w wVar, long j4, long j5, long j6, long j7) {
        if (wVar == null) {
            return;
        }
        wVar.c(j4);
        wVar.w(j6);
        wVar.xv(j5);
        wVar.sr(j7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.core.u.wv wvVar, final int i4, ck.w wVar2) {
        final com.bytedance.sdk.openadsdk.core.c.c cVar = new com.bytedance.sdk.openadsdk.core.c.c(wVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.gd.ev.ux(new com.bytedance.sdk.component.gd.p("get_ad") { // from class: com.bytedance.sdk.openadsdk.core.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.sr(wVar, wvVar, i4, cVar);
                }
            });
        } else {
            sr(wVar, wvVar, i4, cVar);
        }
    }

    public com.bytedance.sdk.openadsdk.core.ck.w c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.w wVar2, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, int i5, ck.w wVar3) {
        com.bytedance.sdk.openadsdk.core.ck.w w3;
        com.bytedance.sdk.openadsdk.tools.w.c(wVar);
        boolean z3 = i5 == 5;
        wvVar.c("buildAdBodyReady", z3);
        JSONObject c4 = c(wVar, wvVar, i4, false, i5);
        wvVar.c("doBuildAdBody", z3);
        if (c4 == null) {
            wVar2.c(-9);
            wVar3.c(-9, p.c(-9), wVar2);
            return null;
        }
        String jSONObject = c4.toString();
        if (i5 == 5) {
            long currentTimeMillis = System.currentTimeMillis();
            w3 = com.bytedance.sdk.openadsdk.core.xv.r.c().c(jSONObject);
            wvVar.c(AdLogEventRepo.COL_ENCRYPT_TYPE, System.currentTimeMillis() - currentTimeMillis, z3);
        } else {
            w3 = com.bytedance.sdk.openadsdk.core.xv.r.c().w(jSONObject);
        }
        if (w3 == null) {
            wVar2.c(-9);
            wVar3.c(-9, p.c(-9), wVar2);
            return null;
        }
        w3.c(c4);
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, ck.w wVar2, String str, int i5) {
        w(wVar, wvVar, i4, wVar2, str, i5);
    }

    private boolean c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.w wVar2, ck.w wVar3, boolean z3, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4) {
        if (wVar3 == null) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
            wVar2.c(1000);
            wVar3.c(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458", wVar2);
            return true;
        } else if (z3) {
            wvVar.c("execGetAdReady", z3);
            if (!TextUtils.isEmpty(wVar.j()) && !wvVar.ux) {
                c(wVar2, wVar, wVar3, wvVar, i4);
                com.bytedance.sdk.openadsdk.core.fz.w.c();
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (w(wVar.f())) {
                wVar2.c(-8);
                wVar3.c(-8, p.c(-8), wVar2);
                com.bytedance.sdk.openadsdk.core.fz.w.c();
                return true;
            }
            wvVar.c("checkCallFreq", System.currentTimeMillis() - currentTimeMillis, z3);
            return false;
        } else {
            return false;
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.u.w wVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar2, final ck.w wVar3, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4) {
        wVar.w(2);
        wVar.c(wVar2.j());
        try {
            boolean z3 = false;
            JSONObject c4 = com.bytedance.sdk.openadsdk.core.xv.r.c(new JSONObject(wVar2.j()), false, true);
            if (c4 == null) {
                c(wVar3, wVar);
                return;
            }
            c c5 = c.c(c4, wVar2, wvVar);
            wVar.c(c5.f35731p);
            i.c(c5.gd);
            int i5 = c5.sr;
            if (i5 != 20000) {
                wVar.c(i5);
                wVar3.c(c5.sr, "reason: " + c5.f35730f + "  message: " + c5.ux, wVar);
                return;
            }
            com.bytedance.sdk.openadsdk.core.u.c cVar = c5.ev;
            if (cVar == null) {
                c(wVar3, wVar);
                return;
            }
            cVar.xv(c4.toString());
            List<com.bytedance.sdk.openadsdk.core.u.me> w3 = c5.ev.w();
            if (w3 != null) {
                List<com.bytedance.sdk.openadsdk.core.u.me> arrayList = new ArrayList<>(w3);
                for (com.bytedance.sdk.openadsdk.core.u.me meVar : w3) {
                    com.bytedance.sdk.openadsdk.core.u.me c6 = com.bytedance.sdk.openadsdk.core.eq.ux.c(meVar.u(), i4);
                    if (c6 != null) {
                        arrayList.remove(meVar);
                        c6.n(meVar.iu());
                        arrayList.add(c6);
                    } else if (meVar.i()) {
                        ls.c().xv(wVar2, wvVar, i4, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.z.20
                            @Override // com.bytedance.sdk.openadsdk.core.ck.w
                            public void c(int i6, String str, com.bytedance.sdk.openadsdk.core.u.w wVar4) {
                                com.bytedance.sdk.openadsdk.core.fz.a.c().w(i6);
                                wVar3.c(i6, str, wVar4);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.ck.w
                            public void c(com.bytedance.sdk.openadsdk.core.u.c cVar2, com.bytedance.sdk.openadsdk.core.u.w wVar4) {
                                com.bytedance.sdk.openadsdk.core.fz.a.c().w(0);
                                wVar3.c(cVar2, wVar4);
                            }
                        });
                        z3 = true;
                    }
                }
                if (z3) {
                    return;
                }
                c5.ev.c(arrayList);
            }
            wVar3.c(c5.ev, wVar);
            for (com.bytedance.sdk.openadsdk.core.u.me meVar2 : w3) {
                com.bytedance.sdk.openadsdk.core.playable.ux.c().w(this.f35680c, meVar2);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.xv(EventNetApiImpl.TAG, "get ad error: ", th);
            c(wVar3, wVar);
        }
    }

    private com.bytedance.sdk.component.ev.w.sr c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4, ck.w wVar2, String str, int i5, com.bytedance.sdk.openadsdk.core.u.w wVar3) throws JSONException {
        byte[] bytes;
        Map<String, String> c4;
        com.bytedance.sdk.openadsdk.core.ck.w c5 = c(wVar, wVar3, wvVar, i4, i5, wVar2);
        if (c5 == null) {
            return null;
        }
        String c6 = com.bytedance.sdk.openadsdk.core.eq.wv.c(str, true);
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        String c7 = com.bytedance.sdk.openadsdk.f.sr.c(w3, c6);
        w3.c(c7);
        com.bytedance.sdk.openadsdk.f.sr.c(c5);
        if (i5 == 5) {
            if (c5.sr() != null) {
                JSONObject sr2 = c5.sr();
                w3.c(sr2);
                bytes = sr2.toString().getBytes(StandardCharsets.UTF_8);
                w3.c(false);
            } else if (c5.xv() == null) {
                return null;
            } else {
                bytes = c5.xv();
                w3.c("application/octet-stream", bytes);
                w3.c(true);
            }
        } else {
            JSONObject sr3 = c5.sr();
            w3.c(sr3);
            bytes = sr3.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z3 = i5 == 5;
        wvVar.c("doHttpReqSignReady", z3);
        com.bytedance.sdk.openadsdk.c.c.c c8 = com.bytedance.sdk.openadsdk.c.c.c.c(k.sr().ev(), k.sr().ux());
        wvVar.c("MSInst", z3);
        Map<String, String> c9 = c8.c(c7, bytes);
        wvVar.c("doHttpReqSign", z3);
        if (c9 == null) {
            c9 = new HashMap<>();
        }
        if (i5 == 5 && (c4 = com.bytedance.sdk.openadsdk.tools.w.c(wVar.f())) != null) {
            c9.putAll(c4);
        }
        com.bytedance.sdk.openadsdk.core.eq.me.c(c9);
        Map<String, String> ux = c5.ux();
        w3.w("User-Agent", com.bytedance.sdk.openadsdk.core.eq.wv.f());
        if (ux != null) {
            c9.putAll(ux);
        }
        if (c9.size() > 0) {
            for (Map.Entry<String, String> entry : c9.entrySet()) {
                w3.w(entry.getKey(), entry.getValue());
            }
        }
        w3.sr(c(bytes, ux, c5));
        wvVar.c("appendHeader", z3);
        return w3;
    }

    private Map<String, Object> c(byte[] bArr, Map<String, String> map, com.bytedance.sdk.openadsdk.core.ck.w wVar) {
        HashMap hashMap = new HashMap();
        try {
            com.bytedance.sdk.openadsdk.core.ck.c cVar = new com.bytedance.sdk.openadsdk.core.ck.c();
            cVar.ev(System.currentTimeMillis());
            cVar.gd(bArr == null ? 0L : bArr.length);
            cVar.xv(wVar.w());
            if (map != null) {
                cVar.c(map.get("x-pglcypher"));
            }
            cVar.c(wVar.c());
            cVar.w(com.bytedance.sdk.component.panglearmor.ev.w() ? 1 : 2);
            cVar.c(ls.w().ta());
            hashMap.put("load_time_model", cVar);
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f35681w.get() >= PolicyConfig.mServerBusyRetryBaseInternal) {
            this.f35681w.set(currentTimeMillis);
            com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.21
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.z.ux.c((com.bytedance.sdk.openadsdk.core.z.sr) null).sr();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException, com.bytedance.sdk.openadsdk.core.u.w wVar, ck.w wVar2) {
        com.bytedance.sdk.openadsdk.core.fz.w.c();
        if (iOException != null) {
            wVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN);
            wVar2.c(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, iOException.getMessage(), wVar);
            com.bytedance.sdk.component.utils.a.w(EventNetApiImpl.TAG, "onFailure: ", Integer.valueOf((int) MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE));
        }
    }

    private void c(Throwable th, com.bytedance.sdk.openadsdk.core.u.w wVar, ck.w wVar2) {
        if (wVar2 != null) {
            wVar.c(4000);
            wVar2.c(4000, th.getMessage(), wVar);
            com.bytedance.sdk.component.utils.a.sr(EventNetApiImpl.TAG, " msg = ", th.getMessage());
        }
    }

    private void c(com.bytedance.sdk.component.ev.w wVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar2, int i4, com.bytedance.sdk.openadsdk.core.u.wv wvVar, ck.w wVar3, com.bytedance.sdk.openadsdk.core.u.w wVar4, com.bytedance.sdk.component.ev.w.xv xvVar) {
        c cVar;
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        z zVar = this;
        com.bytedance.sdk.openadsdk.core.u.wv wvVar2 = wvVar;
        if (wVar != null) {
            if (wVar.ev()) {
                try {
                    com.bytedance.sdk.openadsdk.core.ck.c c4 = zVar.c(xvVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    String sr2 = wVar.sr();
                    wVar4.c(sr2);
                    LogAdapter logAdapter = LogAdapter.sAdapter;
                    if (logAdapter != null) {
                        logAdapter.w(EventNetApiImpl.TAG, "response:");
                        LogAdapter.sAdapter.w(EventNetApiImpl.TAG, sr2);
                    }
                    JSONObject jSONObject3 = new JSONObject(sr2);
                    int optInt = jSONObject3.optInt("status_code");
                    String optString = new JSONObject(wVar2.j()).optString("auction_price");
                    int i5 = 20000;
                    try {
                        if (optInt != 20000) {
                            if (optInt == 40046) {
                                wVar4.c(optInt);
                                wVar3.c(AdError.ERROR_CODE_ADN_SHOW_FAIL, p.c(optInt), wVar4);
                                return;
                            }
                            return;
                        }
                        JSONObject optJSONObject = jSONObject3.optJSONObject("adms");
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject4 = new JSONObject(optJSONObject.optString(keys.next()));
                            jSONObject4.put("auction_price", optString);
                            JSONObject c5 = com.bytedance.sdk.openadsdk.core.xv.r.c(jSONObject4, false, true);
                            if (c5 == null) {
                                c(wVar3, wVar4);
                                return;
                            }
                            c c6 = c.c(c5, wVar2, wvVar2);
                            wVar4.c(c6.f35731p);
                            int i6 = c6.sr;
                            if (i6 != i5) {
                                wVar4.c(i6);
                                wVar3.c(c6.sr, "reason: " + c6.f35730f + "  message: " + c6.ux, wVar4);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.u.c cVar2 = c6.ev;
                            if (cVar2 == null) {
                                c(wVar3, wVar4);
                                return;
                            }
                            cVar2.xv(c5.toString());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (wvVar2 != null) {
                                try {
                                    cVar = c6;
                                    str = optString;
                                    jSONObject = optJSONObject;
                                    jSONObject2 = c5;
                                    c(wVar4, c4.gd() - wvVar2.ev, c6.f35729c, currentTimeMillis - c4.gd(), currentTimeMillis2 - currentTimeMillis);
                                } catch (Throwable th) {
                                    th = th;
                                    com.bytedance.sdk.component.utils.a.xv(EventNetApiImpl.TAG, "get ad error: ", th);
                                    c(wVar3, wVar4);
                                    return;
                                }
                            } else {
                                cVar = c6;
                                jSONObject = optJSONObject;
                                jSONObject2 = c5;
                                str = optString;
                            }
                            wVar3.c(cVar.ev, wVar4);
                            Map<String, com.bytedance.sdk.openadsdk.core.u.me> c7 = com.bytedance.sdk.openadsdk.core.u.c.c(cVar.ev);
                            if (c7 != null) {
                                com.bytedance.sdk.openadsdk.core.t.c.c().c(c7);
                            }
                            for (com.bytedance.sdk.openadsdk.core.u.me meVar : cVar.ev.w()) {
                                com.bytedance.sdk.openadsdk.core.playable.ux.c().w(this.f35680c, meVar);
                            }
                            com.bytedance.sdk.openadsdk.w.w.c().c(jSONObject2);
                            optJSONObject = jSONObject;
                            wvVar2 = wvVar;
                            zVar = this;
                            optString = str;
                            i5 = 20000;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                int c8 = wVar.c();
                String w3 = wVar.w();
                wVar4.c(c8);
                wVar3.c(c8, w3, wVar4);
            }
        }
    }

    private void c(com.bytedance.sdk.component.ev.w wVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar2, int i4, com.bytedance.sdk.openadsdk.core.u.wv wvVar, ck.w wVar3, com.bytedance.sdk.openadsdk.core.u.w wVar4) {
        if (wVar != null) {
            try {
                JSONArray optJSONArray = new JSONObject(wVar.sr()).optJSONArray(CampaignUnit.JSON_KEY_ADS);
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    if (wVar3 != null) {
                        wVar3.c(-9, p.c(-9), wVar4);
                        return;
                    }
                    return;
                }
                int i5 = ls.w().i();
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject = optJSONArray.getJSONObject(i6).optJSONObject("creative");
                    if (optJSONObject != null) {
                        JSONObject c4 = com.bytedance.sdk.openadsdk.core.xv.r.c(new JSONObject(optJSONObject.optString("adm")), false, true);
                        if (c4 == null && wVar3 != null) {
                            wVar3.c(-9, p.c(-9), wVar4);
                        } else {
                            c c5 = c.c(c4, wVar2, wvVar);
                            com.bytedance.sdk.openadsdk.core.eq.ux.c(c5.ev, i4, i5);
                            if (wVar3 != null) {
                                wVar3.c(c5.ev, wVar4);
                            }
                        }
                    } else if (wVar3 != null) {
                        wVar3.c(-9, p.c(-9), wVar4);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (wVar3 != null) {
                    wVar3.c(-9, p.c(-9), wVar4);
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.ck.c c(com.bytedance.sdk.component.ev.w.xv xvVar) {
        try {
            Object obj = xvVar.xv().get("load_time_model");
            if (obj instanceof com.bytedance.sdk.openadsdk.core.ck.c) {
                com.bytedance.sdk.openadsdk.core.ck.c cVar = (com.bytedance.sdk.openadsdk.core.ck.c) obj;
                cVar.xv(true);
                return cVar;
            }
        } catch (Throwable unused) {
        }
        return new com.bytedance.sdk.openadsdk.core.ck.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0236 A[Catch: all -> 0x0261, TryCatch #0 {all -> 0x0261, blocks: (B:59:0x018e, B:61:0x019c, B:63:0x01a9, B:64:0x01b0, B:65:0x01ba, B:67:0x01c0, B:68:0x01d5, B:70:0x01db, B:72:0x01e3, B:74:0x01ef, B:78:0x020e, B:84:0x0219, B:86:0x0236, B:87:0x024f, B:88:0x0254), top: B:96:0x018e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.bytedance.sdk.component.ev.w.xv r27, com.bytedance.sdk.component.ev.w r28, com.bytedance.sdk.openadsdk.core.u.w r29, com.bytedance.sdk.openadsdk.core.ck.w r30, com.bytedance.sdk.openadsdk.ys.w.xv.w r31, com.bytedance.sdk.openadsdk.core.u.wv r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.z.c(com.bytedance.sdk.component.ev.w.xv, com.bytedance.sdk.component.ev.w, com.bytedance.sdk.openadsdk.core.u.w, com.bytedance.sdk.openadsdk.core.ck$w, com.bytedance.sdk.openadsdk.ys.w.xv.w, com.bytedance.sdk.openadsdk.core.u.wv, int, int):void");
    }

    private void c(com.bytedance.sdk.openadsdk.core.u.wv wvVar, com.bytedance.sdk.openadsdk.core.u.me meVar, String str, com.bytedance.sdk.openadsdk.core.ck.c cVar) {
        long j4;
        long j5;
        if (ls.w().mt() && cVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (wvVar != null) {
                try {
                    if (wvVar.ev > 0) {
                        jSONObject.put("client_start_time", cVar.gd() - wvVar.ev);
                        j4 = cVar.w() - wvVar.ev;
                    } else {
                        j4 = 0;
                    }
                    if (wvVar.gd > 0) {
                        jSONObject.put("real_user_duration", cVar.w() - wvVar.gd);
                        jSONObject.put("switch_st1_time", wvVar.ev - wvVar.gd);
                    }
                    j5 = j4;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j5 = 0;
            }
            jSONObject.put("net_send_time", cVar.ux() - cVar.gd());
            jSONObject.put("net_rcv_time", cVar.sr() - cVar.ux());
            jSONObject.put("net_callback_time", cVar.f() - cVar.sr());
            jSONObject.put("network_time", cVar.f() - cVar.gd());
            jSONObject.put("sever_time", cVar.c());
            jSONObject.put("client_end_time", cVar.w() - cVar.f());
            if (cVar.p() > 0) {
                jSONObject.put("req_body_length", cVar.p());
            }
            if (cVar.ev() > 0) {
                jSONObject.put("res_body_length", cVar.ev());
            }
            if (!TextUtils.isEmpty(cVar.k())) {
                jSONObject.put("x-pglcypher", cVar.k());
            }
            jSONObject.put("cypher_v", cVar.s());
            jSONObject.put("armor_s", cVar.fz());
            long xv2 = cVar.xv();
            if (xv2 > 0) {
                jSONObject.put("raw_req_length", xv2);
            }
            int i4 = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.bytedance.sdk.openadsdk.core.xv.sr.c().f());
            jSONObject.put("has_base64", cVar.r() ? 1 : 2);
            jSONObject.put("req_build_opt", com.bytedance.sdk.openadsdk.core.xv.sr.c().r());
            if (!eq.f33187c) {
                i4 = 0;
            }
            jSONObject.put("is_boost", i4);
            if (cVar.fp() > 0) {
                jSONObject.put("net_whqueue", cVar.t() - cVar.bk());
                jSONObject.put("net_wtqueue", cVar.ys() - cVar.t());
                jSONObject.put("net_oconn", cVar.ia() - cVar.fp());
                jSONObject.put("net_bconn", cVar.fp() - cVar.ys());
            }
            try {
                JSONObject c4 = wvVar.ys.c(-1L);
                Iterator<String> keys = c4.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, c4.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, str, "load_ad_time", j5, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(com.bytedance.sdk.openadsdk.core.dislike.xv.w wVar, List<com.bytedance.sdk.openadsdk.ys.w.w.f> list) {
        JSONObject w3;
        if (com.bytedance.sdk.openadsdk.core.z.f.c() && (w3 = w(wVar, list)) != null) {
            com.bytedance.sdk.openadsdk.core.eq.wx wxVar = new com.bytedance.sdk.openadsdk.core.eq.wx(com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux());
            wxVar.c(com.bytedance.sdk.openadsdk.core.eq.wv.r("/api/ad/union/dislike_event/"));
            wxVar.w(w3, InteractionCommon.DISLIKE_TYPE_EXECUTION);
            wxVar.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.25
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar2) {
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                }
            });
        }
    }

    private String c(List<com.bytedance.sdk.openadsdk.ys.w.w.f> list) {
        if (list.get(0).c().equals("0:00")) {
            return list.get(0).w();
        }
        return null;
    }

    public static void c(ck.w wVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
        wVar2.c(-1);
        wVar.c(-1, p.c(-1), wVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ck.ux uxVar) {
        uxVar.c(-1, p.c(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ck.sr srVar) {
        srVar.c(-1, p.c(-1));
    }

    private JSONObject c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, int i4) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject, "keywords", k.sr().k());
            jSONObject.put("protection_of_minors", k.sr().n());
            if (!com.bytedance.sdk.openadsdk.core.xv.ux.c().k(i4)) {
                com.bytedance.sdk.openadsdk.t.c.sr(this.f35680c, jSONObject);
            }
            String w3 = w(wVar);
            String w4 = com.bytedance.sdk.openadsdk.core.xv.ux.c().w(wVar.f(), "");
            if (!TextUtils.isEmpty(w4)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("name", "dynamic_slot_ab_extra");
                jSONObject2.putOpt("value", w4);
                if (TextUtils.isEmpty(w3)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(w3);
                }
                jSONArray.put(jSONObject2);
                String jSONArray2 = jSONArray.toString();
                if (!TextUtils.equals("[]", jSONArray2)) {
                    c(jSONObject, "data", jSONArray2);
                }
            } else if (!TextUtils.equals("[]", w3)) {
                c(jSONObject, "data", w3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray c(JSONArray jSONArray) throws JSONException {
        if (eq.sr() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                if (jSONObject2 != null) {
                    String optString = jSONObject2.optString("name", null);
                    if (!"device_id".equals(optString)) {
                        if ("game_adapter_did".equals(optString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put("name", "device_id");
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, int i4, com.bytedance.sdk.openadsdk.core.u.wv wvVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", wVar.f());
            jSONObject.put("prime_rit", wVar.i());
            jSONObject.put("show_seq", wVar.u());
            jSONObject.put("adtype", i4);
            jSONObject.put("themeStatus", k.sr().me());
            jSONObject.put("download_type", 0);
            if (!TextUtils.isEmpty(wVar.xv()) || !TextUtils.isEmpty(wVar.sr()) || !TextUtils.isEmpty(wVar.ux()) || com.bytedance.sdk.openadsdk.tools.w.c()) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(wVar.xv())) {
                    jSONObject2.put("ad_id", wVar.xv());
                }
                if (!TextUtils.isEmpty(wVar.sr())) {
                    jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, wVar.sr());
                }
                if (wVar.ux() != null) {
                    jSONObject2.put("ext", wVar.ux());
                }
                com.bytedance.sdk.openadsdk.tools.w.c(jSONObject2, wVar.f());
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (i4 == 3 || i4 == 4) {
                if (wvVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", wvVar.f34866p);
                    jSONObject3.put("time_out_control", wvVar.f34865k);
                    jSONObject3.put("time_out", wvVar.f34862a);
                    jSONObject.put("tmax", jSONObject3);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (wvVar != null) {
                jSONObject.put("render_method", wvVar.f34867r);
                int i5 = wvVar.f34867r;
                if (i5 == 1) {
                    if (sr(wVar)) {
                        c(i4, jSONObject);
                    } else {
                        c(jSONObject, "accepted_size", wVar.ev(), wVar.gd());
                    }
                } else if (i5 == 2) {
                    if (wVar.p() > 0.0f && wVar.k() > 0.0f) {
                        c(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.eq.xk.xv(this.f35680c, wVar.p()), com.bytedance.sdk.openadsdk.core.eq.xk.xv(this.f35680c, wVar.k()));
                    }
                    if (sr(wVar)) {
                        c(i4, jSONObject);
                    } else {
                        c(jSONObject, "accepted_size", wVar.ev(), wVar.gd());
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                c(jSONObject, "accepted_size", wVar.ev(), wVar.gd());
            }
            jSONObject.put("ptpl_ids", com.bytedance.sdk.openadsdk.core.xv.w.c().c(wVar.f(), i4));
            jSONObject.put("pos", com.bytedance.sdk.openadsdk.core.eq.wv.ux(i4));
            jSONObject.put("is_support_dpl", wVar.a());
            jSONObject.put("if_support_render_control", wVar.bk() ? 1 : 0);
            jSONObject.put("support_icon_style", (eq.f33190w < 5900 || !wVar.z()) ? 0 : 1);
            if (i4 == 3 || i4 == 4) {
                jSONObject.put("splash_load_type", ls.w().gd(com.bytedance.sdk.openadsdk.core.eq.wv.c(wVar)));
            }
            if (i4 == 1 || i4 == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (wvVar != null && (obj = wvVar.bk) != null) {
                jSONObject.put("session_params", obj);
            }
            int t3 = wVar.t();
            if (i4 == 7) {
                t3 = 1;
            }
            if (i4 == 8) {
                boolean ia = ls.w().ia(wVar.f());
                boolean c4 = com.bytedance.sdk.openadsdk.core.bk.sr.c(wVar.f());
                if (!ia) {
                    jSONObject.put("refresh_control", 0);
                } else if (c4) {
                    jSONObject.put("refresh_control", 0);
                    com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.2
                        @Override // com.bytedance.sdk.openadsdk.p.c.c
                        public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put(BidResponsedEx.KEY_CID, "");
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                            return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("refresh_max").w(jSONObject4.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    t3 = ls.w().e();
                }
                t3 = 1;
            }
            if (wvVar != null && wvVar.f34864f != null) {
                t3 = wVar.t();
            }
            jSONObject.put("ad_count", t3);
            int c5 = com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.ux.c(wVar);
            if (c5 == 1) {
                jSONObject.put("group_load_more", c5);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void c(int i4, JSONObject jSONObject) {
        if (w(i4)) {
            c(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.eq.xk.sr(this.f35680c), com.bytedance.sdk.openadsdk.core.eq.xk.ux(this.f35680c));
        } else {
            c(jSONObject, "accepted_size", 640, 320);
        }
    }

    private void c(JSONObject jSONObject, String str, int i4, int i5) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i4 > 0 && i5 > 0) {
                jSONObject2.put("width", i4);
                jSONObject2.put("height", i5);
            } else {
                jSONObject2.put("width", 640);
                jSONObject2.put("height", 320);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, String str, float f4, float f5) {
        if (f4 <= 0.0f || f5 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f4);
            jSONObject2.put("height", (int) f5);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(JSONObject jSONObject, final ck.ux uxVar) {
        if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
            if (uxVar != null) {
                uxVar.c(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
            }
        } else if (jSONObject == null || uxVar == null) {
        } else {
            com.bytedance.sdk.openadsdk.core.eq.wx wxVar = new com.bytedance.sdk.openadsdk.core.eq.wx(com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux());
            wxVar.c(com.bytedance.sdk.openadsdk.core.eq.wv.r("/api/ad/union/sdk/reward_video/reward/"));
            wxVar.w(jSONObject, "verify");
            wxVar.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.3
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                    if (wVar != null) {
                        if (wVar.ev()) {
                            try {
                                Object obj = com.bytedance.sdk.openadsdk.core.xv.r.c(wVar, "verify", false).second;
                                sr c4 = sr.c(obj != null ? (JSONObject) obj : new JSONObject(wVar.sr()));
                                int i4 = c4.f35780c;
                                if (i4 != 20000) {
                                    uxVar.c(i4, p.c(i4));
                                    return;
                                } else if (c4.xv == null) {
                                    z.this.c(uxVar);
                                    return;
                                } else {
                                    uxVar.c(c4);
                                    return;
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                z.this.c(uxVar);
                                return;
                            }
                        }
                        String c5 = p.c(-2);
                        int c6 = wVar.c();
                        if (!wVar.ev() && !TextUtils.isEmpty(wVar.w())) {
                            c5 = wVar.w();
                        }
                        uxVar.c(c6, c5);
                        return;
                    }
                    z.this.c(uxVar);
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                    uxVar.c(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(JSONObject jSONObject, final ck.sr srVar) {
        if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
            if (srVar != null) {
                srVar.c(1000, "\u5e7f\u544a\u8bf7\u6c42\u5f00\u5173\u5df2\u5173\u95ed,\u8bf7\u8054\u7cfb\u7a7f\u5c71\u7532\u7ba1\u7406\u5458");
            }
        } else if (jSONObject == null || srVar == null) {
        } else {
            JSONObject c4 = com.bytedance.sdk.component.utils.c.c(jSONObject);
            com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
            w3.c(com.bytedance.sdk.openadsdk.core.eq.wv.r("/api/ad/union/sdk/reward_video/live_room/reward"));
            w3.xv(c4.toString());
            w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.4
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                    if (wVar != null) {
                        if (wVar.ev() && !TextUtils.isEmpty(wVar.sr())) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(wVar.sr());
                                String xv2 = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.c.xv(jSONObject2.optString("message")) : null;
                                if (!TextUtils.isEmpty(xv2)) {
                                    try {
                                        jSONObject2 = new JSONObject(xv2);
                                    } catch (Throwable unused) {
                                    }
                                }
                                xv c5 = xv.c(jSONObject2);
                                int i4 = c5.f35792c;
                                if (i4 != 20000) {
                                    srVar.c(i4, p.c(i4));
                                    return;
                                } else if (c5.xv == null) {
                                    z.this.c(srVar);
                                    return;
                                } else {
                                    srVar.c(c5);
                                    return;
                                }
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                                z.this.c(srVar);
                                return;
                            }
                        }
                        String c6 = p.c(-2);
                        int c7 = wVar.c();
                        if (!wVar.ev() && !TextUtils.isEmpty(wVar.w())) {
                            c6 = wVar.w();
                        }
                        srVar.c(c7, c6);
                        return;
                    }
                    z.this.c(srVar);
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                    srVar.c(-2, iOException.getMessage());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d3  */
    @Override // com.bytedance.sdk.openadsdk.core.ck
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(com.bytedance.sdk.openadsdk.ys.w.xv.w r12, boolean r13, int r14) {
        /*
            r11 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.u.wv r7 = new com.bytedance.sdk.openadsdk.core.u.wv
            r7.<init>()
            com.bytedance.sdk.openadsdk.core.n r8 = r7.ys
            int r1 = r12.q()
            r9 = 3
            if (r9 != r1) goto L19
            long r1 = java.lang.System.currentTimeMillis()
            r7.ev = r1
        L19:
            r1 = 2
            if (r13 == 0) goto L1e
            r7.f34867r = r1
        L1e:
            int r13 = r12.s()
            r10 = 1
            if (r10 == r13) goto L2b
            int r13 = r12.s()
            if (r1 != r13) goto L2d
        L2b:
            r7.f34867r = r1
        L2d:
            int r13 = r7.f34867r
            if (r13 == r1) goto L41
            com.bytedance.sdk.openadsdk.core.z.r r13 = com.bytedance.sdk.openadsdk.core.ls.w()
            java.lang.String r2 = r12.f()
            boolean r13 = r13.bk(r2)
            if (r13 == 0) goto L41
            r7.f34867r = r1
        L41:
            r13 = 0
            int r1 = r12.q()
            if (r1 <= 0) goto L4d
            int r13 = r12.q()
            goto L50
        L4d:
            if (r14 <= 0) goto L50
            r13 = r14
        L50:
            r5 = 1
            r6 = 4
            r1 = r11
            r2 = r12
            r3 = r7
            r4 = r13
            org.json.JSONObject r1 = r1.c(r2, r3, r4, r5, r6)
            java.lang.String r2 = "adbody_time"
            r8.w(r2)
            r11.c(r12, r7, r13)
            java.lang.String r12 = "prefetch_time"
            r8.w(r12)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r13 = "User-Agent"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.eq.wv.f()     // Catch: java.lang.Exception -> L85
            r12.putOpt(r13, r2)     // Catch: java.lang.Exception -> L85
            java.lang.String r13 = "request_headers_time"
            r8.w(r13)     // Catch: java.lang.Exception -> L85
            java.lang.String r13 = "header"
            r0.putOpt(r13, r12)     // Catch: java.lang.Exception -> L85
            java.lang.String r12 = "bid_request"
            r0.putOpt(r12, r1)     // Catch: java.lang.Exception -> L85
            goto L89
        L85:
            r12 = move-exception
            r12.printStackTrace()
        L89:
            java.lang.String r12 = r0.toString()
            com.bytedance.sdk.openadsdk.core.xv.r r13 = com.bytedance.sdk.openadsdk.core.xv.r.c()
            android.util.Pair r12 = r13.c(r12, r10)
            java.lang.String r13 = "encry_time"
            r8.w(r13)
            com.bytedance.sdk.openadsdk.core.fz.a r13 = com.bytedance.sdk.openadsdk.core.fz.a.c()     // Catch: java.lang.Throwable -> La2
            r13.c(r14, r8)     // Catch: java.lang.Throwable -> La2
            goto La3
        La2:
        La3:
            java.lang.String r13 = ""
            if (r12 == 0) goto Lbe
            java.lang.Object r14 = r12.second
            if (r14 == 0) goto Lb3
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            java.lang.String r13 = "message"
            java.lang.String r13 = r14.optString(r13)
        Lb3:
            java.lang.Object r12 = r12.first
            if (r12 == 0) goto Lbe
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            goto Lbf
        Lbe:
            r12 = 3
        Lbf:
            if (r12 == r9) goto Ld3
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "0000000004"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            return r12
        Ld3:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "0000000003"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.z.c(com.bytedance.sdk.openadsdk.ys.w.xv.w, boolean, int):java.lang.String");
    }

    private boolean c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, com.bytedance.sdk.openadsdk.core.u.wv wvVar, int i4) {
        boolean c4 = ls.w().c(wVar.f());
        if (c4) {
            ux(wVar, wvVar, i4, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.z.5
                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(int i5, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(i5);
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.w
                public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(0);
                }
            });
        }
        return c4;
    }

    private void c(JSONObject jSONObject, String str, int i4) throws Exception {
        String w3;
        if (i4 == 7) {
            w3 = com.bytedance.sdk.openadsdk.core.component.reward.r.c(ls.getContext(), true).w(str);
        } else if (i4 != 8) {
            return;
        } else {
            w3 = com.bytedance.sdk.openadsdk.core.component.reward.r.c(ls.getContext(), false).w(str);
        }
        String str2 = "1";
        String str3 = "0";
        if (w3 != null && !TextUtils.isEmpty(w3)) {
            if (TextUtils.equals(w3, "0")) {
                str2 = "0";
            } else if (!TextUtils.equals(w3, "1")) {
                JSONObject jSONObject2 = new JSONObject(w3);
                jSONObject.putOpt("cache_info", jSONObject2);
                str3 = jSONObject2.optString("req_id");
            }
            com.bytedance.sdk.openadsdk.core.fz.a.c().c(str, str3, str2, false);
        }
        str2 = null;
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(str, str3, str2, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public String c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        return c(wVar, false, -1);
    }

    private JSONObject c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String w3 = com.bytedance.sdk.component.utils.c.w(str);
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            String upperCase = com.bytedance.sdk.component.utils.ux.w("id=" + w3 + "&timestamp=" + currentTimeMillis + "&ext=" + str2).toUpperCase();
            jSONObject.put("id", w3);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(String str, String str2, final ck.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.z.f.c()) {
            if (cVar != null) {
                cVar.c(false, -1L, 0L);
            }
        } else if (str == null || str2 == null || cVar == null) {
        } else {
            JSONObject c4 = c(str, str2);
            com.bytedance.sdk.openadsdk.core.eq.wx wxVar = new com.bytedance.sdk.openadsdk.core.eq.wx(com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux());
            wxVar.c(com.bytedance.sdk.openadsdk.core.eq.wv.r("/api/ad/union/sdk/material/check/"));
            wxVar.w(c4, "check_ad");
            wxVar.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.6
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                    boolean z3;
                    long j4;
                    long j5;
                    if (wVar != null) {
                        if (wVar.ev()) {
                            long j6 = 0;
                            if (wVar.sr() != null) {
                                try {
                                    w c5 = w.c(new JSONObject(wVar.sr()));
                                    r0 = c5.f35789c;
                                    j6 = wVar.gd();
                                    z3 = c5.f35790w;
                                    j4 = r0;
                                    j5 = j6;
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                                cVar.c(z3, j4, j5);
                                return;
                            }
                            j4 = r0;
                            j5 = j6;
                            z3 = false;
                            cVar.c(z3, j4, j5);
                            return;
                        }
                        cVar.c(false, wVar.c() != 0 ? wVar.c() : -1L, wVar.gd());
                    }
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                    cVar.c(false, 0L, 0L);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public com.bytedance.sdk.component.adexpress.c.xv.c c(int i4) {
        String oh;
        com.bytedance.sdk.component.adexpress.c.xv.c sr2;
        if (com.bytedance.sdk.openadsdk.core.z.f.c()) {
            if (i4 == 2) {
                oh = ls.w().fm();
            } else {
                oh = ls.w().oh();
            }
            if (TextUtils.isEmpty(oh)) {
                return null;
            }
            com.bytedance.sdk.component.ev.w.w xv2 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
            xv2.c(com.bytedance.sdk.openadsdk.core.eq.me.w(oh));
            com.bytedance.sdk.component.ev.w c4 = xv2.c();
            if (c4 != null) {
                try {
                    if (c4.ev()) {
                        if (i4 == 2) {
                            sr2 = com.bytedance.sdk.openadsdk.core.ugeno.f.w.ux(c4.sr());
                        } else {
                            sr2 = com.bytedance.sdk.component.adexpress.c.xv.c.sr(c4.sr());
                        }
                        return sr2;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public com.bytedance.sdk.openadsdk.core.u.xv c(com.bytedance.sdk.openadsdk.core.u.me meVar, String str) {
        String str2;
        String str3;
        Object obj;
        if (meVar != null) {
            str2 = meVar.uj();
            com.bytedance.sdk.openadsdk.core.u.sr ix = meVar.ix();
            com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
            str3 = zg != null ? zg.k() : null;
            if (TextUtils.isEmpty(str3) && ix != null) {
                str3 = ix.sr();
            }
            Map<String, Object> tc = meVar.tc();
            if (TextUtils.isEmpty(str3) && tc != null && (obj = tc.get("ad_package_name")) != null) {
                str3 = obj.toString();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = meVar.f34750w;
            }
        } else {
            str2 = null;
            str3 = null;
        }
        com.bytedance.sdk.component.ev.w.w xv2 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
        xv2.c(JPushConstants.HTTPS_PRE + ls.w().te() + "/customer/api/app/pkg_info/");
        xv2.c("convert_id", str2);
        xv2.c("package_name", str3);
        xv2.c(DownloadModel.DOWNLOAD_URL, com.bytedance.sdk.openadsdk.n.r.w(str));
        final com.bytedance.sdk.component.ev.w[] wVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        xv2.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.7
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                wVarArr[0] = wVar;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        try {
            if (wVarArr[0] != null && wVarArr[0].ev() && !TextUtils.isEmpty(wVarArr[0].sr()) && new JSONObject(wVarArr[0].sr()).optInt("code", -1) == 0) {
                return new com.bytedance.sdk.openadsdk.core.u.xv(new JSONObject(wVarArr[0].sr()));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(com.bytedance.sdk.openadsdk.core.u.me meVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("user_id", "");
            jSONObject3.put("device_id", i.xv());
            jSONObject3.put("device_id_inner", r.c().w());
            jSONObject3.put("phone_number", meVar != null ? meVar.ky() : "");
            jSONObject3.put("third_idfa", com.bytedance.sdk.openadsdk.core.eq.i.c());
            jSONObject3.put("device_model", i.u());
            jSONObject3.put("device_username", "");
            jSONObject3.put("user_agent", com.bytedance.sdk.openadsdk.core.eq.wv.f());
            jSONObject2.put("validate_info", jSONObject3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("app_base_info", jSONObject.optString("app_base_info"));
            jSONObject4.put("app_custom_info", jSONObject.optString("app_custom_info"));
            jSONObject2.put("app_info", jSONObject4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            JSONObject jSONObject5 = new JSONObject();
            if (meVar != null) {
                jSONObject5.put("ad_id", Long.parseLong(meVar.zb()));
                jSONObject5.put("device_id", 0);
            }
            jSONObject2.put("ad_info", jSONObject5);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        w3.c("https://playable.oceanengine.com/web-api/v1/coldstart");
        w3.c(jSONObject2);
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.8
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(final long j4, final ck.xv xvVar) {
        if (xvVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("get_ritId") { // from class: com.bytedance.sdk.openadsdk.core.z.9
                @Override // java.lang.Runnable
                public void run() {
                    z.this.w(j4, xvVar);
                }
            });
        } else {
            w(j4, xvVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(final ok okVar, final String str, final String str2, final ck.xv xvVar, final int i4, final long j4) {
        if (xvVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("get_wlink") { // from class: com.bytedance.sdk.openadsdk.core.z.10
                @Override // java.lang.Runnable
                public void run() {
                    z.this.w(okVar, str, str2, xvVar, i4, j4);
                }
            });
        } else {
            w(okVar, str, str2, xvVar, i4, j4);
        }
    }

    private JSONObject c(ok okVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DomainCampaignEx.JSON_KEY_ADV_ID, okVar.xv());
            jSONObject.put("site_id", okVar.sr());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject c(long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code_group_id", j4);
            jSONObject2.put("app", com.bytedance.sdk.openadsdk.core.eq.gd.w(-1));
            jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.eq.gd.sr(this.f35680c));
            jSONObject2.put("ua", com.bytedance.sdk.openadsdk.core.eq.wv.f());
            jSONObject2.put("ip", com.bytedance.sdk.openadsdk.core.eq.gd.r());
            jSONObject = com.bytedance.sdk.component.utils.c.c(jSONObject2);
            jSONObject.put("ad_sdk_version", eq.xv);
            jSONObject.put("plugin_version", "6.1.0.6");
            return jSONObject;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(String str) {
        xv(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ck
    public void c(final JSONObject jSONObject, final ck.xv<com.bytedance.sdk.component.ev.w> xvVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.gd.ev.c().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.z.15
                @Override // java.lang.Runnable
                public void run() {
                    z.this.w(jSONObject, xvVar);
                }
            });
        } else {
            w(jSONObject, xvVar);
        }
    }
}
