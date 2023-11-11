package com.example.appstrology.ui.providers

import com.example.appstrology.R
import com.example.appstrology.ui.model.LuckyModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardProvider @Inject constructor(){

    fun getLucky(): LuckyModel?{
        return when (Random.nextInt(0, 55)) {
            0 -> LuckyModel(R.drawable.cups1, R.string.cups_ace_title, R.string.cups_ace)
            1 -> LuckyModel(R.drawable.cups2, R.string.cups_two_title, R.string.cups_two)
            2 -> LuckyModel(R.drawable.cups3, R.string.cups_three_title, R.string.cups_three)
            3 -> LuckyModel(R.drawable.cups4, R.string.cups_four_title, R.string.cups_four)
            4 -> LuckyModel(R.drawable.cups5, R.string.cups_five_title, R.string.cups_five)
            5 -> LuckyModel(R.drawable.cups6, R.string.cups_six_title, R.string.cups_six)
            6 -> LuckyModel(R.drawable.cups7, R.string.cups_seven_title, R.string.cups_seven)
            7 -> LuckyModel(R.drawable.cups8, R.string.cups_eight_title, R.string.cups_eight)
            8 -> LuckyModel(R.drawable.cups9, R.string.cups_nine_title, R.string.cups_nine)
            9 -> LuckyModel(R.drawable.cups10, R.string.cups_ten_title, R.string.cups_ten)
            10 -> LuckyModel(R.drawable.cups11, R.string.cups_page_title, R.string.cups_page)
            11 -> LuckyModel(R.drawable.cups12, R.string.cups_knight_title, R.string.cups_knight)
            12 -> LuckyModel(R.drawable.cups13, R.string.cups_queen_title, R.string.cups_queen)
            13 -> LuckyModel(R.drawable.cups14, R.string.cups_king_title, R.string.cups_king)
            14 -> LuckyModel(R.drawable.swords1, R.string.swords_ace_title, R.string.swords_ace)
            15 -> LuckyModel(R.drawable.swords2, R.string.swords_two_title, R.string.swords_two)
            16 -> LuckyModel(R.drawable.swords3, R.string.swords_three_title, R.string.swords_three)
            17 -> LuckyModel(R.drawable.swords4, R.string.swords_four_title, R.string.swords_four)
            18 -> LuckyModel(R.drawable.swords5, R.string.swords_five_title, R.string.swords_five)
            19 -> LuckyModel(R.drawable.swords6, R.string.swords_six_title, R.string.swords_six)
            20 -> LuckyModel(R.drawable.swords7, R.string.swords_seven_title, R.string.swords_seven)
            21 -> LuckyModel(R.drawable.swords8, R.string.swords_eight_title, R.string.swords_eight)
            22 -> LuckyModel(R.drawable.swords9, R.string.swords_nine_title, R.string.swords_nine)
            23 -> LuckyModel(R.drawable.swords10, R.string.swords_ten_title, R.string.swords_ten)
            24 -> LuckyModel(R.drawable.swords11, R.string.swords_page_title, R.string.swords_page)
            25 -> LuckyModel(R.drawable.swords12, R.string.swords_knight_title, R.string.swords_knight)
            26 -> LuckyModel(R.drawable.swords13, R.string.swords_queen_title, R.string.swords_queen)
            27 -> LuckyModel(R.drawable.swords14, R.string.swords_king_title, R.string.swords_king)
            28 -> LuckyModel(R.drawable.coins1, R.string.pentacles_ace_title, R.string.pentacles_ace)
            29 -> LuckyModel(R.drawable.coins2, R.string.pentacles_two_title, R.string.pentacles_two)
            30 -> LuckyModel(R.drawable.coins3, R.string.pentacles_three_title, R.string.pentacles_three)
            31 -> LuckyModel(R.drawable.coins4, R.string.pentacles_four_title, R.string.pentacles_four)
            32 -> LuckyModel(R.drawable.coins5, R.string.pentacles_five_title, R.string.pentacles_five)
            33 -> LuckyModel(R.drawable.coins6, R.string.pentacles_six_title, R.string.pentacles_six)
            34 -> LuckyModel(R.drawable.coins7, R.string.pentacles_seven_title, R.string.pentacles_seven)
            35 -> LuckyModel(R.drawable.coins8, R.string.pentacles_eight_title, R.string.pentacles_eight)
            36 -> LuckyModel(R.drawable.coins9, R.string.pentacles_nine_title, R.string.pentacles_nine)
            37 -> LuckyModel(R.drawable.coins10, R.string.pentacles_ten_title, R.string.pentacles_ten)
            38 -> LuckyModel(R.drawable.coins11, R.string.pentacles_page_title, R.string.pentacles_page)
            39 -> LuckyModel(R.drawable.coins12, R.string.pentacles_knight_title, R.string.pentacles_knight)
            40 -> LuckyModel(R.drawable.coins13, R.string.pentacles_queen_title, R.string.pentacles_queen)
            41 -> LuckyModel(R.drawable.coins14, R.string.pentacles_king_title, R.string.pentacles_king)
            42 -> LuckyModel(R.drawable.wands1, R.string.wands_ace_title, R.string.wands_ace)
            43 -> LuckyModel(R.drawable.wands2, R.string.wands_two_title, R.string.wands_two)
            44 -> LuckyModel(R.drawable.wands3, R.string.wands_three_title, R.string.wands_three)
            45 -> LuckyModel(R.drawable.wands4, R.string.wands_four_title, R.string.wands_four)
            46 -> LuckyModel(R.drawable.wands5, R.string.wands_five_title, R.string.wands_five)
            47 -> LuckyModel(R.drawable.wands6, R.string.wands_six_title, R.string.wands_six)
            48 -> LuckyModel(R.drawable.wands7, R.string.wands_seven_title, R.string.wands_seven)
            49 -> LuckyModel(R.drawable.wands8, R.string.wands_eight_title, R.string.wands_eight)
            50 -> LuckyModel(R.drawable.wands9, R.string.wands_nine_title, R.string.wands_nine)
            51 -> LuckyModel(R.drawable.wands10, R.string.wands_ten_title, R.string.wands_ten)
            52 -> LuckyModel(R.drawable.wands11, R.string.wands_page_title, R.string.wands_page)
            53 -> LuckyModel(R.drawable.wands12, R.string.wands_knight_title, R.string.wands_knight)
            54 -> LuckyModel(R.drawable.wands13, R.string.wands_queen_title, R.string.wands_queen)
            55 -> LuckyModel(R.drawable.wands14, R.string.wands_king_title, R.string.wands_king)
            else -> null
        }
    }
}