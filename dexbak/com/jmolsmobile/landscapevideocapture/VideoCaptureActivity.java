package com.jmolsmobile.landscapevideocapture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import com.jmolsmobile.landscapevideocapture.camera.CameraWrapper;
import com.jmolsmobile.landscapevideocapture.camera.NativeCamera;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.recorder.AlreadyUsedException;
import com.jmolsmobile.landscapevideocapture.recorder.C7141a;
import com.jmolsmobile.landscapevideocapture.recorder.VideoRecorderInterface;
import com.jmolsmobile.landscapevideocapture.view.RecordingButtonInterface;
import com.jmolsmobile.landscapevideocapture.view.VideoCaptureView;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoCaptureActivity extends Activity implements RecordingButtonInterface, VideoRecorderInterface {

    /* renamed from: g */
    public static final int f24322g = 753245;

    /* renamed from: h */
    private static final int f24323h = 578465;

    /* renamed from: i */
    public static final String f24324i = "com.jmolsmobile.extraoutputfilename";

    /* renamed from: j */
    public static final String f24325j = "com.jmolsmobile.extracaptureconfiguration";

    /* renamed from: k */
    public static final String f24326k = "com.jmolsmobile.extraerrormessage";

    /* renamed from: l */
    private static final String f24327l = "com.jmolsmobile.extracamerafacing";

    /* renamed from: m */
    private static final String f24328m = "com.jmolsmobile.savedrecordedboolean";

    /* renamed from: n */
    protected static final String f24329n = "com.jmolsmobile.savedoutputfilename";

    /* renamed from: a */
    private boolean f24330a = false;

    /* renamed from: b */
    VideoFile f24331b = null;

    /* renamed from: c */
    private CaptureConfiguration f24332c;

    /* renamed from: d */
    private VideoCaptureView f24333d;

    /* renamed from: e */
    private C7141a f24334e;

    /* renamed from: f */
    private boolean f24335f;

    static {
        StubApp.interface11(15787);
    }

    /* renamed from: i */
    private void m34565i() {
        setResult(0);
        finish();
    }

    /* renamed from: j */
    private void m34564j() {
        Intent intent = new Intent();
        intent.putExtra(f24324i, this.f24331b.m34548d());
        setResult(-1, intent);
        finish();
    }

    /* renamed from: k */
    private void m34563k(String str) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        Toast.makeText(origApplicationContext, "Can't capture video: " + str, 1).show();
        Intent intent = new Intent();
        intent.putExtra(f24326k, str);
        setResult(f24322g, intent);
        finish();
    }

    /* renamed from: m */
    private boolean m34561m() {
        return getIntent().getBooleanExtra(f24327l, false);
    }

    /* renamed from: o */
    private boolean m34559o(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(f24328m, false);
    }

    /* renamed from: q */
    private void m34557q(Bundle bundle) {
        this.f24332c = m34562l();
        this.f24330a = m34559o(bundle);
        this.f24331b = m34560n(bundle);
        this.f24335f = m34561m();
    }

    /* renamed from: r */
    private void m34556r() {
        this.f24334e = new C7141a(this, this.f24332c, this.f24331b, new CameraWrapper(new NativeCamera(), ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation()), this.f24333d.getPreviewSurfaceHolder(), this.f24335f);
        this.f24333d.setRecordingButtonInterface(this);
        this.f24333d.setCameraSwitchingEnabled(this.f24332c.m34506i());
        this.f24333d.setCameraFacing(this.f24335f);
        if (this.f24330a) {
            this.f24333d.m34454i(m34558p());
        } else {
            this.f24333d.m34455h();
        }
        this.f24333d.m34457f(this.f24332c.m34499p());
    }

    /* renamed from: s */
    private void m34555s() {
        C7141a c7141a = this.f24334e;
        if (c7141a != null) {
            c7141a.m34473h();
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.RecordingButtonInterface
    /* renamed from: a */
    public void mo34452a() {
        try {
            this.f24334e.m34467n();
        } catch (AlreadyUsedException unused) {
            CLog.m34554a(CLog.f24344b, "Cannot toggle recording after cleaning up all resources");
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.RecordingButtonInterface
    /* renamed from: b */
    public void mo34451b() {
        m34565i();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.VideoRecorderInterface
    /* renamed from: c */
    public void mo34466c(String str) {
        m34563k(str);
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.VideoRecorderInterface
    /* renamed from: d */
    public void mo34465d() {
        this.f24333d.m34453j();
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.RecordingButtonInterface
    /* renamed from: e */
    public void mo34450e() {
        m34564j();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.VideoRecorderInterface
    /* renamed from: f */
    public void mo34464f(String str) {
        if (str != null) {
            Toast.makeText(this, str, 1).show();
        }
        this.f24333d.m34454i(m34558p());
        m34555s();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.VideoRecorderInterface
    /* renamed from: g */
    public void mo34463g() {
        this.f24330a = true;
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.RecordingButtonInterface
    /* renamed from: h */
    public void mo34449h(boolean z) {
        Intent intent = new Intent(this, VideoCaptureActivity.class);
        intent.putExtras(getIntent().getExtras());
        intent.putExtra(f24327l, z);
        startActivityForResult(intent, f24323h);
        overridePendingTransition(C7131R.anim.from_middle, C7131R.anim.to_middle);
    }

    /* renamed from: l */
    protected CaptureConfiguration m34562l() {
        CaptureConfiguration captureConfiguration = (CaptureConfiguration) getIntent().getParcelableExtra(f24325j);
        if (captureConfiguration == null) {
            CaptureConfiguration m34503l = CaptureConfiguration.m34503l();
            CLog.m34554a(CLog.f24344b, "No captureconfiguration passed - using default configuration");
            return m34503l;
        }
        return captureConfiguration;
    }

    /* renamed from: n */
    protected VideoFile m34560n(Bundle bundle) {
        if (bundle != null) {
            return new VideoFile(bundle.getString(f24329n));
        }
        return new VideoFile(getIntent().getStringExtra(f24324i));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        setResult(i2, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m34565i();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onPause() {
        C7141a c7141a = this.f24334e;
        if (c7141a != null) {
            c7141a.m34468m(null);
        }
        m34555s();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f24328m, this.f24330a);
        bundle.putString(f24329n, this.f24331b.m34548d());
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: p */
    public Bitmap m34558p() {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f24331b.m34548d(), 2);
        if (createVideoThumbnail == null) {
            CLog.m34554a(CLog.f24344b, "Failed to generate video preview");
        }
        return createVideoThumbnail;
    }
}
