package com.umeng.socialize.bean;

import com.kwad.library.solder.lib.ext.PluginError;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum UmengErrorCode {
    UnKnowCode(2000),
    AuthorizeFailed(2002),
    ShareFailed(2003),
    RequestForUserProfileFailed(PluginError.ERROR_UPD_EXTRACT),
    ShareDataNil(PluginError.ERROR_UPD_EXTRACT),
    ShareDataTypeIllegal(PluginError.ERROR_UPD_EXTRACT),
    NotInstall(PluginError.ERROR_UPD_NO_DOWNLOADER);
    

    /* renamed from: a */
    private final int f39402a;

    UmengErrorCode(int i) {
        this.f39402a = i;
    }

    /* renamed from: a */
    private String m13318a() {
        return "错误码：" + this.f39402a + " 错误信息：";
    }

    public String getMessage() {
        if (this == UnKnowCode) {
            return m13318a() + "未知错误----";
        } else if (this == AuthorizeFailed) {
            return m13318a() + "授权失败----";
        } else if (this == ShareFailed) {
            return m13318a() + "分享失败----";
        } else if (this == RequestForUserProfileFailed) {
            return m13318a() + "获取用户资料失败----";
        } else if (this == ShareDataNil) {
            return m13318a() + "分享内容为空";
        } else if (this == ShareDataTypeIllegal) {
            return m13318a() + "分享内容不合法----";
        } else if (this == NotInstall) {
            return m13318a() + "没有安装应用";
        } else {
            return "unkonw";
        }
    }
}
