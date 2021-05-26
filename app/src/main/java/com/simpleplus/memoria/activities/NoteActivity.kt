package com.simpleplus.memoria.activities

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.simpleplus.memoria.R
import com.simpleplus.memoria.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {

    companion object {

        private const val TAG = "Porsche"
    }

    //Layout components
    private lateinit var binder: ActivityNoteBinding
    var isEditingTitle = false
    var isEditingDesc = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binder.root)
        initToolbar()
        handleFocusStates()
    }

    private fun initToolbar() {

        setSupportActionBar(binder.activityNoteToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        if (isEditingTitle || isEditingDesc) {
            menuInflater.inflate(R.menu.menu_note_toolbar_editing, menu)
            return true
        }

        menuInflater.inflate(R.menu.menu_note_toolbar_viewing, menu)
        return true
    }

    private fun handleFocusStates() {

        val editTitle = binder.activityNoteEditTitle
        val editDesc = binder.activityNoteEditDesc

        editTitle.setOnFocusChangeListener { v, hasFocus ->

            isEditingTitle = hasFocus

            invalidateOptionsMenu()
        }

        editDesc.setOnFocusChangeListener { v, hasFocus ->

            isEditingDesc = hasFocus

            invalidateOptionsMenu()
        }

    }

    override fun onBackPressed() {

        if (isEditingTitle || isEditingDesc) {
            alertForBackButton()
        } else {
            finish()
        }

    }

    private fun alertForBackButton() {

        val builder = AlertDialog.Builder(this).apply {

            setMessage(getString(R.string.alert_note_changes))
            setPositiveButton(getString(R.string.label_save)) { dialogInterface: DialogInterface, i: Int ->
                Log.i(TAG, "alertForBackButton: would be saving")
            }
            setNegativeButton(getString(R.string.label_discard)) { dialogInterface: DialogInterface, i: Int ->
                finish()
            }

            setNeutralButton(getString(R.string.label_cancel)) { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }


        }

        builder.create().show()

    }

}