package ar.edu.unlam.roomshowcase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.roomshowcase.databinding.ListItemBinding
import ar.edu.unlam.roomshowcase.robot.Robot


class RobotAdapter(private val clickListener: (Robot) -> Unit) :
    RecyclerView.Adapter<RobotViewHolder>() {

    fun updateRobots(robots: List<Robot>?) {
        robotList.clear()
        if (robots != null) {
            robotList.addAll(robots)
        }
    }

    private val robotList = mutableListOf<Robot>()

    override fun getItemCount() = robotList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RobotViewHolder {
        return RobotViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RobotViewHolder, position: Int) {
        val robot = robotList[position]
        holder.binding.name.text = robot.name

        holder.itemView.setOnClickListener { clickListener(robot) }
    }

}

class RobotViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)