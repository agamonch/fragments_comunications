package kg.unicapp.frtofr

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kg.unicapp.frtofr.databinding.FragmentBBinding


class FragmentB: Fragment(R.layout.fragment_b) {

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    private var fragmentBlankBinding: FragmentBBinding? = null
    private lateinit var  listener: FragmentBListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBBinding.bind(view)
        fragmentBlankBinding = binding
        binding.button6.setOnClickListener {
            val text = binding.editTextTextPersonName5.text.toString()
            listener.setTextToFragmentA(text)
        }

    }

    fun setNewText (text: String) {
        fragmentBlankBinding!!.textView6.text = text
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentBListener) listener = context
    }

    companion object {
        const val TAG = "FragmentB"

    }
}