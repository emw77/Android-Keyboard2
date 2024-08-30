package com.example.android_keyboard2

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View
import android.view.inputmethod.InputConnection

class CustomKeyboardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {

    private lateinit var keyboardView: KeyboardView
    private var isShifted = false

    override fun onCreate() {
        super.onCreate()
    }

    override fun onCreateInputView(): View {
        keyboardView = layoutInflater.inflate(R.layout.layout, null) as KeyboardView
        keyboardView.setOnKeyboardActionListener(this)
        return keyboardView
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray) {
        val inputConnection: InputConnection? = currentInputConnection
        when (primaryCode) {
            -5 -> { // BACKSPACE key
                inputConnection?.deleteSurroundingText(1, 0)
            }
            -1 -> { // SHIFT key
                isShifted = !isShifted
                keyboardView.invalidateAllKeys()
            }
            else -> {
                val character = if (isShifted) primaryCode.toChar().uppercaseChar() else primaryCode.toChar()
                inputConnection?.commitText(character.toString(), 1)
            }
        }
    }

    override fun onPress(primaryCode: Int) {
        // Optional: Handle key press visual effects
    }

    override fun onRelease(primaryCode: Int) {
        // Optional: Handle key release visual effects
    }

    override fun onText(text: CharSequence?) {
        // Handle text input
    }

    override fun swipeDown() {
        // Optional: Handle swipe down
    }

    override fun swipeLeft() {
        // Optional: Handle swipe left
    }

    override fun swipeRight() {
        // Optional: Handle swipe right
    }

    override fun swipeUp() {
        // Optional: Handle swipe up
    }
}
