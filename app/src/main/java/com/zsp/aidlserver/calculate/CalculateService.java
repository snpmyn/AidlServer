package com.zsp.aidlserver.calculate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created on 2021/5/20
 *
 * @author zsp
 * @desc 计算服务
 */
public class CalculateService extends Service {
    private final String TAG = this.getClass().getSimpleName();
    /**
     * 实现 AIDL 接口方法的 IBinder 实例
     */
    private final CalculateAIDL.Stub stub = new CalculateAIDL.Stub() {
        @Override
        public int add(int x, int y) {
            return x + y;
        }

        @Override
        public int max(int x, int y) {
            return Math.max(x, y);
        }

        @Override
        public int min(int x, int y) {
            return Math.min(x, y);
        }
    };

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return stub;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
