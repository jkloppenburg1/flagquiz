package edu.orangecoastcollege.cs273.flagquiz;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.SecureRandom;
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

    public QuizActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }
}
