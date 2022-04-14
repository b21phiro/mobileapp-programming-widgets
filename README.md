
# Rapport

## En klicker

Detta är en simpel "klickare" där antalet gånger man klickat på knappen visas på skärmen. Man kan även 
nollställa värdet med hjälp av en reset-knapp. Antal "poäng" visas på skärmen. 

---

### activity_main.xml

Alla element är ankrad på roten, som är en LinearLayout med orientationen vertikalt. 

    <!-- Roten -->
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">
    <!-- (...) -->

"Countern" som jag kallar det, använder sig av ID't 'counterDisplay'. Första värdet som visas "0"
är hårdkodad till en början. 

    <!-- Counter Display -->
    <TextView
        android:id="@+id/counterDisplay"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:textAlignment="center"
        android:text="0"
        android:textSize="64sp"
        android:layout_marginTop="180dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

Knapparna 'counterButton' och 'resetCounterButton' är både utav elementet Button.

    <Button
        android:id="@+id/counterButton"
        android:layout_gravity="center"
        android:layout_marginTop="150dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="32sp"
        android:padding="16dp"
        android:background="@color/colorPrimary"
        android:textColor="#fff"
        android:text="CLICK ME"/>

    <Button
        android:id="@+id/resetCounterButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Reset"
        android:textSize="16sp"
        android:layout_gravity="center"
        android:layout_marginTop="64dp"
        />

### MainActivity.java

Först sätts poängets värde, genom att initiera en integer variabel med 0.

    // Nuvarande poäng-värde.
    private int score = 0;


Sedan inom onCreate() metoden instanseras knapparna och 'countern', och knapparna får sina 
eventlisteners som aktiverar respektive metod ( add() / reset() ) medans båda aktiverar metoden
displayScore(), som då uppdaterar countern till nytt värde.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button counterButton = findViewById(R.id.counterButton);
        Button resetButton = findViewById(R.id.resetCounterButton);
        final TextView counterDisplay = findViewById(R.id.counterDisplay);
    
        // Lägger till poäng när man klickar på CLICK ME knappen
        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
                displayScore(counterDisplay);
            }
        });

        // Återställer poäng med 0 när man klickar på RESET
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                displayScore(counterDisplay);
            }
        });

    }

Metoderna som används är extremt simpla, där add() endast adderar på variabeln "score" med 1, 
respektive reset() som tilldelar värdet 0 till "score". displayScore(Textview display) tar en TextView som parameter,
som då uppdaterar den med "score" som först konverteras till en string. 

Båda knapparna slänger in 'counterDisplay' som argument till displayScore(Textview display);
    
    // Tar en TextView element och sätter in värdet hos "score" som en String.
    private void displayScore(TextView display) {
        display.setText(String.valueOf(score));
    }