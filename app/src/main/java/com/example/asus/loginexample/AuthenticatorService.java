package com.example.asus.loginexample;

import android.accounts.AbstractAccountAuthenticator;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by ASUS on 2015-05-30.
 */
public class AuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals(
                android.accounts.AccountManager.ACTION_AUTHENTICATOR_INTENT))
            return null;

        AbstractAccountAuthenticator authenticator =
                new FussyLogicAuthenticator(this);
        return authenticator.getIBinder();
    }

    // --------------------------------

}
