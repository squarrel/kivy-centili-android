package org.myapp;


import org.renpy.android.PythonActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import c.mpayments.android.*;


public class Centili {


    public class PurchListener implements PurchaseListener { 
        @Override
        public void onPurchaseSuccess(PurchaseResponse paramPurchaseResponse) {
            // handle purchase success
            //Toast.makeText(getApplicationContext(), "Purchase success!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPurchasePending(PurchaseResponse paramPurchaseResponse) {
            // notification that purchase verification has begun
            //Toast.makeText(getApplicationContext(), "Purchase pending", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPurchaseFailed(PurchaseResponse paramPurchaseResponse) {
            // purchase canceled by user
            //Toast.makeText(getApplicationContext(), "Purchase failed!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPurchaseCanceled(PurchaseResponse paramPurchaseResponse) {
            // purchase cancelled by user
            //Toast.makeText(getApplicationContext(), "Purchase canceled", Toast.LENGTH_SHORT).show();
        }
    }

    public PurchListener purchListener = new PurchListener();
    
    
    Context context = (Context) PythonActivity.mActivity;
    
    public void purchaseCommit() {
        
        PurchaseManager.attachPurchaseListener(purchListener);
    
        PurchaseRequest pr = new PurchaseRequest("your-api-key");
        //pr.setClientId(<YOUR-CLIENT-ID>); // optional
        //pr.setInfo("Info text..."); // optional
        pr.setLanguageCode("EN"); //optional
        pr.setOfflineModeEnabled(true); // optional
        PurchaseManager.startPurchase(pr, context);
    }
    
    public void onCheckServiceAvailabilityButtonClick(View v) {
        PurchaseManager.checkServiceAvailabilityAsync("your-api-key", context,
                new ServiceAvailabilityListener() {
                    @Override
                    public void onServiceStatusObtained(final int status) {
                        // response returned on a non UI thread
                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (status == PurchaseManager.SERVICE_AVAILABLE) {
                                    //Toast.makeText(getApplicationContext(), "Service is available", Toast.LENGTH_LONG).show();
                                } else {
                                    //Toast.makeText(getApplicationContext(), "Service not available", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
    }
    
}
