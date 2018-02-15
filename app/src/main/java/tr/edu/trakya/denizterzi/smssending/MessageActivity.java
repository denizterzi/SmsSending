package tr.edu.trakya.denizterzi.smssending;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity {
    @BindView(R.id.messageText)
    EditText mMessageEditText;
    @BindView(R.id.phoneNumber)
    EditText mPhoneNo;
    @BindView(R.id.send_button)
    Button mSendButton;
    @OnClick(R.id.send_button)
    public void sendButtonClicked() {
        sendMessage(mMessageEditText.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
//        mSendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SmsManager smsManager=SmsManager.getDefault();
//                smsManager.sendTextMessage(mPhoneNo.getText().toString(),null,mMessageEditText.getText().toString(),null,null);
//                return;
//            }
//        });

    }

    public void sendMessage(String mMessage) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(mPhoneNo.getText().toString(), null, mMessage,null, null);
    }
}