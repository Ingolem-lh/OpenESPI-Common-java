#!/usr/bin/env bash
echo 'curl  --header "Content-Type:application/xml" -X POST -d @test_usage_data.xml http://localhost:8080/DataCustodian/espi/1_1/resource/Batch/RetailCustomer/1/UsagePoint'
time curl  --header "Content-Type:application/xml" -X POST -d @test_usage_data.xml http://localhost:8080/DataCustodian/espi/1_1/resource/Batch/RetailCustomer/1/UsagePoint