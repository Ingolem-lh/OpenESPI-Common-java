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

package org.greenbuttonalliance.espi.common.service;

import org.greenbuttonalliance.espi.common.domain.ElectricPowerUsageSummary;
import org.greenbuttonalliance.espi.common.domain.UsagePoint;
import org.greenbuttonalliance.espi.common.models.atom.EntryType;
import org.greenbuttonalliance.espi.common.utils.EntryTypeIterator;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public interface ElectricPowerUsageSummaryService {

	ElectricPowerUsageSummary findByUUID(UUID uuid);

	List<ElectricPowerUsageSummary> findAllByUsagePoint(UsagePoint usagePoint);

	String feedFor(List<ElectricPowerUsageSummary> electricPowerUsageSummarys);

	String entryFor(ElectricPowerUsageSummary electricPowerUsageSummary);

	void associateByUUID(UsagePoint usagePoint, UUID uuid);

	void persist(ElectricPowerUsageSummary electricPowerUsageSummary);

	ElectricPowerUsageSummary findById(Long electricPowerUsageSummaryId);

	EntryType findEntryType(Long retailCustomerId, Long usagePointId,
							Long electricPowerUsageSummaryId);

	EntryTypeIterator findEntryTypeIterator(Long retailCustomerId,
											Long usagePointId);

	void add(ElectricPowerUsageSummary electricPowerUsageSummary);

	void delete(ElectricPowerUsageSummary electricPowerUsageSummary);

	ElectricPowerUsageSummary importResource(InputStream stream);
}
