package com.bytedance.msdk.core.ux;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.api.c.w;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.ux.w.ev;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f28203c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, Integer> f28204w = new HashMap();

    public void c(String str, String str2, int i4) {
        Map<String, Integer> map = this.f28203c;
        map.put(str + "_" + str2, Integer.valueOf(i4));
    }

    public void w(String str, String str2, int i4) {
        Map<String, Integer> map = this.f28204w;
        map.put(str + "_" + str2, Integer.valueOf(i4));
    }

    public int c(String str, String str2) {
        Map<String, Integer> map = this.f28203c;
        Integer num = map.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public int w(String str, String str2) {
        Map<String, Integer> map = this.f28204w;
        Integer num = map.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(ev evVar, w wVar, w wVar2, String str) {
        if (evVar == null || evVar.f28224c == null) {
            return 4;
        }
        String u3 = wVar2 != null ? wVar2.u() : "";
        String adNetWorkName = evVar.f28224c.getAdNetWorkName();
        String adNetworkSlotId = evVar.f28224c.getAdNetworkSlotId();
        MediationConstant.AdIsReadyStatus isReadyStatus = evVar.f28224c.isReadyStatus();
        if (isReadyStatus == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            if (evVar.f28224c.isHasShown()) {
                xv.c("TTMediationSDK", "--==-- " + str + ":\u5e7f\u544a\u5df2show\u8fc7 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 7;
            } else if (c(u3, evVar.f28224c)) {
                xv.c("TTMediationSDK", "--==-- " + str + ":\u5e7f\u544a\u8fc7\u671f\u4e86(M\u914d\u7f6e) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 2;
            } else if (!c(wVar, wVar2, evVar.f28224c)) {
                xv.c("TTMediationSDK", "--==-- " + str + ":AdSlot\u4e0d\u7b26\u5408 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 6;
            } else {
                xv.c("TTMediationSDK", "--==-- " + str + ":\u590d\u7528\u6210\u529f\uff1a---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return -1;
            }
        } else if (evVar.f28224c.isHasShown()) {
            xv.c("TTMediationSDK", "--==-- " + str + ":\u5e7f\u544a\u5df2show\u8fc7 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 7;
        } else if (isReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            xv.c("TTMediationSDK", "--==-- " + str + ":\u5e7f\u544a\u8fc7\u671f\u4e86(adn api) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 1;
        } else if (isReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            xv.c("TTMediationSDK", "--==-- " + str + ":isReady\u662ffalse ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 5;
        } else if (!c(wVar, wVar2, evVar.f28224c)) {
            xv.c("TTMediationSDK", "--==-- " + str + ":AdSlot\u4e0d\u7b26\u5408 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 6;
        } else {
            xv.c("TTMediationSDK", "--==-- " + str + ":\u590d\u7528\u6210\u529f\uff1a---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return -1;
        }
    }

    public final boolean c(String str, ux uxVar) {
        if (uxVar != null && !uxVar.hasDestroyed()) {
            boolean z3 = SystemClock.elapsedRealtime() > uxVar.getFillTime() + ((long) c(str, uxVar.getAdNetworkSlotId()));
            xv.c("TTMediationSDK", "--==-- \u4f7f\u7528\u4e86\u914d\u7f6e\u7684\u8fc7\u671f\u65f6\u95f4\u8fdb\u884c\u5224\u65ad ------");
            return z3;
        }
        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u5df2\u7ecfdestroy\u4e86\uff0c\u89c6\u4e3a\u8fc7\u671f ------");
        return true;
    }

    public static boolean c(w wVar, w wVar2, ux uxVar) {
        if (wVar != null && wVar2 != null) {
            if (wVar.eq() != wVar2.eq()) {
                xv.c("TMe", "--==-- orientation, a1: " + wVar.eq() + ", a2: " + wVar2.eq());
                return false;
            } else if (wVar.me() != wVar2.me()) {
                xv.c("TMe", "--==-- isMuted, a1: " + wVar.me() + ", a2: " + wVar2.me());
                return false;
            } else if (wVar.q() != wVar2.q()) {
                xv.c("TMe", "--==-- ImgWidth, a1: " + wVar.q() + ", a2: " + wVar2.q());
                return false;
            } else if (wVar.j() != wVar2.j()) {
                xv.c("TMe", "--==-- ImgHeight, a1: " + wVar.j() + ", a2: " + wVar2.j());
                return false;
            } else {
                if (wVar.ck() != null && wVar2.ck() != null) {
                    if (!wVar.ck().equals(wVar2.ck())) {
                        xv.c("TMe", "--==-- rewardName, a1: " + wVar.ck() + ", a2: " + wVar2.ck());
                        return false;
                    }
                } else if (wVar.ck() != null || wVar2.ck() != null) {
                    xv.c("TMe", "--==-- rewardName=null, a1: " + wVar.ck() + ", a2: " + wVar2.ck());
                    return false;
                }
                if (wVar.z() != wVar2.z()) {
                    xv.c("TMe", "--==-- rewardAmount, a1: " + wVar.z() + ", a2: " + wVar2.z());
                    return false;
                }
                if (wVar.y() != null && wVar2.y() != null) {
                    if (!wVar.y().equals(wVar2.y())) {
                        xv.c("TMe", "--==-- reward, userId, a1: " + wVar.y() + ", a2: " + wVar2.y());
                        return false;
                    }
                } else if (wVar.y() != null || wVar2.y() != null) {
                    xv.c("TMe", "--==-- reward, userId=null, a1: " + wVar.y() + ", a2: " + wVar2.y());
                    return false;
                }
                if (wVar.yu() != null && wVar2.yu() != null) {
                    if (c(wVar.yu(), wVar2.yu())) {
                        return true;
                    }
                    xv.c("TMe", "--==-- customData, a1: " + wVar.yu().toString() + ", a2: " + wVar2.yu().toString());
                    return false;
                } else if (wVar.yu() == null && wVar2.yu() == null) {
                    return true;
                } else {
                    xv.c("TMe", "--==-- customData=null, a1: " + wVar.yu() + ", a2: " + wVar2.yu());
                    return false;
                }
            }
        }
        xv.c("TMe", "--==-- adSlot = null, a1: " + wVar + ", a2: " + wVar2);
        return false;
    }

    public static boolean c(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> keySet = map.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                if (str != null) {
                    Object obj = map.get(str);
                    String str2 = obj instanceof String ? (String) obj : null;
                    Object obj2 = map2.get(str);
                    String str3 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null || str3 != null) {
                        if (!TextUtils.equals(str2, str3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
