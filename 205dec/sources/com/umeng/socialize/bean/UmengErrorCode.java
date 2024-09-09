package com.umeng.socialize.bean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum UmengErrorCode {
    UnKnowCode(2000),
    AuthorizeFailed(2002),
    ShareFailed(2003),
    RequestForUserProfileFailed(2004),
    ShareDataNil(2004),
    ShareDataTypeIllegal(2004),
    NotInstall(2008);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f53989a;

    UmengErrorCode(int i4) {
        this.f53989a = i4;
    }

    private String a() {
        return "\u9519\u8bef\u7801\uff1a" + this.f53989a + " \u9519\u8bef\u4fe1\u606f\uff1a";
    }

    public String getMessage() {
        if (this == UnKnowCode) {
            return a() + "\u672a\u77e5\u9519\u8bef----";
        } else if (this == AuthorizeFailed) {
            return a() + "\u6388\u6743\u5931\u8d25----";
        } else if (this == ShareFailed) {
            return a() + "\u5206\u4eab\u5931\u8d25----";
        } else if (this == RequestForUserProfileFailed) {
            return a() + "\u83b7\u53d6\u7528\u6237\u8d44\u6599\u5931\u8d25----";
        } else if (this == ShareDataNil) {
            return a() + "\u5206\u4eab\u5185\u5bb9\u4e3a\u7a7a";
        } else if (this == ShareDataTypeIllegal) {
            return a() + "\u5206\u4eab\u5185\u5bb9\u4e0d\u5408\u6cd5----";
        } else if (this == NotInstall) {
            return a() + "\u6ca1\u6709\u5b89\u88c5\u5e94\u7528";
        } else {
            return "unkonw";
        }
    }
}
