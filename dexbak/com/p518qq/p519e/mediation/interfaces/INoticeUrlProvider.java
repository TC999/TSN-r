package com.p518qq.p519e.mediation.interfaces;

/* renamed from: com.qq.e.mediation.interfaces.INoticeUrlProvider */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface INoticeUrlProvider {
    public static final String IMPL_CLASS_NAME = "util.NoticeUrlProviderImpl";

    String getAssembledLossNoticeUrl(String str, String str2, boolean z);

    String getAssembledWinNoticeUrl(String str, String str2, boolean z);

    String getOtherAssembledLossNoticeUrl(String str, String str2);
}
