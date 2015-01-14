/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.dit599.customPD.items.bags;

import com.dit599.customPD.items.Item;
import com.dit599.customPD.items.keys.Key;
import com.dit599.customPD.sprites.ItemSpriteSheet;

public class KeyRing extends Bag {

	{
		name = "Key Ring";
		image = ItemSpriteSheet.KEYRING;
		
		size = 12;
	}
	
	@Override
	public boolean grab( Item item ) {
		return item instanceof Key;
	}
	
	@Override
	public String info() {
		return
			"Your keys will automatically be added to this ring. Keys are separated " +
			"based on the depth they were found on.";
	}
}
