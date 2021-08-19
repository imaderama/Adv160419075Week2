package id.ac.ubaya.informatika.adv160419075week2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_result.*

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    var num1 = 0
    var num2 = 0
    var hasil = 0
    var score = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        randomNumber()



        if(arguments!=null){
            var playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
//            var playerScore = GameFragmentArgs.fromBundle(requireArguments()).score
            txtTurn.text = "$playerName's Turn"
//            score += playerScore
        }
//        var answer = txtAnswer.text.toString().toInt()
        btnSubmit.setOnClickListener {
            if(txtAnswer.text.toString() == ""){
                Toast.makeText(context, "Anda belum mengisi jawaban!", Toast.LENGTH_SHORT).show()
            }
            else{
                if(txtAnswer.text.toString().toInt() == hasil){
                    randomNumber()
                    score++
                    Toast.makeText(context, score.toString(), Toast.LENGTH_SHORT).show()
                }
                else{
                    val action = GameFragmentDirections.actionResultFragment(score)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

    fun randomNumber(){
        num1 = (0..10).random()
        num2 = (0..10).random()

        txtNum1.text = num1.toString()
        txtNum2.text = num2.toString()

        hasil = num1 + num2
    }
}