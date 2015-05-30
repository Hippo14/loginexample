package com.example.asus.loginexample;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ASUS on 2015-05-30.
 */
public class FussyLogicAuthenticator extends AbstractAccountAuthenticator {
    protected Context mContext;

    public FussyLogicAuthenticator(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        return null;
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
        // We absolutely cannot add an account without some information
        // from the user; so we're definitely going to return an Intent
        // via KEY_INTENT
        final Bundle bundle = new Bundle();

        // We're going to use a LoginActivity to talk to the user (mContext
        // we'll have noted on construction).
        final Intent intent = new Intent(mContext, LoginActivity.class);

        // We can configure that activity however we wish via the
        // Intent.  We'll set ARG_IS_ADDING_NEW_ACCOUNT so the Activity
        // knows to ask for the account name as well
        intent.putExtra(LoginActivity.ARG_ACCOUNT_TYPE, accountType);
        intent.putExtra(LoginActivity.ARG_AUTH_TYPE, authTokenType);
        intent.putExtra(LoginActivity.ARG_IS_ADDING_NEW_ACCOUNT, true);

        // It will also need to know how to send its response to the
        // account manager; LoginActivity must derive from
        // AccountAuthenticatorActivity, which will want this key set
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE,
                response);

        // Wrap up this intent, and return it, which will cause the
        // intent to be run
        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        return bundle;
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public String getAuthTokenLabel(String authTokenType) {
        return null;
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features) throws NetworkErrorException {
        return null;
    }

    // ... implement abstract methods ...
}
