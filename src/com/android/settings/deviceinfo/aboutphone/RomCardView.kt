package com.android.settings.deviceinfo.aboutphone

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import android.os.SystemProperties
import android.provider.Settings
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.android.settings.Utils

import com.android.settings.R;
class RomCardView(context: Context, attrs: AttributeSet?) : AboutBaseCard(context, attrs) {

    init {
        layout.id = R.id.rom_card_id
        layout.gravity = Gravity.CENTER_HORIZONTAL
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        val rom_logo = ImageView(context)
        rom_logo.setPadding(72, 72, 72, 72)
        rom_logo.adjustViewBounds = true
        /*
        rom_logo.imageTintList = ColorStateList.valueOf(
            Utils.getColorAttrDefaultColor(
                context,
                android.R.attr.colorAccent
            )
        )
        */
        linearLayout.id = R.id.rom_logo_id
        rom_logo.setImageResource(R.drawable.empty_logo)
        val rlparams = RelativeLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        rlparams.addRule(RelativeLayout.ABOVE, R.id.rom_logo_id)
        rom_logo.layoutParams = rlparams
        minimumWidth = rom_logo.width
        val rom_title = TextView(context)
        rom_title.text =
            String.format(resources.getString(R.string.about_device_rom_title))
        rom_title.setTextColor(
            Utils.getColorAttrDefaultColor(
                context,
                android.R.attr.textColorPrimary
            )
        )
        rom_title.setPadding(0, 12, 0, 12)
        rom_title.textSize = 18f
        rom_title.textAlignment = TEXT_ALIGNMENT_CENTER
        rom_title.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearLayout.addView(rom_title)
        linearLayout.setBackgroundColor(resources.getColor(R.color.contextual_card_background, null))
        layout.addView(rom_logo, rlparams)
            context.startActivity(Intent(Settings.ACTION_SYSTEM_UPDATE_SETTINGS))
        }
    }
