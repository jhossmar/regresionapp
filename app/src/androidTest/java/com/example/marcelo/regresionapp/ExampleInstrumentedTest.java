package com.example.marcelo.regresionapp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AllOf.allOf;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {
    private  double[] x={12,8,10,11,7,7,10,14};
    private  double[] y={58,42,51,54,40,39,49,56};
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Before
    public void ValorInicial(){
    }
    @Test
    public void test_Edad_Peso() {
        onView(withId(R.id.btn_lineal)).perform(click());

        for (int i=0; i<x.length; i++){
            onView(withId(R.id.editText_lineal_x))
                    .perform(typeText(""+x[i]), closeSoftKeyboard());
            onView(withId(R.id.editText_lineal_y))
                    .perform(typeText(""+y[i]), closeSoftKeyboard());
            onView(withId(R.id.add_dato))
                    .perform(click());
        }
        onView(withId(R.id.calcular))
                .perform(click());

        System.out.println(onView(withId(R.id.valor_A)));
        onView(withId(R.id.valor_A)).check(matches(withText(containsString("20.6122"))));
   }
}
