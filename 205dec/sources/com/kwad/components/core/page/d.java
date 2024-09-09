package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ak;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d extends f {
    private boolean Ot;

    private void aF(boolean z3) {
        Intent intent = getIntent();
        if (z3) {
            getActivity().startActivity((Intent) intent.getParcelableExtra("pendingIntent"));
            return;
        }
        String stringExtra = intent.getStringExtra("filePath");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        ak.gE(stringExtra);
    }

    private void po() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.ksad_request_install_title);
        builder.setMessage(R.string.ksad_request_install_content);
        builder.setNegativeButton(R.string.ksad_request_install_nagative, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.ksad_request_install_positive, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                d.this.pp();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp() {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
            intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
            getActivity().startActivityForResult(intent, 100);
            return;
        }
        finish();
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.a(BaseFragmentActivity.RequestInstallPermissionActivity.class, d.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (i4 == 100 && i5 == -1) {
            aF(this.Ot);
        }
        finish();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("fromNotification", false);
            this.Ot = booleanExtra;
            if (Build.VERSION.SDK_INT < 26) {
                aF(booleanExtra);
                finish();
            } else if (booleanExtra) {
                if (aj.cp(getActivity())) {
                    aF(this.Ot);
                } else {
                    pp();
                }
            } else if (intent.getBooleanExtra("needAllowDialog", false)) {
                po();
            } else {
                pp();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
