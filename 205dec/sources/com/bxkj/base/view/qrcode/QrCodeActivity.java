package com.bxkj.base.view.qrcode;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.R;
import com.orhanobut.logger.j;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class QrCodeActivity extends BaseActivity implements QRCodeView.f {

    /* renamed from: l  reason: collision with root package name */
    private QRCodeView f18869l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18870m;

    /* renamed from: n  reason: collision with root package name */
    private MediaPlayer f18871n;

    /* renamed from: k  reason: collision with root package name */
    private final float f18868k = 0.1f;

    /* renamed from: o  reason: collision with root package name */
    private final MediaPlayer.OnCompletionListener f18872o = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    private void i0() {
        if (this.f18870m && this.f18871n == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f18871n = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.f18871n.setOnCompletionListener(this.f18872o);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.f18871n.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f18871n.setVolume(0.1f, 0.1f);
                this.f18871n.prepare();
            } catch (IOException unused) {
                this.f18871n = null;
            }
        }
    }

    private void j0() {
        MediaPlayer mediaPlayer;
        if (this.f18870m && (mediaPlayer = this.f18871n) != null) {
            mediaPlayer.start();
        }
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    private void k0() {
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
    public void D() {
        j.e("\u6253\u5f00\u76f8\u673a\u51fa\u9519", new Object[0]);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
    public void H(String str) {
        j.c("result:" + str);
        Toast.makeText(this, "\u5b66\u53f7\uff1a" + str, 0).show();
        j0();
        this.f18869l.C();
        Intent intent = new Intent();
        intent.putExtra("studentID", str);
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_qr_code_scan;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f18870m = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.f18870m = false;
        }
        i0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u626b\u7801");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        ZBarView zBarView = (ZBarView) findViewById(R.id.zbarview);
        this.f18869l = zBarView;
        zBarView.setDelegate(this);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
    public void b(boolean z3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f18869l.o();
        super.onDestroy();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z3) {
        super.onPointerCaptureChanged(z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f18869l.z();
        this.f18869l.x();
        this.f18869l.C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f18869l.E();
        super.onStop();
    }
}
