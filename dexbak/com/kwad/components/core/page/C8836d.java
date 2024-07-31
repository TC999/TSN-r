package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.proxy.AbstractC8889f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11016aj;
import com.kwad.sdk.utils.C11017ak;

/* renamed from: com.kwad.components.core.page.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8836d extends AbstractC8889f {

    /* renamed from: Ot */
    private boolean f28613Ot;

    /* renamed from: aF */
    private void m29766aF(boolean z) {
        Intent intent = getIntent();
        if (z) {
            getActivity().startActivity((Intent) intent.getParcelableExtra("pendingIntent"));
            return;
        }
        String stringExtra = intent.getStringExtra(TTDownloadField.TT_FILE_PATH);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        C11017ak.m24109gE(stringExtra);
    }

    /* renamed from: po */
    private void m29765po() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(C9659R.C9664string.ksad_request_install_title);
        builder.setMessage(C9659R.C9664string.ksad_request_install_content);
        builder.setNegativeButton(C9659R.C9664string.ksad_request_install_nagative, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C8836d.this.finish();
            }
        });
        builder.setPositiveButton(C9659R.C9664string.ksad_request_install_positive, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C8836d.this.m29764pp();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pp */
    public void m29764pp() {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
            intent.addFlags(67108864);
            getActivity().startActivityForResult(intent, 100);
            return;
        }
        finish();
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            C10973b.m24291a(BaseFragmentActivity.RequestInstallPermissionActivity.class, C8836d.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            m29766aF(this.f28613Ot);
        }
        finish();
    }

    @Override // com.kwad.components.core.proxy.AbstractC8889f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("fromNotification", false);
            this.f28613Ot = booleanExtra;
            if (Build.VERSION.SDK_INT < 26) {
                m29766aF(booleanExtra);
                finish();
            } else if (booleanExtra) {
                if (C11016aj.m24117cp(getActivity())) {
                    m29766aF(this.f28613Ot);
                } else {
                    m29764pp();
                }
            } else if (intent.getBooleanExtra("needAllowDialog", false)) {
                m29765po();
            } else {
                m29764pp();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
