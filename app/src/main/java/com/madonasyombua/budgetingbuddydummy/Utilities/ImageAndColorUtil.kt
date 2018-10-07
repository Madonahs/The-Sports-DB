package com.madonasyombua.budgetingbuddydummy.Utilities

import com.madonasyombua.budgetingbuddydummy.R

object ImageAndColorUtil {

    fun getImageContentId(expenseName: String): Int {
        return if (expenseName.equals("Car", ignoreCase = true)) {
            R.drawable.ic_sports_car
        } else if (expenseName.equals("Travel", ignoreCase = true)) {
            R.drawable.ic_aeroplane
        } else if (expenseName.equals("Food", ignoreCase = true)) {
            R.drawable.ic_cutlery
        } else if (expenseName.equals("Family", ignoreCase = true)) {
            R.drawable.ic_user
        } else if (expenseName.equals("Bills", ignoreCase = true)) {
            R.drawable.ic_payment_method
        } else if (expenseName.equals("Entertainment", ignoreCase = true)) {
            R.drawable.ic_video_camera
        } else if (expenseName.equals("Home", ignoreCase = true)) {
            R.drawable.ic_house
        } else if (expenseName.equals("Utilities", ignoreCase = true)) {
            R.drawable.ic_light_bulb
        } else if (expenseName.equals("Shopping", ignoreCase = true)) {
            R.drawable.ic_shopping_cart
        } else if (expenseName.equals("Hotel", ignoreCase = true)) {
            R.drawable.ic_rural_hotel_of_three_stars
        } else if (expenseName.equals("Health Care", ignoreCase = true)) {
            R.drawable.ic_first_aid_kit
        } else if (expenseName.equals("Other", ignoreCase = true)) {
            R.drawable.ic_add_black_24dp
        } else if (expenseName.equals("Clothing", ignoreCase = true)) {
            R.drawable.ic_shirt
        } else if (expenseName.equals("Transport", ignoreCase = true)) {
            R.drawable.ic_van
        } else if (expenseName.equals("Groceries", ignoreCase = true)) {
            R.drawable.ic_groceries
        } else if (expenseName.equals("Drinks", ignoreCase = true)) {
            R.drawable.ic_cocktail_glass
        } else if (expenseName.equals("Hobbies", ignoreCase = true)) {
            R.drawable.ic_soccer_ball_variant
        } else if (expenseName.equals("Pets", ignoreCase = true)) {
            R.drawable.ic_animal_prints
        } else if (expenseName.equals("Education", ignoreCase = true)) {
            R.drawable.ic_atomic
        } else if (expenseName.equals("Cinema", ignoreCase = true)) {
            R.drawable.ic_film
        } else if (expenseName.equals("Love", ignoreCase = true)) {
            R.drawable.ic_like
        } else if (expenseName.equals("Kids", ignoreCase = true)) {
            R.drawable.ic_windmill
        } else if (expenseName.equals("Rent", ignoreCase = true)) {
            R.drawable.ic_rent
        } else if (expenseName.equals("iTunes", ignoreCase = true)) {
            R.drawable.ic_itunes_logo_of_amusical_note_inside_a_circle
        } else if (expenseName.equals("Savings", ignoreCase = true)) {
            R.drawable.ic_piggy_bank
        } else if (expenseName.equals("Gifts", ignoreCase = true)) {
            R.drawable.ic_gift
        } else if (expenseName.equals("Salary", ignoreCase = true)) {
            R.drawable.ic_incomes
        } else if (expenseName.trim { it <= ' ' }.equals("Business", ignoreCase = true)) {
            R.drawable.ic_briefcase
        } else if (expenseName.equals("Loan", ignoreCase = true)) {
            R.drawable.ic_contract
        } else if (expenseName.equals("Extra Income", ignoreCase = true)) {
            R.drawable.ic_salary
        } else
            0

    }

    fun getWhiteImageContentId(expenseName: String): Int {
        return if (expenseName.equals("Car", ignoreCase = true)) {
            R.drawable.ic_sports_car_w
        } else if (expenseName.equals("Travel", ignoreCase = true)) {
            R.drawable.ic_aeroplane_w
        } else if (expenseName.equals("Food", ignoreCase = true)) {
            R.drawable.ic_cutlery_w
        } else if (expenseName.equals("Family", ignoreCase = true)) {
            R.drawable.ic_user_w
        } else if (expenseName.equals("Bills", ignoreCase = true)) {
            R.drawable.ic_payment_method_w
        } else if (expenseName.equals("Entertainment", ignoreCase = true)) {
            R.drawable.ic_video_camera_w
        } else if (expenseName.equals("Home", ignoreCase = true)) {
            R.drawable.ic_house_w
        } else if (expenseName.equals("Utilities", ignoreCase = true)) {
            R.drawable.ic_light_bulb_w
        } else if (expenseName.equals("Shopping", ignoreCase = true)) {
            R.drawable.ic_shopping_cart_w
        } else if (expenseName.equals("Hotel", ignoreCase = true)) {
            R.drawable.ic_rural_hotel_of_three_stars_w
        } else if (expenseName.equals("Health Care", ignoreCase = true)) {
            R.drawable.ic_first_aid_kit_w
        } else if (expenseName.equals("Other", ignoreCase = true)) {
            R.drawable.ic_paper_plane_w
        } else if (expenseName.equals("Clothing", ignoreCase = true)) {
            R.drawable.ic_shirt_w
        } else if (expenseName.equals("Transport", ignoreCase = true)) {
            R.drawable.ic_van_w
        } else if (expenseName.equals("Groceries", ignoreCase = true)) {
            R.drawable.ic_groceries_w
        } else if (expenseName.equals("Drinks", ignoreCase = true)) {
            R.drawable.ic_cocktail_glass_w
        } else if (expenseName.equals("Hobbies", ignoreCase = true)) {
            R.drawable.ic_soccer_ball_variant_w
        } else if (expenseName.equals("Pets", ignoreCase = true)) {
            R.drawable.ic_animal_prints_w
        } else if (expenseName.equals("Education", ignoreCase = true)) {
            R.drawable.ic_atomic_w
        } else if (expenseName.equals("Cinema", ignoreCase = true)) {
            R.drawable.ic_film_w
        } else if (expenseName.equals("Love", ignoreCase = true)) {
            R.drawable.ic_like_w
        } else if (expenseName.equals("Kids", ignoreCase = true)) {
            R.drawable.ic_windmill_w
        } else if (expenseName.equals("Rent", ignoreCase = true)) {
            R.drawable.ic_rent_w
        } else if (expenseName.equals("iTunes", ignoreCase = true)) {
            R.drawable.ic_itunes_logo_of_amusical_note_inside_a_circle_w
        } else if (expenseName.equals("Savings", ignoreCase = true)) {
            R.drawable.ic_piggy_bank_w
        } else if (expenseName.equals("Gifts", ignoreCase = true)) {
            R.drawable.ic_gift_w
        } else if (expenseName.equals("Salary", ignoreCase = true)) {
            R.drawable.ic_incomes_w
        } else if (expenseName.trim { it <= ' ' }.equals("Business", ignoreCase = true)) {
            R.drawable.ic_briefcase_w
        } else if (expenseName.equals("Loan", ignoreCase = true)) {
            R.drawable.ic_contract_w
        } else if (expenseName.equals("Extra Income", ignoreCase = true)) {
            R.drawable.ic_salary_w
        } else {
            0
        }
    }

    fun getColorContentId(expenseName: String): Int {
        return if (expenseName.equals("Car", ignoreCase = true)) {
            R.color.RebeccaPurple
        } else if (expenseName.equals("Travel", ignoreCase = true)) {
            R.color.PaleVioletRed
        } else if (expenseName.equals("Food", ignoreCase = true)) {
            R.color.Brown
        } else if (expenseName.equals("Family", ignoreCase = true)) {
            R.color.DarkRed
        } else if (expenseName.equals("Bills", ignoreCase = true)) {
            R.color.DarkGreen
        } else if (expenseName.equals("Entertainment", ignoreCase = true)) {
            R.color.orange_500
        } else if (expenseName.equals("Home", ignoreCase = true)) {
            R.color.Tomato
        } else if (expenseName.equals("Utilities", ignoreCase = true)) {
            R.color.DarkGray
        } else if (expenseName.equals("Shopping", ignoreCase = true)) {
            R.color.LightGreen
        } else if (expenseName.equals("Hotel", ignoreCase = true)) {
            R.color.LightBlue
        } else if (expenseName.equals("Health Care", ignoreCase = true)) {
            R.color.IndianRed
        } else if (expenseName.equals("Other", ignoreCase = true)) {
            R.color.MediumPurple
        } else if (expenseName.equals("Clothing", ignoreCase = true)) {
            R.color.YellowGreen
        } else if (expenseName.equals("Transport", ignoreCase = true)) {
            R.color.Lime
        } else if (expenseName.equals("Groceries", ignoreCase = true)) {
            R.color.SandyBrown
        } else if (expenseName.equals("Drinks", ignoreCase = true)) {
            R.color.RosyBrown
        } else if (expenseName.equals("Hobbies", ignoreCase = true)) {
            R.color.PaleTurquoise
        } else if (expenseName.equals("Pets", ignoreCase = true)) {
            R.color.Peru
        } else if (expenseName.equals("Education", ignoreCase = true)) {
            R.color.RoyalBlue
        } else if (expenseName.equals("Cinema", ignoreCase = true)) {
            R.color.PowderBlue
        } else if (expenseName.equals("Love", ignoreCase = true)) {
            R.color.DeepPink
        } else if (expenseName.equals("Kids", ignoreCase = true)) {
            R.color.Chocolate
        } else if (expenseName.equals("Rent", ignoreCase = true)) {
            R.color.LightSlateGray
        } else if (expenseName.equals("iTunes", ignoreCase = true)) {
            R.color.MediumSeaGreen
        } else if (expenseName.equals("Savings", ignoreCase = true)) {
            R.color.Marroon
        } else if (expenseName.equals("Gifts", ignoreCase = true)) {
            R.color.OrangeRed
        } else if (expenseName.equals("Salary", ignoreCase = true)) {
            R.color.Indigo
        } else if (expenseName.trim { it <= ' ' }.equals("Business", ignoreCase = true)) {
            R.color.Gold
        } else if (expenseName.equals("Loan", ignoreCase = true)) {
            R.color.Kakhi
        } else if (expenseName.equals("Extra Income", ignoreCase = true)) {
            R.color.DarkSlateBlue
        } else {
            0
        }
    }
}
