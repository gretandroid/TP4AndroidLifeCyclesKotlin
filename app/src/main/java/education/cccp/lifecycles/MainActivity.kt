package education.cccp.lifecycles

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var amountTextView: TextView

    //    La méthode onCreate est une méthode du cycle de vie d'android
    //    Elle se déclenche le moment ou l'activité est lancée
    //    Les initialisations s'effectuent dans cette méthode
    //    l'interface d'activité(layout) est gonflée ("inflated")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amountTextView = findViewById(R.id.textView2)
        if (savedInstanceState != null && !savedInstanceState.isEmpty) {
            amountTextView.text = savedInstanceState
                .getString("montant", "")
        }
        Log.d(
            MainActivity::class.java.name,
            "onCreate()"
        )
    }

    // La methode est appelé lorsque l'activité devient visible.
    override fun onStart() {
        super.onStart()
        Log.d(
            MainActivity::class.java.name,
            "onStart()"
        )
    }

    // La méthode obtient le focus(on peut agir avec l'activité)
    override fun onResume() {
        super.onResume()
        Log.d(
            MainActivity::class.java.name,
            "onResume()"
        )
    }

    // L'activité a perdu le focus(elle n'est pas/plus au premier plan)
    override fun onPause() {
        super.onPause()
        Log.d(
            MainActivity::class.java.name,
            "onPause()"
        )
    }

    // L'activité n'est plus visible pour l'utilisateur,
    // c'est dans cette méthode qu'on libere les resources
    // qui ne sont plus nécessaires.
    // c'est le moment ou enregistrer tous les etats a persister
    // au de la du cycle de vie de l'activité.
    override fun onStop() {
        super.onStop()
        Log.d(
            MainActivity::class.java.name,
            "onStop()"
        )
    }

    // L'activité est sur le point d'etre detruite(parce que terminée),
    // On procede a un nettoyage des resources
    override fun onDestroy() {
        super.onDestroy()
        Log.d(
            MainActivity::class.java.name,
            "onDestroy()"
        )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(
            MainActivity::class.java.name,
            "onRestart()"
        )
    }

    // permet de sauvegarder des données utilisateur
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(
            MainActivity::class.java.name,
            "onSaveInstanceState()"
        )
        outState.run {
            putString("montant", amountTextView.text.toString())
        }
    }

    fun calculate(view: View) {
        amountTextView.text = "le montant"
    }
}