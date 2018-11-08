package elmajdma.sequencewalletmanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.seq.api.Key;
import com.seq.exception.ChainException;
import com.seq.exception.ConfigurationException;
import com.seq.http.Client;

public class MainActivity extends AppCompatActivity {
 private Client ledger;
  private Button createKeyId;
  private EditText etkeyId;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initiateViews();
    //CUL2VJGCLHQD4USIQ2VI7DIG63XQWXOC
    try {
      ledger=new Client.Builder()
          .setLedgerName("elmajdmaledger")
          .setCredential(System.getenv("O3LYTVTV6TN4WYKOPYPAIHS7CQMIL2I2"))
          .build();
    } catch (ConfigurationException e) {
      e.printStackTrace();
    }
    createKeyId.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
    Key keyTest=new Key.Builder().setId("majd").create(ledger);
    Log.i("key_test",keyTest.id);
          etkeyId.setText("");
        } catch (ChainException e) {
          e.printStackTrace();
        }
      }
    });
  }

  private void initiateViews(){
    createKeyId=findViewById(R.id.btn_create_key);
    etkeyId=findViewById(R.id.ed_key_id);


  }

}
