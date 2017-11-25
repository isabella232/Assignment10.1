package com.niketgoel.assignment101;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by niketgoel on 25/11/17.
 */

public class SimpleAddition extends Fragment {
    private EditText inputText;
    private Button submitButton;
    private TextView outputText;

    // Creating an interface to communicate with the MainActivity
    OnSimpleAdditionListener activityCallback;

    public interface OnSimpleAdditionListener{
        public void inputNumber( String num);
    }
    //Attaching the MainActivity to the fragment
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            activityCallback= (OnSimpleAdditionListener) context;

        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.simple_fragment, container ,false);
        inputText = (EditText)view.findViewById(R.id.editText);
        submitButton = (Button)view.findViewById(R.id.button);
        outputText = (TextView)view.findViewById(R.id.textView);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonclick(view);
            }
        });
        return view;
    }

    /**
     *
     * @param view
     */
    // creating public method to handle the event
    public void onButtonclick(View view){
        activityCallback.inputNumber(inputText.getText().toString());
    }

    /**
     *
     * @param num
     */
    // creating public method outputResult()to display the result value
    public void outputResult(String num){
        outputText.setText(num);
    }
}
