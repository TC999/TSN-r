package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class TuringIDService {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.TuringIDService$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements Bootes {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ITuringDIDCallback f52179a;
    }

    public static ITuringDID a(Context context) {
        Date a4;
        int a5 = Kiwifruit.a();
        if (a5 != 0) {
            a4 = Date.a(a5);
        } else {
            a4 = Foxnut.f52052l.a(context, true, 1);
        }
        return new Grapefruit(a4);
    }

    public static ITuringDID b(Context context) {
        Date a4;
        int a5 = Kiwifruit.a();
        if (a5 != 0) {
            a4 = Date.a(a5);
        } else {
            Foxnut foxnut = Foxnut.f52052l;
            a4 = foxnut.a(context);
            if (foxnut.f52055a == null) {
                a4 = Date.a(-10002);
            } else {
                int a6 = foxnut.a(a4);
                if (a6 != 1) {
                    if (a6 == 2) {
                        foxnut.a();
                        a4 = Date.a(-10009);
                    } else if (a6 == 3) {
                        foxnut.a();
                    }
                }
            }
        }
        return new Grapefruit(a4);
    }
}
