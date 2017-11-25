package com.niketgoel.assignment101;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements SimpleAddition.OnSimpleAdditionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Implementing the method declared in interface OnSimpleAdditionListener
     * @param num
     */
    @Override
    public void inputNumber(String num) {
        SimpleAddition simpleAddition = (SimpleAddition)getSupportFragmentManager()
                .findFragmentById(R.id.simple_fragment);
        simpleAddition.outputResult(num);
    }
}
