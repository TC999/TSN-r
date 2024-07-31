package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* renamed from: com.kwad.sdk.core.report.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10468p extends C10451c {

    /* renamed from: IP */
    public static int f29574IP = 1;
    private static String ayT = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public C10468p(@Nullable Context context, int i) {
        super(context, "ksadrep.db", i, ayT);
    }
}
