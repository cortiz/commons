/*
 * Copyright (C) 2007-2017 Crafter Software Corporation.
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
package org.craftercms.commons.validation;

/**
 * Runtime exception thrown when validation fails.
 *
 * @author avasquez
 */
public class ValidationRuntimeException extends RuntimeException {

    protected ValidationResult result;

    public ValidationRuntimeException(String message) {
        super(message);
    }

    public ValidationRuntimeException(ValidationResult result) {
        super(result.getMessage());

        this.result = result;
    }

    public ValidationResult getResult() {
        return result;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "; validation errors: " + result.getErrors();
    }

}
