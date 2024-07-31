package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ABParams extends C10482a implements InterfaceC9914b, Serializable {
    public static final int DEFAULT_TIME = 3;
    public static final int PLAYABLE_STYLE_1 = 1;
    public static final int PLAYABLE_STYLE_2 = 2;
    private static final long serialVersionUID = 2242970085362179363L;
    public String drawActionBarTimes;
    public int playableStyle;
    public int showVideoAtH5;
    public int videoBlackAreaClick;
    public int videoBlackAreaNewStyle;
}
