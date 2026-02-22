package com.tflix.live;

import A0.L;
import A0.o;
import B0.b;
import B3.d;
import D0.h;
import F0.g;
import G1.I;
import G1.K;
import H5.A;
import H5.C;
import H5.D;
import H5.l;
import H5.m;
import H5.n;
import H5.t;
import L5.B;
import N5.s;
import N5.x;
import O0.p;
import P.k0;
import P.s0;
import P.t0;
import P.u0;
import P.v;
import P.v0;
import P5.a;
import P5.e;
import Y5.j;
import android.app.PictureInPictureParams;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.media3.exoplayer.dash.DashMediaSource$Factory;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.K1;
import com.google.android.material.card.MaterialCardView;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.tflix.live.app.ProApplication;
import g.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t2.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PlayerActivity extends k {
    public static final /* synthetic */ int G0 = 0;
    public t A0;
    public Handler B0;
    public n C0;
    public a D0;
    public String E0;
    public String F0;
    public ProApplication U;
    public K5.a V;
    public K5.a W;
    public s X;
    public RecyclerView Y;
    public I5.n Z;
    public I5.n a0;
    public ArrayList b0;
    public c c0;
    public L d0;
    public PlayerView e0;
    public B f0;
    public String g0;
    public String h0;
    public String i0;
    public String j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public float r0;
    public int s0;
    public int t0;
    public int u0;
    public boolean w0;
    public boolean x0;
    public boolean y0;
    public final t5.c v0 = new t5.c(14, this);
    public boolean z0 = true;

    public static void y(Map map, u.c cVar) {
        if (map.isEmpty()) {
            return;
        }
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if ("user-agent".equals(str.toLowerCase())) {
                String str2 = (String) entry.getValue();
                if ("null".equals(str2)) {
                    str2 = "";
                }
                cVar.x = str2;
                map.remove(str);
            }
        }
        cVar.b(map);
    }

    public final void A(String str, boolean z) {
        if (this.V == null) {
            return;
        }
        L l = this.d0;
        if (l != null) {
            l.Y();
        }
        this.Z = null;
        this.a0 = null;
        if (z) {
            j.i(this, j.h(this, str), new H5.k(this, 3));
            return;
        }
        if (str.contains("[*]")) {
            String[] split = str.split("\\[\\*\\]");
            j.i(this, split[0], new b(10, split[1], new H5.k(this, 4)));
            return;
        }
        try {
            String string = new JSONObject(str).getString("links");
            if (!string.startsWith("[")) {
                string = Q5.a.b(string);
            }
            JSONArray jSONArray = new JSONArray(string);
            e b = e.b(jSONArray.getJSONObject(this.t0));
            this.g0 = b.v;
            this.h0 = b.w;
            this.i0 = b.x;
            this.j0 = b.y;
            this.u0 = b.z;
            if (jSONArray.length() > 1) {
                B(jSONArray);
            }
        } catch (JSONException e) {
            Log.e("Pro", "JSONException", e);
            Toast.makeText(this, e.toString(), 1).show();
            this.g0 = "https://pro.com";
            this.h0 = null;
            this.i0 = null;
            this.j0 = null;
            this.u0 = 0;
        }
        v(this.g0, this.h0, this.i0, this.j0, null);
    }

    public final void B(JSONArray jSONArray) {
        this.c0 = new c(14, this);
        ArrayList a = e.a(jSONArray);
        this.b0 = a;
        I5.n nVar = new I5.n(this, a, this.c0);
        this.Z = nVar;
        nVar.h = this.t0;
        RecyclerView findViewById = this.e0.findViewById(C.link_recycler_view);
        this.Y = findViewById;
        findViewById.setAdapter(this.Z);
        this.Y.setLayoutManager(new LinearLayoutManager(0));
        new Handler(Looper.getMainLooper()).postDelayed(new n(this, 0), 100L);
        I5.n nVar2 = new I5.n(this, this.b0, this.c0);
        this.a0 = nVar2;
        nVar2.i = true;
        nVar2.h = this.t0;
        ((RecyclerView) this.V.j).setAdapter(nVar2);
        ((RecyclerView) this.V.j).setLayoutManager(new LinearLayoutManager(0));
        ((RecyclerView) this.V.j).setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new n(this, 1), 100L);
    }

    public final void C() {
        if (Build.VERSION.SDK_INT < 30) {
            getWindow().clearFlags(1024);
            getWindow().getDecorView().setSystemUiVisibility(0);
            return;
        }
        Window window = getWindow();
        v vVar = new v(getWindow().getDecorView());
        int r2 = Build.VERSION.SDK_INT;
        (r2 >= 35 ? new v0(window, vVar) : r2 >= 30 ? new u0(window, vVar) : r2 >= 26 ? new t0(window, vVar) : new s0(window, vVar)).K(o.B());
        r0.c.r(getWindow(), true);
    }

    public final void D() {
        if (!this.o0) {
            setRequestedOrientation(6);
            z();
            u();
            this.e0.setResizeMode(3);
            ((ImageButton) this.W.k).setImageResource(A.mode_crop);
            ((ImageButton) this.W.j).setImageResource(I.exo_ic_fullscreen_exit);
            this.o0 = true;
            ((FragmentContainerView) this.V.c).setVisibility(8);
            return;
        }
        setRequestedOrientation(1);
        LinearLayout.LayoutParams layoutParams = ((RelativeLayout) this.V.g).getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.s0;
        ((RelativeLayout) this.V.g).setLayoutParams(layoutParams);
        C();
        this.e0.setResizeMode(0);
        ((ImageButton) this.W.k).setImageResource(A.mode_fill);
        ((ImageButton) this.W.j).setImageResource(I.exo_ic_fullscreen_enter);
        this.o0 = false;
        ((FragmentContainerView) this.V.c).setVisibility(0);
    }

    public final void onBackPressed() {
        if (this.o0 && !this.p0) {
            D();
            return;
        }
        ProApplication proApplication = this.U;
        proApplication.u = null;
        proApplication.w = null;
        L l = this.d0;
        if (l != null) {
            l.Y();
        }
        if (this.y0) {
            super.onBackPressed();
            return;
        }
        if (this.D0 == null) {
            startActivity(new Intent(this, SplashActivity.class));
            finish();
            return;
        }
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            int b = Build.VERSION.SDK_INT >= 29 ? (int) k0.b(packageInfo) : packageInfo.versionCode;
            if (this.D0.R != b) {
                ((RelativeLayout) this.V.g).setVisibility(8);
                ((RecyclerView) this.V.j).setVisibility(8);
                ((FragmentContainerView) this.V.c).setVisibility(8);
                ((FragmentContainerView) this.V.d).setVisibility(0);
                Z5.c cVar = (Z5.c) new K5.e(this).y(Z5.c.class);
                cVar.g = b;
                cVar.f = this.E0;
                cVar.e = this.D0.B;
                cVar.d = new H5.k(this, 0);
                x xVar = new x();
                androidx.fragment.app.L m = m();
                m.getClass();
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(m);
                aVar.f(C.update_fragment_container, xVar, null, 1);
                aVar.d(false);
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("appDetail", this.D0);
        startActivity(intent);
        finish();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((Build.VERSION.SDK_INT >= 24 ? C0.C.A(this) : false) || !this.q0) {
            return;
        }
        x(false);
    }

    public final void onCreate(Bundle bundle) {
        MaterialCardView h;
        TextView h2;
        RelativeLayout h3;
        PlayerView h4;
        ProgressBar h5;
        RecyclerView h6;
        ImageView h7;
        LinearLayout h8;
        TextView h9;
        FragmentContainerView h10;
        ImageButton h11;
        ImageButton h12;
        ImageButton h13;
        ImageButton h14;
        ImageButton h15;
        ImageButton h16;
        ImageButton h17;
        ImageButton h18;
        ImageButton h19;
        LinearLayout h20;
        TextView h21;
        boolean z;
        boolean z2;
        androidx.activity.n.a(this);
        super.onCreate(bundle);
        LinearLayout inflate = getLayoutInflater().inflate(D.activity_player, (ViewGroup) null, false);
        int r3 = C.fragment_container;
        FragmentContainerView h22 = K1.h(inflate, r3);
        if (h22 != null && (h = K1.h(inflate, (r3 = C.message_card))) != null && (h2 = K1.h(inflate, (r3 = C.message_txt))) != null && (h3 = K1.h(inflate, (r3 = C.playerLayout))) != null && (h4 = K1.h(inflate, (r3 = C.player_view))) != null && (h5 = K1.h(inflate, (r3 = C.progress))) != null && (h6 = K1.h(inflate, (r3 = C.recycler_view))) != null && (h7 = K1.h(inflate, (r3 = C.swipeImageView))) != null && (h8 = K1.h(inflate, (r3 = C.swipeIndicatorContainer))) != null) {
            r3 = C.swipeProgressBar;
            CircularProgressBar circularProgressBar = (CircularProgressBar) K1.h(inflate, r3);
            if (circularProgressBar != null && (h9 = K1.h(inflate, (r3 = C.swipeTextView))) != null && (h10 = K1.h(inflate, (r3 = C.update_fragment_container))) != null) {
                K5.a aVar = new K5.a();
                aVar.c = h22;
                aVar.e = h;
                aVar.b = h2;
                aVar.g = h3;
                aVar.h = h4;
                aVar.i = h5;
                aVar.j = h6;
                aVar.k = h7;
                aVar.a = h8;
                aVar.l = circularProgressBar;
                aVar.f = h9;
                aVar.d = h10;
                this.V = aVar;
                setContentView((View) inflate);
                PlayerView playerView = (PlayerView) this.V.h;
                this.e0 = playerView;
                ConstraintLayout findViewById = playerView.findViewById(C.player_controls);
                int r2 = C.bottom_controller;
                LinearLayout h23 = K1.h(findViewById, r2);
                if (h23 != null && (h11 = K1.h(findViewById, (r2 = C.btn_back))) != null && (h12 = K1.h(findViewById, (r2 = C.btn_lock_unlock))) != null && (h13 = K1.h(findViewById, (r2 = C.btn_pip))) != null && (h14 = K1.h(findViewById, (r2 = C.btn_settings))) != null) {
                    r2 = K.exo_duration;
                    if (K1.h(findViewById, r2) != null) {
                        r2 = K.exo_ffwd;
                        if (K1.h(findViewById, r2) != null && (h15 = K1.h(findViewById, (r2 = C.exo_pause))) != null && (h16 = K1.h(findViewById, (r2 = C.exo_play))) != null) {
                            r2 = K.exo_position;
                            if (K1.h(findViewById, r2) != null) {
                                r2 = K.exo_progress;
                                if (((DefaultTimeBar) K1.h(findViewById, r2)) != null) {
                                    r2 = K.exo_rew;
                                    if (K1.h(findViewById, r2) != null && (h17 = K1.h(findViewById, (r2 = C.exo_volume))) != null && (h18 = K1.h(findViewById, (r2 = C.fullscreen))) != null) {
                                        r2 = C.link_recycler_view;
                                        if (K1.h(findViewById, r2) != null && (h19 = K1.h(findViewById, (r2 = C.resize_mode))) != null && (h20 = K1.h(findViewById, (r2 = C.timer_bar_ly))) != null && (h21 = K1.h(findViewById, (r2 = C.title))) != null) {
                                            r2 = C.top_btns;
                                            if (K1.h(findViewById, r2) != null) {
                                                K5.a aVar2 = new K5.a();
                                                aVar2.a = h23;
                                                aVar2.c = h11;
                                                aVar2.d = h12;
                                                aVar2.e = h13;
                                                aVar2.f = h14;
                                                aVar2.g = h15;
                                                aVar2.h = h16;
                                                aVar2.i = h17;
                                                aVar2.j = h18;
                                                aVar2.k = h19;
                                                aVar2.l = h20;
                                                aVar2.b = h21;
                                                this.W = aVar2;
                                                h21.setSelected(true);
                                                ((ImageButton) this.W.c).setOnClickListener(new l(this, 1));
                                                int r1 = Build.VERSION.SDK_INT;
                                                if (r1 < 26 || !getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                                                    ((ImageButton) this.W.e).setVisibility(8);
                                                } else {
                                                    ((ImageButton) this.W.e).setOnClickListener(new l(this, 2));
                                                }
                                                ((ImageButton) this.W.h).setOnClickListener(new l(this, 3));
                                                ((ImageButton) this.W.g).setOnClickListener(new l(this, 4));
                                                ((ImageButton) this.W.d).setOnClickListener(new l(this, 5));
                                                ((ImageButton) this.W.k).setOnClickListener(new l(this, 6));
                                                ((ImageButton) this.W.f).setOnClickListener(new l(this, 7));
                                                ((ImageButton) this.W.i).setOnClickListener(new l(this, 8));
                                                ((ImageButton) this.W.j).setOnClickListener(new l(this, 9));
                                                this.A0 = new t(this, this.V, this.e0, this.d0);
                                                C();
                                                ProApplication proApplication = (ProApplication) getApplication();
                                                this.U = proApplication;
                                                proApplication.u = this;
                                                proApplication.w = new H5.k(this, 1);
                                                String str = proApplication.D;
                                                if (str != null) {
                                                    ((TextView) this.V.b).setText(str);
                                                    z = true;
                                                    ((TextView) this.V.b).setSelected(true);
                                                    ((MaterialCardView) this.V.e).setOnClickListener(new l(this, 0));
                                                } else {
                                                    z = true;
                                                }
                                                Intent intent = getIntent();
                                                this.y0 = intent.getBooleanExtra("fromSplash", z);
                                                if (intent.hasExtra("links_model")) {
                                                    e eVar = r1 > 33 ? (e) C0.a.m(intent) : (e) intent.getParcelableExtra("links_model");
                                                    if (eVar != null) {
                                                        this.g0 = eVar.v;
                                                        this.h0 = eVar.w;
                                                        this.u0 = eVar.z;
                                                        this.j0 = eVar.y;
                                                    } else {
                                                        this.g0 = "https://pro.com";
                                                    }
                                                    this.F0 = "";
                                                    z();
                                                    v(this.g0, this.h0, this.i0, this.j0, null);
                                                } else if (intent.getData() != null) {
                                                    String uri = intent.getData().toString();
                                                    j.j(this, j.n(this) + "app.json", null, new H5.k(this, 2), false);
                                                    String lowerCase = uri.toLowerCase();
                                                    StringBuilder sb = new StringBuilder(uri);
                                                    if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                                        String[] split = uri.split("\\|");
                                                        ArrayList u = j.u(split[1], "drmlicense");
                                                        StringBuilder sb2 = new StringBuilder(split[0] + "|" + ((String) u.get(0)));
                                                        if (!TextUtils.isEmpty((CharSequence) u.get(1))) {
                                                            this.h0 = (String) u.get(1);
                                                        }
                                                        sb = sb2;
                                                    }
                                                    if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                                        String[] split2 = sb.toString().split("\\|");
                                                        ArrayList u2 = j.u(split2[1], "drmscheme");
                                                        sb = new StringBuilder(split2[0] + "|" + ((String) u2.get(0)));
                                                        if (!TextUtils.isEmpty((CharSequence) u2.get(1))) {
                                                            String lowerCase2 = ((String) u2.get(1)).toLowerCase();
                                                            lowerCase2.getClass();
                                                            this.u0 = !lowerCase2.equals("widevine") ? !lowerCase2.equals("clearkey") ? 2 : 0 : 1;
                                                        }
                                                    }
                                                    String sb3 = sb.toString();
                                                    if (sb3.indexOf("|") + 1 >= sb3.length()) {
                                                        z2 = false;
                                                        sb = new StringBuilder(sb3.split("\\|")[0]);
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    this.y0 = z2;
                                                    this.g0 = sb.toString();
                                                    this.i0 = null;
                                                    this.j0 = null;
                                                    this.F0 = "";
                                                    z();
                                                    v(this.g0, this.h0, this.i0, this.j0, null);
                                                } else {
                                                    boolean booleanExtra = intent.getBooleanExtra("isEncoded", true);
                                                    String stringExtra = intent.getStringExtra("links");
                                                    this.F0 = intent.hasExtra("title") ? intent.getStringExtra("title") : "";
                                                    this.t0 = intent.getIntExtra("position", 0);
                                                    if (!this.y0) {
                                                        j.L(this, -1);
                                                    }
                                                    A(stringExtra, booleanExtra);
                                                    this.U.C = stringExtra;
                                                }
                                                this.s0 = ((RelativeLayout) this.V.g).getLayoutParams().height;
                                                this.X = new s();
                                                androidx.fragment.app.L m = m();
                                                androidx.fragment.app.a f = I1.a.f(m, m);
                                                f.f(C.fragment_container, this.X, null, 1);
                                                f.d(false);
                                                r();
                                                if (getResources().getConfiguration().orientation == 2) {
                                                    this.p0 = true;
                                                    ((ImageButton) this.W.j).setClickable(false);
                                                    ((ImageButton) this.W.j).setEnabled(false);
                                                    ((ImageButton) this.W.j).setAlpha(0.5f);
                                                    D();
                                                }
                                                new Handler(Looper.getMainLooper()).postDelayed(new n(this, 3), 500L);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(r2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(r3)));
    }

    public final void onDestroy() {
        L l = this.d0;
        if (l != null) {
            l.Y();
        }
        this.V = null;
        super.onDestroy();
    }

    public final void onPause() {
        this.m0 = true;
        if (!(Build.VERSION.SDK_INT >= 24 ? C0.C.A(this) : false) && this.d0 != null) {
            ((ImageButton) this.W.g).callOnClick();
        }
        this.U.H = null;
        super.onPause();
    }

    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
        if (!z) {
            this.e0.setControllerAutoShow(true);
            if (!this.o0) {
                if (this.a0 != null) {
                    ((RecyclerView) this.V.j).setVisibility(0);
                }
                ((FragmentContainerView) this.V.c).setVisibility(0);
                LinearLayout.LayoutParams layoutParams = ((RelativeLayout) this.V.g).getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = this.s0;
                ((RelativeLayout) this.V.g).setLayoutParams(layoutParams);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new n(this, 5), 500L);
            return;
        }
        this.q0 = false;
        B b = this.f0;
        if (b != null) {
            b.P(false, false);
        }
        this.e0.b();
        this.e0.setControllerAutoShow(false);
        if (this.o0) {
            return;
        }
        if (this.a0 != null) {
            ((RecyclerView) this.V.j).setVisibility(8);
        }
        ((FragmentContainerView) this.V.c).setVisibility(8);
        z();
    }

    public final void onResume() {
        super.onResume();
        this.m0 = false;
        this.x0 = false;
        Q5.b.a(this);
        if (this.d0 == null || this.k0 || ((ImageButton) this.W.h).getVisibility() != 0) {
            return;
        }
        ((ImageButton) this.W.h).callOnClick();
    }

    public final void onUserLeaveHint() {
        if (this.w0 && !this.x0) {
            s();
        }
        super.onUserLeaveHint();
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: BlockSplitter
        LL1ili1iI1iI.IIiLliI1l1li1: Unexpected missing predecessor for block: B:8:0x003d
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(Unknown Source:165)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(Unknown Source:55)
        */
    public final void r() {
        /*
            r7 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            java.lang.String r1 = "DataPreferences"
            r2 = 0
            android.content.SharedPreferences r3 = r7.getSharedPreferences(r1, r2)
            java.lang.String r4 = "external_ad_enabled"
            boolean r3 = r3.getBoolean(r4, r2)
            if (r3 == 0) goto L66
            android.content.SharedPreferences r3 = r7.getSharedPreferences(r1, r2)
            java.lang.String r4 = "external_ad_repeat_after"
            r5 = 3
            int r3 = r3.getInt(r4, r5)
            android.content.SharedPreferences r4 = r7.getSharedPreferences(r1, r2)
            java.lang.String r5 = "player_called"
            int r4 = r4.getInt(r5, r2)
            if (r4 < r3) goto L29
            r4 = r2
        L29:
            r3 = 1
            goto L62
        L51:
        L60:
        L62:
            int r4 = r4 + r3
            Y5.j.L(r7, r4)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tflix.live.PlayerActivity.r():void");
    }

    public final void s() {
        if (this.d0 == null || Build.VERSION.SDK_INT < 26 || !getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
            return;
        }
        PictureInPictureParams.Builder b = d.b();
        d.p(b, new Rational(16, 9));
        Rect rect = new Rect();
        ((RelativeLayout) this.V.g).getGlobalVisibleRect(rect);
        d.o(b, rect);
        d.w(this, d.c(b));
    }

    public final h t(String str, String str2, u.c cVar) {
        DashMediaSource$Factory dashMediaSource$Factory = new DashMediaSource$Factory(cVar);
        int r12 = this.u0;
        UUID r2 = r12 != 0 ? r12 != 1 ? q0.e.e : q0.e.d : q0.e.c;
        if (str2.contains("http")) {
            U0.c cVar2 = new U0.c();
            cVar2.b = Uri.parse(str);
            cVar2.c = "application/dash+xml";
            p pVar = new p(r2);
            pVar.w = Uri.parse(str2);
            pVar.v = r2;
            cVar2.b(new q0.s(pVar));
            return dashMediaSource$Factory.c(cVar2.a());
        }
        U0.c cVar3 = new U0.c();
        cVar3.b = Uri.parse(str);
        cVar3.c = "application/dash+xml";
        cVar3.b(new q0.s(new p(r2)));
        q0.x a = cVar3.a();
        String M = str2.startsWith("{") ? j.M(str2) : j.B(str2);
        I3.C c = new I3.C(12);
        r2.getClass();
        g gVar = new g(r2, new c(M.getBytes()), new HashMap(), true, new int[0], true, c);
        dashMediaSource$Factory.h = new H5.a(UUID.randomUUID().toString());
        dashMediaSource$Factory.c = new H5.o(gVar, 0);
        return dashMediaSource$Factory.c(a);
    }

    public final void u() {
        if (Build.VERSION.SDK_INT < 30) {
            getWindow().setFlags(1024, 1024);
            getWindow().getDecorView().setSystemUiVisibility(5638);
            return;
        }
        Window window = getWindow();
        v vVar = new v(getWindow().getDecorView());
        int r2 = Build.VERSION.SDK_INT;
        z3.e v0Var = r2 >= 35 ? new v0(window, vVar) : r2 >= 30 ? new u0(window, vVar) : r2 >= 26 ? new t0(window, vVar) : new s0(window, vVar);
        v0Var.t(o.B());
        v0Var.I();
        r0.c.r(getWindow(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0311  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.util.Map r28) {
        /*
            Method dump skipped, instructions count: 801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tflix.live.PlayerActivity.v(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void w(int r10) {
        e eVar = (e) this.b0.get(r10);
        String replaceAll = eVar.v.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", "");
        c cVar = this.c0;
        String str = eVar.w;
        String str2 = eVar.x;
        String str3 = eVar.y;
        int r102 = eVar.z;
        PlayerActivity playerActivity = (PlayerActivity) cVar.v;
        playerActivity.g0 = replaceAll;
        playerActivity.h0 = str;
        playerActivity.i0 = str2;
        playerActivity.u0 = r102;
        playerActivity.j0 = str3;
        playerActivity.v(replaceAll, str, str2, str3, null);
    }

    public final void x(boolean z) {
        int r0;
        I5.n nVar;
        int r02;
        if (this.V == null || this.Y == null) {
            return;
        }
        if (this.o0 && (nVar = this.Z) != null) {
            int r03 = nVar.h + 1;
            if (r03 == this.b0.size()) {
                r03 = 0;
            }
            if (z) {
                this.a0.h = r03;
                w(r03);
            }
            ((RecyclerView) this.V.j).setVisibility(8);
            this.Y.setVisibility(0);
            I5.n nVar2 = this.Z;
            if (nVar2 == null || nVar2.h == (r02 = this.a0.h)) {
                return;
            }
            this.Y.h0(r02);
            new Handler(Looper.getMainLooper()).postDelayed(new m(this, r02, 1), 100L);
            return;
        }
        I5.n nVar3 = this.a0;
        if (nVar3 != null) {
            int r04 = nVar3.h + 1;
            if (r04 == this.b0.size()) {
                r04 = 0;
            }
            if (z) {
                this.Z.h = r04;
                w(r04);
            }
            ((RecyclerView) this.V.j).setVisibility(0);
            this.Y.setVisibility(8);
            I5.n nVar4 = this.a0;
            if (nVar4 == null || nVar4.h == (r0 = this.Z.h)) {
                return;
            }
            ((RecyclerView) this.V.j).h0(r0);
            new Handler(Looper.getMainLooper()).postDelayed(new m(this, r0, 0), 100L);
        }
    }

    public final void z() {
        LinearLayout.LayoutParams layoutParams = ((RelativeLayout) this.V.g).getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        ((RelativeLayout) this.V.g).setLayoutParams(layoutParams);
    }
}
