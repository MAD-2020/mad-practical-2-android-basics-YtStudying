package sg.edu.np.Week2Practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView Score;
    private String left, middle, right;
    private Integer point = 0;

    private static final String TAG = "Whack-A-Mole";

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
        left = ButtonLeft.getText().toString();
        middle = ButtonMiddle.getText().toString();
        right = ButtonRight.getText().toString();
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if(randomLocation == 0) {
            ButtonLeft.setText("*");
            ButtonMiddle.setText("O");
            ButtonRight.setText("O");
        }
        else if (randomLocation == 1){
            ButtonLeft.setText("O");
            ButtonMiddle.setText("*");
            ButtonRight.setText("O");
        }
        else{
            ButtonLeft.setText("O");
            ButtonMiddle.setText("O");
            ButtonRight.setText("*");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);
        Score = (TextView) findViewById(R.id.Score);

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                
                Log.v(TAG, "Button Left Clicked!");
                if(left == "*"){
                    point += 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    point -= 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Missed, score deducted!");
                }
                onStart();
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                Log.v(TAG, "Button Middle Clicked!");
                if(middle == "*"){
                    point += 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    point -= 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Missed, score deducted!");
                }
                onStart();
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                Log.v(TAG, "Button Right Clicked!");
                if(right == "*"){
                    point += 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    point -= 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Missed, score deducted!");
                }
                onStart();
            }
        });
    }
}
