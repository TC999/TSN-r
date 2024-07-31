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
import com.bxkj.base.C3801R;
import com.orhanobut.logger.C11792j;
import java.io.IOException;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class QrCodeActivity extends BaseActivity implements QRCodeView.InterfaceC1099f {

    /* renamed from: l */
    private QRCodeView f15299l;

    /* renamed from: m */
    private boolean f15300m;

    /* renamed from: n */
    private MediaPlayer f15301n;

    /* renamed from: k */
    private final float f15298k = 0.1f;

    /* renamed from: o */
    private final MediaPlayer.OnCompletionListener f15302o = new C4006a();

    /* renamed from: com.bxkj.base.view.qrcode.QrCodeActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4006a implements MediaPlayer.OnCompletionListener {
        C4006a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    /* renamed from: i0 */
    private void m43485i0() {
        if (this.f15300m && this.f15301n == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f15301n = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.f15301n.setOnCompletionListener(this.f15302o);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(C3801R.raw.beep);
            try {
                this.f15301n.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f15301n.setVolume(0.1f, 0.1f);
                this.f15301n.prepare();
            } catch (IOException unused) {
                this.f15301n = null;
            }
        }
    }

    /* renamed from: j0 */
    private void m43484j0() {
        MediaPlayer mediaPlayer;
        if (this.f15300m && (mediaPlayer = this.f15301n) != null) {
            mediaPlayer.start();
        }
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    /* renamed from: k0 */
    private void m43483k0() {
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
    /* renamed from: D */
    public void mo38629D() {
        C11792j.m20468e("打开相机出错", new Object[0]);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
    /* renamed from: H */
    public void mo38628H(String str) {
        C11792j.m20470c("result:" + str);
        Toast.makeText(this, "学号：" + str, 0).show();
        m43484j0();
        this.f15299l.m58028C();
        Intent intent = new Intent();
        intent.putExtra("studentID", str);
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_qr_code_scan;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f15300m = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.f15300m = false;
        }
        m43485i0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("扫码");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        ZBarView zBarView = (ZBarView) findViewById(C3801R.C3805id.zbarview);
        this.f15299l = zBarView;
        zBarView.setDelegate(this);
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
    /* renamed from: b */
    public void mo38627b(boolean z) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f15299l.m58007o();
        super.onDestroy();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        super.onPointerCaptureChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f15299l.m57999z();
        this.f15299l.m58001x();
        this.f15299l.m58028C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.f15299l.m58026E();
        super.onStop();
    }
}
