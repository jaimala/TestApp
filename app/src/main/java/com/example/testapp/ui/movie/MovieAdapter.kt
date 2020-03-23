import android.R
import android.content.Context
import android.media.MediaPlayer
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testapp.model.Movie
import java.util.*

/**
 * Created by anupamchugh on 09/02/16.
 */
class MovieAdapter(
    data: ArrayList<Movie>,
    context: Context
) :
    RecyclerView.Adapter<Any?>() {
    private val dataSet: ArrayList<Movie>
    var mContext: Context
    var total_types: Int



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Any {
        val view: View
        when (viewType) {
            Movie.movieName -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.text_type, parent, false)
                return TextTypeViewHolder(view)
            }
        }
        return null
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataSet[position].type) {
            0 -> Model.TEXT_TYPE

        }
    }
    override fun onBindViewHolder(holder: Any, listPosition: Int, payloads: MutableList<Any>) {
        val `object`: Movie = dataSet[listPosition]
        if (`object` != null) {
            when (`object`.type) {
                Movie.TEXT_TYPE -> (holder as TextTypeViewHolder?)!!.txtType.setText(
                    `object`.text
                )


            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    init {
        dataSet = data
        mContext = context
        total_types = dataSet.size
    }

    override fun onBindViewHolder(holder: Any, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}