/*
 * Copyright (c) 2016 Steve Christensen
 *
 * This file is part of RPG-Pad.
 *
 * RPG-Pad is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RPG-Pad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RPG-Pad.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.stevesea.adventuresmith.data.stars_without_number;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        Culture.Arabic,
        Culture.Chinese,
        Culture.English,
        Culture.Indian,
        Culture.Japanese,
        Culture.Nigerian,
        Culture.Russian,
        Culture.Spanish,
})
public @interface Culture {
    String Arabic = "Arabic";
    String Chinese = "Chinese";
    String English = "English";
    String Indian = "Indian";
    String Japanese = "Japanese";
    String Nigerian = "Nigerian";
    String Russian = "Russian";
    String Spanish = "Spanish";
}
