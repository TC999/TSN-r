package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IKsAdLabel {
    @Keep
    String getChannel();

    @Keep
    long getCpmBidFloor();

    @Keep
    String getHistoryTitle();

    @Keep
    String getPostTitle();

    @Keep
    String getPrevTitle();

    @Keep
    int getThirdAge();

    @Keep
    int getThirdGender();

    @Keep
    String getThirdInterest();

    @Keep
    void setChannel(String str);

    @Keep
    void setCpmBidFloor(long j4);

    @Keep
    void setHistoryTitle(String str);

    @Keep
    void setPostTitle(String str);

    @Keep
    void setPrevTitle(String str);

    @Keep
    void setThirdAge(int i4);

    @Keep
    void setThirdGender(int i4);

    @Keep
    void setThirdInterest(String str);
}
