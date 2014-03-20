/*
 * Copyright (C) 2007-2014 Crafter Software Corporation.
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.commons.mail;

import org.craftercms.commons.i10n.I10nException;

/**
 * Thrown when an email can't be sent for some reason.
 *
 * @author avasquez
 */
public class EmailException extends I10nException {

    public static final String BUNDLE_NAME = "crafter.commons.messages.errors";

    public EmailException(String key, Object... args) {
        super(key, BUNDLE_NAME, args);
    }

    public EmailException(String key, Throwable cause, Object... args) {
        super(key, BUNDLE_NAME, cause, args);
    }

}
