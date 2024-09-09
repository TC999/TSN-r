package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.live.c.f;
import com.bytedance.sdk.openadsdk.core.live.c.ux;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.y;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTLiveCommerceHelper {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.live.c.xv f33846c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private static final TTLiveCommerceHelper f33847c = new TTLiveCommerceHelper();
    }

    private void c() {
        if (TextUtils.equals(eq.f33188f, "csj_m_main") && eq.f33190w < 5500) {
            this.f33846c = new ux();
        } else if (TextUtils.equals(eq.f33188f, "main") && eq.f33190w < 5500) {
            this.f33846c = new ux();
        } else {
            this.f33846c = new f();
        }
    }

    public static final TTLiveCommerceHelper getInstance() {
        return c.f33847c;
    }

    private static boolean w() {
        return eq.f33190w >= 4600;
    }

    public int canOpenGoodsDetailPage(me meVar) {
        return this.f33846c.xv(meVar);
    }

    public int canOpenLive(Context context, me meVar, Map<String, Object> map) {
        int c4 = this.f33846c.c(context, meVar, map);
        a.w("TTLiveCommerceHelper", "lv result: " + c4);
        return c4;
    }

    public void convertViewTagToAction(View view, y yVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || yVar == null || (tag = view.getTag(TTAdConstant.KEY_CLICK_AREA)) == null || !(tag instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) tag).intValue();
        int i4 = intValue & 255;
        int i5 = (intValue & 65280) >>> 8;
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        if (i4 == 101 && !yVar.xv()) {
            i4 = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i4));
        map2.put("click_saas_area", Integer.valueOf(i5));
    }

    public int getLiveAdClickCount() {
        if (w()) {
            return com.bytedance.sdk.openadsdk.core.xv.ux.c().ux();
        }
        return 0;
    }

    public int getLiveAuthStatus() {
        return this.f33846c.sr();
    }

    public String getLivePluginVersion() {
        return this.f33846c.ux();
    }

    public int getLiveRoomStatus(me meVar) {
        if (ls.w().ny()) {
            return this.f33846c.b_(meVar);
        }
        return 0;
    }

    public int getLiveSdkStatus() {
        return this.f33846c.w();
    }

    public int getRewardToLiveRoomCode(com.bytedance.sdk.openadsdk.core.w.c.c.ux uxVar) {
        if (uxVar != null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("event_tag", uxVar.k());
            hashMap.put("reward_countdown", Long.valueOf(uxVar.ys()));
            return getRewardToLiveRoomCode(uxVar.getContext(), uxVar.w(), hashMap);
        }
        return 5;
    }

    public void initTobLiveSDK() {
        this.f33846c.c();
    }

    public boolean isLiveCommerceScene(me meVar) {
        return this.f33846c.c(meVar);
    }

    public boolean isSdkLiveRoomType(me meVar) {
        if (meVar == null || TextUtils.isEmpty(meVar.yw())) {
            return false;
        }
        return isSdkLiveRoomType(meVar.yw(), meVar.kp());
    }

    public void onClick(me meVar) {
        if (!w() || meVar == null || TextUtils.isEmpty(meVar.yw())) {
            return;
        }
        int ux = com.bytedance.sdk.openadsdk.core.xv.ux.c().ux() + 1;
        if (ux > 100) {
            ux = 100;
        }
        com.bytedance.sdk.openadsdk.core.xv.ux.c().sr(ux);
    }

    public void reportLiveRoomJumpResult(me meVar, String str, int i4) {
        if (isSdkLiveRoomType(meVar)) {
            this.f33846c.c(meVar, str, i4);
        }
    }

    public void setLiveAdBridge(Bridge bridge) {
        this.f33846c.c(bridge);
    }

    public void tryWarmUpLiveRoom() {
        this.f33846c.xv();
    }

    public void updatePluginVersion(String str) {
        this.f33846c.c(str);
    }

    public void uploadLiveEventV2(String str, me meVar, long j4) {
        this.f33846c.c(str, meVar, j4);
    }

    private TTLiveCommerceHelper() {
        if (w()) {
            if (eq.ux) {
                c();
            } else if (eq.sr()) {
                this.f33846c = new com.bytedance.sdk.openadsdk.core.live.c.sr();
            } else {
                this.f33846c = new com.bytedance.sdk.openadsdk.core.live.c.w();
            }
        } else {
            this.f33846c = new com.bytedance.sdk.openadsdk.core.live.c.w();
        }
        a.w("TTLiveSDkBridge", "create api:" + this.f33846c);
    }

    public boolean isSdkLiveRoomType(String str, int i4) {
        return this.f33846c.c(str, i4);
    }

    public int getRewardToLiveRoomCode(Context context, me meVar, Map<String, Object> map) {
        return this.f33846c.w(context, meVar, map);
    }
}
