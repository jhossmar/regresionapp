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


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {
    private String mStringBeTyped;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void ValorInicial(){
        mStringBeTyped = "Espresso";
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        onView(withText("MINIMOS CUADRADOS")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_lineal)).perform(click());

        onView(withId(R.id.editText_lineal_x))
                .perform(typeText("18.9"), closeSoftKeyboard());
        onView(withId(R.id.editText_lineal_y))
                .perform(typeText("56.9"), closeSoftKeyboard());

        onView(withId(R.id.add_dato))
                .perform(click());

        onView(withId(R.id.calcular))
                .perform(click());

        onView(withText("RESULTADOS")).check(matches(isDisplayed()));

//        assertEquals("com.example.marcelo.regresionapp", appContext.getPackageName());
   }
}
