package newer.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textViewcacu;
    private TextView textViewresult;
    private List<item> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewcacu = (TextView) findViewById(R.id.textViewcacu);
        textViewresult = (TextView) findViewById(R.id.textViewresult);

        findViewById(R.id.button0).setOnClickListener(new listener());
        findViewById(R.id.button1).setOnClickListener(new listener());
        findViewById(R.id.button2).setOnClickListener(new listener());
        findViewById(R.id.button3).setOnClickListener(new listener());
        findViewById(R.id.button4).setOnClickListener(new listener());
        findViewById(R.id.button5).setOnClickListener(new listener());
        findViewById(R.id.button6).setOnClickListener(new listener());
        findViewById(R.id.button7).setOnClickListener(new listener());
        findViewById(R.id.button8).setOnClickListener(new listener());
        findViewById(R.id.button9).setOnClickListener(new listener());
        findViewById(R.id.buttondiv).setOnClickListener(new listener());
        findViewById(R.id.buttonadd).setOnClickListener(new listener());
        findViewById(R.id.buttonclear).setOnClickListener(new listener());
        findViewById(R.id.buttonsub).setOnClickListener(new listener());
        findViewById(R.id.buttonX).setOnClickListener(new listener());
        findViewById(R.id.buttonresult).setOnClickListener(new listener());
        textViewresult.append("");

    }

    class listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button0:
                    textViewcacu.append("0");
                    textViewresult.append("0");
                    break;
                case R.id.button1:
                    textViewcacu.append("1");
                    textViewresult.append("1");
                    break;
                case R.id.button2:
                    textViewcacu.append("2");
                    textViewresult.append("2");
                    break;
                case R.id.button3:
                    textViewcacu.append("3");
                    textViewresult.append("3");
                    break;
                case R.id.button4:
                    textViewcacu.append("4");
                    textViewresult.append("4");
                    break;
                case R.id.button5:
                    textViewcacu.append("5");
                    textViewresult.append("5");
                    break;
                case R.id.button6:
                    textViewcacu.append("6");
                    textViewresult.append("6");
                    break;
                case R.id.button7:
                    textViewcacu.append("7");
                    textViewresult.append("7");
                    break;
                case R.id.button8:
                    textViewcacu.append("8");
                    textViewresult.append("8");
                    break;
                case R.id.button9:
                    textViewcacu.append("9");
                    textViewresult.append("9");
                    break;
                case R.id.buttonadd:
                    textViewresult.append("+");
                data.add(new item(Double.parseDouble(textViewcacu.getText().toString()),type.num));
                    check();
                    data.add(new item(0,type.add));
                    textViewcacu.setText("");
                    break;
                case R.id.buttondiv:
                    textViewresult.append("/");
                    data.add(new item(Double.parseDouble(textViewcacu.getText().toString()),type.num));
                    check();
                    data.add(new item(0,type.div));
                    textViewcacu.setText("");
                    break;
                case R.id.buttonX:
                    textViewresult.append("X");
                    data.add(new item(Double.parseDouble(textViewcacu.getText().toString()),type.num));
                    check();
                    data.add(new item(0,type.X));
                    textViewcacu.setText("");
                    break;
                case R.id.buttonsub:
                    textViewresult.append("-");
                    data.add(new item(Double.parseDouble(textViewcacu.getText().toString()),type.num));
                    check();
                    data.add(new item(0,type.sub));
                    textViewcacu.setText("");
                    break;
                case R.id.buttonclear:
                    textViewresult.setText("");
                    textViewcacu.setText("");
                    data.clear();
                    break;
                case R.id.buttonresult:

                    data.add(new item(Double.parseDouble(textViewcacu.getText().toString()),type.num));
                    check();
                    textViewcacu.setText(data.get(0).value+"");
                    data.clear();


            }


        }
        public void check(){
            if(data.size()>=3){
                double a =data.get(0).value;
                double b= data.get(2).value;
                int opt = data.get(1).type;
                data.clear();
                switch (opt)
                {
                    case type.add:
                        data.add(new item(a+b,type.num));
                        break;
                    case type.div:
                        data.add(new item(a/b,type.num));
                        break;

                    case type.sub:
                        data.add(new item(a-b,type.num));
                        break;

                    case type.X:
                        data.add(new item(a*b,type.num));
                        break;
                }
            }
        }
    }
}
