package com.qq.e.mediation.interfaces;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface INoticeUrlProvider {
    public static final String IMPL_CLASS_NAME = "util.NoticeUrlProviderImpl";

    String getAssembledLossNoticeUrl(String str, String str2, boolean z3);

    String getAssembledWinNoticeUrl(String str, String str2, boolean z3);

    String getOtherAssembledLossNoticeUrl(String str, String str2);
}
