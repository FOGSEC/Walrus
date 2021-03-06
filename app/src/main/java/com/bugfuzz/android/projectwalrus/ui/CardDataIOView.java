/*
 * Copyright 2018 Daniel Underhay & Matthew Daley.
 *
 * This file is part of Walrus.
 *
 * Walrus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Walrus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Walrus.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.bugfuzz.android.projectwalrus.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bugfuzz.android.projectwalrus.R;
import com.bugfuzz.android.projectwalrus.data.CardData;
import com.bugfuzz.android.projectwalrus.device.CardDevice;

public class CardDataIOView extends FrameLayout {

    public CardDataIOView(Context context) {
        super(context);

        init(null, 0);
    }

    public CardDataIOView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs, 0);
    }

    public CardDataIOView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View view = inflate(getContext(), R.layout.view_card_data_io, null);
        addView(view);
    }

    public void setCardDeviceClass(Class<? extends CardDevice> cardDeviceClass) {
        ((ImageView) findViewById(R.id.device)).setImageDrawable(
                ContextCompat.getDrawable(getContext(),
                        cardDeviceClass.getAnnotation(CardDevice.Metadata.class).icon()));
    }

    public void setDirection(boolean reading) {
        ImageView directionImage = findViewById(R.id.direction);
        directionImage.setImageDrawable(
                ContextCompat.getDrawable(getContext(), R.drawable.drawable_card_data_io_direction));
        directionImage.setRotation(90 + (reading ? 180 : 0));
    }

    public void setCardDataClass(Class<? extends CardData> cardDataClass) {
        ((ImageView) findViewById(R.id.type)).setImageDrawable(
                ContextCompat.getDrawable(getContext(),
                        cardDataClass.getAnnotation(CardData.Metadata.class).icon()));
    }

    public void setStatus(String status) {
        ((TextView) findViewById(R.id.status)).setText(status);
    }
}
