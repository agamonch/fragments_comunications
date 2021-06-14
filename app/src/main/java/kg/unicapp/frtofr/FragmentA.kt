package kg.unicapp.frtofr

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kg.unicapp.frtofr.databinding.FragmentABinding
import kg.unicapp.frtofr.databinding.FragmentABinding.bind


class FragmentA: Fragment(R.layout.fragment_a) {

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var fragmentBlankBinding: FragmentABinding? = null

    private lateinit var  listener: FragmentAListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = bind(view)
        fragmentBlankBinding = binding
        binding.button5.setOnClickListener{
            val text = binding.editTextTextPersonName4.text.toString()
            listener.setTextToFragmentB(text)

        }

    }
    fun setNewText (text: String) {
        fragmentBlankBinding!!.textView3.text = text
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener) listener = context
    }



    companion object{
        const val TAG = "FragmentA"

    }
}


