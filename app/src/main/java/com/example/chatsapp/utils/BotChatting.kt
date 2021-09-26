package com.example.chatsapp.utils

import com.example.chatsapp.utils.Const.OPEN_GOOGLE
import com.example.chatsapp.utils.Const.OPEN_SEARCH
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotChatting {


    fun basicChatting(_chat: String): String {

        val random = (0..2).random()
        val randomJoke = (0..10).random()
        val chat = _chat.lowercase()

        return when {

            //Coin Flip
            chat.contains("flip") && chat.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "Heads" else "Tails"

                "I got $result"
            }

            //Math calculations
            chat.contains("solve") -> {
                val equation: String? = chat.substringAfterLast("solve")
                return try {
                    val answer = Calculations.calculate(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that"
                }
            }

            //Hello
            chat.contains("hello") -> {
                when (random) {
                    0 -> "Hey there!"
                    1 -> "Hi. It's good to hear from you.\n"+"I hope you and your loved ones are staying safe and healthy during this difficult time"
                    2 -> "Namastee !"
                    else -> "There's seems to be some kind of an error"
                }
            }
            //What's your name
            chat.contains("what is your name") -> {
                when (random) {
                    0 -> "My name is _ChatsApp_.\n"+ "I like to think of it as a cool name."
                    1 -> "I go by _ChatsApp_.\n"+"It's a nickname..sort of"
                    2 -> "I go by _ChatsApp_.\n"+"It's a nickname..sort of"
                    else -> "There's seems to be some kind of an error"
                }
            }

            //How are you
            chat.contains("how are you") -> {
                when (random) {
                    0 -> "I'm fine, thank you for asking.\n" + "This is a challenging time for us. I hope you and your loved ones are safe and healthy"
                    1 -> "I'm fine, thank you"
                    2 -> "Good! Hope you're doing well too?"
                    else -> "There's seems to be some kind of an error"
                }
            }
            //yes
            chat.contains("yes") -> {
                when (random) {
                    0 -> "Good to hear!"
                    1 -> "That's good to hear!"
                    2 -> "Good!"
                    else -> "There's seems to be some kind of an error"
                }
            }
            //How do you do
            chat.contains("how do you do") -> {
                when (random) {
                    0 -> "I'm fine, thank you for asking.\n" + "This is a challenging time for us. I hope you and your loved ones are safe and healthy"
                    1 -> "I'm fine, thank you"
                    2 -> "Good! Hope you're doing well too.?"
                    else -> "There's seems to be some kind of an error"
                }
            }
            //ThankYou
            chat.contains("thankyou")-> {
                when (random) {
                    0 -> "You're most welcome"
                    1 -> "Cool!"
                    2 -> "My pleasure"
                    else -> "There's seems to be some kind of an error"
                }
            }
            //nice
            chat.contains("nice")-> {
                when (random) {
                    0 -> "I'm glad you liked it"
                    1 -> "Haha!"
                    2 -> "My pleasure"
                    else -> "There's seems to be some kind of an error"
                }
            }

            //What time is it?
            chat.contains("time") -> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Joke
            chat.contains("tell a joke")-> {
                when (randomJoke) {
                    0 -> "Why did the tomato blush?\n" +
                            "Because it saw the salad dressing."
                    1 -> "Did you hear about the first restaurant to open on the moon?\n" +
                            "It had great food, but no atmosphere."
                    2 -> "What’s orange and sounds like a parrot?\n" +
                            "A carrot."
                    3 -> "What’s orange and sounds like a parrot?\n" +
                            "A carrot."
                    4 -> "Why does Humpty Dumpty love autumn?\n" +
                            "Because he always has a great fall."
                    5 -> "Did you hear about the waffle iron with anger issues?\n" +
                            "He just flipped."
                    6 -> "Why do comedians love eggs?\n" +
                            "They’re easy to crack up."
                    7 -> "What do dentists call X-rays?\n" +
                            "Tooth pics."
                    8 -> "Is this pool safe for diving?\n" +
                            "It deep ends"
                    9 -> "Where does bad light end up?\n" +
                            "In prism."
                    10 -> "Why are electrons never invited to parties?\n" +
                            "They’re so negative."

                    else -> "There's seems to be some kind of an error"
                }
            }

            //Open Google
            chat.contains("open") && chat.contains("google") -> {
                OPEN_GOOGLE
            }

            //Search Internet
            chat.contains("search") -> {
                OPEN_SEARCH
            }

            //ChatsApp can't understand
            else -> {
                when (random) {
                    0 -> "Sorry, I didn't understand"
                    1 -> "Oops! Couldn't get that"
                    2 -> "Hope everything is ok, please let me know if I can help"
                    else -> "There's seems to be some kind of an error"
                }
            }
        }
    }
}