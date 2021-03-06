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
import org.greenbuttonalliance.espi.common.test.EspiFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

public class ApplicationInformationTests {

	@Test
	public void isValid() throws Exception {
		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();

		ApplicationInformation applicationInformation = EspiFactory
				.newApplicationInformation();

		Set<ConstraintViolation<ApplicationInformation>> violations = validator
				.validate(applicationInformation);

		assertTrue(violations.isEmpty());
	}

	@Test
	public void isInvalid() throws Exception {
		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();

		ApplicationInformation applicationInformation = new ApplicationInformation();

		Set<ConstraintViolation<ApplicationInformation>> violations = validator
				.validate(applicationInformation);

		assertFalse(violations.isEmpty());
	}

	@Test
	public void clientId() {
		TestUtils.assertAnnotationPresent(ApplicationInformation.class, "clientId",
				NotEmpty.class);
		TestUtils.assertSizeValidation(ApplicationInformation.class, "clientId", 2, 64);
	}

	@Test
	public void thirdPartyApplicationName() {
		TestUtils.assertAnnotationPresent(ApplicationInformation.class,
				"thirdPartyApplicationName", NotEmpty.class);
		TestUtils.assertSizeValidation(ApplicationInformation.class,
				"thirdPartyApplicationName", 2, 64);
	}

	@Test
	public void getClientId() {
		ApplicationInformation applicationInformation = EspiFactory
				.newApplicationInformation();
		assertThat(applicationInformation.getClientId(),
				containsString("ClientId"));
	}

	// @Test
	// public void getResourceIds() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getResourceIds(), is(nullValue()));
	// }

	// @Test
	// public void isSecretRequired() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.isSecretRequired(), is(true));
	// }

	@Test
	public void getClientSecret() {
		ApplicationInformation applicationInformation = EspiFactory
				.newApplicationInformation();
		assertThat(applicationInformation.getClientSecret(),
				containsString("Secret"));
	}

	// @Test
	// public void isScoped() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.isScoped(), is(true));
	// }

	@Test
	public void getScope() {
		ApplicationInformation applicationInformation = EspiFactory
				.newApplicationInformation();
		assertThat(
				applicationInformation.getScope(),
				hasItem("FB=4_5_15;IntervalDuration=3600;BlockDuration=monthly;HistoryLength=13"));
		assertThat(
				applicationInformation.getScope(),
				hasItem("FB=4_5_16;IntervalDuration=3600;BlockDuration=monthly;HistoryLength=13"));
	}

	// @Test
	// public void getAuthorizedGrantTypes() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getAuthorizedGrantTypes(),
	// hasItem("authorization_code"));
	// }

	// ToDo: Verify this test
	// @Test
	// public void getRegisteredRedirectUri() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getRegisteredRedirectUri(),
	// hasItem(applicationInformation.getRedirectUri()));
	// }

	// @Test
	// public void getAuthorities() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getAuthorities(), hasItem(new
	// SimpleGrantedAuthority("ROLE_CLIENT")));
	// }

	// @Test
	// public void getAccessTokenValiditySeconds() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getAccessTokenValiditySeconds(),
	// equalTo(Integer.valueOf(60*60*24*60)));
	// }

	// @Test
	// public void getRefreshTokenValiditySeconds() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getRefreshTokenValiditySeconds(),
	// equalTo(Integer.valueOf(60*60*24)));
	// }

	// @Test
	// public void getAdditionalInformation() {
	// ApplicationInformation applicationInformation =
	// EspiFactory.newApplicationInformation();
	// assertThat(applicationInformation.getAdditionalInformation(),
	// is(nullValue()));
	// }
}
