package jp.wings.nikkeibp.samplecalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = this.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // カレンダーアプリを呼び出すIntentの生成
                Intent intent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                //スケジュールのタイトル
                intent.putExtra(CalendarContract.Events.TITLE, "タイトル");
                //スケジュールの開始時刻 ゼロで現在時刻
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 0);
                //スケジュールの終了時刻　ゼロで現在時刻＋１時間
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 0);
                //スケジュールの場所
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "");
                //スケジュールの詳細内容
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "サンプル");
                //スケジュールに招待するメールアドレス
                intent.putExtra(Intent.EXTRA_EMAIL, "メールアドレス");
                //スケジュールのアクセスレベル
                intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_DEFAULT);
                //スケジュールの同時持ちの可否
                intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_FREE);
                //Intentを呼び出す
                startActivity(intent);
            }
        });
    }
}

