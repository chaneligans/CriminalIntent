package com.bignerdranch.android.criminalintent

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.text.DateFormat

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
//        binding.crimeDate.text = crime.date.toString()
        binding.crimeDate.text = DateFormat.getDateInstance(DateFormat.LONG).format(crime.date).toString()

        binding.root.setOnClickListener {
            Snackbar.make(
                it,
                "${crime.title} clicked~",
                BaseTransientBottomBar.LENGTH_SHORT
            ).show()
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}