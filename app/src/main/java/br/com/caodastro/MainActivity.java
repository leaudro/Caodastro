package br.com.caodastro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextDog;

    private int[] dogs = { R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.dog3,
            R.drawable.dog4,
            R.drawable.dog5,
            R.drawable.dog6
    };

    private String[] dogText = {
            "Meu cachorro é um pastor alemão divertido",
            "Meu cachorro é um vira-lata feliz",
            "Esse puddle faz várias trapalhadas"
    };

    private int indexDog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonNo = (Button) findViewById(R.id.button_no);
        Button mButtonYes = (Button) findViewById(R.id.button_yes);
        mImageView = (ImageView) findViewById(R.id.image);
        mTextDog = (TextView) findViewById(R.id.text_dog);

        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button_yes) {
                    Toast.makeText(MainActivity.this, "Vocês combinam!", Toast.LENGTH_SHORT).show();
                }

                mImageView.setImageResource(dogs[++indexDog % dogs.length]);
                mTextDog.setText(dogText[indexDog % dogText.length]);
            }
        };

        mButtonNo.setOnClickListener(onClickListener);
        mButtonYes.setOnClickListener(onClickListener);
    }
}

