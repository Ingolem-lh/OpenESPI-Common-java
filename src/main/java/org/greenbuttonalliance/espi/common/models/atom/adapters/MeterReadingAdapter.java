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

package org.greenbuttonalliance.espi.common.models.atom.adapters;

import org.greenbuttonalliance.espi.common.domain.MeterReading;
import org.greenbuttonalliance.espi.common.domain.ObjectFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MeterReadingAdapter extends
		XmlAdapter<JAXBElement<MeterReading>, MeterReading> {
	@Override
	public MeterReading unmarshal(JAXBElement<MeterReading> v) throws Exception {
		return v.getValue();
	}

	@Override
	public JAXBElement<MeterReading> marshal(MeterReading v) throws Exception {
		if (v == null) {
			return null;
		}
		return new JAXBElement<>(ObjectFactory.MeterReading_QNAME,
				MeterReading.class, v);
	}
}