package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private String input = "";
    private String operator = "";
    private double num1 = 0;
    private double num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button ac = findViewById(R.id.reset);
        Button brackets = findViewById(R.id.brackets);
        Button porciento = findViewById(R.id.porciento);
        Button divide = findViewById(R.id.divide);
        Button times = findViewById(R.id.times);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button comma = findViewById(R.id.comma);
        Button equal = findViewById(R.id.equal);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberClick(view);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClearClick(view);
            }
        });

        brackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBracketsClick(view);
            }
        });


        porciento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!input.isEmpty()) {
                        double currentValue = Double.parseDouble(input);
                        double percentageValue = currentValue / 100;
                        input = String.valueOf(percentageValue);
                        display.setText(input);
                    }
                }
                });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick(view, "/");
            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick(view, "x");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick(view, "-");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOperatorClick(view, "+");
            }
        });

        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.contains(".")) {
                    input += ".";
                    display.setText(input);
                }
            }
        });
    }
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String clickedNumber = button.getText().toString();
        input += clickedNumber;
        display.setText(input);
    }

    public void onClearClick(View view) {
        input = "";
        operator = "";
        num1 = 0;
        num2 = 0;
        display.setText("");
    }
    public void onBracketsClick(View view) {

        if (input.isEmpty() || isLastCharacterOperator(input) || input.endsWith("(")) {
            input += "(";
        } else if (input.contains("(") && !input.contains(")")) {
            input += ")";
        } else {
            input += "(";
        }

        display.setText(input);
    }
    private boolean isLastCharacterOperator(String input) {
        String operators = "+-*/";
        if (input.isEmpty()) {
            return false;
        }
        char lastChar = input.charAt(input.length() - 1);
        return operators.contains(String.valueOf(lastChar));
    }
    public void onOperatorClick(View view, String selectedOperator) {
        if (!input.isEmpty()) {
            if (!operator.isEmpty()) {
                calculate();
            }
            num1 = Double.parseDouble(input);
            operator = selectedOperator;
            input = "";
        }
    }
    public void onEqualClick(View view) {
        if (!input.isEmpty() && !operator.isEmpty() && !input.endsWith("(")) {
            num2 = Double.parseDouble(input);
            double result = calculate();
            input = String.valueOf(result);
            display.setText(input);
            operator = "";
            num1 = result;
            num2 = 0;
        }
    }

    public double calculate() {
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                }
                break;
        }
        return result;
    }

}