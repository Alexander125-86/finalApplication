package study.alex.finalapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


private const val LAST_SPINNED_IMAGE = "image"

class SpinFragment : Fragment() {

    lateinit var spinImageView: ImageView
    lateinit var spinButton: Button

    private val spinImageList: List<Int> = listOf(
        R.drawable.orel,
        R.drawable.reshka,

        )

    var lastSpinnedImageRes = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_spin, container, false)

        spinImageView = view.findViewById(R.id.spin_image_view)
        spinButton = view.findViewById(R.id.spin_button)


        if (savedInstanceState != null)
            spinImageView.setImageResource(savedInstanceState.getInt(LAST_SPINNED_IMAGE))


        spinButton.setOnClickListener {
            lastSpinnedImageRes = spinImageList.random()
            spinImageView.setImageResource(lastSpinnedImageRes)
        }




        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SPINNED_IMAGE, lastSpinnedImageRes)
    }


}