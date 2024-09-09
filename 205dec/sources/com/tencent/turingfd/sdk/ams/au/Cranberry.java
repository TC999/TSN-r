package com.tencent.turingfd.sdk.ams.au;

import android.os.Process;
import com.tencent.turingfd.sdk.ams.au.Serpens;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cranberry {
    public static String a() {
        StringBuilder sb = new StringBuilder();
        int myPid = Process.myPid();
        Serpens.Cdo b4 = Serpens.b(myPid);
        if (b4 == null) {
            return sb.toString();
        }
        int i4 = b4.f52175e;
        if (i4 == 0) {
            return sb.toString();
        }
        if (i4 == myPid) {
            return sb.toString();
        }
        sb.append(myPid);
        sb.append(",");
        sb.append(b4.f52172b);
        sb.append(",");
        sb.append(b4.f52173c);
        sb.append(",");
        sb.append(i4);
        sb.append(",");
        Serpens.Cdo b5 = Serpens.b(i4);
        if (b5 != null) {
            sb.append(b5.f52174d);
            sb.append(",");
            sb.append(b5.f52173c);
            sb.append(",");
            sb.append(b5.f52172b);
        }
        return sb.toString();
    }
}
