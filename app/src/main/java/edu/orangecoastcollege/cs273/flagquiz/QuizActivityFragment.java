package edu.orangecoastcollege.cs273.flagquiz;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuizActivityFragment extends Fragment {
    // String used when logging error messages
    private static final String TAG = "FlagQuiz Activity";

    private static final int FLAGS_IN_QUIZ = 10;

    private List<String> fileNameList; //flag file names
    private List<String> quizCountriesList; // countries in current quiz
    private Set<String> regionsSet; //world regions in current quiz
    private String correctAnswer; // correct country for the current flag
    private int totalGuesses;
    private int correctAnswers; // correct guesses
    private int guessRows; // number of rows displaying guess Buttons
    private SecureRandom random; //used to randomize quiz
    private Handler handler; // used to delay loading the next flag


    private TextView questionNumberTextView; // current question number
    private ImageView flagImageView; //displays a flag
    private LinearLayout[] guessLinearLayouts; //rows of answer buttons
    private TextView answerTextView; //shows correct answer



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_quiz, container, false);

        fileNameList = new ArrayList<>();
        quizCountriesList = new ArrayList<>();
        random = new SecureRandom();
        handler = new Handler();

        // get references to GUI
        questionNumberTextView = (TextView) view.findViewById(R.id.questionNumberTextView);
        flagImageView = (ImageView) view.findViewById(R.id.flagImageView);
        guessLinearLayouts = new LinearLayout[4];
        guessLinearLayouts[0] =
                (LinearLayout) view.findViewById(R.id.row1LinearLayout);
        guessLinearLayouts[1] =
                (LinearLayout) view.findViewById(R.id.row2LinearLayout);
        guessLinearLayouts[2] =
                (LinearLayout) view.findViewById(R.id.row3LinearLayout);
        guessLinearLayouts[3] =
                (LinearLayout) view.findViewById(R.id.row4LinearLayout);
        answerTextView = (TextView) view.findViewById(R.id.answerTextView);

        // configure listeners for the guess buttons
        for (LinearLayout row : guessLinearLayouts)
        {
            for (int column = 0; column < row.getChildCount(); column++)
            {
                Button button = (Button) row.getChildAt(column);
                button.setOnClickListener(guessButtonListener);
            }
        }

        //set questionNumberTextView's text
        questionNumberTextView.setText(
                getString(R.string.question, 1, FLAGS_IN_QUIZ));

        return view;
    }

    public QuizActivityFragment() {
    }
}
