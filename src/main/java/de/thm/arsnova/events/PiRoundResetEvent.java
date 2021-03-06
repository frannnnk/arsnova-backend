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
package de.thm.arsnova.events;

import de.thm.arsnova.entities.Content;
import de.thm.arsnova.entities.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * Fires whenever a peer instruction round is reset.
 */
public class PiRoundResetEvent extends SessionEvent {

	private static final long serialVersionUID = 1L;

	private final String questionId;
	private final String questionVariant;

	public PiRoundResetEvent(Object source, Session session, Content content) {
		super(source, session);
		questionId = content.getId();
		questionVariant = content.getQuestionVariant();
	}

	@Override
	public void accept(ArsnovaEventVisitor visitor) {
		visitor.visit(this);
	}

	public String getQuestionId() {
		return questionId;
	}

	public String getQuestionVariant() {
		return questionVariant;
	}

	public Map<String, String> getPiRoundResetInformations() {
		Map<String, String> map = new HashMap<>();

		map.put("_id", getQuestionId());
		map.put("variant", getQuestionVariant());

		return map;
	}

}
