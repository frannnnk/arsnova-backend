/*
 * This file is part of ARSnova Backend.
 * Copyright (C) 2012-2018 The ARSnova Team and Contributors
 *
 * ARSnova Backend is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ARSnova Backend is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.thm.arsnova.services;

import de.thm.arsnova.entities.FindQuery;
import de.thm.arsnova.entities.Content;
import de.thm.arsnova.entities.Room;
import de.thm.arsnova.entities.UserProfile;
import de.thm.arsnova.entities.Room.ContentGroup;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContentFindQueryService implements FindQueryService<Content> {
	private RoomService roomService;
	private ContentService contentService;

	public ContentFindQueryService(final RoomService roomService, final ContentService contentService) {
		this.roomService = roomService;
		this.contentService = contentService;
	}

	@Override
	public Set<String> resolveQuery(final FindQuery<Content> findQuery) {
		Set<String> contentIds = new HashSet<>();
		if (findQuery.getProperties().getRoomId() != null) {
			List<Content> contentList = contentService.getByRoomId(findQuery.getProperties().getRoomId());
			for (Content c : contentList) {
				contentIds.add(c.getId());
			}
		}

		return contentIds;
	}
}
