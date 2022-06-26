package com.cruelgeroi.apphub.db

import android.content.ContentProvider
import android.content.UriMatcher
import android.text.TextUtils
import android.content.ContentValues
import android.content.ContentUris
import android.database.Cursor
import android.net.Uri
import android.provider.BaseColumns

class NotesProvider : ContentProvider() {
    companion object {
        private val URI_MATCHER = UriMatcher(UriMatcher.NO_MATCH)
        private const val NOTES = 1
        private const val NOTE = 2

        init {
            URI_MATCHER.addURI(NotesContract.AUTHORITY, "notes", NOTES)
            URI_MATCHER.addURI(NotesContract.AUTHORITY, "notes/#", NOTE)
        }
    }

    private var notesDbHelper: NotesDbHelper? = null
    override fun onCreate(): Boolean {
        notesDbHelper = NotesDbHelper(context)
        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        var selection = selection
        var selectionArgs: Array<String>? = selectionArgs
        var sortOrder = sortOrder
        val db = notesDbHelper!!.readableDatabase

        return when (URI_MATCHER.match(uri)) {
            NOTES -> {

                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = NotesContract.Notes.COLUMN_UPDATED_TS + " DESC"
                }

                db.query(
                    NotesContract.Notes.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
                )
            }
            NOTE -> {
                var id: String = uri.lastPathSegment.toString()
                if (TextUtils.isEmpty(selection)) {
                    selection = BaseColumns._ID + " = ?"
                    selectionArgs = arrayOf(id)
                } else {
                    selection = selection + " AND " + BaseColumns._ID + " = ?"
                    val newSelectionArgs = arrayOf(
                        (selectionArgs!!.size + 1).toString()
                    )
                    System.arraycopy(
                        selectionArgs,
                        0,
                        newSelectionArgs,
                        0,
                        selectionArgs.size
                    )
                    newSelectionArgs[newSelectionArgs.size - 1] = id
                    selectionArgs = newSelectionArgs
                }
                null
            }
            else -> null
        }
    }

    override fun getType(uri: Uri): String? {
        return when (URI_MATCHER.match(uri)) {
            NOTES -> NotesContract.Notes.URI_TYPE_NOTE_DIR
            NOTE -> NotesContract.Notes.URI_TYPE_NOTE_ITEM
            else -> null
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = notesDbHelper!!.writableDatabase
        return when (URI_MATCHER.match(uri)) {
            NOTES -> {
                val rowId = db.insert(
                    NotesContract.Notes.TABLE_NAME,
                    null,
                    values
                )
                if (rowId > 0) {
                    val noteUri = ContentUris.withAppendedId(NotesContract.Notes.URI, rowId)
                    context!!.contentResolver.notifyChange(uri, null)
                    return noteUri
                }
                null
            }
            else -> null
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }
}