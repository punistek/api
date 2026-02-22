package com.tflix.live;

import D1.E;
import E.c;
import E4.f;
import E4.h;
import H5.C;
import H5.D;
import H5.I;
import H5.J;
import H5.K;
import H5.y;
import I3.N0;
import K5.b;
import N5.x;
import P.k0;
import P5.a;
import W0.q;
import Y5.j;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.H;
import androidx.fragment.app.L;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.internal.measurement.K1;
import com.google.android.material.button.MaterialButton;
import com.tflix.live.app.ProApplication;
import com.tflix.live.tv.TvSplashActivity;
import d.g;
import g.e;
import g.k;
import g.o;
import k2.d;
import u5.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SplashActivity extends k {
    public static final /* synthetic */ int e0 = 0;
    public ProApplication U;
    public b V;
    public boolean X;
    public boolean Y;
    public E Z;
    public a a0;
    public String b0;
    public int c0;
    public int W = 0;
    public final g d0 = l(new H(2), new h(9));

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (action == 1 && keyCode == 4) {
            super.onBackPressed();
            return true;
        }
        E e = this.Z;
        if (e != null) {
            if (action == 0 && keyCode != 4) {
                int r0 = e.v;
                SplashActivity splashActivity = (SplashActivity) e.x;
                N0 n0 = (N0) e.w;
                CardView cardView = (CardView) n0.v;
                CardView cardView2 = (CardView) n0.w;
                if (r0 == 0) {
                    cardView2.setCardBackgroundColor(splashActivity.getColor(y.jet_black));
                    cardView.setCardBackgroundColor(splashActivity.getColor(y.red));
                    e.v = 1;
                } else {
                    cardView2.setCardBackgroundColor(splashActivity.getColor(y.red));
                    cardView.setCardBackgroundColor(splashActivity.getColor(y.jet_black));
                    e.v = 0;
                }
            } else if (action == 1 && (keyCode == 23 || keyCode == 66)) {
                j.s(this).edit().putInt("non_touchscreen_ac", 0).apply();
                this.Z.g();
                this.Z = null;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void onCreate(Bundle bundle) {
        MaterialButton h;
        RelativeLayout h2;
        LinearLayout h3;
        MaterialButton h4;
        MaterialButton h5;
        FragmentContainerView h6;
        MaterialButton h7;
        CardView h8;
        o.l();
        super.onCreate(bundle);
        LinearLayout inflate = getLayoutInflater().inflate(D.activity_splash, (ViewGroup) null, false);
        int r0 = C.app_version_txt;
        TextView h9 = K1.h(inflate, r0);
        if (h9 != null && (h = K1.h(inflate, (r0 = C.clear_data_btn))) != null) {
            r0 = C.icon;
            if (K1.h(inflate, r0) != null && (h2 = K1.h(inflate, (r0 = C.loading_layout))) != null && (h3 = K1.h(inflate, (r0 = C.ly_offline))) != null && (h4 = K1.h(inflate, (r0 = C.mobile_data_btn))) != null && (h5 = K1.h(inflate, (r0 = C.refresh_btn))) != null) {
                LinearLayout linearLayout = inflate;
                int r10 = C.splash_anim_view;
                LottieAnimationView h10 = K1.h(inflate, r10);
                if (h10 != null && (h6 = K1.h(inflate, (r10 = C.update_fragment_container))) != null && (h7 = K1.h(inflate, (r10 = C.wifi_setting_btn))) != null) {
                    b bVar = new b();
                    bVar.b = h9;
                    bVar.c = h;
                    bVar.g = h2;
                    bVar.h = h3;
                    bVar.d = h4;
                    bVar.e = h5;
                    bVar.i = h10;
                    bVar.a = h6;
                    bVar.f = h7;
                    this.V = bVar;
                    setContentView((View) linearLayout);
                    this.U = (ProApplication) getApplication();
                    boolean hasSystemFeature = getPackageManager().hasSystemFeature("android.software.leanback");
                    this.Y = hasSystemFeature;
                    if (hasSystemFeature || getPackageManager().hasSystemFeature("com.google.android.tv") || ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4) {
                        startActivity(new Intent(this, TvSplashActivity.class));
                        finish();
                        return;
                    }
                    if (getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                        u();
                        return;
                    }
                    int r15 = getSharedPreferences("DataPreferences", 0).getInt("non_touchscreen_ac", -1);
                    if (r15 != -1) {
                        if (r15 != 0) {
                            u();
                            return;
                        } else {
                            startActivity(new Intent(this, TvSplashActivity.class));
                            finish();
                            return;
                        }
                    }
                    J j = new J(this);
                    g.h hVar = new g.h(this);
                    LinearLayout inflate2 = LayoutInflater.from(this).inflate(D.dialog_platform, (ViewGroup) null, false);
                    int r3 = C.others_btn;
                    CardView h11 = K1.h(inflate2, r3);
                    if (h11 == null || (h8 = K1.h(inflate2, (r3 = C.smart_tv_btn))) == null) {
                        throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(r3)));
                    }
                    LinearLayout linearLayout2 = inflate2;
                    N0 n0 = new N0(linearLayout2, h11, h8, 26);
                    hVar.setView(linearLayout2);
                    hVar.setTitle("I am using app in");
                    e eVar = hVar.a;
                    eVar.f = "Press Enter/Ok button to continue";
                    eVar.k = false;
                    this.Z = new E(n0, this, hVar.c(), j);
                    return;
                }
                r0 = r10;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(r0)));
    }

    public final void onResume() {
        super.onResume();
        Q5.b.a(this);
    }

    public final void r(String str) {
        if (t()) {
            j.j(this, str.concat("app.json"), null, new B0.b(4, this, str), !this.Y);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new A0.a(12, this), 500L);
        }
    }

    public final void s() {
        if (!t()) {
            new Handler(Looper.getMainLooper()).postDelayed(new A0.a(12, this), 500L);
            return;
        }
        String n = j.n(this);
        if (!this.X && !n.equals("https://error_pro.com")) {
            r(n);
            return;
        }
        u5.b a = ((i) f.c().b(i.class)).a();
        q qVar = new q(3);
        qVar.a = 0L;
        q qVar2 = new q(qVar);
        a.getClass();
        x3.a.h(a.c, new d(2, a, qVar2));
        a.d(I.remote_config_defaults);
        a.a().b(new B0.b(3, this, a));
    }

    public final boolean t() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (Build.VERSION.SDK_INT > 28) {
            return connectivityManager.getActiveNetwork() != null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void u() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= 29) {
                this.c0 = (int) k0.b(packageInfo);
            } else {
                this.c0 = packageInfo.versionCode;
            }
            ((TextView) this.V.b).setText("Version: " + packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        j.s(this).edit().putInt("non_touchscreen_ac", 1).apply();
        j.L(this, 0);
        if (Build.VERSION.SDK_INT >= 33 && c.a(this, "android.permission.POST_NOTIFICATIONS") != 0 && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
            this.d0.a("android.permission.POST_NOTIFICATIONS");
        }
        ((MaterialButton) this.V.e).setOnClickListener(new K(this, 0));
        ((MaterialButton) this.V.f).setOnClickListener(new K(this, 1));
        ((MaterialButton) this.V.d).setOnClickListener(new K(this, 2));
        ((MaterialButton) this.V.c).setOnClickListener(new K(this, 3));
        Q5.b.a(this);
        s();
    }

    public final void v(String str) {
        j.t(this).putString("new_api_host", "https://error_pro.com").apply();
        int r0 = this.W;
        if (r0 == 0) {
            this.X = true;
            s();
        } else if (r0 < 2) {
            r(str);
        } else {
            ((LinearLayout) this.V.h).setVisibility(0);
            ((LottieAnimationView) this.V.i).setVisibility(8);
        }
        this.W++;
    }

    public final void w() {
        a aVar = this.a0;
        if (aVar == null) {
            return;
        }
        if (aVar.R == this.c0) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("appDetail", this.a0);
            startActivity(intent);
            finish();
            return;
        }
        ((RelativeLayout) this.V.g).setVisibility(8);
        ((FragmentContainerView) this.V.a).setVisibility(0);
        Z5.c cVar = (Z5.c) new K5.e(this).y(Z5.c.class);
        cVar.g = this.c0;
        cVar.f = this.b0;
        cVar.e = this.a0.B;
        cVar.d = new J(this);
        x xVar = new x();
        L m = m();
        androidx.fragment.app.a f = I1.a.f(m, m);
        f.f(C.update_fragment_container, xVar, null, 1);
        f.d(false);
    }
}
