/*
 *     Copyright (c) 2018-2019 Green Button Alliance, Inc.
 *
 *     Portions copyright (c) 2013-2018 EnergyOS.org
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package org.greenbuttonalliance.espi.common.domain;

import org.greenbuttonalliance.espi.common.support.TestUtils;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.greenbuttonalliance.espi.common.test.EspiFactory.newAuthorization;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertTrue;

public class AuthorizationTests {

	@Test
	public void isValid() throws Exception {
		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();

		Authorization authorization = newAuthorization();

		Set<ConstraintViolation<Authorization>> violations = validator
				.validate(authorization);

		assertThat(violations, is(empty()));
	}

	@Test
	public void isInvalid() throws Exception {
		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();

		Authorization authorization = new Authorization();

		Set<ConstraintViolation<Authorization>> violations = validator
				.validate(authorization);

		assertThat(violations, is(not(empty())));
	}

	@Test
	public void extendsIdentifiableObject() {
		assertTrue(Authorization.class.getSuperclass() == IdentifiedObject.class);
	}

	@Test
	public void persistence() {
		TestUtils.assertAnnotationPresent(Authorization.class, Entity.class);
		TestUtils.assertAnnotationPresent(Authorization.class, Table.class);
	}

	@Test
	public void accessToken() {
		TestUtils.assertColumnAnnotation(Authorization.class, "accessToken",
				"access_token");
	}

	@Test
	public void authorizationServer() {
		TestUtils.assertColumnAnnotation(Authorization.class, "authorizationURI",
				"authorization_uri");
	}

	@Test
	public void thirdParty() {
		TestUtils.assertColumnAnnotation(Authorization.class, "thirdParty", "third_party");
	}

	@Test
	public void retailCustomer() {
		TestUtils.assertAnnotationPresent(Authorization.class, "retailCustomer",
				ManyToOne.class);
		TestUtils.assertAnnotationPresent(Authorization.class, "retailCustomer",
				JoinColumn.class);
	}

	@Test
	public void state() {
		TestUtils.assertColumnAnnotation(Authorization.class, "state", "state");
	}

	@Test
	public void applicationInformation() {
		TestUtils.assertAnnotationPresent(Authorization.class, "applicationInformation",
				ManyToOne.class);
		TestUtils.assertAnnotationPresent(Authorization.class, "applicationInformation",
				JoinColumn.class);
	}

	@Test
	public void subscriptionId() {
		Authorization authorization = new Authorization();

		authorization
				.setResourceURI("http://localhost:8080/DataCustodian/espi/1_1/resource/Subscription/16228736-8e29-4807-a2a7-283be5cc253e");

		assertThat(authorization.getSubscriptionId(),
				is("16228736-8e29-4807-a2a7-283be5cc253e"));
	}
}