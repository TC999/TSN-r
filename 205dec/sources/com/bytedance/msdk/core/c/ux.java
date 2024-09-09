package com.bytedance.msdk.core.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends w {
    private com.bytedance.sdk.openadsdk.s.c.w.c.c xv;

    public ux(com.bytedance.msdk.adapter.c cVar) {
        super(cVar);
    }

    @Override // com.bytedance.msdk.core.c.w
    public <T> T c(int i4, ValueSet valueSet, Class<T> cls) {
        com.bytedance.msdk.api.sr.c.xv.w wVar;
        com.bytedance.msdk.api.sr.c.xv.w wVar2;
        if (i4 == 8130) {
            if (getAdType() == 5) {
                com.bytedance.msdk.api.sr.c.r.xv xvVar = this.f27671f;
                if (xvVar != null) {
                    xvVar.c();
                }
            } else if (getAdType() == 9 && (wVar2 = this.f27676k) != null) {
                wVar2.c();
            }
        } else if (i4 == 8113) {
            if (getAdType() == 5) {
                com.bytedance.msdk.api.sr.c.r.xv xvVar2 = this.f27671f;
                if (xvVar2 != null) {
                    xvVar2.w();
                }
            } else if (getAdType() == 9 && (wVar = this.f27676k) != null) {
                wVar.w();
            }
        } else if (i4 == 8131) {
            if (((w) this).f27851w != null) {
                ((w) this).f27851w.nativeDislikeClick(this, valueSet.stringValue(8036), (Map) valueSet.objectValue(8037, Map.class));
            }
        } else if (i4 == 8132) {
            com.bytedance.msdk.adapter.c cVar = ((w) this).f27851w;
            if (cVar != null) {
                com.bytedance.msdk.core.w.c.c(cVar.getAdapterRit());
            }
            if (this.xv != null) {
                this.xv.onSelected(valueSet.intValue(8038), valueSet.stringValue(8039), false);
            }
        } else if (i4 == 8133) {
            float floatValue = valueSet.floatValue(8040);
            float floatValue2 = valueSet.floatValue(8041);
            if (getAdType() == 5) {
                com.bytedance.msdk.api.sr.c.r.xv xvVar3 = this.f27671f;
                if (xvVar3 instanceof com.bytedance.msdk.api.sr.c.r.r) {
                    ((com.bytedance.msdk.api.sr.c.r.r) xvVar3).c(floatValue, floatValue2);
                }
            } else if (getAdType() == 9) {
                com.bytedance.msdk.api.sr.c.xv.w wVar3 = this.f27676k;
                if (wVar3 instanceof com.bytedance.msdk.api.sr.c.xv.ux) {
                    ((com.bytedance.msdk.api.sr.c.xv.ux) wVar3).c(floatValue, floatValue2);
                }
            }
        } else if (i4 == 8134) {
            int intValue = valueSet.intValue(8014);
            String stringValue = valueSet.stringValue(8015);
            View view = (View) valueSet.objectValue(8042, View.class);
            if (getAdType() == 5) {
                com.bytedance.msdk.api.sr.c.r.xv xvVar4 = this.f27671f;
                if (xvVar4 instanceof com.bytedance.msdk.api.sr.c.r.r) {
                    ((com.bytedance.msdk.api.sr.c.r.r) xvVar4).c(view, stringValue, intValue);
                }
            } else if (getAdType() == 9) {
                com.bytedance.msdk.api.sr.c.xv.w wVar4 = this.f27676k;
                if (wVar4 instanceof com.bytedance.msdk.api.sr.c.xv.ux) {
                    ((com.bytedance.msdk.api.sr.c.xv.ux) wVar4).c(view, stringValue, intValue);
                }
            }
        } else if (i4 == 8140) {
            String stringValue2 = valueSet.stringValue(8045);
            String stringValue3 = valueSet.stringValue(8046);
            int intValue2 = valueSet.intValue(8047);
            String stringValue4 = valueSet.stringValue(8048);
            String stringValue5 = valueSet.stringValue(8049);
            String stringValue6 = valueSet.stringValue(8050);
            int intValue3 = valueSet.intValue(8051);
            int intValue4 = valueSet.intValue(8052);
            String stringValue7 = valueSet.stringValue(8054);
            boolean booleanValue = valueSet.booleanValue(8055);
            String stringValue8 = valueSet.stringValue(8056);
            String stringValue9 = valueSet.stringValue(8057);
            Object objectValue = valueSet.objectValue(8036, Object.class);
            String stringValue10 = valueSet.stringValue(8058);
            double doubleValue = valueSet.doubleValue(8016);
            boolean booleanValue2 = valueSet.booleanValue(8033);
            int intValue5 = valueSet.intValue(8060);
            String stringValue11 = valueSet.stringValue(8061);
            String stringValue12 = valueSet.stringValue(8061);
            long longValue = valueSet.longValue(8078);
            String stringValue13 = valueSet.stringValue(8079);
            Map<String, String> map = (Map) valueSet.objectValue(8427, Map.class);
            String stringValue14 = valueSet.stringValue(8080);
            String stringValue15 = valueSet.stringValue(8081);
            double doubleValue2 = valueSet.doubleValue(8082);
            int intValue6 = valueSet.intValue(8059);
            String stringValue16 = valueSet.stringValue(8551);
            int intValue7 = valueSet.intValue(8553);
            setTitle(stringValue2);
            setAdDescription(stringValue3);
            setAppSize(intValue2);
            setIconUrl(stringValue4);
            setSource(stringValue5);
            setImageUrl(stringValue6);
            setImageHeight(intValue3);
            setImageWidth(intValue4);
            setImages((List) valueSet.objectValue(8053, List.class));
            setPackageName(stringValue7);
            setIsAppDownload(booleanValue);
            setAppName(stringValue8);
            setAuthorName(stringValue9);
            if (TextUtils.equals(getAdNetWorkName(), "baidu")) {
                putExtraMsg("baidu_dislike_info", objectValue);
            }
            setLevelTag(stringValue10);
            setCpm(doubleValue);
            setExpressAd(booleanValue2);
            setImageMode(intValue5);
            setActionText(stringValue11);
            setStore(stringValue12);
            setPackageSizeBytes(longValue);
            setPermissionsUrl(stringValue13);
            setPermissionsMap(map);
            setPrivacyAgreement(stringValue14);
            setVersionName(stringValue15);
            setRating(doubleValue2);
            setInteractionType(intValue6);
            setFunctionDescUrl(stringValue16);
            setSupportRender(intValue7);
        } else if (i4 == 8143) {
            return (T) Double.valueOf(getCpm());
        } else {
            if (i4 == 8145) {
                com.bytedance.msdk.api.sr.c.r.gd gdVar = this.f27681r;
                if (gdVar != null) {
                    gdVar.x();
                }
            } else if (i4 == 8146) {
                com.bytedance.msdk.api.sr.c.r.gd gdVar2 = this.f27681r;
                if (gdVar2 != null) {
                    gdVar2.m();
                }
            } else if (i4 == 8118) {
                com.bytedance.msdk.api.sr.c.r.gd gdVar3 = this.f27681r;
                if (gdVar3 != null) {
                    gdVar3.vc();
                }
            } else if (i4 == 8117) {
                int intValue8 = valueSet.intValue(8014);
                String stringValue17 = valueSet.stringValue(8015);
                com.bytedance.msdk.api.sr.c.r.gd gdVar4 = this.f27681r;
                if (gdVar4 != null) {
                    gdVar4.c(new com.bytedance.msdk.api.c(intValue8, stringValue17));
                }
            } else if (i4 == 8150) {
                com.bytedance.msdk.api.sr.c.r.gd gdVar5 = this.f27681r;
                if (gdVar5 != null) {
                    gdVar5.gw();
                }
            } else if (i4 == 1025) {
                if (this.f27681r != null) {
                    this.f27681r.c(valueSet.longValue(8072), valueSet.longValue(8073));
                }
            } else if (i4 == 8152) {
                com.bytedance.msdk.api.sr.c.w wVar5 = this.ev;
                if (wVar5 != null) {
                    wVar5.c();
                }
            } else if (i4 == 8153) {
                com.bytedance.msdk.api.sr.c.w wVar6 = this.ev;
                if (wVar6 != null) {
                    wVar6.w();
                }
            } else if (i4 == 8187) {
                if (this.ev != null) {
                    this.ev.c(valueSet.longValue(8062), valueSet.longValue(8063), valueSet.intValue(8064), valueSet.intValue(8065));
                }
            } else if (i4 == 8155) {
                if (this.ev != null) {
                    this.ev.c(valueSet.longValue(8062), valueSet.stringValue(8066), valueSet.stringValue(8056));
                }
            } else if (i4 == 8156) {
                if (this.ev != null) {
                    this.ev.c(valueSet.stringValue(8066), valueSet.stringValue(8056));
                }
            } else if (i4 == 8157) {
                if (this.ev != null) {
                    this.ev.w(valueSet.longValue(8062), valueSet.longValue(8063), valueSet.stringValue(8066), valueSet.stringValue(8056));
                }
            } else if (i4 == 8158) {
                if (this.ev != null) {
                    this.ev.c(valueSet.longValue(8062), valueSet.longValue(8063), valueSet.stringValue(8066), valueSet.stringValue(8056));
                }
            } else if (i4 == 8160) {
                return (T) Boolean.valueOf(isUseCustomVideo());
            } else {
                if (i4 == 6069) {
                    return (T) Integer.valueOf(getImageMode());
                }
                if (i4 == 8185) {
                    com.bytedance.sdk.openadsdk.s.c.w.c.c cVar2 = this.xv;
                    if (cVar2 != null) {
                        cVar2.onShow();
                    }
                } else if (i4 == 8184) {
                    com.bytedance.sdk.openadsdk.s.c.w.c.c cVar3 = this.xv;
                    if (cVar3 != null) {
                        cVar3.onCancel();
                    }
                } else if (i4 == 8196) {
                    return (T) Boolean.valueOf(isExpressAd());
                } else {
                    if (i4 == 8197) {
                        com.bytedance.msdk.api.sr.c.sr srVar = this.gd;
                        if (srVar != null) {
                            srVar.c();
                        }
                    } else if (i4 == 8227) {
                        if (valueSet != null) {
                            putExtraMsg((Map) valueSet.objectValue(8075, Map.class));
                        }
                    } else if (i4 == 6107 && this.f27679p != null) {
                        this.f27679p.c(valueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.bytedance.msdk.core.s.c.c(cls);
    }

    @Override // com.bytedance.msdk.c.ux
    public void cancelDownload() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            bridge.call(6093, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void dislikeClick(String str, Map<String, Object> map) {
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.i(8036, str);
            a4.h(8075, map);
            ((w) this).f27850c.call(8194, a4.l(), Integer.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public View getAdView() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (View) bridge.call(6081, null, View.class);
        }
        return super.getAdView();
    }

    @Override // com.bytedance.msdk.c.ux
    public int getDownloadStatus() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return ((Integer) bridge.call(8193, null, Integer.class)).intValue();
        }
        return super.getDownloadStatus();
    }

    @Override // com.bytedance.msdk.c.ux
    public com.bytedance.msdk.api.sr.c.r.f getGMNativeCustomVideoReporter() {
        Bridge bridge;
        Bridge bridge2 = ((w) this).f27850c;
        if (bridge2 == null || (bridge = (Bridge) bridge2.call(8320, null, Bridge.class)) == null) {
            return null;
        }
        return f.c(bridge);
    }

    @Override // com.bytedance.msdk.c.ux
    public String getReqId() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (String) bridge.call(8147, null, String.class);
        }
        return super.getReqId();
    }

    @Override // com.bytedance.msdk.c.ux
    public int getVideoHeight() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return ((Integer) bridge.call(8162, null, Integer.class)).intValue();
        }
        return super.getVideoWidth();
    }

    @Override // com.bytedance.msdk.c.ux
    public String getVideoUrl() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (String) bridge.call(8163, null, String.class);
        }
        return super.getVideoUrl();
    }

    @Override // com.bytedance.msdk.c.ux
    public int getVideoWidth() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return ((Integer) bridge.call(8161, null, Integer.class)).intValue();
        }
        return super.getVideoWidth();
    }

    @Override // com.bytedance.msdk.c.ux
    public boolean hasDislike() {
        try {
            Bridge bridge = ((w) this).f27850c;
            if (bridge != null) {
                return ((Boolean) bridge.call(8135, null, Boolean.class)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return super.hasDislike();
    }

    @Override // com.bytedance.msdk.c.ux
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null && bridge.values() != null && ((w) this).f27850c.values().keys() != null && ((w) this).f27850c.values().keys().contains(8121)) {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) ((w) this).f27850c.call(8121, null, MediationConstant.AdIsReadyStatus.class);
            return adIsReadyStatus == null ? super.isReadyStatus() : adIsReadyStatus;
        }
        return super.isReadyStatus();
    }

    @Override // com.bytedance.msdk.c.ux
    public void pauseAppDownload() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            bridge.call(8191, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, k kVar) {
        super.registerViewForInteraction(viewGroup, list, list2, kVar);
        c(null, viewGroup, list, list2, null, kVar);
    }

    @Override // com.bytedance.msdk.c.ux
    public void render() {
        super.render();
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            bridge.call(6083, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void resumeAppDownload() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            bridge.call(8192, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux, com.bytedance.msdk.c.xv
    public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        this.xv = cVar;
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20033, activity);
            ((w) this).f27850c.call(6085, a4.l(), Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void unregisterView() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            bridge.call(8195, null, Void.class);
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
        super.registerViewForInteraction(activity, viewGroup, list, list2, list3, kVar);
        c(activity, viewGroup, list, list2, list3, kVar);
    }

    private void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20033, activity);
            a4.h(8067, viewGroup);
            a4.h(8068, list);
            a4.h(8069, list2);
            a4.h(8070, list3);
            a4.h(8071, k.c(kVar));
            ((w) this).f27850c.call(8159, a4.l(), Void.class);
        }
    }
}
