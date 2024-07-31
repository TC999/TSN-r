package com.kwad.sdk.p369c;

import com.kuaishou.weapon.p205p0.IWeaponInitParams;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.utils.C11028au;
import com.kwad.sdk.utils.C11059bi;

/* renamed from: com.kwad.sdk.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9779b implements IWeaponInitParams {
    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final boolean getAPPLISTSwitch() {
        return !C11028au.m24064Ms();
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final String getAppKey() {
        return "400000";
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final String getChannel() {
        return "";
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final String getDeviceId() {
        return C11059bi.getDeviceId();
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final boolean getPrivacySwitch() {
        return true;
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final String getProductName() {
        return "ksadsdk";
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final String getSecKey() {
        return "f12536c198aee4d8198aad2300827430";
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final String getUserId() {
        return "";
    }

    @Override // com.kuaishou.weapon.p205p0.IWeaponInitParams
    public final boolean isLoadSo() {
        return C9425a.adE.booleanValue();
    }
}
