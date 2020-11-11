package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button clearButton, parenthesisButton, divideButton, sevenButton, eightButton, nineButton,
            multiplyButton, fourButton, fiveButton, sixButton, subtractButton, oneButton, twoButton, threeButton,
            plusButton, plusminusButton, zeroButton, decimalButton, equalButton, backSpaceButton;

    TextView inputTextView, outputTextView;
    String process;

    boolean endWithOperator = false;
    boolean isempty = true;
    boolean ispositive = true;
    boolean tempPlusMinus = false;
    boolean endWithDigits = false;
    boolean isPlusMinusClicked = false;
    boolean endsWithParenthesis = false;
    boolean endsWithDecimal = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        oneButton = findViewById(R.id.oneButton);
        twoButton = findViewById(R.id.twoButton);
        threeButton = findViewById(R.id.threeButton);
        fourButton = findViewById(R.id.fourButton);
        fiveButton = findViewById(R.id.fiveButton);
        sixButton = findViewById(R.id.sixButton);
        sevenButton = findViewById(R.id.sevenButton);
        eightButton = findViewById(R.id.eightButton);
        nineButton = findViewById(R.id.nineButton);
        zeroButton = findViewById(R.id.zeroButton);

        backSpaceButton = findViewById(R.id.backSpaceButton);
        clearButton = findViewById(R.id.clearButton);
        parenthesisButton = findViewById(R.id.parenthesisButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        subtractButton = findViewById(R.id.subtractButton);
        plusButton = findViewById(R.id.plusButton);
        plusminusButton = findViewById(R.id.plusminusButton);
        equalButton = findViewById(R.id.equalButton);
        decimalButton = findViewById(R.id.decimalButton);

        inputTextView = findViewById(R.id.inputTextView);
        outputTextView = findViewById(R.id.outputTextView);

        backSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(process.length() > 0) {
                    process = inputTextView.getText().toString();
                    process = process.substring(0, process.length() - 1);
                    inputTextView.setText(process);
                }
                else{
                    inputTextView.setText("");
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTextView.setText("");
                outputTextView.setText("");
                isempty = false;
                ispositive = true;
                tempPlusMinus = false;
                endWithDigits = false;
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "0");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "1");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "2");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "3");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "4");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "5");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "6");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "7");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "8");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                inputTextView.setText(process + "9");
                isempty = false;
                endWithDigits = true;
                endWithOperator = false;
                endsWithParenthesis = false;
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlusMinusClicked){
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "+");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        process = process.substring(0, process.length()-1);
                        inputTextView.setText(process + "+");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    isPlusMinusClicked = false;
                }
                else{
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "+");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        inputTextView.setText(process + "+");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                }

                if(endsWithParenthesis){
                    process = inputTextView.getText().toString();
                    process = process.substring(0, process.length()-2);
                    inputTextView.setText(process + "+");
                    endWithOperator = true;
                    endWithDigits = false;
                    endsWithParenthesis = false;
                }

                tempPlusMinus = false;
                endsWithDecimal = false;

            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlusMinusClicked){
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "-");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        process = process.substring(0, process.length()-1);
                        inputTextView.setText(process + "-");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    isPlusMinusClicked = false;
                }else{
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "-");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        inputTextView.setText(process + "-");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                }

                if(endsWithParenthesis){
                    process = inputTextView.getText().toString();
                    process = process.substring(0, process.length()-2);
                    inputTextView.setText(process + "-");
                    endWithOperator = true;
                    endWithDigits = false;
                    endsWithParenthesis = false;
                }

                tempPlusMinus = false;
                endsWithDecimal = false;
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlusMinusClicked){
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "x");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        process = process.substring(0, process.length()-1);
                        inputTextView.setText(process + "x");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    isPlusMinusClicked = false;
                }else{
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "x");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        inputTextView.setText(process + "x");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                }

                if(endsWithParenthesis){
                    process = inputTextView.getText().toString();
                    process = process.substring(0, process.length()-2);
                    inputTextView.setText(process + "x");
                    endWithOperator = true;
                    endWithDigits = false;
                    endsWithParenthesis = false;
                }

                tempPlusMinus = false;
                endsWithDecimal = false;
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlusMinusClicked){
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "÷");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        process = process.substring(0, process.length()-1);
                        inputTextView.setText(process + "÷");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    isPlusMinusClicked = false;
                }else{
                    if(!endWithOperator) {
                        process = inputTextView.getText().toString();
                        inputTextView.setText(process + "÷");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    else if(endWithOperator){
                        inputTextView.setText(process + "÷");
                        endWithOperator = true;
                        endWithDigits = false;
                    }
                    endsWithDecimal = false;
                }

                if(endsWithParenthesis){
                    process = inputTextView.getText().toString();
                    process = process.substring(0, process.length()-2);
                    inputTextView.setText(process + "÷");
                    endWithOperator = true;
                    endWithDigits = false;
                    endsWithParenthesis = false;
                }

                tempPlusMinus = false;
            }
        });


        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                if(endWithOperator || process.equals("") || process.equals(null)) {
                    inputTextView.setText(process + "0.");
                    endsWithDecimal = true;
                    endWithOperator = false;
                }
                else if(!endsWithDecimal){
                    inputTextView.setText(process + ".");
                    endsWithDecimal = true;
                    endWithOperator = true;
                }

            }
        });

        // parenthesis
        parenthesisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                if(CheckParentesis(process) && !endWithDigits){
                    inputTextView.setText(process + "(");
                    endsWithParenthesis = true;
                }
                else if(!CheckParentesis(process)){
                    inputTextView.setText(process + ")");
                    endsWithParenthesis = false;
                }
                else if(CheckParentesis(process) && endWithDigits){
                    inputTextView.setText(process + "x(");
                    endWithOperator = true;
                }
            }
        });
        //equal////////////////////////////////////////////////////////
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();

                process = process.replaceAll("x", "*");
                process = process.replaceAll("÷", "/");

                Context c = Context.enter();
                c.setOptimizationLevel(-1);

                String res = "";

                try{
                    Scriptable scriptable = c.initStandardObjects();
                    res = c.evaluateString(scriptable, process, "javascript", 1, null).toString();
                }catch (Exception e){
                    res = "Invalid Input";
                }

                outputTextView.setText(res);

            }
        });
        //plus minus
        plusminusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                process = inputTextView.getText().toString();
                isPlusMinusClicked = true;

                if(process.equals(null) || process.equals("")){
                    inputTextView.setText("(-");
                    ispositive = false;
                    isempty = true;
                }
                else if(isempty){
                    inputTextView.setText("");
                    ispositive = true;
                }

                else if(endWithOperator && !tempPlusMinus){
                    inputTextView.setText(process + "(-");
                    tempPlusMinus = true;
                }
                else if(endWithOperator &&tempPlusMinus){
                    process = process.substring(0, process.length()-2);
                    inputTextView.setText(process);
                    tempPlusMinus = false;
                }

                else if(endWithDigits && !tempPlusMinus){
                    inputTextView.setText("(-" + process);
                    tempPlusMinus = true;
                }
                else if(endWithDigits && tempPlusMinus){
                    process = process.substring(2, process.length());
                    inputTextView.setText(process);
                    tempPlusMinus = false;
                }

            }
        });


    }

    public boolean CheckParentesis(String str)
    {
        if (str.isEmpty())
            return true;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            if (current == '(')
            {
                stack.push(current);
            }

            if (current == ')')
            {
                if (stack.isEmpty())
                    return false;
                char last = stack.peek();
                if (current == ')' && last == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}