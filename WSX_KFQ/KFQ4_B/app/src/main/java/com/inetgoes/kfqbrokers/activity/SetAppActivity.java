package com.inetgoes.kfqbrokers.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inetgoes.kfqbrokers.Constants;
import com.inetgoes.kfqbrokers.FangApplication;
import com.inetgoes.kfqbrokers.IM_Util.XmppUtil;
import com.inetgoes.kfqbrokers.R;
import com.inetgoes.kfqbrokers.asynctast.HttpAsy;
import com.inetgoes.kfqbrokers.asynctast.PostExecute;
import com.inetgoes.kfqbrokers.manager.AppSharePrefManager;
import com.inetgoes.kfqbrokers.service.PushService;
import com.inetgoes.kfqbrokers.utils.AppUtil;
import com.inetgoes.kfqbrokers.utils.DataCleanManager;
import com.inetgoes.kfqbrokers.utils.DialogUtil;
import com.inetgoes.kfqbrokers.utils.JacksonMapper;
import com.inetgoes.kfqbrokers.utils.L;
import com.inetgoes.kfqbrokers.utils.SoundPoolUtil;
import com.inetgoes.kfqbrokers.view.CustomTitleBar;

import java.util.HashMap;
import java.util.Map;


/**
 * 设置页面
 */
public class SetAppActivity extends Activity implements View.OnClickListener {
    private static Activity activity;
    private View item_layout;
    private Button out_login;
    private TextView iv_cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomTitleBar.getTitleBar(this, "设置", true, false);
        setContentView(R.layout.activity_set_app);

        activity = SetAppActivity.this;

        initView();
    }

    private void initView() {

        //消息设置
        item_layout = findViewById(R.id.set_layout_mess);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("消息设置");
            item_layout.findViewById(R.id.set_hitm).setVisibility(View.GONE);
            item_layout.setOnClickListener(this);
        }

        //版本更新
        item_layout = findViewById(R.id.set_layout_version);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("软件版本更新");
            // TODO 软件版本
            ((TextView) item_layout.findViewById(R.id.set_hitm)).setText("当前已是最新版本");
            item_layout.setOnClickListener(this);
        }

        //清除缓存
        item_layout = findViewById(R.id.set_layout_cache);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("清除缓存");
            try {
                String cache = DataCleanManager.getTotalCacheSize(getApplicationContext());
                Log.e("SetAppActivity", "缓存" + cache);
                iv_cache = (TextView) item_layout.findViewById(R.id.set_hitm);
                iv_cache.setText(cache);
            } catch (Exception e) {
                e.printStackTrace();
            }
            item_layout.setOnClickListener(this);
        }


        item_layout = findViewById(R.id.set_layout_opinion);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("意见反馈");
            item_layout.findViewById(R.id.set_hitm).setVisibility(View.GONE);
            item_layout.setOnClickListener(this);
        }


        item_layout = findViewById(R.id.set_layout_contact);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("联系我们");
            item_layout.findViewById(R.id.set_hitm).setVisibility(View.GONE);
            item_layout.setOnClickListener(this);
        }


//        item_layout = findViewById(R.id.set_layout_about);
//        if (item_layout != null) {
//            ((TextView) item_layout.findViewById(R.id.set_text)).setText("关于看房去专家");
//            item_layout.findViewById(R.id.set_hitm).setVisibility(View.GONE);
//            item_layout.setOnClickListener(this);
//        }


        item_layout = findViewById(R.id.set_layout_help);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("使用帮助");
            item_layout.findViewById(R.id.set_hitm).setVisibility(View.GONE);
            item_layout.setOnClickListener(this);
        }


        //法律条款
        item_layout = findViewById(R.id.set_layout_law);
        if (item_layout != null) {
            ((TextView) item_layout.findViewById(R.id.set_text)).setText("使用条款和隐私政策");
            item_layout.findViewById(R.id.set_hitm).setVisibility(View.GONE);
            item_layout.setOnClickListener(this);
        }

        //退出登录
        out_login = (Button) findViewById(R.id.out_login);
        out_login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.set_layout_mess://消息设置
                Intent intent = new Intent(activity, SetMessageActivity.class);
                startActivity(intent);
                break;

            case R.id.set_layout_version://版本更新
                Toast.makeText(SetAppActivity.this, "已经是最新版本", Toast.LENGTH_SHORT).show();
                break;

            case R.id.set_layout_cache://清除缓存
                DataCleanManager.clearAllCache(getApplicationContext());
                iv_cache.setText("0M");
                Toast.makeText(SetAppActivity.this, "缓存已清除", Toast.LENGTH_SHORT).show();
                break;

            case R.id.set_layout_law://法律条款
//                Intent i = new Intent(activity, SetLawActivity.class);
                Intent i = new Intent(activity, SetLaw2Activity.class);
                startActivity(i);
                break;

            case R.id.out_login://退出登录
                String phone = AppSharePrefManager.getInstance(this).getLastest_login_phone_num();
                if (AppSharePrefManager.getInstance(this).getEdit().clear().commit()) {
                    AppSharePrefManager.getInstance(this).setLastest_login_phone_num(phone);
                    AppSharePrefManager.getInstance(this).setVersionName(AppUtil.getCurrentAppVersionName(this));
                    Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();

                    new Thread() {
                        @Override
                        public void run() {
                            XmppUtil.getInstance().closeConnection();
                        }
                    }.start();

                    Intent pushService = new Intent(PushService.ACTION);
                    pushService.setPackage(getPackageName());
                    stopService(pushService);

                    switchRun(AppSharePrefManager.getInstance(SetAppActivity.this).getLastest_login_id(), "ready");

                    Intent it = new Intent(activity, LoginActivity.class);
                    it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(it);
                }
                break;
            case R.id.set_layout_contact://联系我们
                startActivity(new Intent(activity, SetContactWeActivity.class));
                break;
        }
    }

    /**
     * 经纪人运行模式切换接口
     *
     * @param userid
     * @param currstate 值有: ready, process
     */
    private void switchRun(int userid, final String currstate) {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("currstate", currstate);
        new HttpAsy(new PostExecute() {
            @Override
            public void onPostExecute(String result) {
                L.LogE("switchRun onPostExecute is " + result);
                if (TextUtils.isEmpty(result)) {
                    Toast.makeText(SetAppActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String, Object> resMap = JacksonMapper.getInstance().mapObjFromJson(result);
                if (((boolean) resMap.get("state"))) {
                    FangApplication.mainButtomState = currstate;
                }
            }
        }).execute(Constants.switchRunUrl, map);
    }
}
