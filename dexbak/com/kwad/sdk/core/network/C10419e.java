package com.kwad.sdk.core.network;

import com.bytedance.msdk.api.AdError;

/* renamed from: com.kwad.sdk.core.network.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10419e {
    public final int errorCode;
    public final String msg;
    public static C10419e avt = new C10419e(-1, "请求超时事件");
    public static C10419e avu = new C10419e(-2, "请求异常");
    public static C10419e avv = new C10419e(-1000, "该业务组件未加载");
    public static C10419e avw = new C10419e(AdError.ERROR_CODE_REQUEST_PB_ERROR, "网络错误");
    public static C10419e avx = new C10419e(AdError.ERROR_CODE_APP_EMPTY, "数据解析错误");
    public static C10419e avy = new C10419e(AdError.ERROR_CODE_WAP_EMPTY, "数据为空");
    public static C10419e avz = new C10419e(AdError.ERROR_CODE_ADSLOT_EMPTY, "视频资源缓存失败");
    public static C10419e avA = new C10419e(AdError.ERROR_CODE_ADSLOT_SIZE_EMPTY, "网络超时");
    public static C10419e avB = new C10419e(AdError.ERROR_CODE_ADCOUNT_ERROR, "图片下载失败");
    public static C10419e avC = new C10419e(AdError.ERROR_CODE_IMAGE_SIZE, "广告场景不匹配");
    public static C10419e avD = new C10419e(AdError.ERROR_CODE_MEDIA_ID, "广告加载异常");
    public static C10419e avE = new C10419e(AdError.ERROR_CODE_MEDIA_TYPE, "activity场景不匹配");
    public static C10419e avF = new C10419e(AdError.ERROR_CODE_AD_TYPE, "sdk初始化失败");
    public static C10419e avG = new C10419e(AdError.ERROR_CODE_ACCESS_METHOD_PASS, "权限未开启");
    public static C10419e avH = new C10419e(100006, "更多视频请前往快手App查看");
    public static C10419e avI = new C10419e(100007, "复制链接失败，请稍后重试");
    public static C10419e avJ = new C10419e(100008, "内容有点敏感，不可以发送哦");
    public static C10419e avK = new C10419e(130001, "数据不存在");
    public static C10419e avL = new C10419e(0, "网络超时");

    private C10419e(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
