package jp.techacademy.kousei.asayama.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //変数
    TextView mTextView1;
    int hourOfDay = 13;      //TimePickerDialogの時間
    int minute = 0;         //TimePickerDialogの分

    //onCreateメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView1 = (TextView) findViewById(R.id.textView1);
    }
    //onClickメソッド
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1) {     //あいさつボタンクリック時
            //TimePickerDialogインスタンス生成
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        }
                    },
                    hourOfDay,
                    minute,
                    true);

            //時間によって挨拶を変更する
            if ((hourOfDay > -1 && hourOfDay < 25) && (minute > -1 && minute < 60)) {
                if ((2 <= hourOfDay && hourOfDay <= 9) && (minute >= 0 && minute <= 59)) {
                    mTextView1.setText("おはよう");
                    timePickerDialog.show();
                } else if ((10 <= hourOfDay && hourOfDay <= 17) && (minute >= 0 && minute <= 59)) {
                    mTextView1.setText("こんにちは");
                    timePickerDialog.show();
                } else if ((hourOfDay < 2 || hourOfDay >= 18) && (minute >= 0 && minute <= 59)) {
                    mTextView1.setText("こんばんは");
                    timePickerDialog.show();
                }
            }   else {
                mTextView1.setText("値が不正です");
            }
        }
    }
}
