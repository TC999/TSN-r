package com.jmolsmobile.landscapevideocapture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.recorder.AlreadyUsedException;
import com.jmolsmobile.landscapevideocapture.view.VideoCaptureView;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class VideoCaptureActivity extends Activity implements com.jmolsmobile.landscapevideocapture.view.a, com.jmolsmobile.landscapevideocapture.recorder.b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f37870g = 753245;

    /* renamed from: h  reason: collision with root package name */
    private static final int f37871h = 578465;

    /* renamed from: i  reason: collision with root package name */
    public static final String f37872i = "com.jmolsmobile.extraoutputfilename";

    /* renamed from: j  reason: collision with root package name */
    public static final String f37873j = "com.jmolsmobile.extracaptureconfiguration";

    /* renamed from: k  reason: collision with root package name */
    public static final String f37874k = "com.jmolsmobile.extraerrormessage";

    /* renamed from: l  reason: collision with root package name */
    private static final String f37875l = "com.jmolsmobile.extracamerafacing";

    /* renamed from: m  reason: collision with root package name */
    private static final String f37876m = "com.jmolsmobile.savedrecordedboolean";

    /* renamed from: n  reason: collision with root package name */
    protected static final String f37877n = "com.jmolsmobile.savedoutputfilename";

    /* renamed from: a  reason: collision with root package name */
    private boolean f37878a = false;

    /* renamed from: b  reason: collision with root package name */
    c f37879b = null;

    /* renamed from: c  reason: collision with root package name */
    private CaptureConfiguration f37880c;

    /* renamed from: d  reason: collision with root package name */
    private VideoCaptureView f37881d;

    /* renamed from: e  reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.recorder.a f37882e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37883f;

    static {
        StubApp.interface11(15787);
    }

    private void i() {
        setResult(0);
        finish();
    }

    private void j() {
        Intent intent = new Intent();
        intent.putExtra("com.jmolsmobile.extraoutputfilename", this.f37879b.d());
        setResult(-1, intent);
        finish();
    }

    private void k(String str) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        Toast.makeText(origApplicationContext, "Can't capture video: " + str, 1).show();
        Intent intent = new Intent();
        intent.putExtra("com.jmolsmobile.extraerrormessage", str);
        setResult(753245, intent);
        finish();
    }

    private boolean m() {
        return getIntent().getBooleanExtra("com.jmolsmobile.extracamerafacing", false);
    }

    private boolean o(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("com.jmolsmobile.savedrecordedboolean", false);
    }

    private void q(Bundle bundle) {
        this.f37880c = l();
        this.f37878a = o(bundle);
        this.f37879b = n(bundle);
        this.f37883f = m();
    }

    private void r() {
        this.f37882e = new com.jmolsmobile.landscapevideocapture.recorder.a(this, this.f37880c, this.f37879b, new com.jmolsmobile.landscapevideocapture.camera.b(new com.jmolsmobile.landscapevideocapture.camera.c(), ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation()), this.f37881d.getPreviewSurfaceHolder(), this.f37883f);
        this.f37881d.setRecordingButtonInterface(this);
        this.f37881d.setCameraSwitchingEnabled(this.f37880c.i());
        this.f37881d.setCameraFacing(this.f37883f);
        if (this.f37878a) {
            this.f37881d.i(p());
        } else {
            this.f37881d.h();
        }
        this.f37881d.f(this.f37880c.p());
    }

    private void s() {
        com.jmolsmobile.landscapevideocapture.recorder.a aVar = this.f37882e;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void a() {
        try {
            this.f37882e.n();
        } catch (AlreadyUsedException unused) {
            b.a("VideoCapture_Activity", "Cannot toggle recording after cleaning up all resources");
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void b() {
        i();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void c(String str) {
        k(str);
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void d() {
        this.f37881d.j();
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void e() {
        j();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void f(String str) {
        if (str != null) {
            Toast.makeText(this, str, 1).show();
        }
        this.f37881d.i(p());
        s();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void g() {
        this.f37878a = true;
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void h(boolean z3) {
        Intent intent = new Intent(this, VideoCaptureActivity.class);
        intent.putExtras(getIntent().getExtras());
        intent.putExtra("com.jmolsmobile.extracamerafacing", z3);
        startActivityForResult(intent, 578465);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    protected CaptureConfiguration l() {
        CaptureConfiguration captureConfiguration = (CaptureConfiguration) getIntent().getParcelableExtra("com.jmolsmobile.extracaptureconfiguration");
        if (captureConfiguration == null) {
            CaptureConfiguration l4 = CaptureConfiguration.l();
            b.a("VideoCapture_Activity", "No captureconfiguration passed - using default configuration");
            return l4;
        }
        return captureConfiguration;
    }

    protected c n(Bundle bundle) {
        if (bundle != null) {
            return new c(bundle.getString("com.jmolsmobile.savedoutputfilename"));
        }
        return new c(getIntent().getStringExtra("com.jmolsmobile.extraoutputfilename"));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i4, int i5, Intent intent) {
        setResult(i5, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        i();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onPause() {
        com.jmolsmobile.landscapevideocapture.recorder.a aVar = this.f37882e;
        if (aVar != null) {
            aVar.m(null);
        }
        s();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.jmolsmobile.savedrecordedboolean", this.f37878a);
        bundle.putString("com.jmolsmobile.savedoutputfilename", this.f37879b.d());
        super.onSaveInstanceState(bundle);
    }

    public Bitmap p() {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f37879b.d(), 2);
        if (createVideoThumbnail == null) {
            b.a("VideoCapture_Activity", "Failed to generate video preview");
        }
        return createVideoThumbnail;
    }
}
